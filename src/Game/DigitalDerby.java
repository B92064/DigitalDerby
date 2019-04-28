package Game;

import java.awt.Dimension;

import javax.swing.JFrame;

public class DigitalDerby {
	final static int HEIGHT = 700;
	final static int WIDTH = 500;
	JFrame gameFrame;
	GamePanel P;

	public DigitalDerby() {
		// Based off Digital Derby Auto Raceway
		this.gameFrame = new JFrame();
		this.P = new GamePanel();
		gameFrame.setPreferredSize(new Dimension(WIDTH, HEIGHT));
	}

	public static void main(String[] args) {
		DigitalDerby DD = new DigitalDerby();
		DD.setup();
	}

	void setup() {
		gameFrame.add(P);
		gameFrame.addKeyListener(P);
		gameFrame.setVisible(true);
		gameFrame.setSize(WIDTH, HEIGHT);
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.getContentPane().setPreferredSize(new Dimension(WIDTH, HEIGHT));
		gameFrame.pack();
		P.startGame();
	}
}
