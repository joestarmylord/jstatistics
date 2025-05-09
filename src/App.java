import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

public class App {

    public static void main(String[] args) {
        try {
            JOptionPane.showMessageDialog(null, "Alô, Jardim!", "Jardim do Ébano", JOptionPane.OK_OPTION);

            String nome;
            while (true) {
                nome = JOptionPane.showInputDialog(null, "Preencha o campo abaixo com seu nome completo:", "Jardim do Ébano", JOptionPane.OK_OPTION);
                if (nome == null) throw new Exception("Entrada cancelada.");
                if (nome.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Erro: o nome não pode estar vazio.", "Jardim do Ébano", JOptionPane.ERROR_MESSAGE);
                } else {
                    break;
                }
            }

            String endereco;
            while (true) {
                endereco = JOptionPane.showInputDialog(null, "Preencha o campo abaixo com seu endereço (letras e números):", "Jardim do Ébano", JOptionPane.OK_OPTION);
                if (endereco == null) throw new Exception("Entrada cancelada.");
                if (endereco.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Erro: o endereço não pode estar vazio.", "Jardim do Ébano", JOptionPane.ERROR_MESSAGE);
                } else {
                    break;
                }
            }

            String telefone;
            while (true) {
                telefone = JOptionPane.showInputDialog(null, "Digite seu número de telefone (11 dígitos, apenas números):", "Jardim do Ébano", JOptionPane.OK_OPTION);
                if (telefone == null) throw new Exception("Entrada cancelada.");
                if (!telefone.matches("\\d{11}")) {
                    JOptionPane.showMessageDialog(null, "Erro: o telefone deve conter exatamente 11 números sem espaços, traços ou letras.", "Jardim do Ébano", JOptionPane.ERROR_MESSAGE);
                } else {
                    break;
                }
            }

            double largura = 0;
            while (true) {
                try {
                    String inputLargura = JOptionPane.showInputDialog(null, "Informe a largura do jardim em metros:", "Jardim do Ébano", JOptionPane.OK_OPTION);
                    if (inputLargura == null) throw new Exception("Entrada cancelada.");
                    largura = Double.parseDouble(inputLargura);
                    if (largura <= 0) {
                        JOptionPane.showMessageDialog(null, "Erro: a largura deve ser maior que zero.", "Jardim do Ébano", JOptionPane.ERROR_MESSAGE);
                    } else {
                        break;
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Erro: insira um número válido para a largura.", "Jardim do Ébano", JOptionPane.ERROR_MESSAGE);
                }
            }

            double comprimento = 0;
            while (true) {
                try {
                    String inputComprimento = JOptionPane.showInputDialog(null, "Informe o comprimento do jardim em metros:", "Jardim do Ébano", JOptionPane.OK_OPTION);
                    if (inputComprimento == null) throw new Exception("Entrada cancelada.");
                    comprimento = Double.parseDouble(inputComprimento);
                    if (comprimento <= 0) {
                        JOptionPane.showMessageDialog(null, "Erro: o comprimento deve ser maior que zero.", "Jardim do Ébano", JOptionPane.ERROR_MESSAGE);
                    } else {
                        break;
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Erro: insira um número válido para o comprimento.", "Jardim do Ébano", JOptionPane.ERROR_MESSAGE);
                }
            }

            double area = largura * comprimento;
            String classificacao = (area >= 50) ? "Grande" : "Pequeno";

            JOptionPane.showMessageDialog(null, "Dados salvos! \nAguarde que entraremos em contato!", "Jardim do Ébano", JOptionPane.OK_OPTION);

            File arquivo = new File("dadoscliente.txt");
            boolean arquivoExiste = arquivo.exists();
            FileWriter writer = new FileWriter(arquivo, true);

            if (!arquivoExiste) {
                writer.write("Nome, Endereço, Telefone, Área do Jardim (m²), Tamanho\n");
            }

            writer.write(nome + ", " + endereco + ", " + telefone + ", " + area + ", " + classificacao + "\n");
            writer.close();

            int servicos = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Escolha um tipo de serviço: \n1. Administração \n2. Manutenção \n3. Criação de Jardins",
                    "Jardim do Ébano", JOptionPane.OK_OPTION));

            switch (servicos) {
                case 1:
                    JOptionPane.showMessageDialog(null, "Você optou por serviços administrativos!", "Jardim do Ébano", JOptionPane.OK_OPTION);
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Você optou por serviços de manutenção!", "Jardim do Ébano", JOptionPane.OK_OPTION);
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Você optou por serviços de criação de jardins!", "Jardim do Ébano", JOptionPane.OK_OPTION);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida! \nTente novamente!", "Jardim do Ébano", JOptionPane.OK_OPTION);
                    break;
            }

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar os dados no arquivo.", "Jardim do Ébano", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Operação cancelada ou inválida: " + e.getMessage(), "Jardim do Ébano", JOptionPane.WARNING_MESSAGE);
        }
    }
}
