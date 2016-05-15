import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameField {
	private JFrame gameFrame;
	public JPanel gamePanel;
	
	protected GameField () {
		
	}
	private void frameCreation (){
		gameFrame = new JFrame("Arkanoid");
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.setResizable(false);
		gameFrame.pack();
		gameFrame.setLocationRelativeTo(null);
		gameFrame.setVisible(true);
		gameFrame.getContentPane().setBackground(Color.CYAN);
		
	}
	

}
