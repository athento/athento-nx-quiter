
package org.athento.nuxeo.quiter.integration.quitter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para DetailType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="DetailType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="concept" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="amountWithoutVAT" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="expenseAccount" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="personalAccount" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DetailType", propOrder = {
    "concept",
    "amountWithoutVAT",
    "expenseAccount",
    "personalAccount"
})
public class DetailType {

    @XmlElement(required = true)
    protected String concept;
    @XmlElement(required = true)
    protected String amountWithoutVAT;
    @XmlElement(required = true)
    protected String expenseAccount;
    @XmlElement(required = true)
    protected String personalAccount;

    /**
     * Obtiene el valor de la propiedad concept.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConcept() {
        return concept;
    }

    /**
     * Define el valor de la propiedad concept.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConcept(String value) {
        this.concept = value;
    }

    /**
     * Obtiene el valor de la propiedad amountWithoutVAT.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAmountWithoutVAT() {
        return amountWithoutVAT;
    }

    /**
     * Define el valor de la propiedad amountWithoutVAT.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAmountWithoutVAT(String value) {
        this.amountWithoutVAT = value;
    }

    /**
     * Obtiene el valor de la propiedad expenseAccount.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpenseAccount() {
        return expenseAccount;
    }

    /**
     * Define el valor de la propiedad expenseAccount.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpenseAccount(String value) {
        this.expenseAccount = value;
    }

    /**
     * Obtiene el valor de la propiedad personalAccount.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getPersonalAccount() {
        return personalAccount;
    }

    /**
     * Define el valor de la propiedad expenseAccount.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setPersonalAccount(String value) {
        this.personalAccount = value;
    }
}
