package Game;

import java.awt.Graphics;

public class Racecar extends GameObject {
boolean right;
boolean left;
int speed;
int road = 7;
	public Racecar(int x, int y, int width, int height) {
		super(x, y, width, height);
		this.speed = 5;
		// TODO Auto-generated constructor stub
	}
 void update() {
	 x -= road;
	 x += speed;
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
	 
 }
}
