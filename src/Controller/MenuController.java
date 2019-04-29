package Controller;


import Main.ClienteApp;
import Main.MenuApp;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class MenuController implements Initializable {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private VBox PainelCadastros;
   
    @FXML
    void btnClose(MouseEvent event) {
        MenuApp.getStage().close();
    }

    @FXML
    void btnMaximize(MouseEvent event) {
        Stage s = (Stage)((Node)event.getSource()).getScene().getWindow();
        s.setFullScreen(true);
    }

    @FXML
    void btnMinus(MouseEvent event) {
        Stage s = (Stage)((Node)event.getSource()).getScene().getWindow();
        s.setIconified(true);
    }
    
    
     @FXML
    void btnCadastros(MouseEvent event) {
        PainelCadastros.setVisible(true);
    }
    
    @FXML
    void btnHome(MouseEvent event) {
        PainelCadastros.setVisible(false);
    }
    
    @FXML
    void btnCliente(MouseEvent event) {
        ClienteApp cliente = new ClienteApp();
        try {
            cliente.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
        MenuApp.getStage().close();
    }
    
   @FXML
    void btnEmpresa(MouseEvent event) {

    }
    
    @FXML
    void btnProduto(MouseEvent event) {

    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        PainelCadastros.setVisible(false);
    }    
    
   
    
}
