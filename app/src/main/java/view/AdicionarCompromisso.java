package view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
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
   private boolean isDateValidate = false;
   private boolean isHoraValidate = false;
   private String lastCharacterDate = "";
    private String lastCharacterHora = "";
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
                    lastCharacterDate = data.getText().toString().substring(lengthData - 1);
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Integer lengthData = data.getText().toString().length();
                if(lengthData == 2){
                    if(!lastCharacterDate.equals("/")) {
                        data.getText().append("/");
                    } else{
                        data.getText().delete(lengthData - 1, lengthData);
                    }
                } else if(lengthData == 5){
                    if(!lastCharacterDate.equals("/")) {
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
        hora.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Integer lengthHora = hora.getText().length();
                if(lengthHora > 1){
                    lastCharacterHora = hora.getText().toString().substring(lengthHora - 1);
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Integer lengthHora = hora.getText().toString().length();
                if(lengthHora == 2){
                    if(!lastCharacterHora.equals(":")) {
                        hora.getText().append(":");
                    } else{
                        hora.getText().delete(lengthHora - 1, lengthHora);
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
                if(data.getText().toString().matches("(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/\\d{4}")){
                    compromissosController.data = data.getText().toString();
                    isDateValidate = true;
                }else{
                    Log.i("TESTE", "HELLO WORD");
                    Toast.makeText(getApplicationContext(), "Formato da data invalido!", Toast.LENGTH_LONG).show();
                    isDateValidate = false;
                }
                compromissosController.hora = hora.getText().toString();
                if(hora.getText().toString().matches("^(0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]$")){
                    compromissosController.hora = hora.getText().toString();
                    isHoraValidate = true;
                }else{
                    Toast.makeText(getApplicationContext(), "Formato de hora invalido!", Toast.LENGTH_LONG).show();
                    isHoraValidate = false;
                }
                compromissosController.descricao = descricao.getText().toString();
                if(isHoraValidate == true && isDateValidate == true){
                    result = compromissosController.salveCompromisso();
                    Toast.makeText(getApplicationContext(), result,   Toast.LENGTH_LONG).show();
                    finish();
                }
            }
        });

    }
}