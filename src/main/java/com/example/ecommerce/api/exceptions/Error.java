package com.example.ecommerce.api.exceptions;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents an error object that will be returned as part of the error response.
 */
@Data
public class Error {

    private static final long serialVersionUID = 1L;

    /** App error code, which is different from HTTP error code. */
    private String errorCode;

    /** Short, human-readable summary of the problem. */
    private String message;

    /** HTTP status code. */
    private Integer status;

    /** URL of request that produced the error. */
    private String url = "Not available";

    /** Method of request that produced the error. */
    private String reqMethod = "Not available";


}
