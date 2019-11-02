package com.example.car4rent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class EmployeeHomePage extends AppCompatActivity {
    ArrayList<String> arrayList;
    RecyclerView recycleView;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_home_page);
        final ImageView img= findViewById(R.id.iv_image);
        final TextView username= findViewById(R.id.tv_username1);
        recycleView = findViewById(R.id.rc_emprecycleview);
        layoutManager = new LinearLayoutManager(this);
        recycleView.setLayoutManager(layoutManager);
        arrayList = new ArrayList<>();

        arrayList.add("Add New Customer");
        arrayList.add("List of Customer");
        arrayList.add("Add New Vehicle");
        arrayList.add("List of Vehicle");
        arrayList.add("List of Reservations");
        arrayList.add("Logout");


        EmployeeHomePageRecycleAdapter recyclerViewAdapter = new EmployeeHomePageRecycleAdapter(this, arrayList);
        recycleView.setAdapter(recyclerViewAdapter);
    }
}

