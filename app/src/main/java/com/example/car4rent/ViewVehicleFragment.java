package com.example.car4rent;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ViewVehicleFragment extends Fragment {
    public ViewVehicleFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_view_vehicle, container, false);
        Button vehiclelist = (Button) view.findViewById(R.id.b_viewVehicle);
        vehiclelist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),ViewVehicle.class);
                startActivity(intent);
            }
        });
        return view;
    }
}
   /* private RecyclerView myrecyclerview;
    private List<Vehicle> lstVehicle;

    public ViewVehicleFragment() {


    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_view_vehicle, container, false);
        myrecyclerview= v.findViewById(R.id.viewvehicle_recyclerview);
        ViewVehicleCustomerRecyclerViewAdapter recyclerViewAdapter= new ViewVehicleCustomerRecyclerViewAdapter(getContext(),lstVehicle);
        myrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrecyclerview.setAdapter(recyclerViewAdapter);
        return v;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lstVehicle = new ArrayList<>();
        lstVehicle.add(new Vehicle("Sedan","BMW","Series5",2019,"black","888 RAT",R.drawable.bmw_series5));
        lstVehicle.add(new Vehicle("Sedan","Audi","A4",2019,"Metallic Grey","898 CAT",R.drawable.audia4));
        lstVehicle.add(new Vehicle("Sedan","Honda","Civic",2019,"Blue","997 BOB",R.drawable.honda_civic));
        lstVehicle.add(new Vehicle("Sedan","Mazda","Mazda 3",2019,"Red","123 ABC",R.drawable.mazda3));
        lstVehicle.add(new Vehicle("Sedan","Nissan","Altima",2019,"Black","765 ADA",R.drawable.nissan_altima));
    }
}
*/
