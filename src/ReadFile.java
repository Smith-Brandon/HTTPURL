import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.JTextField;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

import java.awt.event.*;

public class ReadFile extends JFrame{
	private JTextField addressBar;
	private JEditorPane display;


	public ReadFile() {
		super("My Browser");

		addressBar = new JTextField("https://www.google.com");
		//Make actionListener which reacts to user keyboard "enter"
		addressBar.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent event) {
						//On enter text/url is sent as a string to load
						String temp = event.getActionCommand();
						if(temp.contains("http://")) {
							loadPage(event.getActionCommand());
						}
						else if(temp.contains("https://")) {
							loadPage(event.getActionCommand());
						}
						else {
						loadPage("http://" + event.getActionCommand());
						}
					}

				}

		);
		add(addressBar, BorderLayout.NORTH);
		//Create display
		display = new JEditorPane();
		display.setEditable(false);
		//Make linkListener to go to a link if clicked
		display.addHyperlinkListener(
			new HyperlinkListener() {
				public void hyperlinkUpdate(HyperlinkEvent event) {
					if(event.getEventType()==HyperlinkEvent.EventType.ACTIVATED) {
						loadPage(event.getURL().toString());
					}
				}
			}
		);
		//Add to  and make it visible
		add(new JScrollPane(display), BorderLayout.CENTER);
		setSize(500,300);
		setVisible(true);
	}

	
	//load Page to display on screen
	private void loadPage(String userText) {
		try {
			display.setPage(userText);
			addressBar.setText(userText);
		}catch(Exception e) {
			System.out.println("You did something wrong, be sure to enter a valid URL!");
		}
	}
}

