int cols = 4;
int rows = 3;
int totalCards = cols * rows;

// Letras que serão usadas no jogo
char[][] themes = {
  {'A', 'B', 'C', 'D', 'E', 'F'}, // Tema 1
  {'G', 'H', 'I', 'J', 'K', 'L'},  // Tema 2
  {'M', 'N', 'O', 'P', 'Q', 'R'},  // Tema 3
  {'S', 'T', 'U', 'V', 'W', 'X'}   // Tema 4
};

char[] currentTheme;
String[] deck;
boolean[] revealed;
boolean[] matched;
int firstSelection = -1;
int secondSelection = -1;
boolean waiting = false;
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
  
  // Criar pares de cartas
  char[] tempDeck = new char[totalCards];
  for (int i = 0; i < totalCards / 2; i++) {
    tempDeck[i*2] = currentTheme[i % currentTheme.length];
    tempDeck[i*2+1] = currentTheme[i % currentTheme.length];
  }
  
  // Embaralhar
  for (int i = tempDeck.length - 1; i > 0; i--) {
    int j = (int)random(i + 1);
    char temp = tempDeck[i];
    tempDeck[i] = tempDeck[j];
    tempDeck[j] = temp;
  }
  
  // Converter para deck de strings
  for (int i = 0; i < totalCards; i++) {
    deck[i] = str(tempDeck[i]);
  }
  
  // Inicializar arrays
  for (int i = 0; i < totalCards; i++) {
    revealed[i] = false;
    matched[i] = false;
  }
}

void draw() {
  background(70, 130, 180); // Azul médio
  
  // Desenhar cartas
  for (int i = 0; i < rows; i++) {
    for (int j = 0; j < cols; j++) {
      int index = i * cols + j;
      int x = j * cardWidth;
      int y = i * cardHeight;
      
      if (matched[index]) {
        fill(34, 139, 34); // Verde escuro para cartas combinadas
      } else if (revealed[index]) {
        fill(255, 255, 255); // Branco para cartas reveladas
      } else {
        fill(30, 144, 255); // Azul dodger para cartas não reveladas
      }
      
      // Desenhar carta
      rect(x + 10, y + 10, cardWidth - 20, cardHeight - 20, 15);
      
      // Desenhar letra se a carta estiver revelada ou combinada
      if (revealed[index] || matched[index]) {
        textAlign(CENTER, CENTER);
        if (matched[index]) {
          fill(255); // Texto branco para cartas combinadas
        } else {
          fill(0); // Texto preto para cartas reveladas
        }
        textSize(min(cardWidth, cardHeight) * 0.6);
        text(deck[index], x + cardWidth/2, y + cardHeight/2);
      }
    }
  }
  
  // Mostrar informações do jogo
  fill(255);
  textSize(20);
  textAlign(LEFT);
  text("Tentativas: " + attempts, 20, 30);
  text("Pares encontrados: " + pairsFound + "/" + (totalCards/2), 20, 60);
  
  // Mostrar tema atual
  text("Tema: " + themeNames[currentThemeIndex], 20, 90);
  
  // Botão para mudar tema
  drawButton(width - 150, 20, 130, 30, "Mudar Tema", color(100, 200, 255));
  
  // Botão para reiniciar
  drawButton(width - 150, 60, 130, 30, "Reiniciar", color(255, 200, 100));
  
  // Mensagem de vitória
  if (gameWon) {
    drawWinMessage();
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
  
  // Verificar clique nos botões
  if (mouseX > width - 150 && mouseX < width - 20) {
    if (mouseY > 20 && mouseY < 50) { // Botão Mudar Tema
      currentThemeIndex = (currentThemeIndex + 1) % themes.length;
      initGame();
      return;
    } else if (mouseY > 60 && mouseY < 90) { // Botão Reiniciar
      initGame();
      return;
    }
  }
  
  if (waiting) return;
  
  // Verificar clique nas cartas
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
      delay(500);
      checkMatch();
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

void delay(int time) {
  int current = millis();
  while (millis() < current + time) {
    // Espera
  }
}