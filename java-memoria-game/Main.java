int cols = 4;
int rows = 3;
int totalCards = cols * rows;

char[][] themes = {
  {'A', 'B', 'C', 'D', 'E', 'F'},
  {'G', 'H', 'I', 'J', 'K', 'L'},
  {'M', 'N', 'O', 'P', 'Q', 'R'},
  {'S', 'T', 'U', 'V', 'W', 'X'}
};

char[] currentTheme;
String[] deck;
boolean[] revealed;
boolean[] matched;
int firstSelection = -1;
int secondSelection = -1;
boolean waiting = false;
int revealStartTime = 0; // Novo timer
int cardWidth, cardHeight;
int pairsFound = 0;
int attempts = 0;
PFont font;
boolean gameWon = false;
int currentThemeIndex = 0;
String[] themeNames = {"Letras A-F", "Letras G-L", "Letras M-R", "Letras S-X"};

void setup() {
  size(800, 600);
  cardWidth = width / cols;
  cardHeight = height / rows;
  font = createFont("Arial Bold", 48);
  textFont(font);
  
  initGame();
}

void initGame() {
  deck = new String[totalCards];
  revealed = new boolean[totalCards];
  matched = new boolean[totalCards];
  firstSelection = -1;
  secondSelection = -1;
  waiting = false;
  pairsFound = 0;
  attempts = 0;
  gameWon = false;
  
  currentTheme = themes[currentThemeIndex];
  
  char[] tempDeck = new char[totalCards];
  for (int i = 0; i < totalCards / 2; i++) {
    tempDeck[i*2] = currentTheme[i % currentTheme.length];
    tempDeck[i*2+1] = currentTheme[i % currentTheme.length];
  }
  
  for (int i = tempDeck.length - 1; i > 0; i--) {
    int j = (int)random(i + 1);
    char temp = tempDeck[i];
    tempDeck[i] = tempDeck[j];
    tempDeck[j] = temp;
  }
  
  for (int i = 0; i < totalCards; i++) {
    deck[i] = str(tempDeck[i]);
    revealed[i] = false;
    matched[i] = false;
  }
}

void draw() {
  background(70, 130, 180);

  for (int i = 0; i < rows; i++) {
    for (int j = 0; j < cols; j++) {
      int index = i * cols + j;
      int x = j * cardWidth;
      int y = i * cardHeight;
      
      if (matched[index]) {
        fill(34, 139, 34);
      } else if (revealed[index]) {
        fill(255);
      } else {
        fill(30, 144, 255);
      }
      
      rect(x + 10, y + 10, cardWidth - 20, cardHeight - 20, 15);
      
      if (revealed[index] || matched[index]) {
        textAlign(CENTER, CENTER);
        fill(matched[index] ? 255 : 0);
        textSize(min(cardWidth, cardHeight) * 0.6);
        text(deck[index], x + cardWidth/2, y + cardHeight/2);
      }
    }
  }
  
  fill(255);
  textSize(20);
  textAlign(LEFT);
  text("Tentativas: " + attempts, 20, 30);
  text("Pares encontrados: " + pairsFound + "/" + (totalCards/2), 20, 60);
  text("Tema: " + themeNames[currentThemeIndex], 20, 90);
  
  drawButton(width - 150, 20, 130, 30, "Mudar Tema", color(100, 200, 255));
  drawButton(width - 150, 60, 130, 30, "Reiniciar", color(255, 200, 100));
  
  if (gameWon) {
    drawWinMessage();
  }

  // Espera para mostrar as duas cartas antes de verificar
  if (waiting && millis() - revealStartTime > 800) {
    checkMatch();
  }
}

void drawButton(float x, float y, float w, float h, String label, color btnColor) {
  fill(btnColor);
  rect(x, y, w, h, 5);
  fill(0);
  textSize(16);
  textAlign(CENTER, CENTER);
  text(label, x + w/2, y + h/2);
}

void drawWinMessage() {
  fill(0, 0, 0, 200);
  rect(width/2 - 150, height/2 - 80, 300, 160, 20);
  fill(255);
  textSize(28);
  textAlign(CENTER, CENTER);
  text("Parabéns!", width/2, height/2 - 40);
  textSize(20);
  text("Você completou o jogo!", width/2, height/2);
  text("Tentativas: " + attempts, width/2, height/2 + 40);
}

void mousePressed() {
  if (gameWon) {
    initGame();
    return;
  }
  
  if (mouseX > width - 150 && mouseX < width - 20) {
    if (mouseY > 20 && mouseY < 50) {
      currentThemeIndex = (currentThemeIndex + 1) % themes.length;
      initGame();
      return;
    } else if (mouseY > 60 && mouseY < 90) {
      initGame();
      return;
    }
  }

  if (waiting) return;

  int col = mouseX / cardWidth;
  int row = mouseY / cardHeight;
  
  if (col >= cols || row >= rows) return;
  
  int index = row * cols + col;
  
  if (!revealed[index] && !matched[index]) {
    revealed[index] = true;
    
    if (firstSelection == -1) {
      firstSelection = index;
    } else if (secondSelection == -1 && index != firstSelection) {
      secondSelection = index;
      attempts++;
      waiting = true;
      revealStartTime = millis(); // Marca o tempo de revelação
    }
  }
}

void checkMatch() {
  if (deck[firstSelection].equals(deck[secondSelection])) {
    matched[firstSelection] = true;
    matched[secondSelection] = true;
    pairsFound++;
    if (pairsFound == totalCards / 2) {
      gameWon = true;
    }
  } else {
    revealed[firstSelection] = false;
    revealed[secondSelection] = false;
  }
  
  firstSelection = -1;
  secondSelection = -1;
  waiting = false;
}
