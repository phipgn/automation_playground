package com.giaphi.banks;

public class CheckingAccount extends BankAccount {
    public double overdraftLimit;

    public CheckingAccount(String owner, double balance, double overdraftLimit) {
        super(owner, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) {
        if (balance - amount >= -overdraftLimit) {
            balance -= amount;
        } else {
            System.out.println("Withdrawal exceeds overdraft limit.");
        }
    }

    @Override
    public void notifyBalance() {
        System.out.println("My checking account's balance: " + balance);
    }
}
