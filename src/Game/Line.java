package Game;

import java.awt.Color;
import java.awt.Graphics;

public class Line extends GameObject {

	public Line(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}
void update() {
	super.update();
	y += Rival.mph + 5;
}
void draw(Graphics g) {
	g.setColor(Color.WHITE);
	g.fillRect(x, y, width, height);
}
}
