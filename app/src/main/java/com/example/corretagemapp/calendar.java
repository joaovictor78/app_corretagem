package com.example.corretagemapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.Toast;

import com.applandeo.materialcalendarview.CalendarUtils;
import com.applandeo.materialcalendarview.CalendarView;
import com.applandeo.materialcalendarview.EventDay;

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
        Drawable text = CalendarUtils.getDrawableText(getApplicationContext(), "Joao Victorrrr",  Typeface.DEFAULT_BOLD, android.R.color.black, 15);
        myEvents.add(new EventDay(calendarD, text));
        calendarView.setEvents(myEvents);
    }

}