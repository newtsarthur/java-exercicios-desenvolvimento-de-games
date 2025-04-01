# Jogo da Forca

Este é um jogo da forca simples, implementado em Processing. O objetivo do jogo é adivinhar uma palavra secreta antes que o número de tentativas se esgote. O jogador tem até 6 tentativas erradas para descobrir a palavra.

## Funcionalidades

- **Palavras aleatórias**: O jogo escolhe uma palavra aleatória de uma lista predefinida.
- **Desenho do boneco da forca**: O boneco da forca é desenhado conforme o jogador faz tentativas erradas.
- **Adivinhação de letras**: O jogador pode adivinhar letras pressionando as teclas do teclado.
- **Exibição do progresso**: A palavra secreta é exibida com underscores para as letras não adivinhadas. As letras erradas são listadas.
- **Tela de vitória e derrota**: O jogo exibe uma mensagem quando o jogador vence ou perde.

## Como Jogar

1. O jogo começa com uma palavra secreta escolhida aleatoriamente de uma lista.
2. Tente adivinhar as letras da palavra pressionando as teclas no teclado.
3. Cada tentativa errada faz o boneco da forca ser desenhado.
4. Você perde o jogo se fizer 6 tentativas erradas antes de adivinhar a palavra.
5. Você vence o jogo se adivinhar todas as letras da palavra corretamente.

## Controle

- Pressione uma tecla para tentar adivinhar uma letra.
- Se a letra estiver correta, ela será revelada na palavra secreta.
- Se a letra estiver errada, o número de tentativas restantes será reduzido e a letra será registrada como errada.

## Como Rodar

1. Clone ou baixe o repositório.
2. Abra o arquivo `.pde` no Processing.
3. Execute o código e comece a jogar!

## Detalhes do Código

- **Estrutura do jogo**:
  - A lista de palavras está armazenada no array `words`.
  - A palavra secreta é escolhida aleatoriamente no método `chooseWord()`.
  - As tentativas erradas são registradas em um `ArrayList<Character>`.
  - O boneco da forca é desenhado progressivamente no método `drawHangman()` à medida que as tentativas falham.

- **Componentes do jogo**:
  - `drawWord()`: Exibe a palavra com as letras adivinhadas.
  - `drawGuesses()`: Exibe as letras erradas já tentadas.
  - `drawHangman()`: Desenha o boneco da forca conforme as tentativas erradas.
  - `keyPressed()`: Trata a entrada do jogador e atualiza o estado do jogo.