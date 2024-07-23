package main.interafces.Impl;

import main.interafces.Operation;

public class BaseClass implements Operation {


    @Override
    public StringBuilder transform(StringBuilder substring) {
        return substring;
    }
}
