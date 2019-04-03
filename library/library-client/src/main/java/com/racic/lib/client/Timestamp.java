
package com.racic.lib.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour timestamp complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="timestamp">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nanos" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "timestamp", propOrder = {
    "nanos"
})
public class Timestamp {

    protected int nanos;

    /**
     * Obtient la valeur de la propriété nanos.
     * 
     */
    public int getNanos() {
        return nanos;
    }

    /**
     * Définit la valeur de la propriété nanos.
     * 
     */
    public void setNanos(int value) {
        this.nanos = value;
    }

}
