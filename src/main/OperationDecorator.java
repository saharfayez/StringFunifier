package main;

import java.util.List;

public abstract class OperationDecorator implements Operation {

    protected Operation operation;



    public OperationDecorator(Operation operation) {

        this.operation = operation;
    }

    @Override
    public StringBuilder transform(StringBuilder substring) {
        return operation.transform(substring);
    }
}
