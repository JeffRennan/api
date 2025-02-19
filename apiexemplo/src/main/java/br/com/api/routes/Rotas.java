package br.com.api.routes;

import br.com.api.service.*;
import spark.Spark;

public class Rotas {

    public static void processarRotas() {
        // Configuração das rotas de Vacina
        configurarRotasVacina();

        // Configuração das rotas de Dose
        configurarRotasDose();

    }

    // Método para configurar as rotas de Vacina
    private static void configurarRotasVacina() {
                Spark.get("/vacinas/consultar", ServicoVacina.consultarTodasVacinas());
        Spark.get("/vacinas/consultar/faixa_etaria/:faixa", ServicoVacina.consultarPorFaixaEtaria());
        Spark.get("/vacinas/consultar/idade_maior/:meses", ServicoVacina.consultarPorIdadeMaior());
        Spark.get("/vacinas/consultar/nao_aplicaveis/paciente/:id", ServicoVacina.consultarNaoAplicaveis());
    }

    // Método para configurar as rotas de Dose
    private static void configurarRotasDose() {
        Spark.get("/doses/consultar/:idVacina", ServicoDose.consultarDosesPorVacina());
        Spark.get("/doses/consultar/idade/:idadeMeses", ServicoDose.consultarDosesPorIdade());
    }

  


}
