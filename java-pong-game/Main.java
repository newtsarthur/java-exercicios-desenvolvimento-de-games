int paddleWidth = 10, paddleHeight = 80;
int ballSize = 15;
int player1Y, player2Y;
int ballX, ballY, ballSpeedX, ballSpeedY;
int player1Score = 0, player2Score = 0;
int scoreLimit = 5;
boolean gameOver = false;
boolean upPressed, downPressed, wPressed, sPressed;
String difficulty = "normal";

int paddleSpeed = 6;
int delayAfterWin = 180; // frames ~3 segundos
int delayCounter = 0;

void setup() {
  size(600, 400);
  setDifficulty(difficulty);
  resetGame();
}

void draw() {
  background(0);

  if (gameOver) {
    showWinner();
    delayCounter++;
    if (delayCounter >= delayAfterWin) {
      player1Score = 0;
      player2Score = 0;
      gameOver = false;
      delayCounter = 0;
      resetGame();
    }
    return;
  }

  drawPaddles();
  drawBall();
  drawScore();
  moveBall();
  checkCollision();
  movePaddles();
}

void setDifficulty(String level) {
  if (level.equals("easy")) {
    paddleHeight = 100;
    ballSpeedX = 3;
    ballSpeedY = 3;
  } else if (level.equals("hard")) {
    paddleHeight = 60;
    ballSpeedX = 6;
    ballSpeedY = 6;
  } else {
    paddleHeight = 80;
    ballSpeedX = 4;
    ballSpeedY = 4;
  }
}

void resetGame() {
  player1Y = height / 2 - paddleHeight / 2;
  player2Y = height / 2 - paddleHeight / 2;
  ballX = width / 2;
  ballY = height / 2;
  ballSpeedX *= random(1) < 0.5 ? 1 : -1; // bola vai pra lado aleatório
}

void drawPaddles() {
  fill(255);
  rect(20, player1Y, paddleWidth, paddleHeight);
  rect(width - 30, player2Y, paddleWidth, paddleHeight);
}

void drawBall() {
  ellipse(ballX, ballY, ballSize, ballSize);
}

void drawScore() {
  textSize(20);
  fill(255);
  text(player1Score, width / 4, 30);
  text(player2Score, 3 * width / 4, 30);
}

void moveBall() {
  ballX += ballSpeedX;
  ballY += ballSpeedY;

  if (ballY <= 0 || ballY >= height) {
    ballSpeedY *= -1;
  }

  if (ballX <= 0) {
    player2Score++;
    checkWinner();
    if (!gameOver) resetGame();
  } else if (ballX >= width) {
    player1Score++;
    checkWinner();
    if (!gameOver) resetGame();
  }
}

void checkCollision() {
  // Jogador 1
  if (ballX <= 30 && ballY >= player1Y && ballY <= player1Y + paddleHeight) {
    ballSpeedX *= -1;
    // opcional: add som aqui
  }
  // Jogador 2
  if (ballX >= width - 30 && ballY >= player2Y && ballY <= player2Y + paddleHeight) {
    ballSpeedX *= -1;
  }
}

void checkWinner() {
  if (player1Score >= scoreLimit || player2Score >= scoreLimit) {
    gameOver = true;
  }
}

void showWinner() {
  textSize(32);
  fill(255, 0, 0);
  textAlign(CENTER, CENTER);
  if (player1Score >= scoreLimit) {
    text("Jogador 1 venceu!", width / 2, height / 2);
  } else {
    text("Jogador 2 venceu!", width / 2, height / 2);
  }
  textSize(16);
  fill(255);
  text("Reiniciando em 3 segundos...", width / 2, height / 2 + 40);
  text("1: Fácil   2: Normal   3: Difícil", width / 2, height / 2 + 70);
}

void movePaddles() {
  if (wPressed && player1Y > 0) player1Y -= paddleSpeed;
  if (sPressed && player1Y + paddleHeight < height) player1Y += paddleSpeed;
  if (upPressed && player2Y > 0) player2Y -= paddleSpeed;
  if (downPressed && player2Y + paddleHeight < height) player2Y += paddleSpeed;
}

void keyPressed() {
  if (key == '1') {
    difficulty = "easy";
    setDifficulty(difficulty);
    resetGame();
  }
  if (key == '2') {
    difficulty = "normal";
    setDifficulty(difficulty);
    resetGame();
  }
  if (key == '3') {
    difficulty = "hard";
    setDifficulty(difficulty);
    resetGame();
  }
  if (key == 'r' || key == 'R') {
    player1Score = 0;
    player2Score = 0;
    resetGame();
    gameOver = false;
    delayCounter = 0;
  }
  if (key == 'w') wPressed = true;
  if (key == 's') sPressed = true;
  if (keyCode == UP) upPressed = true;
  if (keyCode == DOWN) downPressed = true;
}

void keyReleased() {
  if (key == 'w') wPressed = false;
  if (key == 's') sPressed = false;
  if (keyCode == UP) upPressed = false;
  if (keyCode == DOWN) downPressed = false;
}
