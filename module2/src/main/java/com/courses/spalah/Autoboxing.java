package com.courses.spalah;

/**
 * @author Ievgen Tararaka
 */
public class Autoboxing {
    public static void main(String[] args) {
        // до 5-й Java нужно было делать так
        Integer integer = new Integer(100);
        int intValue = integer.intValue();

        // после 5-й Java
        Integer integer2 = new Integer(200); // unboxing
        int intValue2 = integer2;

        int intValue3 = 300;
        Integer integer3 = intValue3; // boxing
    }
}
