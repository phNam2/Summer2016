package gui;

import javax.swing.JFrame;


public class Starting_Frame extends JFrame {

	public static final int DEFAULT_WIDTH = 400;
	
	public static final int DEFAULT_HEIGHT = 500;
	
	
	public Starting_Frame() {
		
		setTitle("Choose a format");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		Starting_Panel pan = new Starting_Panel();
		add(pan);
		
	}

	public static final long serialVersionUID = 1;
}
