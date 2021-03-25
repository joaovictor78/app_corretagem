package view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.corretagemapp.R;
import com.example.corretagemapp.models.CompromissoModel;

import java.util.List;

public class CompromissosAdapter  extends RecyclerView.Adapter<CompromissosAdapter.CompromissosViewHolder> {
    private List<CompromissoModel> compromissos;
    CompromissosAdapter(List<CompromissoModel> compromissos){
        this.compromissos = compromissos;
    }
    @NonNull
    @Override
    public CompromissosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.card_schedule, parent, false
        );
        return new CompromissosViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CompromissosViewHolder holder, int position) {
        holder.bind(compromissos.get(position));
    }

    @Override
    public int getItemCount() {
        return compromissos.size();
    }
    public class CompromissosViewHolder extends RecyclerView.ViewHolder{
        TextView assunto;
        TextView hora;
        TextView descricao;
        public CompromissosViewHolder(@NonNull View itemView) {
            super(itemView);
            assunto = itemView.findViewById(R.id.assunto_compromisso);
            hora = itemView.findViewById(R.id.hora_compromisso);
            descricao = itemView.findViewById(R.id.descricao_compromisso);
        }
        public void bind(CompromissoModel compromisso) {
            assunto.setText(compromisso.getAssunto());
            hora.setText(compromisso.getHorario());
            descricao.setText(compromisso.getDescricao());
        }
        }
    }

