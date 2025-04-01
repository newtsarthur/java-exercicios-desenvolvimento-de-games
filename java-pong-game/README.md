# Jogo Pong

Este é um jogo clássico de Pong, onde dois jogadores controlam paddles e tentam marcar pontos. O objetivo é evitar que a bola passe pela sua paddle enquanto tenta marcar pontos no adversário. O jogo inclui várias dificuldades e a possibilidade de reiniciar a partida.

## Funcionalidades

- **Modos de Dificuldade**: O jogo oferece três níveis de dificuldade:
  - **Fácil**: Paddle maior e bola mais lenta.
  - **Normal**: Paddle no tamanho médio e bola com velocidade normal.
  - **Difícil**: Paddle menor e bola mais rápida.
  
- **Contagem de Pontos**: Cada jogador tenta marcar pontos ao fazer a bola passar pela paddle do adversário. O jogo termina quando um jogador atinge o número de pontos definido (5 pontos).

- **Reiniciar Jogo**: Após o término de uma partida, o jogador pode reiniciar pressionando a tecla "R".

## Como Jogar

1. **Objetivo**: O objetivo do jogo é marcar pontos evitando que a bola passe pela sua paddle e tentando fazer a bola passar pela paddle do adversário.
2. **Controle do Jogador 1**: Use as teclas `W` (para cima) e `S` (para baixo) para mover a paddle.
3. **Controle do Jogador 2**: Use as teclas de seta `UP` (para cima) e `DOWN` (para baixo) para mover a paddle.
4. **Mudando Dificuldade**:
   - Pressione `1` para escolher o nível fácil.
   - Pressione `2` para escolher o nível normal.
   - Pressione `3` para escolher o nível difícil.
5. **Reiniciar o Jogo**: Pressione `R` para reiniciar a partida.

## Controles

- **Jogador 1**: `W` (mover para cima), `S` (mover para baixo)
- **Jogador 2**: `Setas para Cima` (mover para cima), `Setas para Baixo` (mover para baixo)
- **Dificuldade**:
  - `1` para fácil
  - `2` para normal
  - `3` para difícil
- **Reiniciar o jogo**: Pressione `R` para reiniciar a partida.

## Como Rodar

1. Clone ou baixe o repositório.
2. Abra o código no Processing e execute o jogo.
3. O jogo será exibido na janela de visualização e você poderá interagir com ele usando o teclado.

## Detalhes do Código

- **Lógica de Dificuldade**:
  - A dificuldade afeta o tamanho da paddle e a velocidade da bola.
  - Quando o nível de dificuldade é alterado, a configuração do jogo é reiniciada automaticamente.
  
- **Sistema de Pontuação**:
  - O jogador que fizer a bola passar pela paddle do adversário marca 1 ponto.
  - O jogo termina quando um jogador atinge 5 pontos, e uma mensagem de vencedor é exibida.
  
- **Movimentação das Paddles**:
  - Cada jogador pode mover sua paddle para cima ou para baixo.
  - As teclas de movimento são definidas como `W`/`S` para o jogador 1 e as setas do teclado para o jogador 2.

- **Reinício de Jogo**:
  - O jogo pode ser reiniciado pressionando a tecla "R". Quando o jogo é reiniciado, a pontuação é zerada, e o jogo volta ao estado inicial.