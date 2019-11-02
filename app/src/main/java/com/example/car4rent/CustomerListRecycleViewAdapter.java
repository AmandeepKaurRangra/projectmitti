package com.example.car4rent;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.car4rent.Customer;

import java.util.ArrayList;
import java.util.Map;

public class CustomerListRecycleViewAdapter extends RecyclerView.Adapter<CustomerListRecycleViewAdapter.ViewHolder> {
    LayoutInflater layoutInflater;
    Context context;
    Map<String, Customer> users;
    CustomerRepository customerRepository;
    ArrayList<String> uNames;

    public CustomerListRecycleViewAdapter(Context context, Map<String, Customer> users){
        this.context = context;
        this.users = users;
        layoutInflater = LayoutInflater.from(context);
        customerRepository = CustomerRepository.getInstance();
        uNames = new ArrayList<>(users.keySet());
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.fragment_customer_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        holder.tvUserName.setText(uNames.get(position));
        holder.tvName.setText(users.get(uNames.get(position)).firstName+" "+users.get(uNames.get(position)).lastName);
        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = holder.tvUserName.getText().toString().toLowerCase();
                customerRepository.deleteUser(userName);
                users = customerRepository.getCustomers();
                uNames.remove(userName);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, users.size());
                notifyDataSetChanged();
            }
        });

        holder.btnModify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = holder.tvUserName.getText().toString().toLowerCase();
                Intent intent = new Intent(context, ModifyCustomer.class);
                intent.putExtra("username", userName);
                context.startActivity(intent);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvName, tvUserName;
        Button btnDelete, btnModify;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvCustomerName);
            tvUserName = itemView.findViewById(R.id.tv_CustomerUserName);
            btnDelete = itemView.findViewById(R.id.bt_deletecustomer);
            btnModify = itemView.findViewById(R.id.bt_Modifyme);
        }
    }

}
