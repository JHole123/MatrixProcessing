

class Letter {
    
  // Properties
  int x, y;
  int size = 20;
  color colour;
  int ticksSinceCreation = 0;
  int opacity = 255;
  int whiteness = 0;
  int tickThreshold;
  String currentLetter = "A";
  
  // Constructor
  Letter(int x, int y) {
    this.x = x;
    this.y = y;
    this.colour = color(this.whiteness, 255, this.whiteness, 255);
    this.tickThreshold = (int)random(5, 30);
  }
  
  void Display() {
    this.opacity = (int)map(this.ticksSinceCreation, 0, 600, 255, 0);
    this.colour = color(this.whiteness, 255, this.whiteness, this.opacity);
    fill(this.colour);
    noStroke();
    textSize(this.size);
    if (this.ticksSinceCreation % tickThreshold == 0) generateLetter();
    text(this.currentLetter, this.x, this.y);
  }
  
  void Tick() {
    this.Display();
    ticksSinceCreation++;
  }
  
  private void generateLetter() {
    int start = unhex("0020"); // 30A0 30FF
    int end = unhex("007E");
    int unicode = floor(random(start, end));
    this.currentLetter = Character.toString((char)unicode);
  }
  
  
}
