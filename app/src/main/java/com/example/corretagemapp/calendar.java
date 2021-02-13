package com.example.corretagemapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.applandeo.materialcalendarview.CalendarUtils;
import com.applandeo.materialcalendarview.CalendarView;
import com.applandeo.materialcalendarview.EventDay;
import com.applandeo.materialcalendarview.listeners.OnDayClickListener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class calendar extends AppCompatActivity {
    private CalendarView calendarView;
    private List<EventDay> myEvents = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        calendarView = (CalendarView) findViewById(R.id.calendarView);
        Calendar calendarD = Calendar.getInstance();
        myEvents.add(new EventDay(calendarD, R.drawable.cicle_avatar));
        calendarView.setEvents(myEvents);
        calendarView.setOnDayClickListener(new OnDayClickListener() {
            @Override
            public void onDayClick(EventDay eventDay) {
                if(myEvents.contains(eventDay))
                Log.i("Estee", "È o evento bixo");
            }
        });
    }

}