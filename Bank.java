package com.company;

import java.util.ArrayList;

public class Bank {

    ArrayList<Branch> branches = new ArrayList<>();
    private String name;

    public Bank(String name){
        this.name = name;

    }


    public boolean addBranch(String branchName){

        if(findBranch(branchName) == null){
            this.branches.add(new Branch(branchName));
            return true;
        }
        return false;
    }

    private Branch findBranch(String branchName){
        for(int i = 0; i < branches.size(); i++){
            Branch checkedBranch = this.branches.get(i);
            if(checkedBranch.getBranchName().equals(branchName)){
                return checkedBranch;
            }
        }
        return null;
    }

    public boolean addCustomer(String branchName, String customerName, double initialAmount){

        Branch branch = findBranch(branchName);
        if(branch != null){
            return branch.addCustomer(customerName, initialAmount);
        }
        return false;
    }

    public boolean addTransaction(String branchName, String customerName, double amount){
        Branch branch = findBranch(branchName);
        if(branch != null){
            return branch.addTransaction(customerName, amount);
        }
        return false;
    }

//    public double getBalance(String branchName, String customerName){
//        Branch branch = findBranch(branchName);
//        if(branch != null){
//            return branch.getBalance(customerName);
//        }
//        return -1;
//    }

    public void printBranchCustomer(String branchName, String customerName){
        findBranch(branchName).printCustomerBalance(customerName);
    }



    public boolean customerList(String branchName, boolean showTransactions) {
        Branch branch = findBranch(branchName);
        if (branch != null) {
            System.out.println("Customer details for branch " + branch.getBranchName());
            ArrayList<Customers> branchCustomers = branch.getCustomers();
            for (int i = 0; i < branchCustomers.size(); i++) {
                Customers branchCustomer = branchCustomers.get(i);
                System.out.println("Customer: " + branchCustomer.getName() + "[" + (i + 1) + "]");
                if (showTransactions) {
                    System.out.println("Transactions");
                    ArrayList<Double> transactions = branchCustomer.getTransactions();
                    for (int j = 0; j < transactions.size(); j++) {
                        System.out.println("[" + (j + 1) + "] Amount " + transactions.get(j));
                    }
                }
            }
            return true;

        } else {
            return false;
        }
    }

}
