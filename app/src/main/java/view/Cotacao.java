package view;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.corretagemapp.R;
import com.example.corretagemapp.models.CotacaoModel;
import com.example.corretagemapp.models.CotacaoModelPreco;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cotacao extends AppCompatActivity {
    RecyclerView recyclerView;
    JSONObject jsonObjectCorretora;
    ArrayList<CotacaoModel> listCotacao;
    ArrayList<CotacaoModel>  minhasCotacoes = new ArrayList<>();
    int id_image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_CorretagemApp);
        setContentView(R.layout.activity_member_price);
        try {
            Bundle args = new Bundle();
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                String value = extras.getString("corretoraSelected");
                id_image = extras.getInt("id_image");
                jsonObjectCorretora = new JSONObject(value);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        listCotacao = initListCotacaoOperados();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Button calcularTotalButton = findViewById(R.id.calcular_total);
        TextView textEmpty = findViewById(R.id.textEmpty);
        calcularTotalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!minhasCotacoes.isEmpty()){
                    Intent intent = new Intent(getApplicationContext(), ValorTotalCotacao.class);
                    intent.putExtra("dados", minhasCotacoes);
                    intent.putExtra("id_image", id_image);
                    startActivity(intent);
                } else{
                    Toast.makeText(getApplicationContext(), "Nenhuma cotação adicionada!",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
        //Add lines for cotacaoAdapter
        recyclerView = findViewById(R.id.lista_cotacao);
        recyclerView.setAdapter(new CotacaoAdapter(minhasCotacoes));
        Button addButton = findViewById(R.id.adicionar_pessoa);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater layoutInflaterAndroid = LayoutInflater.from(Cotacao.this);
                View mView = layoutInflaterAndroid.inflate(R.layout.dialog_new_member, null);
                AlertDialog.Builder alertDialogBuilderUserInput = new AlertDialog.Builder(Cotacao.this);
                alertDialogBuilderUserInput.setView(mView);
                final EditText idade = (EditText) mView.findViewById(R.id.userInputIdade);
                alertDialogBuilderUserInput
                        .setCancelable(false)
                        .setPositiveButton("Adicionar", new DialogInterface.OnClickListener() {
                            @RequiresApi(api = Build.VERSION_CODES.N)
                            public void onClick(DialogInterface dialogBox, int id) {
                                if (idade.getText().length() != 0) {
                                    String user_idade = idade.getText().toString();
                                    if(idade.getText().toString().matches("(\\d{1,2})")){
                                        Stream<CotacaoModel> lista = listCotacao.stream().filter(cotacaoModel -> filterCorretora(cotacaoModel, Integer.parseInt(user_idade)));
                                        List<CotacaoModel> cotacaoEscolhida = lista.collect(Collectors.toList());
                                        CotacaoModel cotacao = cotacaoEscolhida.get(0);
                                        cotacao.setIdade(user_idade.toString());
                                        minhasCotacoes.add(cotacao);
                                    }else{
                                        Toast.makeText(getApplicationContext(), "Idade Incorreta!!", Toast.LENGTH_LONG).show();

                                    }
                                    if (minhasCotacoes.isEmpty()) {
                                        recyclerView.setVisibility(View.GONE);
                                        textEmpty.setVisibility(View.VISIBLE);
                                    }
                                    else {
                                        recyclerView.setVisibility(View.VISIBLE);
                                        textEmpty.setVisibility(View.GONE);
                                    }
                                }
                                else {
                                    Toast.makeText(getApplicationContext(), "Nenhuma idade adicionada!",
                                            Toast.LENGTH_LONG).show();}
                            }
                        })

                        .setNegativeButton("Cancelar",
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
            JSONArray arrayCarencias = jsonObjectCorretora.getJSONArray("carencia");
            if (array != null) {
                for (int i = 0; i < array.length(); i++) {
                    List<CotacaoModelPreco> cotacaoModelPrecoEnfermagemList = new ArrayList<>();
                    List<CotacaoModelPreco> cotacaoModelPrecoApartamentoList = new ArrayList<>();
                    List<String> listCarencia = new ArrayList<>();
                    JSONObject operadora = array.getJSONObject(i);
                    String idade_min = operadora.getString("idade_min");
                    String idade_max = operadora.getString("idade_max");
                    JSONArray valorPorTipo = operadora.getJSONArray("valor_por_tipo");
                    if (valorPorTipo != null) {
                        for (int count = 0; count < valorPorTipo.length(); count ++){
                            if(valorPorTipo.getJSONObject(count).getString("tipo").equals("1")){
                                cotacaoModelPrecoEnfermagemList.add(CotacaoModelPreco.CotacaoModelPrecoBuilder.builder().setTipo(valorPorTipo.getJSONObject(count).getInt("tipo")).setPreco(valorPorTipo.getJSONObject(count).getString("valor")).setTitle(valorPorTipo.getJSONObject(count).getString("title")).build());
                            } else if(valorPorTipo.getJSONObject(count).getString("tipo").equals("2")){
                                cotacaoModelPrecoApartamentoList.add(CotacaoModelPreco.CotacaoModelPrecoBuilder.builder().setTipo(valorPorTipo.getJSONObject(count).getInt("tipo")).setPreco(valorPorTipo.getJSONObject(count).getString("valor")).setTitle(valorPorTipo.getJSONObject(count).getString("title")).build());
                            }
                            for(int x = 0; x < arrayCarencias.length(); x++){
                                listCarencia.add(arrayCarencias.getJSONObject(x).getString("message").toString());
                            }

                        }
                    }
                    listCotacoes.add(CotacaoModel.CotacaoBuilder.builder().setIdadeMin(idade_min).setIdadeMax(idade_max).setApartamentoPreco(cotacaoModelPrecoApartamentoList).setEnfermariaPreco(cotacaoModelPrecoEnfermagemList).setCarencia(listCarencia).build());
                }

            }
            return listCotacoes;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
    private Boolean filterCorretora(CotacaoModel cotacaoModel, int user_idade) {
            if (user_idade >= Integer.parseInt(cotacaoModel.getIdade_min()) && user_idade <= Integer.parseInt(cotacaoModel.getIdade_max())) {
                return true;
            }
        return false;
    }

}