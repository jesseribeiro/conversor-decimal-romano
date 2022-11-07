package br.com.jesse.converter;

public class ConverterService {

    private static Integer[] listaDecimal = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static String[] listaRomano = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public String traduzirNumeralRomano(Integer decimal) {
        String valor = "";
        Integer cont = 0;

        while (decimal > 0) {
            if (decimal >= listaDecimal[cont]) {
                valor += listaRomano[cont];
                decimal -= listaDecimal[cont];
            } else {
                cont++;
            }
        }
        return valor;
    }

    public Integer traduzNumeroDecimal (String romano) {
        Integer valor = 0;

        Character[] listaChar = getCharacters(romano);

        Integer cont = 0;
        String compara;

        while (cont < romano.length()) {
            Integer i = 0;
            Boolean encontrouValor = false;
            if (romano.length() - cont >= 2) {
                for (String str : listaRomano) {
                    compara = listaChar[cont] + "" + listaChar[cont+1];
                    if (compara.equalsIgnoreCase(str)) {
                        valor += listaDecimal[i];
                        encontrouValor = true;
                        cont += 2;
                        break;
                    }
                    i++;
                }
                if (!encontrouValor) {
                    i = 0;
                    for (String str : listaRomano) {
                        compara = listaChar[cont] + "";
                        if (compara.equalsIgnoreCase(str)) {
                            valor += listaDecimal[i];
                            break;
                        }
                        i++;
                    }
                    cont++;
                }
            }
            else {
                for (String str : listaRomano) {
                    compara = listaChar[cont] + "";
                    if (compara.equalsIgnoreCase(str)) {
                        valor += listaDecimal[i];
                        break;
                    }
                    i++;
                }
                cont++;
            }
        }
        return valor;
    }

    public boolean ifExistsValor(String romano) {
        Character[] listaChar = getCharacters(romano);

        Integer cont = 0;
        Integer ultimoValor = 1000;
        String compara;

        while (cont < romano.length()) {
            Integer i = 0;
            Boolean encontrouValor = false;
            if (romano.length() - cont >= 2) {
                for (String str : listaRomano) {
                    compara = listaChar[cont] + "" + listaChar[cont+1];
                    if (compara.equalsIgnoreCase(str)) {
                        if (listaDecimal[i] > ultimoValor) {
                            return false;
                        }
                        ultimoValor = listaDecimal[i];
                        encontrouValor = true;
                        cont += 2;
                        break;
                    }
                    i++;
                }
                if (!encontrouValor) {
                    i = 0;
                    for (String str : listaRomano) {
                        compara = listaChar[cont] + "";
                        if (compara.equalsIgnoreCase(str)) {
                            if (listaDecimal[i] > ultimoValor) {
                                return false;
                            }
                            ultimoValor = listaDecimal[i];
                            break;
                        }
                        i++;
                    }
                    cont++;
                }
            }
            else {
                for (String str : listaRomano) {
                    compara = listaChar[cont] + "";
                    if (compara.equalsIgnoreCase(str)) {
                        if (listaDecimal[i] > ultimoValor) {
                            return false;
                        }
                        ultimoValor = listaDecimal[i];
                        break;
                    }
                    i++;
                }
                cont++;
            }
        }
        return true;
    }


    public Character[] getCharacters(String romano) {
        Integer cont = 0;
        Character listaChar[] = new Character[romano.length()];
        for (char ch : romano.toCharArray()) {
            listaChar[cont] = ch;
            cont++;
        }
        return listaChar;
    }
}
