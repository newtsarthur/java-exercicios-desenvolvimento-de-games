int[][] board = new int[3][3];
boolean playerTurn = true;

void setup() {
  size(300, 300);
  resetBoard();
}

void draw() {
  background(255);
  drawBoard();
}

void drawBoard() {
  stroke(0);
  strokeWeight(4);
  for (int i = 1; i < 3; i++) {
    line(i * 100, 0, i * 100, height);
    line(0, i * 100, width, i * 100);
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
  float y = row * 100 + 50;
  line(x - 25, y - 25, x + 25, y + 25);
  line(x + 25, y - 25, x - 25, y + 25);
}

void drawO(int row, int col) {
  float x = col * 100 + 50;
  float y = row * 100 + 50;
  ellipse(x, y, 50, 50);
}

void mousePressed() {
  int col = mouseX / 100;
  int row = mouseY / 100;
  
  if (board[row][col] == 0) {
    board[row][col] = playerTurn ? 1 : 2;
    playerTurn = !playerTurn;
  }
}

void resetBoard() {
  for (int i = 0; i < 3; i++) {
    for (int j = 0; j < 3; j++) {
      board[i][j] = 0;
    }
  }
}