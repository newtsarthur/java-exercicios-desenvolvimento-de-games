# Jogo da Velha (Tic-Tac-Toe)

Este é um jogo da velha simples implementado em Processing. O jogo permite jogar tanto contra outra pessoa quanto contra a inteligência artificial (IA). A interface gráfica é limpa e intuitiva, com opções para alternar entre o modo de 2 jogadores ou jogar contra a IA.

## Funcionalidades

- **Jogar contra a IA**: Você pode jogar contra a IA, que faz movimentos aleatórios. 
- **Modo 2 Jogadores**: Permite que duas pessoas joguem no mesmo computador, alternando entre "X" e "O".
- **Verificação de Vitória**: O jogo detecta automaticamente quando um jogador vence ou se o jogo terminou em empate.
- **Alternância de Modo**: No topo da tela, é possível alternar entre o modo "2 Jogadores" e "Contra IA" clicando na área de texto.
- **Reiniciar Jogo**: Após o término de uma partida, o jogo pode ser reiniciado clicando na tela.

## Como Jogar

1. **Objetivo**: O objetivo do jogo é alinhar três símbolos ("X" ou "O") em uma linha horizontal, vertical ou diagonal antes do seu oponente.
2. **Jogador 1 (X)**: Clique nas células do tabuleiro para colocar seu símbolo "X".
3. **Jogador 2 (O) ou IA (O)**: Se você estiver jogando contra a IA, a IA fará movimentos aleatórios.
4. **Alternar Modos**: Clique na área de texto no topo para alternar entre "2 Jogadores" e "Contra IA".
5. **Reiniciar Jogo**: Se o jogo terminar, clique na tela para reiniciar a partida.

## Controles

- **Modo 2 Jogadores**:
  - Jogador 1: Clica nas células para colocar "X".
  - Jogador 2: Clica nas células para colocar "O".
- **Contra IA**: O jogador humano sempre joga com "X", e a IA joga com "O". A IA faz movimentos aleatórios.
- **Alternar entre Modos**: Clique na área de texto no topo da tela.
- **Reiniciar Jogo**: Clique na tela após o fim de uma partida.

## Como Rodar

1. Clone ou baixe o repositório.
2. Abra o código no ambiente de desenvolvimento Processing.
3. Execute o código e interaja com o jogo.

## Detalhes do Código

- **Tabuleiro**: O jogo é representado por uma matriz 3x3, onde cada célula pode ter um valor de 0 (vazio), 1 (X) ou 2 (O).
- **Movimento da IA**: A IA escolhe uma célula vazia aleatoriamente para jogar "O".
- **Verificação de Vitória**: Após cada movimento, o jogo verifica se algum jogador venceu (3 "X" ou 3 "O" em linha).
- **Empate**: O jogo também detecta se o tabuleiro está cheio e não há vencedor (empate).
