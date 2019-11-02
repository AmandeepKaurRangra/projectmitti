package com.example.car4rent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

//public class CustomerHomePageRecycleAdapter extends RecyclerView.Adapter<CustomerHomePageRecycleAdapter.ViewHolder> {
//    Context context;
//    ArrayList<String> arrayList;
//    LayoutInflater layoutInflater; public CustomerHomePageRecycleAdapter(Context context, ArrayList<String> arrayList) {
//        layoutInflater = LayoutInflater.from(context);
//        this.context = context;
//        this.arrayList = arrayList;
//    }
//    @NonNull
//    @Override
//    public CustomerHomePageRecycleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = layoutInflater.inflate(R.layout.customerlisthomepage, parent, false);
//        return new CustomerHomePageRecycleAdapter.ViewHolder(view);
//    }
//
//
//
//    @Override
//    public void onBindViewHolder(@NonNull CustomerHomePageRecycleAdapter.ViewHolder holder, final int position) {
//        holder.textView.setText(arrayList.get(position));
//        holder.textView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(position == 0){
//                    Intent intent = new Intent(context, Vehicle1.class);
//                    context.startActivity(intent);
//                }
//                if(position == 1){
//                    Intent intent = new Intent(context, vehicle2.class);
//                    context.startActivity(intent);
//                }
//                if(position == 2) {
//                    Intent intent = new Intent(context, CustomerLogin.class);
//                    context.startActivity(intent);
//                }
//
//                }
//            });
//        }

//    @Override
//    public int getItemCount() {
//        return arrayList.size();
//    }
//
//    class ViewHolder extends RecyclerView.ViewHolder{
//        TextView textView;
//        public ViewHolder(@NonNull View itemView) {
//            super(itemView);
//            textView = itemView.findViewById(R.id.tv_EmployeeListItem1);
//        }
//    }
//}

