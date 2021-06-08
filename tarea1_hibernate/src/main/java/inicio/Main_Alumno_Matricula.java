package inicio;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main_Alumno_Matricula {

	public static void main(String[] args) {

		// SessionFactory. Generador de sesiones
    	StandardServiceRegistry sr = new StandardServiceRegistryBuilder().configure().build();
    	SessionFactory sf = new MetadataSources(sr).buildMetadata().buildSessionFactory();
		
    	// Abro sesión
    	Session session = sf.openSession();
    	
    	// Inicio transacción
    	session.getTransaction().begin();
    	
    	// Creación de objetos simples
    	Alumno alumno1 = new Alumno("Arturo", "McKenzie", 22);

    	    	
    	// Matricula
    	Matricula m = new Matricula();
    	m.setCurso("2DAM");
    	
    	// Asignación bidireccional
    	alumno1.setMatricula(m);
    	m.setAlumno(alumno1);
    	
    	
    	// Guardar objetos en BBDD
    	session.save(alumno1);
    	
    	// Commit transacción
    	session.getTransaction().commit();
    	
    	// Cierro Session y SessionFactory
    	session.close();
    	sf.close();
	}
}
