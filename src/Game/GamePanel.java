package Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	int frameRate = 20;
	Timer timer = new Timer(1000 / frameRate, this);
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	final int INSTRUCTION_STATE = 3;
	int currentState = MENU_STATE;
	Font titleFont;
	Font pFont;
	Font bFont;
	GameObject O;
	Racecar R;
	ObjectManager OM;
	Rival Ri;
	
	public GamePanel() {
		this.timer = timer;
		this.titleFont = new Font("Arial", Font.BOLD, 48);
		this.pFont = new Font("Arial", Font.PLAIN, 15);
		this.bFont = new Font("Arial", Font.BOLD, 15);
		this.O = new GameObject(10, 10, 100, 100);
		this.R = new Racecar(250, 550, 75, 100);
		this.OM = new ObjectManager(R);
		this.Ri = new Rival(100, 0 , 75, 100);
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
		//	Ri.speed = 5;
		} else if (e.getKeyCode() == KeyEvent.VK_2) {
		//	Ri.speed = 10;
		} else if (e.getKeyCode() == KeyEvent.VK_3) {
		//	Ri.speed = 15;
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
		} else if (e.getKeyCode() == KeyEvent.VK_2) {
		//	Ri.speed = 10;
		} else if (e.getKeyCode() == KeyEvent.VK_3) {
		//	Ri.speed = 15;
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

	}

	void updateMenuState() {

	}

	void updateGameState() {
		OM.update();
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
		O.draw(g);
		OM.draw(g);
	}

	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, DigitalDerby.WIDTH, DigitalDerby.HEIGHT);
	}

	void drawInstructionState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, DigitalDerby.WIDTH, DigitalDerby.HEIGHT);
		g.setColor(Color.YELLOW);
		g.setFont(pFont);
		g.drawString("Press 1, 2, and 3 to control speed.", 120, 200);
		g.drawString("Turn the steering wheel to go left and right.", 110, 220);
	}
}
