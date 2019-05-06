package Controller;

import Main.ClienteApp;
import Main.EmpresaApp;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;


import javafx.stage.Stage;


public class MenuController implements Initializable {
    @FXML private ResourceBundle resources;
    @FXML private URL location;
    
    @FXML
    private Text usuario;
    
    public static String usuario2;

    public static String getUsuario2() {
        return usuario2;
    }

    public static void setUsuario2(String usuario2) {
        MenuController.usuario2 = usuario2;
    }

    @FXML
    void btnClientes(MouseEvent event) throws IOException {
        OpenCliente();
    }
    
    
    @FXML
    void btnConfigurações(MouseEvent event) {

    }

    @FXML
    void btnEmpresas(MouseEvent event) {
        EmpresaApp empresa = new EmpresaApp();
        try {
            empresa.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    void btnEstoque(MouseEvent event) {

    }

    @FXML
    void btnFuncionarios(MouseEvent event) {

    }

    @FXML
    void btnRelatorios(MouseEvent event) {

    }
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        usuario.setText(usuario2.toUpperCase());
    }   
    
    
    public void OpenCliente(){
        
        Platform.runLater(() -> {
            ClienteApp cliente = new ClienteApp();
            try {
                cliente.start(new Stage());
            }catch (Exception ex) {
                Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    });
        
    }
    
   
    
}
