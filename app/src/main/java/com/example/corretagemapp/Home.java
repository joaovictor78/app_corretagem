package com.example.corretagemapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.corretagemapp.models.Corretoras;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class Home extends Fragment {

    // Add RecyclerView member
    private RecyclerView recyclerView;
    private CorretoraAdapter corretoraAdapter;
    //json variables



    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
         String jsonFileString = Utils.getJsonFromAssets(container.getContext(), "corretoras.json");
        try {
            JSONArray corretoras = new JSONArray(jsonFileString);
             corretoraAdapter = new CorretoraAdapter(corretoras);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        // Add the following lines to create RecyclerView
        recyclerView = view.findViewById(R.id.rowlistview);

        recyclerView.setAdapter(corretoraAdapter);
        return view;
    }
}