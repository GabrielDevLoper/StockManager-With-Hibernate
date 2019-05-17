package Controller.Empresa;

import FormatedTxtField.FormatedTextField;
import GenericDAO.HibernateDAO;
import Model.Cliente;
import Model.Empresa;
import Model.Endereco;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;


public class CadastroEmpresaController implements Initializable {
    
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML private TextField txtNome;
    @FXML private TextField txtTelefone;
    @FXML private TextField txtCnpj;
    @FXML private TextField txtEndereco;
    @FXML private TextField txtNumero;
    @FXML private TextField txtBairro;
    @FXML private TextField txtCep;
    @FXML private TextField txtCidade;
    @FXML private TextField txtComplemento;
    @FXML private TextField txtUf;

    @FXML
    void btnCancelar(MouseEvent event) {

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
        
        Empresa emp = new Empresa();
        emp.setNome(txtNome.getText().toUpperCase().trim());
        emp.setTelefone(txtTelefone.getText().toUpperCase().trim());
        emp.setCnpj(txtCnpj.getText().trim());
        emp.setEndereco(end);
        end.setEmpresa(emp);
        
        cdao.add(emp);
        
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
    void FormatedCnpj(KeyEvent event) {
        FormatedTextField tff = new FormatedTextField();
        tff.setMask("###.###.###-##");
        tff.setCaracteresValidos("0123456789");
        tff.setTf(txtCnpj);
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
         txtCep.setText("");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    } 
    
    public void ClearTextFields(){
        txtBairro.setText("");
        txtCep.setText("");
        txtCidade.setText("");
        txtComplemento.setText("");
        txtCnpj.setText("");
        txtEndereco.setText("");
        txtNome.setText("");
        txtNumero.setText("");
        txtTelefone.setText("");
        txtUf.setText("");
    }
    
}
