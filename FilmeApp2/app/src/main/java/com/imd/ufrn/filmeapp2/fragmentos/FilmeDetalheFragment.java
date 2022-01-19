package com.imd.ufrn.filmeapp2.fragmentos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import com.imd.ufrn.filmeapp2.R;
import com.imd.ufrn.filmeapp2.model.Filme;


public class FilmeDetalheFragment extends Fragment {
    TextView tvNome;
    TextView tvDuracao;
    TextView tvAno;
    RatingBar rbEstrelas;

    public static  final String TAG_DETALHE = "tagDetalhes";
    public static  final String FILME = "tagDetalhes";

    Filme mFilme;

    public static FilmeDetalheFragment novaInstancia(Filme filme) {

        FilmeDetalheFragment filmeDetalheFragment = new FilmeDetalheFragment();

        Bundle parametros = new Bundle();
        parametros.putSerializable(FILME,filme);

        filmeDetalheFragment.setArguments(parametros);

        return  filmeDetalheFragment;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mFilme = (Filme) getArguments().getSerializable(FILME);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
    View layout = inflater.inflate(R.layout.fragment_filme_detalhe,container,false);

    tvNome = layout.findViewById(R.id.tvNome);
    tvDuracao = layout.findViewById(R.id.tvDuracao);
    tvAno = layout.findViewById(R.id.tvAno);
    rbEstrelas = layout.findViewById(R.id.rbEstrelas);

    if(mFilme !=null){
        tvNome.setText(mFilme.getNome());
        tvDuracao.setText(mFilme.getDuracao());
        tvAno.setText(String.valueOf(mFilme.getAno_lancamento()));
        rbEstrelas.setRating(mFilme.getEstrelas());
    }
        return layout;
    }
}