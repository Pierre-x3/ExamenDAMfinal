package com.example.examendamfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Formulario extends AppCompatActivity {

    Button buttonRVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        buttonRVolver = findViewById(R.id.buttonR);
        buttonRVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText longitud = findViewById(R.id.txtlongitud);
                EditText latitud = findViewById(R.id.txtlatitud);
                EditText marcador = findViewById(R.id.txtmarcador);
                String mensaje=null;

                if (longitud.getText().toString().length()==0) {
                    mensaje="* Ingrese la longitud\n";
                }
                if (latitud.getText().toString().length()==0) {
                    mensaje=mensaje+"* Ingrese la latitud\n";
                }
                if (marcador.getText().toString().length()==0) {
                    mensaje=mensaje+"* Ingrese el marcador";
                }

                if(mensaje==null){
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("geo:<"+longitud.getText().toString()+">,<"+latitud.getText().toString()+">?q=<"+longitud.getText().toString()+">,<"+latitud.getText().toString()+">("+marcador.getText().toString()+")"));
                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent);
                    }
                } else {
                    Toast.makeText(getApplicationContext(),mensaje,Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}