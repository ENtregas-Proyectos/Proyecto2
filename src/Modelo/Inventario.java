package Modelo;

import java.util.ArrayList;

public class Inventario {

	
	private ArrayList<Habitacion> habitaciones;
	
	
	public Inventario()
	{
		habitaciones = new ArrayList<Habitacion>();
	}
	
		
	
	public ArrayList<Habitacion> getHabitacion()
	{
		
		return habitaciones;
	}
	
	
}
