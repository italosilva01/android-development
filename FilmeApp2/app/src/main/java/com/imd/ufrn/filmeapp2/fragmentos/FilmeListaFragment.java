package com.imd.ufrn.filmeapp2.fragmentos;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.imd.ufrn.filmeapp2.R;
import com.imd.ufrn.filmeapp2.model.Filme;

import java.util.ArrayList;
import java.util.List;


public class FilmeListaFragment extends ListFragment {

    List<Filme> mFilmes;
    ArrayAdapter<Filme> mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFilmes = carregarFilme();

        //passar a atividade, passar o layut e passar os dados
        mAdapter = new ArrayAdapter<Filme>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                mFilmes
        );

        //Fazendo adaptador
        setListAdapter(mAdapter);

    }

    private List<Filme> carregarFilme(){
        List<Filme> filmes = new ArrayList<Filme>();

        filmes.add(new Filme("Os vingadores", "2h15",2012,4.5f));
        filmes.add(new Filme("O senhor dos aneis", "2h15",2012,4.5f));
        filmes.add(new Filme("Duna", "2h15",2012,4.5f));
        filmes.add(new Filme("star wars", "2h15",2012,4.5f));

        return  filmes;
    }

    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        // comunicar a atividade filmeActive que o item foi clicado
        //getActivity retorna a atividade corrente para qual o objeto está
        Activity activity = getActivity();

        //2; vericar se a atividade é FilmeActivity

        if(  activity instanceof AoClicarFilme){
            //2.1 colocar em uma variável do tipo filme, o filme que foi clicado
            Filme filme = (Filme) l.getItemAtPosition(position);

            //2.2 passar filme para interface

            AoClicarFilme listener = (AoClicarFilme) activity;
            listener.clicouNoFilme(filme);

        }

    }
    public interface AoClicarFilme{
        void clicouNoFilme(Filme filme);

    }

    public void adicionar(Filme filme){
        mFilmes.add(filme);
        mAdapter.notifyDataSetChanged();
    }


}