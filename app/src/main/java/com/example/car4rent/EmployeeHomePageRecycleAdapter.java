package com.example.car4rent;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class EmployeeHomePageRecycleAdapter extends RecyclerView.Adapter<EmployeeHomePageRecycleAdapter.ViewHolder> {
    Context context;
    ArrayList<String> arrayList;
    LayoutInflater layoutInflater; public EmployeeHomePageRecycleAdapter(Context context, ArrayList<String> arrayList) {
        layoutInflater = LayoutInflater.from(context);
        this.context = context;
        this.arrayList = arrayList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.employeelist_homepage, parent, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.textView.setText(arrayList.get(position));
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(position == 0){
                    Intent intent = new Intent(context, CustomerSignUp.class);
                    context.startActivity(intent);
                }
                /*if(position == 1){
                    Intent intent = new Intent(context, ListOfCustomer.class);
                    context.startActivity(intent);
                }
                if(position == 2){
                    Intent intent = new Intent(context, AddNewVehicle.class);
                    context.startActivity(intent);
                }
                if(position == 3){
                    Intent intent = new Intent(context, ListOfVehicle.class);
                    context.startActivity(intent);
                }
                if(position == 4){
                    Intent intent = new Intent(context, ListOfReservation.class);
                    context.startActivity(intent);
                }
                if(position == 5){
                    Intent intent = new Intent(context, EmployeeLogin.class);
                    context.startActivity(intent);
                } */
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_EmployeeListItem);
        }
    }
}

