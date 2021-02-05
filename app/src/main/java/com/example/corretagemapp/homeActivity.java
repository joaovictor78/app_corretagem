package com.example.corretagemapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.corretagemapp.models.Corretora;
import com.example.corretagemapp.models.Corretoras;

import java.util.ArrayList;

public class homeActivity extends AppCompatActivity {
     private CorretoraAdapter corretoraAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);
        corretoraAdapter = new CorretoraAdapter(new ArrayList<>(Corretoras.listCorretoras()));
        RecyclerView recyclerView = findViewById(R.id.rowlistview);
        recyclerView.setAdapter(corretoraAdapter);

    }
}