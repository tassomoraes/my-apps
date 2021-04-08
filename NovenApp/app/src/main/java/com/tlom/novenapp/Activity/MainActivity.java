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
import com.tlom.novenapp.R;
import com.tlom.novenapp.RecyclerItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Novena> novenaList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

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
                                Intent intent = new Intent(getApplicationContext(),SaoJoseActivity.class);
                                startActivity(intent);
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

        Novena novena = new Novena("Novena de São José", "1º Dia", R.drawable.sao_jose);
        novenaList.add(novena);

        novena = new Novena("Novena de São Rafael Arcanjo", "1º Dia", R.drawable.sao_rafael);
        novenaList.add(novena);

        novena = new Novena("Novena da Divina Misericórdia", "5º Dia", R.drawable.jesus_misericordioso);
        novenaList.add(novena);

    }
}
