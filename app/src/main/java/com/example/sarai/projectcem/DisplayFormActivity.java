package com.example.sarai.projectcem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class DisplayFormActivity extends AppCompatActivity {
    public final static String CIRCUITO_ABERTO_TENSAO = "com.example.sarai.profectcem.CIRCUITO_ABERTO_TENSAO";
    public final static String CIRCUITO_ABERTO_CORRENTE = "com.example.sarai.profectcem.CIRCUITO_ABERTO_CORRENTE";
    public final static String CIRCUITO_ABERTO_POTENCIA = "com.example.sarai.profectcem.CIRCUITO_ABERTO_POTENCIA";

    public final static String CIRCUITO_CIRCUITO_TENSAO = "com.example.sarai.profectcem.CIRCUITO_CIRCUITO_TENSAO";
    public final static String CIRCUITO_CIRCUITO_CORRENTE = "com.example.sarai.profectcem.CIRCUITO_CIRCUITO_CORRENTE";
    public final static String CIRCUITO_CIRCUITO_POTENCIA = "com.example.sarai.profectcem.CIRCUITO_CIRCUITO_POTENCIA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_form);
    }

    public void passParametersToResults(View view) {
        Intent intent = new Intent(this, DisplayParametersActivity.class);
        EditText ca_tensao = (EditText) findViewById(R.id.editText);
        String value_ca_tensao = ca_tensao.getText().toString();

        EditText ca_corrente = (EditText) findViewById(R.id.editText2);
        String value_ca_corrente = ca_corrente.getText().toString();

        EditText ca_potencia = (EditText) findViewById(R.id.editText3);
        String value_ca_potencia = ca_potencia.getText().toString();

        EditText cc_tensao= (EditText) findViewById(R.id.editText4);
        String value_cc_tensao = cc_tensao.getText().toString();

        EditText cc_corrente= (EditText) findViewById(R.id.editText5);
        String value_cc_corrente = cc_corrente.getText().toString();

        EditText cc_potencia= (EditText) findViewById(R.id.editText6);
        String value_cc_potencia = cc_potencia.getText().toString();

        intent.putExtra(CIRCUITO_ABERTO_TENSAO, value_ca_tensao);
        intent.putExtra(CIRCUITO_ABERTO_CORRENTE, value_ca_corrente);
        intent.putExtra(CIRCUITO_ABERTO_POTENCIA, value_ca_potencia);
        intent.putExtra(CIRCUITO_CIRCUITO_TENSAO, value_cc_tensao);
        intent.putExtra(CIRCUITO_CIRCUITO_CORRENTE, value_cc_corrente);
        intent.putExtra(CIRCUITO_CIRCUITO_POTENCIA, value_cc_potencia);
        startActivity(intent);
    }
}