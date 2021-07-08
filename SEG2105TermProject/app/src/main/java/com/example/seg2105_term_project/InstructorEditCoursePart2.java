package com.example.seg2105_term_project;


import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import java.util.Locale;

public class InstructorEditCoursePart2 extends AppCompatActivity {

    int hour1,minute1,hour2,minute2;
    EditText DayInput1,DayInput2,capacity,description;
    Button finishButton, TimeInput1, TimeInput2;
    String mainCourse;
    MyDBHandlerCourses myDBHandlerCourses = new MyDBHandlerCourses(this);
    Course course;

    private boolean validDay(String day) {
        if (day.equals("Monday") || day.equals("Tuesday") || day.equals("Wednesday") || day.equals("Thursday") || day.equals("Friday") || day.equals("Saturday") || day.equals("Sunday")) {
            return true;
        }
        return false;
    }

    private boolean validCapacity(String capacity) {
        int intCapacity = -1;
        try {
            intCapacity = Integer.parseInt(capacity);
        } catch (Exception e) {
            return false;
        } finally {
            if (intCapacity > 0 && intCapacity <= 500) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.instructor_edit_course_part2);
        getSupportActionBar().setTitle("Course Modification");

        TimeInput1 = findViewById(R.id.TimeInput1Edit);
        TimeInput2 = findViewById(R.id.TimeInput2Edit);
        DayInput1 = findViewById(R.id.dayInput1);
        DayInput2 = findViewById(R.id.dayInput2);
        finishButton = findViewById(R.id.finishButton);
        capacity = findViewById(R.id.capacityLimit);
        description = findViewById(R.id.courseDescription);
        description.setText("");
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            mainCourse = extras.getString("mainCourse");
            course = myDBHandlerCourses.findCourse("",mainCourse);
            DayInput1.setText(course.getDate1());
            TimeInput1.setText(course.getTime1());
            DayInput2.setText(course.getDate2());
            TimeInput2.setText(course.getTime2());
            capacity.setText(""+course.getCapacity());
            description.setText(course.getDescription());
        }

        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!validDay(DayInput1.getText().toString())) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Day 1 invalid.", Toast.LENGTH_LONG);
                    toast.show();
                } else if (TimeInput1.getText().toString().equals("select time")) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Please enter time for day 1.", Toast.LENGTH_LONG);
                    toast.show();
                } else if (!validDay(DayInput2.getText().toString())) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Day 2 invalid.", Toast.LENGTH_LONG);
                    toast.show();
                } else if (TimeInput2.getText().toString().equals("select time")) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Please enter time for day 2.", Toast.LENGTH_LONG);
                    toast.show();
                } else if (!validCapacity(capacity.getText().toString())) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Capacity invalid.", Toast.LENGTH_LONG);
                    toast.show();
                } else {
                    addCourseAgain(course);
                    Toast toast = Toast.makeText(getApplicationContext(), "Successfully Assigned!", Toast.LENGTH_LONG);
                    toast.show();
                    Intent intent = new Intent(getApplicationContext(), InstructorPage.class);
                    startActivity(intent);
                }

            }
        });

        TimeInput1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Time1Picker(v);
            }
        });

        TimeInput2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Time2Picker(v);
            }
        });


    }

    public void Time1Picker(View view){
        TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                hour1 = hourOfDay;
                minute1 = minute;
                TimeInput1.setText(String.format(Locale.getDefault(), "%02d:%02d",hour1,minute1));
            }
        };

        TimePickerDialog timePickerDialog = new TimePickerDialog(this,onTimeSetListener,hour1,minute1,false);
        timePickerDialog.setTitle("Select Time");
        timePickerDialog.show();
    }
    public void Time2Picker(View view){
        TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                hour2 = hourOfDay;
                minute2 = minute;
                TimeInput2.setText(String.format(Locale.getDefault(), "%02d:%02d",hour2,minute2));
            }
        };

        TimePickerDialog timePickerDialog = new TimePickerDialog(this,onTimeSetListener,hour2,minute2,false);
        timePickerDialog.setTitle("Select Time");
        timePickerDialog.show();
    }

    public Course addCourseAgain(Course course){
        String courseName = course.getCourseName();
        String courseCode = course.getCourseCode();
        myDBHandlerCourses.deleteCourse(courseName,courseCode);
        Course newCourse = new Course(courseName,courseCode);
        newCourse.setCourseName(courseName);
        newCourse.setCourseCode(courseCode);
        newCourse.setInstructor(CurrentUser.getUsername());
        newCourse.setDate1(DayInput1.getText().toString());
        newCourse.setDate2(DayInput2.getText().toString());
        newCourse.setTime1(TimeInput1.getText().toString());
        newCourse.setTime2(TimeInput2.getText().toString());
        newCourse.setCapacity(Integer.parseInt(capacity.getText().toString()));
        newCourse.setDescription(description.getText().toString());
        myDBHandlerCourses.addCourse(newCourse);
        return newCourse;
    }


}