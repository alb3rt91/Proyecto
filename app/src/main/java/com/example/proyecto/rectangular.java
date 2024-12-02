package com.example.proyecto;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class rectangular extends Fragment {
    private EditText etNombreProyecto, etM, etMValue, etH, etHValue;
    private TextView tvSolera, tvMuros, tvTotalSuperficie, tvMediacanas;
    private Button btnGuardar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rectangular, container, false);

        // Referencias a los componentes del layout
        etNombreProyecto = view.findViewById(R.id.et_nombre_proyecto);
        etM = view.findViewById(R.id.et_m);
        etMValue = view.findViewById(R.id.et_M);
        etH = view.findViewById(R.id.et_h);
        etHValue = view.findViewById(R.id.et_H);
        tvSolera = view.findViewById(R.id.tv_solera);
        tvMuros = view.findViewById(R.id.tv_muros);
        tvTotalSuperficie = view.findViewById(R.id.tv_total_superficie);
        tvMediacanas = view.findViewById(R.id.tv_mediacanas);
        btnGuardar = view.findViewById(R.id.btn_guardar);

        addTextChangedListeners();

        btnGuardar.setOnClickListener(v -> {
            saveProject();
            NavHostFragment.findNavController(this).navigate(R.id.action_rectangular2_to_bottom1Fragment);
        });

        return view;
    }

    private void addTextChangedListeners() {
        View.OnFocusChangeListener focusChangeListener = (v, hasFocus) -> updateResults();

        etM.setOnFocusChangeListener(focusChangeListener);
        etMValue.setOnFocusChangeListener(focusChangeListener);
        etH.setOnFocusChangeListener(focusChangeListener);
        etHValue.setOnFocusChangeListener(focusChangeListener);
    }

    private void updateResults() {
        double m = parseDouble(etM.getText().toString());
        double M = parseDouble(etMValue.getText().toString());
        double h = parseDouble(etH.getText().toString());
        double H = parseDouble(etHValue.getText().toString());

        double solera = m * M;
        double muros = (M * (h + H)) + ((m - 2) * h);
        double totalSuperficie = solera + muros;
        double mediacanas = m + M + M + h + H + h + H;

        tvSolera.setText("SOLERA = " + solera);
        tvMuros.setText("MUROS = " + muros);
        tvTotalSuperficie.setText("TOTAL SUPERFICIE PISCINA = " + totalSuperficie);
        tvMediacanas.setText("MEDIACAÑAS = " + mediacanas);
    }

    private void saveProject() {
        String nombreProyecto = etNombreProyecto.getText().toString().trim();
        String solera = tvSolera.getText().toString();
        String muros = tvMuros.getText().toString();
        String totalSuperficie = tvTotalSuperficie.getText().toString();
        String mediacanas = tvMediacanas.getText().toString();

        if (nombreProyecto.isEmpty()) {
            Toast.makeText(getContext(), "Introduce un nombre para el proyecto", Toast.LENGTH_SHORT).show();
            return;
        }

        Proyecto proyecto = new Proyecto(nombreProyecto, solera, muros, totalSuperficie, mediacanas);
        SharedData.getInstance().addProyecto(proyecto);
        Toast.makeText(getContext(), "Proyecto guardado", Toast.LENGTH_SHORT).show();
    }

    private double parseDouble(String value) {
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }
}
