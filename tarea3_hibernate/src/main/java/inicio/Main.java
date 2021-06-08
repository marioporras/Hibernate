package inicio;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import inicio.Correoelectronico;

public class Main {

	public static HibernateUtil hu = new HibernateUtil();

	public static void main(String[] args) {

		// cosas ..
		new Correoelectronico();


		Profesor profesor = new Profesor(7, "Sara", "Barrrera", "Salas");

		Set<Correoelectronico> correosElectronicos = new HashSet<Correoelectronico>();
		correosElectronicos.add(new Correoelectronico(3, "sara@yahoo.com", profesor));
		correosElectronicos.add(new Correoelectronico(2, "sara@hotmail.com", profesor));
		correosElectronicos.add(new Correoelectronico(1, "sara@gmail.com", profesor));

		profesor.setCorreosElectronicos(correosElectronicos);
		Session s = HibernateUtil.crearSesion();
		s.getTransaction().begin();
		s.save(profesor);
		s.getTransaction().commit();
		HibernateUtil.cerrarSesion();

	}

}
