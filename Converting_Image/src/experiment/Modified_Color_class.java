package experiment;

import java.awt.Color;
import java.util.LinkedList;
import java.util.ListIterator;


public class Modified_Color_class extends Color {

	/**
	 * 
	 */
	private String color_category;
	
	/**
	 * 
	 * @param a
	 * @param name
	 */
	public Modified_Color_class( int a, String name) {
		
		super(a);
		color_category = name;
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @param a
	 */
	public Modified_Color_class( int a ) {
		
		super(a);
		
		ColorList_Reduced list = new ColorList_Reduced("colors");
		LinkedList<Modified_Color_class> ex = list.getList();
		ListIterator<Modified_Color_class> ex1 = ex.listIterator();
		
		while (ex1.hasNext()) {
			
			Modified_Color_class next = ex1.next();
			
			if ( next.getRGB() == a) {
				
				this.color_category = next.getName();
				break;
			}
		}
	}
	
	public String getName(){
		
		return this.color_category;
	}
	
	private static final long serialVersionUID = 1;
}
