package DAO;

import ConnectionFactory.NewHibernateUtil;
import org.hibernate.SessionFactory;
import Model.Cliente;
import Model.Model;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.Session;

public class HibernateDAO {
    private NewHibernateUtil connection = new NewHibernateUtil();
    private SessionFactory factory = new NewHibernateUtil().getConnection();
    private Session session;
  
    
    public HibernateDAO(){
        session = factory.openSession();
    }
    
    public boolean add(Model c){
        try{
            Transaction tx = session.beginTransaction();
            session.save(c);
            tx.commit();
            return true;
        }catch(Exception e){
            return false;
        }finally{
            closeConnection();
        }
    }
    
    public boolean update(Model c){
       try{
            Transaction tx = session.beginTransaction();
            session.update(c);
            tx.commit();
            return true;
        }catch(Exception e){
            return false;
        }finally{
            closeConnection();
        }
    }
    
    public boolean delete(Model c){
        try{
            Transaction tx = session.beginTransaction();
            session.delete(c);
            tx.commit();
            return true;
        }catch(Exception e){
            return false;
        }finally{
            closeConnection();
        }
    }
    
    public <T extends Model> List<T> getList(String table) {
        try{
            Transaction tx = session.beginTransaction();
            Query query = session.createQuery("FROM " + table);
            List<T> list = query.list();
            tx.commit();
            return list;
        }catch(Exception e){
            return null;
        }finally{
            closeConnection();
        }
    }
    
    public void closeConnection(){
        session.close();
        connection.closeSession();
    }
    
}
