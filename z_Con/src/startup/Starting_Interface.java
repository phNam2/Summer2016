package startup;

import javax.swing.JFrame;

import gui.Starting_Frame;


public class Starting_Interface {

	public static void main (String[] args) {
		
		Starting_Frame frame = new Starting_Frame();
		frame.setLocation(600, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
