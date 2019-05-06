package Main;

import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EmpresaApp extends Application {
    private static Stage stage;
    
    private double xOffset;
    private double yOffset;

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        EmpresaApp.stage = stage;
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/View/Empresas.fxml"));
       
        Scene scene = new Scene(root);
        this.stage = stage;
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
