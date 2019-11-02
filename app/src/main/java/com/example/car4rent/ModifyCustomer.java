package com.example.car4rent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ModifyCustomer extends AppCompatActivity {
  /* EditText etFirstName;
    EditText etLastName;
    EditText etUserName;
    EditText etPassword;
    Button btnModify;
    Intent intent;
    String userName;
    CustomerRepository customerRepository; */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_customer);

          /* btnModify = findViewById(R.id.bt_Modifycs);
            etFirstName = findViewById(R.id.et_csFirstName);
            etLastName = findViewById(R.id.et_csLastName);
            etUserName = findViewById(R.id.et_csUsername);
            etPassword = findViewById(R.id.et_csPassword);

            customerRepository = CustomerRepository.getInstance();

            intent = getIntent();
            userName = intent.getStringExtra("username").toLowerCase();
            Customer user = customerRepository.getUser(userName.toLowerCase());
            if (user != null) {
                etFirstName.setText(user.firstName);
                etLastName.setText(user.lastName);
                etUserName.setText(user.userName);
            }


            btnModify.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String fName, lName, uName, password;
                    fName = etFirstName.getText().toString();
                    lName = etLastName.getText().toString();
                    uName = etUserName.getText().toString().toLowerCase();
                    password = etPassword.getText().toString();
                    if (fName.equals("") || lName.equals("") || uName.equals("") || password.equals("")) {
                        Toast.makeText(ModifyCustomer.this, "Please enter all credentials!!!", Toast.LENGTH_LONG).show();
                    } else {
                        Customer user = new Customer();
                        user.firstName = fName;
                        user.lastName = lName;
                        user.userName = uName;
                        user.password = password;
                        user.role = "customer";
                        customerRepository.deleteUser(userName);
                        customerRepository.addUser(user);
                        Intent intent = new Intent(ModifyCustomer.this, LogInClickActivity.class);
                        startActivity(intent);
                        ModifyCustomer.this.finish();
                    }
                }
            });
        } */
    }

}

