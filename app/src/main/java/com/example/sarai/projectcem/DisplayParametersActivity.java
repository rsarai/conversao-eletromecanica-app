package com.example.sarai.projectcem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class DisplayParametersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_parameters);

        Intent intent = getIntent();
        String ca_corrente = intent.getStringExtra(DisplayFormActivity.CIRCUITO_ABERTO_CORRENTE);
        String ca_tensao = intent.getStringExtra(DisplayFormActivity.CIRCUITO_ABERTO_TENSAO);
        String ca_potencia = intent.getStringExtra(DisplayFormActivity.CIRCUITO_ABERTO_POTENCIA);

        String cc_potencia = intent.getStringExtra(DisplayFormActivity.CIRCUITO_CIRCUITO_POTENCIA);
        String cc_tensao = intent.getStringExtra(DisplayFormActivity.CIRCUITO_CIRCUITO_TENSAO);
        String cc_corrente = intent.getStringExtra(DisplayFormActivity.CIRCUITO_CIRCUITO_CORRENTE);

        String[] results;
        String[] err_results = {"err", "err", "err", "err"};
        String[] other_results = get_results(ca_corrente, ca_tensao, ca_potencia, cc_potencia, cc_tensao, cc_corrente);
        if (other_results == null){
            results = err_results;
        } else {
            results = other_results;
        }

        TextView textView = findViewById(R.id.textView13);
        textView.setText(results[0]);

        TextView xeqLabel = findViewById(R.id.textView14);
        xeqLabel.setText(results[1]);

        TextView xmLabel = findViewById(R.id.textView16);
        xmLabel.setText(results[2]);

        TextView reqLabel = findViewById(R.id.textView15);
        reqLabel.setText(results[3]);
    }

    public String[] get_results(String ca_corrente, String ca_tensao, String ca_potencia,
                              String cc_potencia, String cc_tensao, String cc_corrente) {
        if (ca_corrente == null || ca_tensao == null || ca_potencia == null ||
                cc_potencia == null || cc_tensao == null || cc_corrente == null){
            return null;
        }
        double value_ca_corrente = Double.parseDouble(ca_corrente);
        double value_ca_tensao = Double.parseDouble(ca_tensao);
        double value_ca_potencia = Double.parseDouble(ca_potencia);

        double value_cc_potencia = Double.parseDouble(cc_potencia);
        double value_cc_tensao = Double.parseDouble(cc_tensao);
        double value_cc_corrente = Double.parseDouble(cc_corrente);

        double zcc = value_cc_tensao/value_cc_corrente;
        double req = value_cc_potencia / (value_cc_corrente * value_cc_corrente);
        double xeq = Math.sqrt(zcc * zcc - req * req);

        double zf = value_ca_tensao/value_ca_corrente;
        double rc = Math.pow(value_ca_tensao, 2)/value_ca_potencia;
        double aux= Math.pow(1/zf, 2) - Math.pow(1/rc, 2);
        double xm = 1/Math.sqrt(aux);

        String[] results = {Double.toString(req), Double.toString(xeq), Double.toString(rc), Double.toString(xm)};
        return results;
    }
}
