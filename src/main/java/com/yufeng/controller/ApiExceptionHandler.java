package com.yufeng.controller;

import com.yufeng.config.ResultStatus;
import com.yufeng.util.ResultModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by kingstones on 16/8/10.
 */
//@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseEntity<ResultModel> handleInvalidRequestError(Exception ex) {
        return new ResponseEntity<ResultModel>(ResultModel.error(ResultStatus.BAD_REQUEST),HttpStatus.OK);

    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ResponseEntity<ResultModel> handleUnexpectedServerError(RuntimeException ex) {
        return new ResponseEntity<ResultModel>(ResultModel.error(ResultStatus.INTERNAL_SERVER_ERROR),HttpStatus.OK);

    }
}

