package Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	int frameRate = 20;
	Timer timer = new Timer(1000 / frameRate, this);
	Timer scoreTimer; 
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	final int INSTRUCTION_STATE = 3;
	int currentState = MENU_STATE;
	static int score = 0;
	static int addedScore =1;
	Font titleFont;
	Font pFont;
	Font bFont;
	GameObject O;
	Racecar R;
	ObjectManager OM;
	Rival Ri;
	Line L;
	public static BufferedImage racecarImg;
	public static BufferedImage rivalImg;
	
	public GamePanel() {
		this.timer = timer;
		this.titleFont = new Font("Arial", Font.BOLD, 48);
		this.pFont = new Font("Arial", Font.PLAIN, 15);
		this.bFont = new Font("Arial", Font.BOLD, 15);
		this.O = new GameObject(10, 10, 100, 100);
		this.R = new Racecar(250, 420, 60, 85);
		this.OM = new ObjectManager(R);
		this.Ri = new Rival(100, 0 , 60, 85 , 5);
		this.L = new Line(245, 0 , 10 , 15);
		this.scoreTimer = new Timer(2000,OM);
		try {

            racecarImg = ImageIO.read(this.getClass().getResourceAsStream("racecar.png"));

            rivalImg = ImageIO.read(this.getClass().getResourceAsStream("rival.png"));



    } catch (IOException e) {

            // TODO Auto-generated catch block

            e.printStackTrace();

    }
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("keyTyped");
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("keyPressed");
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (currentState == MENU_STATE) {
				currentState = GAME_STATE;
			} else if (currentState == END_STATE) {
				currentState = MENU_STATE;
				R = new Racecar(250, 420, 60, 85);
				OM = new ObjectManager(R);
				score = 0;
				Rival.mph = 5;
				OM.enemySpawnTime = 1000;
				OM.lineSpawnTime = 200;
				Ri.mph = 10;
				OM.enemySpawnTime = 1000;
				addedScore = 1;
			} else if (currentState == INSTRUCTION_STATE) {
				currentState = MENU_STATE;
			}

		} else if (e.getKeyCode() == KeyEvent.VK_I) {
			if (currentState == MENU_STATE) {
				currentState = INSTRUCTION_STATE;
			}

		} else if (e.getKeyCode() == KeyEvent.VK_A) {
			R.left = true;
		} else if (e.getKeyCode() == KeyEvent.VK_D) {
			R.right = true;
		} else if (e.getKeyCode() == KeyEvent.VK_1) {
			Rival.mph = 5;
			OM.enemySpawnTime = 1000;
			OM.lineSpawnTime = 200;
		} else if (e.getKeyCode() == KeyEvent.VK_2) {
			Rival.mph = 10;
			OM.enemySpawnTime = 700;
			OM.lineSpawnTime = 120;
		} else if (e.getKeyCode() == KeyEvent.VK_3) {
			Rival.mph = 15;
			OM.enemySpawnTime = 400;
			OM.lineSpawnTime = 110;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("keyReleased");
		if (e.getKeyCode() == KeyEvent.VK_A) {
			R.left = false;
		} else if (e.getKeyCode() == KeyEvent.VK_D) {
			R.right = false;
		} else if (e.getKeyCode() == KeyEvent.VK_1) {
		//	Ri.speed = 5;
			Ri.mph = 10;
			OM.enemySpawnTime = 1000;
			addedScore = 1;
		} else if (e.getKeyCode() == KeyEvent.VK_2) {
		//	Ri.speed = 10;
			Ri.mph = 15;
			OM.enemySpawnTime = 650;
			addedScore = 2;
		} else if (e.getKeyCode() == KeyEvent.VK_3) {
		//	Ri.speed = 15;
			Ri.mph = 20;
			OM.enemySpawnTime = 500;
			addedScore = 3;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// System.out.println("Digital Derby Auto Raceway");
		O.update();
		if (currentState == MENU_STATE) {

			updateMenuState();

		} else if (currentState == GAME_STATE) {

			updateGameState();

		} else if (currentState == END_STATE) {

			updateEndState();

		}
		repaint();
	}

	@Override
	public void paintComponent(Graphics g) {
		// O.draw(g);
		if (currentState == MENU_STATE) {

			drawMenuState(g);

		} else if (currentState == GAME_STATE) {

			drawGameState(g);

		} else if (currentState == END_STATE) {

			drawEndState(g);

		} else if (currentState == INSTRUCTION_STATE) {

			drawInstructionState(g);

		}
	}

	void startGame() {
		timer.start();
		scoreTimer.start();
	}

	void updateMenuState() {

	}

	void updateGameState() {
		OM.update();
		if(R.isAlive == false) {
			currentState = END_STATE;
		}
	}

	void updateEndState() {

	}

	void updateInstructionState() {

	}

	void drawMenuState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, DigitalDerby.WIDTH, DigitalDerby.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("Digital Derby", 110, 115);
		g.setFont(bFont);
		g.drawString("Press Enter to start", 180, 500);
		g.drawString("Press I for instructions", 170, 550);
	}

	void drawGameState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, DigitalDerby.WIDTH, DigitalDerby.HEIGHT);
		g.setColor(Color.yellow);
		g.drawString("The score is " + score, 10, 20);
		OM.draw(g);
		OM.checkCollision();
		OM.purgeObjects();
		
	}

	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, DigitalDerby.WIDTH, DigitalDerby.HEIGHT);
		g.setColor(Color.BLACK);
		g.setFont(titleFont);
		g.drawString("YOU DIED", 140, 200);
		g.setFont(pFont);
		g.drawString("Press Enter to Restart", 170, 330);
	}

	void drawInstructionState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, DigitalDerby.WIDTH, DigitalDerby.HEIGHT);
		g.setColor(Color.YELLOW);
		g.setFont(pFont);
		g.drawString("Press 1, 2, and 3 to control speed.", 120, 200);
		g.drawString("Press A and D to go left and right.", 120, 220);
		g.drawString("Press Enter to go back to menu.", 120, 600);
		g.drawString("To get more points go at higher speeds.", 110, 240);
		g.drawString("Try to get the highest amount of points before the time runs out!", 40, 260);
	}
}
