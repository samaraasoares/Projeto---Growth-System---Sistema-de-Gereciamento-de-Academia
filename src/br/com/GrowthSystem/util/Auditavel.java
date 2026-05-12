package br.com.GrowthSystem.util;

public interface Auditavel {
    void registrarLog(String acao);
    String obterHistorico();
}