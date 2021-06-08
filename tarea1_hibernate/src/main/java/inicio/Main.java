package inicio;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main {

	public static void main(String[] args) {

    	StandardServiceRegistry sr = new StandardServiceRegistryBuilder().configure().build();
    	SessionFactory sf = new MetadataSources(sr).buildMetadata().buildSessionFactory();
		
    	Session sesion = sf.openSession();
    	
    	// Inicio transacción
    	sesion.getTransaction().begin();
    	
    	Alumno alumno1 = new Alumno("Mario", "Perez", 44);
    	Alumno alumno2 = new Alumno("Arturo", "McKenzie", 44);
    	
    	// Guardar objetos en BBDD
    	sesion.save(alumno1);
    	sesion.save(alumno2);
    	
    	// Commit transacción
    	sesion.getTransaction().commit();
    	
    	// Cierro Session y SessionFactory
    	sesion.close();
    	sf.close();
	}
}
