package gui;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;

/**
 * 
 * @author hnp435
 *
 */
public class ValueEntryPanel extends JPanel {
	
	/**
	 * 
	 */
	private JTextField textField;

	/**
	 * 
	 * @param prompt
	 */
	public ValueEntryPanel(String prompt) {
		
		JLabel promptLabel = new JLabel(prompt);
		add(promptLabel);
		
		textField = new JTextField(50);
		add(textField);
	}

	/**
	 * 
	 * @return
	 */
	public String getValueAsString() {
		
		return textField.getText();
	}
	
	/**
	 * 
	 * @return
	 */
	public int getValueAsInt() {
		
		String valueAsString = textField.getText();
		int value = -1;
		if (valueAsString != null && valueAsString.length() > 0) {
			
			try {
				value = Integer.parseInt(valueAsString);
			} catch (NumberFormatException e){
				
				textField.setText("Not an int: " + textField.getText());
				throw e;
			}
		} else {
			textField.setText("Empty field: " + textField.getText());
			throw new NumberFormatException("Didn't enter the value for the int");
		}
		return value;
	}
	
	public static final long serialVersionUID = 1;
}
