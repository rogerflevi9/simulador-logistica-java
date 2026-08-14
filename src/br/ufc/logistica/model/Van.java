package br.ufc.logistica.model;

public class Van extends Veiculo{
    private double tarifaFixaUrbana;
    private double custoPorKm;

    public Van(String placa, double capacidadeMaxKg, double tarifaFixaUrbana, double custoPorKm){
        super(placa, capacidadeMaxKg);
        this.tarifaFixaUrbana = tarifaFixaUrbana;
        this.custoPorKm = custoPorKm;
    }

    @Override
    public double calcularCustoViagem(double distanciaKm){
        return tarifaFixaUrbana + (custoPorKm * distanciaKm);
    }
    
    public double getTarifaFixaUrbana(){
        return tarifaFixaUrbana;
    }
    public double custoPorKm(){
        return custoPorKm;
    }
}
