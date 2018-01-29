package com.courses.spalah.myString;

public class Main {
    public static void main(String[] args) {
        MyString myString = new MyString('1', 'q', 'f', '3');

        myString.printSymbols();
        myString.reverseArraySymbols();
        myString.lengthArraySymbols();
        myString.getByIndex(0);
        myString.getByIndex(1);
        myString.getByIndex(3);
    }
}
