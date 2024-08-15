package com.bigarson.helper;

import com.bigarson.base.BaseResponse;
import com.bigarson.model.exception.AccountException;
import com.bigarson.model.exception.AlreadyExistException;
import com.bigarson.model.exception.BadRequestException;
import com.bigarson.model.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Locale;

@ControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    private final MessageSource messageSource;

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<BaseResponse<?>> argumentValidException(MethodArgumentNotValidException e) {
        BaseResponse<?> baseResponse = new BaseResponse<>();
        for (ObjectError error : e.getBindingResult().getAllErrors()) {
            baseResponse.setMessage(error.getDefaultMessage());
        }
        baseResponse.setSuccess(false);
        return new ResponseEntity<>(baseResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<BaseResponse<?>> notFoundException(NotFoundException e, Locale locale) {
        return BaseResponse.error(messageSource.getMessage(e.getMessage(), null, locale), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = AlreadyExistException.class)
    public ResponseEntity<BaseResponse<?>> alreadyExistException(AlreadyExistException e, Locale locale) {
        return BaseResponse.error(messageSource.getMessage(e.getMessage(), null, locale), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = BadRequestException.class)
    public ResponseEntity<BaseResponse<?>> badRequestException(BadRequestException e, Locale locale) {
        return BaseResponse.error(messageSource.getMessage(e.getMessage(), null, locale), HttpStatus.BAD_REQUEST);
    }


}
