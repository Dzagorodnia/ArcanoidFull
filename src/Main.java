import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {
		Main main = new Main();
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
	}

}
