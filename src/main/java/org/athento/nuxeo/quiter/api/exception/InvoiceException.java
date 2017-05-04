package org.athento.nuxeo.quiter.api.exception;

/**
 * Factura exception.
 */
public class InvoiceException extends QuiterException {

    /**
     *
     * @param message
     */
    public InvoiceException(String message) {
        super(message, null);
    }

    /**
     *
     * @param message
     * @param code
     */
    public InvoiceException(String message, String code) {
        super(message, code);
    }

    /**
     *
     * @param message
     * @param code
     * @param cause
     */
    public InvoiceException(String message, String code, Throwable cause) {
        super(message, code, cause);
    }

    /**
     *
     * @param cause
     */
    public InvoiceException(Throwable cause) {
        super(cause);
    };

}
