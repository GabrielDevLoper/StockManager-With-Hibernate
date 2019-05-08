package Main;

import Controller.MenuController;
import Controller.VisualizarEmpresaController;
import Model.Empresa;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class VisualizarEmpresaApp extends Application {
    private static Stage stage;
    
    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        VisualizarEmpresaApp.stage = stage;
    }

    public VisualizarEmpresaApp(Empresa emp1) {
        VisualizarEmpresaController.setEmp2(emp1);
    }
    
    
    
    
    
    
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/View/VisualizarEmpresa.fxml"));
       
        Scene scene = new Scene(root);
        this.stage = stage;
        //stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);
        //stage.setFullScreen(true); faz com que o stage se inicie com a tela cheia
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
