package com.example.corretagemapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.corretagemapp.models.CotacaoModel;
import com.example.corretagemapp.models.CotacoesFake;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cotacao extends AppCompatActivity {
    RecyclerView recyclerView;
    JSONObject jsonObjectCorretora;
    ArrayList<CotacaoModel> listCotacao;
    ArrayList<CotacaoModel>  minhasCotacoes = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cotacao);
        try {
            Bundle args = new Bundle();
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                String value = extras.getString("corretoraSelected");
                jsonObjectCorretora = new JSONObject(value);
                Log.i("Teste", jsonObjectCorretora.toString());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
       listCotacao = initListCotacaoOperados();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Button calcularTotalButton = findViewById(R.id.calcular_total);
        calcularTotalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ValorTotalCotacao.class);
                startActivity(intent);
            }
        });
        //Add lines for cotacaoAdapter
        recyclerView = findViewById(R.id.lista_cotacao);
        recyclerView.setAdapter(new CotacaoAdapter(minhasCotacoes));
        Button addButton = findViewById(R.id.adicionar_pessoa);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater layoutInflaterAndroid = LayoutInflater.from(getApplicationContext());
                View mView = layoutInflaterAndroid.inflate(R.layout.add_membro, null);
                AlertDialog.Builder alertDialogBuilderUserInput = new AlertDialog.Builder(Cotacao.this);
                alertDialogBuilderUserInput.setView(mView);

                final EditText idade = (EditText) mView.findViewById(R.id.userInputIdade);
                alertDialogBuilderUserInput
                        .setCancelable(false)
                        .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                            @RequiresApi(api = Build.VERSION_CODES.N)
                            public void onClick(DialogInterface dialogBox, int id) {
                                Integer user_idade = Integer.parseInt(idade.getText().toString());
                                Stream<CotacaoModel> lista = listCotacao.stream().filter(cotacaoModel -> filterCorretora(cotacaoModel, user_idade));
                                List<CotacaoModel> cotacaoEscolhida = lista.collect(Collectors.toList());

                                if(cotacaoEscolhida.size() != 0){
                                    CotacaoModel cotacao = cotacaoEscolhida.get(0);
                                    cotacao.setIdade(user_idade.toString());
                                    minhasCotacoes.add(cotacao);
                                } else {
                                    List<CotacaoModel> cotacaoIdadeMax = listCotacao.stream().filter(cotacaoModel -> cotacaoModel.getIdade_max().equals("null")).collect(Collectors.toList());
                                   if(cotacaoIdadeMax.size() != 0){
                                       CotacaoModel cotacao = cotacaoIdadeMax.get(0);
                                       cotacao.setIdade(user_idade.toString());
                                       minhasCotacoes.add(cotacao);
                                   }
                                }


                            }
                        })

                        .setNegativeButton("Cancell",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialogBox, int id) {
                                        dialogBox.cancel();
                                    }
                                });

                AlertDialog alertDialogAndroid = alertDialogBuilderUserInput.create();
                alertDialogAndroid.show();
            }
        });

    }

    private ArrayList<CotacaoModel> initListCotacaoOperados() {

        try {
            ArrayList<CotacaoModel> listCotacoes = new ArrayList<CotacaoModel>();
            JSONArray array = jsonObjectCorretora.getJSONArray("precos");
            if (array != null) {
                for (int i = 0; i < array.length(); i++) {
                    JSONObject operadora = array.getJSONObject(i);
                    String idade_min = operadora.getString("idade_min");
                    String idade_max = operadora.getString("idade_max") != null ?  operadora.getString("idade_max") : null;
                    JSONArray valorPorTipo = operadora.getJSONArray("valor_por_tipo");
                    String preco_enfermaria = valorPorTipo.getJSONObject(0).getString("valor");
                    String preco_apartamento = valorPorTipo.getJSONObject(1).getString("valor");
                    listCotacoes.add(CotacaoModel.CotacaoBuilder.builder().setIdadeMin(idade_min).setIdadeMax(idade_max).setApartamentoPreco(preco_apartamento).setEnfermariaPreco(preco_enfermaria).build());
                }
                return listCotacoes;
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
    private Boolean filterCorretora(CotacaoModel cotacaoModel, int user_idade) {
        if (!cotacaoModel.getIdade_max().equals("null")) {
            if (user_idade >= Integer.parseInt(cotacaoModel.getIdade_min()) && user_idade <= Integer.parseInt(cotacaoModel.getIdade_max())) {
                return true;

            }
        } else {
            return false;
        }
        return false;
    }

}