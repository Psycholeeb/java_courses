package com.courses.spalah;

/**
 * @author Ievgen Tararaka
 */
public class Strings {
    public static void main(String[] args) {
        // создание
        String vasya = "Василий";

        String petya = new String("Петя");

        // конкатенация строк

        String vasyaAndPetya = vasya + " " + petya;

        // методы для класса String
        vasyaAndPetya.length();
        vasyaAndPetya.isEmpty();
        vasyaAndPetya.toLowerCase();
        vasyaAndPetya.toUpperCase();
        vasyaAndPetya.charAt(0);
        vasyaAndPetya.contains("a");
        vasyaAndPetya.startsWith("b");
        vasyaAndPetya.endsWith("c");
        vasyaAndPetya.indexOf("d");
        vasyaAndPetya.replace("e", "f");
        vasyaAndPetya.split("");
        vasyaAndPetya.substring(0, 10);
        vasyaAndPetya.trim();
    }
}
