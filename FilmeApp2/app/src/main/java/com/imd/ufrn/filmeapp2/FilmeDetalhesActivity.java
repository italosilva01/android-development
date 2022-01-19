package com.imd.ufrn.filmeapp2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;

import com.imd.ufrn.filmeapp2.fragmentos.FilmeDetalheFragment;
import com.imd.ufrn.filmeapp2.model.Filme;

public class FilmeDetalhesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filme_detalhes);

        Intent it = getIntent();

        //recuperar filme
        Filme filme =(Filme) it.getExtras().getSerializable("filme");

        //inflar fragmento de layout de maneira dinamica

        // 1 Criar uma instancia de fragmento  de detalhe
        FilmeDetalheFragment filmeDetalheFragment = FilmeDetalheFragment.novaInstancia(filme);

        //inflar o fragmento
        // preciso de um gerenciador de fragmentos. Faz a transição
        FragmentManager fm = getSupportFragmentManager();
        //Adicionar ou troca em um porção de tela
        FragmentTransaction ft = fm.beginTransaction();

        //Espaço do layout da atividade onde o layout vai está
        ft.replace(R.id.detalhe,filmeDetalheFragment, FilmeDetalheFragment.TAG_DETALHE);

        ft.commit();
    }
}