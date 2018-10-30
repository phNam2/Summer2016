package experiment;

import java.util.LinkedList;
import java.util.ListIterator;

import javax.imageio.ImageIO;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class ColorList {

	/**
	 * 
	 */
	public LinkedList<Color> c;
	
	/**
	 * 
	 * @param pathname
	 */
	public ColorList(String pathname) {
		
		c = new LinkedList<Color>();
		this.createList(pathname);
	}

	/**
	 * 
	 * @param pathname
	 */
	public void createList(String pathname) {
		
		File folder = new File(pathname);
		File[] listOfFiles = folder.listFiles();

		for (File file : listOfFiles) {
		    if (file.isDirectory()) {
		    
		    	//System.out.println(file.getName());
		    	createList(file.getPath());
		    }
		    
		    if (file.isFile()) {
		    	
		    	//System.out.println(file.getParent());
		    	try {
					this.addcolor(file);
				} catch (IOException e) {
					e.printStackTrace();
				}
		    }
		}
	}
	
	/**
	 * 
	 * @param filename
	 * @throws IOException 
	 */
	public void addcolor(File filename) throws IOException {
	
		BufferedImage image = ImageIO.read(filename);
		Color color = new Color(image.getRGB(0, 0));
		c.addLast(color);
	}
	
	/**
	 * 
	 * @return
	 */
	public LinkedList<Color> getList() {
		
		return c;
	}
	
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		ColorList sample = new ColorList("colors");
		
		LinkedList<Color> ex = sample.getList();
		ListIterator<Color> ex1 = ex.listIterator();
		while (ex1.hasNext()) {
			
			System.out.println(ex1.next());
		}
	}

}
