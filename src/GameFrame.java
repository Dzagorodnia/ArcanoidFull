import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;

public class GameFrame {
	private JFrame frame;
	public GamePanel gamePanel;

	public GameFrame() {
		frame = new JFrame("Arkanoid");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		gamePanel = new GamePanel(300, 500);
		gamePanel.setPreferredSize(new Dimension(300, 500));
		frame.getContentPane().add(gamePanel);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.getContentPane().setBackground(Color.CYAN);

	}

	public void setGameFrame(JFrame frame) {
		this.frame = frame;

	}

	public JFrame getGameFrame() {
		return frame;

	}

	public static void main(String[] args) {
		GameFrame mainFrame = new GameFrame();

		while (true) {
			mainFrame.gamePanel.ball.moveBall();
			mainFrame.gamePanel.plank.movePlank();
			mainFrame.gamePanel.repaint();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

		// long animationTimeStep = 30;
		/*
		 * while(true) { mainFrame.gamePanel.Update(animationTimeStep); try {
		 * Thread.sleep(animationTimeStep); } catch (InterruptedException e) {
		 * e.printStackTrace(); } }
		 */
	}

}