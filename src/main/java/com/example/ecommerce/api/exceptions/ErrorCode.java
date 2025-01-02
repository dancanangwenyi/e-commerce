package com.example.ecommerce.api.exceptions;

/**
 * Enum representing different error codes and associated messages.
 */
public enum ErrorCode {

    // Internal Errors: 1 to 0999
    GENERIC_ERROR("SAYURI-0001", "The system is unable to complete the request. Contact system support."),
    HTTP_MEDIATYPE_NOT_SUPPORTED("SAYURI-0002", "Requested media type is not supported. Please use 'application/json' or 'application/xml' as 'Content-Type' header value"),
    HTTP_MESSAGE_NOT_WRITABLE("SAYURI-0003", "Missing 'Accept' header. Please add the 'Accept' header."),
    HTTP_MEDIA_TYPE_NOT_ACCEPTABLE("SAYURI-0004", "Requested 'Accept' header value is not supported. Please use 'application/json' or 'application/xml' as 'Accept' value"),
    JSON_PARSE_ERROR("SAYURI-0005", "Make sure the request payload is a valid JSON object."),
    HTTP_MESSAGE_NOT_READABLE("SAYURI-0006", "Make sure the request payload is a valid JSON or XML object according to 'Content-Type'.");

    private final String errCode;
    private final String errMsgKey;

    // Constructor
    ErrorCode(final String errCode, final String errMsgKey) {
        this.errCode = errCode;
        this.errMsgKey = errMsgKey;
    }

    /** @return the error code */
    public String getErrCode() {
        return errCode;
    }

    /** @return the error message key */
    public String getErrMsgKey() {
        return errMsgKey;
    }

    /**
     * @return the full error message
     */
    public String getErrorMessage() {
        // You could enhance this to look up the message from a properties file or translation service
        return errMsgKey;
    }
}
