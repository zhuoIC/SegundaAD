package com.example.segunda;

import android.renderscript.Double2;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class SegundaMainActivity extends AppCompatActivity implements View.OnClickListener{
    final double cambioAdolar = 1.17955;
    final double getCambioAeuro = 0.847869;
    EditText etxE;
    EditText etxD;
    Button btnConvertir;
    RadioButton rbtEaD;
    RadioButton rbtDaE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_main);
        EditText etxE = (EditText) findViewById(R.id.etxE);
        EditText etxD = (EditText) findViewById(R.id.etxD);
        btnConvertir = (Button) findViewById(R.id.btnConvertir);
        btnConvertir.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        if (view == btnConvertir)
        {
            actualizar();
        }
    }

    public void actualizar()
    {
        rbtEaD = (RadioButton) findViewById(R.id.rbtnE);
        double valor = 0;
        if (rbtEaD.isChecked())
        {
            valor = Calcular(Double.parseDouble(etxE.getText().toString()), cambioAdolar);
            etxE.setText(String.valueOf(valor));
        }
        else
        {
            valor = Calcular(Double.parseDouble(String.format(etxD.getText().toString())), cambioAdolar);
            etxD.setText(String.valueOf(valor));
        }
    }

    public double Calcular(double valor, double cambio)
    {
        return valor * cambio;
    }
}
