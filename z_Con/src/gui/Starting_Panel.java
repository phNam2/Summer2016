package gui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class Starting_Panel extends JPanel{

	public Starting_Panel() {
		
		setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
		add(Box.createVerticalGlue());
		
		JLabel prompt = new JLabel("Choose the format you want to work with");
		prompt.setMaximumSize(prompt.getPreferredSize());
		add(prompt);
		prompt.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(Box.createVerticalGlue());
		
		JButton picture = new JButton("Picture");
		picture.setMaximumSize(picture.getPreferredSize());
		add(picture);
		picture.setAlignmentX(Component.CENTER_ALIGNMENT);
		picture.addActionListener(new PictureAction());
		add(Box.createVerticalGlue());
		
		
		JButton gif = new JButton("Gif");
		gif.setMaximumSize(gif.getPreferredSize());
		add(gif);
		gif.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		add(Box.createVerticalGlue());
		
		
		JButton video = new JButton("Video");
		video.setMaximumSize(video.getPreferredSize());
		add(video);
		video.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		add(Box.createVerticalGlue());
	}

	
	
	private class PictureAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			getTopLevelAncestor().setVisible(false);
			
			Upload_pic_Frame frame = new Upload_pic_Frame();
			frame.setLocation(450, 300);
			frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			frame.setVisible(true);
		}
		
		
		
	}
	
	
	public static final long serialVersionUID = 1;
}
