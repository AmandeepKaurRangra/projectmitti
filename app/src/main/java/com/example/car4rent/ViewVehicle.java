package com.example.car4rent;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Intent;
import android.os.Bundle;


import java.util.ArrayList;
import java.util.Map;

public class ViewVehicle extends AppCompatActivity {
    Intent intent;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    VehicleRepository vehicleRepositry;
    Map<String, Vehicle> vehicleMap;
    ArrayList<String> arrayList;
    String user, startDate, endDate, mode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_vehicle);

        intent = getIntent();
        user = intent.getStringExtra("user");
        startDate = intent.getStringExtra("startDate");
        endDate = intent.getStringExtra("endDate");
        mode = ""+intent.getStringExtra("mode");

        if(startDate!=null && endDate!=null && !startDate.equals("") && !endDate.equals("")){

        }

        recyclerView = findViewById(R.id.rvVehicleListClient1);

        vehicleRepositry = VehicleRepository.getInstance();
        vehicleMap = vehicleRepositry.getVehicles();
        arrayList = new ArrayList<>(vehicleMap.keySet());

        for(int i = 0; i< arrayList.size(); i++){
            Vehicle vehicle = vehicleMap.get(arrayList.get(i));
        }

        ViewVehicleCustomerRecyclerViewAdapter vehicleListEmployeeRecyclerViewAdapter = new ViewVehicleCustomerRecyclerViewAdapter(this, vehicleRepositry.getVehicles(), mode, user, startDate, endDate);
        recyclerView.setAdapter(vehicleListEmployeeRecyclerViewAdapter);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }

}

