package Main;


import DAO.HibernateDAO;
import Model.Cliente;
import Model.Endereco;
import Model.Usuario;
import java.util.List;

public class Adicionar {

    public static void main(String[] args) {
        HibernateDAO cdao = new HibernateDAO();
        
        Endereco end = new Endereco();
        end.setCidade("MACEIO");
        end.setBairro("SÃO JORGE");
        end.setRua("JOAO MARIA");
        end.setNumero("590");
        end.setComplemento("RACINE");
        
        Cliente cli = new Cliente();
        cli.setNome("ANDRE SANTOS");
        cli.setTelefone("55555");
        cli.setCpf("66666");
        cli.setEndereco(end);
        end.setCliente(cli);
        
        cdao.add(cli);
        
       
    }
}