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

import java.util.Calendar;
import java.util.Locale;

public class InstructorAssignCoursePart2 extends AppCompatActivity {

    int hour1,minute1,hour2,minute2;

    EditText TimeInput1;
    EditText TimeInput2;
    EditText DayInput1;
    EditText DayInput2;
    DatePickerDialog datePickerDialog;
    String mainCourse;
    Course course;
    Button assignButton;
    EditText capacity;
    EditText description;
    MyDBHandlerCourses myDBHandlerCourses = new MyDBHandlerCourses(this);
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.instructor_assign_course_part2);

        TimeInput1 = findViewById(R.id.TimeInput1);
        TimeInput2 = findViewById(R.id.TimeInput2);
        DayInput1 = findViewById(R.id.DayInput1);
        DayInput2 = findViewById(R.id.DayInput2);
        assignButton = findViewById(R.id.assignButton);
        capacity = findViewById(R.id.CapacityLimit);
        description = findViewById(R.id.CourseDescription);
        description.setText("");
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            mainCourse = extras.getString("mainCourse");
            course = myDBHandlerCourses.findCourse(mainCourse,"");
        }

        assignButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TimeInput1.getText().toString()!="" && TimeInput2.getText().toString() != "" && DayInput1.getText().toString()!="" && DayInput2.getText().toString() !="" && capacity.getText().toString()!=""){
                    course.setInstructor(CurrentUser.getUsername());
                    course.setDate1(DayInput1.getText().toString());
                    course.setDate2(DayInput2.getText().toString());
                    course.setTime1(TimeInput1.getText().toString());
                    course.setTime2(TimeInput2.getText().toString());
                    course.setCapacity(Integer.parseInt(capacity.getText().toString()));
                    course.setDescription(description.getText().toString());
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

        DayInput1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InitDatePicker1(v);
            }
        });

        DayInput2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InitDatePicker2(v);
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

    public void InitDatePicker1(View view){
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month +1;
                String date =  makeDateString(dayOfMonth, month, year);
                DayInput1.setText(date);

            }
        };


        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int date = cal.get(Calendar.DATE);

        int style = AlertDialog.THEME_HOLO_LIGHT;
        datePickerDialog = new DatePickerDialog(this,style,dateSetListener,year,month,date);
        datePickerDialog.setTitle("Select Date");
        datePickerDialog.show();
    }
    public void InitDatePicker2(View view){
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month +1;
                String date =  makeDateString(dayOfMonth, month, year);
                DayInput2.setText(date);

            }
        };


        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int date = cal.get(Calendar.DATE);

        int style = AlertDialog.THEME_HOLO_LIGHT;
        datePickerDialog = new DatePickerDialog(this,style,dateSetListener,year,month,date);
        datePickerDialog.setTitle("Select Date");
        datePickerDialog.show();
    }

    public String makeDateString(int day, int month, int year){
        return getMonthFormat(month)+" "+day+" "+year;
    }

    private String getMonthFormat(int month) {
        if(month==1){
            return "JAN";
        }
        if(month==2){
            return "FEB";
        }
        if(month==3){
            return "MAR";
        }
        if(month==4){
            return "APR";
        }
        if(month==5){
            return "MAY";
        }
        if(month==6){
            return "JUN";
        }
        if(month==7){
            return "JUL";
        }
        if(month==8){
            return "AUG";
        }
        if(month==9){
            return "SEP";
        }
        if(month==10){
            return "OCT";
        }
        if(month==11){
            return "NOV";
        }
        if(month==12){
            return "DEC";
        }
        return "JAN";
    }

}
