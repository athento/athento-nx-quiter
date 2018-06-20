
package org.athento.nuxeo.quiter.integration.quiter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para InvoiceType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="InvoiceType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="invoiceID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="company" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="department" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nif" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="postingDate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="invoiceDate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="office" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="brand" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="details" type="{http://www.quiter.com/InvoicesIntegration}DetailsType"/>
 *         &lt;element name="taxes" type="{http://www.quiter.com/InvoicesIntegration}TaxesType"/>
 *         &lt;element name="paymentMethodInfo" type="{http://www.quiter.com/InvoicesIntegration}PaymentMethodType"/>
 *         &lt;element name="invoiceNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="total" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="providerID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sucursal" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InvoiceType", propOrder = {
    "invoiceID",
    "company",
    "department",
    "nif",
    "postingDate",
    "invoiceDate",
    "office",
    "brand",
    "details",
    "taxes",
    "paymentMethodInfo",
    "invoiceNumber",
    "total",
    "providerID",
    "sucursal"
})
public class InvoiceType {

    @XmlElement(required = true)
    protected String invoiceID;
    @XmlElement(required = true)
    protected String company;
    @XmlElement(required = true)
    protected String department;
    @XmlElement(required = true)
    protected String nif;
    @XmlElement(required = true)
    protected String postingDate;
    @XmlElement(required = true)
    protected String invoiceDate;
    @XmlElement(required = true)
    protected String office;
    @XmlElement(required = true)
    protected String brand;
    @XmlElement(required = true)
    protected DetailsType details;
    @XmlElement(required = true)
    protected TaxesType taxes;
    @XmlElement(required = true)
    protected PaymentMethodType paymentMethodInfo;
    @XmlElement(required = true)
    protected String invoiceNumber;
    @XmlElement(required = true)
    protected String total;
    @XmlElement(required = true)
    protected String providerID;
    @XmlElement(required = true)
    protected String sucursal;

    /**
     * Obtiene el valor de la propiedad invoiceID.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInvoiceID() {
        return invoiceID;
    }

    /**
     * Define el valor de la propiedad invoiceID.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInvoiceID(String value) {
        this.invoiceID = value;
    }

    /**
     * Obtiene el valor de la propiedad company.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompany() {
        return company;
    }

    /**
     * Define el valor de la propiedad company.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompany(String value) {
        this.company = value;
    }

    /**
     * Obtiene el valor de la propiedad department.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDepartment() {
        return department;
    }

    /**
     * Define el valor de la propiedad department.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDepartment(String value) {
        this.department = value;
    }

    /**
     * Obtiene el valor de la propiedad nif.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNif() {
        return nif;
    }

    /**
     * Define el valor de la propiedad nif.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNif(String value) {
        this.nif = value;
    }

    /**
     * Obtiene el valor de la propiedad postingDate.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPostingDate() {
        return postingDate;
    }

    /**
     * Define el valor de la propiedad postingDate.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPostingDate(String value) {
        this.postingDate = value;
    }

    /**
     * Obtiene el valor de la propiedad invoiceDate.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInvoiceDate() {
        return invoiceDate;
    }

    /**
     * Define el valor de la propiedad invoiceDate.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInvoiceDate(String value) {
        this.invoiceDate = value;
    }

    /**
     * Obtiene el valor de la propiedad office.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOffice() {
        return office;
    }

    /**
     * Define el valor de la propiedad office.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOffice(String value) {
        this.office = value;
    }

    /**
     * Obtiene el valor de la propiedad brand.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Define el valor de la propiedad brand.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBrand(String value) {
        this.brand = value;
    }

    /**
     * Obtiene el valor de la propiedad details.
     * 
     * @return
     *     possible object is
     *     {@link DetailsType }
     *     
     */
    public DetailsType getDetails() {
        return details;
    }

    /**
     * Define el valor de la propiedad details.
     * 
     * @param value
     *     allowed object is
     *     {@link DetailsType }
     *     
     */
    public void setDetails(DetailsType value) {
        this.details = value;
    }

    /**
     * Obtiene el valor de la propiedad taxes.
     * 
     * @return
     *     possible object is
     *     {@link TaxesType }
     *     
     */
    public TaxesType getTaxes() {
        return taxes;
    }

    /**
     * Define el valor de la propiedad taxes.
     * 
     * @param value
     *     allowed object is
     *     {@link TaxesType }
     *     
     */
    public void setTaxes(TaxesType value) {
        this.taxes = value;
    }

    /**
     * Obtiene el valor de la propiedad paymentMethodInfo.
     * 
     * @return
     *     possible object is
     *     {@link PaymentMethodType }
     *     
     */
    public PaymentMethodType getPaymentMethodInfo() {
        return paymentMethodInfo;
    }

    /**
     * Define el valor de la propiedad paymentMethodInfo.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentMethodType }
     *     
     */
    public void setPaymentMethodInfo(PaymentMethodType value) {
        this.paymentMethodInfo = value;
    }

    /**
     * Obtiene el valor de la propiedad invoiceNumber.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    /**
     * Define el valor de la propiedad invoiceNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInvoiceNumber(String value) {
        this.invoiceNumber = value;
    }

    /**
     * Obtiene el valor de la propiedad total.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTotal() {
        return total;
    }

    /**
     * Define el valor de la propiedad total.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTotal(String value) {
        this.total = value;
    }

    /**
     * Obtiene el valor de la propiedad providerID.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProviderID() {
        return providerID;
    }

    /**
     * Define el valor de la propiedad providerID.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProviderID(String value) {
        this.providerID = value;
    }

    /**
     * Obtiene el valor de la propiedad sucursal.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getSucursal() {
        return sucursal;
    }

    /**
     * Define el valor de la propiedad sucursal.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setSucursal(String value) {
        this.sucursal = value;
    }

}
