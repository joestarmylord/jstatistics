// import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {
        // Aplicando lógica de programação (Aristóteles e George "boolean")
        Scanner leia = new Scanner(System.in);
        // Variável: é um espaço reservado na memória do computador
        // Variavél: serve para guardar valores
        // Variavél: ela tem um tipo (texto, número, lógica...)

        // Exercicio 1: crie um algoritmo para JStatistics que leia a opção desejada:
        // "Qual o conjunto de dados utilizado?"
        // 1. Populacional ou 2. Amostral
        // Observação: o valor recebido deve ser um valor inteiro.

        

        int opcao; // Declarei a variável em java.
        // System.out.println("\t #------- \t #------- \t JStatistics \t #------- \t #------- \t");
        // System.out.println("Qual o conjunto de dados utilizado? \n 1. Populacional \n 2. Amostral");
        // opcao = leia.nextInt();
        // System.out.println(opcao);
        JOptionPane.showMessageDialog(null, "O jogo da estatisticas: JStatistics");
        opcao = Integer.parseInt(JOptionPane.showInputDialog("Vamos começar o jogo? \n Escolha a estratégia: \n 1.Populacional \n 2. Amostral"));
        JOptionPane.showMessageDialog(null, "Você escolheu: "+opcao, "JStatistics", JOptionPane.DEFAULT_OPTION);

        // Exercicio 2: você deve criar um menu perguntando para o usuário:
        // que tipo de variável ele deseja cadastrar: 1. Quantitativo 2. Qualitativo
        // O menu deve ter as quebras de linha conforme o texto abaixo.
        // Tudo deve ser feito em apenas um system
        // Mostre a opção escolhida (o número lido)

        String opcaoVariavel = JOptionPane.showInputDialog(null," Que tipo de variável ele deseja cadastrar?\n 1. Quantitativo \n 2. Qualitativo");
        int opVariavel = Integer.parseInt(opcaoVariavel);
        // JOptionPane.showMessageDialog(null, opVariavel);
        JOptionPane.showMessageDialog(null, "Sua escolha foi: "+opVariavel, "JStatistics", JOptionPane.OK_OPTION);
    }
}
