package io.amofoe.util.http;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public class HttpErrorInfo {
    private final ZonedDateTime timestamp;
    private final int httpStatus;
    private final String message;
    private final String path;
    private final String error;

    public HttpErrorInfo() {
        this.timestamp = null;
        this.httpStatus = 0;
        this.message = "";
        this.path = "";
        this.error = "";
    }

    public HttpErrorInfo(HttpStatus httpStatus, String message, String path) {
        this.error = httpStatus.getReasonPhrase();
        this.timestamp = ZonedDateTime.now();
        this.httpStatus = httpStatus.value();
        this.message = message;
        this.path = path;
    }

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }

    public int getHttpStatus() {
        return httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public String getPath() {
        return path;
    }

    public String getError() {
        return error;
    }
}
