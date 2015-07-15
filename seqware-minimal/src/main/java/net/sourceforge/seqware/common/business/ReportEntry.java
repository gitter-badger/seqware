/*
 * Copyright (C) 2015 SeqWare
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
package net.sourceforge.seqware.common.business;

import com.google.common.collect.Sets;
import java.util.Set;

/**
 *
 * @author dyuen
 */
public class ReportEntry {
    private String filename;
    private String fileSwa;
    private String rootProcessingName;
    private String rootProcessingSwa;
    private Set<String> sequencerRunSwas = Sets.newHashSet();
    private Set<String> laneSwas = Sets.newHashSet();
    private Set<String> iusSwas = Sets.newHashSet();
    private Set<String> sampleSwas = Sets.newHashSet();
    private Set<String> experimentSwas = Sets.newHashSet();
    private Set<String> studySwas = Sets.newHashSet();

    public ReportEntry() {
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFileSwa() {
        return fileSwa;
    }

    public void setFileSwa(String fileSwa) {
        this.fileSwa = fileSwa;
    }

    public String getRootProcessingName() {
        return rootProcessingName;
    }

    public void setRootProcessingName(String rootProcessingName) {
        this.rootProcessingName = rootProcessingName;
    }

    public String getRootProcessingSwa() {
        return rootProcessingSwa;
    }

    public void setRootProcessingSwa(String rootProcessingSwa) {
        this.rootProcessingSwa = rootProcessingSwa;
    }

    public Set<String> getSequencerRunSwas() {
        return sequencerRunSwas;
    }

    public void setSequencerRunSwas(Set<String> sequencerRunSwas) {
        this.sequencerRunSwas = sequencerRunSwas;
    }

    public Set<String> getLaneSwas() {
        return laneSwas;
    }

    public void setLaneSwas(Set<String> laneSwas) {
        this.laneSwas = laneSwas;
    }

    public Set<String> getIusSwas() {
        return iusSwas;
    }

    public void setIusSwas(Set<String> iusSwas) {
        this.iusSwas = iusSwas;
    }

    public Set<String> getSampleSwas() {
        return sampleSwas;
    }

    public void setSampleSwas(Set<String> sampleSwas) {
        this.sampleSwas = sampleSwas;
    }

    public Set<String> getExperimentSwas() {
        return experimentSwas;
    }

    public void setExperimentSwas(Set<String> experimentSwas) {
        this.experimentSwas = experimentSwas;
    }

    public Set<String> getStudySwas() {
        return studySwas;
    }

    public void setStudySwas(Set<String> studySwas) {
        this.studySwas = studySwas;
    }

}
