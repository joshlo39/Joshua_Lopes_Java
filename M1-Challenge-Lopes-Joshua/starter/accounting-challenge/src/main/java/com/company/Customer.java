package com.company;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private int id;
    private String name;
    private List<AccountRecord> charges = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //default
    public Customer(){}

    //overriden constructor
    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
    }
    //made this method to add charges to balance
    public int getBalance() {
        int balancePerCustomer = 0;
        for(AccountRecord charge : charges){
            balancePerCustomer += charge.getCharge();
        }
        return balancePerCustomer;
    }
    public int getId(int id){
        return id;
    }
    public List<AccountRecord> getCharges() {
        return charges;
    }

    @Override
    public String toString() {
        //update this
        return "Customer Name: " + this.name + "\t\tCustomerId: " + this.id + "\t\tBalance: " + this.getBalance();
    }
}
