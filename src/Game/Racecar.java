package Game;

import java.awt.Color;
import java.awt.Graphics;

public class Racecar extends GameObject {

boolean right;
boolean left;

int road = 8;
	public Racecar(int x, int y, int width, int height) {
		super(x, y, width, height);
		
		
		// TODO Auto-generated constructor stub
	}
 void update() {
	 
	  if(left == true) {
			x -= 10;
			if(x < 0) {
				x = 0;
			}
		}
		else if(right == true) {
			x += 10;
			if(x > 450) {
				x = 450;
			}
		}
 }
// to make road work make the race car have negative y constantly. Set boundaries to prevent it going off screen
 void draw(Graphics g){
	 g.setColor(Color.BLUE);
	 g.fillRect(x, y, width, height);
 }
}
