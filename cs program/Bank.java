package banka;
import banka.Bank;
import java.util.ArrayList;
import java.util.Scanner;
class BankAccount {

    private final int accountNumber;
    private double balance;

    public BankAccount(int anAccountNumber, double initialBalance) {
        accountNumber = anAccountNumber;
        balance = initialBalance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void deposit(double amount) {
        double newBalance = balance + amount;
        balance = newBalance;
    }

    public void withdraw(double amount) {
        double newBalance = balance - amount;
        balance = newBalance;
    }

    public double getBalance() {
        return balance;
    }
}

class Bank {

    private final ArrayList<BankAccount> accounts;

    public Bank() {
        accounts = new ArrayList<>();
    }

    public void addAccount(BankAccount a) {
        accounts.add(a);
    }

    public double getTotalBalance() {
        double total = 0;
        for (BankAccount a : accounts) {
            total = total + a.getBalance();
        }
        return total;
    }

    public int countBalancesAtLeast(double atLeast) {
        int matches = 0;
        for (BankAccount a : accounts) {
            if (a.getBalance() >= atLeast) {
                matches++;
            }
        }
        return matches;
    }

    public BankAccount find(int accountNumber) {
        for (BankAccount a : accounts) {
            if (a.getAccountNumber() == accountNumber) {
                return a;
            }
        }
        return null;
    }

    public BankAccount getMaximum() {
        if (accounts.size() == 0) {
            return null;
        }
        BankAccount largestYet = accounts.get(0);
        for (int i = 1; i < accounts.size(); i++) {
            BankAccount a = accounts.get(i);
            if (a.getBalance() > largestYet.getBalance()) {
                largestYet = a;
            }
        }
        return largestYet;
    }

    public BankAccount getMinimum() {
        if (accounts.size() == 0) {
            return null;
        }
        BankAccount leastYet = accounts.get(0);
        for (int i = 1; i < accounts.size(); i++) {
            BankAccount a = accounts.get(i);
            if (a.getBalance() < leastYet.getBalance()) {
                leastYet = a;
            }
        }
        return leastYet;
    }
}