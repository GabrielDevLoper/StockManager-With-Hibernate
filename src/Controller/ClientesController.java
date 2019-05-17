package Controller;

import GenericDAO.HibernateDAO;
import Main.AlteraClienteApp;

import Main.CadastroClienteApp;

import Model.Cliente;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ClientesController implements Initializable {
    
    private ObservableList<Cliente> clientes = FXCollections.observableArrayList();
    private Cliente selecionadoCliente;
    
    
    @FXML
    private TableView<Cliente> tblClientes;
    @FXML
    private TableColumn<Cliente, String> clnNome;
    @FXML
    private TableColumn<Cliente, String> clnTelefone;
    @FXML
    private TableColumn<Cliente, String> clnCpf;
    
    @FXML private TextField txtBuscarCliente;
    
    
    @FXML
    void btnBuscar(MouseEvent event) {
        tblClientes.setItems(BuscarCliente());
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
    void btnAtualizar(MouseEvent event) {
        initTable();
    }
    
    @FXML
    void btnVisualizar(MouseEvent event) {

    }
   
    /*Comando abaixo é usado para criar botões de fechar e minimizar automatico
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
   */
    
    
    
    
    
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
    
    
    @FXML
    void btnAlterar(MouseEvent event) {
        
        if(selecionadoCliente!= null){
            AlteraClienteApp acp = new AlteraClienteApp(selecionadoCliente);
            try {
                acp.start(new Stage());
            } catch (Exception ex) {
                Logger.getLogger(ClientesController.class.getName()).log(Level.SEVERE, null, ex);
            }   
            
        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Selecione um Cliente");
            alert.setTitle("Cliente");
            alert.setContentText("Aperte OK Para continuar");
            alert.show();
            
        }
    }
    
    @FXML
    void btnExcluir(MouseEvent event) {
        if(selecionadoCliente != null){
            HibernateDAO dao = new HibernateDAO();
            dao.delete(selecionadoCliente);
        
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Excluido Com Sucesso");
            alert.setTitle("Excluido");
            alert.setContentText("Aperte OK Para continuar");
            alert.show();
            
            initTable();
            
        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Selecione um Cliente");
            alert.setTitle("Cliente");
            alert.setContentText("Aperte OK Para continuar");
            alert.show();
        }
        
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
    
    
    public ObservableList<Cliente> BuscarCliente(){
        ObservableList<Cliente> clienteBuscar = FXCollections.observableArrayList();
        for(int x = 0; x<clientes.size(); x++){
            if(clientes.get(x).getNome().contains(txtBuscarCliente.getText().toUpperCase())){
                clienteBuscar.add(clientes.get(x));
            
            }else if(clientes.get(x).getCpf().contains(txtBuscarCliente.getText().toUpperCase())){
                 clienteBuscar.add(clientes.get(x));
            }
        }
        return clienteBuscar;
    }
   
   
    
}
