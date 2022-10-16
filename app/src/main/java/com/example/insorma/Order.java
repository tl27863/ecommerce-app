package com.example.insorma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class Order extends AppCompatActivity {

    TextView productName , productRating;
    TextView productPrice , productDescription;
    ImageView productImage;
    EditText productQty;
    Button addOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        productName = findViewById(R.id.productTitle);
        productRating = findViewById(R.id.productRating);
        productPrice = findViewById(R.id.productPrice);
        productDescription = findViewById(R.id.productDesc);
        productImage = findViewById(R.id.productImage);
        productQty = findViewById(R.id.productQty);
        addOrder = findViewById(R.id.addOrder);

        final int productId = this.getIntent().getIntExtra("currentPID", 0);
        String ratingTxt = "Rating: " + Home.productDB.get(productId).getProductRating().toString() + "/10";
        String priceTxt = "$ " + Home.productDB.get(productId).getProductPrice().toString();
        productName.setText(Home.productDB.get(productId).getProductName());
        productRating.setText(ratingTxt);
        productPrice.setText(priceTxt);
        productDescription.setText(Home.productDB.get(productId).getProductDescription());
        productImage.setImageResource(Home.productDB.get(productId).getProductImage());

        addOrder.setOnClickListener(view -> {
            String quantity = productQty.getText().toString();
            int Quantity = Integer.parseInt(quantity);

            if(Quantity < 1){
                Toast.makeText(Order.this , "Quantity must be more than 0!" , Toast.LENGTH_SHORT).show();
            }else{
                Random random = new Random();
                int val = random.nextInt(100-1)+1;
                String currentDate = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
                Home.transactionDB.add(new Transactions(val , Login.loggedOnUser , Home.productDB.get(productId).getProductName() ,
                        currentDate , Quantity));
                Intent intent = new Intent(getApplicationContext(),TransactionHistory.class);
                startActivity(intent);
            }

        });
    //    productName.setText("k");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.mymenu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}