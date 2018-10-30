package side_program;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Compare_Image {


	BufferedImage image1;
	BufferedImage image2;
	int width;
	int height;
	
	int RedSmallest;
	int RedBiggest;
	
	int GreenSmallest;
	int GreenBiggest;
	
	int BlueSmallest;
	int BlueBiggest;
	
	public Compare_Image() throws IOException{
		
		RedSmallest = Integer.MAX_VALUE;
		RedBiggest = Integer.MIN_VALUE;
		
		GreenSmallest = Integer.MAX_VALUE;
		GreenBiggest = Integer.MIN_VALUE;
		
		BlueSmallest = Integer.MAX_VALUE;
		BlueBiggest = Integer.MIN_VALUE;
		
		try {
			File input = new File("C:/individual/subject/project/Document/Sample1/american-eagle_(0).jpg");
			image1 = ImageIO.read(input);
			width = image1.getWidth();
			height = image1.getHeight();
	        
			
			input = new File("C:/individual/subject/project/Document/Sample1/american-eagle_(100).jpg");
			image2 = ImageIO.read(input);
			
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
		
		return image1.getType();
		
	}
	
	
	public void Compare() throws IOException{
		//String content = "Image2 - Image 1:";
		
		for(int i=0; i < this.height(); i++){
	         
			for(int j=0; j < this.width(); j++){
				
				//System.out.println(i + "\t\t" + j);
				
				
				Color c1 = new Color(image1.getRGB(j, i));
				Color c2 = new Color(image2.getRGB(j, i));
				int red = c1.getRed() - c2.getRed();
				int green = c1.getGreen() - c2.getGreen();
				int blue = c1.getBlue() - c2.getBlue();
				
				///////////////////////////////////////////////////////////////////////////////////
				if ( red > this.RedBiggest) {
					
					this.RedBiggest = red;
				} 
				else if ( red < this.RedSmallest) {
					
					this.RedSmallest = red;
				}
				
				/////////////////////////////////////////////////////////////////////////////////////
				if ( green > this.GreenBiggest) {
					
					this.GreenBiggest = green;
				} 
				else if ( green < this.GreenSmallest) {
					
					this.GreenSmallest = green;
				}
				
				/////////////////////////////////////////////////////////////////////////////////////
				if ( blue > this.BlueBiggest) {
	
					this.BlueBiggest = blue;
				} 
				else if ( blue < this.BlueSmallest) {
	
					this.BlueSmallest = blue;
				}
				
				int k = i*j;
				System.out.println("Pixel: " + k + "\t\t Red: " + red + "\t Green: " + green + "\t Blue: " + blue);
				//content = content + "/nPixel: " + k + "/t/t : " + h;
			}
		}
		
		System.out.println("Red range: " + this.RedSmallest + " - " + this.RedBiggest);
		System.out.println("Green range: " + this.GreenSmallest + " - " + this.GreenBiggest);
		System.out.println("Red range: " + this.BlueSmallest + " - " + this.BlueBiggest);
		
		
		
//		File output = new File("C:/individual/subject/project/Document/Sample1/file1.txt");
//		FileWriter fw = new FileWriter(output.getAbsoluteFile());
//		BufferedWriter bw = new BufferedWriter(fw); 
//		bw.write(content);
//		bw.close();
	}
	
	
	public static void main(String[] args) throws IOException {
		
		Compare_Image compare = new Compare_Image();
		System.out.println(compare.height() + "\t\t" + compare.width());
		compare.Compare();
	}

}
