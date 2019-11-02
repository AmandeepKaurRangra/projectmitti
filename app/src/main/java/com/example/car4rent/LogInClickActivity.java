package com.example.car4rent;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.os.Message;
import android.view.Gravity;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.Toast;

import static com.example.car4rent.R.id.m_logout;
import static com.example.car4rent.R.id.nav_customerlist;
import static com.example.car4rent.R.id.nav_view;

public class LogInClickActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;
    // private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        //mAppBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        //NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);

        // NavigationView navView = findViewById(R.id.nav_view);
        // NavigationUI.setupWithNavController(navView, navController);
        setContentView(R.layout.activity_log_in_click);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        //if (savedInstanceState == null){
           // getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, new CustomerListFragment()).commit();
          //  navigationView.setCheckedItem(R.id.nav_host_fragment);}

        // if (savedInstanceState == null)
        //   getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, new AddCustomer()).commit();
        //  navigationView.setCheckedItem(R.id.nav_newcustomer);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {

            case R.id.nav_newcustomer:
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, new AddCustomer()).commit();
                break;
            case R.id.nav_addvehicle:
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, new AddVehicleFragment()).commit();
                break;
            case R.id.nav_reservationlist:
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, new ReservationListFragment()).commit();
                break;
            case nav_customerlist:
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, new CustomerListFragment()).commit();
                break;
            case R.id.nav_list_of_reservation:
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, new AddCustomer()).commit();
                break;

            case R.id.nav_viewVehicle:
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, new ViewVehicleFragment()).commit();
                break;

            case R.id.nav_rent_or_reserve:
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, new Rent_or_ReserveFragment()).commit();
                break;

            case R.id.nav_cancel_reservation:
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, new CancelReservationFragment()).commit();
                break;

       case R.id.nav_vehicleslist:
               getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, new VehicleListFragment()).commit();
               break;


        }
        drawer.closeDrawer(GravityCompat.START);

        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();

        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case m_logout:
                Intent intent = new Intent(LogInClickActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                Toast.makeText(LogInClickActivity.this, "Succesfully Logged Out ", Toast.LENGTH_LONG).show();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.log_in_click, menu);
        return true;
    }

}

  /*  @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.onNavDestinationSelected(item, navController)
                || super.onOptionsItemSelected(item);
    }
    // Passing each menu ID as a set of Ids because each
    // menu should be considered as top level destinations.
     // AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph())
    //  .setDrawerLayout(drawerLayout)
  //    .build();
    // NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
    //  NavigationUI.setupWithNavController(navigationView, navController);
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_log_in_click_drawer, menu);
        return true;
    }
    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
    }
*/