package com.example.proyecto;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ProyectoRomanaAdapter extends RecyclerView.Adapter<ProyectoRomanaAdapter.ViewHolder> {
    private final List<ProyectoRomana> proyectos;

    public ProyectoRomanaAdapter(List<ProyectoRomana> proyectos) {
        this.proyectos = proyectos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_proyecto_romana, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ProyectoRomana proyecto = proyectos.get(position);
        holder.nombreTextView.setText(proyecto.getNombre());
        holder.detallesTextView.setText("Detalles: " + proyecto.getTotalSuperficie());
    }

    @Override
    public int getItemCount() {
        return proyectos.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView nombreTextView;
        private final TextView detallesTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombreTextView = itemView.findViewById(R.id.nombreTextView2);
            detallesTextView = itemView.findViewById(R.id.detallesTextView2);
        }
    }
}
