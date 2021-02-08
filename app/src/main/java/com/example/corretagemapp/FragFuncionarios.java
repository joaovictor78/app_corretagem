package com.example.corretagemapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.RecyclerView;

import com.example.corretagemapp.models.Corretoras;
import com.example.corretagemapp.models.Funcionarios;

import java.util.ArrayList;

public class FragFuncionarios extends Fragment {
    // Add RecyclerView member
    private RecyclerView recyclerView;
    private FuncionarioAdapter funcionarioAdapter;
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_funcionarios, container, false);
        recyclerView = view.findViewById(R.id.lista_funcionarios);
        funcionarioAdapter = new FuncionarioAdapter(new ArrayList<>(Funcionarios.listFuncionario()));
        recyclerView.setAdapter(funcionarioAdapter);
        return view;
    }
}
