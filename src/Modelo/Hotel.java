package Modelo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;

public class Hotel 
{
	public CoordinadorInventario inventario = new CoordinadorInventario();
	public CoordinadorDeServicios servicio = new CoordinadorDeServicios();

	public void aplicacionAdministrador() 
	{
		System.out.println("Menu Administrador ");
		iniciarapp();
		boolean continuar= true;
		while (continuar) {
			inventario.mostrarMenu();
			int opcion = Integer.parseInt(input("Por favor seleccione una opción:"));
			if (opcion ==1 ) 
			{
				inventario.vaciarArchico();
				inventario.crearInventario();
			}
			else if (opcion ==2 ) {
				inventario.cargarCuartos();
				inventario.escribirArchivo();
			}
			else if (opcion == 3 ) {
				inventario.AgregarCuarto();
				inventario.escribirArchivo();
			}
			else if (opcion == 4 ) {
				inventario.modificarCuarto();
				inventario.escribirArchivo();
			}
			else if (opcion == 5) {
				inventario.cargarTarifa();
				inventario.escribirArchivo();
			}
			else if (opcion == 6) {
				inventario.consultarInventario();
			}
			else if (opcion == 7 ) {
				inventario.consultarHabitacion( "101");	
			}
			else if (opcion ==8 ) {
				//FALTA ESTO
			}
			else if (opcion==9) {
				continuar = false;
				System.out.println("Saliendo");
			}
		}
	}
	
	public void aplicacionParaServicios() 
	{
		System.out.println("Menu opciones servicios ");
		iniciarappServicio();
		boolean continuar= true;
		while (continuar) {
			servicio.mostrarMenu();
			int opcion = Integer.parseInt(input("Por favor seleccione una opción: "));
			if (opcion ==1 ) {
				servicio.vaciarArchico();
				servicio.crearServicios();
			}
			else if (opcion ==2 ) {
				servicio.cargarServicios();
				servicio.escribirArchivo();
			}
			else if (opcion == 3 ) {
				servicio.AgregarServicio();
				servicio.escribirArchivo();
			}
			else if (opcion == 4 ) {
				servicio.AgregarServicioAHabitacion();
				servicio.escribirArchivo();
			}
			else if (opcion == 5 ) {
				servicio.AgregarServicioAHuesped();
				servicio.escribirArchivo();
			}
			else if (opcion == 6) {
				servicio.RegistrarPago();
				servicio.escribirArchivo();
			}
			else if (opcion == 7 ) {
				servicio.consultarServicios();
			}
			else if (opcion == 8 ) {
				servicio.consultarCuentaHabitacion();	
			}
			else if (opcion == 9 ) {
				servicio.AgregarServicio();	
			}
			else if (opcion==10) {
				continuar = false;
				System.out.println("\n Saliendo");
			}
		}
	}
	
	public void aplicacionRecepcionista() {
		System.out.println("\n*********** MENU RECEPCIONISTA ***********\n ");
		CoordinadorDeReservas coordinadorDeReservas = new CoordinadorDeReservas();
		boolean continuar= true;
		while (continuar) {
			coordinadorDeReservas.mostrarMenuRecepcionista();
			
			int opcion = Integer.parseInt(input("POR FAVOR SELECCIONE UNA OPCION: "));
			if (opcion ==1 ) {
				String nombreHuesped = input("\nNombre Huesped: \n");
				String documentoIdentidad = input("Documento Identidad Huesped: \n");
				String numeroCelular = input("Numero Celular Huesped: \n");
				String correoElectronico = input("Correo Electronico Huesped: \n");
				LocalDate fechaEntrada = LocalDate.parse(input("Ingrese la fecha de entrada en formato Y-M-D (ejemplo 2023-02-01): \n"));
				LocalDate fechaSalida = LocalDate.parse(input("Ingrese la fecha de salida en formato Y-M-D(ejemplo 2023-02-01): \n"));
				int tamanioReserva = Integer.parseInt(input("\nDesea hacer una reserva singular o grupal?\n1. Singular\n2. Grupal\n"));
				if (tamanioReserva == 1) {
					int cantidadPersonas =  Integer.parseInt(input("cantidad personas: \n"));
					Habitacion habitacion = coordinadorDeReservas.encontrarHabitacionReserva(fechaEntrada, fechaSalida, cantidadPersonas);
					coordinadorDeReservas.crearReserva(nombreHuesped,documentoIdentidad,correoElectronico,numeroCelular, cantidadPersonas, habitacion, fechaEntrada, fechaSalida);
				}
				else if(tamanioReserva==2) {
					int numeroHabitaciones = Integer.parseInt(input("Digite el numero de habitaciones: \n"));
					
					for (int i=1;i<=numeroHabitaciones; i++) {
						int cantidadPersonasGrupal =  Integer.parseInt(input("cantidad personas habitacion "+i+": \n"));
						Habitacion habitacion = coordinadorDeReservas.encontrarHabitacionReserva(fechaEntrada, fechaSalida, cantidadPersonasGrupal);
						coordinadorDeReservas.crearReserva(nombreHuesped,documentoIdentidad,correoElectronico,numeroCelular, cantidadPersonasGrupal, habitacion, fechaEntrada, fechaSalida);
					}
					
				}

			}
			else if (opcion ==2 ) {
				String nombreHuesped = input("\nIngrese el nombre del Huesped: ");
				coordinadorDeReservas.mostrarReservasHuesped(nombreHuesped);
				String numeroHabitacion = input("\nIngrese el numero de la habitacion de la reserva a cancelar: ");
				coordinadorDeReservas.cancelarReserva(nombreHuesped, numeroHabitacion);
				
			}
			else if (opcion == 3 ) {
				LocalDate fechaInicio= LocalDate.parse(input("Ingrese la fecha de entrada en el formato Y-M-D"));
				LocalDate fechaFinal= LocalDate.parse(input("Ingrese la fecha de salida en el formato Y-M-D"));
				int cantidadPersonas= Integer.parseInt(input("Ingrese la fecha de entrada en el formato Y-M-D"));
				Habitacion habitacion = coordinadorDeReservas.encontrarHabitacionReserva(fechaInicio, fechaFinal, cantidadPersonas);
				Boolean disponibilidad = coordinadorDeReservas.checkearDisponibilidad(habitacion, fechaInicio, fechaFinal);
				
				if (disponibilidad) {
					System.out.println("Si hay disponibiliodad en la habitacion seleccionada");
				}
				else {
					System.out.println("no hay disponibilidad en la habitacion deseada");
					
				}
			}
			else if (opcion==4) {
				continuar = false;
				System.out.println("\n Saliendo");
			}
		}
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
	public void iniciarapp() 
	{
		
		inventario.iniciar();

	}

	public void iniciarappServicio()
	{
		servicio.iniciar();
	}
	
	
	
}




