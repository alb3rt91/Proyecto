package com.example.proyecto;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class Formas extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_formas, container, false);

        Button btnRectangular = view.findViewById(R.id.btnRectangular);
        Button btnRectangularRomana = view.findViewById(R.id.btnRectangularRomana);
        Button btnRectangularRectangular = view.findViewById(R.id.btnRectangularRectangular);

        // Navegar al fragmento "Piscina rectangular sin escalera"
        btnRectangular.setOnClickListener(v ->
                NavHostFragment.findNavController(this)
                        .navigate(R.id.action_formas_to_rectangular2)
        );

        // Navegar al fragmento "Piscina rectangular con escalera romana"
        btnRectangularRomana.setOnClickListener(v ->
                NavHostFragment.findNavController(this)
                        .navigate(R.id.action_formas_to_rectangular_romana)
        );

        // Navegar al fragmento "Piscina rectangular con escalera rectangular"
        btnRectangularRectangular.setOnClickListener(v ->
                NavHostFragment.findNavController(this)
                        .navigate(R.id.action_formas_to_rectangular_rectangular)
        );

        return view;
    }
}
