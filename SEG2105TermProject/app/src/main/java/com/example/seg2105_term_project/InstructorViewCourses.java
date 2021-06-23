package com.example.seg2105_term_project;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class InstructorViewCourses extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.instructor_view_courses);

        MyDBHandlerCourses myDBHandlerCourses = new MyDBHandlerCourses(this);

        TextView entireView = (TextView) findViewById(R.id.entireView);

        Cursor cursor = myDBHandlerCourses.viewData();

        StringBuilder stringBuilder = new StringBuilder("No Data To Show");
        while (cursor.moveToNext()) {
            int index = stringBuilder.indexOf("No Data To Show");
            if (index!=-1){
                stringBuilder.delete(0,"No Data To Show".length());
            }
            stringBuilder.append("\nCourse Name: " + cursor.getString(1) + "\nCourse Code: " + cursor.getString(2));
            stringBuilder.append("\n");
        }


        entireView.setText(stringBuilder);
    }
}
