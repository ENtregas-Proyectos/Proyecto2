package Modelo;

import java.time.LocalDate;

public interface IReserva {
	
	public String  getNombreHuesped();
	public Habitacion getHabitacion();
	public LocalDate getFechaInicial();
	public LocalDate getFechaFinal();
	public int getIdreserva();
}
