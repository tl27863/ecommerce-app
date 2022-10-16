package com.example.insorma;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.TextView;

import java.util.ArrayList;

public class TransactionHistory extends AppCompatActivity {

    RecyclerView tRecyclerView;
    TextView errMsg;
    private ArrayList<Transactions> userTransactionDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_history);

        errMsg = findViewById(R.id.uherrmsg);
        userTransactionDB = new ArrayList<>();
        for(int i = 0 ; i < Home.transactionDB.size() ; i++){
            if(Home.transactionDB.get(i).getUID().equals(Login.loggedOnUser)){
                userTransactionDB.add(new Transactions(Home.transactionDB.get(i).getTransId() ,
                        Home.transactionDB.get(i).getUID(), Home.transactionDB.get(i).getPID() ,
                        Home.transactionDB.get(i).getTransDate() , Home.transactionDB.get(i).getTransQty()));
            }
        }

        if(userTransactionDB.size() < 1){
            errMsg.setText("Theres No Transaction!");
        }

        tRecyclerView = findViewById(R.id.transactionHistory);
        tAdapter tadapter = new tAdapter(userTransactionDB);
        tRecyclerView.setAdapter(tadapter);
        tRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.mymenu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}