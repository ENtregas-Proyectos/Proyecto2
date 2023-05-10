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

import javax.swing.JOptionPane;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class CoordinadorInventario {
	public static Hashtable<String, Habitacion> listaHabitaciones = new Hashtable<String , Habitacion>();
	 File Cuartos= new File("./data/Habitaciones.txt");

	
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
			 String nombre = JOptionPane.showInputDialog("Ingrese el numero de la Habitacion");
			 String ubicacion = JOptionPane.showInputDialog("Ingrese la ubicacion de la Habitacion: ");
			 int capacidad = Integer.parseInt(JOptionPane.showInputDialog("Cual es la capacidad de la habiatcion :"));
			 int camas =Integer.parseInt(JOptionPane.showInputDialog("Cuantas camas tiene la habitacion: "));
			 String tamano = JOptionPane.showInputDialog("Cual es el tamano de las camas en la habitacion? \n(Si hay mas de una cama porfavor ingresar los tamanos separados por comas, ej Queen,King)");
		 	 String tipo= JOptionPane.showInputDialog("Cual es el tipo de la habitacion?");
			 String extras = JOptionPane.showInputDialog("Que caracteristicas extra tiene la habitacion?");
			 ArrayList<String> TamanosCamas= arreglarTamano(tamano);
			 String tarifa = JOptionPane.showInputDialog("Cual es la tarifa de la habitacion");
			 Habitacion nuevo = new Habitacion(nombre, ubicacion, capacidad, camas, TamanosCamas, tipo, extras, tarifa);
			 listaHabitaciones.put(nombre, nuevo);
			 continuar=false;
			 System.out.print("listo");
			 
			 
			 
			 
			 
		
	}
		
		
	}
	public void modificarCuarto() {
		String viejo = JOptionPane.showInputDialog("Cual es el nombre de la habitacion que desea modificar?");
		Habitacion aModificar = listaHabitaciones.get(viejo);
		mostrarHabitacion(aModificar);
		System.out.println(" A continuacion ingrese la nueva infromacion para la habitacion "+aModificar.getNumero());
		
		
	 	String nombre = JOptionPane.showInputDialog("Cual es el nombre de la habitacion? ");
		String ubicacion = JOptionPane.showInputDialog("Cual es la ubicacion de la habitacion?");
		int capacidad = Integer.parseInt(JOptionPane.showInputDialog("Cual es la capacidad de la habitacion?"));
		int camas =Integer.parseInt(JOptionPane.showInputDialog("Cuantas camas tiene la habitacion?"));
	 	String tamano2= JOptionPane.showInputDialog("Cual es el tamano de las camas en la habitacion? \n(Si hay mas de una cama porfavor ingresar los tamanos separados por comas, ej Queen,King)");
		String tipo= JOptionPane.showInputDialog("Cual es el tipo de la habitacion?");
		String extras= JOptionPane.showInputDialog("Que caracteristicas extra tiene la habitacion?");
		ArrayList<String> TamanosCamas2= arreglarTamano(tamano2);
		String tarifa = JOptionPane.showInputDialog ("Cual es la tarifa de la habitacion");
		Habitacion nuevo = new Habitacion(nombre, ubicacion, capacidad, camas, TamanosCamas2, tipo, extras, tarifa);
	 	
	 	listaHabitaciones.remove(viejo);
	 	listaHabitaciones.put(nombre, nuevo);
	 	System.out.println(listaHabitaciones.get(nombre).getExtra());
	 	
	 	
	 	
		
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
	public  List<String> consultarInventario() {
	 Set<String> nombres = listaHabitaciones.keySet();
	 Object[] nuevo = nombres.toArray();
	 List<String> inventariofinal = new ArrayList<>();
	 
	 for ( int a =0 ; a< listaHabitaciones.size(); a++) {
		 String texto = "\nNombre: "+nuevo[a] +"--------------->";
		 texto += ("\t\t Ubicacion: "+ listaHabitaciones.get(nuevo[a]).getUbicacion()+ "\n\t\t Capacidad: "+ listaHabitaciones.get(nuevo[a]).getCapacidad() +"\n\t\t Tipo: "+
				 listaHabitaciones.get(nuevo[a]).getTipo()+"\n\t\t Caracteristicas Extra: "+ listaHabitaciones.get(nuevo[a]).getExtra()+"\n\t\t Tarifa: "+ listaHabitaciones.get(nuevo[a]).getTarifa()
				 + "\n\t\t Tamano Camas: "+ listaHabitaciones.get(nuevo[a]).getTamano());
		 //System.out.println("\t\t Ubicacion: "+ listaHabitaciones.get(nuevo[a]).getUbicacion()+ "\n\t\t Capacidad: "+ listaHabitaciones.get(nuevo[a]).getCapacidad() +"\n\t\t Tipo: "+
		 //listaHabitaciones.get(nuevo[a]).getTipo()+"\n\t\t Caracteristicas Extra: "+ listaHabitaciones.get(nuevo[a]).getExtra()+"\n\t\t Tarifa: "+ listaHabitaciones.get(nuevo[a]).getTarifa()
		 //+ "\n\t\t Tamano Camas: "+ listaHabitaciones.get(nuevo[a]).getTamano());
		inventariofinal.add(texto);
	 }
	return inventariofinal;
	
	 }
	public List<String> consultarHabitacion(String habitacion) {
		Habitacion aBuscar = listaHabitaciones.get(habitacion);
		System.out.println(aBuscar);
		List<String> respuesta = mostrarHabitacion(aBuscar);
		return respuesta;
		
	}
	private List<String> mostrarHabitacion( Habitacion nombre) {
		List <String> respuesta= new ArrayList <String>();
		
		respuesta.add("Nombre: "+nombre.getNumero()+ "\n");
		respuesta.add("Ubicacion: "+nombre.getUbicacion()+ "\n");
		respuesta.add("Capacidad: "+nombre.getCapacidad()+ "\n");
		respuesta.add("Camas: "+nombre.getCamas()+ "\n");
		respuesta.add("Tamano camas: "+nombre.getTamano()+ "\n");
		respuesta.add("Tipo: "+ nombre.getTipo()+ "\n");
		respuesta.add("Caracteristicas Extras:  "+nombre.getExtra()+ "\n");
		respuesta.add("Tarifa: "+nombre.getTarifa()+ "\n");
		
		return respuesta;
		
	}
		
	public void cargarTarifa() {
		int tipoACambiar = Integer.parseInt(JOptionPane.showInputDialog("Porfavor seleccione el tipo de cuarto para el cual desea modificar la tarifa\n 1. Estandar \\n2. Suite \\n3. Suite Doble "));
		
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
		String tarifa = JOptionPane.showInputDialog("Porfavor indique la tarifa que desea aplicar ");
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
		File inventario= new File("./data/Inventario.txt");
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
		 System.out.print("paso por aca 1");

	    try {
	      // Creates a FileWriter
	      FileWriter file = new FileWriter("./data/Inventario.txt");
	      System.out.print("paso por aca 2");

	      // Creates a BufferedWriter
	      BufferedWriter output = new BufferedWriter(file);
	      System.out.print("paso por aca 3");

	      // Writes the string to the file
	      output.write(data);
	      System.out.print("paso por aca 4");

	      // Closes the writer
	      output.close();
	      System.out.print("paso por aca 5");
	    }

	    catch (Exception e) {
	      e.getStackTrace();
	      System.out.print("CAOS");
	    }
	}
}

