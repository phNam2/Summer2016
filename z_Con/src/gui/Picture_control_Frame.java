package gui;

import javax.swing.JFrame;

public class Picture_control_Frame extends JFrame {

	public static final int DEFAULT_WIDTH = 400;
	
	public static final int DEFAULT_HEIGHT = 500;
	
	public Picture_control_Frame() {
	
		setTitle("Choose");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		Picture_control_Panel pan = new Picture_control_Panel();
		add(pan);
	}

}
