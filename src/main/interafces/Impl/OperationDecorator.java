package main.interafces.Impl;

import main.interafces.Operation;

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
