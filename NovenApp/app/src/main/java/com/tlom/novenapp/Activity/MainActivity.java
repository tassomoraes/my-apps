package com.tlom.novenapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;

import com.tlom.novenapp.Adapter.Adapter;
import com.tlom.novenapp.Model.Novena;
import com.tlom.novenapp.NovenaPreferencia;
import com.tlom.novenapp.R;
import com.tlom.novenapp.RecyclerItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Novena> novenaList = new ArrayList<>();
    private NovenaPreferencia preferencia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        preferencia = new NovenaPreferencia(getApplicationContext());

        //Cria listagem de novenas
        this.ciarNovenas();
        
        //Configura Adapter
        Adapter adapter = new Adapter( novenaList );

        //Configura RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager( layoutManager );
        recyclerView.setHasFixedSize( true ); //otimizando: tamanho do RecyclerView fixo
        recyclerView.addItemDecoration( new DividerItemDecoration(this, LinearLayout.VERTICAL)); //adicionando linhas
        recyclerView.setAdapter( adapter );

        //Trata o toque
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getApplicationContext(),
                        recyclerView,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                chamaActivity(position);
                            }

                            @Override
                            public void onLongItemClick(View view, int position) {

                            }

                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            }
                        }
                )
        );

    }

    private void ciarNovenas() {

        //recupera o ultimo dia
        int dia = preferencia.recuperarDia("sj_dia");
        Novena novena = new Novena("Novena de São José", dia, R.drawable.sao_jose);
        novenaList.add(novena);

        novena = new Novena("Novena de São Rafael Arcanjo", 1, R.drawable.sao_rafael);
        novenaList.add(novena);

        novena = new Novena("Novena à Divina Misericórdia", 5, R.drawable.jesus_misericordioso);
        novenaList.add(novena);

    }

    private void chamaActivity(int position){

        Novena novena = novenaList.get( position );
        if (novena.getTitulo().equals("Novena de São José")){
            Intent intent = new Intent(getApplicationContext(),SaoJoseActivity.class);
            int dia =  novena.getDia();
            intent.putExtra("sj_dia",dia);
            startActivity(intent);
            //atualiza o dia do RecycleView
            dia = preferencia.recuperarDia("sj_dia");
            novena.setDia(dia);

        } else if (novena.getTitulo().equals("Novena de São Rafael Arcanjo")){
            Intent intent = new Intent(getApplicationContext(),SaoRafaelActivity.class);
            startActivity(intent);
        } else if (novena.getTitulo().equals("Novena à Divina Misericórdia")){
            Intent intent = new Intent(getApplicationContext(),DivinaMisericordiaActivity.class);
            startActivity(intent);
        }
    }
}
