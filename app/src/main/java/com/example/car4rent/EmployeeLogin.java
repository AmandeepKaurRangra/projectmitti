package com.example.car4rent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EmployeeLogin extends AppCompatActivity {
    EmployeeRepository employeeRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_login);
        final EditText Username = findViewById(R.id.et_EmpId);
        final EditText Password = findViewById(R.id.et_EmpPass);
        final CheckBox cb_RemPass = findViewById(R.id.cb_EmpRemPass);
        final Button b1_Login = findViewById(R.id.b_EmpLogIn);
        final TextView tv_ForgotPass = findViewById(R.id.tv_ForgotPass);
        final Button b1_Click = findViewById(R.id.b_EmpClickHere);
        employeeRepository = EmployeeRepository.getInstance();
        b1_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String User1 = Username.getText().toString();
                String Pass1 = Password.getText().toString();
                int i = 0;
                boolean userFind = false;
                if (employeeRepository.getUsers().containsKey(User1)) {
                    Employee user1 = employeeRepository.getUsers().get(User1);
                    if (user1.password.equals(Pass1)) {
                        if (user1.role.equalsIgnoreCase("employee")) {

                            Intent intent = new Intent(EmployeeLogin.this, LogInClickActivity.class);
                            startActivity(intent);
                        } else if (user1.role.equalsIgnoreCase("employee")) {

                            Intent intent = new Intent(EmployeeLogin.this, LogInClickActivity.class);
                            startActivity(intent);
                        }
                    } else {
                        Toast.makeText(EmployeeLogin.this, "Invalid User Credentials", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(EmployeeLogin.this, "Invalid User Credentials", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
