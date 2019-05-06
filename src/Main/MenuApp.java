package Main;

import Controller.MenuController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class MenuApp extends Application {
    private static Stage stage;
    
    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        MenuApp.stage = stage;
    }

    private String user;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
    
    
    public MenuApp(String usuario) {
        MenuController.setUsuario2(usuario);
    }
    
    
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/View/Menu.fxml"));
       
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
