package com.learning.spring.restfulwebservices.exception;

import java.util.Date;

public class CommonExceptionResponse {

    //timestamp
    private Date timestamp;
    //message
    private String message;
    //details
    private String details;

    public CommonExceptionResponse(Date timestamp, String message, String details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "CommonExceptionResponse{" +
                "timestamp=" + timestamp +
                ", message='" + message + '\'' +
                ", details='" + details + '\'' +
                '}';
    }
}
