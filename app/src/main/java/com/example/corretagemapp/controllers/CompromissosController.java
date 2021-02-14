package com.example.corretagemapp.controllers;


import android.content.Context;

import com.example.corretagemapp.DAO.CompromissosDAO;
import com.example.corretagemapp.models.CompromissoModel;

public class CompromissosController {
    public CompromissosDAO compromissos;
    String result;
    public String CompromissosController(Context context, CompromissoModel compromissoModel){
      compromissos = new CompromissosDAO(context);
      result = compromissos.insertCompromisso(compromissoModel);
      return result;
    }
}
