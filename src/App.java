import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class App {

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Alô, Jardim!", "Jardim", JOptionPane.OK_OPTION);

        String nome = JOptionPane.showInputDialog(null, "Preencha o campo abaixo com seu nome completo.", "Jardim", JOptionPane.OK_OPTION);
        String endereco = JOptionPane.showInputDialog(null, "Preencha o campo abaixo com seu endereço (letras e números).", "Jardim", JOptionPane.OK_OPTION);
        String telefone = JOptionPane.showInputDialog(null, "Preencha o campo abaixo com seu número de telefone (apenas números).", "Jardim", JOptionPane.OK_OPTION);

        double largura = Double.parseDouble(JOptionPane.showInputDialog(null, "Informe a largura do jardim em metros:", "Jardim", JOptionPane.OK_OPTION));
        double comprimento = Double.parseDouble(JOptionPane.showInputDialog(null, "Informe o comprimento do jardim em metros:", "Jardim", JOptionPane.OK_OPTION));
        double area = largura * comprimento;

        JOptionPane.showMessageDialog(null, "Dados salvos!", "Jardim", JOptionPane.OK_OPTION);

        try {
            FileWriter writer = new FileWriter("dadoscliente.txt");
            writer.write("Nome, Endereço, Telefone, Área do Jardim (m²)\n");
            writer.write(nome + ", " + endereco + ", " + telefone + ", " + area + "\n");
            writer.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar o arquivo", "Jardim", JOptionPane.OK_OPTION);
        }
    }
}

