package view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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