package inicio;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class Main {

	//public static HibernateUtil hu = new HibernateUtil();

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		// cosas ..
	 
	
		Session s = HibernateUtil.crearSesion();
		s.getTransaction().begin();
		Query query = s.getNamedQuery("mostrarAlumnos");
		List<Alumno> alumnos = query.list();
		for (Alumno alumno : alumnos) {
		     System.out.println(alumno.toString());
		 }
		s.getTransaction().commit();
		HibernateUtil.cerrarSesion();

	}

}
