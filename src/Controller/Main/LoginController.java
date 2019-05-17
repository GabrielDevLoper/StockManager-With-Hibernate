package Controller.Main;

import Main.MenuApp;
import Main.LoginApp;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


public class LoginController implements Initializable {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    
    @FXML
    private JFXTextField txtUsuario;

    @FXML
    private JFXPasswordField txtSenha;
    
    
    @FXML
    void btnEntrar(MouseEvent event) {
        MenuApp menu = new MenuApp(txtUsuario.getText());
        try {
            menu.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        LoginApp.getStage().close();
    }

    @FXML
    void btnSair(MouseEvent event) {
        LoginApp.getStage().close();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
