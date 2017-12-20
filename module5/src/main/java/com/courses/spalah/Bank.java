package com.courses.spalah;

class Bank {
    private String bankName;
    private Deposit depositFirst;
    private Deposit depositSecond;
    private Deposit depositThird;

    Bank(String bankName) {
        this.bankName = bankName;
        this.depositFirst = new Deposit(1000, 12, "Vladislav");
        this.depositSecond = new Deposit(200, 3, "Dmitry");
        this.depositThird = new Deposit(3500, 14, "Anna");
    }

    double getDeposit() {
        double amountPayment = depositFirst.calculationDeposit(3)
                + depositSecond.calculationDeposit(1) + depositThird.calculationDeposit(5);

        return amountPayment;
    }

    public String getBankName() {
        return bankName;
    }
}