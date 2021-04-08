package com.tlom.novenapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.tlom.novenapp.R;

public class DivinaMisericordiaActivity extends AppCompatActivity {

    private Button buttonConcluir;
    private TextView textDia, textOracaoDia;
    private int dia = 1;
    private int tituloDia, oracaoDia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_divina_misericordia);

        textDia = findViewById(R.id.textDia);
        textOracaoDia = findViewById(R.id.textOracaoDia);

        buttonConcluir = findViewById(R.id.buttonConcluir);
        buttonConcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                concluirDia();
            }
        });

    }

    public void concluirDia(){

        if (dia==9) {
            dia = 1;
        }else{
            dia++;
        }
        switch (dia){
            case 1:
                tituloDia = R.string.dm_titulo_dia1;
                oracaoDia = R.string.dm_oracao_dia1;
                break;
            case 2:
                tituloDia = R.string.dm_titulo_dia2;
                oracaoDia = R.string.dm_oracao_dia2;
                break;
            case 3:
                tituloDia = R.string.dm_titulo_dia3;
                oracaoDia = R.string.dm_oracao_dia3;
                break;
            case 4:
                tituloDia = R.string.dm_titulo_dia4;
                oracaoDia = R.string.dm_oracao_dia4;
                break;
            case 5:
                tituloDia = R.string.dm_titulo_dia5;
                oracaoDia = R.string.dm_oracao_dia5;
                break;
            case 6:
                tituloDia = R.string.dm_titulo_dia6;
                oracaoDia = R.string.dm_oracao_dia6;
                break;
            case 7:
                tituloDia = R.string.dm_titulo_dia7;
                oracaoDia = R.string.dm_oracao_dia7;
                break;
            case 8:
                tituloDia = R.string.dm_titulo_dia8;
                oracaoDia = R.string.dm_oracao_dia8;
                break;
            case 9:
                tituloDia = R.string.dm_titulo_dia9;
                oracaoDia = R.string.dm_oracao_dia9;
                break;
        }
        textDia.setText(tituloDia);
        textOracaoDia.setText(oracaoDia);
        buttonConcluir.setText("Concluir "+dia+"º Dia");
    }

}
