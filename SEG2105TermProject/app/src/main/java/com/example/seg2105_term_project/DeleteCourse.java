package com.example.seg2105_term_project;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class DeleteCourse extends AppCompatActivity {

    TextInputEditText inputNameForDelete;
    TextInputEditText inputCodeForDelete;
    Button deleteButtonForDelete;
    Button findButtonForDelete;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delete_course);

        inputNameForDelete = (TextInputEditText) (findViewById(R.id.inputNameForDelete));
        inputCodeForDelete = (TextInputEditText) (findViewById(R.id.inputCodeForDelete));
        deleteButtonForDelete = (Button)(findViewById(R.id.deleteButtonForDelete));
        findButtonForDelete = (Button)(findViewById(R.id.findButtonForDelete));

    }

}
