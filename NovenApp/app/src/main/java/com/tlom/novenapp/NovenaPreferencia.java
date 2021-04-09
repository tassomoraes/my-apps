package com.tlom.novenapp;

import android.content.Context;
import android.content.SharedPreferences;

public class NovenaPreferencia {

    private Context context;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor; //manipula os arquivos

    private final String NOME_ARQUIVO = "novena.preferencia";

    public NovenaPreferencia( Context c) {
        this.context = c;
        preferences = context.getSharedPreferences(NOME_ARQUIVO,0); //recuperar a anotação
        editor = preferences.edit(); //salvar a anotação
    }

    public void salvarDia (String chave, int dia){
        editor.putInt(chave, dia);
        editor.commit();
    }

    public int recuperarDia(String chave){
        int anotacao = preferences.getInt(chave,1);
        return anotacao;
    }

}
