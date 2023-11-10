package com.example.myapplication;

import android.os.Bundle;
import android.widget.TextView;

import com.example.myapplication.models.contacts;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class contactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contactinfo);

        contacts contact = (contacts) getIntent().getSerializableExtra("contact");

        TextView name = findViewById(R.id.nameContact);
        TextView tel = findViewById(R.id.telContact);
        TextView inst = findViewById(R.id.instContact);
        TextView birth = findViewById(R.id.birthContact);

        name.setText(contact.getName());
        tel.setText(contact.getTel());
        inst.setText(contact.getInstitution());
        birth.setText(contact.getBirth());
    }
}
