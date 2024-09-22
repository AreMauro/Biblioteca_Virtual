package ClasesDB;

import java.io.File;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class BaseDB {

     private static BaseDB single_instance = null;
     
     private SessionFactory factory;
     

    	 
     private BaseDB()
    	    {
    	 factory = new Configuration().configure().buildSessionFactory();
    	    }
     public SessionFactory getSession() {
    	 
    	 return factory;
     }
     
     
    	    public static synchronized BaseDB getInstance()
    	    {
    	        if (single_instance == null) {
    	        	
    	        	single_instance = new BaseDB();
    	        	
    	        }
    	        return single_instance;
    	    }
	
}
