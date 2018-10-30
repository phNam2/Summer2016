package gui;

import javax.swing.JFrame;

public class Upload_pic_Frame extends JFrame {

	

	public static final int DEFAULT_WIDTH = 700;
	
	public static final int DEFAULT_HEIGHT = 200;
	
	
	public Upload_pic_Frame() {
		
		setTitle("Choose a format");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		Upload_pic_Panel pan = new Upload_pic_Panel();
		add(pan);
	}

	
	private static final long serialVersionUID = 1;
}
