package com.example.corretagemapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.applandeo.materialcalendarview.CalendarUtils;
import com.applandeo.materialcalendarview.CalendarView;
import com.applandeo.materialcalendarview.EventDay;
import com.applandeo.materialcalendarview.listeners.OnDayClickListener;
import com.example.corretagemapp.controllers.CompromissosController;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Agenda extends AppCompatActivity {
    private CalendarView calendarView;
    private List<EventDay> myEvents = new ArrayList<>();
    private FloatingActionButton fab;
    CompromissosController compromissosController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        compromissosController = new CompromissosController(getBaseContext());
        compromissosController.getAllDates();
        fab = findViewById(R.id.fab_agenda);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        calendarView = (CalendarView) findViewById(R.id.calendarView);
        Calendar c = Calendar.getInstance();
        c.set(2021, Calendar.FEBRUARY, 28);
        myEvents.add(new EventDay( c, R.drawable.cicle_avatar));
        calendarView.setEvents(myEvents);
        calendarView.setOnDayClickListener(new OnDayClickListener() {
            @Override
            public void onDayClick(EventDay eventDay) {
                if(myEvents.contains(eventDay)){
                    Log.i("Estee", "È o evento bixo");
                    Log.i("Calendario", String.valueOf(eventDay.getCalendar().get(Calendar.YEAR)));
                    Intent intent = new Intent(getApplicationContext(),  CompromissosAgendados.class);
                    startActivity(intent);
                }

            }
        });
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),  AdicionarCompromisso.class);
                startActivity(intent);
            }
        });
    }

}