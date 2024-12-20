package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.stage.StageStyle;

public class Main extends Application {

    private double x = 0;
    private double y = 0;

    @Override
    public void start(Stage stage) {
        try {
            // Load the FXML layout
            Pane root = FXMLLoader.load(getClass().getResource("layout.fxml"));

            // Create the scene and apply styles
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            stage.setScene(scene);

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

            // Show the stage
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
