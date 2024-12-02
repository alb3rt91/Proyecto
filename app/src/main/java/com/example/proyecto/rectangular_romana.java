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

public class rectangular_romana extends Fragment {

    private EditText etNombreProyecto, etM, etMValue, etH, etHValue, etEscalera;
    private TextView tvSolera, tvMuros, tvMurosYSolera, tvSoleraEscalera, tvMurosEscalera, tvPerimetroEscalera, tvEscaleraTotal, tvTotalSuperficie, tvMediacanas;
    private Button btnGuardar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rectangular_romana, container, false);

        // Referencias a los componentes del layout
        etNombreProyecto = view.findViewById(R.id.et_nombre_proyecto2);
        etM = view.findViewById(R.id.et_m2);
        etMValue = view.findViewById(R.id.et_M2);
        etH = view.findViewById(R.id.et_h2);
        etHValue = view.findViewById(R.id.et_H2);
        etEscalera = view.findViewById(R.id.et_escalera);

        tvSolera = view.findViewById(R.id.tv_solera2);
        tvMuros = view.findViewById(R.id.tv_muros2);
        tvMurosYSolera = view.findViewById(R.id.tv_muros_y_solera2);
        tvSoleraEscalera = view.findViewById(R.id.tv_solera_escalera2);
        tvMurosEscalera = view.findViewById(R.id.tv_muros_escalera2);
        tvPerimetroEscalera = view.findViewById(R.id.tv_perimetro_escalera2);
        tvEscaleraTotal = view.findViewById(R.id.tv_escalera_total2);
        tvTotalSuperficie = view.findViewById(R.id.tv_total_superficie_piscina2);
        tvMediacanas = view.findViewById(R.id.tv_mediacanas2);
        btnGuardar = view.findViewById(R.id.btn_guardar2);

        // Actualización de resultados en tiempo real
        addTextChangedListeners();

        // Botón Guardar
        btnGuardar.setOnClickListener(v -> {
            saveProject();
            NavHostFragment.findNavController(this).navigate(R.id.action_rectangular_romana_to_bottom1Fragment);
        });

        return view;
    }

    private void addTextChangedListeners() {
        View.OnFocusChangeListener focusChangeListener = (v, hasFocus) -> updateResults();

        etM.setOnFocusChangeListener(focusChangeListener);
        etMValue.setOnFocusChangeListener(focusChangeListener);
        etH.setOnFocusChangeListener(focusChangeListener);
        etHValue.setOnFocusChangeListener(focusChangeListener);
        etEscalera.setOnFocusChangeListener(focusChangeListener);
    }

    private void updateResults() {
        double m = parseDouble(etM.getText().toString());
        double M = parseDouble(etMValue.getText().toString());
        double h = parseDouble(etH.getText().toString());
        double H = parseDouble(etHValue.getText().toString());
        double escalera = parseDouble(etEscalera.getText().toString());

        // Cálculos
        double solera = m * M;
        double muros = (M * (h + H)) + (H * m) + ((m - escalera - escalera) * h);
        double murosYSolera = muros + solera;

        double soleraEscalera = Math.PI * escalera * escalera * 0.5;
        double murosEscalera = Math.PI * escalera * h;
        double perimetroEscalera = Math.PI * escalera;
        double escaleraTotal = soleraEscalera + murosEscalera;

        double totalSuperficie = murosYSolera + escaleraTotal;

        double mediacanas = m + M + M + h + H + h + H + perimetroEscalera + m - escalera - escalera;

        // Actualización de TextViews
        tvSolera.setText("SOLERA = " + solera);
        tvMuros.setText("MUROS = " + muros);
        tvMurosYSolera.setText("MUROS Y SOLERA = " + murosYSolera);
        tvSoleraEscalera.setText("SOLERA ESCALERA = " + soleraEscalera);
        tvMurosEscalera.setText("MUROS ESCALERA = " + murosEscalera);
        tvPerimetroEscalera.setText("PERIMETRO ESCALERA = " + perimetroEscalera);
        tvEscaleraTotal.setText("ESCALERA TOTAL = " + escaleraTotal);
        tvTotalSuperficie.setText("TOTAL SUPERFICIE PISCINA = " + totalSuperficie);
        tvMediacanas.setText("MEDIACAÑAS = " + mediacanas);
    }

    private void saveProject() {
        String nombreProyecto = etNombreProyecto.getText().toString().trim();
        String solera = tvSolera.getText().toString();
        String muros = tvMuros.getText().toString();
        String murosYSolera = tvMurosYSolera.getText().toString();
        String soleraEscalera = tvSoleraEscalera.getText().toString();
        String murosEscalera = tvMurosEscalera.getText().toString();
        String perimetroEscalera = tvPerimetroEscalera.getText().toString();
        String escaleraTotal = tvEscaleraTotal.getText().toString();
        String totalSuperficie = tvTotalSuperficie.getText().toString();
        String mediacanas = tvMediacanas.getText().toString();

        if (nombreProyecto.isEmpty()) {
            Toast.makeText(getContext(), "Introduce un nombre para el proyecto", Toast.LENGTH_SHORT).show();
            return;
        }

        ProyectoRomana proyecto = new ProyectoRomana(
                nombreProyecto,
                solera,
                muros,
                murosYSolera,
                soleraEscalera,
                murosEscalera,
                perimetroEscalera,
                escaleraTotal,
                totalSuperficie,
                mediacanas
        );
        SharedData.getInstance().addProyectoRomana(proyecto);

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
