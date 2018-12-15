package com.example.sarai.projectcem;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class CAMachineFormActivity extends AppCompatActivity {
    public final static String CA_X1 = "com.example.sarai.profectcem.CA_X1";
    public final static String CA_R1 = "com.example.sarai.profectcem.CA_R1";
    public final static String CA_X2 = "com.example.sarai.profectcem.CA_X2";
    public final static String CA_R2 = "com.example.sarai.profectcem.CA_R2";

    public final static String CA_XM = "com.example.sarai.profectcem.CA_XM";
    public final static String CA_V_PHASE = "com.example.sarai.profectcem.CA_V_PHASE";
    public final static String CA_W_SYNC = "com.example.sarai.profectcem.CA_W_SYNC";
    public final static String CA_N_SYNC = "com.example.sarai.profectcem.CA_N_SYNC";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camachine_form);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void caMachineGraphDisplayActivity(View view) {
        Intent intent = new Intent(this, CAMachineGraphActivity.class);

        EditText ca_x1 = (EditText) findViewById(R.id.editText17);
        String value_ca_x1 = ca_x1.getText().toString();

        EditText ca_x2 = (EditText) findViewById(R.id.editText18);
        String value_ca_x2 = ca_x2.getText().toString();

        EditText ca_r1 = (EditText) findViewById(R.id.editText16);
        String value_ca_r1 = ca_r1.getText().toString();

        EditText ca_r2 = (EditText) findViewById(R.id.editText19);
        String value_ca_r2 = ca_r2.getText().toString();

        EditText ca_xm = (EditText) findViewById(R.id.editText23);
        String value_ca_xm = ca_xm.getText().toString();

        EditText ca_v_phase = (EditText) findViewById(R.id.editText21);
        String value_ca_v_phase = ca_v_phase.getText().toString();

        EditText ca_n_sync = (EditText) findViewById(R.id.editText22);
        String value_ca_n_sync = ca_n_sync.getText().toString();

        EditText ca_w_sync = (EditText) findViewById(R.id.editText20);
        String value_ca_w_sync = ca_w_sync.getText().toString();

        intent.putExtra(CA_X1, value_ca_x1);
        intent.putExtra(CA_R1, value_ca_r1);
        intent.putExtra(CA_X2, value_ca_x2);
        intent.putExtra(CA_R2, value_ca_r2);
        intent.putExtra(CA_XM, value_ca_xm);
        intent.putExtra(CA_V_PHASE, value_ca_v_phase);
        intent.putExtra(CA_W_SYNC, value_ca_w_sync);
        intent.putExtra(CA_N_SYNC, value_ca_n_sync);

        startActivity(intent);
    }

}
