package gui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Picture_control_Panel extends JPanel {

	

	public Picture_control_Panel() {
		
		setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
		add(Box.createVerticalGlue());
		
		JButton changeColor = new JButton("CHANGE COLOR");
		changeColor.setMaximumSize(changeColor.getPreferredSize());
		add(changeColor);
		//changeColor.addActionListener( new Submit() );
		changeColor.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(Box.createVerticalGlue());
		
		JButton penCil = new JButton("PENCIL STYLE");
		penCil.setMaximumSize(penCil.getPreferredSize());
		add(penCil);
		//penCil.addActionListener( new Back() );
		penCil.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(Box.createVerticalGlue());
		
		JButton rotate = new JButton("ROTATION");
		rotate.setMaximumSize(rotate.getPreferredSize());
		add(rotate);
		//rotate.addActionListener( new Submit() );
		rotate.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(Box.createVerticalGlue());
		
		JButton prev = new JButton("PREVIOUS");
		prev.setMaximumSize(prev.getPreferredSize());
		add(prev);
		//prev.addActionListener( new Back() );
		prev.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(Box.createVerticalGlue());
		
		JButton save = new JButton("SAVE");
		save.setMaximumSize(save.getPreferredSize());
		add(save);
		//save.addActionListener( new Submit() );
		save.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(Box.createVerticalGlue());
		
		JButton next = new JButton("NEXT");
		next.setMaximumSize(next.getPreferredSize());
		add(next);
		//back.addActionListener( new Back() );
		next.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(Box.createVerticalGlue());
		
		JButton back = new JButton("BACK");
		back.setMaximumSize(back.getPreferredSize());
		add(back);
		back.addActionListener( new Back2() );
		back.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(Box.createVerticalGlue());
		
		
		
		
	}
	
	private class Back2 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			getTopLevelAncestor().setVisible(false);
			
			Upload_pic_Frame frame = new Upload_pic_Frame();
			frame.setLocation(450, 300);
			frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			frame.setVisible(true);
			
		}	
	}
	
	
	
	
	private static final long serialVersionUID = 1;
}
