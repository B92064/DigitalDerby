package Game;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;

public class ObjectManager {
	Racecar R;
	ArrayList<Rival> Ri = new ArrayList<Rival>();
	long enemyTimer = 0;
	long enemySpawnTime = 4000;
	Random random = new Random();
	int random1;
	int twov;
	int rvalue;
	int speed;
	Random Randon = new Random();
	int randon1 = random.nextInt(2);
	int mph1;
	
	public ObjectManager(Racecar R) {
		this.R = R;
		this.speed = 5;
		
	}

	void update() {
		R.update();
		randomOne();
		randomTwo();
		manageEnemies();
	//	System.out.println(rvalue);
		for (int i = 0; i < Ri.size(); i++) {
			Ri.get(i).update();
			Ri.get(i).mph += mph1;
		}
		random1 = random.nextInt(500);
	}

	void draw(Graphics g) {
		if(R.isAlive == true) {
			R.draw(g);
			}
			for (int i = 0; i < Ri.size(); i++) {
				if(Ri.get(i).isAlive == true) {
				Ri.get(i).draw(g);
				}
			}
	}
	int randomOne() {
		if(randon1 == 0) {
			mph1 = 0;
		} else if(randon1 == 1) {
			mph1 = 5;
		} else if(random1 == 2) {
			mph1 = 10;
		}
		return mph1;
		
		
	}
	int randomTwo() {
		if(random1 < 250) {
			twov = 1;
			rvalue = 275;
		} else if (random1 >250) {
			twov = 2;
			rvalue = 100;
		}
		return rvalue;
		
		
	}
	public void manageEnemies(){
        if(System.currentTimeMillis() - enemyTimer >= enemySpawnTime){
                addRival(new Rival(randomTwo(), 0, 75, 100));

enemyTimer = System.currentTimeMillis();
        }
}
	void addRival(Rival i) {
		Ri.add(i);
	}
	void purgeObjects() {
		for (int i = 0; i < Ri.size(); i++) {
			if (Ri.get(i).isAlive == false) {
				Ri.remove(i);
				System.out.println("Dead");
			}
		}
	}
}