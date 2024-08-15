package com.bigarson.model.exception;

public class BranchNotFoundException extends NotFoundException {
    public BranchNotFoundException() {
        super("exception.notfound.branch");
    }
}
