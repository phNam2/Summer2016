package experiment;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import java.awt.Color;
import javax.imageio.ImageIO;

public class Pencil_Sketch extends ImageContent3{

	BufferedImage image3;
	
	public Pencil_Sketch(BufferedImage sample) throws IOException {
		
		// Create image2
		super(false, sample);
		
		image3 = new BufferedImage(this.width(), this.height(), image.getType());
		// TODO Create the sketch
		int prev = 0;
		for (int i=0; i < this.height; i++) {
			
			for ( int j=0; j < this.width; j++) {
				
				int current = image2.getRGB(j, i);
				//Color.BLACK.
				boolean conti = true;
				
				if (current == Color.BLACK.getRGB() || current == Color.WHITE.getRGB()) {
					
					image3.setRGB(j, i, current);
					conti = false;
				}
				
				if ( j != 0 && conti) {
					//System.out.println(prev.getRGB() + "/t/t" + current.getRGB());
					if ( current != prev ) {
			
						image3.setRGB(j, i, Color.BLACK.getRGB());
						
						int back = j -1;
						int num = 1;
						while ( back >= this.getWidth() && num != 2) {
							
							image3.setRGB(back, i, Color.BLACK.getRGB());
							back = back -1;
							num = num + 1;
						}
					} 
					else {

						image3.setRGB(j, i, Color.WHITE.getRGB());
					}
				}
				prev = current;
			}
		}
		
//		File output = new File("C:/individual/subject/project/product6/sample9.png");
//		ImageIO.write(image3, "png", output);
	}

	
	public void paint (Graphics g) {

		g.drawImage(image3, 0, 0, null);
	}
	
	public BufferedImage getImage() {
		
		return image3;
	}
	
	public static final long serialVersionUID = 1;
}
