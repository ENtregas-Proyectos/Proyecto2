package Modelo;

public class Recepcionista {
	private String login;
	private String nombre;
	private String clave;

	public Recepcionista(String nombre, String login,String clave) {
		this.nombre=nombre;
		this.login=login;
		this.clave=clave;
	}
	
	public String getLogin() {
		return(login);
	}
	public String getClave() {
		return(clave);
	}
	public String getNombre() {
		return(nombre);
	}

}
