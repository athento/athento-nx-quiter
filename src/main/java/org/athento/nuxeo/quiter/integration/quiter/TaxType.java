
package org.athento.nuxeo.quiter.integration.quiter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para TaxType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="TaxType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="taxBase" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="percentage" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="totalInvoice" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TaxType", propOrder = {
    "type",
    "taxBase",
    "percentage",
    "totalInvoice"
})
public class TaxType {

    @XmlElement(required = true)
    protected String type;
    @XmlElement(required = true)
    protected String taxBase;
    @XmlElement(required = true)
    protected String percentage;
    @XmlElement(required = true)
    protected String totalInvoice;

    /**
     * Obtiene el valor de la propiedad type.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Define el valor de la propiedad type.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Obtiene el valor de la propiedad taxBase.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTaxBase() {
        return taxBase;
    }

    /**
     * Define el valor de la propiedad taxBase.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTaxBase(String value) {
        this.taxBase = value;
    }

    /**
     * Obtiene el valor de la propiedad percentage.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPercentage() {
        return percentage;
    }

    /**
     * Define el valor de la propiedad percentage.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPercentage(String value) {
        this.percentage = value;
    }

    /**
     * Obtiene el valor de la propiedad totalInvoice.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTotalInvoice() {
        return totalInvoice;
    }

    /**
     * Define el valor de la propiedad totalInvoice.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTotalInvoice(String value) {
        this.totalInvoice = value;
    }

}
