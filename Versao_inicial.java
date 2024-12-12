import javax.swing.*;
import java.util.List;
import java.util.Arrays;

class Metal {
    private String nome;
    private double potencial;

    public Metal(String nome, double potencial) {
        this.nome = nome;
        this.potencial = potencial;
    }

    public String get_nome() {
        return nome;
    }

    public double get_potencial() {
        return potencial;
    }
}

public class Pilha_De_Metais {

    public static void main(String[] args) {
        // Criando os metais disponíveis
        List<Metal> metais = Arrays.asList(
            new Metal("Lítio (Li)", -3.040),
            new Metal("Potássio (K)", -2.931),
            new Metal("Cálcio (Ca)", -2.868),
            new Metal("Sódio (Na)", -2.710),
            new Metal("Magnésio (Mg)", -2.370),
            new Metal("Alumínio (Al)", -1.660),
            new Metal("Zinco (Zn)", -0.763),
            new Metal("Cromo (Cr)", -0.744),
            new Metal("Ferro (Fe)", -0.440),
            new Metal("Níquel (Ni)", -0.250),
            new Metal("Chumbo (Pb)", -0.126),
            new Metal("Hidrogênio (H)", 0.000),
            new Metal("Cobre (Cu)", 0.337),
            new Metal("Prata (Ag)", 0.799),
            new Metal("Mercúrio (Hg)", 0.851),
            new Metal("Paládio (Pd)", 0.987),
            new Metal("Platina (Pt)", 1.200),
            new Metal("Ouro (Au)", 1.680)
        );

        StringBuilder opcoes = new StringBuilder("Escolha dois metais para formar a pilha:\n");
        for (int i = 0; i < metais.size(); i++) {
            opcoes.append((i + 1)).append(". ").append(metais.get(i).get_nome()).append("\n");
        }

        try {
            int escolha_1 = Integer.parseInt(JOptionPane.showInputDialog(null, opcoes.toString() + "\nEscolha o primeiro metal (1-18):", "Escolha de Metal", JOptionPane.QUESTION_MESSAGE)) - 1;
            int escolha_2 = Integer.parseInt(JOptionPane.showInputDialog(null, opcoes.toString() + "\nEscolha o segundo metal (1-18):", "Escolha de Metal", JOptionPane.QUESTION_MESSAGE)) - 1;

            if (escolha_1 == escolha_2 || escolha_1 < 0 || escolha_2 < 0 || escolha_1 >= metais.size() || escolha_2 >= metais.size()) {
                JOptionPane.showMessageDialog(null, "Escolhas inválidas. Por favor, escolha dois metais diferentes e válidos.", "Erro", JOptionPane.ERROR_MESSAGE);
            } else {
                Metal metal_1 = metais.get(escolha_1);
                Metal metal_2 = metais.get(escolha_2);
                double delta_e = Math.abs(metal_1.get_potencial() - metal_2.get_potencial());

                JOptionPane.showMessageDialog(null, "Metais escolhidos:\n- " + metal_1.get_nome() + "\n- " + metal_2.get_nome() +
                    String.format("\nO potencial da pilha formada é: %.2f V", delta_e), "Resultado", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, insira números válidos.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}