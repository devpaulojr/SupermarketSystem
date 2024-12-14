package com.devpaulojr.Spring_App.controller.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.time.Instant;

public class StandardError implements Serializable {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant timesStamp;
    private Integer status;
    private String error;
    private String path;

    public StandardError(){

    }

    public StandardError(Instant timesStamp, Integer status, String error, String path) {
        this.timesStamp = timesStamp;
        this.status = status;
        this.error = error;
        this.path = path;
    }

    public Instant getTimesStamp() {
        return timesStamp;
    }

    public void setTimesStamp(Instant timesStamp) {
        this.timesStamp = timesStamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
