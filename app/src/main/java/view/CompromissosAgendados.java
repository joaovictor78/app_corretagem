package view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.corretagemapp.R;

public class CompromissosAgendados extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compromissos_agendados);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}