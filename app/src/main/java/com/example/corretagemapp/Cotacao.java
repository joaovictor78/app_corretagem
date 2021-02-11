package com.example.corretagemapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.corretagemapp.models.CotacoesFake;

import org.json.JSONException;
import org.json.JSONObject;

public class Cotacao extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cotacao);
        try {
            Bundle args = new Bundle();
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                String value = extras.getString("corretoraSelected");
                JSONObject obj = new JSONObject(value);
                Log.i("Teste", obj.toString());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Button calcularTotalButton = findViewById(R.id.calcular_total);
        calcularTotalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),  ValorTotalCotacao.class);
                startActivity(intent);
            }
        });
        //Add lines for cotacaoAdapter
        recyclerView = findViewById(R.id.lista_cotacao);
        recyclerView.setAdapter(new CotacaoAdapter(CotacoesFake.listaCotacoes()));

    }

}