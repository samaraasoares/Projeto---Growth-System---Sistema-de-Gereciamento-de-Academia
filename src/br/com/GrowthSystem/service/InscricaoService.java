package br.com.GrowthSystem.service;

import br.com.GrowthSystem.model.*;
import br.com.GrowthSystem.dao.InscricaoDAO;

public class InscricaoService {
    private InscricaoDAO dao = new InscricaoDAO();

    public void matricular(int id, Aluno al, Aula au) throws Exception {
        // Validação de Lotação
        if (dao.contarPorAula(au.getId()) >= au.getCapacidadeMax()) {
            throw new Exception(" Aula lotada! Limite de " + au.getCapacidadeMax() + " atingido.");
        }
        dao.inserir(new Inscricao(id, al, au, "12/05/2026"));
        al.registrarLog("Inscrito na aula de " + au.getModalidade());
    }
}