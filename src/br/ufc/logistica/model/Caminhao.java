package br.ufc.logistica.model;

public class Caminhao extends Veiculo {
    private int quantidadeEixos;
    private double custoPorKm;

    public Caminhao(String placa, double capacidadeMaxKg, int quantidadeEixos, double custoPorKm){
        super(placa, capacidadeMaxKg);
        this.quantidadeEixos = quantidadeEixos;
        this.custoPorKm = custoPorKm;
    }

    @Override
    public double calcularCustoViagem(double distanciaKm){
        double pedagioEstimado = quantidadeEixos * 12.50;
        return (distanciaKm * custoPorKm) + pedagioEstimado;
    }
    
    public int getQuantidadeEixos(){
        return quantidadeEixos;
    }
    public double custoPorKm(){
        return custoPorKm;
    }
    
}
