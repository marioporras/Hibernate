package inicio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main {

	private static ArrayList<Superusuario> superusuarios = new ArrayList<Superusuario>();

	public static void main(String[] args) throws IOException {

		StandardServiceRegistry sr = new StandardServiceRegistryBuilder().configure().build();
		SessionFactory sf = new MetadataSources(sr).buildMetadata().buildSessionFactory();

		Session sesion = sf.openSession();

		// Creo mi Arraylist de superusuarios
		crearTablaSuperusuarios("C:\\Users\\mario\\Downloads\\Alumnado_nuevo (1).txt");
		// Inicio transacción
		sesion.getTransaction().begin();

		for (Superusuario superusuario : superusuarios) {
			sesion.save(superusuario);
		}
		// Commit transacción
		sesion.getTransaction().commit();

		// Cierro Session y SessionFactory
		sesion.close();
		sf.close();
	}

	/**
	 * El método creará una tabla llamada “Superusuarios” en la base de datos, y
	 * añadirá el contenido de ese fichero a la tabla.
	 * 
	 * @param fichero
	 * @throws IOException
	 */
	public static void crearTablaSuperusuarios(String fichero) throws IOException {

		String linea;
		try {
			BufferedReader br = new BufferedReader(new FileReader(fichero));

			while ((linea = br.readLine()) != null) {
				String[] campos = linea.split(",");
				String linea1 = campos[0];
				String linea2 = campos[1];
				String linea3 = campoUser(linea2, linea1);
				// String linea4 = campos[3];

				Superusuario supu = new Superusuario(linea2, linea1, linea3);
				superusuarios.add(supu);

			}
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Devuelve el campo user
	 * @param nombre
	 * @param apellidos
	 * @return
	 */
	public static String campoUser(String nombre, String apellidos) {
		return "2DAM" + nombre.charAt(1) + apellidos.charAt(0);

	}
}
