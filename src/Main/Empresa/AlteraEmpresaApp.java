package Main.Empresa;

import Controller.Cliente.AlteraClienteController;
import Controller.Empresa.AlteraEmpresaController;
import Model.Cliente;
import Model.Empresa;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


public class AlteraEmpresaApp extends Application {
    private static Stage stage;
    
    public AlteraEmpresaApp(Empresa em1){
        AlteraEmpresaController.setEm2(em1);
    }
    
    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        AlteraEmpresaApp.stage = stage;
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/View/Empresa/AlteraEmpresas.fxml"));
       
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
