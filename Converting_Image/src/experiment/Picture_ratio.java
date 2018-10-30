package experiment;

/**
 * http://stackoverflow.com/questions/11959758/java-maintaining-aspect-ratio-of-jpanel-background-image/11959928#11959928
 */


import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.*;


import javax.imageio.ImageIO;


/**
 * 
 * @author Nam
 *
 */
public class Picture_ratio extends JFrame{

	/**
	 * 
	 */
	public static final long serialVersionUID = 1;

	
	BufferedImage image = null;
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * 
	 */
	public Picture_ratio(String file_location) {
		
		this.setLocation(0, 0);
		this.setTitle("Experiment 1");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//TODO Create image 
		
		try {
			File input = new File(file_location);
			image = ImageIO.read(input);
		 } catch (IOException e) {
	    	 //System.out.println("Error: file not found.");
	    	 //return;
	     }
		
		ImageContent4 image_print = null;
		image_print = new ImageContent4(image);
		this.add(image_print);
			
//		this.setSize(image.width() + 16, image.height() + 39);
		
		this.setSize(image_print.s_width() + 16, image_print.s_height() + 39);
	}
	
	
	
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 *	Second constructor 
	 */
	public Picture_ratio(BufferedImage image2) {
		
//		this.setLocation(0, 0);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//TODO Create image 
		
		
		ImageContent4 image_print = null;
		image_print = new ImageContent4(image2);
		this.add(image_print);
			
//		this.setSize(image.width() + 16, image.height() + 39);
		
		this.setSize(816, 839);

	}
	
	
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public BufferedImage getImage() {
		
		return image;
	}
	
	
	
	
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * 
	 * @param args
	 */
//	public static void main(String[] args) {
//		
//		Picture_ratio testing = new Picture_ratio("sample/swan.jpg");
//		testing.setVisible(true);
//	}
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
 * 
 * @author Nam
 *
 */
class ImageContent4 extends JPanel {
	
	/**
	 * 
	 */
	BufferedImage image;
	int width;
	int height;
	int scale_height;
	int scale_width;
	   
	/**
	 * 
	 * @throws IOException
	 */
	public ImageContent4(BufferedImage image2) {
		
		image = image2;
		
		width = image.getWidth();
		height = image.getHeight();
	   
	}
	
	

	@Override
	public void paint(Graphics g) {


		Image scaled = null;
		int x_cor = 0;
		int y_cor = 0;
		
		if ( this.width() > this.height()) {
			
			scale_width = 800;
			scale_height = (int) Math.round(800*this.height()/this.width());
			
			scaled = image.getScaledInstance(scale_width, scale_height, Image.SCALE_SMOOTH);
			
			y_cor = (int) Math.round(( 800- scale_height)/2);
		}
		else if (this.width() < this.height()) {
			
			scale_height = 800;
			scale_width = (int) Math.round(800*this.width()/this.height());
			
			scaled = image.getScaledInstance(scale_width, scale_height, Image.SCALE_SMOOTH);
			
			x_cor = (int) Math.round(( 800- scale_width)/2);
		}
		else {
			
			scaled = image.getScaledInstance(800, 800, Image.SCALE_SMOOTH);
		}
		
	    g.drawImage(scaled, x_cor, y_cor, this);
//	    g.drawImage(scaled, 0, 0, this);

	}
	
	
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * 
	 * @return
	 */
	public int width() {
	
		return width;
	}
	
	public int height() {
		
		return height;
	}
		
	public int type() {
		
		return image.getType();
		
	}
	
	public int s_width() {
		
		return scale_width;
	}
	
	public int s_height() {
		
		return scale_height;
	}
	
	public static final long serialVersionUID = 1;
}
