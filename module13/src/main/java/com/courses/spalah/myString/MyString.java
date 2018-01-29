package com.courses.spalah.myString;

public class MyString {
    private char[] arraySymbols;

    public MyString(char ... symbols) {
        this.arraySymbols = new char[symbols.length];

        for (int i = 0; i < symbols.length; i++) {
            arraySymbols[i] = symbols[i];
        }
    }

    public void printSymbols() {
        String printSymbols = new String(arraySymbols);
        System.out.println("Input data: " + printSymbols);
    }

    public void reverseArraySymbols() {
        String reverse = new StringBuilder(new String(arraySymbols)).reverse().toString();
        System.out.println("Reverse input data: " + reverse);
    }

    public int lengthArraySymbols() {
        return arraySymbols.length;
    }

    public char getByIndex(int index) {
        return arraySymbols[index];
    }
}
