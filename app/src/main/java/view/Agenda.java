package view;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.applandeo.materialcalendarview.CalendarView;
import com.applandeo.materialcalendarview.EventDay;
import com.applandeo.materialcalendarview.listeners.OnDayClickListener;
import com.example.corretagemapp.R;
import com.example.corretagemapp.controllers.CompromissosController;
import com.example.corretagemapp.models.DataCompromissoModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Agenda extends AppCompatActivity {
    private CalendarView calendarView;
    private List<EventDay> myEvents = new ArrayList<>();
    private FloatingActionButton fab;
    private List<DataCompromissoModel> listDataCompromissos;
    CompromissosController compromissosController;
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_CorretagemApp);
        setContentView(R.layout.activity_calendar);
        compromissosController = new CompromissosController(getBaseContext());
        listDataCompromissos = compromissosController.getAllDates();
        fab = findViewById(R.id.fab_agenda);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        calendarView = (CalendarView) findViewById(R.id.calendarView);
        listDataCompromissos.forEach(dataCompromissoModel -> setDateCompromisso(dataCompromissoModel));
        calendarView.setEvents(myEvents);
        calendarView.setOnDayClickListener(new OnDayClickListener() {
            @Override
            public void onDayClick(EventDay eventDay) {
                if(myEvents.contains(eventDay)){
                    String data;
                    String dia =  String.valueOf(eventDay.getCalendar().get(Calendar.DAY_OF_MONTH));
                    //O metodo Calendar.Month retorna o mes com sempre -1 ex: Mes 2 ele retorna mes 1.
                    String mes = String.valueOf(eventDay.getCalendar().get(Calendar.MONTH) + 1);
                    String ano =  String.valueOf(eventDay.getCalendar().get(Calendar.YEAR));
                    if(Integer.parseInt(mes) <= 9){
                        if(Integer.parseInt(dia) <= 9){
                            data =  "0" + dia + "/"  + "0" + mes + "/" + ano;
                        }
                        else{
                            data =   dia + "/"  + "0" + mes + "/" + ano;
                        }
                    }
                    else{
                        data = dia + "/"  +  mes + "/" + ano;
                    }
                    Intent intent = new Intent(getApplicationContext(),  CompromissosAgendados.class);
                    intent.putExtra("data", data);
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
    private void setDateCompromisso(DataCompromissoModel compromisso){
        Calendar c = Calendar.getInstance();
        c.set(Integer.parseInt(compromisso.ano), Integer.parseInt(compromisso.mes) - 1, Integer.parseInt(compromisso.dia));
        myEvents.add(new EventDay( c, R.drawable.ic_breakpoint));
    }
}