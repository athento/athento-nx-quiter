package org.athento.nuxeo.quiter.operation.exception;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.athento.nuxeo.quiter.api.entity.QuiterExceptionEntity;
import org.athento.nuxeo.quiter.api.exception.QuiterException;
import org.nuxeo.ecm.automation.OperationContext;
import org.nuxeo.ecm.automation.OperationException;
import org.nuxeo.ecm.automation.core.annotations.Context;
import org.nuxeo.ecm.automation.core.annotations.Operation;
import org.nuxeo.ecm.automation.core.annotations.OperationMethod;
import org.nuxeo.ecm.automation.jaxrs.io.operations.RestOperationContext;
import org.nuxeo.ecm.core.api.CoreSession;

/**
 * Quiter exception.
 */
@Operation(id = QuiterExceptionOperation.ID, category = "Quiter",
        label = "Quiter Exception", description = "Throws an Quiter Exception")
public class QuiterExceptionOperation {

    private static final Log LOG = LogFactory
            .getLog(QuiterExceptionOperation.class);

    public static final String ID = "Quiter.Exception";

    @Context
    protected OperationContext ctx;

    @Context
    protected CoreSession session;

    @OperationMethod()
    public QuiterExceptionEntity run() throws OperationException {
        QuiterExceptionEntity retVal = null;
        Object excObject = ctx.get("exceptionObject");
        int returnCode = 500;
        if (excObject instanceof QuiterException) {
            retVal = new QuiterExceptionEntity(((QuiterException) excObject).getMessage(),
                    ((QuiterException) excObject).getCode());
        } else if (excObject instanceof Throwable) {
            Throwable t = (Throwable) excObject;
            retVal = new QuiterExceptionEntity(t.getMessage(), "500");
        } else {
            retVal = new QuiterExceptionEntity("Error in Renault operation", "500");
        }
        ((RestOperationContext) ctx).setHttpStatus(returnCode);
        return retVal;
    }

}