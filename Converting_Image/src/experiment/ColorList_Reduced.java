package experiment;

import java.util.LinkedList;
import java.util.ListIterator;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class ColorList_Reduced {

	/**
	 * 
	 */
	public LinkedList<Modified_Color_class> c;
	
	/**
	 * 
	 * @param pathname
	 */
	public ColorList_Reduced(String pathname) {
		
		c = new LinkedList<Modified_Color_class>();
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
		String name = filename.getParent();
		
		Modified_Color_class color = new Modified_Color_class(image.getRGB(0, 0), name);
		c.addLast(color);
	}
	
	/**
	 * 
	 * @return
	 */
	public LinkedList<Modified_Color_class> getList() {
		
		return c;
	}
	
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		ColorList_Reduced sample = new ColorList_Reduced("colors");
		
		LinkedList<Modified_Color_class> ex = sample.getList();
		ListIterator<Modified_Color_class> ex1 = ex.listIterator();
		while (ex1.hasNext()) {
			
			Modified_Color_class next = ex1.next();
			System.out.println(next + "\t" + next.getName());
		}
	}

}
