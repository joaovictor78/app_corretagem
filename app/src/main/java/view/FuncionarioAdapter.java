package view;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.example.corretagemapp.R;
import com.example.corretagemapp.models.Funcionario;

import java.util.ArrayList;
import java.util.List;

public class FuncionarioAdapter extends RecyclerView.Adapter<FuncionarioAdapter.FuncionarioViewHolder> {
    private List<Funcionario> funcionarios;

    public FuncionarioAdapter(ArrayList<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    @NonNull
    @Override
    public FuncionarioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.card_funcionarios, parent, false
        );
        return new FuncionarioAdapter.FuncionarioViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull FuncionarioViewHolder holder, int position) {
        Funcionario funcionario = funcionarios.get(position);
        holder.bind(funcionario);
    }
    public void deleteItem(){
        Log.i("DELETE", "EXECUTADO COM SUCESSO!");
    }

    @Override
    public int getItemCount() {
        return funcionarios.size();
    }

    class FuncionarioViewHolder extends RecyclerView.ViewHolder {
        TextView nome;
        TextView email;
        TextView phone;
        TextView text_icon;

        FuncionarioViewHolder(@NonNull View itemView) {
            super(itemView);
            nome = itemView.findViewById(R.id.name_funcionario);
            email = itemView.findViewById(R.id.email_funcionario);
            phone = itemView.findViewById(R.id.phone_funcionario);
            text_icon = itemView.findViewById(R.id.text_circlericon);

        }

        public void bind(Funcionario funcionario) {
            nome.setText(funcionario.getName());
            email.setText(funcionario.getEmail());
            phone.setText(funcionario.getPhone());
            text_icon.setText(String.valueOf(funcionario.getName().charAt(0)));
        }
    }
}