package com.example.ecommerce.api.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import com.fasterxml.jackson.core.JsonParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Locale;

import static com.example.ecommerce.api.exceptions.ErrorUtils.*;

/**
 * Global exception handler that intercepts exceptions thrown by controllers
 * and maps them to custom error responses.
 */
@ControllerAdvice
public class RestApiErrorHandler {

    private static final Logger log = LoggerFactory.getLogger(RestApiErrorHandler.class);
    private final MessageSource messageSource;

    @Autowired
    public RestApiErrorHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    /**
     * Handles generic exceptions.
     *
     * @param request the HttpServletRequest
     * @param ex the exception that was thrown
     * @param locale the locale of the request
     * @return a ResponseEntity containing the error details
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Error> handleException(HttpServletRequest request, Exception ex,
                                                 Locale locale) {
        ex.printStackTrace(); // Keep this for development; remove in production
        Error error = createError(ErrorCode.GENERIC_ERROR.getErrMsgKey(),
                        ErrorCode.GENERIC_ERROR.getErrCode(),
                        HttpStatus.INTERNAL_SERVER_ERROR.value());
                error.setUrl(request.getRequestURL().toString());
                error.setReqMethod(request.getMethod());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Handles HttpMediaTypeNotSupportedException.
     *
     * @param request the HttpServletRequest
     * @param ex the exception
     * @param locale the locale of the request
     * @return a ResponseEntity containing the error details
     */
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public ResponseEntity<Error> handleHttpMediaTypeNotSupportedException(HttpServletRequest request,
                                                                          HttpMediaTypeNotSupportedException ex,
                                                                          Locale locale) {
        ex.printStackTrace(); // Keep this for development; remove in production
        Error error = createError(ErrorCode.HTTP_MEDIATYPE_NOT_SUPPORTED.getErrMsgKey(),
                        ErrorCode.HTTP_MEDIATYPE_NOT_SUPPORTED.getErrCode(),
                        HttpStatus.UNSUPPORTED_MEDIA_TYPE.value());
                error.setUrl(request.getRequestURL().toString());
                error.setReqMethod(request.getMethod());
        log.info("HttpMediaTypeNotSupportedException :: request.getMethod(): " + request.getMethod());
        return new ResponseEntity<>(error, HttpStatus.UNSUPPORTED_MEDIA_TYPE);
    }

    /**
     * Handles HttpMessageNotWritableException.
     *
     * @param request the HttpServletRequest
     * @param ex the exception
     * @param locale the locale of the request
     * @return a ResponseEntity containing the error details
     */
    @ExceptionHandler(HttpMessageNotWritableException.class)
    public ResponseEntity<Error> handleHttpMessageNotWritableException(HttpServletRequest request,
                                                                       HttpMessageNotWritableException ex,
                                                                       Locale locale) {
        ex.printStackTrace(); // Keep this for development; remove in production
        Error error = createError(ErrorCode.HTTP_MESSAGE_NOT_WRITABLE.getErrMsgKey(),
                        ErrorCode.HTTP_MESSAGE_NOT_WRITABLE.getErrCode(),
                        HttpStatus.INTERNAL_SERVER_ERROR.value());
                error.setUrl(request.getRequestURL().toString());
                error.setReqMethod(request.getMethod());
        log.info("HttpMessageNotWritableException :: request.getMethod(): " + request.getMethod());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Handles HttpMediaTypeNotAcceptableException.
     *
     * @param request the HttpServletRequest
     * @param ex the exception
     * @param locale the locale of the request
     * @return a ResponseEntity containing the error details
     */
    @ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
    public ResponseEntity<Error> handleHttpMediaTypeNotAcceptableException(HttpServletRequest request,
                                                                           HttpMediaTypeNotAcceptableException ex,
                                                                           Locale locale) {
        ex.printStackTrace(); // Keep this for development; remove in production
        Error error = createError(ErrorCode.HTTP_MEDIA_TYPE_NOT_ACCEPTABLE.getErrMsgKey(),
                        ErrorCode.HTTP_MEDIA_TYPE_NOT_ACCEPTABLE.getErrCode(),
                        HttpStatus.NOT_ACCEPTABLE.value());
                error.setUrl(request.getRequestURL().toString());
                error.setReqMethod(request.getMethod());
        log.info("HttpMediaTypeNotAcceptableException :: request.getMethod(): " + request.getMethod());
        return new ResponseEntity<>(error, HttpStatus.NOT_ACCEPTABLE);
    }

    /**
     * Handles HttpMessageNotReadableException.
     *
     * @param request the HttpServletRequest
     * @param ex the exception
     * @param locale the locale of the request
     * @return a ResponseEntity containing the error details
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Error> handleHttpMessageNotReadableException(HttpServletRequest request,
                                                                       HttpMessageNotReadableException ex,
                                                                       Locale locale) {
        ex.printStackTrace(); // Keep this for development; remove in production
        Error error = createError(ErrorCode.HTTP_MESSAGE_NOT_READABLE.getErrMsgKey(),
                        ErrorCode.HTTP_MESSAGE_NOT_READABLE.getErrCode(),
                        HttpStatus.NOT_ACCEPTABLE.value());
                error.setUrl(request.getRequestURL().toString());
                error.setReqMethod(request.getMethod());
        log.info("HttpMessageNotReadableException :: request.getMethod(): " + request.getMethod());
        return new ResponseEntity<>(error, HttpStatus.NOT_ACCEPTABLE);
    }

    /**
     * Handles JsonParseException.
     *
     * @param request the HttpServletRequest
     * @param ex the exception
     * @param locale the locale of the request
     * @return a ResponseEntity containing the error details
     */
    @ExceptionHandler(JsonParseException.class)
    public ResponseEntity<Error> handleJsonParseException(HttpServletRequest request,
                                                          JsonParseException ex,
                                                          Locale locale) {
        ex.printStackTrace(); // Keep this for development; remove in production
        Error error = createError(ErrorCode.JSON_PARSE_ERROR.getErrMsgKey(),
                        ErrorCode.JSON_PARSE_ERROR.getErrCode(),
                        HttpStatus.BAD_REQUEST.value());
                error.setUrl(request.getRequestURL().toString());
                error.setReqMethod(request.getMethod());
        log.info("JsonParseException :: request.getMethod(): " + request.getMethod());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
