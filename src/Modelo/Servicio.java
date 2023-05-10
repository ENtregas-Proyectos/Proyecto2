package Modelo;

import java.util.ArrayList;

public class Servicio 
{
	
	private String nombre;

	private double precio;
	

	public Servicio(String nombre, int precio)
	{
		this.nombre = nombre;
		this.precio= precio;
		
	}
	
	public String getNombre()
	{
		return nombre;
	}
	
	public double getPrecio()
	{
		return precio;
		
	}

}
