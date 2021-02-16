package view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.corretagemapp.R;
import com.example.corretagemapp.controllers.CompromissosController;

public class AdicionarCompromisso extends AppCompatActivity {
   CompromissosController compromissosController;
   EditText assunto;
   EditText data;
   EditText hora;
   EditText descricao;
   Button saveCompromisso;
   private String lastCharacter = "";
   private String result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_compromisso);
        saveCompromisso = findViewById(R.id.salvar_compromisso);
        assunto = findViewById(R.id.input_assunto);
        data = findViewById(R.id.input_data);
        hora = findViewById(R.id.input_horario);
        descricao = findViewById(R.id.input_descricao);
        data.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Integer lengthData = data.getText().length();
                if(lengthData > 1){
                    lastCharacter = data.getText().toString().substring(lengthData - 1);
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Integer lengthData = data.getText().length();
                if(lengthData == 2){
                    if(!lastCharacter.equals("/")) {
                        data.getText().append("/");
                    } else{
                        data.getText().delete(lengthData - 1, lengthData);
                    }
                } else if(lengthData == 5){
                    if(!lastCharacter.equals("/")) {
                        data.getText().append("/");
                    } else{
                        data.getText().delete(lengthData - 1, lengthData);
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        compromissosController = new CompromissosController(getBaseContext());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        saveCompromisso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compromissosController.assunto = assunto.getText().toString();
                compromissosController.data = data.getText().toString();
                compromissosController.hora = hora.getText().toString();
                compromissosController.descricao = descricao.getText().toString();
                result = compromissosController.salveCompromisso();
                Toast.makeText(getApplicationContext(), result,   Toast.LENGTH_LONG).show();
                finish();
            }
        });

    }
}