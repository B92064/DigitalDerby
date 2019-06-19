package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Rival extends GameObject {
	
	static int mph = 10;
	Random random = new Random();
	int random1;
	
	public Rival(int x, int y, int width, int height, int mph) {
		super(x, y, width, height);
		
		this.random1 = this.random.nextInt((10 -5) +1 ) +5;
		// TODO Auto-generated constructor stub
	}
	void update() {
		super.update();
		y+= mph + random1;
		collisionBox.setBounds(x,y,width,height);
	}
	void draw(Graphics g) {
	//	System.out.println("Rival Drawn");
		
	System.out.println(mph + random1);
	g.drawImage(GamePanel.rivalImg,x,y,width,height,null);
	}
}
