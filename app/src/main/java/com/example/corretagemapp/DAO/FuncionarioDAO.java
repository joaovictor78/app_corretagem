package com.example.corretagemapp.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.corretagemapp.database.DataBase;
import com.example.corretagemapp.models.Funcionario;

import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {
    private SQLiteDatabase db;
    private DataBase database;
    public FuncionarioDAO(Context context){
        database = new DataBase(context);
    }
    public void insertFuncionario(Funcionario funcionario) throws Exception {
        ContentValues contentValues;
        long result;
        db = database.getWritableDatabase();
        contentValues = new ContentValues();
        contentValues.put("nome_funcionario",funcionario.getName());
        contentValues.put("numero_funcionario", funcionario.getPhone());
        contentValues.put("email_funcionario", funcionario.getEmail());
        result = db.insert("funcionario", null, contentValues);
        db.close();
        if(result == -1){
            throw new Exception("Número não pode ser menor que zero!");
        }
    }
    public List<Funcionario> selectFuncionario(){
        String selectFuncionario = "SELECT * FROM  funcionario;";
        db = database.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectFuncionario, null);

        List<Funcionario> listFuncionarios = new ArrayList();
        while(cursor.moveToNext()){

            String nome = cursor.getString(cursor.getColumnIndex("nome_funcionario"));
            String email = cursor.getString(cursor.getColumnIndex("email_funcionario"));
            String numero = cursor.getString(cursor.getColumnIndex("numero_funcionario"));

            Funcionario funcionario = Funcionario.FuncionarioBuilder.builder().setName(nome).setEmail(email).setPhone(numero).build();
            listFuncionarios.add(funcionario);

        }
        db.close();
        cursor.close();
        return listFuncionarios;
    }
    public void selectAllFuncionario(){

    }
    public void deleteFuncionario(){

    }
}
