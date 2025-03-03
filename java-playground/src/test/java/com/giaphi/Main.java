package com.giaphi;

import java.util.Arrays;
import java.util.Random;

import com.giaphi.banks.BankAccount;
import com.giaphi.banks.CheckingAccount;
import com.giaphi.banks.SavingsAccount;
import com.giaphi.humans.People;

public class Main {
    public static void main(String[] args) {
        // var account1 = new BankAccount("Phi", 10000);
        BankAccount account1 = new SavingsAccount("Phi", 10000, 3.5);
        BankAccount account2 = new CheckingAccount("Phi", 10000, 3.5);
        // account1.deposit(1000);
        // account1.applyInterest();
        // account1.applyInterest(0.5);
        // account1.applyInterest(1);
        // account1.notifyBalance();
    }
}
