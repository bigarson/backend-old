package com.bigarson.model.exception;

public class WorkingTimeAlreadyExistException extends AlreadyExistException {
    public WorkingTimeAlreadyExistException() {
        super("working.time.already.exist");
    }
}
