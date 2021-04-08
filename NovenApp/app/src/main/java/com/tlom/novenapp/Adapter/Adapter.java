package com.tlom.novenapp.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tlom.novenapp.Model.Novena;
import com.tlom.novenapp.R;

import org.w3c.dom.Text;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private List<Novena> novenaList;

    public Adapter(List<Novena> novenaList) {
        this.novenaList = novenaList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //Convertendo o xml para uma View (inflate)
        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_list, parent, false);

        return new MyViewHolder( itemLista );
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Novena novena = novenaList.get(position);
        holder.titulo.setText(novena.getTitulo());
        holder.dia.setText(novena.getDia());
        holder.imagem.setImageResource(novena.getImagem());
    }

    @Override
    public int getItemCount() {
        return novenaList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView titulo;
        TextView dia;
        ImageView imagem;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            titulo = itemView.findViewById(R.id.textTitulo);
            dia = itemView.findViewById(R.id.textDia);
            imagem = itemView.findViewById(R.id.imageView);
        }
    }
}
