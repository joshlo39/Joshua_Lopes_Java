package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    private static List<String[]> customerData  = Arrays.asList(
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"},
            new String[] {"2","Daily Planet","-7500","01-10-2022"},
            new String[] {"1","Wayne Enterprises","18000","12-22-2021"},
            new String[] {"3","Ace Chemical","-48000","01-10-2022"},
            new String[] {"3","Ace Chemical","-95000","12-15-2021"},
            new String[] {"1","Wayne Enterprises","175000","01-01-2022"},
            new String[] {"1","Wayne Enterprises","-35000","12-09-2021"},
            new String[] {"1","Wayne Enterprises","-64000","01-17-2022"},
            new String[] {"3","Ace Chemical","70000","12-29-2022"},
            new String[] {"2","Daily Planet","56000","12-13-2022"},
            new String[] {"2","Daily Planet","-33000","01-07-2022"},
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"},
            new String[] {"2","Daily Planet","33000","01-17-2022"},
            new String[] {"3","Ace Chemical","140000","01-25-2022"},
            new String[] {"2","Daily Planet","5000","12-12-2022"},
            new String[] {"3","Ace Chemical","-82000","01-03-2022"},
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"}
    );

    //--------------------------PLAN---------------------------------
    //create a list for all customers
    //iterate through customerData and check if it is already in the list
    //if it is already in the only add account record to that customer
    // if it is not unique, create a new customer and add it to the list. Also add the account record to that customer


    public static void main(String[] args) {
        List<Customer> allCustomers = new ArrayList<>();
        for (String[] data : customerData) {
            int id = Integer.parseInt(data[0]);
            String name = data[1];
            int charge = Integer.parseInt(data[2]);
            String date = data[3];
            boolean customerExists = false;


            for (Customer customer : allCustomers) {
                if (customer.getId() == id) {
                    customerExists = true;
                    AccountRecord accountRecord = new AccountRecord(charge, date);
                    customer.getCharges().add(accountRecord);
                    break;
                }
            }

            if (!customerExists) {
                Customer newCustomer = new Customer(id, name);
                AccountRecord accountRecord = new AccountRecord(charge, date);
                newCustomer.getCharges().add(accountRecord);
                allCustomers.add(newCustomer);
            }
        }

        System.out.println("All Customers:" );
        for(Customer customer : allCustomers){
            System.out.println(customer);
        }


        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("Negative Accounts: " );
        //prints out all negative accounts
        List<Customer> negativeAccounts = allCustomers.stream().filter(customer -> customer.getBalance() < 0).collect(Collectors.toList());
        for (Customer customer : negativeAccounts) {System.out.println(customer);}

        //prints out all negative accounts
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("Positive Accounts: ");
        List<Customer> positiveAccounts = allCustomers.stream().filter(customer -> customer.getBalance() > 0).collect(Collectors.toList());
        for (Customer customer : positiveAccounts) {System.out.println(customer);}

    }
}


