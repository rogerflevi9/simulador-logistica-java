package br.ufc.logistica.model;

import br.ufc.logistica.exception.CargaExcedidaException;
import java.util.ArrayList;
import java.util.List;

public abstract class Veiculo {
    private String placa;
    private double capacidadeMaxKg;
    private double pesoAtualKg;
    private List<Carga> cargas;

    public Veiculo(String placa, double capacidadeMaxKg){
        this.placa = placa;
        this.capacidadeMaxKg = capacidadeMaxKg;
        this.pesoAtualKg = 0.0;
        this.cargas = new ArrayList<>();
    }

    public void adicionarCarga(Carga carga) throws CargaExcedidaException {
        if(this.pesoAtualKg + carga.getPesoKg() > capacidadeMaxKg) {
            throw new CargaExcedidaException("Falha ao carregar veiculo" + placa + "Carga de: " + carga.getPesoKg() + "kg excede o limite em " + (capacidadeMaxKg - pesoAtualKg) + "kg");

        }  
        this.cargas.add(carga);
        this.pesoAtualKg += carga.getPesoKg();  
    }

    public abstract double calcularCustoViagem(double distanciaKm);

    public String getPlaca(){
        return placa;
    }
    public double getCapacidadeMaximakg(){
        return capacidadeMaxKg;
    }
    public double getPesoAtualKg(){
        return pesoAtualKg;
    }
    public List<Carga> getCargas(){
        return cargas;
    }

}
