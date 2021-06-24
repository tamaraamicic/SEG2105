package com.example.seg2105_term_project;


import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;
import java.util.Locale;

public class InstructorEditCoursePart2 extends AppCompatActivity {


    EditText TimeInput1;
    EditText TimeInput2;
    EditText DayInput1;
    EditText DayInput2;
    EditText capacityLimit;
    EditText courseDescription;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.instructor_edit_course_part2);

        TimeInput1 = findViewById(R.id.TimeInput1);
        TimeInput2 = findViewById(R.id.TimeInput2);
        DayInput1 = findViewById(R.id.DayInput1);
        DayInput2 = findViewById(R.id.DayInput2);
        capacityLimit = findViewById(R.id.capacityLimit);
        courseDescription = findViewById(R.id.courseDescription);

    }

}