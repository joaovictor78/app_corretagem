package com.example.corretagemapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Cotacao extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cotacao);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Button calcularTotalButton = findViewById(R.id.calcular_total);
        calcularTotalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),  ValorTotalCotacao.class);
                startActivity(intent);

            }
        });
    }

}