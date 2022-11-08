package br.com.jesse.converter;

import java.util.HashMap;
import java.util.Set;

public class VerificadorService {

    public boolean verificaQtdRomano(String romano) {
        ConverterService converter = new ConverterService();
        Character[] listaChar = converter.getCharacters(romano);

        HashMap<String, Integer> map = getHashMapNumeros(romano, listaChar);

        Set<String> chaves = map.keySet();

        // verifica a qtd de cada letra usada
        for (String chave : chaves) {
            Integer qtd = map.get(chave);

            if (qtd > 3 || ((chave.equalsIgnoreCase("V") || chave.equalsIgnoreCase("L") || chave.equalsIgnoreCase("D")) && qtd > 1))  {
                return false;
            }
        }
        return true;
    }

    public Boolean ifNumerosInvalidos(String romano) {
        String[] listaRomano = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        ConverterService converter = new ConverterService();
        Character[] listaChar = converter.getCharacters(romano);

        // verifica se as letras inseridas são validas
        for (char ch : listaChar) {
            Integer cont = 0;

            Integer numerosVerdadeiros = 0;
            while (cont < listaRomano.length) {
                if (String.valueOf(ch).equalsIgnoreCase(listaRomano[cont])) {
                    numerosVerdadeiros++;
                }
                cont++;
            }

            if (numerosVerdadeiros == 0) {
                return false;
            }
        }
        return true;
    }

    public String contabilizarNumeros(String romano) {
        ConverterService converter = new ConverterService();
        Character[] listaChar = converter.getCharacters(romano);

        HashMap<String, Integer> map = getHashMapNumeros(romano, listaChar);

        String rel = "Letras utilizadas: \n";

        Set<String> chaves = map.keySet();
        for (String chave : chaves) {
            Integer qtd = map.get(chave);

            rel += chave + " utilizada " + qtd + " vezes\n";
        }
        return rel;
    }

    private static HashMap<String, Integer> getHashMapNumeros(String romano, Character[] listaChar) {
        Integer cont = 0;
        HashMap<String,Integer> map = new HashMap<>();

        // cria um hashmap das letras e a qtd
        while (cont < romano.length()) {
            Integer qtd = map.get(listaChar[cont].toString());

            if (qtd == null) {
                map.put(listaChar[cont].toString(),1);
            } else {
                qtd++;
                map.remove(listaChar[cont]);
                map.put(listaChar[cont].toString(),qtd);
            }
            cont++;
        }
        return map;
    }
}
