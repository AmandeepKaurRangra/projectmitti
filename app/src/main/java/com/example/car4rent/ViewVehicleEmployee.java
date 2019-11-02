package com.example.car4rent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

public class ViewVehicleEmployee extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    VehicleRepository vehicleRepositry;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_vehicle_employee);
        recyclerView = findViewById(R.id.rvVehicleListEmployee1);

        vehicleRepositry = VehicleRepository.getInstance();

        ViewVehicleEmployeeRecyclerViewAdapter ViewVehicleEmployeeRecyclerViewAdapter = new ViewVehicleEmployeeRecyclerViewAdapter(this, vehicleRepositry.getVehicles());
        recyclerView.setAdapter(ViewVehicleEmployeeRecyclerViewAdapter);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }
}