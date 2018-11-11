package com.example.sarai.projectcem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class GraphParamsActivity extends AppCompatActivity {
    public final static String TENSAO_MAX = "com.example.sarai.profectcem.TENSAO_MAX";
    public final static String FREQUENCIA = "com.example.sarai.profectcem.FREQUENCIA";
    public final static String POTENCIA_APARENTE = "com.example.sarai.profectcem.POTENCIA_APARENTE";

    public final static String ESPIRAS_PRIMARIO = "com.example.sarai.profectcem.ESPIRAS_PRIMARIO";
    public final static String ESPIRAS_SECUNDARIO = "com.example.sarai.profectcem.ESPIRAS_SECUNDARIO";
    public final static String COMPRIMENTO_NUCLEO = "com.example.sarai.profectcem.COMPRIMENTO_NUCLEO";
    public final static String AREA_NUCLEO = "com.example.sarai.profectcem.AREA_NUCLEO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph_params);
    }

    public void runGraph(View view) {
        Intent intent = new Intent(this, DisplayGraphActivity.class);

        EditText vmax = (EditText) findViewById(R.id.editText7);
        String value_vmax = vmax.getText().toString();

        EditText freq = (EditText) findViewById(R.id.editText13);
        String value_freq= freq.getText().toString();

        EditText potencia = (EditText) findViewById(R.id.editText8);
        String value_potencia = potencia.getText().toString();

        EditText np = (EditText) findViewById(R.id.editText9);
        String value_np = np.getText().toString();

        EditText ns = (EditText) findViewById(R.id.editText10);
        String value_ns = ns.getText().toString();

        EditText comprimento = (EditText) findViewById(R.id.editText11);
        String value_comprimento= comprimento.getText().toString();

        EditText area = (EditText) findViewById(R.id.editText12);
        String value_area = area.getText().toString();

        intent.putExtra(TENSAO_MAX, value_vmax);
        intent.putExtra(FREQUENCIA, value_freq);
        intent.putExtra(POTENCIA_APARENTE, value_potencia);
        intent.putExtra(ESPIRAS_PRIMARIO, value_np);
        intent.putExtra(ESPIRAS_SECUNDARIO, value_ns);
        intent.putExtra(COMPRIMENTO_NUCLEO, value_comprimento);
        intent.putExtra(AREA_NUCLEO, value_area);

        startActivity(intent);
    }
}
