package com.example.car4rent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CustomerRepository {
    private static CustomerRepository instance = null;
    private Map<String, Customer> users = new HashMap<>();

    private CustomerRepository(){}

    public static CustomerRepository getInstance() {
        if (instance == null) {
            instance = new CustomerRepository();
        }
        return instance;
    }

    public  void addUser(Customer user) {
        this.users.put(user.userName, user);
    }

    public  Map<String, Customer> getUsers() {
        return this.users;
    }

    public void deleteUser(String userName){
        users.remove(userName);
    }

    public Customer getUser(String userName){
        return users.get(userName);
    }
    public Map<String, Customer> getCustomers(){
        Map<String, Customer> userCustomer = new HashMap<>();
        ArrayList<String> userNames = new ArrayList<>(instance.users.keySet());
        for(int i = 0; i < userNames.size(); i++){
            if(instance.users.get(userNames.get(i)).role.equalsIgnoreCase("customer")){
                userCustomer.put(userNames.get(i), instance.users.get(userNames.get(i)));
            }
        }
        return userCustomer;
    }
}

