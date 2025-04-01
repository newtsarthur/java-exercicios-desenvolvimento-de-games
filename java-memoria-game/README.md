# Jogo da Memória

Este é um jogo de memória interativo onde o objetivo é encontrar os pares de cartas iguais. O jogo possui múltiplos temas e um sistema de pontuação baseado no número de tentativas feitas.

## Funcionalidades

- **Temas Diversificados**: O jogo oferece 4 temas diferentes de letras, e o jogador pode alternar entre eles durante o jogo.
- **Cartas Aleatórias**: As cartas são embaralhadas a cada reinício de jogo, proporcionando uma experiência única a cada rodada.
- **Pares de Cartas**: O jogador deve encontrar pares de cartas com as mesmas letras.
- **Contagem de Tentativas**: O jogo conta o número de tentativas feitas pelo jogador para encontrar os pares.
- **Feedback Visual**: As cartas reveladas e combinadas são destacadas com cores diferentes.
- **Mensagem de Vitória**: Uma mensagem de vitória aparece quando todos os pares são encontrados.

## Como Jogar

1. As cartas são organizadas em uma grade de 4 colunas e 3 linhas.
2. O jogador deve clicar nas cartas para revelá-las e tentar encontrar pares iguais.
3. Cada carta pode ser clicada uma vez. Quando o jogador revela duas cartas, elas são comparadas.
4. Se as cartas forem iguais, elas ficam reveladas; caso contrário, elas são viradas de volta.
5. O objetivo é encontrar todos os pares de cartas do tema atual.

## Controle

- **Clique nas Cartas**: Clique nas cartas para revelá-las e tentar encontrar um par correspondente.
- **Mudar Tema**: No canto superior direito, há um botão para mudar o tema, que altera as cartas que o jogador deve combinar.
- **Reiniciar Jogo**: O botão "Reiniciar" permite ao jogador começar um novo jogo com o tema atual.

## Como Rodar

1. Clone ou baixe o repositório.
2. Abra o código no Processing e execute o jogo.
3. O jogo será exibido na janela de visualização e você poderá interagir com ele clicando nas cartas.

## Detalhes do Código

- **Estrutura do Jogo**:
  - O jogo usa uma grade de 4 colunas e 3 linhas de cartas. Cada carta possui uma letra que pertence a um dos 4 temas definidos no código.
  - O jogador seleciona cartas, e se encontrar um par, as cartas permanecem visíveis.
  - O código usa a função `mousePressed()` para capturar as seleções do jogador e a função `checkMatch()` para verificar se as cartas selecionadas são iguais.

- **Temas**:
  - O jogo possui 4 temas de letras: "Letras A-F", "Letras G-L", "Letras M-R", e "Letras S-X".
  - O tema pode ser trocado durante o jogo clicando no botão "Mudar Tema" no canto superior direito da tela.

- **Pontuação e Vitoria**:
  - O jogo conta o número de tentativas feitas até o jogador completar todos os pares.
  - Ao completar todos os pares, uma mensagem de vitória é exibida com o número de tentativas feitas.
