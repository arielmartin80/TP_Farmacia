package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class Farmacia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	private String telefono;
	private String diaDeTurno;

	@OneToOne @Cascade({CascadeType.ALL})
	private Direccion direccion;
	
	@OneToOne
	private Punto punto;
	
	public Punto getGeoLocalizacion() {
		return punto;
	}

	public void setGeoLocalizacion(Punto punto) {
		this.punto = punto;
	}
	
	public void setGeoLocalizacion(String latitud, String longitud) {
		this.punto.setLatitud(latitud);
		this.punto.setLongitud(longitud);
	}

	public Farmacia(String nombre,String diaDeTurno) {
		this.nombre=nombre;
		this.diaDeTurno=diaDeTurno;
	}
	
	public Farmacia(Direccion direccion) {
		this.direccion=direccion;
	}
	
	public Farmacia() {
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDiaDeTurno() {
		return diaDeTurno;
	}
	public void setDiaDeTurno(String diaDeTurno) {
		this.diaDeTurno = diaDeTurno;
	}

	public Direccion getDireccion() {
		return direccion;
	}
	
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
		
	}
	
	
	
	
}
