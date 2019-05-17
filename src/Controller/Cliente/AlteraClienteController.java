package Controller.Cliente;

import FormatedTxtField.FormatedTextField;
import GenericDAO.HibernateDAO;
import Main.Cliente.AlteraClienteApp;
import Model.Cliente;
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


public class AlteraClienteController implements Initializable {
    
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
    @FXML private TextField txtCpf;
    @FXML private TextField txtEndereco;
    @FXML private TextField txtNumero;
    @FXML private TextField txtBairro;
    @FXML private TextField txtCep;
    @FXML private TextField txtCidade;
    @FXML private TextField txtComplemento;
    @FXML private TextField txtUf;
    
    private static Cliente c2;

    public static Cliente getC2() {
        return c2;
    }

    public static void setC2(Cliente c2) {
        AlteraClienteController.c2 = c2;
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
        
        Cliente cli = new Cliente();
        cli.setId(Integer.parseInt(lblID.getText()));
        cli.setNome(txtNome.getText().toUpperCase().trim());
        cli.setTelefone(txtTelefone.getText().toUpperCase().trim());
        cli.setCpf(txtCpf.getText().trim());
        cli.setEndereco(end);
        end.setCliente(cli);
        
        cdao.update(cli);
        
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Alterado Com Sucesso");
                alert.setTitle("Alterado");
                alert.setContentText("Aperte OK Para continuar");
                alert.show();
        
        AlteraClienteApp.getStage().close();
        

    }

    
    public void initClient(){
        lblID.setText(Integer.toString(c2.getId()));
        txtNome.setText(c2.getNome());
        txtTelefone.setText(c2.getTelefone());
        txtCpf.setText(c2.getCpf());
        
        lblIDend.setText(Integer.toString(c2.getEndereco().getId()));
        txtEndereco.setText(c2.getEndereco().getEndereco());
        txtNumero.setText(c2.getEndereco().getNumero());
        txtBairro.setText(c2.getEndereco().getBairro());
        txtCep.setText(c2.getEndereco().getCep());
        txtCidade.setText(c2.getEndereco().getCidade());
        txtComplemento.setText(c2.getEndereco().getComplemento());
        txtUf.setText(c2.getEndereco().getUf());
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
        txtCpf.setText("");
        txtEndereco.setText("");
        txtNome.setText("");
        txtNumero.setText("");
        txtTelefone.setText("");
        txtUf.setText("");
    }
    
}
