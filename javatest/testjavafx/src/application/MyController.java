package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MyController {
	
    @FXML
    private AnchorPane loginBar;

    @FXML
    private AnchorPane main_form;

    @FXML
    private Button close;

    @FXML
    private Button login;

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

//  DATABASE TOOls
  private Connection connect;
  private PreparedStatement prepare;
  private ResultSet result;
  
//  NOW LETS CREATE OUR DATABASE : ) 
  
  private double x = 0;
  private double y = 0;
  
  public void loginAdmin(){
      
      String sql = "SELECT * FROM admin WHERE username = ? and password = ?";
      
      connect = database.connectDb();
      
      try {
    	   Alert alert;
    	  prepare = connect.prepareStatement(sql);
          prepare.setString(1, username.getText());
          prepare.setString(2, password.getText());
          
          result = prepare.executeQuery();
//        CHECK IF FIELDS ARE EMPTTY
        if(username.getText().isEmpty() || password.getText().isEmpty()){
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields");
            alert.showAndWait();
        }else {
        	if(result.next()) {
        		  alert = new Alert(AlertType.INFORMATION);
                  alert.setTitle("Information Message");
                  alert.setHeaderText(null);
                  alert.setContentText("Successfully Login!");
                  alert.showAndWait();
                  login.getScene().getWindow().hide();
                  
                  Parent root = FXMLLoader.load(getClass().getResource("dashboard.fxml"));
                  
                  Stage stage = new Stage();
                  Scene scene = new Scene(root);
                  
                  // Enable window dragging
                  root.setOnMousePressed((MouseEvent event) -> {
                      x = event.getSceneX();
                      y = event.getSceneY();
                  });

                  root.setOnMouseDragged((MouseEvent event) -> {
                      stage.setX(event.getScreenX() - x);
                      stage.setY(event.getScreenY() - y);
                      stage.setOpacity(0.8);
                  });

                  root.setOnMouseReleased((MouseEvent event) -> {
                      stage.setOpacity(1);
                  });

                  // Set transparent style
                  stage.initStyle(StageStyle.TRANSPARENT);
                  
                  stage.setScene(scene);
                  stage.show();
        	}else {
        		 alert = new Alert(AlertType.ERROR);
                 alert.setTitle("Error Message");
                 alert.setHeaderText(null);
                 alert.setContentText("Wrong Username/Password");
                 alert.showAndWait();
             }
        	
        	
        }
        
          
      }catch(Exception e){e.printStackTrace();}
      
  }
      
  
    
    
    
    
    
    
    
    
   

    @FXML
    private void onClose() {
        System.exit(0); // Close the application when the close button is clicked
    }
}
