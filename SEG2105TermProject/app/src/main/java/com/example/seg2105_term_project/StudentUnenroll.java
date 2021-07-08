package com.example.seg2105_term_project;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class StudentUnenroll extends AppCompatActivity {

    TextInputEditText inputNameForUnenroll;
    TextInputEditText inputCodeForUnenroll;
    TextInputEditText inputDateForUnenroll;
    Button searchButtonForUnenroll;
    Button unenrollButtonForUnenroll;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_enroll);

        inputNameForUnenroll = (TextInputEditText) (findViewById(R.id.inputNameForUnenroll));
        inputCodeForUnenroll = (TextInputEditText) (findViewById(R.id.inputCodeForUnenroll));
        inputDateForUnenroll = (TextInputEditText) (findViewById(R.id.inputDateForUnenroll));
        searchButtonForUnenroll = (Button) (findViewById(R.id.searchButtonForUnenroll));
        unenrollButtonForUnenroll = (Button) (findViewById(R.id.unenrollButtonForUnenroll));

    }
}
