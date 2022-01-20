import java.util.ArrayList;

ArrayList<Line> lines = new ArrayList<Line>();

void setup() {
  size(1280, 720);
  
  for (int i = 0; i < width / 20; i++) {
    lines.add(new Line(i * 20));
  }
}

void draw() {
  background(0,0,0);

  for (int i = 0; i < lines.size(); i++) {
    lines.get(i).Tick();
  }
  
}
