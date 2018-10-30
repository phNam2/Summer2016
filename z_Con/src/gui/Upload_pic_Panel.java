package gui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import checking.Picture_ratio;

public class Upload_pic_Panel extends JPanel {

	private ValueEntryPanel URL = null;

	public Upload_pic_Panel() {
	
		setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
		add(Box.createVerticalGlue());
		
		URL = new ValueEntryPanel("URL: ");
		URL.setMaximumSize(URL.getPreferredSize());
		add(URL);
		URL.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(Box.createVerticalGlue());
		
		
		JButton submit = new JButton("SUBMIT");
		submit.setMaximumSize(submit.getPreferredSize());
		add(submit);
		submit.addActionListener( new Submit() );
		submit.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		add(Box.createVerticalGlue());
		
		JButton back = new JButton("BACK");
		back.setMaximumSize(back.getPreferredSize());
		add(back);
		back.addActionListener( new Back() );
		back.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(Box.createVerticalGlue());
	}

	
	private class Submit implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			getTopLevelAncestor().setVisible(false);
			
			String name = URL.getValueAsString();
			Picture_ratio testing = new Picture_ratio(name);
			testing.setVisible(true);
			
			Picture_control_Frame frame = new Picture_control_Frame();
			frame.setLocation(916, 100);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		}
	}
	
	
	private class Back implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			getTopLevelAncestor().setVisible(false);
			
			Starting_Frame frame = new Starting_Frame();
			frame.setLocation(600, 300);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		}
		
	}
	
	
	private static final long serialVersionUID = 1;
}
