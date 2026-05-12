package br.com.GrowthSystem.util;

public class ValidadorUtil {
    public static boolean isCpfValido(String cpf) {
        if (cpf == null) return false;
        String limpo = cpf.replaceAll("[^0-9]", "");
        return limpo.length() == 11;
    }
}