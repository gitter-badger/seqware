//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-833 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2009.09.14 at 03:13:03 PM PDT 
//


package net.sourceforge.seqware.queryengine.webservice.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence maxOccurs="unbounded">
 *         &lt;element name="SUBMISSION" type="{}SubmissionType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 * @author morgantaschuk
 * @version $Id: $Id
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "submission"
})
@XmlRootElement(name = "SUBMISSION_SET")
public class SubmissionSet {

    @XmlElement(name = "SUBMISSION", required = true)
    protected List<SubmissionType> submission;

    /**
     * Gets the value of the submission property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the submission property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSUBMISSION().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link net.sourceforge.seqware.queryengine.webservice.model.SubmissionType}
     *
     * @return a {@link java.util.List} object.
     */
    public List<SubmissionType> getSUBMISSION() {
        if (submission == null) {
            submission = new ArrayList<SubmissionType>();
        }
        return this.submission;
    }

}
