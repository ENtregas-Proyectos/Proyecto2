package Modelo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class CoordinadorDeReservas {
	
	public Hashtable<String, ArrayList<IReserva>> mapaReservas= new Hashtable<String, ArrayList<IReserva>>();
	
	public void mostrarMenuRecepcionista() {
		System.out.println("1. CREAR NUEVA RESERVA");
		System.out.println("2. CANCELAR RESERVA EXISTENTE");
		System.out.println("3. CHECKEAR DISPONIBILIDAD HABITACION\n");
		System.out.println("4. MENU INICIAL:\n");
	}
	
	public void crearReserva(String nombreHuesped, String documentoIdentidad, String correoElectronico, String numeroCelular, int cantidadPersonas, Habitacion habitacion, LocalDate fechaEntrada, LocalDate fechaSalida) {
		
		ReservaIndividual reserva = new ReservaIndividual(nombreHuesped, documentoIdentidad, correoElectronico, numeroCelular,cantidadPersonas, habitacion,fechaEntrada, fechaSalida);
		String numHabitacion = habitacion.getNumero();
		
		Boolean disponibilidad = checkearDisponibilidad(habitacion, fechaEntrada, fechaSalida);
		if (disponibilidad) {
		
			if (mapaReservas.contains(numHabitacion) == false) {
				ArrayList<IReserva> listaReservasHabitacion= new ArrayList<IReserva>();
				listaReservasHabitacion.add(reserva);
				mapaReservas.put(numHabitacion, listaReservasHabitacion);
				habitacion.blockearDisponibilidad(fechaEntrada, fechaSalida);
				System.out.println("\n********LA RESERVA SE HA GENERADO CON EXITO********\n");
				
			}
			else {
				ArrayList<IReserva> lista = mapaReservas.get(numHabitacion);
				lista.add(reserva);
				mapaReservas.put(numHabitacion, lista);
				habitacion.blockearDisponibilidad(fechaEntrada, fechaSalida);
				System.out.println("\n********LA RESERVA SE HA GENERADO CON EXITO********\n");
			}
		}
		else {
			System.out.println("\nNO hay disponibilidad para esta habitacion en estas fechas");
			
		}
		
	}
	
	public void cancelarReserva(String nombreHuesped, String numeroHabitacion) {
		String nombre = null;
		for (IReserva reserva: (mapaReservas.get(numeroHabitacion)) ) {
			nombre = reserva.getNombreHuesped();
			if (nombre.equals(nombreHuesped)){
				(mapaReservas.get(numeroHabitacion)).remove(reserva);
				Habitacion habitacion = reserva.getHabitacion();
				LocalDate fechaInicio = reserva.getFechaInicial();
				LocalDate fechaFinal = reserva.getFechaFinal();
				habitacion.desbloquearDisponibilidad(fechaInicio, fechaFinal);
				System.out.println("LA RESERVA SE HA CANCELADO CON EXITO/n");
				break;
			}
		}
		if (nombre ==null) {
			System.out.println("NO SE ENCONTRO LA RESERVA/n");
		}
	}
	
	public boolean checkearDisponibilidad(Habitacion habitacion, LocalDate fechaIncio, LocalDate fechaFinal) {
		boolean verificar= habitacion.verificarDisponibilidad(fechaIncio, fechaFinal);
		
		if (verificar == true) {
			return(verificar);
		}
		else {
			return(verificar);
		}
	}
	
	public int getIdReserva(ReservaIndividual reserva) {
		return(reserva.getIdreserva());
	}
	
	public  Habitacion encontrarHabitacionReserva(LocalDate fechaInicial, LocalDate fechaFinal, int numeroPersonas) {
		ArrayList<Habitacion> habitacionesDisponibles = new ArrayList<Habitacion>();
		Hashtable<String, Habitacion> listaHabitaciones= CoordinadorInventario.listaHabitaciones;
		Iterator<Map.Entry<String, Habitacion>> iterator = listaHabitaciones.entrySet().iterator();

		while (iterator.hasNext()) {
		    Entry<String, Habitacion> entry = iterator.next();
		    String key = entry.getKey();
		    Habitacion habitacion = entry.getValue();
		    
		    if (habitacion.getCapacidad() >= numeroPersonas && checkearDisponibilidad(habitacion, fechaInicial, fechaFinal)) {
		    	habitacionesDisponibles.add(habitacion);
		    	}
			}
		for(Habitacion habitacion: habitacionesDisponibles) {
			String numeroHabitacion = habitacion.getNumero();
			String tamanioHabitacion = habitacion.getTamanoString();
			int camasHabitacion = habitacion.getCamas();
			int index = habitacionesDisponibles.indexOf(habitacion);
			int capacidad = habitacion.getCapacidad();
			
			System.out.println(index+". Habitacion numero: "+numeroHabitacion+", tipo: "+tamanioHabitacion+", capacidad: "+capacidad+"\n");
		}
		int seleccion = Integer.parseInt(input("Seleccione la habitacion que desee:\n"));
		Habitacion habitacion = habitacionesDisponibles.get(seleccion);
		return(habitacion);
		
		}
		
	public static String input(String mensaje)
	{
		try
		{
			System.out.print(mensaje );
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		}
		catch (IOException e)
		{
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
		return null;
	}
	
	public void mostrarReservasHuesped(String nombreHuesped) {
		Iterator<Entry<String, ArrayList<IReserva>>> iterator = mapaReservas.entrySet().iterator();
		System.out.println("\nReservas a nombre de: "+nombreHuesped);
		while (iterator.hasNext()) {
		    Entry<String, ArrayList<IReserva>> entry = iterator.next();
		    String key = entry.getKey();
		    ArrayList<IReserva> listaReservasHabitacion = entry.getValue();
		    for (IReserva reserva:listaReservasHabitacion) {
		    	String nombreCheckear=reserva.getNombreHuesped();
		 	    if (nombreCheckear.equals(nombreHuesped)) {
		    	System.out.println("\nHabitacion: "+key);
		    	}
		    }
		 
			}
		
		
	}
}
	

