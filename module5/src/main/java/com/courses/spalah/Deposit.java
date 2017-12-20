package com.courses.spalah;

class Deposit {
    private int startSummDeposit;
    private int rateProcent;
    private String nameClient;

    Deposit(int startSummDeposit, int rateProcent, String nameClient) {
        this.startSummDeposit = startSummDeposit;
        this.rateProcent = rateProcent;
        this.nameClient = nameClient;
    }

    double calculationDeposit(int yearsForDeposit) {
        double calculate = startSummDeposit * rateProcent * (yearsForDeposit * 365) / 365 / 100;

        return calculate;
    }
}