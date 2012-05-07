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
 * Describes inferred interactions, usually combining data from more than one experiment.
 *                 Examples: 1: Show the topology of binary interactions within a complex. 2: Interaction inferred from
 *                 multiple experiments which on their own would not support the interaction. Example: A-B in experiment 1,
 *                 B-C- in experiment 2, A-C is the inferred interaction.
 *             
 * 
 * <p>Java class for inferredInteractionList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="inferredInteractionList">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="inferredInteraction" type="{http://psi.hupo.org/mi/mif}inferredInteraction" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "inferredInteractionList", propOrder = {
    "inferredInteraction"
})
public class InferredInteractionList {

    @XmlElement(required = true)
    protected List<InferredInteraction> inferredInteraction;

    /**
     * Gets the value of the inferredInteraction property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the inferredInteraction property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInferredInteraction().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InferredInteraction }
     * 
     * 
     */
    public List<InferredInteraction> getInferredInteraction() {
        if (inferredInteraction == null) {
            inferredInteraction = new ArrayList<InferredInteraction>();
        }
        return this.inferredInteraction;
    }

}
