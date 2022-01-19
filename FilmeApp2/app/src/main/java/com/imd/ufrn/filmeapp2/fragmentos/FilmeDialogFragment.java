package com.imd.ufrn.filmeapp2.fragmentos;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;

import com.imd.ufrn.filmeapp2.R;
import com.imd.ufrn.filmeapp2.model.Filme;


public class FilmeDialogFragment extends DialogFragment {


    public FilmeDialogFragment() {
        // Required empty public constructor
    }
    public static final String DIALOG_TAG = "addDialog";

    private EditText eTNome;
    private EditText eTDuracao;
    private EditText eTAno;
    private EditText eTEstrelas;

    private Button btnSalvar;
    private RatingBar rbEstrela;

    //variavel representa filme que será adicionado
    Filme mFilme;

    public static  FilmeDialogFragment novaInstancia(){
        //1. instanciar fragmento que vai ser iniciado
        FilmeDialogFragment filmeDialogFragment = new FilmeDialogFragment();

        return filmeDialogFragment;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mFilme = new Filme();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout= inflater.inflate(R.layout.fragment_filme_dialog, container, false);

        eTNome = layout.findViewById(R.id.etNome);
        eTAno= layout.findViewById(R.id.etAno);

        eTDuracao = layout.findViewById(R.id.etDuracao);
        rbEstrela= layout.findViewById(R.id.rbEstrelas);

        btnSalvar = layout.findViewById(R.id.btnSalvar);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvarFilme();
            }
        });
        getDialog().setTitle("Novo Filme");
        return  layout;
    }

    private void salvarFilme(){
        Activity activity = getActivity();

        if(activity instanceof AoSalvarFilme){
            mFilme.setNome(eTNome.getText().toString());
            mFilme.setDuracao(eTDuracao.getText().toString());
            mFilme.setAno_lancamento(Integer.parseInt(eTAno.getText().toString()));
            mFilme.setEstrelas(rbEstrela.getRating());

        }

        AoSalvarFilme listener = (AoSalvarFilme) activity;
        listener.salvouFilme(mFilme);
        //fecha dialog
        dismiss();

    }


    public interface AoSalvarFilme{
        void salvouFilme(Filme filme);
    }


}