package Main;


import DAO.HibernateDAO;
import Model.Cliente;
import Model.Endereco;
import Model.Usuario;
import java.util.List;

public class Adicionar {

    public static void main(String[] args) {
        HibernateDAO dao = new HibernateDAO();
        Cliente clie = new Cliente();
        clie.setId(2);
        Endereco end = new Endereco("MACEIO", "SÃO JORGE", "RUA SÃO FLORISVAL", "83", "DE FRENTE AO RACINE", clie);
        dao.add(end);
        
        dao = new HibernateDAO();
        Cliente cli = new Cliente("ANDRE SANTOS", "82981029294", "11306448476", end);
        dao.add(cli);
        
       
       
        
        
        
        
        
     
         
            
            
    }
    
}
