package Modelo;
import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class CoordinadorInventario {
	public static Hashtable<String, Habitacion> listaHabitaciones = new Hashtable<String , Habitacion>();
	 File Cuartos= new File("./Proyect1/data/Habitaciones.txt");

	
	public void mostrarMenu() {
		System.out.println("\n1. Crear inventario de Habitaciones \t\t (Si crea un inventario se borra el inventario anterior)"); 
		System.out.println("2. Cargar archivo de Habitaciones"); //ya
		System.out.println("3. Cargar Habitacion Manualmente ");//ya
		System.out.println("4. Actualizar informacion de una Habitacion");//ya 
		System.out.println("5. Cargar tarifa de Tipo de habitacion");
		System.out.println("6. Consultar Inventario");//ya 
		System.out.println("7. Consultar informacion de una Habitacion ");//ya 
		System.out.println("8. Consultar reserva en determinada fecha ");
		System.out.println("9. Volver al menu inicial\n\n");
		
		
		
	}
	
	public void cargarCuartos() {
		try { 
			BufferedReader br = new BufferedReader(new FileReader(Cuartos));
			String linea = br.readLine();
			while (linea!= null) {
				String[] partes = linea.split(";");
				String  numero=partes[0];
				String ubicacion = partes[1];
				int capacidad = Integer.parseInt(partes[2]);
				int camas =Integer.parseInt(partes[3]);
				String tamano= partes[4];
				String tipo= partes[5];
				String extras= partes[6];
				String tarifa = partes[7]; 
				ArrayList<String> TamanosCamas= arreglarTamano(tamano);
				Habitacion nuevo = new Habitacion(numero, ubicacion, capacidad, camas, TamanosCamas, tipo, extras, tarifa);
				listaHabitaciones.put(numero, nuevo);
				linea = br.readLine();
		}
			br.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	private  ArrayList<String> arreglarTamano(String lista) {
		 ArrayList<String> TamanosCamas = new ArrayList<String>();
		 String [] partes= lista.split(",");
		 for (int a =0; a< partes.length; a++) {
			 TamanosCamas.add(partes[a]);	 
		 }
		return TamanosCamas;
		
	}
	public void AgregarCuarto() {
		boolean continuar = true;
		System.out.println("Añadir Cuarto Manualmente");
		while (continuar) {
			System.out.println("Cual es el nombre de la habitacion?");
			 String nombre = input(" ");
			 String ubicacion = input("Cual es la ubicacion de la habitacion?");
			 int capacidad = Integer.parseInt(input("Cual es la capacidad de la habitacion?"));
			 int camas =Integer.parseInt(input("Cuantas camas tiene la habitacion?"));
		 	 String tamano= input("Cual es el tamano de las camas en la habitacion? \n(Si hay mas de una cama porfavor ingresar los tamanos separados por comas, ej Queen,King)");
			 String tipo= input("Cual es el tipo de la habitacion?");
			 String extras= input("Que caracteristicas extra tiene la habitacion?");
			 ArrayList<String> TamanosCamas= arreglarTamano(tamano);
			 String tarifa = input("Cual es la tarifa de la habitacion");
			 Habitacion nuevo = new Habitacion(nombre, ubicacion, capacidad, camas, TamanosCamas, tipo, extras, tarifa);
			 listaHabitaciones.put(nombre, nuevo);
			 continuar=false;
	}
		
		
	}
	public void modificarCuarto() {
		String viejo = input("Cual es el nombre de la habitacion que desea modificar?");
		Habitacion aModificar = listaHabitaciones.get(viejo);
		mostrarHabitacion(aModificar);
		System.out.println(" A continuacion ingrese la nueva infromacion para la habitacion "+aModificar.getNumero());
		
		
	 	String nombre = input("Cual es el nombre de la habitacion? ");
		String ubicacion = input("Cual es la ubicacion de la habitacion?");
		int capacidad = Integer.parseInt(input("Cual es la capacidad de la habitacion?"));
		int camas =Integer.parseInt(input("Cuantas camas tiene la habitacion?"));
	 	String tamano2= input("Cual es el tamano de las camas en la habitacion? \n(Si hay mas de una cama porfavor ingresar los tamanos separados por comas, ej Queen,King)");
		String tipo= input("Cual es el tipo de la habitacion?");
		String extras= input("Que caracteristicas extra tiene la habitacion?");
		ArrayList<String> TamanosCamas2= arreglarTamano(tamano2);
		String tarifa = input ("Cual es la tarifa de la habitacion");
		Habitacion nuevo = new Habitacion(nombre, ubicacion, capacidad, camas, TamanosCamas2, tipo, extras, tarifa);
	 	
	 	listaHabitaciones.remove(viejo);
	 	listaHabitaciones.put(nombre, nuevo);
	 	
	 	
	 	
		
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
	public void consultarInventario() {
	 Set<String> nombres = listaHabitaciones.keySet();
	 Object[] nuevo = nombres.toArray();
	 
	 for ( int a =0 ; a< listaHabitaciones.size(); a++) {
		 System.out.println("\nNombre: "+nuevo[a] +"-------------------------------" );
		 System.out.println("\t\t Ubicacion: "+ listaHabitaciones.get(nuevo[a]).getUbicacion()+ "\n\t\t Capacidad: "+ listaHabitaciones.get(nuevo[a]).getCapacidad() +"\n\t\t Tipo: "+
		 listaHabitaciones.get(nuevo[a]).getTipo()+"\n\t\t Caracteristicas Extra: "+ listaHabitaciones.get(nuevo[a]).getExtra()+"\n\t\t Tarifa: "+ listaHabitaciones.get(nuevo[a]).getTarifa()
		 + "\n\t\t Tamano Camas: "+ listaHabitaciones.get(nuevo[a]).getTamano());
	 }
	
	 }
	public void consultarHabitacion() {
		Habitacion aBuscar = listaHabitaciones.get(input("Cual es el nombre de la habitacion que desea consultar ? "));
		mostrarHabitacion(aBuscar);
		
	}
	private void mostrarHabitacion( Habitacion nombre) {
		System.out.println("Esta es la informacion actual de la habitacion "+nombre.getNumero());
		System.out.println("Nombre: "+nombre.getNumero());
		System.out.println("Ubicacion: "+nombre.getUbicacion());
		System.out.println("Capacidad: "+nombre.getCapacidad());
		System.out.println("Camas: "+nombre.getCamas());
		System.out.println("Tamano camas: "+nombre.getTamano());
		System.out.println("Tipo: "+ nombre.getTipo());
		System.out.println("Caracteristicas Extras:  "+nombre.getExtra());
		System.out.println("Tarifa: "+nombre.getTarifa());
		
	}
		
	public void cargarTarifa() {
		System.out.println("Porfavor seleccione el tipo de cuarto para el cual desea modificar la tarifa");
		System.out.println("1. Estandar \n2. Suite \n3. Suite Doble");
		int tipoACambiar= Integer.parseInt(input("Por favor seleccione una opción:"));
		String tipoFijo;
		while (tipoACambiar > 3 || tipoACambiar <1) {
			tipoACambiar = Integer.parseInt(input("Porfavor ingrese una opcion valida"));
		}
		if (tipoACambiar == 1) {
			tipoFijo ="Estandar";
		}
		else if(tipoACambiar == 2) {
			tipoFijo = "Suite";
		}
		else {
			tipoFijo = "Doble Suite";
		}
		String tarifa = input("Porfavor indique la tarifa que desea aplicar ");
		Set<String> nombres = listaHabitaciones.keySet();
		Object[] nuevo = nombres.toArray();
		for ( int a =0 ; a< listaHabitaciones.size(); a++) {
			if (listaHabitaciones.get(nuevo[a]).getTipo().equals(tipoFijo)) {
				listaHabitaciones.get(nuevo[a]).setTarifa(tarifa);
				listaHabitaciones.replace(listaHabitaciones.get(nuevo[a]).getNumero(), listaHabitaciones.get(nuevo[a]));
				
			}
		}
	}
	
	
	public void escribirArchivo() {
		String data = escribirInventario();

	    try {
	      // Creates a FileWriter
	      FileWriter file = new FileWriter("./Proyect1/data/Inventario.txt");

	      // Creates a BufferedWriter
	      BufferedWriter output = new BufferedWriter(file);

	      // Writes the string to the file
	      output.write(data);

	      // Closes the writer
	      output.close();
	    }

	    catch (Exception e) {
	      e.getStackTrace();
	    }
	}
	private String escribirInventario() {
		String fin="";
		Set<String> nombres = listaHabitaciones.keySet();
		Object[] nuevo = nombres.toArray();
		for (int a =0 ; a < listaHabitaciones.size(); a++) {
			fin+= listaHabitaciones.get(nuevo[a]).getNumero()+ ";" + listaHabitaciones.get(nuevo[a]).getUbicacion()+ ";" +
		Integer.toString(listaHabitaciones.get(nuevo[a]).getCapacidad())+ ";" +Integer.toString(listaHabitaciones.get(nuevo[a]).getCamas())+ ";" +listaHabitaciones.get(nuevo[a]).getTamanoString()+ ";" + listaHabitaciones.get(nuevo[a]).getTipo()+ ";" + listaHabitaciones.get(nuevo[a]).getExtra()+ ";" + listaHabitaciones.get(nuevo[a]).getTarifa()+ "\n";
			
		}
		return fin;
	}
	public void crearInventario() {
		listaHabitaciones.clear();
	}
	public void iniciar() {
		File inventario= new File("./Proyect1/data/Inventario.txt");
		try { 
			BufferedReader br = new BufferedReader(new FileReader(inventario));
			String linea = br.readLine();
			if (linea== null) {
				System.out.println("El inventario esta vacio");
			}
			while (linea!= null) {
				String[] partes = linea.split(";");
				String  numero=partes[0];
				String ubicacion = partes[1];
				int capacidad = Integer.parseInt(partes[2]);
				int camas =Integer.parseInt(partes[3]);
				String tamano= partes[4];
				String tipo= partes[5];
				String extras= partes[6];
				String tarifa = partes[7]; 
				ArrayList<String> TamanosCamas= arreglarTamano(tamano);
				Habitacion nuevo = new Habitacion(numero, ubicacion, capacidad, camas, TamanosCamas, tipo, extras, tarifa);
				listaHabitaciones.put(numero, nuevo);
				linea = br.readLine();
		}
			br.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void vaciarArchico() {
		String data = "";

	    try {
	      // Creates a FileWriter
	      FileWriter file = new FileWriter("./data/Inventario.txt");

	      // Creates a BufferedWriter
	      BufferedWriter output = new BufferedWriter(file);

	      // Writes the string to the file
	      output.write(data);

	      // Closes the writer
	      output.close();
	    }

	    catch (Exception e) {
	      e.getStackTrace();
	    }
	}
}

