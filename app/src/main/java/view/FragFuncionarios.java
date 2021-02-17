package view;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.corretagemapp.R;
import com.example.corretagemapp.controllers.FuncionarioController;
import com.example.corretagemapp.models.Funcionario;
import com.example.corretagemapp.models.Funcionarios;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class FragFuncionarios extends Fragment {
    // Add RecyclerView member
    private RecyclerView recyclerView;
    private FuncionarioAdapter funcionarioAdapter;
    private FuncionarioController controller;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
        controller = new FuncionarioController(getActivity().getBaseContext());
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
                final EditText email = (EditText) mView.findViewById(R.id.userInputEmail);
                final EditText phone = (EditText) mView.findViewById(R.id.userInputPhone);
                alertDialogBuilderUserInput
                        .setCancelable(false)
                        .setPositiveButton("Adicionar", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogBox, int id) {
                                controller.nome = name.getText().toString();
                                controller.email = email.getText().toString();
                                controller.numero = phone.getText().toString();
                                controller.salveFuncionario();
                            }
                        })

                        .setNegativeButton("Cancelar",
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
        funcionarioAdapter = new FuncionarioAdapter((ArrayList<Funcionario>) controller.buscarFuncionario());
        recyclerView.setAdapter(funcionarioAdapter);
        return view;
    }
}
