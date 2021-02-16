package view;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONObject;

public class CompromissosAdapter  extends RecyclerView.Adapter<CompromissosAdapter.CompromissosViewHolder> {
    @NonNull
    @Override
    public CompromissosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull CompromissosViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
    public class CompromissosViewHolder extends RecyclerView.ViewHolder{

        public CompromissosViewHolder(@NonNull View itemView) {
            super(itemView);
        }
        public void bind(JSONObject corretora) {

        }
        }
    }

