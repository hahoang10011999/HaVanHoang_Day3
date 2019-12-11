package com.example.day3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Add extends AppCompatActivity {
    EditText etName,etNumber;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        etName = findViewById(R.id.etName);
        etNumber = findViewById(R.id.etNumber);
        btnAdd = findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                String number = etNumber.getText().toString();
                Intent intent = new Intent(getBaseContext(),MainActivity.class);
                intent.putExtra("ten",name);
                intent.putExtra("number",number);
                startActivity(intent);
            }
        });
    }
}
