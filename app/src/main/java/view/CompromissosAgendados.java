package view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.corretagemapp.R;
import com.example.corretagemapp.controllers.CompromissosController;

public class CompromissosAgendados extends AppCompatActivity {
    private CompromissosController controller;
    private RecyclerView recyclerView;
    private TextView dataText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compromissos_agendados);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent intent = getIntent();
        String data = intent.getStringExtra("data");
        dataText = findViewById(R.id.compromisso_data);
        dataText.setText(data);
        controller = new CompromissosController(getBaseContext());
        recyclerView = findViewById(R.id.list_view_compromissos);
        recyclerView.setAdapter(new CompromissosAdapter(controller.getAllCompromissos(data)));
    }
}