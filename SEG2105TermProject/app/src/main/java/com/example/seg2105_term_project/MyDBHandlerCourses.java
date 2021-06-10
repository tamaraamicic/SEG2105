package com.example.seg2105_term_project;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDBHandlerCourses extends SQLiteOpenHelper {
    //defining the schema
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "courseDB.db";
    private static final String TABLE_COURSES = "courses";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_COURSENAME = "coursename"; // was product name
    private static final String COLUMN_CODE = "code"; // was product price

    //constructor
    public MyDBHandlerCourses(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // create the table
    @Override
    public void onCreate(SQLiteDatabase db) {
        //CREATE TABLE TABLE_COURSES (COLUMN_ID INTEGER PRIMARY KEY, COLUMN_COURSENAME TEXT,
        // COLUMN_CODE DOUBLE)
        String CREATE_PRODUCTS_TABLE = "CREATE TABLE " + TABLE_COURSES +
                "(" + COLUMN_ID + " INTEGER PRIMARY KEY, " +
                COLUMN_COURSENAME + " TEXT, " +
                COLUMN_CODE + " TEXT" + ")";
        db.execSQL(CREATE_PRODUCTS_TABLE);
    }

    // deletes old tables and creates a new one
    // change tables by incrementing the database version number
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_COURSES);
        onCreate(db);
    }

    // insert into database
    public void addCourse(Course course) {
        SQLiteDatabase db =this.getWritableDatabase();

        // creating a new map of values where column names are the keys
        ContentValues values = new ContentValues();
        values.put(COLUMN_COURSENAME, course.getCourseName());
        values.put(COLUMN_CODE, course.getCourseCode());

        // insert into table and close
        db.insert(TABLE_COURSES, null, values);
        db.close();
    }

    // read from database
    public Course findCourse(String courseName, String courseCode) {
        SQLiteDatabase db = this.getWritableDatabase();

        //run a query to find the product
        // SELECT * FROM TABLE_PRODUCTS WHERE COLUMN_COURSENAME = coursename
        String query = "SELECT * FROM " + TABLE_COURSES + " WHERE " + COLUMN_COURSENAME +
                " = \"" + courseName + "\"";
        Cursor cursor = db.rawQuery(query, null);

        // create an object and get the result
        Course course = new Course(courseName, courseCode);
        if (cursor.moveToFirst()) {
            course.setID(Integer.parseInt(cursor.getString(0)));
            course.setCourseName(cursor.getString(1));
            course.setCourseCode(cursor.getString(2));
            cursor.close();
        } else {
            course = null;
        }
        db.close();
        return course;
    }

    // delete from database
    public boolean deleteCourse(String coursename) {
        boolean result = false;
        SQLiteDatabase db = this.getWritableDatabase();

        // run a query to find the product then delete
        // SELECT * FROM TABLE_PRODUCTS WHERE COLUMN_PRODUCTNAME = productname
        String query = "SELECT * FROM " + TABLE_COURSES + " WHERE " + COLUMN_COURSENAME + " = \""
                + coursename + "\"";
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            String idStr = cursor.getString(0);
            db.delete(TABLE_COURSES, COLUMN_ID + " = " + idStr, null);
            cursor.close();
            result = true;
        }
        db.close();
        return result;
    }

    public Cursor viewData(){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        Cursor cursor;
        cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_COURSES,null);
        return cursor;
    }
}