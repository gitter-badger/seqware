package com.github.seqware.model;

import com.github.seqware.factory.ModelManager;
import com.github.seqware.model.impl.AtomImpl;
import com.github.seqware.model.interfaces.AbstractSet;
import com.github.seqware.model.interfaces.BaseBuilder;

/**
 * A ReferenceSet is a collection of references which are a collection of
 * contigs and coordinates. Consider an example to be "Homo Sapiens".
 *
 * @author dyuen
 * @author jbaran
 */
public interface ReferenceSet extends AbstractSet<ReferenceSet, Reference> {

    /**
     * Get the name of the reference set
     *
     * @return the name of the reference set
     */
    public String getName();
    
    /**
     * Get the organism associated with this reference set
     * @return the organism associated with this reference set
     */
    public String getOrganism();

    /**
     * Create a ReferenceSet builder started with a copy of this
     * @return 
     */
    @Override
    public abstract ReferenceSet.Builder toBuilder();

    public abstract static class Builder implements BaseBuilder {

        public ReferenceSet aSet;
        
        @Override
        public ReferenceSet build() {
           return build(true);
        }

        public abstract ReferenceSet build(boolean newObject);

        @Override
        public ReferenceSet.Builder setManager(ModelManager aThis) {
            ((AtomImpl)aSet).setManager(aThis);
            return this;
        }

        public abstract ReferenceSet.Builder setName(String name);
        
        public abstract ReferenceSet.Builder setOrganism(String organism);
    }


}