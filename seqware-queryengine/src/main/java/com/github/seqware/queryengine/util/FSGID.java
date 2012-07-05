/*
 * Copyright (C) 2012 SeqWare
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.github.seqware.queryengine.util;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.KryoSerializable;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.github.seqware.queryengine.impl.HBaseStorage;
import com.github.seqware.queryengine.model.Feature;
import com.github.seqware.queryengine.model.FeatureSet;
import java.util.Date;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Special class for Features which also stores the row key for features
 *
 * @author dyuen
 * @author boconnor
 */
public class FSGID extends SGID implements KryoSerializable {

    private String rowKey = null;
    //private SGID featureSetID = null;

    @Override
    public String toString() {
        return rowKey + "." + super.toString() /** + "." + featureSetID.toString() */;
    }
    
    public FSGID(long mostSig, long leastSig, String rowKey) {
        super(mostSig, leastSig);
        this.rowKey = rowKey;
    }


    /**
     * Create a fully functional FSGID
     * @param sgid
     * @param f
     * @param fSet 
     */
    public FSGID(SGID sgid, Feature f, FeatureSet fSet) {
        super(sgid.getUuid().getMostSignificantBits(), sgid.getUuid().getLeastSignificantBits());
        try {
     //       this.featureSetID = fSet.getSGID();
            // generate row key
            StringBuilder builder = new StringBuilder();
            builder.append(fSet.getReference().getName()).append(".").append(f.getId()).append(":").append(padZeros(f.getStart(), HBaseStorage.PAD)).append(".feature.").append(f.getVersion());
            rowKey = builder.toString();
        } catch (Exception ex) {
            Logger.getLogger(FSGID.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Could not upgrade SGID on Feature " + f.getSGID() + " due to location out of bounds");
        }
    }

    private String padZeros(long input, int totalPlaces) throws Exception {
        String strInput = new Long(input).toString();
        if (strInput.length() > totalPlaces) {
            throw new Exception("Integer " + input + " is larger than total places of " + totalPlaces + " so padding this string failed.");
        }
        int diff = totalPlaces - strInput.length();
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < diff; i++) {
            buffer.append("0");
        }
        buffer.append(strInput);
        return (buffer.toString());
    }

//    /**
//     * Get the ID for the associated feature set
//     *
//     * @return
//     */
//    public SGID getFeatureSetID() {
//        return featureSetID;
//    }

    /**
     * Get the HBase-style row-key for this Feature
     *
     * @return
     */
    public String getRowKey() {
        return rowKey;
    }

    @Override
    public void write(Kryo kryo, Output output) {
        // doesn't seem to inherit properly?
        output.writeLong(super.getUuid().getLeastSignificantBits());
        output.writeLong(super.getUuid().getMostSignificantBits());
        output.writeBoolean(super.getBackendTimestamp() != null);
        if (super.getBackendTimestamp() != null){
            output.writeLong(super.getBackendTimestamp().getTime());
        }
        output.writeString(rowKey);
    }

    @Override
    public void read(Kryo kryo, Input input) {
        long leastSig = input.readLong();
        long mostSig = input.readLong();
        this.setUuid(new UUID(mostSig, leastSig));
        boolean hasTimestamp = input.readBoolean();
        if (hasTimestamp){
            super.setBackendTimestamp(new Date(input.readLong()));
        }
        this.rowKey = input.readString();
    }  
}