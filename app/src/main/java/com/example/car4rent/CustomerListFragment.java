package com.example.car4rent;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CustomerListFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_customer_list, container, false);
        Button Modifyme = view.findViewById(R.id.bt_Modifyme);
        Modifyme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),  ModifyCustomer.class);
                startActivity(intent);
            }
        });
        return view;
    }


    public class ViewCustomers extends AppCompatActivity {
        RecyclerView recyclerView;
        RecyclerView.LayoutManager layoutManager;
        CustomerListRecycleViewAdapter customerListRecycleViewAdapter;
        CustomerRepository customerRepository;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.fragment_customer_list);
            recyclerView = findViewById(R.id.rv_customerlist);
            customerRepository = CustomerRepository.getInstance();
            customerListRecycleViewAdapter = new CustomerListRecycleViewAdapter(this, customerRepository.getCustomers());
            recyclerView.setAdapter(customerListRecycleViewAdapter);
            layoutManager = new LinearLayoutManager(this);
            recyclerView.setLayoutManager(layoutManager);
        }
    }
}
