package com.tlom.novenapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.tlom.novenapp.R;

public class SaoRafaelActivity extends AppCompatActivity {


    private Button buttonConcluir;
    private int dia = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sao_rafael);

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
        buttonConcluir.setText("Concluir "+dia+"º Dia");
    }

}
