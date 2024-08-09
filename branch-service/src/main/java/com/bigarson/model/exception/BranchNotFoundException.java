package com.bigarson.model.exception;

public class BranchNotFoundException extends RuntimeException {
    public BranchNotFoundException() {
        super("exception.notfound.branch");
    }
}
