package com.imd.ufrn.filmeapp2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.imd.ufrn.filmeapp2.fragmentos.FilmeDetalheFragment;
import com.imd.ufrn.filmeapp2.fragmentos.FilmeDialogFragment;
import com.imd.ufrn.filmeapp2.fragmentos.FilmeListaFragment;
import com.imd.ufrn.filmeapp2.model.Filme;

import org.w3c.dom.Entity;

public class FilmeActivity extends AppCompatActivity implements FilmeListaFragment.AoClicarFilme, FilmeDialogFragment.AoSalvarFilme {

    private FilmeListaFragment filmeListaFragment;
    private FragmentManager mFragmaentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filme);
        mFragmaentManager = getSupportFragmentManager();

        filmeListaFragment =(FilmeListaFragment) mFragmaentManager.findFragmentById(R.id.fragmentLista);
    }

    @Override
    public void salvouFilme(Filme filme) {
        filmeListaFragment.adicionar(filme);
    }

    @Override
    public void clicouNoFilme(Filme filme) {
        // parametro FIlme é o filme que o usuário clicou. Comunicação via interface
        System.out.println(IsTablet());
        if(IsTablet()){

            // 1 Criar uma instancia de fragmento  de detalhe
            FilmeDetalheFragment filmeDetalheFragment = FilmeDetalheFragment.novaInstancia(filme);

            //inflar o fragmento
            // preciso de um gerenciador de fragmentos. Faz a transição
           // FragmentManager fm = getSupportFragmentManager();
            //Adicionar ou troca em um porção de tela
            FragmentTransaction ft = mFragmaentManager.beginTransaction();

            //Espaço do layout da atividade onde o layout vai está
            ft.replace(R.id.detalhe,filmeDetalheFragment, FilmeDetalheFragment.TAG_DETALHE);

            ft.commit();

        }else{
            Intent it = new Intent(this,FilmeDetalhesActivity.class);
            it.putExtra("filme",filme);

            startActivity(it);
        }


    }


    private boolean IsTablet(){
        return findViewById(R.id.detalhe) != null;
    }

    //1. carregar menu

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //inflar layout do menu na atividade (na action bar)

        getMenuInflater().inflate(R.menu.menu,menu);
        return  true;

    }

    //2. implementar ações quando algum item do menu for clicado


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.acao_novo:
                FilmeDialogFragment filmeDialogFragment= FilmeDialogFragment.novaInstancia()
;
                filmeDialogFragment.show(mFragmaentManager,FilmeDialogFragment.DIALOG_TAG);

        }

        return super.onOptionsItemSelected(item);


    }
}