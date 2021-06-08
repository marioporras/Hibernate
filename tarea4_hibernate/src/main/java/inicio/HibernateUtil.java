package inicio;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.context.internal.ThreadLocalSessionContext;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

     public static SessionFactory sessionFactory;
     public static Session session;

     
     public static Session crearSesion() {
 		StandardServiceRegistry sr = new StandardServiceRegistryBuilder().configure().build();
 		sessionFactory = new MetadataSources(sr).buildMetadata().buildSessionFactory();

 		session = sessionFactory.openSession();
 		return session;
     }
     
     /**
      * Método que cierra una sesión y su sessionFactory
      */
     public static void cerrarSesion() {
    	
    	 if (session!=null) {
    		 session.close();
    	 }
    	 
    	 if ((sessionFactory!=null) && (sessionFactory.isClosed()==false)) {
    		 sessionFactory.close();    		 
    	 }

     }

     
     
     
//     public static synchronized void buildSessionFactory() {
//         if (sessionFactory == null) {
//            Configuration configuration = new Configuration();
//             configuration.configure();
//             configuration.setProperty("hibernate.current_session_context_class", "thread");
//             ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).getBootstrapServiceRegistry();
//             sessionFactory = configuration.buildSessionFactory(serviceRegistry);
//         }
//     }
//
//     public static void openSessionAndBindToThread() {
//         Session session = sessionFactory.openSession();
//         ThreadLocalSessionContext.bind(session);
//     }
//
//
//     public static SessionFactory getSessionFactory() {
//         if (sessionFactory==null)  {
//             buildSessionFactory();
//         }
//         return sessionFactory;
//     }

     
     
//     private static void closeSessionAndUnbindFromThread() {
//         Session session = ThreadLocalSessionContext.unbind(sessionFactory);
//         if (session!=null) {
//             session.close();
//         }
//     }
//
//     private static void closeSessionFactory() {
//         if ((sessionFactory!=null) && (sessionFactory.isClosed()==false)) {
//             sessionFactory.close();
//         }
//     }
 }

