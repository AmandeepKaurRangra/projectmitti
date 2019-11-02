package com.example.car4rent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    CustomerRepository customerRepository;
    EmployeeRepository employeeRepository;
    VehicleRepository vehicleRepositry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        customerRepository = CustomerRepository.getInstance();
        employeeRepository = EmployeeRepository.getInstance();
        vehicleRepositry = VehicleRepository.getInstance();
        createUsers();
        createVehicles();
        final Button b_Customer = findViewById(R.id.b_Customer);
        final Button b_Employee = findViewById(R.id.b_Employee);

        b_Customer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CustomerLogin.class);
                startActivity(intent);
            }
        });

        b_Employee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, EmployeeLogin.class);
                startActivity(intent);
            }
        });
    }

    private void createUsers() {
        Customer user = new Customer();
        user.firstName = "SANDEEP";
        user.lastName = "SINGH";
        user.role = "customer";
        user.password = "123";
        user.confirmPassword="123";
        user.userName = "sandy";

        customerRepository.addUser(user);

        Customer user2 = new Customer();
        user2.firstName = "Jaskaran";
        user2.lastName = "singh";
        user2.role = "customer";
        user2.password = "123";
        user2.userName = "jass";
        customerRepository.addUser(user2);


        Employee user1 = new Employee();
        user1.firstName = "Sahil";
        user1.lastName = "Rangra";
        user1.role = "employee";
        user1.password = "123";
        user1.userName = "sahil";
        employeeRepository.addUser(user1);


    }
    private void createVehicles() {
        Vehicle vehicle = new Vehicle();
        vehicle.brand = "BMW";
        vehicle.color = "black";
        vehicle.licencePlate = "E6h 789".toLowerCase();
        vehicle.model = "X6";
        vehicle.type = "SUV";
        vehicle.year = 2019;
        vehicleRepositry.addVehicle(vehicle);

        Vehicle vehicle1 = new Vehicle();
        vehicle1.brand = "AUDI";
        vehicle1.color = "black";
        vehicle1.licencePlate = "A22 789".toLowerCase();
        vehicle1.model = "A8";
        vehicle1.type = "Sedan";
        vehicle1.year = 2019;
        vehicleRepositry.addVehicle(vehicle1);
    }
}