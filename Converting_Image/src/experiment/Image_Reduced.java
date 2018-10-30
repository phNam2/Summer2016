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
public class Image_Reduced extends JFrame{

	/**
	 * 
	 */
	public static final long serialVersionUID = 1;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * 
	 */
	public Image_Reduced() {
		
		this.setLocation(10, 10);
		this.setTitle("Experiment 1");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//TODO Create image
		ImageContent3 image = null;
		
		try {
			image = new ImageContent3(true);
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
		
		Image_Reduced testing = new Image_Reduced();
		testing.setVisible(true);
	}
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
 * 
 * @author Nam
 *
 */
class ImageContent3 extends JPanel {
	
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
	public ImageContent3(boolean createFile) throws IOException {
		
		try {
			File input = new File("sample/Swan.jpg");
			
			image = ImageIO.read(input);
			width = image.getWidth();
			height = image.getHeight();
	        
			image2 = new BufferedImage(this.width(), this.height(), image.getType());
			
	     } catch (IOException e) {
	    	 System.out.println("Error: file not found.");
	    	 return;
	     }
	}
	
	public ImageContent3(boolean createFile, BufferedImage sample) throws IOException {
		
		image = sample;
		width = image.getWidth();
		height = image.getHeight();
	        
		//System.out.println(image.getType());;
		image2 = new BufferedImage(this.width(), this.height(), image.getType());
		
		
		Drawing(createFile);
}
	

	public void Drawing(boolean createFile) {
		
		//TODO convert the picture
		ColorList_Reduced color = new ColorList_Reduced("colors3");
		LinkedList<Modified_Color_class> list = color.getList();
		
		for (int i=0; i < height; i++) {
			
			for (int j=0; j < width; j++) {
				
				Color c = new Color(image.getRGB(j, i));
				boolean isChange = false;
				
				String bestName = "";
				ListIterator<Modified_Color_class> iteration = list.listIterator();
				
				while (iteration.hasNext() && !isChange) {
					
					Modified_Color_class next = iteration.next(); 
					if ( c.getRed() == next.getRed() && c.getGreen() == next.getGreen() && c.getBlue() == next.getBlue() ){
					
						image2.setRGB(j, i,next.getRGB());
						bestName = next.getName();
						////////////////////////////////TODO
						isChange = true;
					}	
				}
				
				iteration = list.listIterator();
				while (iteration.hasNext() && !isChange) {
				
					Modified_Color_class next = iteration.next(); 
					if ( (next.getRed() - 50 <= c.getRed() && c.getRed() <= next.getRed() + 50) && 
						 (next.getGreen() - 50 <= c.getGreen() && c.getGreen() <= next.getGreen() + 50) &&
						 (next.getBlue() - 50 <= c.getBlue() && c.getBlue() <= next.getBlue() + 50)) {
					
						image2.setRGB(j, i,next.getRGB());
						////////////////////////////////TODO
						bestName = next.getName();
						isChange = true;
					}	
				}
				
				
				
			//	System.out.println(bestName);
				//TODO Change color when nothing is done
				if (!isChange) {
					
					if ( i == 0 && j == 0) {
						
						// Do nothing
					}
					else if ( i == 0 && j != 0) {
						
						image2.setRGB(j, i, image2.getRGB(j-1, i));	
					}
					else if ( i != 0 && j == 0) {
						
						image2.setRGB(j, i, image2.getRGB(j, i-1));
					}
					else {
						
						image2.setRGB(j, i, image2.getRGB(j-1, i));
					}
					
				}
				else {
			
					if (bestName.compareTo("colors3\\black") == 0) {
					
						image2.setRGB(j, i, Color.black.getRGB());
					}
					if (bestName.compareTo("colors3\\blue") == 0) {
					
						image2.setRGB(j, i, Color.blue.getRGB());
					}
					if (bestName.compareTo("colors3\\brown") == 0) {
					
						Color brown = new Color(139, 69, 19);
						image2.setRGB(j, i, brown.getRGB());
					}
					if (bestName.compareTo("colors3\\cyan") == 0) {
					
						image2.setRGB(j, i, Color.cyan.getRGB());
					}
					if (bestName.compareTo("colors3\\green") == 0) {
						
						image2.setRGB(j, i, Color.green.getRGB());
					}
					if (bestName.compareTo("colors3\\grey") == 0) {
						
						Color grey = new Color(128, 128, 128);
						image2.setRGB(j, i, grey.getRGB());
					}
					if (bestName.compareTo("colors3\\aorange") == 0) {
						
						image2.setRGB(j, i, Color.orange.getRGB());
					}
					if (bestName.compareTo("colors3\\pink") == 0) {
						
						image2.setRGB(j, i, Color.pink.getRGB());
					}
					if (bestName.compareTo("colors3\\purple") == 0) {
						
						Color purple = new Color(128, 0, 128);
						image2.setRGB(j, i, purple.getRGB());
					}
					if (bestName.compareTo("colors3\\red") == 0) {
						
						image2.setRGB(j, i, Color.red.getRGB());
					}
					if (bestName.compareTo("colors3\\askin_color") == 0) {
						
						Color skin = new Color(255, 235, 205);
						image2.setRGB(j, i, skin.getRGB());
					}
					if (bestName.compareTo("colors3\\white") == 0) {
						
						image2.setRGB(j, i, Color.white.getRGB());
					}
					if (bestName.compareTo("colors3\\yellow") == 0) {
						
						image2.setRGB(j, i, Color.yellow.getRGB());
					}
				}
					
			}
		}
		
		//////////////////////TODO Create a file
		if (createFile) {
			
//			File output = new File("C:/individual/subject/project/product6/sample3.png");
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
