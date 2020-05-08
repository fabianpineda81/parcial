package com.example.regPersonas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class Buscar extends AppCompatActivity {

    ControladorRegPersonas c;
    ListView listado2;
    Button salir;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad_buscar);
        listado2 = findViewById(R.id.listado2);
        c = new ControladorRegPersonas(getApplicationContext());
        String ced = getIntent().getStringExtra("cedula");
        Cursor cur = c.personSearch(ced);
        salir = findViewById(R.id.btnRegresar);

        AdapterRegistroPersona eca = new AdapterRegistroPersona(this,cur,0);
        listado2.setAdapter(eca);
        eca.notifyDataSetChanged();

        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });
    }

}
