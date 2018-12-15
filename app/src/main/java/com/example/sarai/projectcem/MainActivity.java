package com.example.sarai.projectcem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Called when the user taps the Generate Graph button */
    public void generateGraph(View view) {
        Intent intent = new Intent(this, GraphParamsActivity.class);
        startActivity(intent);
    }

    public void calculateParameters(View view) {
        Intent intent = new Intent(this, DisplayFormActivity.class);
        startActivity(intent);
    }

    public void caMachineActivity(View view) {
        Intent intent = new Intent(this, CAMachineFormActivity.class);
        startActivity(intent);
    }
}
