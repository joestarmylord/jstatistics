# 🎲 Simulador de Dado – Duas Perspectivas

## 👨‍💻 Visão do Programador

Ao abrir o código, um programador enxerga:

* **Uso de bibliotecas Java padrão:**

  * `javax.swing.JOptionPane` para janelas gráficas.
  * `java.util.Random` para geração de números aleatórios.
  * `java.io.FileWriter` para salvar dados em arquivos.

* **Lógica estruturada:**

  * Um laço `do-while` controlado pela interação do usuário.
  * Armazenamento eficiente de dados com `int[]` (contagem) e `StringBuilder` (histórico e estatísticas).
  * Dois arquivos `.txt` gerados separadamente ao final do programa.

* **Código limpo e simples:**

  * Variáveis nomeadas de forma descritiva (`resultado`, `contagem`, `historico`).
  * Separação lógica entre entrada de dados, processamento e saída.

* **Possíveis ideias de melhoria:**

  * Refatorar para salvar tudo em um único arquivo.
  * Criar uma GUI completa com `JFrame` em vez de só `JOptionPane`.
  * Adicionar gráficos ou visualizações com barras.

---

## 🎮 Visão do Jogador

Ao executar o jogo, o jogador vê:

* Uma **janelinha simpática** que diz qual número saiu no dado.
* Um botão perguntando: "Deseja lançar o dado novamente?".
* Ao encerrar, vê um **resumo com quantas vezes saiu cada número**.
* Uma mensagem final dizendo que os dados foram **salvos em arquivos `.txt`**.

> O jogador não vê o código, só se diverte clicando e vendo os resultados!

---

## 🧠 Conclusão

| Elemento                | Programador vê                              | Jogador vê                                   |
| ----------------------- | ------------------------------------------- | -------------------------------------------- |
| `Random` e arrays       | Algoritmo de sorteio e contagem             | Um dado sendo lançado                        |
| `JOptionPane.show...`   | Funções de interface gráfica                | Janelas amigáveis com perguntas e resultados |
| `FileWriter`            | Escrita em disco de forma estruturada       | Mensagem: "dados salvos em arquivos .txt"    |
| Laços e controle lógico | Estrutura de repetição e condição de parada | Opção de continuar jogando ou parar          |

Esse projeto é um ótimo exemplo de como **a mesma aplicação pode ser simples e divertida para o usuário**, e ao mesmo tempo **organizada e didática para o desenvolvedor**.

---
