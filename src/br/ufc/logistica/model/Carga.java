package br.ufc.logistica.model;

public class Carga {
    private String descricao;
    private double pesoKg;

    public Carga(String descricao, double pesoKg){
        this.descricao = descricao;
        this.pesoKg = pesoKg;
    }

    public String getDescricao(){
        return descricao;
    }
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }

    public double getPesoKg(){
        return pesoKg;
    }
    public void setPesoKg(double pesoKg){
        this.pesoKg = pesoKg;
    }

}