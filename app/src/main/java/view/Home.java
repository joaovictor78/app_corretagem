package view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.corretagemapp.R;

import org.json.JSONArray;
import org.json.JSONException;

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