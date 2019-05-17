package Controller;

import FormatedTxtField.FormatedTextField;
import GenericDAO.HibernateDAO;
import Main.CadastroClienteApp;
import Model.Cliente;
import Model.Endereco;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;


public class CadastroClienteController implements Initializable {
    
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML private TextField txtNome;
    @FXML private TextField txtTelefone;
    @FXML private TextField txtCpf;
    @FXML private TextField txtEndereco;
    @FXML private TextField txtNumero;
    @FXML private TextField txtBairro;
    @FXML private TextField txtCep;
    @FXML private TextField txtCidade;
    @FXML private TextField txtComplemento;
    @FXML private TextField txtUf;

    @FXML
    void btnCancelar(MouseEvent event) {
        CadastroClienteApp.getStage().close();
    }
    @FXML
    void btnSalvar(MouseEvent event) {
        HibernateDAO cdao = new HibernateDAO();
        Endereco end = new Endereco();
        
        end.setCidade(txtCidade.getText().toUpperCase().trim());
        end.setBairro(txtBairro.getText().toUpperCase().trim());
        end.setEndereco(txtEndereco.getText().toUpperCase().trim());
        end.setNumero(txtNumero.getText().toUpperCase().trim());
        end.setUf(txtUf.getText().toUpperCase().trim());
        end.setCep(txtCep.getText());
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
                
        ClearTextFields();

    }
    
    @FXML
    void FormatedCep(KeyEvent event) {
        FormatedTextField tff = new FormatedTextField();
        tff.setMask("#####-###");
        tff.setCaracteresValidos("0123456789");
        tff.setTf(txtCep);
        tff.formatter();
    }
   

    @FXML
    void FormatedCpf(KeyEvent event) {
        FormatedTextField tff = new FormatedTextField();
        tff.setMask("###.###.###-##");
        tff.setCaracteresValidos("0123456789");
        tff.setTf(txtCpf);
        tff.formatter();

    }

    @FXML
    void FormatedTel(KeyEvent event) {
        FormatedTextField tff = new FormatedTextField();
        tff.setMask("(##)#.####-####");
        tff.setCaracteresValidos("0123456789");
        tff.setTf(txtTelefone);
        tff.formatter();

    }

    
    
    @FXML
    void btnClearCEP(MouseEvent event) {
        Clear();
    }
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    } 
    
    public void ClearTextFields(){
        txtBairro.setText("");
        txtCep.setText("");
        txtCidade.setText("");
        txtComplemento.setText("");
        txtCpf.setText("");
        txtEndereco.setText("");
        txtNome.setText("");
        txtNumero.setText("");
        txtTelefone.setText("");
        txtUf.setText("");
    }
    
   public void Clear(){
       txtCep.setText("");
   }
    
    
    
}
