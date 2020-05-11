import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.JTextField;
import java.awt.event.*;

public class Example {
	/*Example(){
		//Declare parts
		JFrame frame = new JFrame("HTTP / URL");
		
		JLabel label = new JLabel("Enter a URL Here: ");
		JButton buttonEnter = new JButton("Search");
		JTextField textfield = new JTextField("",10);
		JEditorPane display;
		
		//Add parts
		frame.add(label);
		frame.add(textfield);
		frame.add(buttonEnter);
		
		frame.setSize(300,300);  
		frame.setVisible(true);  
		
		buttonEnter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
	
*/
	

	public static void main(String[] args) {
		ReadFile page = new ReadFile();
		page.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}