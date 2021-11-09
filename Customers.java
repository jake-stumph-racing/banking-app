package com.company;

import java.util.ArrayList;

public class Customers {

    private ArrayList<Double> transactions = new ArrayList<>();
    private String name;
    private double balance;

    public Customers(String name, double initialAmount) {
        this.name = name;
        addTransaction(initialAmount);
        this.balance = balance;
    }

    public void addTransaction(double amount){
        this.transactions.add(amount);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }

    public double getBalance(){
        double balance = 0;
        for(int i = 0; i < transactions.size(); i++){
            balance += transactions.get(i);
        }
//        for(Double transaction : transactions){
//            balance += transaction;
//        }
        return balance;
    }
}
