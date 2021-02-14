package com.example.corretagemapp.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.corretagemapp.database.DataBase;
import com.example.corretagemapp.models.CompromissoModel;

public class CompromissosDAO {
    private SQLiteDatabase db;
    private DataBase database;
    public CompromissosDAO(Context context){
        database = new DataBase(context);
    }
    public void insertCompromisso(CompromissoModel compromisso) throws Exception {
        ContentValues contentValues;
        long result;
        db = database.getWritableDatabase();
        contentValues = new ContentValues();
        contentValues.put("assunto",compromisso.getAssunto());
        contentValues.put("data", compromisso.getData());
        contentValues.put("horario", compromisso.getHorario());
        contentValues.put("descricao", compromisso.getDescricao());
        result = db.insert("compromisso", null, contentValues);
        db.close();
        if(result == -1){
            throw new Exception("Número não pode ser menor que zero!");
        }
    }
    public void selectCompromissos(){
        String selectCompromissos = "SELECT * FROM  compromisso;";
        db = database.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectCompromissos, null);
        while(cursor.moveToNext()){

        }
        db.close();
        cursor.close();
    }
    public void selectAllCompromissos(){

    }
    public void deleteCompromissos(){

    }
    public void deleteAllCompromissos(){

    }
}
