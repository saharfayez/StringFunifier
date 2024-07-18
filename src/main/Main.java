package main;

import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();

        List<Integer> startIndexes = List.of(1 , 5,7,11,13);
        List<Integer> endIndexes = List.of(3 , 5 , 10 , 12,14);
        List<Operation> operations = List.of(
                new ReverseOperation( new CompressionOperation(new BaseClass())),
                new UpperCaseOperation( (new BaseClass())),
                new CompressionOperation( new UpperCaseOperation(new SortingOperation(new BaseClass()))),
                new CompressionOperation(new BaseClass()),
                new ReverseOperation(new UpperCaseOperation(new CompressionOperation(new BaseClass())))

        );





        StringFunifier sd = new StringFunifier(s ,  startIndexes, endIndexes , operations);
        System.out.println(sd.getStringFunifier());


    }
}