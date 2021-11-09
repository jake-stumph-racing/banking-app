package com.company;

import java.util.ArrayList;

public class Branch {

    private ArrayList<Customers> customers = new ArrayList<>();
    private String branchName;

    public Branch(String branchName){
        this.branchName = branchName;
    }

    public String getBranchName() {
        return branchName;
    }

    public ArrayList<Customers> getCustomers() {
        return customers;
    }

    public boolean addCustomer(String customerName, double initialAmount){
        if (findCustomer(customerName) == null){
            this.customers.add(new Customers(customerName, initialAmount));
            return true;
        }
        return false;
    }

    public boolean addTransaction(String customerName, double amount){
        Customers existingCustomer = findCustomer(customerName);
        if(existingCustomer != null){
            existingCustomer.addTransaction(amount);
            return true;
        }
        System.out.println(customerName + " not found.");
        return false;
    }

//    public double getBalance(String customerName){
//        double balance =
//        Customers existingCustomer = findCustomer(customerName);
//        if(existingCustomer != null){
////            existingCustomer.getTransactions();
//            for(int i = 0; i < existingCustomer.getTransactions().size(); i++){
//                balance += existingCustomer.getTransactions().get(i);
//            }
//            return balance;
//        }
//        return -1;
//    }

    public void printCustomerBalance(String customerName){
        Customers existingCustomer = findCustomer(customerName);
        System.out.println("Customer: " + existingCustomer.getName() + " has a balance of: " + existingCustomer.getBalance());
    }

    private Customers findCustomer(String customerName){
        for(int i = 0; i < customers.size(); i++){
            Customers checkedCustomer = this.customers.get(i);
            if(checkedCustomer.getName().equals(customerName)){
                return checkedCustomer;
            }
        }
        return null;
    }

}
