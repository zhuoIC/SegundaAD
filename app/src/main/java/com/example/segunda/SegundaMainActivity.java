package com.example.segunda;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class SegundaMainActivity extends AppCompatActivity implements View.OnClickListener {
    final double getCambio = 1.17955;
    EditText etxE;
    EditText etxD;
    Button btnConvertir;
    RadioButton rbtEaD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_main);
        etxE = (EditText) findViewById(R.id.etxE);
        etxD = (EditText) findViewById(R.id.etxD);
        btnConvertir = (Button) findViewById(R.id.btnConvertir);
        rbtEaD = (RadioButton) findViewById(R.id.rbtnE);
        btnConvertir.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == btnConvertir) {
            actualizar(view);
        }
    }

    public void actualizar(View view) {
        double valor = 0;
        try {
            if (rbtEaD.isChecked()) {
                etxD.setText(String.format("%.2f", Double.parseDouble(etxE.getText().toString()) * getCambio));
            } else {

                etxE.setText(String.format("%.2f", Double.parseDouble(etxD.getText().toString()) / getCambio));
            }
        } catch (Exception e) {
            Toast.makeText(this, "Error al introducir datos", Toast.LENGTH_SHORT).show();
            //Snackbar.make(view, "Error al introducir datos", Snackbar.LENGTH_SHORT).show();
        }
    }

}