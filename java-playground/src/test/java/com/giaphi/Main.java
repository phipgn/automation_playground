package com.giaphi;

import java.util.Arrays;
import java.util.Random;

import com.giaphi.banks.BankAccount;
import com.giaphi.banks.CheckingAccount;
import com.giaphi.banks.SavingsAccount;
import com.giaphi.humans.People;

public class Main {
    public static void main(String[] args) {
        var savingsAccount = new SavingsAccount("Kien", 1000, 3.5);
        System.out.println(savingsAccount.getBalance());
        // account.withdraw(999);
        // savingsAccount.deposit(0);
        // System.out.println(savingsAccount.getBalance());

        // savingsAccount.applyInterest();
        // System.out.println(savingsAccount.getBalance());

        var checkingAccount = new CheckingAccount("Kien", 1000, 200);
        checkingAccount.deposit(2000);
        System.out.println(checkingAccount.getBalance());
        checkingAccount.withdraw(201);
        System.out.println(checkingAccount.getBalance());
    }
}
