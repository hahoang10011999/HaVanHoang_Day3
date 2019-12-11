package com.example.day3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Contact> contacts;
    Contact contact1,contact2,contact3;
    RecyclerView recyclerView;
    ContactAdapter contactAdapter;
    TextView tvName,tvNumber;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvName = findViewById(R.id.tvName);
        tvNumber = findViewById(R.id.tvNumber);
        recyclerView = findViewById(R.id.rvlist) ;
        img = findViewById(R.id.plus);
        contacts = new ArrayList<>();
        contact1 = new Contact("A","123456");
        contact2 = new Contact("B","726353");
        contact3 = new Contact("C","823632");

        contacts.add(contact1);
        contacts.add(contact2);
        contacts.add(contact3);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getBaseContext(),
                LinearLayoutManager.VERTICAL, false);
        contactAdapter = new ContactAdapter(contacts);
    contactAdapter.setIonclickContact(new IonclickContact() {
        @Override
        public void onClickName(String name,int i) {
            Intent intent = new Intent(getBaseContext(),ReName.class);
            intent.putExtra("position",i);
            startActivity(intent);
        }
        @Override
        public void onClickPhone(Contact contact,int i) {
            Intent intent = new Intent(getBaseContext(),Show.class);
            intent.putExtra("object",contact);
            intent.putExtra("position",i);
            startActivity(intent);

        }
    });
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),Add.class);
                startActivity(intent);
            }
        });
        Intent intent = getIntent();
        String name = intent.getStringExtra("ten");
        String number = intent.getStringExtra("number");
        String name1 = intent.getStringExtra("name");
        String edName = intent.getStringExtra("edName");
        String edNumber = intent.getStringExtra("edNumber");
        int i = intent.getIntExtra("newposition",999);
        int j = intent.getIntExtra("position",999);

            Contact user = new Contact(name,number);
            contacts.add(user);
            if(name1 != null) {
            contacts.get(i).setName(name1);
        }
         if(edName != null && edNumber != null){
            contacts.get(j).setName(edName);
            contacts.get(j).setNumber(edNumber);
        }

    recyclerView.setLayoutManager(layoutManager);
    recyclerView.setAdapter(contactAdapter);
    }
}
