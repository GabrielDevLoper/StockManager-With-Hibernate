package Main;

import Controller.AlteraClienteController;
import Model.Cliente;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


public class AlteraClienteApp extends Application {
    private static Stage stage;
    
    public AlteraClienteApp(Cliente c1){
        AlteraClienteController.setC2(c1);
    }
    
    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        AlteraClienteApp.stage = stage;
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/View/AlteraClientes.fxml"));
       
        Scene scene = new Scene(root);
        this.stage = stage;
        //stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
