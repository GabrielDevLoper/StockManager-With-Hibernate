package Main.Cliente;

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
        
        
        
        Parent root = FXMLLoader.load(getClass().getResource("/View/Cliente/Clientes.fxml"));
       
        Scene scene = new Scene(root);
        this.stage = stage;
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
