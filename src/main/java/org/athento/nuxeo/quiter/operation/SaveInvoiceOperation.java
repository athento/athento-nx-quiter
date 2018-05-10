package org.athento.nuxeo.quiter.operation;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.athento.nuxeo.quiter.api.exception.InvoiceException;
import org.athento.nuxeo.quiter.api.exception.QuiterException;
import org.athento.nuxeo.quiter.integration.quitter.*;
import org.athento.nuxeo.quiter.api.util.QuiterUtils;
import org.nuxeo.ecm.automation.OperationContext;
import org.nuxeo.ecm.automation.core.annotations.Context;
import org.nuxeo.ecm.automation.core.annotations.Operation;
import org.nuxeo.ecm.automation.core.annotations.OperationMethod;
import org.nuxeo.ecm.automation.core.annotations.Param;
import org.nuxeo.ecm.core.api.CoreSession;
import org.nuxeo.ecm.core.api.DocumentModel;
import org.nuxeo.ecm.core.event.Event;
import org.nuxeo.ecm.core.event.EventProducer;
import org.nuxeo.ecm.core.event.impl.DocumentEventContext;
import org.nuxeo.ecm.core.event.impl.EventContextImpl;
import org.nuxeo.runtime.api.Framework;
import org.w3c.dom.Document;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

/**
 * Save a Invoice into Quitter.
 *
 * @author victorsanchez
 */
@Operation(id = SaveInvoiceOperation.ID, category = "Quiter", label = "Save a Invoice document into Quitter", description = "Save a Invoice document into Quitter",
        since = "6.0", addToStudio = false)
public class SaveInvoiceOperation {

    private static final Log LOG = LogFactory.getLog(SaveInvoiceOperation.class);

    /**
     * Operation ID.
     */
    public static final String ID = "Quiter.SaveInvoice";

    /**
     * Success result.
     */
    private static final String SUCCESS = "SUCCESS";

    @Param(name = "dealerCode", required = true, description = "Dealer code")
    String dealerCode;

    @Param(name = "user", required = true, description = "Username")
    String user;

    @Param(name = "password", required = true, description = "Password")
    String password;

    /**
     * Param to save document.
     */
    @Param(name = "save", required = false)
    boolean save = true;

    /**
     * Param to debugging.
     */
    @Param(name = "debug", required = false)
    boolean debug = false;

    /**
     * Param to simulate.
     */
    @Param(name = "mockup", required = false)
    boolean mockup = false;

    /**
     * Context.
     */
    @Context
    protected OperationContext ctx;

    /**
     * Session.
     */
    @Context
    protected CoreSession session;

    /**
     * Run, save the Factura into Quitter tool.
     *
     * @return get document to update with service result information
     * @throws QuiterException error
     */
    @OperationMethod
    public DocumentModel run(DocumentModel doc) throws QuiterException {
        if (LOG.isInfoEnabled()) {
            LOG.info("Running Save Factura operation ...");
        }
        if (!"Invoice".equals(doc.getType())) {
            throw new InvoiceException("Document " + doc.getId() + " is not a Invoice doctype");
        }
        MessageType output = null;
        // Get invoice service
        InvoicesIntegration_Service service = new InvoicesIntegration_Service(session);

        InvoicesType invoicesType;
        if (!mockup) {
            // Generate invoiceTypes from source document
            invoicesType = getInvoicesTypeFromDocument(doc);
        } else {
            invoicesType = mockInvoicesType();
        }

        if (debug) {
            // Prepare execute invoice
            ExecuteInvoicesIntegration invoicesIntegration = new ExecuteInvoicesIntegration();
            invoicesIntegration.setDealerCode(dealerCode);
            invoicesIntegration.setUser(user);
            invoicesIntegration.setPassword(password);
            invoicesIntegration.setInvoices(invoicesType);
            // Show XML with document information
            showJaxbRequest(invoicesIntegration);
        }

        // Call service
        String result = "";
        try {
            output = service.getInvoicesIntegration().executeInvoicesIntegration(dealerCode, user, password, invoicesType);
            result = output.getResult();
        }  catch (Exception e) {
            result = "ERROR";
            LOG.error("Unable to integrate Factura into Quiter", e);
        }
        if (!SUCCESS.equals(result)) {
            LOG.error("QUITTER: Error saving Factura into Quitter: " + output.getDescription());
        }
        if (output != null) {
            if (LOG.isInfoEnabled()) {
                LOG.info("Output Factura " + output.getDescription() + ", " + output.getDocumentID());
            }
            if (save) {
                // Save result information into doc
                doc.setPropertyValue("integration:result", output.getResult());
                doc.setPropertyValue("integration:description", output.getDescription());
                if (SUCCESS.equals(result)) {
                    doc.setPropertyValue("integration:documentID", output.getDocumentID());
                }
                session.saveDocument(doc);
                // Throws output
                raiseEvent(doc, output);
            }
        }
        return doc;
    }

    /**
     * Mock for an invoice type.
     *
     * @return
     */
    private InvoicesType mockInvoicesType() {
        InvoicesType invoicesType = new InvoicesType();
        InvoiceType invoiceType = new InvoiceType();
        invoiceType.setInvoiceID("12345678");
        invoiceType.setCompany("Yerbabuena");
        invoiceType.setDepartment("1");
        invoiceType.setNif("11146407B");
        invoiceType.setPostingDate(QuiterUtils.formatDate(Calendar.getInstance().getTime(), "yyyy-MM-dd"));
        invoiceType.setInvoiceDate(QuiterUtils.formatDate(Calendar.getInstance().getTime(), "yyyy-MM-dd"));
        invoiceType.setOffice("1");
        invoiceType.setBrand("2");
        invoiceType.setProviderID("1");
        // Add details
        DetailsType detailsType = new DetailsType();
        DetailType detailType1 = new DetailType();
        detailType1.setConcept("1");
        detailType1.setAmountWithoutVAT("2");
        detailType1.setExpenseAccount("64909100");
        detailType1.setPersonalAccount("PA_111");
        detailsType.getDetail().add(detailType1);
        DetailType detailType2 = new DetailType();
        detailType2.setConcept("1");
        detailType2.setAmountWithoutVAT("100");
        detailType2.setExpenseAccount("64909100");
        detailType2.setPersonalAccount("PA_222");
        detailsType.getDetail().add(detailType2);
        DetailType detailType3 = new DetailType();
        detailType3.setConcept("1");
        detailType3.setAmountWithoutVAT("200");
        detailType3.setExpenseAccount("65202900");
        detailType3.setPersonalAccount("PA_333");
        detailsType.getDetail().add(detailType3);
        invoiceType.setDetails(detailsType);
        // Add taxes
        TaxesType taxesType = new TaxesType();
        TaxType taxType1 = new TaxType();
        taxType1.setType("1");
        taxType1.setTaxBase("2");
        taxType1.setPercentage("4");
        taxType1.setTotalInvoice("43");
        taxesType.getTax().add(taxType1);
        invoiceType.setTaxes(taxesType);
        // Add payment method
        PaymentMethodType paymentType = new PaymentMethodType();
        paymentType.setPaymentMethod("1");
        paymentType.setBank("BBVA");
        paymentType.setExpirationDate(QuiterUtils.formatDate(Calendar.getInstance().getTime(), "yyyy-MM-dd"));
        paymentType.setAccount("1234");
        paymentType.setGenerateDeadline(true);
        invoiceType.setPaymentMethodInfo(paymentType);
        // Add Invoice number
        invoiceType.setInvoiceNumber("1234");
        invoiceType.setTotal("10000");
        invoicesType.getInvoice().add(invoiceType);
        return invoicesType;
    }

    /**
     * Get invoices type from document.
     *
     * @param doc
     * @return a instance of
     * @throws InvoiceException on error
     */
    private InvoicesType getInvoicesTypeFromDocument(DocumentModel doc) throws InvoiceException {
        // Type=Invoice | Schema=S_FACTURA
        InvoicesType invoicesType = new InvoicesType();
        InvoiceType invoiceType = new InvoiceType();
        invoiceType.setInvoiceID(doc.getId());
        invoiceType.setCompany((String) doc.getPropertyValue("S_FACTURA:companyid"));
        invoiceType.setDepartment((String) doc.getPropertyValue("S_FACTURA:department"));
        invoiceType.setNif((String) doc.getPropertyValue("S_FACTURA:provider"));
        invoiceType.setPostingDate(QuiterUtils.formatDate(Calendar.getInstance().getTime(), "yyyy-MM-dd"));
        invoiceType.setInvoiceDate(new java.text.SimpleDateFormat("yyyy-MM-dd").format(((Calendar) doc.getPropertyValue("S_FACTURA:date")).getTime()));
        invoiceType.setOffice((String) doc.getPropertyValue("S_FACTURA:tipoDocumento"));
        invoiceType.setBrand((String) doc.getPropertyValue("S_FACTURA:providerAccount"));
        //if (doc.getPropertyValue("S_FACTURA:companyid").equals("50") || doc.getPropertyValue("S_FACTURA:companyid").equals("70")) {
        //   invoiceType.setOffice((String) doc.getPropertyValue("S_FACTURA:companyid"));
        //} else {
        //            invoiceType.setOffice("");
        //}
        invoiceType.setBrand((String) doc.getPropertyValue("S_FACTURA:providerAccount"));
        // Add details
        DetailsType detailsType = new DetailsType();
        List<Map<String, Object>> details = (List) doc.getPropertyValue("S_FACTURA:subjectLine");
        for (Map<String, Object> detail : details) {
            DetailType detailType = new DetailType();
            detailType.setConcept((String) detail.get("subjectLineSubject"));
            Double amount = (Double) detail.get("subjectLineAmount");
            if (amount == null) {
                amount=0.0;
            }
            detailType.setAmountWithoutVAT(String.format("%.2f",amount).replace(",",""));
            detailType.setExpenseAccount((String) detail.get("subjectLineAccount"));
            detailType.setPersonalAccount((String) detail.get("subjectLinePersonalAccount"));
            detailsType.getDetail().add(detailType);
        }
        invoiceType.setDetails(detailsType);
        // Add taxes
        TaxesType taxesType = new TaxesType();
        List<Map<String, Object>> taxes = (List) doc.getPropertyValue("S_FACTURA:taxesLine");
        for (Map<String, Object> tax : taxes) {
            TaxType taxType = new TaxType();
            taxType.setType((String) tax.get("type_"));
            Double base = (Double) tax.get("taxBase");
            if (base == null) {
                base=0.0;
            }
            taxType.setTaxBase(String.format("%.2f",base).replace(",",""));
            taxType.setPercentage((String) tax.get("percentage"));
            Double total = (Double) tax.get("totalInvoice");
            if (total == null) {
                total=0.0;
            }
            taxType.setTotalInvoice(String.format("%.2f",total).replace(",",""));
            taxesType.getTax().add(taxType);
        }
        invoiceType.setTaxes(taxesType);
        // Add payment method
        PaymentMethodType paymentType = new PaymentMethodType();
        paymentType.setPaymentMethod((String) doc.getPropertyValue("S_FACTURA:paymentMethod"));
        paymentType.setBank((String) doc.getPropertyValue("S_FACTURA:bank"));
        // FIXME:
        paymentType.setExpirationDate(null);
        // FIXME:
        paymentType.setAccount(null);
        // FIXME: Default true
        paymentType.setGenerateDeadline(true);
        invoiceType.setPaymentMethodInfo(paymentType);
        // Add Invoice number
        invoiceType.setInvoiceNumber((String) doc.getPropertyValue("S_FACTURA:number"));
        // Add providerID
        invoiceType.setProviderID((String) doc.getPropertyValue("S_FACTURA:providerIdIntegration"));
        // Add Total
        Double Dtotal = (Double) doc.getPropertyValue("S_FACTURA:totalAmount");
        if (Dtotal == null) {
            Dtotal=0.0;
        }
        invoiceType.setTotal(String.format("%.2f",Dtotal).replace(",",""));
        // Add Invoice Type
        invoicesType.getInvoice().add(invoiceType);
        return invoicesType;
    }

    /**
     * Show JAXB XML to request.
     *
     * @param invoicesIntegration
     */
    private void showJaxbRequest(ExecuteInvoicesIntegration invoicesIntegration) {
        try {
            // Make document from JAXBContext
            Document document = DocumentBuilderFactory.newInstance()
                    .newDocumentBuilder().newDocument();
            JAXBContext jc = JAXBContext
                    .newInstance("org.athento.nuxeo.quiter.integration.quitter");
            Marshaller marshaller = jc.createMarshaller();
            marshaller.marshal(invoicesIntegration, document);

            if (LOG.isInfoEnabled()) {
                LOG.info("prettyXML request: " + QuiterUtils.formatXML(document));
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }


    /**
     * Raise event with output information.
     *
     * @param doc
     * @param output
     */
    private void raiseEvent(DocumentModel doc, MessageType output) {
        CoreSession session = ctx.getCoreSession();
        EventProducer producer = Framework.getService(EventProducer.class);
        EventContextImpl evctx = new DocumentEventContext(session, session.getPrincipal(), doc);
        if (output != null) {
            evctx.getProperties().put("result", output.getResult());
            evctx.getProperties().put("description", output.getDescription());
            evctx.getProperties().put("documentID", output.getDocumentID());
        }
        Event event = evctx.newEvent("saveFacturaEvent");
        producer.fireEvent(event);
    }


}
