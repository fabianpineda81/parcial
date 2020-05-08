package com.example.regPersonas;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import static com.example.regPersonas.R.id.edtcedula;


public class MainActivity extends AppCompatActivity {

    EditText ce, nom, sal;
    Spinner est, niv;
    varPersonas regi;
    Button guardar, listado, eliminar, actualizar, buscar;
    ControladorRegPersonas c;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ce = findViewById(edtcedula);
        nom = findViewById(R.id.edtnombre);
        est = findViewById(R.id.spinnerestrato);
        sal = findViewById(R.id.edtsalario);
        niv = findViewById(R.id.spinnernivel);
        guardar = findViewById(R.id.btnguardar);
        eliminar = findViewById(R.id.btneliminar);
        actualizar = findViewById(R.id.btnactualizar);
        listado = findViewById(R.id.btnlistado);
        buscar = findViewById(R.id.btnbuscar);

        c = new ControladorRegPersonas(getApplicationContext());

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                regi = new varPersonas(ce.getText().toString(), nom.getText().toString(),
                        est.getItemAtPosition(est.getFirstVisiblePosition()).toString(),
                        sal.getText().toString(),
                        niv.getItemAtPosition(niv.getFirstVisiblePosition()).toString());
                if(!c.buscarPersona(regi.cedula)) {
                    long id = c.agregarPersona(regi);
                    Toast.makeText(getApplicationContext(), "Persona guardada", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"La persona ya se encuentra en la lista",Toast.LENGTH_SHORT).show();
                }
            }
        });

        eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                regi = new varPersonas(ce.getText().toString(), nom.getText().toString(),
                        est.getItemAtPosition(est.getFirstVisiblePosition()).toString(),
                        sal.getText().toString(),
                        niv.getItemAtPosition(niv.getFirstVisiblePosition()).toString());
        if (!c.buscarPersona(regi.cedula)) {
            Toast.makeText(getApplicationContext(), "La persona no se encuentra en la lista", Toast.LENGTH_SHORT).show();
        } else {
            c.eliminarPersona(regi.cedula);
            Toast.makeText(getApplicationContext(), "La persona ha sido eliminada", Toast.LENGTH_SHORT).show();
        }

            }
        });

        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                regi = new varPersonas(ce.getText().toString(), nom.getText().toString(),
                        est.getItemAtPosition(est.getFirstVisiblePosition()).toString(),
                        sal.getText().toString(),
                        niv.getItemAtPosition(niv.getFirstVisiblePosition()).toString());
                if(!c.buscarPersona(regi.cedula)){
                    Toast.makeText(getApplicationContext(), "La persona no se encuentra en la lista", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent i = new Intent(MainActivity.this, Buscar.class);
                    i.putExtra("cedula", regi.cedula);
                    startActivity(i);
                }
            }
        });

        actualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                regi = new varPersonas(ce.getText().toString(), nom.getText().toString(),
                        est.getItemAtPosition(est.getFirstVisiblePosition()).toString(),
                        sal.getText().toString(),
                        niv.getItemAtPosition(niv.getFirstVisiblePosition()).toString());
                if(!c.buscarPersona(regi.cedula)){
                    Toast.makeText(getApplicationContext(), "La persona no se encuentra en la lista", Toast.LENGTH_SHORT).show();
                }
                else{
                    long id = c.actualizarPersona(regi);
                    Toast.makeText(getApplicationContext(), "Datos actualizados", Toast.LENGTH_SHORT).show();
                }
            }
        });

        listado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ListadoActivity.class);
                startActivity(i);
            }
        });

    }


}
