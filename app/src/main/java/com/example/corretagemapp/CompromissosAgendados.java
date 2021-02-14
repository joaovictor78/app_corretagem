package com.example.corretagemapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class CompromissosAgendados extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compromissos_agendados);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}