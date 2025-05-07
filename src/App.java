import javax.swing.JOptionPane;
import java.util.Random;
import java.io.FileWriter;
import java.io.IOException;

public class App {

    public static void main(String[] args) {
        Random random = new Random();
        int[] contagem = new int[6]; // Para contar quantas vezes saiu cada número (1 a 6)
        StringBuilder historico = new StringBuilder(); // Para guardar os resultados e salvar no .txt
        int resposta;

        do {
            int resultado = random.nextInt(6) + 1;
            contagem[resultado - 1]++; // Aumenta a contagem do número sorteado
            historico.append("Resultado: ").append(resultado).append("\n"); // Guarda o resultado

            JOptionPane.showMessageDialog(null, "Você lançou o dado e tirou: " + resultado,
                    "Resultado do Dado", JOptionPane.INFORMATION_MESSAGE);

            resposta = JOptionPane.showConfirmDialog(null, "Deseja lançar o dado novamente?",
                    "Lançar novamente", JOptionPane.YES_NO_OPTION);

        } while (resposta == JOptionPane.YES_OPTION);

        // Mostra estatísticas
        StringBuilder estatisticas = new StringBuilder("Estatísticas dos lançamentos:\n");
        for (int i = 0; i < 6; i++) {
            estatisticas.append("Número ").append(i + 1).append(": ").append(contagem[i]).append(" vezes\n");
        }

        JOptionPane.showMessageDialog(null, estatisticas.toString());

        // Salva no arquivo .txt
        try {
            FileWriter writer = new FileWriter("historico.txt");
            writer.write("Histórico de lançamentos:\n");
            writer.write(historico.toString());
            writer.close();
            FileWriter writer2 = new FileWriter("estatistica.txt");
            writer2.write("\n" + estatisticas.toString());
            writer2.close();
            JOptionPane.showMessageDialog(null, "Os resultados foram salvos em arquivos txt. Até a próxima!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar o arquivo!");
        }
    }
}
