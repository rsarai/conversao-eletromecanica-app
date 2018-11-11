package com.example.sarai.projectcem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import static com.example.sarai.projectcem.data.CastingCastIron.HBDATA;

public class DisplayGraphActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_graph);

        Intent intent = getIntent();
        String value_vmax = intent.getStringExtra(GraphParamsActivity.TENSAO_MAX);
        String value_freq = intent.getStringExtra(GraphParamsActivity.FREQUENCIA);
        String value_potencia = intent.getStringExtra(GraphParamsActivity.POTENCIA_APARENTE);
        String value_np = intent.getStringExtra(GraphParamsActivity.ESPIRAS_PRIMARIO);
        String value_ns = intent.getStringExtra(GraphParamsActivity.ESPIRAS_SECUNDARIO);
        String value_comprimento = intent.getStringExtra(GraphParamsActivity.COMPRIMENTO_NUCLEO);
        String value_area = intent.getStringExtra(GraphParamsActivity.AREA_NUCLEO);

        GraphView graph = (GraphView) findViewById(R.id.graph);
        LineGraphSeries<DataPoint> seriesHVsB = new LineGraphSeries<>();

        for (double[] coord : HBDATA) {
            seriesHVsB.appendData(new DataPoint(coord[0], coord[1]), true, 100);
        }
        graph.addSeries(seriesHVsB);
    }
}
