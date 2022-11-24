package com.example.brgain.helpers;

import com.example.brgain.model.core.ApiResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice(basePackages = {"com.example"})
@Slf4j
public class GlobalExceptionHandler {

  @ExceptionHandler(Exception.class)
  @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
  public @ResponseBody
  ApiResponse handleException(Exception ex) {
//    String errorMsg = "Error occurred " +
//            ":" + (ex.getLocalizedMessage() == null ? "Error" : ex.getLocalizedMessage());
    String errorMsg = ex.getLocalizedMessage();
    ApiResponse apiOutput = new ApiResponse();
    apiOutput.setSuccess(false);
    apiOutput.setErrorCode(400);
    apiOutput.setErrorMessage(errorMsg);
    log.error("Exception occurred", ex);
    return apiOutput;
  }


}