package inicio;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
 @Table(name="Profesor")
 public class Profesor implements Serializable  {

     @Id
     @Column(name="Id")
     private int id;

     @Column(name="nombre")
     private String nombre;

     @Column(name="ape1")
     private String ape1;

     @Column(name="ape2")
     private String ape2;

     @OneToMany(mappedBy="profesor",cascade= CascadeType.ALL)
     private Set<Correoelectronico> correosElectronicos;


     public Profesor(){
     }

     public Profesor(int id, String nombre, String ape1, String ape2) {
         this.id = id;
         this.nombre = nombre;
         this.ape1 = ape1;
         this.ape2 = ape2;
     }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApe1() {
		return ape1;
	}

	public void setApe1(String ape1) {
		this.ape1 = ape1;
	}

	public String getApe2() {
		return ape2;
	}

	public void setApe2(String ape2) {
		this.ape2 = ape2;
	}

	public Set<Correoelectronico> getCorreosElectronicos() {
		return correosElectronicos;
	}

	public void setCorreosElectronicos(Set<Correoelectronico> correosElectronicos) {
		this.correosElectronicos = correosElectronicos;
	}

     
     
 }