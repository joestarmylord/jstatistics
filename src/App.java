import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class App {

    public static void main(String[] args) {
        try {
            JOptionPane.showMessageDialog(null, "Alô, Jardim!", "Jardim do Ébano", JOptionPane.INFORMATION_MESSAGE);

            String nome;
            while (true) {
                nome = JOptionPane.showInputDialog(null, "Nome completo:", "Jardim do Ébano", JOptionPane.INFORMATION_MESSAGE);
                if (nome == null) throw new Exception("Entrada cancelada.");
                if (nome.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Erro: o nome não pode estar vazio.", "Jardim do Ébano", JOptionPane.ERROR_MESSAGE);
                } else break;
            }

            String endereco;
            while (true) {
                endereco = JOptionPane.showInputDialog(null, "Endereço:", "Jardim do Ébano", JOptionPane.INFORMATION_MESSAGE);
                if (endereco == null) throw new Exception("Entrada cancelada.");
                if (endereco.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Erro: o endereço não pode estar vazio.", "Jardim do Ébano", JOptionPane.ERROR_MESSAGE);
                } else break;
            }

            String telefone;
            while (true) {
                telefone = JOptionPane.showInputDialog(null, "Telefone (11 dígitos):", "Jardim do Ébano", JOptionPane.INFORMATION_MESSAGE);
                if (telefone == null) throw new Exception("Entrada cancelada.");
                if (!telefone.matches("\\d{11}")) {
                    JOptionPane.showMessageDialog(null, "Erro: o telefone deve conter 11 números.", "Jardim do Ébano", JOptionPane.ERROR_MESSAGE);
                } else break;
            }

            double largura = 0, comprimento = 0;
            while (true) {
                try {
                    largura = Double.parseDouble(JOptionPane.showInputDialog(null, "Largura do jardim (m):", "Jardim do Ébano", JOptionPane.INFORMATION_MESSAGE));
                    if (largura <= 0) throw new NumberFormatException();
                    break;
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Erro: insira uma largura válida.", "Jardim do Ébano", JOptionPane.ERROR_MESSAGE);
                }
            }

            while (true) {
                try {
                    comprimento = Double.parseDouble(JOptionPane.showInputDialog(null, "Comprimento do jardim (m):", "Jardim do Ébano", JOptionPane.INFORMATION_MESSAGE));
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
                        "Jardim do Ébano", JOptionPane.INFORMATION_MESSAGE));
                String servicoSelecionado = "";
                String descricao = "";

                switch (opcao) {
                    case 1:
                        servicoSelecionado = "Administração";
                        descricao = "Organização de cronogramas, controle de plantas e agendamentos.";
                        break;
                    case 2:
                        servicoSelecionado = "Manutenção";
                        descricao = "Poda, irrigação e cuidados periódicos com o jardim.";
                        break;
                    case 3:
                        servicoSelecionado = "Criação de Jardins";
                        descricao = "Projeto paisagístico completo, do planejamento à execução.";
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opção inválida!", "Jardim do Ébano", JOptionPane.WARNING_MESSAGE);
                        continue;
                }

                JOptionPane.showMessageDialog(null,
                        "Você escolheu: " + servicoSelecionado + "\nDescrição: " + descricao,
                        "Serviço Escolhido", JOptionPane.INFORMATION_MESSAGE);

                if (!servicos.contains(servicoSelecionado)) {
                    servicos.add(servicoSelecionado);
                } else {
                    JOptionPane.showMessageDialog(null, "Serviço já contratado.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                }

                int resposta = JOptionPane.showConfirmDialog(null, "Deseja contratar mais um serviço?", "Jardim do Ébano", JOptionPane.YES_NO_OPTION);
                continuar = (resposta == JOptionPane.YES_OPTION);
            }

            int qtd = servicos.size();
            int desconto = (qtd >= 3) ? 20 : (qtd == 2) ? 10 : 0;
            File arquivo = new File("dadoscliente.txt");
            boolean novo = !arquivo.exists();
            FileOutputStream fos = new FileOutputStream(arquivo, true);

            if (novo) {
                fos.write(0xEF); fos.write(0xBB); fos.write(0xBF); 
            }

            OutputStreamWriter writer = new OutputStreamWriter(fos, "UTF-8");

            if (novo) {
                writer.write("Nome, Endereço, Telefone, Área (m²), Tamanho, Serviços, Desconto (%)\n");
            }

            writer.write(nome + ", " + endereco + ", " + telefone + ", " + area + ", " + classificacao + ", " + String.join(" | ", servicos) + ", " + desconto + "%\n");
            writer.close();
            JOptionPane.showMessageDialog(null,
                    "Dados salvos com sucesso!\nServiços contratados: " + qtd + "\nDesconto aplicado: " + desconto + "%",
                    "Jardim do Ébano", JOptionPane.INFORMATION_MESSAGE);

            try {
                File origem = new File("dadoscliente.txt");
                File destino = new File("relatorio_jardins.txt");

                BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(origem), "UTF-8"));
                OutputStreamWriter relatorio = new OutputStreamWriter(new FileOutputStream(destino, false), "UTF-8");
                String linha;
                int totalJardins = 0;
                int grandes = 0;
                int maiores100 = 0;
                double soma = 0;
                reader.readLine();

                while ((linha = reader.readLine()) != null) {
                    String[] campos = linha.split(",");
                    if (campos.length >= 6) {
                        try {
                            double areaLida = Double.parseDouble(campos[3].trim());
                            String tamanho = campos[4].trim();
                            soma += areaLida;
                            totalJardins++;
                            if (tamanho.equalsIgnoreCase("Grande")) grandes++;
                            if (areaLida > 100) maiores100++;
                        } catch (Exception ignored) {}
                    }
                }

                reader.close();
                double media = (totalJardins > 0) ? soma / totalJardins : 0;
                relatorio.write("RELATÓRIO INTERNO DOS JARDINS\n");
                relatorio.write("-------------------------------\n");
                relatorio.write("Total de Jardins: " + totalJardins + "\n");
                relatorio.write("Média de Área: " + String.format("%.2f", media) + " m²\n");
                relatorio.write("Jardins Grandes: " + grandes + "\n");
                relatorio.write("Jardins com mais de 100 m²: " + maiores100 + "\n");
                relatorio.close();
                
            try {
                BufferedReader reader2 = new BufferedReader(new InputStreamReader(new FileInputStream("dadoscliente.txt"), "UTF-8"));
                List<Double> listaAreas = new ArrayList<>();
                List<Integer> qtdeServicos = new ArrayList<>();
                reader2.readLine();
                while ((linha = reader2.readLine()) != null) {
                    String[] campos = linha.split(",");
                    if (campos.length >= 6) {
                        try {
                            double areaLida = Double.parseDouble(campos[3].trim());
                            listaAreas.add(areaLida);
                            String servicosStr = campos[5];
                            int qtde = servicosStr.split("\\|").length;
                            qtdeServicos.add(qtde);
                        } catch (Exception ignored) {}
                    }
                }
                reader2.close();

                double moda = 0;
                int maxFrequencia = 0;
                for (double a : listaAreas) {
                    int freq = 0;
                    for (double b : listaAreas) {
                        if (Double.compare(a, b) == 0) freq++;
                    }
                    if (freq > maxFrequencia) {
                        moda = a;
                        maxFrequencia = freq;
                    }
                }

                qtdeServicos.sort(Integer::compareTo);
                OutputStreamWriter writerAvancado = new OutputStreamWriter(new FileOutputStream("relatorio_jardins.txt", true), "UTF-8");
                writerAvancado.write("\nRELATÓRIO AVANÇADO - ÁREAS E SERVIÇOS\n");
                writerAvancado.write("--------------------------------------\n");
                writerAvancado.write("Áreas registradas:\n");
                for (double a : listaAreas) {
                    writerAvancado.write(String.format("• %.2f m²\n", a));
                }

                writerAvancado.write("\nModa das Áreas (valor mais frequente): " + String.format("%.2f", moda) + " m²\n");
                writerAvancado.write("\nQuantidade de serviços contratados por cliente (ordenado):\n");
                for (int q : qtdeServicos) {
                    writerAvancado.write("• " + q + " serviço(s)\n");
                }
                writerAvancado.close();

            } catch (IOException e) {
            }
                
            } catch (IOException ignored) {}
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao gravar o arquivo.", "Jardim do Ébano", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Operação encerrada: " + e.getMessage(), "Jardim do Ébano", JOptionPane.WARNING_MESSAGE);
        }
    }
}
