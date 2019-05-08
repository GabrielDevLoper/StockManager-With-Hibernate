package Controller;

import FormatedTxtField.FormatedTextField;
import GenericDAO.HibernateDAO;
import Main.AlteraEmpresaApp;
import Model.Empresa;
import Model.Endereco;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;


public class AlteraEmpresaController implements Initializable {
    
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private Label lblID;
    @FXML
    private Label lblIDend;

    
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
    
    private static Empresa em2;

    public static Empresa getEm2() {
        return em2;
    }

    public static void setEm2(Empresa em2) {
        AlteraEmpresaController.em2 = em2;
    }
    
    
    @FXML
    void btnAlterar(MouseEvent event) {
        HibernateDAO cdao = new HibernateDAO();
        Endereco end = new Endereco();
        
        end.setId(Integer.parseInt(lblIDend.getText()));
        end.setCidade(txtCidade.getText().toUpperCase().trim());
        end.setBairro(txtBairro.getText().toUpperCase().trim());
        end.setEndereco(txtEndereco.getText().toUpperCase().trim());
        end.setNumero(txtNumero.getText().toUpperCase().trim());
        end.setUf(txtUf.getText().toUpperCase().trim());
        end.setCep(txtCep.getText());
        end.setComplemento(txtComplemento.getText().toUpperCase().trim());
        
        Empresa emp = new Empresa();
        emp.setId(Integer.parseInt(lblID.getText()));
        emp.setNome(txtNome.getText().toUpperCase().trim());
        emp.setTelefone(txtTelefone.getText().toUpperCase().trim());
        emp.setCnpj(txtCnpj.getText().trim());
        emp.setEndereco(end);
        end.setEmpresa(emp);
        
        cdao.update(emp);
        
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Alterado Com Sucesso");
                alert.setTitle("Alterado");
                alert.setContentText("Aperte OK Para continuar");
                alert.show();
        
        AlteraEmpresaApp.getStage().close();
        

    }

    
    public void initClient(){
        lblID.setText(Integer.toString(em2.getId()));
        txtNome.setText(em2.getNome());
        txtTelefone.setText(em2.getTelefone());
        txtCnpj.setText(em2.getCnpj());
        
        lblIDend.setText(Integer.toString(em2.getEndereco().getId()));
        txtEndereco.setText(em2.getEndereco().getEndereco());
        txtNumero.setText(em2.getEndereco().getNumero());
        txtBairro.setText(em2.getEndereco().getBairro());
        txtCep.setText(em2.getEndereco().getCep());
        txtCidade.setText(em2.getEndereco().getCidade());
        txtComplemento.setText(em2.getEndereco().getComplemento());
        txtUf.setText(em2.getEndereco().getUf());
    }
    
    
    

    @FXML
    void btnCancelar(MouseEvent event) {

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
        tff.setMask("##.###.###/####-##");
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
        initClient();
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
