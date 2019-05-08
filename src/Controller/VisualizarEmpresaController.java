package Controller;

import Model.Empresa;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class VisualizarEmpresaController implements Initializable {

  private static Empresa emp2;

    public static Empresa getEmp2() {
        return emp2;
    }

    public static void setEmp2(Empresa emp2) {
        VisualizarEmpresaController.emp2 = emp2;
    }
  
    
    @FXML
    private Label txtNome;

    @FXML
    private Label txtTelefone;

    @FXML
    private Label txtCnpj;

    @FXML
    private Label txtEndereco;

    @FXML
    private Label txtBairro;

    @FXML
    private Label txtCidade;

    @FXML
    private Label txtUf;

    @FXML
    private Label txtComplemento;

    @FXML
    private Label txtNumero;

    @FXML
    private Label txtCep;

    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initEmpresa();
        
    }   
    
    public void initEmpresa(){
        txtNome.setText(emp2.getNome());
        txtTelefone.setText(emp2.getTelefone());
        txtCnpj.setText(emp2.getCnpj());
        txtEndereco.setText(emp2.getEndereco().getEndereco());
        txtBairro.setText(emp2.getEndereco().getBairro());
        txtNumero.setText(emp2.getEndereco().getNumero());
        txtCidade.setText(emp2.getEndereco().getCidade());
        txtComplemento.setText(emp2.getEndereco().getComplemento());
        txtCep.setText(emp2.getEndereco().getCep());
        txtUf.setText(emp2.getEndereco().getUf());
    }
    
}
