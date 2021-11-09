package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Bank bank = new Bank("Chase");
        bank.addBranch("Pasadena");
        bank.addCustomer("Pasadena", "Jake", 5678.90);
        bank.addCustomer("Pasadena", "Carrie", 6789.0);
        bank.addCustomer("Pasadena", "Dewie", 5);

        bank.addBranch("Los Angeles");
        bank.addCustomer("Los Angeles", "Abe", 4.5);

        bank.addTransaction("Pasadena", "Jake", 44.56);
        bank.addTransaction("Pasadena", "Jake", 64.56);
        bank.addTransaction("Pasadena", "Carrie", 4456.67);

        bank.customerList("Pasadena", true);

        bank.addBranch("Melbourne");

        if(!bank.addCustomer("Melbourne", "Brian", 5.5)){
            System.out.println("Error Melbourne branch doesn't exist");
        }

        bank.printBranchCustomer("Pasadena", "Jake");

//        bank.getBalance("Pasadena", "Jake");
    }
}
