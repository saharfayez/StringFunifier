package main.operations;

import main.interafces.Operation;
import main.interafces.Impl.OperationDecorator;

public class LowerCaseOperation extends OperationDecorator {


    public LowerCaseOperation(Operation operation) {
        super(operation);
    }


    @Override
    public StringBuilder transform(StringBuilder substring) throws InterruptedException {
        Thread.sleep(1000);
        substring=super.transform(substring);

        for (int i = 0; i < substring.length(); i++) {
            if (Character.isUpperCase(substring.charAt(i))) {
                substring.setCharAt(i,
                        Character.toLowerCase(substring.charAt(i)));
            }
        }
        return substring;
    }
}