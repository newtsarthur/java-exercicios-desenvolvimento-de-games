String[] words = {"banana", "cidade", "computador", "elefante", "guitarra"};
String word;
char[] guessed;
int attemptsLeft = 6;
ArrayList<Character> wrongGuesses = new ArrayList<>();
boolean gameOver = false;
boolean playerWon = false;

void setup() {
  size(400, 500);
  chooseWord();
}

void draw() {
  background(255);
  drawWord();
  drawHangman();
  drawGuesses();
  
  if (gameOver) {
    textSize(32);
    fill(255, 0, 0);
    textAlign(CENTER, CENTER);
    if (playerWon) {
      text("Você venceu!", width / 2, height - 50);
    } else {
      text("Você perdeu! A palavra era: " + word, width / 2, height - 50);
    }
  }
}

void chooseWord() {
  word = words[int(random(words.length))];
  guessed = new char[word.length()];
  for (int i = 0; i < guessed.length; i++) {
    guessed[i] = '_';
  }
  attemptsLeft = 6;
  wrongGuesses.clear();
  gameOver = false;
  playerWon = false;
}

void drawWord() {
  textSize(32);
  fill(0);
  textAlign(CENTER, CENTER);
  String display = "";
  for (char c : guessed) {
    display += c + " ";
  }
  text(display, width / 2, 400);
}

void drawGuesses() {
  textSize(20);
  fill(0);
  text("Erros: " + wrongGuesses.toString(), 20, 450);
}

void drawHangman() {
  stroke(0);
  strokeWeight(4);
  line(100, 300, 300, 300);
  line(200, 300, 200, 100);
  line(200, 100, 250, 100);
  line(250, 100, 250, 130);
  
  if (attemptsLeft < 6) ellipse(250, 150, 40, 40);
  if (attemptsLeft < 5) line(250, 170, 250, 230);
  if (attemptsLeft < 4) line(250, 180, 230, 210);
  if (attemptsLeft < 3) line(250, 180, 270, 210);
  if (attemptsLeft < 2) line(250, 230, 230, 270);
  if (attemptsLeft < 1) line(250, 230, 270, 270);
}

void keyPressed() {
  if (gameOver) {
    chooseWord();
    return;
  }
  
  char guess = key;
  if (!Character.isLetter(guess)) return;
  guess = Character.toLowerCase(guess);
  
  boolean found = false;
  for (int i = 0; i < word.length(); i++) {
    if (word.charAt(i) == guess) {
      guessed[i] = guess;
      found = true;
    }
  }
  
  if (!found && !wrongGuesses.contains(guess)) {
    wrongGuesses.add(guess);
    attemptsLeft--;
  }
  
  if (attemptsLeft == 0) {
    gameOver = true;
    playerWon = false;
  }
  if (new String(guessed).equals(word)) {
    gameOver = true;
    playerWon = true;
  }
}
