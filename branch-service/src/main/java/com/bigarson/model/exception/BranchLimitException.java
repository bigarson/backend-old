package com.bigarson.model.exception;

public class BranchLimitException extends BadRequestException {
    public BranchLimitException() {
        super("exception.branch.limit");
    }
}
