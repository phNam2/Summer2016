package experiment_giff;


import java.io.*;
import java.awt.image.BufferedImage;


class Create_Gif {

	
	public Create_Gif() {
		
		
	}

	public void testing() throws IOException {
		
		Gif_View view = new Gif_View();
		BufferedImage[] list= view.getImages("sample2/slap.gif");
		
		int delay = view.delayList()/10;
		//System.out.println(delay);
		Giffer.generateFromBI(list, "V:/project/experiment2(gif)/product9/sample14.gif", delay, true);
		
	}
	
	
	public static void main(String[] args) throws IOException {
	
		Create_Gif gif = new Create_Gif();
		gif.testing();
	}

}


