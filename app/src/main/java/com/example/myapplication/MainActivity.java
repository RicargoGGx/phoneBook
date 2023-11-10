package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;

import android.content.pm.PackageManager;
import android.os.Bundle;

import com.example.myapplication.adapters.ContactAdapter;
import com.example.myapplication.models.contacts;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final int callPermission = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, callPermission);
        }

        List<contacts> contactsList = new ArrayList<>();
        contactsList.add(new contacts("Yo","8715659629","22","Yo"));
        contactsList.add(new contacts("Carolina","8711857877","51","Casa"));
        contactsList.add(new contacts("Pedro","8712832781","53","Casa"));
        contactsList.add(new contacts("Fridi","8711440169","25","Casa"));
        contactsList.add(new contacts("Anahí","987654321","21","UTT"));
        contactsList.add(new contacts("Sele","0123456789","19","UA de C"));
        contactsList.add(new contacts("Edgar","6549873210","22","LUZAC"));
        contactsList.add(new contacts("Tilin","9873216540","23","UTT"));

        ContactAdapter C = new ContactAdapter(contactsList);

        RecyclerView rv = findViewById(R.id.rcContacts);

        rv.setAdapter(C);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setHasFixedSize(true);
    }
}