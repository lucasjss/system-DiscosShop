package com.example.sonodisco;

import java.util.Objects;

public class Discos {
    String Nome, Autoria, genero, Lancamento;

    public Discos(String nome, String autoria, String genero, String lancamento, int quantidade) {
        this.Nome = nome;
        this.Autoria = autoria;
        this.genero = genero;
        this.Lancamento = lancamento;
    }

    public Discos() {
    }

    @Override
    public String toString() {
        return "Discos{" +
                "Nome='" + Nome + '\'' +
                ", Autoria='" + Autoria + '\'' +
                ", genero='" + genero + '\'' +
                ", Lancamento=" + Lancamento +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Discos discos = (Discos) o;
        return Objects.equals(Nome, discos.Nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Nome);
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getAutoria() {
        return Autoria;
    }

    public void setAutoria(String autoria) {
        Autoria = autoria;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getLancamento() {
        return Lancamento;
    }

    public void setLancamento(String lancamento) {
        Lancamento = lancamento;
    }
}
