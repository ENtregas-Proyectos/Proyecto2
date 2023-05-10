package Modelo;

import java.util.ArrayList;

public class Trabajador implements Empleado

{
	private String login;
	private String nombre;
	private String clave;

	public Trabajador(String nombre, String login,String clave) {
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