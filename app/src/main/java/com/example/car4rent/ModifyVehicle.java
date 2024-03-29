package com.example.car4rent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class ModifyVehicle extends AppCompatActivity {
    Spinner brandSpinner, typeSpinner;
    EditText etColor, etModel, etYear, etLicencePlate;
    Button modifyVehicle;
    String type, brand;
    int brandPosition, typePosition;
    VehicleRepository vehicleRepositry;
    ArrayList<String> brands, types;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_vehicle);

        intent = getIntent();
        String license = intent.getStringExtra("license").toLowerCase();

        brandSpinner = findViewById(R.id.spinnerBrandModifyVehicle);
        typeSpinner = findViewById(R.id.spinnerTypeModifyVehicle);
        etColor = findViewById(R.id.etColorModifyVehicle);
        etModel = findViewById(R.id.etModelModifyVehicle);
        etYear = findViewById(R.id.etYearModifyVehicle);
        etLicencePlate = findViewById(R.id.etPlateNumberModifyVehicle);
        modifyVehicle = findViewById(R.id.btnModifyVehicle);

        vehicleRepositry = VehicleRepository.getInstance();

        setTypes();
        setBrands();
        ArrayAdapter<String> adapterBrands = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, brands);
        ArrayAdapter<String> adapterTypes = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, types);
        adapterBrands.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterTypes.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        brandSpinner.setAdapter(adapterBrands);
        typeSpinner.setAdapter(adapterTypes);

        Vehicle vehicle = vehicleRepositry.getVehicles().get(license);
        etLicencePlate.setText(vehicle.licencePlate);
        etColor.setText(vehicle.color);
        etModel.setText(vehicle.model);
        etYear.setText(""+vehicle.year);
        brandSpinner.setSelection(adapterBrands.getPosition(vehicle.brand));
        typeSpinner.setSelection(adapterTypes.getPosition(vehicle.type));


        modifyVehicle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String model = etModel.getText().toString();
                String year = etYear.getText().toString();
                String color = etColor.getText().toString();
                String licenceNumber = etLicencePlate.getText().toString();
                if(brandPosition != 0 || typePosition != 0 || !model.equals("") || !year.equals("") || !color.equals("") || !licenceNumber.equals("")){
                    Vehicle vehicle = new Vehicle();
                    vehicle.year = Integer.parseInt(year);
                    vehicle.type = type;
                    vehicle.model = model;
                    vehicle.licencePlate = licenceNumber.toLowerCase();
                    vehicle.color = color;
                    vehicle.brand = brand;
                    vehicleRepositry.addVehicle(vehicle);
                    Toast.makeText(ModifyVehicle.this, "Vehicle modified successfully.", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(ModifyVehicle.this, ViewVehicleEmployee.class);
                    startActivity(intent);
                    ModifyVehicle.this.finish();
                }
                else {
                    Toast.makeText(ModifyVehicle.this, "Fill all credentials!!!", Toast.LENGTH_LONG).show();
                }
            }
        });

        typeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                type = typeSpinner.getItemAtPosition(position).toString();
                typePosition = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        brandSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                brand = brandSpinner.getItemAtPosition(position).toString();
                brandPosition = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void setBrands(){
        brands = new ArrayList<>();
        brands.add("Select Brand");
        brands.add("Audi");
        brands.add("BMW");
        brands.add("Ford");
        brands.add("Honda");
        brands.add("Hyundai");
        brands.add("Kia");
        brands.add("Mazda");
        brands.add("Mercedes");
        brands.add("Nissan");
        brands.add("Porsche");
        brands.add("Subaru");
        brands.add("Toyota");
        brands.add("Volkswagen");
        brands.add("Volvo");
    }

    public void setTypes(){
        types = new ArrayList<>();
        types.add("Select Type");
        types.add("Hatchback");
        types.add("Sedan");
        types.add("MPV");
        types.add("SUV");
        types.add("Crossover");
        types.add("Coupe");
        types.add("Convertible");
    }
}

