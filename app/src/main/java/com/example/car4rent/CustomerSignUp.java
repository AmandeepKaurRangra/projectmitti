package com.example.car4rent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class CustomerSignUp extends AppCompatActivity {
    CustomerRepository customerRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_sign_up);

        final EditText FirstName = findViewById(R.id.et_FirstName);
        final EditText LastName = findViewById(R.id.et_LastName);
        final EditText EmailId = findViewById(R.id.et_SignUpEmail);
        final EditText Password = findViewById(R.id.et_SignUpPass);
        final EditText confirmpassword = findViewById(R.id.et_ConfirmPass);
        final EditText phone = findViewById(R.id.et_PhoneNumber);
        final Button Submit = findViewById(R.id.b_Submit);
        customerRepository = CustomerRepository.getInstance();

        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fName, lName, uName, password, confirmPassword;
                fName = FirstName.getText().toString();
                lName = LastName.getText().toString();
                uName = EmailId.getText().toString().toLowerCase();
                password = Password.getText().toString();
                confirmPassword = confirmpassword.getText().toString();
                if (fName.equals("") || lName.equals("") || uName.equals("") || password.equals("") || confirmPassword.equals("")) {
                    Toast.makeText(CustomerSignUp.this, "Fill all the credentials", Toast.LENGTH_SHORT).show();
                } else {
                    if (!customerRepository.getUsers().containsKey(uName)) {
                        Customer user = new Customer();
                        user.firstName = fName;
                        user.lastName = lName;
                        user.userName = uName;
                        user.password = password;
                        user.confirmPassword = confirmPassword;
                        user.role = "customer";
                        customerRepository.addUser(user);
                        FirstName.setText("");
                        LastName.setText("");
                        Password.setText("");
                        confirmpassword.setText("");
                        EmailId.setText("");
                        Toast.makeText(CustomerSignUp.this, "Customer Added successfully", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(CustomerSignUp.this, "UserName already exists", Toast.LENGTH_SHORT).show();
                    }
                }
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(CustomerSignUp.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }

                }, 2000);
            }
        });
    }
}
/*
    CustomerRepository customerRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_customer);
        etFirstName = findViewById(R.id.etModelModifyVehicle);
        etLastName = findViewById(R.id.spinnerTypeModifyVehicle);
        etUserName = findViewById(R.id.etYearModifyVehicle);
        etPassword = findViewById(R.id.etColorModifyVehicle);

        addCustomer = findViewById(R.id.btnAddCustomer);
        customerRepository = CustomerRepository.getInstance();
        addCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fName, lName, uName, password;
                fName = etFirstName.getText().toString();
                lName = etLastName.getText().toString();
                uName = etUserName.getText().toString().toLowerCase();
                password = etPassword.getText().toString();
                if(fName.equals("") || lName.equals("") || uName.equals("") || password.equals("")){
                    Toast.makeText(AddCustomer.this, "Fill all the credentials", Toast.LENGTH_SHORT).show();
                }
                else{
                    if(!userRepository.getUsers().containsKey(uName)){
                        User user = new User();
                        user.firstName = fName;
                        user.lastName = lName;
                        user.userName = uName;
                        user.password = password;
                        user.role = "client";
                        userRepository.addUser(user);
                        etFirstName.setText("");
                        etLastName.setText("");
                        etPassword.setText("");
                        etUserName.setText("");
                        Toast.makeText(AddCustomer.this, "Customer Added successfully", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(AddCustomer.this, "UserName already exists", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}*/