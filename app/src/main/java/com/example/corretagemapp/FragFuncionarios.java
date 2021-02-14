package com.example.corretagemapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.corretagemapp.models.Funcionarios;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

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
        FloatingActionButton fab = view.findViewById(R.id.fab_addfuncionarios);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater layoutInflaterAndroid = LayoutInflater.from(getContext());
                View mView = layoutInflaterAndroid.inflate(R.layout.add_funcionario, null);
                AlertDialog.Builder alertDialogBuilderUserInput = new AlertDialog.Builder(getContext());
                alertDialogBuilderUserInput.setView(mView);

                final EditText name = (EditText) mView.findViewById(R.id.userInputName);
                final EditText email = (EditText) mView.findViewById(R.id.userInputName);
                final EditText phone = (EditText) mView.findViewById(R.id.userInputName);
                alertDialogBuilderUserInput
                        .setCancelable(false)
                        .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogBox, int id) {
                                // ToDo get user input here
                            }
                        })

                        .setNegativeButton("Cancell",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialogBox, int id) {
                                        dialogBox.cancel();
                                    }
                                });

                AlertDialog alertDialogAndroid = alertDialogBuilderUserInput.create();
                alertDialogAndroid.show();
            }
        });

        recyclerView = view.findViewById(R.id.lista_funcionarios);
        funcionarioAdapter = new FuncionarioAdapter(new ArrayList<>(Funcionarios.listFuncionario()));
        recyclerView.setAdapter(funcionarioAdapter);
        return view;
    }
}
