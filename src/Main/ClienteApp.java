package Main;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ClienteApp extends Application {
    private static Stage stage;
    
    private double xOffset;
    private double yOffset;

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        ClienteApp.stage = stage;
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/View/Clientes.fxml"));
       
        Scene scene = new Scene(root);
        this.stage = stage;
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);
        
        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });
            root.setOnMouseDragged(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                stage.setX(event.getScreenX() - xOffset);
                stage.setY(event.getScreenY() - yOffset);
            }
        });
        
        
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
