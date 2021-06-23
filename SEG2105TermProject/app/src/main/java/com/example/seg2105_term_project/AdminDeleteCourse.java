package com.example.seg2105_term_project;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class AdminDeleteCourse extends AppCompatActivity {

    TextInputEditText inputNameForDelete;
    TextInputEditText inputCodeForDelete;
    Button deleteButtonForDelete;
    Button findButtonForDelete;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_delete_course);

        inputNameForDelete = (TextInputEditText) (findViewById(R.id.inputNameForDelete));
        inputCodeForDelete = (TextInputEditText) (findViewById(R.id.inputCodeForDelete));
        deleteButtonForDelete = (Button)(findViewById(R.id.deleteButtonForDelete));
        deleteButtonForDelete.setEnabled(false);
        findButtonForDelete = (Button)(findViewById(R.id.findButtonForDelete));
        MyDBHandlerCourses handlerCourses = new MyDBHandlerCourses(this);

        findButtonForDelete.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String name = inputNameForDelete.getText().toString();
                String code = inputCodeForDelete.getText().toString();
                Course course = handlerCourses.findCourse(name, code);
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
                if(handlerCourses.deleteCourse(name, code)) {
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

}
