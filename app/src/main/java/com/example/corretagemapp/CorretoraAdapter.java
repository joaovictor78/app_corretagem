package com.example.corretagemapp;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.corretagemapp.models.Corretora;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class CorretoraAdapter extends RecyclerView.Adapter<CorretoraAdapter.CorretoraViewHolder> {
    private final JSONArray corretoras;
    public CorretoraAdapter(JSONArray corretoras) {
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
        try {
            JSONObject corretora = corretoras.getJSONObject(position);
             holder.bind(corretora);
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
    @Override
    public int getItemCount() {
        return corretoras.length();
    }

    class CorretoraViewHolder extends RecyclerView.ViewHolder{
        TextView nome;
        JSONObject corretoraSelected;

        CorretoraViewHolder(@NonNull View itemView) {
            super(itemView);
            nome = itemView.findViewById(R.id.nameCorretora);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(v.getContext(), Cotacao.class);
                    intent.putExtra("corretoraSelected", corretoraSelected.toString());
                    Log.i("AAAAAAAAAAAAAAAAA", corretoraSelected.toString());
                    v.getContext().startActivity(intent);
                }
            });

        }

        public void bind(JSONObject corretora){
            try {
                corretoraSelected = corretora;
                nome.setText(corretora.get("nome").toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

}