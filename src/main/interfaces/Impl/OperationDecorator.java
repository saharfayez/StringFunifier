package main.interfaces.Impl;

import main.interfaces.Operation;

public abstract class OperationDecorator implements Operation {

    protected Operation operation;



    public OperationDecorator(Operation operation) {

        this.operation = operation;
    }

    @Override
    public StringBuilder transform(StringBuilder substring) throws InterruptedException {
        return operation.transform(substring);
    }
}
