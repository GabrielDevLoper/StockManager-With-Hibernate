package Main;


import GenericDAO.HibernateDAO;
import Model.Cliente;
import Model.Endereco;
import Model.Usuario;
import java.util.List;

public class Adicionar {

    public static void main(String[] args) {
        HibernateDAO cdao = new HibernateDAO();
        
        Endereco end = new Endereco();
        end.setCidade("MACEIO");
        end.setBairro("BENEDITO BENTES");
        end.setRua("GROTA");
        end.setNumero("590");
        end.setComplemento("BIU");
        
        Cliente cli = new Cliente();
        cli.setNome("ANA SANTOS");
        cli.setTelefone("61651");
        cli.setCpf("6666687978");
        cli.setEndereco(end);
        end.setCliente(cli);
        
        cdao.add(cli);
        
       
    }
}