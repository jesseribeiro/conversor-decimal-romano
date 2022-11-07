package br.com.jesse.converter;

import javax.swing.*;

public class Conversor {

    public void iniciodojogo() {
        while (true) {
            if (JOptionPane.showConfirmDialog(null, "Converter um número?", "Conversão número", JOptionPane.YES_OPTION, JOptionPane.INFORMATION_MESSAGE) == 1) {
                break;
            }
            pergunta();
        }
    }

    protected boolean pergunta() {
        String valor = JOptionPane.showInputDialog(null, "Qual número você quer converter?", "Conversão número", JOptionPane.INFORMATION_MESSAGE);
        if (valor.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Valor em branco. Digite algum valor!", "Conversão número", JOptionPane.YES_NO_OPTION);
            pergunta();
            return false;
        }

        Integer numeral = 0;

        ConverterService convert = new ConverterService();
        VerificadorService verif = new VerificadorService();

        Boolean numeroExistente = true;
        try {
            numeral = Integer.parseInt(valor);
            if (numeral <= 0) {
                numeroExistente = false;
            }
        } catch (Exception e) {
            valor = valor.toUpperCase();
            if (!verif.ifNumerosInvalidos(valor) || !convert.ifExistsValor(valor) || !verif.verificaQtdRomano(valor)) {
                numeroExistente = false;
            }
        }

        if (!numeroExistente) {
            JOptionPane.showMessageDialog(null, "Número inexistente, tente outro número!", "Conversão número", JOptionPane.YES_NO_OPTION);
            pergunta();
            return false;
        }

        if (numeral > 0) {
            String result = convert.traduzirNumeralRomano(numeral);
            JOptionPane.showMessageDialog(null, "O número em romano é " + result+"!", "Conversão número", JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(null, verif.contabilizarNumeros(result), "Conversão número", JOptionPane.INFORMATION_MESSAGE);
        } else {
            Integer result = convert.traduzNumeroDecimal(valor);
            JOptionPane.showMessageDialog(null, "O número em decimal é " + result+"!", "Conversão número", JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(null, verif.contabilizarNumeros(valor), "Conversão número", JOptionPane.INFORMATION_MESSAGE);
        }
        return false;
    }
}