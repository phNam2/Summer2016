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
public class Automatic_Convert extends JFrame{

	/**
	 * 
	 */
	public static final long serialVersionUID = 1;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * 
	 */
	public Automatic_Convert() {
		
		this.setLocation(10, 10);
		this.setTitle("Experiment 1");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//TODO Create image 
		ImageContent2 image = null;
		//Double_Picture image = null;
		//Pencil_Sketch image = null;
		
		try {
			image = new ImageContent2(true);
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
		
//		Automatic_Convert testing = new Automatic_Convert();
//		testing.setVisible(true);
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
	BufferedImage image2;
	int width;
	int height;
	   
	/**
	 * 
	 * @throws IOException
	 */
	public ImageContent2(boolean createFile) throws IOException {
		
		try {
			File input = new File("sample/Orca.jpg");
			
			image = ImageIO.read(input);
			width = image.getWidth();
			height = image.getHeight();
	        
			//System.out.println(image.getType());;
			image2 = new BufferedImage(this.width(), this.height(), image.getType());
			
	     } catch (IOException e) {
	    	 System.out.println("Error: file not found.");
	    	 return;
	     }
		
		Drawing(createFile);
	}
		
		
	
	public ImageContent2(boolean createFile, BufferedImage sample) throws IOException {
				
		image = sample;
		width = image.getWidth();
		height = image.getHeight();
	        
		//System.out.println(image.getType());;
		image2 = new BufferedImage(this.width(), this.height(), image.getType());
		
		
		Drawing(createFile);
	}
	
	
	
	
	public void Drawing(boolean createFile) {	
		//TODO convert the picture
		ColorList color = new ColorList("colors");
		LinkedList<Color> list = color.getList();
		
		for (int i=0; i < height; i++) {
			
			for (int j=0; j < width; j++) {
				
				//image2.setRGB(j, i, image.getRGB(j, i));
				Color c = new Color(image.getRGB(j, i));
			
				boolean isChange = false;
					
				//TODO Start to bring color
				Color bestColor = new Color(255, 255, 255);
				image2.setRGB(j, i, bestColor.getRGB());
				ListIterator<Color> iteration = list.listIterator();
				while (iteration.hasNext()) {
				
					Color next = iteration.next(); 
					
					int distance[] = new int[6];
					distance[0] = bestColor.getRed() - c.getRed();
					distance[1] = bestColor.getGreen() - c.getGreen();
					distance[2] = bestColor.getBlue() - c.getBlue();
					distance[3] = next.getRed() - c.getRed();
					distance[4] = next.getGreen() - c.getGreen();
					distance[5] = next.getBlue() - c.getBlue();

					
					for (int k = 0; k < 6; k++) {
						
						if (distance[k] < 0) {
							
							distance[k] = distance[k] * (-1);
						}
					}
					
					
					if ( distance[0] > distance[3] && distance[1] > distance[4] && distance[2] > distance[5]) {
						
						bestColor = next;
						image2.setRGB(j, i, next.getRGB());
						isChange = true;
					}
				}
				
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
						
						image2.setRGB(j, i, image2.getRGB(j, i-1));
					}
				}
			}
		}
		
		//////////////////////TODO Create a file
		if (createFile) {
			
			//File output = new File("C:/individual/subject/project/project2");
			//ImageIO.write(image2, "png", output);
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
