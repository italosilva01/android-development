package com.example.persistencia2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnGravar;
    private EditText etDado;
    private TextView tvDado;

    private static final String ARQUIVO_PREFERENCIA = "ArquivoPreferencia";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGravar = findViewById(R.id.btnGravar);
        etDado = findViewById(R.id.etDado);
        tvDado = findViewById(R.id.tvDado);

        btnGravar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //modo 0 - privado só o app pode acessar o arquivo
                //objeto preferenciais faz referencia ao arquivo
                //getSharedPreferences aponta para o arquivo e disponibiliza metodos simples para escrever e ler o arquivo
                SharedPreferences preferences = getSharedPreferences(ARQUIVO_PREFERENCIA,0);
                //editor para manipular o arquivo associado a preferencias.
                SharedPreferences.Editor editor = preferences.edit();

                //validar o nome
                if(etDado.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Preencher o nome!",Toast.LENGTH_SHORT).show();
                }else{
                    String nome = etDado.getText().toString();
                    editor.putString("chaveNome",nome);
                    editor.commit();

                    tvDado.setText("Olá, "+nome);
                }
            }
        });

        //recuperar dados
        SharedPreferences preferences = getSharedPreferences(ARQUIVO_PREFERENCIA,0);

        //verificar se temos o dado em preferencias

        if(preferences.contains("chaveNome")){
            String nome = preferences.getString("chaveNome","usuário não definido!");
            tvDado.setText("Olá, "+nome);
        }else{
            tvDado.setText("Olá, usuário não definido!");
        }
    }
}