package experiment;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class A_first {

	BufferedImage image;
	Picture_ratio testing;
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public A_first(String file_location) {

		//TODO Get file
		try {
			File input = new File(file_location);
			image = ImageIO.read(input);
			
	     } catch (IOException e) {
	    	 System.out.println("Error: file not found.");
	    	 return;
	     }
		Print(image);
		
		//TODO Asking
		Scanner reader = new Scanner(System.in);
		System.out.println("Please choose one of these options:\n"
					+ "1. For Automatic Convert \n"
					+ "2. For Control Conver \n"
					+ "3. For Getting double Picture for comparision \n"
					+ "4. For Getting Pencil Sketch Style \n\n");
		
		boolean conti = true;
		
		
		
		while (conti == true) {
			
			int k = 0;
			
			while ( k<1 || k>4) {
						
				boolean error = true;
				while (error) {
					try {
						k = reader.nextInt();
						error = false;
					} catch(InputMismatchException e) {
					
						System.out.println("NUMBER ONLY, PLEASE CHOOSE AGAIN!!!");
						reader.next();
					}	
				}
				
				
				// TODO Automatic
				if (k==1) {
					
					
					ImageContent2 picture = null;
					try {
						picture = new ImageContent2(false, image);
						
					} catch (IOException e) {

						e.printStackTrace();
					}
					
					Print(picture.getImage());
					
//					//TODO
//					boolean ans = false;
//					System.out.println("Do you want to make it for comparision? (true/false)");
//					boolean erro = true;
//					while (erro) {
//						try {
//							ans = reader.nextBoolean();
//							erro = false;
//						} catch(InputMismatchException e) {
//						
//							System.out.println("TRUE OR FALSE ONLY, PLEASE CHOOSE AGAIN!!!");
//							reader.next();
//						}	
//					}
//					
//					if (ans==true) {
//						
//						Double_Picture picture2 = null;
//						try {
//							picture2 = new Double_Picture(image);
//						
//						} catch (IOException e) {
//
//							e.printStackTrace();
//						}
//					
//						Print2(picture.getImage());
//					}else {
//						
//					}
					
				
					// TODO Control
				} else if (k==2) {
				
					ImageContent picture = null;
					try {
						picture = new ImageContent(false, image);
					
					} catch (IOException e) {

						e.printStackTrace();
					}
				
					Print(picture.getImage());
				
					// TODO Double
				} else if (k==3) {
				
					Double_Picture picture = null;
					try {
						picture = new Double_Picture(image);
					
					} catch (IOException e) {

						e.printStackTrace();
					}
				
					Print2(picture.getImage());
				
					// TODO Sketch
				} else if (k==4) {
					
					Pencil_Sketch picture = null;
					try {
						picture = new Pencil_Sketch(image);
						
					} catch (IOException e) {

						e.printStackTrace();
					}
					
					Print(picture.getImage());
				
					// TODO
				} else {
				
					System.out.println("CHOICE INVALID!!! PLEASE CHOOSE AGAIN!!!");
				}
			}
			
			
			
			System.out.println("Do you want to continue? (true/false)");
			boolean error = true;
			while (error) {
				try {
					conti = reader.nextBoolean();
					error = false;
				} catch(InputMismatchException e) {
				
					System.out.println("TRUE OR FALSE ONLY, PLEASE CHOOSE AGAIN!!!");
					reader.next();
				}	
			}
			
			
			if (conti) {
				System.out.println("Then please choose the next options.");
			} else {
				System.out.println("Thank you!");
			}
		}
		
		reader.close();
		System.exit(0);
	}
	
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void Print(BufferedImage image) {

		testing = new Picture_ratio(image);
		testing.setLocation(0, 0);
		testing.setTitle("Picture 0");
		testing.setVisible(true);
	}
	
	public void Print2(BufferedImage image) {

		testing.setVisible(false);
		testing.dispose();
		
		testing = new Picture_ratio(image);
		testing.setLocation(0, 0);
		testing.setTitle("Picture 0");
		testing.setVisible(true);

	}

	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		A_first no = new A_first("sample/swan.jpg");
		
		return;
		
	}

}
