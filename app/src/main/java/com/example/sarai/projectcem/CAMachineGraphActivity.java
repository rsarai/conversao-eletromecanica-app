package com.example.sarai.projectcem;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.sarai.projectcem.assets.Complex;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.LegendRenderer;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CAMachineGraphActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camachine_graph);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        String value_ca_ca_x1 = intent.getStringExtra(CAMachineFormActivity.CA_X1);
        String value_ca_ca_x2 = intent.getStringExtra(CAMachineFormActivity.CA_R1);
        String value_ca_ca_r1 = intent.getStringExtra(CAMachineFormActivity.CA_X2);
        String value_ca_ca_r2 = intent.getStringExtra(CAMachineFormActivity.CA_R2);
        String value_ca_ca_xm = intent.getStringExtra(CAMachineFormActivity.CA_XM);
        String value_ca_ca_v_phase = intent.getStringExtra(CAMachineFormActivity.CA_V_PHASE);
        String value_ca_ca_n_sync = intent.getStringExtra(CAMachineFormActivity.CA_N_SYNC);
        String value_ca_ca_w_sync = intent.getStringExtra(CAMachineFormActivity.CA_W_SYNC);

        double r1, r2, x1, x2, xm, v_phase, n_sync, w_sync;

        if (value_ca_ca_n_sync.equals("") ||
                value_ca_ca_x1.equals("") ||
                value_ca_ca_x2.equals("") ||
                value_ca_ca_r1.equals("") ||
                value_ca_ca_r2.equals("") ||
                value_ca_ca_xm.equals("") ||
                value_ca_ca_v_phase.equals("") ||
                value_ca_ca_w_sync .equals("")) {
            r1 = 0.641;                      // Resistência do estator
            x1 = 1.106;                      // Reatância do estator
            r2 = 0.332;                      // Resistência do rotor
            x2 = 0.464;                      // Reatância do rotor
            xm = 26.3;                       // Reatância do ramo de magnetização
            v_phase = 460 / Math.sqrt(3);    // Tensão de fase
            n_sync = 1800;                   // Velocidade síncrona (rpm)
            w_sync = 188.5;                  // Velocidade síncrona (rad/s)
        } else {
            x1 = Double.parseDouble(value_ca_ca_x1);
            x2 = Double.parseDouble(value_ca_ca_x2);
            r1 = Double.parseDouble(value_ca_ca_r1);
            r2 = Double.parseDouble(value_ca_ca_r2);
            xm = Double.parseDouble(value_ca_ca_xm);
            v_phase = Double.parseDouble(value_ca_ca_v_phase);
            n_sync = Double.parseDouble(value_ca_ca_n_sync);
            w_sync = Double.parseDouble(value_ca_ca_w_sync);
        }

        // Calcule a tensão e a impedância de Thévenin com as Equações
        double v_th = v_phase * (xm / Math.sqrt(Math.pow(r1, 2) + Math.pow(x1 + xm, 2)));
        // double z_th = ((j*xm) * (r1 + j*x1)) / (r1 + j*(x1 + xm));

        Complex a = new Complex(0, xm);
        Complex b = new Complex(r1, x1);
        Complex c = new Complex(r1, (x1 + xm));
        Complex z_th = a.times(b).divides(c);

        double r_th = z_th.re();
        double x_th = z_th.im();

        // Agora, calcule a característica de conjugado X velocidade para diversos
        // escorregamentos entre 0 e 1. Observe que o primeiro valor de escorregamento
        // é ajustado para 0,001 em vez de exatamente 0 para evitar problemas de
        // divisão por zero.
        List<Double> s = new ArrayList<>();         // Escorregamento
        for (int i = 0; i < 50; i++){
            double v;
            if (i == 0) {
                v = 0.001;
            } else {
                v = i / 50.f;
            }
            s.add(v);
        }

        List<Double> nm = new ArrayList<>();        // Velocidade mecânica
        for (int i = 0; i < s.size(); i++){
            nm.add(s.get(i) * n_sync);
        }

        // Calcule o conjugado para a resistência de rotor original
        List<Double> t_ind1 = new ArrayList<>();
        List<Double> t_ind2 = new ArrayList<>();

        Collections.reverse(s);
        for (int i = 0; i < 50; i++){
            double t_ind1_p = (3 * Math.pow(v_th, 2) * r2/s.get(i)) / (
                    w_sync * (Math.pow(r_th + r2/s.get(i), 2) + Math.pow(x_th + x2, 2)));
            t_ind1.add(t_ind1_p);

            double t_ind2_p = (3 * Math.pow(v_th, 2) * (2*r2)/s.get(i)) / (
                    w_sync * (Math.pow(r_th + (2*r2)/s.get(i), 2) + Math.pow(x_th + x2, 2)));
            t_ind2.add(t_ind2_p);
        }

        GraphView graph = (GraphView) findViewById(R.id.graph2);
        graph.getViewport().setScalable(true);
        // activate horizontal scrolling
        graph.getViewport().setScrollable(true);
        // activate horizontal and vertical zooming and scrolling
        graph.getViewport().setScalableY(true);
        // activate vertical scrolling
        graph.getViewport().setScrollableY(true);
        LineGraphSeries<DataPoint> seriesTind1 = new LineGraphSeries<>();
        seriesTind1.setColor(Color.RED);
        seriesTind1.setTitle("R2 Original");

        LineGraphSeries<DataPoint> seriesTind2 = new LineGraphSeries<>();
        seriesTind2.setColor(Color.BLUE);
        seriesTind2.setTitle("R2 Dobrada");

        for (int i = 0; i < t_ind1.size(); i++) {
            seriesTind1.appendData(new DataPoint(nm.get(i), t_ind1.get(i)),
                    true, 1000);
            seriesTind2.appendData(new DataPoint(nm.get(i), t_ind2.get(i)),
                    true, 1000);
        }
        graph.addSeries(seriesTind1);
        graph.addSeries(seriesTind2);

        graph.getLegendRenderer().setVisible(true);
        graph.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.MIDDLE);
        graph.setTitle("Característica de conjugado versus velocidade do motor de indução");
    }

}
