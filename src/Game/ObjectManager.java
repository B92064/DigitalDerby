package Game;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;

public class ObjectManager implements ActionListener {
	Racecar R;
	ArrayList<Rival> Ri = new ArrayList<Rival>();
	long enemyTimer = 0;
	long enemySpawnTime = 1000;
	long lineTimer = 0;
	long lineSpawnTime = 200;
	Random random = new Random();
	int random1;
	int twov;
	int rvalue;
	int speed;
	Random Randon = new Random();
	int randon1 = random.nextInt(2);
	int mph1;
	ArrayList<Line> L = new ArrayList<Line>();
	int score = 0;
	int scoreTime;
	public ObjectManager(Racecar R) {
		this.R = R;

	}

	void update() {
		R.update();
		for (int i = 0; i < L.size(); i++) {
			L.get(i).update();

		}
		// randomOne();
		randomTwo();
		manageEnemies();
		manageLine();
		// System.out.println(rvalue);
		for (int i = 0; i < Ri.size(); i++) {
			Ri.get(i).update();
			// Ri.get(i).mph += mph1;
		}

		random1 = random.nextInt(500);
	}

	void draw(Graphics g) {
		
		for (int i = 0; i < Ri.size(); i++) {
			if (Ri.get(i).isAlive == true) {
				Ri.get(i).draw(g);
			}
		}
		for (int i = 0; i < L.size(); i++) {
			if (L.get(i).isAlive == true) {
				L.get(i).draw(g);
			}
		}
		if (R.isAlive == true) {
			R.draw(g);
		}
		/*
		for(int i = 0; i< 999999999; i++) {
			
		}
		*/
	}

	/*
	 * int randomOne() { if(randon1 == 0) { mph1 = 0; } else if(randon1 == 1) { mph1
	 * = 5; } else if(random1 == 2) { mph1 = 10; } return mph1;
	 * 
	 * 
	 * }
	 */
	int randomTwo() {
		if (random1 < 250) {
			twov = 1;
			rvalue = 270;
		} else if (random1 > 250) {
			twov = 2;
			rvalue = 160;
		}
		return rvalue;

		// 61 is the distance between Rivals
	}

	public void manageEnemies() {
		if (System.currentTimeMillis() - enemyTimer >= enemySpawnTime) {
			addRival(new Rival(randomTwo(), 0, 60, 85, 5));

			enemyTimer = System.currentTimeMillis();
		}
	}

	public void manageLine() {
		if (System.currentTimeMillis() - lineTimer >= lineSpawnTime) {
			addLine(new Line(245, 0, 10, 15));

			lineTimer = System.currentTimeMillis();
		}
	}

	void addRival(Rival i) {
		Ri.add(i);
	}

	void addLine(Line i) {
		L.add(i);
	}

	void purgeObjects() {
		for (int i = 0; i < Ri.size(); i++) {
			if (Ri.get(i).isAlive == false) {
				Ri.remove(i);
				System.out.println("Dead");
			}
		}
	}
	void checkCollision() {
		for(Rival r : Ri){

	        if(R.collisionBox.intersects(r.collisionBox)){

	                R.isAlive = false;

	        }

	}
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		GamePanel.score+= GamePanel.addedScore;
		GamePanel.timeLeft -= 1;
	}
}
