package main.operations;

import main.interfaces.Operation;
import main.interfaces.Impl.OperationDecorator;

public class CompressionOperation extends OperationDecorator {


    public CompressionOperation(Operation operation) {
        super(operation);
    }

    @Override
    public StringBuilder transform(StringBuilder substring) throws InterruptedException {

        String s2 = substring.toString();
        substring = super.transform(substring);
        substring.setLength(0);
        int count = 1;
        char[] chars = s2.toCharArray();
        for (int j = 0; j < chars.length; j++) {
            char c = chars[j];
            if (j + 1 < chars.length && c == chars[j + 1]) {
                count++;
            } else {
                substring.append(c).append(count);
                count = 1;
            }

        }
        return substring;
    }
}