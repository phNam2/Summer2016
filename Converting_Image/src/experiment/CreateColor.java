package experiment;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class CreateColor extends JFrame {

	
	public static final long serialVersionUID = 1;
	
	public CreateColor() {
		
		this.setLocation(500, 100);
		this.setTitle("Color");
		this.setSize(416, 439);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		try {
			ColorContent image = new ColorContent();
			this.add(image);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

	public static void main(String[] args) {
		
		CreateColor color = new CreateColor();
		color.setVisible(true);
	}

}


class ColorContent extends JPanel {
	
	BufferedImage image;
	Color c;
	
	public ColorContent() throws IOException {
		
		image = new BufferedImage(400, 400, 5);
		
		//TODO
		c = new Color(240, 255, 255);
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		for (int i=0; i < 400; i++) {
			
			for (int j=0; j < 400; j++) {
				
				image.setRGB(j, i, c.getRGB());
			}
		}
		
		//TODO
		//File output = new File("C:/Users/Nam/Pictures/Saved Pictures/pro/colors/black/black1.jpg");
		//ImageIO.write(image, "jpg", output);
	}
	
	public void paint (Graphics g) {
		
		g.drawImage(image, 1, 1, null);
		
	}
	
	public static final long serialVersionUID = 1;
}