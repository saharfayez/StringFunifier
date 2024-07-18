package main;

public class ReverseOperation extends OperationDecorator  {


    public ReverseOperation(Operation operation) {
        super(operation);
    }



    @Override
    public StringBuilder transform(StringBuilder substring) {
        substring=super.transform(substring);
        substring.reverse();
        return substring;
    }
}
