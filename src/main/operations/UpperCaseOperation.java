package main.operations;

import main.interfaces.Operation;
import main.interfaces.Impl.OperationDecorator;

public class UpperCaseOperation extends OperationDecorator {



     public UpperCaseOperation(Operation operation) {
         super(operation);
     }

     @Override
    public StringBuilder transform(StringBuilder substring) throws InterruptedException {

         substring=super.transform(substring);

         for (int i = 0; i < substring.length(); i++) {
             if (Character.isLowerCase(substring.charAt(i))) {
                 substring.setCharAt(i,
                         Character.toUpperCase(substring.charAt(i)));
             }
         }
         return substring;
    }

 }