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
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 *
 *         A Sample defines an isolate of sequenceable material upon which
 *         sequencing experiments can be based.  The Sample object may be a surrogate for taxonomy
 *         accession or an anonymized individual identifier.  Or, it may fully specify
 *         provenance and isolation method of the starting material.
 *
 *
 * <p>Java class for SampleType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="SampleType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SAMPLE_NAME">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;all>
 *                   &lt;element name="TAXON_ID" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *                   &lt;element name="COMMON_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="ANONYMIZED_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                 &lt;/all>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="DESCRIPTION" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MEMBERS" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence maxOccurs="unbounded">
 *                   &lt;element name="MEMBER">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;attribute name="sample_ref" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="sample_id" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="barcode_seqence" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="SAMPLE_LINKS" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence maxOccurs="unbounded">
 *                   &lt;element name="SAMPLE_LINK">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;choice>
 *                             &lt;element name="URL_LINK">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;all>
 *                                       &lt;element name="LABEL" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="URL" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
 *                                     &lt;/all>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="ENTREZ_LINK">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;all>
 *                                       &lt;element name="DB" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="ID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                     &lt;/all>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/choice>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="SAMPLE_ATTRIBUTES" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence maxOccurs="unbounded">
 *                   &lt;element name="SAMPLE_ATTRIBUTE">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;all>
 *                             &lt;element name="TAG" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="VALUE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="UNITS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                           &lt;/all>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="alias" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="accession" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 * @author morgantaschuk
 * @version $Id: $Id
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SampleType", propOrder = {
    "samplename",
    "description",
    "members",
    "samplelinks",
    "sampleattributes"
})
public class SampleType {

    @XmlElement(name = "SAMPLE_NAME", required = true)
    protected SampleType.SAMPLENAME samplename;
    @XmlElement(name = "DESCRIPTION")
    protected String description;
    @XmlElement(name = "MEMBERS")
    protected SampleType.MEMBERS members;
    @XmlElement(name = "SAMPLE_LINKS")
    protected SampleType.SAMPLELINKS samplelinks;
    @XmlElement(name = "SAMPLE_ATTRIBUTES")
    protected SampleType.SAMPLEATTRIBUTES sampleattributes;
    @XmlAttribute
    protected String alias;
    @XmlAttribute
    protected String accession;

    /**
     * Gets the value of the samplename property.
     *
     * @return a {@link net.sourceforge.seqware.queryengine.webservice.model.SampleType.SAMPLENAME} object.
     */
    public SampleType.SAMPLENAME getSAMPLENAME() {
        return samplename;
    }

    /**
     * Sets the value of the samplename property.
     *
     * @param value
     *     allowed object is
     *     {@link net.sourceforge.seqware.queryengine.webservice.model.SampleType.SAMPLENAME}
     */
    public void setSAMPLENAME(SampleType.SAMPLENAME value) {
        this.samplename = value;
    }

    /**
     * Gets the value of the description property.
     *
     * @return a {@link java.lang.String} object.
     */
    public String getDESCRIPTION() {
        return description;
    }

    /**
     * Sets the value of the description property.
     *
     * @param value
     *     allowed object is
     *     {@link java.lang.String}
     */
    public void setDESCRIPTION(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the members property.
     *
     * @return a {@link net.sourceforge.seqware.queryengine.webservice.model.SampleType.MEMBERS} object.
     */
    public SampleType.MEMBERS getMEMBERS() {
        return members;
    }

    /**
     * Sets the value of the members property.
     *
     * @param value
     *     allowed object is
     *     {@link net.sourceforge.seqware.queryengine.webservice.model.SampleType.MEMBERS}
     */
    public void setMEMBERS(SampleType.MEMBERS value) {
        this.members = value;
    }

    /**
     * Gets the value of the samplelinks property.
     *
     * @return a {@link net.sourceforge.seqware.queryengine.webservice.model.SampleType.SAMPLELINKS} object.
     */
    public SampleType.SAMPLELINKS getSAMPLELINKS() {
        return samplelinks;
    }

    /**
     * Sets the value of the samplelinks property.
     *
     * @param value
     *     allowed object is
     *     {@link net.sourceforge.seqware.queryengine.webservice.model.SampleType.SAMPLELINKS}
     */
    public void setSAMPLELINKS(SampleType.SAMPLELINKS value) {
        this.samplelinks = value;
    }

    /**
     * Gets the value of the sampleattributes property.
     *
     * @return a {@link net.sourceforge.seqware.queryengine.webservice.model.SampleType.SAMPLEATTRIBUTES} object.
     */
    public SampleType.SAMPLEATTRIBUTES getSAMPLEATTRIBUTES() {
        return sampleattributes;
    }

    /**
     * Sets the value of the sampleattributes property.
     *
     * @param value
     *     allowed object is
     *     {@link net.sourceforge.seqware.queryengine.webservice.model.SampleType.SAMPLEATTRIBUTES}
     */
    public void setSAMPLEATTRIBUTES(SampleType.SAMPLEATTRIBUTES value) {
        this.sampleattributes = value;
    }

    /**
     * Gets the value of the alias property.
     *
     * @return a {@link java.lang.String} object.
     */
    public String getAlias() {
        return alias;
    }

    /**
     * Sets the value of the alias property.
     *
     * @param value
     *     allowed object is
     *     {@link java.lang.String}
     */
    public void setAlias(String value) {
        this.alias = value;
    }

    /**
     * Gets the value of the accession property.
     *
     * @return a {@link java.lang.String} object.
     */
    public String getAccession() {
        return accession;
    }

    /**
     * Sets the value of the accession property.
     *
     * @param value
     *     allowed object is
     *     {@link java.lang.String}
     */
    public void setAccession(String value) {
        this.accession = value;
    }


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
     *         &lt;element name="MEMBER">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;attribute name="sample_ref" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="sample_id" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="barcode_seqence" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "member"
    })
    public static class MEMBERS {

        @XmlElement(name = "MEMBER", required = true)
        protected List<SampleType.MEMBERS.MEMBER> member;

        /**
         * Gets the value of the member property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the member property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getMEMBER().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link SampleType.MEMBERS.MEMBER }
         * 
         * 
         */
        public List<SampleType.MEMBERS.MEMBER> getMEMBER() {
            if (member == null) {
                member = new ArrayList<SampleType.MEMBERS.MEMBER>();
            }
            return this.member;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;attribute name="sample_ref" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="sample_id" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="barcode_seqence" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class MEMBER {

            @XmlAttribute(name = "sample_ref")
            protected String sampleRef;
            @XmlAttribute(name = "sample_id")
            protected String sampleId;
            @XmlAttribute(name = "barcode_seqence", required = true)
            protected String barcodeSeqence;

            /**
             * Gets the value of the sampleRef property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSampleRef() {
                return sampleRef;
            }

            /**
             * Sets the value of the sampleRef property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSampleRef(String value) {
                this.sampleRef = value;
            }

            /**
             * Gets the value of the sampleId property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSampleId() {
                return sampleId;
            }

            /**
             * Sets the value of the sampleId property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSampleId(String value) {
                this.sampleId = value;
            }

            /**
             * Gets the value of the barcodeSeqence property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getBarcodeSeqence() {
                return barcodeSeqence;
            }

            /**
             * Sets the value of the barcodeSeqence property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setBarcodeSeqence(String value) {
                this.barcodeSeqence = value;
            }

        }

    }


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
     *         &lt;element name="SAMPLE_ATTRIBUTE">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;all>
     *                   &lt;element name="TAG" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="VALUE" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="UNITS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                 &lt;/all>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "sampleattribute"
    })
    public static class SAMPLEATTRIBUTES {

        @XmlElement(name = "SAMPLE_ATTRIBUTE", required = true)
        protected List<SampleType.SAMPLEATTRIBUTES.SAMPLEATTRIBUTE> sampleattribute;

        /**
         * Gets the value of the sampleattribute property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the sampleattribute property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getSAMPLEATTRIBUTE().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link SampleType.SAMPLEATTRIBUTES.SAMPLEATTRIBUTE }
         * 
         * 
         */
        public List<SampleType.SAMPLEATTRIBUTES.SAMPLEATTRIBUTE> getSAMPLEATTRIBUTE() {
            if (sampleattribute == null) {
                sampleattribute = new ArrayList<SampleType.SAMPLEATTRIBUTES.SAMPLEATTRIBUTE>();
            }
            return this.sampleattribute;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;all>
         *         &lt;element name="TAG" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="VALUE" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="UNITS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *       &lt;/all>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {

        })
        public static class SAMPLEATTRIBUTE {

            @XmlElement(name = "TAG", required = true)
            protected String tag;
            @XmlElement(name = "VALUE", required = true)
            protected String value;
            @XmlElement(name = "UNITS")
            protected String units;

            /**
             * Gets the value of the tag property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTAG() {
                return tag;
            }

            /**
             * Sets the value of the tag property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTAG(String value) {
                this.tag = value;
            }

            /**
             * Gets the value of the value property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getVALUE() {
                return value;
            }

            /**
             * Sets the value of the value property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setVALUE(String value) {
                this.value = value;
            }

            /**
             * Gets the value of the units property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getUNITS() {
                return units;
            }

            /**
             * Sets the value of the units property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setUNITS(String value) {
                this.units = value;
            }

        }

    }


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
     *         &lt;element name="SAMPLE_LINK">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;choice>
     *                   &lt;element name="URL_LINK">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;all>
     *                             &lt;element name="LABEL" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                             &lt;element name="URL" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
     *                           &lt;/all>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="ENTREZ_LINK">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;all>
     *                             &lt;element name="DB" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                             &lt;element name="ID" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                           &lt;/all>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/choice>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "samplelink"
    })
    public static class SAMPLELINKS {

        @XmlElement(name = "SAMPLE_LINK", required = true)
        protected List<SampleType.SAMPLELINKS.SAMPLELINK> samplelink;

        /**
         * Gets the value of the samplelink property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the samplelink property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getSAMPLELINK().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link SampleType.SAMPLELINKS.SAMPLELINK }
         * 
         * 
         */
        public List<SampleType.SAMPLELINKS.SAMPLELINK> getSAMPLELINK() {
            if (samplelink == null) {
                samplelink = new ArrayList<SampleType.SAMPLELINKS.SAMPLELINK>();
            }
            return this.samplelink;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;choice>
         *         &lt;element name="URL_LINK">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;all>
         *                   &lt;element name="LABEL" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                   &lt;element name="URL" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
         *                 &lt;/all>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="ENTREZ_LINK">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;all>
         *                   &lt;element name="DB" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                   &lt;element name="ID" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                 &lt;/all>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/choice>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "urllink",
            "entrezlink"
        })
        public static class SAMPLELINK {

            @XmlElement(name = "URL_LINK")
            protected SampleType.SAMPLELINKS.SAMPLELINK.URLLINK urllink;
            @XmlElement(name = "ENTREZ_LINK")
            protected SampleType.SAMPLELINKS.SAMPLELINK.ENTREZLINK entrezlink;

            /**
             * Gets the value of the urllink property.
             * 
             * @return
             *     possible object is
             *     {@link SampleType.SAMPLELINKS.SAMPLELINK.URLLINK }
             *     
             */
            public SampleType.SAMPLELINKS.SAMPLELINK.URLLINK getURLLINK() {
                return urllink;
            }

            /**
             * Sets the value of the urllink property.
             * 
             * @param value
             *     allowed object is
             *     {@link SampleType.SAMPLELINKS.SAMPLELINK.URLLINK }
             *     
             */
            public void setURLLINK(SampleType.SAMPLELINKS.SAMPLELINK.URLLINK value) {
                this.urllink = value;
            }

            /**
             * Gets the value of the entrezlink property.
             * 
             * @return
             *     possible object is
             *     {@link SampleType.SAMPLELINKS.SAMPLELINK.ENTREZLINK }
             *     
             */
            public SampleType.SAMPLELINKS.SAMPLELINK.ENTREZLINK getENTREZLINK() {
                return entrezlink;
            }

            /**
             * Sets the value of the entrezlink property.
             * 
             * @param value
             *     allowed object is
             *     {@link SampleType.SAMPLELINKS.SAMPLELINK.ENTREZLINK }
             *     
             */
            public void setENTREZLINK(SampleType.SAMPLELINKS.SAMPLELINK.ENTREZLINK value) {
                this.entrezlink = value;
            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;all>
             *         &lt;element name="DB" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="ID" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *       &lt;/all>
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {

            })
            public static class ENTREZLINK {

                @XmlElement(name = "DB", required = true)
                protected String db;
                @XmlElement(name = "ID", required = true)
                protected String id;

                /**
                 * Gets the value of the db property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getDB() {
                    return db;
                }

                /**
                 * Sets the value of the db property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setDB(String value) {
                    this.db = value;
                }

                /**
                 * Gets the value of the id property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getID() {
                    return id;
                }

                /**
                 * Sets the value of the id property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setID(String value) {
                    this.id = value;
                }

            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;all>
             *         &lt;element name="LABEL" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="URL" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
             *       &lt;/all>
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {

            })
            public static class URLLINK {

                @XmlElement(name = "LABEL", required = true)
                protected String label;
                @XmlElement(name = "URL", required = true)
                @XmlSchemaType(name = "anyURI")
                protected String url;

                /**
                 * Gets the value of the label property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getLABEL() {
                    return label;
                }

                /**
                 * Sets the value of the label property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setLABEL(String value) {
                    this.label = value;
                }

                /**
                 * Gets the value of the url property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getURL() {
                    return url;
                }

                /**
                 * Sets the value of the url property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setURL(String value) {
                    this.url = value;
                }

            }

        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;all>
     *         &lt;element name="TAXON_ID" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
     *         &lt;element name="COMMON_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="ANONYMIZED_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *       &lt;/all>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {

    })
    public static class SAMPLENAME {

        @XmlElement(name = "TAXON_ID")
        protected Integer taxonid;
        @XmlElement(name = "COMMON_NAME")
        protected String commonname;
        @XmlElement(name = "ANONYMIZED_NAME")
        protected String anonymizedname;

        /**
         * Gets the value of the taxonid property.
         * 
         * @return
         *     possible object is
         *     {@link Integer }
         *     
         */
        public Integer getTAXONID() {
            return taxonid;
        }

        /**
         * Sets the value of the taxonid property.
         * 
         * @param value
         *     allowed object is
         *     {@link Integer }
         *     
         */
        public void setTAXONID(Integer value) {
            this.taxonid = value;
        }

        /**
         * Gets the value of the commonname property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCOMMONNAME() {
            return commonname;
        }

        /**
         * Sets the value of the commonname property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCOMMONNAME(String value) {
            this.commonname = value;
        }

        /**
         * Gets the value of the anonymizedname property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getANONYMIZEDNAME() {
            return anonymizedname;
        }

        /**
         * Sets the value of the anonymizedname property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setANONYMIZEDNAME(String value) {
            this.anonymizedname = value;
        }

    }

}