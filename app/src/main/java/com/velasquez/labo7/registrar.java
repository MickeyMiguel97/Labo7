package com.velasquez.labo7;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.velasquez.labo7.Datos.Persona;
import com.velasquez.labo7.Entidades.DBHelper;

public class registrar extends AppCompatActivity {

    private EditText txtId, txtNombre;
    private Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);
        inicializarControle();

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean flag = DBHelper.myDB.add(new Persona(
                        txtId.getText().toString(),
                        txtNombre.getText().toString()
                ));
                if (flag) {
                    Log.d("Edit", txtNombre.getText().toString());
                }
            }
        });
    }

    public void inicializarControle() {
        btnEnviar = findViewById(R.id.btnRegistrar);
        txtId = findViewById(R.id.txtId);
        txtNombre = findViewById(R.id.txtNombre);
    }
}