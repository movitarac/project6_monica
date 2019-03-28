
package com.racic.lib.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour session complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="session">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idSession" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="member" type="{http://webservice.lib.racic.com/}member" minOccurs="0"/>
 *         &lt;element name="sessionStart" type="{http://webservice.lib.racic.com/}timestamp" minOccurs="0"/>
 *         &lt;element name="sessionTimeOut" type="{http://webservice.lib.racic.com/}timestamp" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "session", propOrder = {
    "idSession",
    "member",
    "sessionStart",
    "sessionTimeOut"
})
public class Session {

    protected Integer idSession;
    protected Member member;
    protected Timestamp sessionStart;
    protected Timestamp sessionTimeOut;

    /**
     * Obtient la valeur de la propriété idSession.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdSession() {
        return idSession;
    }

    /**
     * Définit la valeur de la propriété idSession.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdSession(Integer value) {
        this.idSession = value;
    }

    /**
     * Obtient la valeur de la propriété member.
     * 
     * @return
     *     possible object is
     *     {@link Member }
     *     
     */
    public Member getMember() {
        return member;
    }

    /**
     * Définit la valeur de la propriété member.
     * 
     * @param value
     *     allowed object is
     *     {@link Member }
     *     
     */
    public void setMember(Member value) {
        this.member = value;
    }

    /**
     * Obtient la valeur de la propriété sessionStart.
     * 
     * @return
     *     possible object is
     *     {@link Timestamp }
     *     
     */
    public Timestamp getSessionStart() {
        return sessionStart;
    }

    /**
     * Définit la valeur de la propriété sessionStart.
     * 
     * @param value
     *     allowed object is
     *     {@link Timestamp }
     *     
     */
    public void setSessionStart(Timestamp value) {
        this.sessionStart = value;
    }

    /**
     * Obtient la valeur de la propriété sessionTimeOut.
     * 
     * @return
     *     possible object is
     *     {@link Timestamp }
     *     
     */
    public Timestamp getSessionTimeOut() {
        return sessionTimeOut;
    }

    /**
     * Définit la valeur de la propriété sessionTimeOut.
     * 
     * @param value
     *     allowed object is
     *     {@link Timestamp }
     *     
     */
    public void setSessionTimeOut(Timestamp value) {
        this.sessionTimeOut = value;
    }

}
