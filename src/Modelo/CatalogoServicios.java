package Modelo;

import java.util.ArrayList;

public class CatalogoServicios 
{
	
	private ArrayList<Servicio>servicios;
	
	private ArrayList<Consumo> serviciosConsumidos;
	
	public CatalogoServicios()
	{
		servicios = new ArrayList<Servicio>();
		serviciosConsumidos = new ArrayList<Consumo>();
		
	}
	
	public ArrayList<Servicio> getCatalogo()
	{
		return servicios;
		
	}
	
	public void agregarServicio(Servicio servicio)
	{
		servicios.add(servicio);
		
	}

	
	
	
}
