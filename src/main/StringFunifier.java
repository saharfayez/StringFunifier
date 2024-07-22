package main;

import java.util.*;
import java.util.concurrent.*;

public class StringFunifier {


    String boringString;
    List<Integer> startIndexes = new ArrayList<>();
    List<Integer> endIndexes = new ArrayList<>();
    List<Operation> funOperations = new ArrayList<>();

    public StringFunifier(String boringString, List<Integer> startIndexes, List<Integer> endIndexes, List<Operation> funOperations) {

        this.boringString = boringString;
        this.startIndexes = startIndexes;
        this.endIndexes = endIndexes;
        this.funOperations = funOperations;


    }

    public String getStringFunifier() throws InterruptedException, ExecutionException {
        StringBuilder result = new StringBuilder();
        int lastEnd = 0;

        List<Future<StringBuilder>> operationThreads = startThreadsForOperations();
        for (int i = 0; i < startIndexes.size(); i++) {
            int start = startIndexes.get(i);
            int end = endIndexes.get(i);

            result.append(boringString, lastEnd, start);

            StringBuilder boringSubString = new StringBuilder(boringString.substring(start, end + 1));
            StringBuilder subStringOperationThread = operationThreads.get(i).get();

            result.append('(').append(subStringOperationThread).append(')');

            lastEnd = end + 1;
        }

        result.append(boringString.substring(lastEnd));

        return result.toString();
    }

    public List<Future<StringBuilder>> startThreadsForOperations() throws InterruptedException {

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Vector<Callable<StringBuilder>> callables = new Vector<Callable<StringBuilder>>(5);
        for (int i = 0; i < startIndexes.size(); i++) {
            int start = startIndexes.get(i);
            int end = endIndexes.get(i);

            StringBuilder boringSubString = new StringBuilder(boringString.substring(start, end + 1));


            int finalI1 = i;
            callables.add(new Callable<StringBuilder>() {
                public StringBuilder call() throws Exception {
                    StringBuilder result = funOperations.get(finalI1).transform(boringSubString);
                    return result;

                }
            });


        }
        java.util.List<Future<StringBuilder>> futures = executorService.invokeAll((callables));
        executorService.shutdown();

        return futures;

    }


}

