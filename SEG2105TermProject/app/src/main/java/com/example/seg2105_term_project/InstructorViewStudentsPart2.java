package com.example.seg2105_term_project;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class InstructorViewStudentsPart2 extends AppCompatActivity {

    Course course;
    String mainCourse;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.instructor_view_students2);

        TextView instructorViewStudentsTextView = (TextView) findViewById(R.id.instructorViewStudentsTextView);

        MyDBHandlerCourses myDBHandlerCourses = new MyDBHandlerCourses(this);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            mainCourse = extras.getString("mainCourse");
            course = myDBHandlerCourses.findCourse("",mainCourse);
        }

        StringBuilder stringBuilder = new StringBuilder("No students in this course.");

        if (!course.getStudents().equals("")) {
            stringBuilder.delete(0, "No students in this course.".length());
            stringBuilder.append("Students: ");
            stringBuilder.append("\n");
            stringBuilder.append(course.getStudents());
        }

        instructorViewStudentsTextView.setText(stringBuilder);

    }
}
