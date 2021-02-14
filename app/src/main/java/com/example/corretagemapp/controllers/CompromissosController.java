package com.example.corretagemapp.controllers;


import android.content.Context;

import com.example.corretagemapp.DAO.CompromissosDAO;
import com.example.corretagemapp.models.CompromissoModel;

public class CompromissosController {
    private CompromissosDAO compromissos;
    private CompromissoModel compromissoModel;
    public String assunto;
    public String data;
    public String hora;
    public String descricao;
    private String result;


    public  CompromissosController(Context context){
      compromissos = new CompromissosDAO(context);
      compromissoModel = new CompromissoModel();
    }
    public String salveCompromisso(){
        compromissoModel.setAssunto(assunto);
        compromissoModel.setData(data);
        compromissoModel.setHorario(hora);
        compromissoModel.setDescricao(descricao);
        try {
            compromissos.insertCompromisso(compromissoModel);
            return "Compromisso salvo com sucesso!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Erro ao salvar compromisso!";
        }
    }
}
