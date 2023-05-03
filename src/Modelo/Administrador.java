package Modelo;

public class Administrador implements Empleado

{
	private String login;
	private String nombre;
	private String clave;

	public Administrador(String nombre, String login,String clave) {
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
	@Override
	public String darNombre() {
		// TODO Auto-generated method stub
		return(nombre);
	}

}
