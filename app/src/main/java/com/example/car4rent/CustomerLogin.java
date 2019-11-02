package com.example.car4rent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CustomerLogin extends AppCompatActivity {
    CustomerRepository customerRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_login);
        //final ImageView loginImage = findViewById(R.id.iv_customerLogin);
        final EditText Username = findViewById(R.id.et_Username);
        final EditText Password = findViewById(R.id.et_Password);
        final CheckBox cb_RemPass = findViewById(R.id.cb_RemPass);
        final Button b_Login = findViewById(R.id.b_Login);
        final Button b_SignUp = findViewById(R.id.b_SignUp);
        final TextView tv_ForgotPass = findViewById(R.id.tv_ForgotPass);
        final Button b_Click = findViewById(R.id.b_click);
        customerRepository = CustomerRepository.getInstance();

        b_SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(CustomerLogin.this, CustomerSignUp.class);
                startActivity(intent);
            }
        });
        b_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String User = Username.getText().toString();
                String Pass = Password.getText().toString();
                int i = 0;
                boolean userFind = false;
                if (customerRepository.getUsers().containsKey(User)) {
                    Customer user = customerRepository.getUsers().get(User);
                    if (user.password.equals(Pass)) {
                        if (user.role.equalsIgnoreCase("customer")) {

                            Intent intent = new Intent(CustomerLogin.this, CustomerHomePage.class);
                            startActivity(intent);
                        }
                    } else {
                        Toast.makeText(CustomerLogin.this, "Wrong Password", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(CustomerLogin.this, "Wrong UserName", Toast.LENGTH_LONG).show();
                }

                if (customerRepository.getUsers().containsKey(User)) {
                    Customer user2 = customerRepository.getUsers().get(User);
                    if (user2.password.equals(Pass)) {
                        if (user2.role.equalsIgnoreCase("customer")) {

                            Intent intent = new Intent(CustomerLogin.this, LogInClickActivity.class);
                            startActivity(intent);
                        }
                    } else {
                        Toast.makeText(CustomerLogin.this, "Wrong Password", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(CustomerLogin.this, "Wrong UserName", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}