package experiment;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;


public class PROJECT {

	BufferedImage image;
	int width;
	int height;
	   
	
	public PROJECT() throws IOException {
		
		try {
			File input = new File("sample2/baby.gif");
			
			image = ImageIO.read(input);
			//width = image.getWidth();
			//height = image.getHeight();
	        
			
			//System.out.println(image.getType());
			
			int count = 0;
	         
			for(int i=0; i<height; i++){
	         
				for(int j=0; j<width; j++){
	            
					count++;
					Color c = new Color(image.getRGB(j, i));
					System.out.println("S.No: " + count + " Red: " + c.getRed() +"  Green: " + 
																	 c.getGreen() + " Blue: " + c.getBlue());
					
					
				}
			}
		
			
	     } catch (IOException e) {
	    	 System.out.println("Error: file not found.");
	    	 return;
	     }
	}
	  
	
	public int width() {
	
		return width;
	}
	
	public int height() {
		
		return height;
	}
	   
	public int type() {
		
		return image.getType();
		
	}
	   
	static public void main(String args[]) throws Exception 
	{
		PROJECT obj = new PROJECT();
		System.out.println(obj.type());
	}
	
}
