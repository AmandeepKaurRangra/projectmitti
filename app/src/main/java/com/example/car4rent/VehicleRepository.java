package com.example.car4rent;

import java.util.HashMap;
import java.util.Map;

public class VehicleRepository {
    private static VehicleRepository instance;
    private Map<String, Vehicle> vehicles = new HashMap<>();

    private VehicleRepository(){}

    public static VehicleRepository getInstance(){
        if(instance == null){
            instance = new VehicleRepository();
        }
        return instance;
    }

    public void addVehicle(Vehicle vehicle){
        vehicles.put(vehicle.licencePlate, vehicle);
    }

    public Map<String, Vehicle> getVehicles(){
        return vehicles;
    }

    public void removeVehicle(String license){
        instance.vehicles.remove(license.toLowerCase());
    }
}

