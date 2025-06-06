package com.giaphi.banks;

public class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String owner, double balance, double interestRate) {
        super(owner, balance);
        this.interestRate = interestRate;
    }

    public void applyInterest() { // business logic
        balance += balance * interestRate;
    }

    public void applyInterest(double x) {
        balance += balance * x;
    }

    public void applyInterest(int x) {
        balance += balance * x;
    }

    @Override
    public void notifyBalance() {
        System.out.println("My savings account's balance: " + balance);
    }
}
