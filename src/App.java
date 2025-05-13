import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class App {

    public static void main(String[] args) {
        try {
            JOptionPane.showMessageDialog(null, "Alô, Jardim!", "Jardim do Ébano", JOptionPane.OK_OPTION);

            String nome;
            while (true) {
                nome = JOptionPane.showInputDialog(null, "Nome completo:", "Jardim do Ébano", JOptionPane.OK_OPTION);
                if (nome == null) throw new Exception("Entrada cancelada.");
                if (nome.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Erro: o nome não pode estar vazio.", "Jardim do Ébano", JOptionPane.ERROR_MESSAGE);
                } else break;
            }

            String endereco;
            while (true) {
                endereco = JOptionPane.showInputDialog(null, "Endereço:", "Jardim do Ébano", JOptionPane.OK_OPTION);
                if (endereco == null) throw new Exception("Entrada cancelada.");
                if (endereco.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Erro: o endereço não pode estar vazio.", "Jardim do Ébano", JOptionPane.ERROR_MESSAGE);
                } else break;
            }

            String telefone;
            while (true) {
                telefone = JOptionPane.showInputDialog(null, "Telefone (11 dígitos):", "Jardim do Ébano", JOptionPane.OK_OPTION);
                if (telefone == null) throw new Exception("Entrada cancelada.");
                if (!telefone.matches("\\d{11}")) {
                    JOptionPane.showMessageDialog(null, "Erro: o telefone deve conter 11 números.", "Jardim do Ébano", JOptionPane.ERROR_MESSAGE);
                } else break;
            }

            double largura = 0, comprimento = 0;
            while (true) {
                try {
                    largura = Double.parseDouble(JOptionPane.showInputDialog(null, "Largura do jardim (m):", "Jardim do Ébano", JOptionPane.OK_OPTION));
                    if (largura <= 0) throw new NumberFormatException();
                    break;
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Erro: insira uma largura válida.", "Jardim do Ébano", JOptionPane.ERROR_MESSAGE);
                }
            }

            while (true) {
                try {
                    comprimento = Double.parseDouble(JOptionPane.showInputDialog(null, "Comprimento do jardim (m):", "Jardim do Ébano", JOptionPane.OK_OPTION));
                    if (comprimento <= 0) throw new NumberFormatException();
                    break;
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Erro: insira um comprimento válido.", "Jardim do Ébano", JOptionPane.ERROR_MESSAGE);
                }
            }

            double area = largura * comprimento;
            String classificacao = (area >= 50) ? "Grande" : "Pequeno";

            List<String> servicos = new ArrayList<>();
            boolean continuar = true;

            while (continuar) {
                int opcao = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "Escolha um serviço:\n1. Administração\n2. Manutenção\n3. Criação de Jardins",
                        "Jardim do Ébano", JOptionPane.OK_OPTION));
                        
                String servicoSelecionado = "";
                String descricaoServico = "";

                switch (opcao) {
                    case 1:
                        servicoSelecionado = "Administração";
                        descricaoServico = "Organização de cronogramas, controle de plantas e agendamentos.";
                        break;
                    case 2:
                        servicoSelecionado = "Manutenção";
                        descricaoServico = "Poda, irrigação e cuidados periódicos com o jardim.";
                        break;
                    case 3:
                        servicoSelecionado = "Criação de Jardins";
                        descricaoServico = "Projeto paisagístico completo, do planejamento à execução.";
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opção inválida!", "Jardim do Ébano", JOptionPane.WARNING_MESSAGE);
                        continue;
                }
                
                JOptionPane.showMessageDialog(null,
                        "Você escolheu: " + servicoSelecionado + "\nDescrição: " + descricaoServico,
                        "Serviço Escolhido", JOptionPane.INFORMATION_MESSAGE);
                

                if (!servicos.contains(servicoSelecionado)) {
                    servicos.add(servicoSelecionado);
                    JOptionPane.showMessageDialog(null, "Serviço adicionado: " + servicoSelecionado, "Jardim do Ébano", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Serviço já contratado.", "Jardim do Ébano", JOptionPane.WARNING_MESSAGE);
                }

                int resposta = JOptionPane.showConfirmDialog(null, "Deseja contratar mais um serviço?", "Jardim do Ébano", JOptionPane.YES_NO_OPTION);
                continuar = (resposta == JOptionPane.YES_OPTION);
            }

            int qtd = servicos.size();
            int desconto = (qtd >= 3) ? 20 : (qtd == 2) ? 10 : 0;
            String dadosCliente = nome + ", " + endereco + ", " + telefone + ", " + area + ", " + classificacao + ", " + String.join(" | ", servicos) + ", " + desconto + "%\n";
            File arquivo = new File("dadoscliente.txt");
            boolean arquivoExiste = arquivo.exists();

            FileOutputStream fos = new FileOutputStream(arquivo, true);
            OutputStreamWriter writer;

            if (!arquivoExiste) {
                fos.write(0xEF);
                fos.write(0xBB);
                fos.write(0xBF);
                writer = new OutputStreamWriter(fos, "UTF-8");
                writer.write("Nome, Endereço, Telefone, Área (m²), Tamanho, Serviços, Desconto (%)\n");
            } else {
                writer = new OutputStreamWriter(fos, "UTF-8");
            }

            writer.write(dadosCliente);
            writer.close();

            JOptionPane.showMessageDialog(null,
                    "Dados salvos com sucesso!\nServiços contratados: " + qtd + "\nDesconto aplicado: " + desconto + "%",
                    "Jardim do Ébano", JOptionPane.INFORMATION_MESSAGE);

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao gravar o arquivo.", "Jardim do Ébano", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Encerrado: " + e.getMessage(), "Jardim do Ébano", JOptionPane.WARNING_MESSAGE);
        }
    }
}
