import org.w3c.dom.events.EventException;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class WebViewHTTP extends Application {

	public static void main(String[] args) {
		launch(args);

	}
	
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Java Web Browser");
        
        //Create WebView
        WebView webView = new WebView();
        
        // Create Panes for Layout Control
        FlowPane addressPane = new FlowPane();
        StackPane viewPane = new StackPane();
       
        // Add addressBar and Buttons
        Button submit = new Button("  GO  ");
        Button back = new Button("  Back  ");
        Button forw = new Button("  Forward  ");
        TextField addressBar = new TextField("https://www.google.com");
        
        //Add some settings to for layout
        addressBar.setMaxSize(800, 30);
        addressBar.setMinSize(500, 30);
        FlowPane.setMargin(addressBar, new Insets(5, 5, 5, 5));
        FlowPane.setMargin(back, new Insets(5, 5, 5, 5));
        
        //Add StackPane Alignment for Layout
        viewPane.setAlignment(Pos.BOTTOM_CENTER);
        addressPane.setAlignment(Pos.TOP_CENTER);
        
        // Add Elements to StackPane
        viewPane.getChildren().add(webView);
        addressPane.getChildren().addAll(back, forw, addressBar, submit);

        // Create VBox with StackPanes
        VBox vBox = new VBox(addressPane, viewPane);  
       
        //Add History
        WebEngine webEngine = webView.getEngine();
        WebHistory history = webEngine.getHistory();
        
		//Make actionListener which reacts to user click on submit
        submit.addEventHandler(MouseEvent.MOUSE_CLICKED, 
        	    new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
            	try {
	            	String temp = addressBar.getText();
	            	if(temp.contains("http://")) {
						webView.getEngine().load(temp);
					}
					else if(temp.contains("https://")) {
						webView.getEngine().load(temp);
					}
					else {
						webView.getEngine().load("http://" + temp);
					}
            	}
            	catch(Exception e1){
            		System.err.println("Something went wrong in the Submit EventHandler!");
            	}
            }
    });
        
      //Make actionListener which reacts to user click on Back
        back.addEventHandler(MouseEvent.MOUSE_CLICKED, 
        	    new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
            	String tempUrl = webView.getEngine().getLocation();
            	try {
            	history.go(-1);
            	} catch(EventException e1) {
            		webView.getEngine().load(tempUrl);
            		System.out.println("Can't go any Further so page will stay the same.");
            	}
   
            }
    });
        
        //Make actionListener which reacts to user click on Forw
        forw.addEventHandler(MouseEvent.MOUSE_CLICKED, 
        	    new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
            	String tempUrl = webView.getEngine().getLocation();
            	try {
            	history.go(1);
            	} catch(EventException e1) {
            		webView.getEngine().load(tempUrl);
            		System.out.println("Can't go any Further so page will stay the same.");
            	}
            }
    });


        //Create the Scene
        Scene scene = new Scene(vBox, 960, 600);
        
        //Show Scene
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    
}
