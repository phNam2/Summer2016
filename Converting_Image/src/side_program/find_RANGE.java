package side_program;

public class find_RANGE {

	
	public int smallest;
	
	public int biggest;
	
	
	public find_RANGE() {
		
		int[] no = {107, 128, 142, 205, 255, 252, 250, 238, 251, 188, 179, 139, 128, 100};
		smallest = no[0];
		biggest = no[0];
		
		for (int i = 0; i< no.length; i++) {
			
			if ( no[i] < smallest) {
				
				smallest = no[i];
			}
			
			if ( no[i] > biggest) {
				
				biggest = no[i];
			}
		}
	}
	
	public int bigest() {
		
		return this.biggest;
	}
	
	public int smallest(){
		
		return this.smallest;
	}
	
	public static void main(String[] args) {
		
		find_RANGE range = new find_RANGE();
		System.out.println("Range: " + range.smallest() + " - " + range.bigest());
	}

}
