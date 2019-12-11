package com.example.day3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Show extends AppCompatActivity {
    TextView tvShowName,tvShowNumber;
    EditText edName,edNumber;
    Button btnEd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        setTitle("show infor");
        tvShowName = findViewById(R.id.tvShowName);
        tvShowNumber = findViewById(R.id.tvShowNumber);
        edName = findViewById(R.id.edName);
        edNumber = findViewById(R.id.edNumber);
        btnEd = findViewById(R.id.btnEd);

        Intent intent = getIntent();
        final Contact contact = (Contact) intent.getSerializableExtra("object");
        tvShowName.setText(contact.getName());
        tvShowNumber.setText(contact.getNumber());

        btnEd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = getIntent();
                int i = intent1.getIntExtra("position",999);
                Intent intent = new Intent(getBaseContext(),MainActivity.class);
                String edname = edName.getText().toString();
                String ednumber = edNumber.getText().toString();
                intent.putExtra("edName",edname);
                intent.putExtra("edNumber",ednumber);
                intent.putExtra("position",i);
                startActivity(intent);
            }
        });
    }
}
