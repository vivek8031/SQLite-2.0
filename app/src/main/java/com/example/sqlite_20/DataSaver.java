package com.example.sqlite_20;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DataSaver extends AppCompatActivity {


    DatabaseHelper mDatabaseHelper;
    private Button btnAdd;
    private EditText editText,editTextage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_saver);
        editText = (EditText) findViewById(R.id.editText);
        editTextage = (EditText) findViewById(R.id.editTextage);
        btnAdd = (Button) findViewById(R.id.save);
        mDatabaseHelper = new DatabaseHelper(this);
        AddData();
    }
    public void AddData() {
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editText.getText().toString();
                String age = editTextage.getText().toString();

                boolean insertData = mDatabaseHelper.addData(name, age);
                if (insertData == true) {
                    Toast.makeText(DataSaver.this, "Data Successfully Inserted!", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(DataSaver.this, "Something went wrong", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
