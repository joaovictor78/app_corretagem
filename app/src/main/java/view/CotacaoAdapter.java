package view;



import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.example.corretagemapp.R;
import com.example.corretagemapp.models.CotacaoModel;
import com.example.corretagemapp.models.CotacaoModelPreco;

import java.util.List;

public class CotacaoAdapter extends RecyclerView.Adapter<CotacaoAdapter.CotacaoViewHolder> {
    private final List<CotacaoModel> cotacoes;
    CotacaoAdapter(List<CotacaoModel> cotacoes){
        this.cotacoes = cotacoes;
    }
    @NonNull
    @Override
    public CotacaoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.cotacao_card, parent, false
        );
        return  new CotacaoViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull CotacaoViewHolder holder, int position) {
        holder.bind(cotacoes.get(position));
    }

    @Override
    public int getItemCount() {
        return cotacoes.size();
    }
     static class CotacaoViewHolder extends RecyclerView.ViewHolder{
         private Context context;
         TextView idade;
         LinearLayout apartamento_title;
         LinearLayout apartamento_preco;
         LinearLayout enfermangem_title;
         LinearLayout enfermagem_preco;
         private boolean isIdade = false;
         TextView textViewDinamic;
         public CotacaoViewHolder(@NonNull View itemView) {
             super(itemView);
             idade = itemView.findViewById(R.id.idade);
             apartamento_title = itemView.findViewById(R.id.title_apartamento);
             apartamento_preco = itemView.findViewById(R.id.preco_apartamento);
             enfermagem_preco = itemView.findViewById(R.id.preco_enfermagem);
             enfermangem_title = itemView.findViewById(R.id.title_enfermagem);
         }

         public void bind(CotacaoModel cotacaoModel){
           idade.setText(cotacaoModel.getIdade());
           List<CotacaoModelPreco> listApartamentoPreco = cotacaoModel.getListApartamentoPreco();
           for(int count = 0; count < listApartamentoPreco.size(); count++){
               textViewDinamic = new TextView(itemView.getContext().getApplicationContext());
               textViewDinamic.setText(listApartamentoPreco.get(count).getTitle());
               apartamento_title.addView(textViewDinamic);
           }

           //apartamento_preco.setText(cotacaoModel.getListApartamentoPreco().get(0).getTitle());
           //enfermagem_preco.setText(cotacaoModel.getListEnfermagemPreco().get(0).getTitle());
         }
     }

     }

