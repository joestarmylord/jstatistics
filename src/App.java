import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {

        // if
        // if else
        // switch
        // ternário ? :

        int op = Integer.parseInt(JOptionPane.showInputDialog(null, "Qual o resultado de uma população? \n 1. Parâmetro \n 2. Estatistica"));
        if (op == 1) {
            JOptionPane.showMessageDialog(null, "Certa a resposta!");
        } else {
            JOptionPane.showMessageDialog(null, "Resposta incorreta!", "JStatistics", JOptionPane.ERROR_MESSAGE);
        }

        // Exercícios:
        // Considerando os números 30, 50, 80, 90. Digite o valor da média aritmética simples. (62,5);
        // Considerando os valores 10, 40, 50, 80, 10. Digite qual é a moda? (10)
        // Qual a medida de tendência central que mostra o centro da amostra? (mediana)

        // dica
        // String nome;
        // if nome.equals("mediana")

        // dica
        // double resposta = Double.parseDouble()

        double media = Double.parseDouble(JOptionPane.showInputDialog(null, "Considerando os números: 30, 50, 80, 90. \nDigite o valor da média aritmética simples."));
        if (media == 62.5) {
            JOptionPane.showMessageDialog(null, "Certa a resposta!");
        } else {
            JOptionPane.showMessageDialog(null, "Resposta incorreta!", "JStatistics", JOptionPane.ERROR_MESSAGE);
        }

        int exe2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Considerando os valores: 10, 40, 50, 80, 10. \nDigite qual é a moda?"));
        if (exe2 == 10) {
            JOptionPane.showMessageDialog(null, "Certa a resposta!");
        } else {
            JOptionPane.showMessageDialog(null, "Resposta incorreta!", "JStatistics", JOptionPane.ERROR_MESSAGE);
        }

        String mediana = JOptionPane.showInputDialog("Qual a medida de tendência central que mostra o centro da amostra?");
        if (mediana.equalsIgnoreCase("mediana")){
            JOptionPane.showMessageDialog(null, "Certa a resposta!");
        } else {
            JOptionPane.showMessageDialog(null, "Resposta incorreta!", "JStatistics", JOptionPane.ERROR_MESSAGE);
        }

    }
}
