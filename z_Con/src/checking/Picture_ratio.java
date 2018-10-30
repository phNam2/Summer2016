package checking;

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
		
		this.setLocation(100, 100);
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
		
		ImageContent2 image_print = null;
		image_print = new ImageContent2(image);
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
	public static void main(String[] args) {
		
		Picture_ratio testing = new Picture_ratio("C:/individual/subject/project/project2/Converting_Image/sample/swan.jpg");
		testing.setVisible(true);
	}
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
 * 
 * @author Nam
 *
 */
class ImageContent2 extends JPanel {
	
	/**
	 * 
	 */
	BufferedImage image;
	int width;
	int height;
	   
	/**
	 * 
	 * @throws IOException
	 */
	public ImageContent2(BufferedImage image2) {
		
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
			
			int scale_width = 800;
			int scale_height = (int) Math.round(800*this.height()/this.width());
			
			scaled = image.getScaledInstance(scale_width, scale_height, Image.SCALE_SMOOTH);
			
			y_cor = (int) Math.round(( 800- scale_height)/2);
		}
		else if (this.width() < this.height()) {
			
			int scale_height = 800;
			int scale_width = (int) Math.round(800*this.width()/this.height());
			
			scaled = image.getScaledInstance(scale_width, scale_height, Image.SCALE_SMOOTH);
			
			x_cor = (int) Math.round(( 800- scale_width)/2);
		}
		else {
			
			scaled = image.getScaledInstance(800, 800, Image.SCALE_SMOOTH);
		}
		
	    g.drawImage(scaled, x_cor, y_cor, this);

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
	
	public static final long serialVersionUID = 1;
}
