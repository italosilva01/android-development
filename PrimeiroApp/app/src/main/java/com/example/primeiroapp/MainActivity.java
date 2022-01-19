package com.example.primeiroapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etNome;
    Button btnEnviar;
    TextView tvSaudacao;
    Button btnNumero;
    TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNome = findViewById(R.id.etNome);
        btnEnviar = findViewById(R.id.btnEnviar);
        tvSaudacao = findViewById(R.id.tvSaudacao);

        btnNumero = findViewById(R.id.btnNumero);
        tvResultado = findViewById(R.id.tvResultado);

        btnNumero.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                SorteiaNumero sort = new SorteiaNumero();

                tvResultado.setText("Numero : "+sort.getNumeroAleatorio());


            }
        });
    }
    public void saudar(View view){
        String nome = etNome.getText().toString();
        tvSaudacao.setText("Bem-vindo, "+nome);

    }
}