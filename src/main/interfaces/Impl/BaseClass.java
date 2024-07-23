package main.interfaces.Impl;

import main.interfaces.Operation;

public class BaseClass implements Operation {


    @Override
    public StringBuilder transform(StringBuilder substring) {
        return substring;
    }
}
