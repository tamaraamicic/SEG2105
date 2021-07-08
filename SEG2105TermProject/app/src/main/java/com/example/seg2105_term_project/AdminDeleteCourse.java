package com.example.seg2105_term_project;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class AdminDeleteCourse extends AppCompatActivity {

    TextInputEditText inputNameForDelete;
    TextInputEditText inputCodeForDelete;
    Button deleteButtonForDelete;
    Button findButtonForDelete;
    TextView entireCourseview;
    Cursor cursor;
    MyDBHandlerCourses myDBHandlerCourses;
    StringBuilder stringBuilder;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_delete_course);
        getSupportActionBar().setTitle("Course Deletion");





        inputNameForDelete = (TextInputEditText) (findViewById(R.id.inputNameForDelete));
        inputCodeForDelete = (TextInputEditText) (findViewById(R.id.inputCodeForDelete));
        deleteButtonForDelete = (Button)(findViewById(R.id.deleteButtonForDelete));
        deleteButtonForDelete.setEnabled(false);
        findButtonForDelete = (Button)(findViewById(R.id.findButtonForDelete));
        entireCourseview = (TextView)findViewById(R.id.entireTextView);


        myDBHandlerCourses = new MyDBHandlerCourses(this);
        display();

        findButtonForDelete.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String name = inputNameForDelete.getText().toString();
                String code = inputCodeForDelete.getText().toString();
                Course course = myDBHandlerCourses.findCourse(name, code);
                if (course != null) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Course found! Press \'DELETE COURSE\'", Toast.LENGTH_LONG);
                    toast.show();
                    deleteButtonForDelete.setEnabled(true);
                    if (code.equals("")) {
                        inputCodeForDelete.setText(course.getCourseCode());
                    } else if (name.equals("")) {
                        inputNameForDelete.setText(course.getCourseName());
                    }
                } else {
                    Toast toast = Toast.makeText(getApplicationContext(), "Course not found. Please retry.", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });

        deleteButtonForDelete.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String name = inputNameForDelete.getText().toString();
                String code = inputCodeForDelete.getText().toString();
                if(myDBHandlerCourses.deleteCourse(name, code)) {
                    display();
                    Toast toast = Toast.makeText(getApplicationContext(), "Course successfully deleted.", Toast.LENGTH_LONG);
                    toast.show();
                    inputCodeForDelete.setText("");
                    inputNameForDelete.setText("");
                }else{
                    Toast toast = Toast.makeText(getApplicationContext(), "Course could not be deleted.", Toast.LENGTH_LONG);
                    toast.show();
                }
                deleteButtonForDelete.setEnabled(false);

            }
        });





    }

    public void display(){
        stringBuilder = new StringBuilder();
        cursor = myDBHandlerCourses.viewData();
        boolean flag = false;
        while (cursor.moveToNext()) {

            flag = true;
            int index = stringBuilder.indexOf("No Data To Show");
            if (index!=-1){
                stringBuilder.delete(0,"No Data To Show".length());
            }
            stringBuilder.append("\nCourse Name: " + cursor.getString(1) + "\nCourse Code: " + cursor.getString(2)+ "\nInstructor: " + cursor.getString(3)+ "\nDate 1: " + cursor.getString(4)+ "\nTime 1: " + cursor.getString(6)+ "\nDate 2: " + cursor.getString(5)+ "\nTime 2: " + cursor.getString(7)+ "\nCapacity: " + cursor.getString(8)+ "\nDescription: " + cursor.getString(9));
            stringBuilder.append("\n");
        }

        if(!flag){
            stringBuilder.append("No Data To Show");
        }
        entireCourseview.setText(stringBuilder);
    }

}
