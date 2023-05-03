package Modelo;

import java.util.ArrayList;

public class Servicio 
{
	
	private String nombre;

	private double precio;
	
	private ArrayList<Servicio>servicios;

	public Servicio(String nombre, int precio)
	{
		this.nombre = nombre;
		this.precio= precio;
		this.servicios = new ArrayList<Servicio>();
		
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
