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

    private static final int callPermission = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, callPermission);
        }

        List<contacts> contactsList = new ArrayList<>();
        contactsList.add(new contacts("Yo","8715659629","5-Febrero-2001","Yo"));
        contactsList.add(new contacts("Carolina","8711857877","3-Febrero-1972","Casa"));
        contactsList.add(new contacts("Pedro","8712832781","6-Diciembre-1970","Casa"));
        contactsList.add(new contacts("Fridi","+52 1 8711440169","9-Febrero-1998","Casa"));
        contactsList.add(new contacts("Anahí","987654321","NA","UTT"));
        contactsList.add(new contacts("Sele","0123456789","NA","UA de C"));
        contactsList.add(new contacts("Edgar","6549873210","2-Abril-2003","LUZAC"));
        contactsList.add(new contacts("Tilin","9873216540","NA","UTT"));

        ContactAdapter C = new ContactAdapter(contactsList);

        RecyclerView rv = findViewById(R.id.rcContacts);

        rv.setAdapter(C);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setHasFixedSize(true);
    }
}