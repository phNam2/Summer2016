package experiment;

import javax.swing.JPanel;
import java.awt.Graphics;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;

import javax.imageio.ImageIO;





public class Double_Picture extends JPanel {

	/**
	 * 
	 */
	BufferedImage image;
	BufferedImage image2;
	BufferedImage image3;
	int width;
	int height;
	   
	/**
	 * 
	 * @throws IOException
	 */
	public Double_Picture() throws IOException {
		
		try {
			File input = new File("sample/american-eagle2.jpg");
			
			image = ImageIO.read(input);
			width = image.getWidth()*2;
			height = image.getHeight();
	        
			image2 = new BufferedImage(this.width(), this.height(), image.getType());
			
	     } catch (IOException e) {
	    	 System.out.println("Error: file not found.");
	    	 return;
	     }
		
	
		
		//TODO copy the old image
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		for (int i=0; i < height; i++) {
			
			for (int j=0; j < image.getWidth(); j++) {
				
				//System.out.println(image.getRGB(j, i));
				image2.setRGB(j, i, image.getRGB(j, i));
			}
		}
		
		Drawing();
	}
	
	public Double_Picture(BufferedImage sample) throws IOException {
		
		image = sample;
		width = image.getWidth()*2;
		height = image.getHeight();
	        
		//System.out.println(image.getType());;
		image2 = new BufferedImage(this.width(), this.height(), image.getType());
		
		for (int i=0; i < height; i++) {
			
			for (int j=0; j < image.getWidth(); j++) {
				
				//System.out.println(image.getRGB(j, i));
				image2.setRGB(j, i, image.getRGB(j, i));
			}
		}
		
		Drawing();
	}
		
	
	public Double_Picture(BufferedImage sample, BufferedImage sample2) throws IOException {
		
		image = sample;
		image3 = sample2;
		width = image.getWidth()+image3.getWidth();
		height = image.getHeight();
	        
		//System.out.println(image.getType());;
		image2 = new BufferedImage(this.width(), this.height(), image.getType());
		
		for (int i=0; i < height; i++) {
			
			for (int j=0; j < image.getWidth(); j++) {
				
				//System.out.println(image.getRGB(j, i));
				image2.setRGB(j, i, image.getRGB(j, i));
			}
		}
		
		for (int i=0; i < height; i++) {
			
			for (int j=image.getWidth(); j < image.getWidth()*2; j++) {
				
				//System.out.println(image.getRGB(j, i));
				image2.setRGB(j, i, image3.getRGB(j, i));
			}
		}
	}
	
	
	
	public void Drawing() {	
		//TODO convert the picture
		ColorList color = new ColorList("colors");
		//LinkedList<Color> list = color.getList();
		//ListIterator<Color> iteration = list.listIterator();
		
		for (int i=0; i < height; i++) {
			
			for (int j=0; j < image.getWidth(); j++) {
				
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
					
						/////////////////////////////////////////////////////////////////////////////////////TODO
						image2.setRGB(j + image.getWidth(), i,next.getRGB());
						////////////////////////////////TODO
						conti = false;
					}
					
					
				}
			}
		}
		
		//////////////////////TODO
//		File output = new File("V:/project/experiment3(video)/sample3.png");
//		ImageIO.write(image2, "png", output);
		
		repaint();
	}
	  
	/**
	 * 
	 */
	public void paint (Graphics g) {
		
		//g.drawImage(image2, 1, 1, 500, 500, Color.BLACK, null);
		g.drawImage(image2, 0, 0, null);
		//g.drawImage(image, this.width(), 1, null);
		//g.drawImage(image2, 1, 1, 500, 500, null);
		
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
