int[][] board = new int[3][3]; // 0 = vazio, 1 = X, 2 = O
boolean playerTurn = true; // true = X, false = O
boolean gameOver = false;
boolean playAgainstAI = false; // Define se o jogo é contra a IA

void setup() {
  size(300, 350);
  resetBoard();
}

void draw() {
  background(255);
  drawBoard();
  drawMenu();
  
  if (checkWin(1)) {
    displayMessage("X venceu!");
    gameOver = true;
  } else if (checkWin(2)) {
    displayMessage("O venceu!");
    gameOver = true;
  } else if (isBoardFull()) {
    displayMessage("Empate!");
    gameOver = true;
  }
  
  if (playAgainstAI && !playerTurn && !gameOver) {
    aiMove();
    playerTurn = true;
  }
}

void drawBoard() {
  stroke(0);
  strokeWeight(4);
  for (int i = 1; i < 3; i++) {
    line(i * 100, 50, i * 100, height);
    line(0, i * 100 + 50, width, i * 100 + 50);
  }
  
  for (int i = 0; i < 3; i++) {
    for (int j = 0; j < 3; j++) {
      if (board[i][j] == 1) {
        drawX(i, j);
      } else if (board[i][j] == 2) {
        drawO(i, j);
      }
    }
  }
}

void drawX(int row, int col) {
  float x = col * 100 + 50;
  float y = row * 100 + 100;
  line(x - 25, y - 25, x + 25, y + 25);
  line(x + 25, y - 25, x - 25, y + 25);
}

void drawO(int row, int col) {
  float x = col * 100 + 50;
  float y = row * 100 + 100;
  ellipse(x, y, 50, 50);
}

void drawMenu() {
  fill(200);
  rect(0, 0, width, 50);
  fill(0);
  textSize(16);
  textAlign(CENTER, CENTER);
  text("Clique para alternar: " + (playAgainstAI ? "Contra IA" : "2 Jogadores"), width / 2, 25);
}

void mousePressed() {
  if (mouseY < 50) {
    playAgainstAI = !playAgainstAI;
    resetBoard();
    return;
  }
  
  if (gameOver) {
    resetBoard();
    gameOver = false;
    return;
  }
  
  int col = mouseX / 100;
  int row = (mouseY - 50) / 100;
  
  if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == 0) {
    board[row][col] = playerTurn ? 1 : 2;
    playerTurn = !playerTurn;
  }
}

void aiMove() {
  int row, col;
  do {
    row = int(random(3));
    col = int(random(3));
  } while (board[row][col] != 0);
  
  board[row][col] = 2;
  playerTurn = true;
}

boolean checkWin(int player) {
  for (int i = 0; i < 3; i++) {
    if (board[i][0] == player && board[i][1] == player && board[i][2] == player) return true;
    if (board[0][i] == player && board[1][i] == player && board[2][i] == player) return true;
  }
  if (board[0][0] == player && board[1][1] == player && board[2][2] == player) return true;
  if (board[0][2] == player && board[1][1] == player && board[2][0] == player) return true;
  return false;
}

boolean isBoardFull() {
  for (int i = 0; i < 3; i++) {
    for (int j = 0; j < 3; j++) {
      if (board[i][j] == 0) {
        return false;
      }
    }
  }
  return true;
}

void displayMessage(String msg) {
  fill(0);
  textSize(32);
  textAlign(CENTER, CENTER);
  text(msg, width / 2, height / 2);
}

void resetBoard() {
  for (int i = 0; i < 3; i++) {
    for (int j = 0; j < 3; j++) {
      board[i][j] = 0;
    }
  }
  playerTurn = true;
}