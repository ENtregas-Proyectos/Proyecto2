package Modelo;

import java.time.LocalDate;
import java.util.ArrayList;

public class ReservaIndividual implements IReserva
{
	public String nombreHuesped;
	public String documentoIdentidad;
	public String correoElectronico;
	public String numeroCelular;
	public int cantidadPersonas;
	public Habitacion habitacion;
	public LocalDate fechaEntrada;
	public LocalDate fechaSalida; 
	public static int idReserva = 0;
	
	
	public ReservaIndividual(String nombreHuesped, String documentoIdentidad, String correoElectronico, String numeroCelular, int cantidadPersonas, Habitacion habitacion, LocalDate fechaEntrada, LocalDate fechaSalida)
	{
		this.nombreHuesped = nombreHuesped;
		this.documentoIdentidad = documentoIdentidad;
		this.correoElectronico = correoElectronico;
		this.numeroCelular = numeroCelular;
		this.cantidadPersonas = cantidadPersonas;
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida; 
		idReserva=idReserva+1;
	}
	
	public String  getNombreHuesped() {
		return (nombreHuesped);
		}
	public Habitacion getHabitacion() {
		return(habitacion);
	}
	
	public LocalDate getFechaInicial() {
		return(fechaEntrada);
	}
	public LocalDate getFechaFinal() {
		return(fechaSalida);
	}

	public int getIdreserva() {
		return(idReserva);
	}

}

