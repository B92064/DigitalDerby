package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Rival extends GameObject {
	
	int mph;
	public Rival(int x, int y, int width, int height) {
		super(x, y, width, height);
		this.mph = 5;
		// TODO Auto-generated constructor stub
	}
	void update() {
		y+= mph;
	}
	void draw(Graphics g) {
		System.out.println("Rival Drawn");
		g.setColor(Color.YELLOW);
		g.fillRect(x, y, width, height);
	}
}
