package com.giaphi.banks;

public abstract class BankAccount {
    protected String owner;
    protected double balance;
    
    public BankAccount(String owner, double balance) {
        this.owner = owner;
        this.balance = balance;
    }

    public abstract void notifyBalance();

    public void deposit(double amount) { // prevent invalid states
        if (amount > 0) {
            balance += amount;
            return;
        }
        System.out.println("Amount must be greater than 0.");      
    }

    public void withdraw(double amount) {
        if (balance > 0 && balance >= amount) {
            balance -= amount;
            return;
        }
        System.out.println("Account does not have enough balance.");
    }
}
