//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.05.04 at 12:38:29 AM CEST 
//


package org.bioinfo.formats.parser.psi.v254jaxb;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Crossreference to an external database. Crossreferences to literature databases, e.g. PubMed, should not be put into this structure, but into the bibRef element where possible.
 * 
 * <p>Java class for xref complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="xref">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="primaryRef" type="{http://psi.hupo.org/mi/mif}dbReference"/>
 *         &lt;element name="secondaryRef" type="{http://psi.hupo.org/mi/mif}dbReference" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "xref", propOrder = {
    "primaryRef",
    "secondaryRef"
})
public class Xref {

    @XmlElement(required = true)
    protected DbReference primaryRef;
    protected List<DbReference> secondaryRef;

    /**
     * Gets the value of the primaryRef property.
     * 
     * @return
     *     possible object is
     *     {@link DbReference }
     *     
     */
    public DbReference getPrimaryRef() {
        return primaryRef;
    }

    /**
     * Sets the value of the primaryRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link DbReference }
     *     
     */
    public void setPrimaryRef(DbReference value) {
        this.primaryRef = value;
    }

    /**
     * Gets the value of the secondaryRef property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the secondaryRef property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSecondaryRef().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DbReference }
     * 
     * 
     */
    public List<DbReference> getSecondaryRef() {
        if (secondaryRef == null) {
            secondaryRef = new ArrayList<DbReference>();
        }
        return this.secondaryRef;
    }

}
