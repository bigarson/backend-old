package com.bigarson.model.exception;

public class BranchLimitException extends RuntimeException{
    public BranchLimitException() {
        super("exception.account.branch-limit");
    }
}
