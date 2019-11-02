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
import java.util.List;
import java.util.Map;

public class ViewVehicleCustomerRecyclerViewAdapter extends RecyclerView.Adapter<ViewVehicleCustomerRecyclerViewAdapter.ViewHolder> {


    LayoutInflater layoutInflater;
    Context context;
    Map<String, Vehicle> vehicleMap;
    ArrayList<String> licenceNumbers;
    String mode, startDate, endDate;
    String user;

    public ViewVehicleCustomerRecyclerViewAdapter(Context context, Map<String, Vehicle> vehicleMap, String mode, String user, String startDate, String endDate) {
        this.context = context;
        this.vehicleMap = vehicleMap;
        layoutInflater = LayoutInflater.from(context);
        licenceNumbers = new ArrayList<>(vehicleMap.keySet());
        this.mode = mode;
        this.user = user;
        this.startDate = startDate;
        this.endDate = endDate;
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
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ViewVehicleDetail.class);
                intent.putExtra("mode", mode);
                intent.putExtra("license", license);
                intent.putExtra("startDate", startDate);
                intent.putExtra("endDate", endDate);
                intent.putExtra("user", user);
                context.startActivity(intent);
            }
        });

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
    }

    @Override
    public int getItemCount() {
        return vehicleMap.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvBrand, tvModel;
        LinearLayout linearLayout;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvBrand = itemView.findViewById(R.id.tvBrandVehicleList);
            tvModel = itemView.findViewById(R.id.tvModelVehicleList);
            linearLayout = itemView.findViewById(R.id.llVehicleList);
            imageView = itemView.findViewById(R.id.ivVehicleList);
        }
    }
}