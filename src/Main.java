import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {
		GameFrame mainFrame = new GameFrame();
		mainFrame.addWindowCloseListener(e->{
            System.out.println("You closed window");
		});
		       

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
