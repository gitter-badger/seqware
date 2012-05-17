package com.github.seqware.model;

import java.util.UUID;

/**
 * Features should be able to represent a GVF (which is a more generic version of a VCF)
 * See http://genomebiology.com/2010/11/8/R88
 * 
 * We will want to tag features and version features, however we probably do not want 
 * ACL features on a Feature level since there will be many many features
 * @author dyuen
 */
public abstract class Feature implements Taggable, Versionable{

    /**
     * Strand locations of features.
     *
     * Positive/negative strand are relative to the landmark.
     */
    public enum Strand { POSITIVE, NEGATIVE, NOT_STRANDED, UNKNOWN }

    /**
     * Internally used unique identifier of this feature.
     */
    private UUID uuid;

    /**
     * User provided ID for the feature (optional).
     */
    private String id;

    /**
     * Reference system used for coordinates, for example, versioned name of genome assembly used.
     */
    private String reference;

    /**
     * Start coordinate.
     */
	private long start;

    /**
     * Stop coordinate.
     */
	private long stop;

    /**
     * Strand of the feature.
     */
    private Strand strand;

    private Feature() {
        // TODO This will have to be replaced with a stronger UUID generation method.
        this.uuid = UUID.randomUUID();
    }

    /**
     * Create a new location based non-stranded feature.
     *
     * @param reference Reference system used for coordinates, for example, versioned name of genome assembly used.
     * @param start Start coordinate.
     * @param stop Stop coordinate.
     */
    public Feature(String reference, long start, long stop) {
        this();
    }

    /**
     * Create a new location based feature.
     *
     * @param reference Reference system used for coordinates, for example, versioned name of genome assembly used.
     * @param start Start coordinate.
     * @param stop Stop coordinate.
     * @param strand Strand of the feature.
     */
    public Feature(String reference, long start, long stop, Strand strand) {
        this(reference, start, stop);

        if (strand != null)
            this.strand = strand;
        else
            this.strand = Strand.NOT_STRANDED;
    }

    /**
     * Get the universally unique identifier of this feature.
     */
    public UUID getUUID() {
        return this.uuid;
    }
}

