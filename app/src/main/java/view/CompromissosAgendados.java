package view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.corretagemapp.R;
import com.example.corretagemapp.controllers.CompromissosController;

public class CompromissosAgendados extends AppCompatActivity {
    private CompromissosController controller;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compromissos_agendados);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        controller = new CompromissosController(getBaseContext());
        controller.getAllCompromissos();
    }
}