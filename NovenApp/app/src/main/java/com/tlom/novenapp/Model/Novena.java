package com.tlom.novenapp.Model;

public class Novena {

    String titulo;
    String dia;
    int imagem;

    public Novena() {
    }

    public Novena(String titulo, String dia, int imagem) {
        this.titulo = titulo;
        this.dia = dia;
        this.imagem = imagem;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }
}
