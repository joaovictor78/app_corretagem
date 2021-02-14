package com.example.corretagemapp.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.corretagemapp.database.DataBase;
import com.example.corretagemapp.models.CompromissoModel;

public class CompromissosDAO {
    private SQLiteDatabase db;
    private DataBase database;
    public CompromissosDAO(Context context){
        database = new DataBase(context);
    }
    public String insertCompromisso(CompromissoModel compromisso){
        ContentValues contentValues;
        long result;
        db = database.getWritableDatabase();
        contentValues = new ContentValues();
        contentValues.put("assunto",compromisso.getAssunto());
        contentValues.put("data", compromisso.getData());
        contentValues.put("hora", compromisso.getHorario());
        contentValues.put("descricao", compromisso.getDescricao());
        result = db.insert("compromisso", null, contentValues);
        db.close();
        if(result == -1){
            return "Erro ao inserir compromisso!";
        }else{
            return "Compromisso salvo com sucesso!";
        }
    }
}
