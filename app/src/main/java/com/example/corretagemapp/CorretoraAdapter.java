package com.example.corretagemapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.corretagemapp.models.Corretora;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class CorretoraAdapter extends RecyclerView.Adapter<CorretoraAdapter.CorretoraViewHolder> {
    private final List<Corretora> corretoras;

    public CorretoraAdapter(ArrayList<Corretora> corretoras) {
        this.corretoras = corretoras;
    }

    @NonNull
    @Override
    public CorretoraViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.card_item, parent, false
        );
        return new CorretoraViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CorretoraViewHolder holder, int position) {
        Corretora corretora = corretoras.get(position);
        holder.bind(corretora);

    }
    @Override
    public int getItemCount() {
        return corretoras.size();
    }

    class CorretoraViewHolder extends RecyclerView.ViewHolder{
        TextView nome;

        CorretoraViewHolder(@NonNull View itemView) {
            super(itemView);
            nome = itemView.findViewById(R.id.nameCorretora);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(v.getContext(), Cotacao.class);
                    v.getContext().startActivity(intent);
                }
            });

        }

        public void bind(Corretora corretora){
            nome.setText(corretora.getName());
        }


    }

}