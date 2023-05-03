package Modelo;

import java.util.ArrayList;

public class Reserva 
{
	
	private ArrayList<Habitacion> habitacion;
	
	private int CantidadPersonas;

	private Huesped huespedes;
	
	
	
	public void reserva(Huesped huespedes, int CantidadPersonas, Habitacion habitacion)
	{
		this.huespedes = huespedes;
		this.CantidadPersonas = CantidadPersonas;
		this.habitacion = new ArrayList<Habitacion>();
		
	}
	

}

