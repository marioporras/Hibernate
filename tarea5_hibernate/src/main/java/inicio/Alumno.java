package inicio;

public class Alumno {

	private int idAlumno;
	private String apellido;
	private int edad;
	private String nombre;

	public Alumno(int idAlumno, String apellido, int edad, String nombre) {
		super();
		this.idAlumno = idAlumno;
		this.apellido = apellido;
		this.edad = edad;
		this.nombre = nombre;
	}

	public Alumno() {
		// TODO Auto-generated constructor stub
	}

	public int getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(int idAlumno) {
		this.idAlumno = idAlumno;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Alumno [idAlumno=" + idAlumno + ", apellido=" + apellido + ", edad=" + edad + ", nombre=" + nombre
				+ "]";
	}
	
	
}
