package experiment_giff;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.*;


import javax.imageio.ImageIO;



/**
 * 
 * @author Nam
 *
 */
public class Gif_View {

	
	public int ub;
	
	public int delay;
	
	public Gif_View() {
		
		ub = 0;	
	}
	
	
	public void printImages() throws IOException {
		
		
		
		GifDecoder d = new GifDecoder();
		d.read("sample2/ed.gif");
		ub = d.getFrameCount();
		delay = d.getDelay(0);
		for (int i = 1; i <= ub; i++) {
			
		    Print_Frame f = new Print_Frame(d.getFrame(i-1), i);
			f.setVisible(true);
		    
			File output = new File("C:/individual/subject/project/experiment2/product7/dance/sample" + i + ".png");
			ImageIO.write(d.getFrame(i-1), "png", output);
			
		}	
	}
	
	
	public BufferedImage[] getImages(String file_Address) throws IOException {
		
		GifDecoder d = new GifDecoder();
	
		d.read(file_Address);
		ub = d.getFrameCount();
		
		BufferedImage[] list = new BufferedImage[ub];
		delay = d.getDelay(0);
		
		for (int i = 0; i < ub; i++) {
			
			list[i] = d.getFrame(i);
			
			//list.add();
		}	
		
		return list;
	}
	
	
	public int delayList() {
		
		return delay;
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * 
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		Gif_View testing = new Gif_View();
		testing.printImages();
	
		
		int delay = testing.delayList();
			
		System.out.println("The delay of frame: " +  delay);
		
	}
	
	public static final long serialVersionUID = 1;
}

class Print_Frame extends JFrame {
	
	
	
	public Print_Frame(BufferedImage NewImage, int number) {
		
		this.setLocation(10, 10);
		this.setTitle("Frame " + number);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Panel p = new Panel(NewImage); 
		this.add(p);	
		this.setSize(NewImage.getWidth() + 16, NewImage.getHeight() + 39);

	}
	
	public static final long serialVersionUID = 1;
}



class Panel extends JPanel {
	
	BufferedImage image;
	
	
	public Panel(BufferedImage NewImage) {
		
		image = NewImage;	
	}
	
	public void paint (Graphics g) {
		
		g.drawImage(image, 0, 0, null);
	}
	
	public static final long serialVersionUID = 1;
}





