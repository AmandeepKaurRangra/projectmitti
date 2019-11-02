package com.example.car4rent;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EmployeeRepository {
    private static EmployeeRepository instance = null;
    private Map<String, Employee> users = new HashMap<>();

    private EmployeeRepository(){}

    public static EmployeeRepository getInstance() {
        if (instance == null) {
            instance = new EmployeeRepository();
        }
        return instance;
    }

    public  void addUser(Employee user1) {
        this.users.put(user1.userName, user1);
    }

    public  Map<String, Employee> getUsers() {
        return this.users;
    }

    public void deleteUser(String userName){
        users.remove(userName);
    }

    public Employee getUser(String userName){
        return users.get(userName);
    }
    public Map<String, Employee> getEmployees(){
        Map<String, Employee> userEmployee = new HashMap<>();
        ArrayList<String> userNames = new ArrayList<>(instance.users.keySet());
        for(int i = 0; i < userNames.size(); i++){
            if(instance.users.get(userNames.get(i)).role.equalsIgnoreCase("employee")){
                userEmployee.put(userNames.get(i), instance.users.get(userNames.get(i)));
            }
        }
        return userEmployee;
    }
}