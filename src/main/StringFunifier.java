package main;

import java.util.ArrayList;
import java.util.List;

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

    public String getStringFunifier() {
        StringBuilder result = new StringBuilder();
        int lastEnd = 0;

        /*
        for each range
        do operation.transform(range.start, range.end)
        surround with ()
        return awesome funny string
         */

        for (int i = 0; i < startIndexes.size(); i++) {
            int start = startIndexes.get(i);
            int end = endIndexes.get(i);
            // String operation = funOperations.get(i);

            result.append(boringString, lastEnd, start);


            StringBuilder builder = new StringBuilder(boringString.substring(start, end + 1));

            funOperations.get(i).transform(builder);

            result.append('(').append(builder).append(')');


            lastEnd = end + 1;
        }


        result.append(boringString.substring(lastEnd));

        return result.toString();
    }

}
