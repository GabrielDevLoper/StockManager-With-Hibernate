package ConnectionFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class NewHibernateUtil {

    private SessionFactory connection = getConnection();
    
    public SessionFactory getConnection(){
        Configuration con = new Configuration().configure();
        StandardServiceRegistryBuilder build = new StandardServiceRegistryBuilder().applySettings(con.getProperties());
        return con.buildSessionFactory(build.build());
    }
    
    public Session openSession(){
        return connection.openSession();
    }
    
    public void closeSession(){
        connection.close();
    }
}
