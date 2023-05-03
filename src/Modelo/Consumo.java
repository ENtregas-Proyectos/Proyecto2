package Modelo;

import java.util.ArrayList;
import Modelo.Servicio;

public class Consumo 
{
	
	private String nombre;
	
	private String empleado;
	
	private String srv;
	
	private int precio;
	
	private ArrayList<Consumo> consumos;
	
	private ArrayList<Consumo> serviciosConsumidos;
	
	public Consumo(String nombre, String empleado, String srv,  int precio)
	{
		this.nombre = nombre;
		this.precio= precio;
		this.empleado = empleado;
		this.srv = srv;
		consumos = new ArrayList<Consumo>();
		serviciosConsumidos = new ArrayList<Consumo>();
		
	}
	
	public String getNombre()
	{

		return nombre;
	}
	
	public String getEmpleado()
	{
		return empleado;
	}
	
	public int getPrecio()
	{
		
		return precio;
	}
	
}

