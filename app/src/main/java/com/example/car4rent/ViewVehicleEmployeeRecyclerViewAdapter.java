package com.example.car4rent;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Map;

public class ViewVehicleEmployeeRecyclerViewAdapter extends RecyclerView.Adapter<ViewVehicleEmployeeRecyclerViewAdapter.ViewHolder> {
        LayoutInflater layoutInflater;
        Context context;
        Map<String, Vehicle> vehicleMap;
        ArrayList<String> licenceNumbers;

public ViewVehicleEmployeeRecyclerViewAdapter(Context context, Map<String, Vehicle> vehicleMap) {
        this.context = context;
        this.vehicleMap = vehicleMap;
        layoutInflater = LayoutInflater.from(context);
        licenceNumbers = new ArrayList<>(vehicleMap.keySet());
        }

@NonNull
@Override
public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.vehicle_list, parent, false);
        return new ViewHolder(view);
        }

@Override
public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
final String license = licenceNumbers.get(position);
        holder.tvBrand.setText(vehicleMap.get(license).brand);
        holder.tvModel.setText(vehicleMap.get(license).model);
        String brand = vehicleMap.get(license).brand.toLowerCase();
        switch (brand) {
        case "audi":
        holder.imageView.setImageResource(R.drawable.volvo);
        break;
        case "bmw":
        holder.imageView.setImageResource(R.drawable.volvo);
        break;
        case "ford":
        holder.imageView.setImageResource(R.drawable.volvo);
        break;
        case "honda":
        holder.imageView.setImageResource(R.drawable.volvo);
        break;
        case "hyundai":
        holder.imageView.setImageResource(R.drawable.volvo);
        break;
        case "kia":
        holder.imageView.setImageResource(R.drawable.volvo);
        break;
        case "mazda":
        holder.imageView.setImageResource(R.drawable.volvo);
        break;
        case "mercedes":
        holder.imageView.setImageResource(R.drawable.volvo);
        break;
        case "nissan":
        holder.imageView.setImageResource(R.drawable.volvo);
        break;
        case "porsche":
        holder.imageView.setImageResource(R.drawable.volvo);
        break;
        case "subaru":
        holder.imageView.setImageResource(R.drawable.volvo);
        break;
        case "toyota":
        holder.imageView.setImageResource(R.drawable.volvo);
        break;
        case "volkswagen":
        holder.imageView.setImageResource(R.drawable.volvo);
        break;
        case "volvo":
        holder.imageView.setImageResource(R.drawable.volvo);
        break;
default:
        holder.imageView.setImageResource(android.R.drawable.stat_notify_error);
        break;
        }

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
        Intent intent = new Intent(context, ViewVehicleDetailEmployee.class);
        intent.putExtra("license", license);
        context.startActivity(intent);
        }
        });
        }

@Override
public int getItemCount() {
        return vehicleMap.size();
        }

public class ViewHolder extends RecyclerView.ViewHolder {
    TextView tvBrand, tvModel;
    ImageView imageView;
    LinearLayout linearLayout;
    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        tvBrand = itemView.findViewById(R.id.tvBrandVehicleList);
        tvModel = itemView.findViewById(R.id.tvModelVehicleList);
        imageView = itemView.findViewById(R.id.ivVehicleList);
        linearLayout = itemView.findViewById(R.id.llVehicleList);
    }
}
}
