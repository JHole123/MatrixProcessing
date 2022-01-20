import java.util.ArrayList;
import java.lang.Math;

class Line {
  
  ArrayList<Letter> Content = new ArrayList<Letter>();
  int x, y;
  int creationTick = 0;
  boolean isWhite = false;
  int whiteIndex;
  int whiteIndexMin;
  int tickThreshold;
  
  public Line(int x) {
    this.x = x;
    this.y = (int)random(1,70) * -20;
    this.tickThreshold = (int)random(10, 31);
  }
  
  private void Regenerate() {
    this.y = (int)random(1,40) * -20;
  }
  
  public void Tick() {
    creationTick++;
    if (creationTick == this.tickThreshold) {
      Content.add(new Letter(this.x, this.y));
      creationTick = 0;
      this.y += 20;
      if (isWhite) whiteUpdate();
    }
    if (this.y > height) {
      this.Regenerate();
    }
    if (this.y > height / 2 && (int)random(0, 500) > 497 && !this.isWhite) whiteSetup();
    for (int i = 0; i < Content.size(); i++) {
      Content.get(i).Tick();
      if (Content.get(i).ticksSinceCreation == 600) Content.remove(i);
    }
       
  }
  
  public void whiteSetup() {
    this.isWhite = true;
    this.whiteIndex = Content.size() - 1;
    this.whiteIndexMin = this.whiteIndex - floor(600 / this.tickThreshold);
    Content.get(this.whiteIndex).whiteness = 255;
  }
  
  public void whiteUpdate() {
    
    /*Content.get(this.whiteIndex).whiteness = 0;
    this.whiteIndex -= 2;
    if (this.whiteIndex <= this.whiteIndexMin) this.isWhite = false;
    else {
      Content.get(this.whiteIndex).whiteness = 255;
    }*/
    
    try {
      Content.get(this.whiteIndex).whiteness = 0;
      this.whiteIndex -= 2;
      Content.get(this.whiteIndex).whiteness = 255;
    }
    catch (IndexOutOfBoundsException e) {
      this.isWhite = false;
    }
      
  }
  
  
  
}
