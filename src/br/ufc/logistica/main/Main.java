package br.ufc.logistica.main;

import br.ufc.logistica.exception.CargaExcedidaException;
import br.ufc.logistica.model.Caminhao;
import br.ufc.logistica.model.Carga;
import br.ufc.logistica.model.Van;
import br.ufc.logistica.model.Veiculo;

public class Main {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("       SIMULADOR DE SISTEMA LOGÍSTICO E TRÁFEGO      ");
        System.out.println("==================================================\n");

        Veiculo caminhao = new Caminhao("NUV-2026", 5000.0, 3, 4.50);
        Veiculo van = new Van("FORT-8899", 800.0, 50.0, 2.10);

        Carga cargaEletrodomesticos = new Carga("Lote de geladeiras", 600.0);
        Carga cargaGraos = new Carga("Sacas de milhos", 3000.0);
        Carga cargaPesadaExcedente = new Carga("Maquinario Industrial", 2500.0);


        try {
            System.out.println("---> Carregando o Caminhao (" + caminhao.getPlaca() + "...");
            caminhao.adicionarCarga(cargaEletrodomesticos);
            caminhao.adicionarCarga(cargaGraos);

            System.out.println("Carga adicionada com sucesso!");
            System.out.println("    Peso atual do caminhao: " + caminhao.getPesoAtualKg());
            
            double distanciaDist = 250.0;
            double custoCaminhao = caminhao.calcularCustoViagem(distanciaDist);
        } catch (CargaExcedidaException e) {
            System.err.println("ERRO NO CAMINHAO: " + e.getMessage() + "\n");
        }

        try {
            System.out.println("---> Carregando a Van (" + van.getPlaca() + ")...");
            van.adicionarCarga(cargaEletrodomesticos);
            System.out.println("✔ Primeira carga de " + cargaEletrodomesticos.getPesoKg() + "kg adicionada na Van.");

            System.out.println("---> Tentando adicionar carga excessiva...");
            van.adicionarCarga(cargaPesadaExcedente); // +2500kg (Vai estourar os 800kg!)

        } catch (CargaExcedidaException e) {
            System.out.println("\n--------------------------------------------------");
            System.out.println("⚠ EXCEÇÃO CAPTURADA COM SUCESSO!");
            System.out.println("Mensagem: " + e.getMessage());
            System.out.println("--------------------------------------------------\n");
        }

        System.out.println("=== Simulação finalizada sem travamentos da aplicação! ===");
    }
}