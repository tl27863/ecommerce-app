package com.example.insorma;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;


import java.util.ArrayList;

public class Home extends AppCompatActivity implements pAdapter.OnNoteListener {

    public static ArrayList<Product> productDB;
    public static ArrayList<Transactions> transactionDB;
    RecyclerView pRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        productDB = new ArrayList<>();
        transactionDB = new ArrayList<>();
        productDB.add(new Product("Bed", 7 , 1200 , R.drawable.product_bed, "Comfy Wooden Bed" ));
        productDB.add(new Product("Chair", 8 , 120 , R.drawable.product_chair , "Comfy Wooden Chair" ));
        productDB.add(new Product("Desk", 9 , 600 , R.drawable.product_desk , "Steel & Wood Desk" ));

        pRecyclerView = findViewById(R.id.productView);
        pAdapter padapter = new pAdapter(productDB , this);
        pRecyclerView.setAdapter(padapter);
        pRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        //final String idUser = this.getIntent().getStringExtra("uid");
        //String uid = Login.loggedOnUser;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.mymenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        switch (item.getItemId()){
            case R.id.lehome:
                Intent intent34 = new Intent(getApplicationContext(), Home.class);
                startActivity(intent34);
                break;
            case R.id.history:
                Intent intent1 = new Intent(getApplicationContext(), TransactionHistory.class);
                startActivity(intent1);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onNoteClick(int position) {
        Intent intent = new Intent(getApplicationContext() , Order.class);
        intent.putExtra("currentPID" , position);
        startActivity(intent);
    }
}