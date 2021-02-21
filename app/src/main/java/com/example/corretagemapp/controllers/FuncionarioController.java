package com.example.corretagemapp.controllers;

import android.content.Context;

import com.example.corretagemapp.DAO.CompromissosDAO;
import com.example.corretagemapp.DAO.FuncionarioDAO;
import com.example.corretagemapp.models.CompromissoModel;
import com.example.corretagemapp.models.Funcionario;

import java.util.List;

public class FuncionarioController {
    private FuncionarioDAO funcionario;
    private Funcionario funcionarioModel;
    public String nome;
    public String numero;
    public String email;


    public  FuncionarioController(Context context){
        funcionario = new FuncionarioDAO(context);
        funcionarioModel = new Funcionario();
    }
    public String salveFuncionario(){
        funcionarioModel.setName(nome);
        funcionarioModel.setPhone(numero);
        funcionarioModel.setEmail(email);
        try {
            funcionario.insertFuncionario(funcionarioModel);
            return "Funcionário salvo com sucesso!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Erro ao salvar Funcionário!";
        }
    }
    public List<Funcionario> buscarFuncionario() {
        return  funcionario.selectFuncionario();
    }
    public String deleteFuncionarioById(String id){
        try{
            funcionario.deleteFuncionarioById(id);
            return "Funcionario apagado com sucesso!";
        } catch (Exception e) {
            return "Erro ao apagar funcionario!";
        }

    }
}
