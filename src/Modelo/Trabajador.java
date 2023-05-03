package Modelo;

import java.util.ArrayList;

public class Trabajador 

{
	private String nombre;
	private String login;
	private String clave;
	private ArrayList<Consumo> serviciosConsumidos;
	
	public Trabajador(String nombre, String login, String clave)
	{
		
		this.clave = clave;
		this.login = login;
		this.nombre=nombre; 
	}
	
	public void ingresarConsumo(Consumo consumo)
	{
		serviciosConsumidos.add(consumo);
		
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