package view;



import android.annotation.SuppressLint;
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

import static com.example.corretagemapp.R.color.orange_pure;

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
         TextView textEnfermagemTitle;
         TextView textEnfermagemPreco;
         TextView textApartamentoTitle;
         TextView textApartamentoPreco;
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
           List<CotacaoModelPreco> listEnfermariaPreco = cotacaoModel.getListEnfermagemPreco();
           List<String> listCarencia = cotacaoModel.getListCarencia();
           for(int count = 0; count < listEnfermariaPreco.size(); count++){
               textEnfermagemTitle = new TextView(itemView.getContext().getApplicationContext());
               textEnfermagemTitle.setText(listEnfermariaPreco.get(count).getTitle());
               textEnfermagemPreco = new TextView(itemView.getContext().getApplicationContext());
               textEnfermagemPreco.setText(listEnfermariaPreco.get(count).getPreco());
               enfermangem_title.addView(textEnfermagemTitle);
               enfermagem_preco.addView(textEnfermagemPreco);


           }
           for(int count = 0; count < listApartamentoPreco.size(); count ++){
               textApartamentoTitle = new TextView(itemView.getContext().getApplicationContext());
               textApartamentoTitle.setText(listApartamentoPreco.get(count).getTitle());
               textApartamentoPreco = new TextView(itemView.getContext().getApplicationContext());
               textApartamentoPreco.setText(listApartamentoPreco.get(count).getPreco());
               apartamento_title.addView(textApartamentoTitle);
               apartamento_preco.addView(textApartamentoPreco);
           }
         }
     }

     }

