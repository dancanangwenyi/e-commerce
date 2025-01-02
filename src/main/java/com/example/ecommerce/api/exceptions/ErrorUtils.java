package com.example.ecommerce.api.exceptions;

/**
 * Utility class that helps in creating standardized error objects.
 */
public class ErrorUtils {

    private ErrorUtils() {
        // Private constructor to prevent instantiation
    }

    /**
     * Creates and returns an error object based on the provided parameters.
     *
     * @param errMsgKey the error message key (localized string)
     * @param errorCode the unique error code for the error
     * @param httpStatusCode the HTTP status code
     * @return an Error object populated with the given information
     */
    public static Error createError(final String errMsgKey, final String errorCode,
                                    final Integer httpStatusCode) {
        Error error = new Error();
        error.setMessage(errMsgKey);
        error.setErrorCode(errorCode);
        error.setStatus(httpStatusCode);
        return error;
    }


}
