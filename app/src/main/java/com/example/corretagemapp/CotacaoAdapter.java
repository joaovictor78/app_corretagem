package com.example.corretagemapp;



import android.media.Image;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.corretagemapp.models.CotacaoModel;

import org.json.JSONException;
import org.json.JSONObject;

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
        return new CotacaoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CotacaoViewHolder holder, int position) {
        holder.bind(cotacoes.get(position));
    }

    @Override
    public int getItemCount() {
        return cotacoes.size();
    }
     class CotacaoViewHolder extends RecyclerView.ViewHolder{
         TextView idade;
         TextView apartamento_preco;
         TextView enfermagem_preco;
         public CotacaoViewHolder(@NonNull View itemView) {
             super(itemView);
             idade = itemView.findViewById(R.id.idade);
             apartamento_preco = itemView.findViewById(R.id.preco_apartamento);
             enfermagem_preco = itemView.findViewById(R.id.preco_enfermagem);

         }
         public void bind(CotacaoModel cotacaoModel){
           idade.setText(cotacaoModel.getIdade());
           apartamento_preco.setText(cotacaoModel.getApartamento_preco());
           enfermagem_preco.setText(cotacaoModel.getEnfermaria_preco());


         }
     }
}

