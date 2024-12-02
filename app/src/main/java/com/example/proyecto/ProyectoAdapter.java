package com.example.proyecto;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProyectoAdapter extends RecyclerView.Adapter<ProyectoAdapter.ViewHolder> {
    private List<Proyecto> proyectos;

    public ProyectoAdapter(List<Proyecto> proyectos) {
        this.proyectos = proyectos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_proyecto, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Proyecto proyecto = proyectos.get(position);
        holder.nombreTextView.setText(proyecto.getNombre());

        holder.itemView.setOnClickListener(v -> {
            if (holder.detalleTextView.getVisibility() == View.GONE) {
                holder.detalleTextView.setVisibility(View.VISIBLE);
                holder.detalleTextView.setText(
                        "Solera: " + proyecto.getSolera() + "\n" +
                                "Muros: " + proyecto.getMuros() + "\n" +
                                "Total Superficie: " + proyecto.getTotalSuperficie() + "\n" +
                                "Mediacañas: " + proyecto.getMediacanas()
                );
            } else {
                holder.detalleTextView.setVisibility(View.GONE);
            }
        });
    }

    @Override
    public int getItemCount() {
        return proyectos.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView nombreTextView;
        TextView detalleTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombreTextView = itemView.findViewById(R.id.nombreTextView);
            detalleTextView = itemView.findViewById(R.id.detalleTextView);
        }
    }
}
