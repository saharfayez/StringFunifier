package main.operations;

import main.interfaces.Operation;
import main.interfaces.Impl.OperationDecorator;

public class ReverseOperation extends OperationDecorator {


    public ReverseOperation(Operation operation) {
        super(operation);
    }



    @Override
    public StringBuilder transform(StringBuilder substring) throws InterruptedException {
        Thread.sleep(1000);
        substring=super.transform(substring);
        substring.reverse();
        return substring;
    }


}
