package com.example.seg2105_term_project;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class InstructorViewStudents extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.instructor_view_students);
        getSupportActionBar().setTitle("View Students");

        MyDBHandlerCourses myDBHandlerCourses = new MyDBHandlerCourses(this);

        TextView instructorViewStudentsTextView = (TextView) findViewById(R.id.instructorViewStudentsTextView);

        Cursor cursor = myDBHandlerCourses.viewData();

        StringBuilder stringBuilder = new StringBuilder("No Data To Show");
        while (cursor.moveToNext()) {
            int index = stringBuilder.indexOf("No Data To Show");
            if (index!=-1){
                stringBuilder.delete(0,"No Data To Show".length());
            }
            if (cursor.getString(3) == CurrentUser.getUsername()) {
                stringBuilder.append("Students in course " + cursor.getString(1) + ": ");
                stringBuilder.append(cursor.getString(10));
                stringBuilder.append("\n");
            }
//            stringBuilder.append("\nCourse Name: " + cursor.getString(1) + "\nCourse Code: " + cursor.getString(2)+ "\nInstructor: " + cursor.getString(3)
//                    + "\nDate 1: " + cursor.getString(4)+ "\nTime 1: " + cursor.getString(6)+ "\nDate 2: " + cursor.getString(5)+ "\nTime 2: "
//                    + cursor.getString(7)+ "\nCapacity: " + cursor.getString(8)+ "\nDescription: " + cursor.getString(9));
//            stringBuilder.append("\n");
        }


        instructorViewStudentsTextView.setText(stringBuilder);
    }
}
