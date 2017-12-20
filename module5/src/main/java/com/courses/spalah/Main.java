package com.courses.spalah;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank("Private Bank");
        System.out.print("Total summ of procent deposit in " + bank.getBankName() + ": " + bank.getDeposit() + "$");
    }
}
