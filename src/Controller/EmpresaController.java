package Controller;

import GenericDAO.HibernateDAO;
import Main.AlteraEmpresaApp;
import Main.CadastroEmpresaApp;
import Main.VisualizarEmpresaApp;
import Model.Cliente;
import Model.Empresa;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class EmpresaController implements Initializable {
    private ObservableList<Empresa> empresas = FXCollections.observableArrayList();
     private Empresa empresaSelecionada;
    
    @FXML private TextField txtBuscarEmpresa;
    @FXML private TableView<Empresa> tblEmpresas;
    @FXML private TableColumn<Empresa, String> clnNome;
    @FXML private TableColumn<Empresa, String> clnTelefone;
    @FXML private TableColumn<Empresa, String> clnCnpj;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initTable();
        
           tblEmpresas.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
           @Override
           public void changed(ObservableValue observable, Object oldValue, Object newValue) {
               empresaSelecionada = (Empresa) newValue;
           }
        });
    }    
    
    @FXML
    void btnExcluir(MouseEvent event) {
        HibernateDAO dao = new HibernateDAO();
        if(empresaSelecionada != null){
            dao.delete(empresaSelecionada);    
        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Selecione uma Empresa");
            alert.setTitle("Empresa");
            alert.setContentText("Aperte OK Para continuar");
            alert.show();
        }
        
    }
    
    @FXML
    void btnAlterar(MouseEvent event) {
        if(empresaSelecionada != null){
            AlteraEmpresaApp aep = new AlteraEmpresaApp(empresaSelecionada);
            try {
            aep.start(new Stage());
            } catch (Exception ex) {
            Logger.getLogger(EmpresaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Selecione uma Empresa");
            alert.setTitle("Empresa");
            alert.setContentText("Aperte OK Para continuar");
            alert.show();
        }
        
    }
    
    @FXML
    void btnAtualizar(MouseEvent event) {
         initTable();
    }

    @FXML
    void btnNovo(MouseEvent event) {
        CadastroEmpresaApp ce = new CadastroEmpresaApp();
        try {
            ce.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(EmpresaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    void btnVisualizar(MouseEvent event) {
        VisualizarEmpresaApp viewEmp = new VisualizarEmpresaApp(empresaSelecionada);
        try {
            viewEmp.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(EmpresaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }
    
    private void initTable(){
        
            //PASSAR AS STRINGS DA MESMA FORMA QUE FOI ESCRITA NA CLASSE.
            clnNome.setCellValueFactory(new PropertyValueFactory("nome"));
            clnTelefone.setCellValueFactory(new PropertyValueFactory("telefone"));
            clnCnpj.setCellValueFactory(new PropertyValueFactory("cnpj"));
            tblEmpresas.setItems(updateTable());
    }
    
    private ObservableList<Empresa>  updateTable(){
        HibernateDAO cdao = new HibernateDAO();
        empresas = FXCollections.observableArrayList(cdao.getList("Empresa"));
        return empresas;
        
    }
    
}
