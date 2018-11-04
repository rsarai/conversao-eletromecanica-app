package com.example.sarai.projectcem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

        // req, xeq, xm, rc = get_results(ca_corrente, ca_tensao, ca_potencia, cc_potencia, cc_tensao, cc_corrente);
        String test = "teste";
        TextView textView = findViewById(R.id.textView13);
        textView.setText(test);

        TextView xeqLabel = findViewById(R.id.textView14);
        xeqLabel.setText(test);

        TextView xmLabel = findViewById(R.id.textView16);
        xmLabel.setText(test);

        TextView reqLabel = findViewById(R.id.textView15);
        reqLabel.setText(test);
    }
}
