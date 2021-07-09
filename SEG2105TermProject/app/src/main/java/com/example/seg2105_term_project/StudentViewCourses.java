package com.example.seg2105_term_project;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class StudentViewCourses extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_view_courses);
        getSupportActionBar().setTitle("View Courses");

        MyDBHandlerCourses myDBHandlerCourses = new MyDBHandlerCourses(this);

        TextView entireView = (TextView) findViewById(R.id.studentViewCoursesText);

        Cursor cursor = myDBHandlerCourses.viewData();

        StringBuilder stringBuilder = new StringBuilder("No Data To Show");
        while (cursor.moveToNext()) {
            int index = stringBuilder.indexOf("No Data To Show");
            if (index!=-1){
                stringBuilder.delete(0,"No Data To Show".length());
            }
            stringBuilder.append("\nCourse Name: " + cursor.getString(1) + "\nCourse Code: " + cursor.getString(2)+ "\nInstructor: " + cursor.getString(3)+ "\nDate 1: " + cursor.getString(4)+ "\nTime 1: " + cursor.getString(6)+ "\nDate 2: " + cursor.getString(5)+ "\nTime 2: " + cursor.getString(7)+ "\nCapacity: " + cursor.getString(8)+ "\nDescription: " + cursor.getString(9)+ "\nStudents: " + cursor.getString(10).replaceAll(",$",""));
            stringBuilder.append("\n");


        }


        entireView.setText(stringBuilder);
    }
}
