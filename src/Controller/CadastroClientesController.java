package Controller;

import GenericDAO.HibernateDAO;
import Main.CadastroClienteApp;
import Model.Cliente;
import Model.Endereco;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class CadastroClientesController implements Initializable {
    
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    
    @FXML
    private JFXTextField txtNome;

    @FXML
    private JFXTextField txtTelefone;

    @FXML
    private JFXTextField txtCpf;

    @FXML
    private JFXTextField txtCidade;

    @FXML
    private JFXTextField txtBairro;

    @FXML
    private JFXTextField txtRua;

    @FXML
    private JFXTextField txtNumero;

    @FXML
    private JFXTextArea txtComplemento;
    
    
    
    

    @FXML
    void btnCancelar(MouseEvent event) {

    }

    @FXML
    void btnClose(MouseEvent event) {
        CadastroClienteApp.getStage().close();
    }

    @FXML
    void btnMinus(MouseEvent event) {
        Stage s = (Stage)((Node)event.getSource()).getScene().getWindow();
        s.setIconified(true);

    }

    @FXML
    void btnSalvar(MouseEvent event) {
        HibernateDAO cdao = new HibernateDAO();
        
        Endereco end = new Endereco();
        end.setCidade(txtCidade.getText().toUpperCase().trim());
        end.setBairro(txtBairro.getText());
        end.setRua(txtRua.getText().toUpperCase().trim());
        end.setNumero(txtNumero.getText().toUpperCase().trim());
        end.setComplemento(txtComplemento.getText().toUpperCase().trim());
        
        Cliente cli = new Cliente();
        cli.setNome(txtNome.getText().toUpperCase().trim());
        cli.setTelefone(txtTelefone.getText().toUpperCase().trim());
        cli.setCpf(txtCpf.getText().trim());
        cli.setEndereco(end);
        end.setCliente(cli);
        cdao.add(cli);
        
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Salvo Com Sucesso");
                alert.setTitle("Salvo");
                alert.setContentText("Aperte OK Para continuar");
                alert.show();

    }
    
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
