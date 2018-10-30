package experiment;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;

import javax.imageio.ImageIO;


/**
 * 
 * @author Nam
 *
 */
public class Control_Convert extends JFrame{

	/**
	 * 
	 */
	public static final long serialVersionUID = 1;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * 
	 */
	public Control_Convert() {
		
		this.setLocation(10, 10);
		this.setTitle("Experiment 1");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		////////TODO
		ImageContent image = null;
		//Double_Picture image = null;
		//Pencil_Sketch image = null;
		try {
			image = new ImageContent(true);
			//image = new Double_Picture();
			//image = new Pencil_Sketch();
			
			
			this.add(image);
			
		} catch (IOException e) {

			e.printStackTrace();
		}
		this.setSize(image.width() + 16, image.height() + 39);
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
//		Control_Convert testing = new Control_Convert();
//		testing.setVisible(true);
	}
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
 * 
 * @author Nam
 *
 */
class ImageContent extends JPanel {
	
	/**
	 * 
	 */
	BufferedImage image;
	BufferedImage image2;
	int width;
	int height;
	   
	/**
	 * 
	 * @throws IOException
	 */
	public ImageContent(boolean createFile) throws IOException {
		
		try {
			File input = new File("sample/swan.jpg");
			
			image = ImageIO.read(input);
			width = image.getWidth();
			height = image.getHeight();
	        
			image2 = new BufferedImage(this.width(), this.height(), image.getType());
			
	     } catch (IOException e) {
	    	 System.out.println("Error: file not found.");
	    	 return;
	     }
		
		Drawing(createFile);
	}
		
	
	public ImageContent(boolean createFile, BufferedImage sample) throws IOException {
			
			image = sample;
			width = image.getWidth();
			height = image.getHeight();
		        
			//System.out.println(image.getType());;
			image2 = new BufferedImage(this.width(), this.height(), image.getType());
			
			
			Drawing(createFile);
	}
		
	
	public void Drawing(boolean createFile) {	
		//TODO convert the picture
		ColorList color = new ColorList("colors3");
		//LinkedList<Color> list = color.getList();
		//ListIterator<Color> iteration = list.listIterator();
		
		for (int i=0; i < height; i++) {
			
			for (int j=0; j < width; j++) {
				
				//image2.setRGB(j, i, image.getRGB(j, i));
				Color c = new Color(image.getRGB(j, i));
			
			
				LinkedList<Color> list = color.getList();
				ListIterator<Color> iteration = list.listIterator();
				boolean conti = true;
				
				while (iteration.hasNext() && conti) {
					
					Color next = iteration.next(); 
					if ( c.getRed() == next.getRed() && c.getGreen() == next.getGreen() && c.getBlue() == next.getBlue() ){
					
						image2.setRGB(j, i,next.getRGB());
						////////////////////////////////TODO
						conti = false;
					}	
				}
				
				iteration = list.listIterator();
				while (iteration.hasNext() && conti) {
				
					Color next = iteration.next(); 
					if ( (next.getRed() - 50 <= c.getRed() && c.getRed() <= next.getRed() + 50) && 
						 (next.getGreen() - 50 <= c.getGreen() && c.getGreen() <= next.getGreen() + 50) &&
						 (next.getBlue() - 50 <= c.getBlue() && c.getBlue() <= next.getBlue() + 50)) {
					
						image2.setRGB(j, i,next.getRGB());
						////////////////////////////////TODO
						conti = false;
					}	
				}
			}
		}
		
		//////////////////////TODO
		if (createFile) {
			
//			File output = new File("C:/individual/subject/project/product6/sample2.png");
//			ImageIO.write(image2, "png", output);
		}
		
		
		//repaint();
	}
	
	/**
	 * 
	 */
	public void paint (Graphics g) {
		
		//g.drawImage(image2, 0, 0, 500, 500, Color.BLACK, null);
		g.drawImage(image2, 0, 0, null);
		//g.drawImage(image, this.width(), 0, null);
		//g.drawImage(image2, 0, 0, 500, 500, null);
		
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
	
	public BufferedImage getImage() {
		
		return image2;
	}
	
	public static final long serialVersionUID = 1;
}
