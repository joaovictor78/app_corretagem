package view;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.example.corretagemapp.R;
import com.example.corretagemapp.controllers.FuncionarioController;
import com.example.corretagemapp.models.Funcionario;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class FragFuncionarios extends Fragment {

    // Add RecyclerView member
    private RecyclerView recyclerViewFuncionario;
    private FuncionarioAdapter funcionarioAdapter;
    private FuncionarioController controller;
    String ultimodigito = "";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        controller = new FuncionarioController(getActivity().getBaseContext());

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_employees, container, false);
        FloatingActionButton fab = view.findViewById(R.id.fab_addfuncionarios);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater layoutInflaterAndroid = LayoutInflater.from(getContext());
                View mView = layoutInflaterAndroid.inflate(R.layout.diagol_new_employees, null);
                AlertDialog.Builder alertDialogBuilderUserInput = new AlertDialog.Builder(getContext());
                alertDialogBuilderUserInput.setView(mView);

                final EditText name = (EditText) mView.findViewById(R.id.userInputName);
                final EditText email = (EditText) mView.findViewById(R.id.userInputEmail);
                final EditText phone = (EditText) mView.findViewById(R.id.userInputPhone);
               phone.addTextChangedListener(new TextWatcher() {
                   @Override
                   public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                        Integer digito = phone.getText().toString().length();
                        if(digito > 1){
                            ultimodigito = phone.getText().toString().substring(digito - 1);

                        }
                   }

                   @Override
                   public void onTextChanged(CharSequence s, int start, int before, int count) {
                       Integer digito = phone.getText().toString().length();
                       if(digito == 2){
                           if(!ultimodigito.equals(" ")){
                               phone.append(" ");
                           } else {
                               phone.getText().delete(digito -1, digito);
                           }
                       } else if (digito == 8){
                           if(!ultimodigito.equals("-")){
                               phone.append("-");
                           } else {
                               phone.getText().delete(digito -1, digito);
                           }
                       }
                   }

                   @Override
                   public void afterTextChanged(Editable s) {

                   }
               });

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
        ArrayList<Funcionario> funcionarios = (ArrayList<Funcionario>) controller.buscarFuncionario();
        recyclerViewFuncionario = view.findViewById(R.id.lista_funcionarios);
        funcionarioAdapter = new FuncionarioAdapter(funcionarios);
        recyclerViewFuncionario.setAdapter(funcionarioAdapter);
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT){
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

                String result = controller.deleteFuncionarioById(funcionarios.get(viewHolder.getAdapterPosition()).getId());
                Toast.makeText(getActivity().getApplicationContext(), result, Toast.LENGTH_SHORT).show();
            }
        }).attachToRecyclerView(recyclerViewFuncionario);
        return view;
    }


}
