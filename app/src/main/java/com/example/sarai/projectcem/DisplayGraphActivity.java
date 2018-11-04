package com.example.sarai.projectcem;

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

        GraphView graph = (GraphView) findViewById(R.id.graph);
        LineGraphSeries<DataPoint> seriesHVsB = new LineGraphSeries<>();

        for (double[] coord : HBDATA) {
            seriesHVsB.appendData(new DataPoint(coord[0], coord[1]), true, 100);
        }
        graph.addSeries(seriesHVsB);
    }
}
