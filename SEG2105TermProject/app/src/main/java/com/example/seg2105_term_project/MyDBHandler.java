package com.example.seg2105_term_project;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.Editable;

public class MyDBHandler extends SQLiteOpenHelper {
    //defining the schema
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "productDB.db";
    private static final String TABLE_PRODUCTS = "products";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_PRODUCTNAME = "productname";
    private static final String COLUMN_PRICE = "price";
    private static final String TABLE_NAME = "store";

    //constructor
    public MyDBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // create the table
    @Override
    public void onCreate(SQLiteDatabase db) {
        //CREATE TABLE TABLE_PRODUCTS (COLUMN_ID INTEGER PRIMARY KEY, COLUMN_PRODUCTNAME TEXT,
        // COLUMN_PRICE DOUBLE)
        String CREATE_PRODUCTS_TABLE = "CREATE TABLE " + TABLE_PRODUCTS + "(" + COLUMN_ID +
                " INTEGER PRIMARY KEY, " + COLUMN_PRODUCTNAME + " TEXT, " + COLUMN_PRICE + " DOUBLE"
                + ")";
        db.execSQL(CREATE_PRODUCTS_TABLE);
    }

    // deletes old tables and creates a new one
    // change tables by incrementing the database version number
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCTS);
        onCreate(db);
    }

    // insert into database
    public void addProduct(User user) {
        SQLiteDatabase db =this.getWritableDatabase();

        // creating a new map of values where column names are the keys
        ContentValues values = new ContentValues();
        values.put(COLUMN_PRODUCTNAME, user.getUsername());
        values.put(COLUMN_PRICE, user.getPassword());

        // insert into table and close
        db.insert(TABLE_PRODUCTS, null, values);
        db.close();
    }

    // read from database
    public User findProduct(String productname) {
        SQLiteDatabase db = this.getWritableDatabase();

        //run a query to find the product
        // SELECT * FROM TABLE_PRODUCTS WHERE COLUMN_PRODUCTNAME = productname
        String query = "SELECT * FROM " + TABLE_PRODUCTS + " WHERE " + COLUMN_PRODUCTNAME +
                " = \"" + productname + "\"";
        Cursor cursor = db.rawQuery(query, null);

        // create an object and get the result
        User product = new User();
        if (cursor.moveToFirst()) {
            product.setID(Integer.parseInt(cursor.getString(0)));
            product.setUsername(cursor.getString(1));
            product.setPassword(cursor.getString(2));
            cursor.close();
        } else {
            product = null;
        }
        db.close();
        return product;
    }

    // delete from database
    public boolean deleteProduct(String productname) {
        boolean result = false;
        SQLiteDatabase db = this.getWritableDatabase();

        // run a query to find the product then delete
        // SELECT * FROM TABLE_PRODUCTS WHERE COLUMN_PRODUCTNAME = productname
        String query = "SELECT * FROM " + TABLE_PRODUCTS + " WHERE " + COLUMN_PRODUCTNAME + " = \""
                + productname + "\"";
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            String idStr = cursor.getString(0);
            db.delete(TABLE_PRODUCTS, COLUMN_ID + " = " + idStr, null);
            cursor.close();
            result = true;
        }
        db.close();
        return result;
    }

    public Cursor viewData(){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        Cursor cursor;
        cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_PRODUCTS,null);
        return cursor;
    }
}