package main;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;


public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {


        Scanner scanner = new Scanner(System.in);
        String boringString = scanner.next();

        List<Integer> startIndexes = List.of(1, 5, 7, 11, 13);
        List<Integer> endIndexes = List.of(3, 5, 10, 12, 14);
        List<Operation> funOperations = List.of(
                new ReverseOperation(new CompressionOperation(new BaseClass())),
                new UpperCaseOperation((new BaseClass())),
                new CompressionOperation(new UpperCaseOperation(new SortingOperation(new BaseClass()))),
                new CompressionOperation(new BaseClass()),
                new ReverseOperation(new UpperCaseOperation(new CompressionOperation(new BaseClass())))

        );
        StringFunifier sd = new StringFunifier(boringString, startIndexes, endIndexes, funOperations);
        System.out.println(sd.getStringFunifier());

    }


}
