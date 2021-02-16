 package com.example.corretagemapp.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.corretagemapp.database.DataBase;
import com.example.corretagemapp.models.CompromissoModel;
import com.example.corretagemapp.models.DataCompromissoModel;

import java.util.ArrayList;
import java.util.List;

 public class CompromissosDAO {
    private SQLiteDatabase db;
    private DataBase database;
    public CompromissosDAO(Context context){
        database = new DataBase(context);
    }
    public void insertCompromisso(CompromissoModel compromisso) throws Exception {
        ContentValues contentValuesCompromisso;
        ContentValues contentValuesDataCompromisso;
        long resultCompromisso;
        long resultDataCompromisso;
        db = database.getWritableDatabase();
        contentValuesCompromisso = new ContentValues();
        contentValuesDataCompromisso = new ContentValues();
        contentValuesCompromisso.put("assunto", compromisso.getAssunto());
        contentValuesCompromisso.put("horario", compromisso.getHorario());
        contentValuesCompromisso.put("descricao", compromisso.getDescricao());
        resultCompromisso = db.insert("compromisso", null, contentValuesCompromisso);
        contentValuesDataCompromisso.put("id_compromisso", resultCompromisso);
        contentValuesDataCompromisso.put("data", compromisso.getData());
        resultDataCompromisso = db.insert("data_compromisso", null, contentValuesDataCompromisso);
        if(resultCompromisso == -1 || resultDataCompromisso == -1){
            throw new Exception("Erro ao cadastrar compromisso!");
        }
        db.close();
    }
    public List<DataCompromissoModel> getAllDateCompromissos(){
        db = database.getReadableDatabase();
        String selectDataAllQuery = "SELECT * FROM data_compromisso;";
        Cursor cursor = db.rawQuery(selectDataAllQuery, null);
        List<DataCompromissoModel> dataCompromisso = new ArrayList();
        while(cursor.moveToNext()){
            String valor = cursor.getString(cursor.getColumnIndex("data"));
            String dia = valor.substring(0, 2);
            String mes = valor.substring(3, 5);
            String ano = valor.substring(6, 10);
            DataCompromissoModel data = new DataCompromissoModel(dia, mes, ano);
            dataCompromisso.add(data);
        }
        cursor.close();
        db.close();
        return dataCompromisso;
    }
}
