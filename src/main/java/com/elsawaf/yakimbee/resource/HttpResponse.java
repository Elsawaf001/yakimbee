package com.elsawaf.yakimbee.resource;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;

import java.time.Instant;
import java.util.Date;
import java.util.Map;

@Data
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@Setter
@Getter
@SuperBuilder
public class HttpResponse {
    @JsonFormat(shape = JsonFormat.Shape.STRING , pattern = "dd-MM-yyyy hh-mm-ss", timezone = "Africa/Cairo")
    protected Instant timeStamp;
    protected int StatusCode;
    protected HttpStatus httpStatus;
    protected String reason;
    protected String message;
    protected String developerMessage;
    protected Map<? , ?> data;


}