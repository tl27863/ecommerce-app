package com.example.insorma;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "Insorma.db";

    public DBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "Insorma.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase InsoDB) {
        InsoDB.execSQL("create Table Users(UserID INT primary key AUTOINCREMENT," +
                "UserEmailAddress TEXT, UserUsername TEXT, UserPhone TEXT," +
                "UserPassword TEXT);");
        InsoDB.execSQL("create Table Product(ProductName TEXT primary key," +
                "ProductRating INT, ProductPrice INT, ProductImage INT," +
                "ProductDescription TEXT);");
        InsoDB.execSQL("create Table Transactions(TransactionID INT primary key AUTOINCREMENT," +
                "TransactionDate TEXT , Quantity INT," +
                "foreign key (UserID) REFERENCES Users(UserID)," +
                "foreign key (ProductID) REFERENCES Product(ProductName))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase InsoDB, int i, int i1) {
        InsoDB.execSQL("drop Table if exists Users");
        InsoDB.execSQL("drop Table if exists Product");
        InsoDB.execSQL("drop Table if exists Transactions");
    }

    public boolean registerUser(String username , String email , String phone , String password){
        SQLiteDatabase InsoDB = this.getWritableDatabase();
        ContentValues register = new ContentValues();
        register.put("username",username);
        register.put("email",email);
        register.put("phone",phone);
        register.put("password",password);
        long regisIn = InsoDB.insert("Users" , null , register);
        if(regisIn == -1)
            return false;
        else
            return true;
    }

    public boolean chkUsername(String username){
        SQLiteDatabase InsoDB = this.getWritableDatabase();
        Cursor cursor = InsoDB.rawQuery("Select * from Users where username = ?", new String[] {username});
        if(cursor.getCount() > 0)
            return true;
        else
            return false;
    }

}
