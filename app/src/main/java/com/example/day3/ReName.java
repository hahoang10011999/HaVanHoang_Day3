package com.example.day3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ReName extends AppCompatActivity {

    EditText edName;
    Button btnRN;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_re_name);
        setTitle("ReName");
        edName = findViewById(R.id.edName);
        btnRN = findViewById(R.id.btnRN);
        btnRN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ten = edName.getText().toString();
                Intent intent = getIntent();
                int i = intent.getIntExtra("position",9999);

                Intent intent1 = new Intent(getBaseContext(),MainActivity.class);
                intent1.putExtra("name",ten);
                intent1.putExtra("newposition",i);
                startActivity(intent1);
            }
        });
    }
}
