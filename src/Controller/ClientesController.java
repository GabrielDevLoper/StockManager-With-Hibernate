package Controller;

import GenericDAO.HibernateDAO;
import Main.CadastroClienteApp;
import Main.MenuApp;

import Model.Cliente;
import Main.ClienteApp;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ClientesController implements Initializable {
    
    @FXML
    private TableView<Cliente> tblClientes;
    @FXML
    private TableColumn<Cliente, String> clnNome;
    @FXML
    private TableColumn<Cliente, String> clnTelefone;
    @FXML
    private TableColumn<Cliente, String> clnCpf;
   
    
     @FXML
    void btnAlterar(MouseEvent event) {

    }

    @FXML
    void btnNovo(MouseEvent event) {
        
        CadastroClienteApp cc = new CadastroClienteApp();
        try {
            cc.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(ClientesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    void btnExcluir(MouseEvent event) {

    }
    
    @FXML
    void btnAtualizar(MouseEvent event) {

    }
    
     @FXML
    void btnFechar(MouseEvent event) {
        ClienteApp.getStage().close();
        MenuApp menu = new MenuApp();
        try {
            menu.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    
    
    
    private ObservableList<Cliente> clientes = FXCollections.observableArrayList();
    private Cliente selecionadoCliente;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initTable();
        
        tblClientes.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
           @Override
           public void changed(ObservableValue observable, Object oldValue, Object newValue) {
               selecionadoCliente = (Cliente) newValue;
           }
        });
        
        
   }
    
    private void initTable(){
        
        //PASSAR AS STRINGS DA MESMA FORMA QUE FOI ESCRITA NA CLASSE.
            clnNome.setCellValueFactory(new PropertyValueFactory("nome"));
            clnTelefone.setCellValueFactory(new PropertyValueFactory("telefone"));
            clnCpf.setCellValueFactory(new PropertyValueFactory("cpf"));
            tblClientes.setItems(updateTable());
    }
    
    private ObservableList<Cliente>  updateTable(){
        HibernateDAO cdao = new HibernateDAO();
        clientes = FXCollections.observableArrayList(cdao.getList("Cliente"));
        return clientes;
        
    }
    
   
    
}
