package com.giaphi.banks;

public class BankAccount {
    // Encapsulation --> hiding data, control access
    private String owner;
    protected double balance;
    
    // setter getter
    public BankAccount(String owner, double balance) {
        this.owner = owner;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

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
