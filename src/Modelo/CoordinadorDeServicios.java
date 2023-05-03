package Modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;

import Modelo.CatalogoServicios;

public class CoordinadorDeServicios
{
	
	private Hashtable<String, Servicio> listaServicios = new Hashtable<String , Servicio>();
	private Hashtable<String, Consumo> listaConsumos = new Hashtable<String, Consumo>();
	File Servicios= new File("./data/Servicios.txt");
	
	
	public void mostrarMenu() 
	{
		System.out.println("\n1. Crear servicios \t\t (Si crea unos servicios se borra el servicio anterior)"); 
		System.out.println("2. Cargar archivo de Servicios"); 
		System.out.println("3. Agregar servicio de manera manual");
		System.out.println("4. Agregar servicio a una habitación");
		System.out.println("5. Agregar servicio a un huesped"); 
		System.out.println("6. Registrar pago ");
		System.out.println("7. Consultar Servicios");
		System.out.println("8. Consultar cuenta habitacion ");
		System.out.println("9.Salir\n\n");

		
		
		
	}
	
	public void AgregarServicio() 
	{
		boolean continuar = true;
		System.out.println("Añadir servicio de namera manual");
		while (continuar) {
			System.out.println("Digite el nombre del servicio");
			 String nombre = input(" ");
			 int precio = Integer.parseInt(input("Digite el precio del servicio"));
			 Servicio nuevo = new Servicio(nombre, precio);
			 listaServicios.put(nombre, nuevo);
			 continuar=false;
	}
	}
	
	public void cargarServicios() {
		try { 
			BufferedReader br = new BufferedReader(new FileReader(Servicios));
			String linea = br.readLine();
			while (linea!= null) {
				String[] partes = linea.split(";");
				String  nombre=partes[0];
				String precio = partes[1];
				int precioF = Integer.parseInt(precio);
				Servicio nuevo = new Servicio(nombre, precioF);
				listaServicios.put(nombre, nuevo);
				linea = br.readLine();
		}
			br.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	public void AgregarServicioAHabitacion() 
	{
		boolean continuar = true;
		System.out.println("Añadir un servicio a numero de habitacion");
		while (continuar) 
		{
			System.out.println("Cual es el numero de la habitacion?");
			 String nombre = input(" ");
			 String empleado = input("Digite su nombre como empleado registrado en el sistema: ");
			 String srv = input("Digite el nombre del servicio: ");
			 int precio = Integer.parseInt(input("Cual es el precio del servicio?: "));
			 Consumo nuevo = new Consumo(nombre, empleado,srv, precio);
			 listaConsumos.put(nombre, nuevo);
			 String rta = input("Desea realizar su pago en este momento? ");
			 if (rta == "si")
			 {
				 RegistrarPago();
				 
			 }
			 
			 else if(rta == "no")
			 {
				 continuar = false;
			 }
				 
			 
		}
	}
	
	public void AgregarServicioAHuesped() 
	{
		boolean continuar = true;
		System.out.println("Añadir un servicio a nombre de huesped");
		while (continuar) {
			System.out.println("Cual es el nombre del huesped? ");
			 String nombre = input(" ");
			 String empleado = input("Digite su nombre como empleado registrado en el sistema: ");
			 String srv = input("Digite el nombre del servicio: ");
			 int precio = Integer.parseInt(input("Cual es el precio del servicio?: "));
			 Consumo nuevo = new Consumo(nombre, empleado, srv, precio);
			 listaConsumos.put(nombre, nuevo);
			 String rta = input("Desea realizar su pago en este momento? ");
			 if (rta == "si")
			 {
				 RegistrarPago();
				 
			 }
			 
			 else if(rta == "no")
			 {
				 continuar = false;
			 }
			 
	}
	}
	
	public void RegistrarPago()
	{
		boolean continuar = true;
		System.out.println("Añadir un servicio a nombre de huesped");
		while (continuar) {
			System.out.println("Cual es el nombre del huesped? ");
			 String nombre = input(" ");
			 String empleado = input("Digite su nombre como empleado registrado en el sistema: ");
			 String srv = input("Digite el nombre del servicio: ");
			 int precio = Integer.parseInt(input("Cual es el precio del servicio?: "));
			 Consumo nuevo = new Consumo(nombre, empleado, srv, precio);
			 listaConsumos.put(nombre, nuevo);
			 continuar=false;
	}
	}
	
	public void consultarServicios() 
	{
		 Set<String> nombres = listaServicios.keySet();
		 Object[] nuevo = nombres.toArray();
		 
		 for ( int a =0 ; a< listaServicios.size(); a++) 
		 {
			 System.out.println("\nNombre: "+nuevo[a] +"-------------------------------" );
			 System.out.println("\t\t Precio: "+ listaServicios.get(nuevo[a]).getPrecio());
		 }
	}



public void consultarServicio()
{
	Servicio aBuscar = listaServicios.get(input("Cual es el nombre del servicio que desea consultar? "));
	mostrarServicio(aBuscar);
	
}

private void mostrarServicio(Servicio aBuscar) 
{
	System.out.println("El precio del servicio: "+aBuscar.getNombre()+ " es: ");
	System.out.println("Precio: "+aBuscar.getPrecio());

}


public Factura generarFactura(Servicio servicio)
{
	return null;
	
	
}




public void vaciarArchico() {
	String data = "";

    try {
      // Creates a FileWriter
      FileWriter file = new FileWriter("./data/Servicios.txt");

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



public void crearServicios() 
{
	listaServicios.clear();
}




public void escribirArchivo() {
	String data = escribirServicios();

    try {
      // Creates a FileWriter
      FileWriter file = new FileWriter("./data/Servicios.txt");

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

private String escribirServicios() {
	String fin="";
	Set<String> nombres = listaServicios.keySet();
	Object[] nuevo = nombres.toArray();
	for (int a =0 ; a < listaServicios.size(); a++) 
	{
		fin+= listaServicios.get(nuevo[a]).getNombre()+ ";" + listaServicios.get(nuevo[a]).getPrecio()+ "\n";
		
	}
	return fin;
}


public void mostrarConsumo(Consumo aBuscar) 
{
	System.out.println("Los consumos de la habitacion: "+aBuscar.getNombre()+ " son: ");
	System.out.println(aBuscar.getPrecio());

}

public void consultarCuentaHabitacion() 
{
		Consumo aBuscar = listaConsumos.get(input("Cual es el nombre del cuarto que desea consultar? "));
		mostrarConsumo(aBuscar);
		
	
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

public void iniciar() {
	File Servicios= new File("./data/Servicios.txt");
	try { 
		BufferedReader br = new BufferedReader(new FileReader(Servicios));
		String linea = br.readLine();
		if (linea== null) {
			System.out.println("El menú de servicios está vacío");
		}
		while (linea!= null) {
			String[] partes = linea.split(";");
			String  nombre=partes[0];
			String precio = partes[1];
			int precioF = Integer.parseInt(precio);
			Servicio nuevo = new Servicio(nombre, precioF);
			listaServicios.put(nombre, nuevo);
			linea = br.readLine();
	}
		br.close();
	}
	catch (Exception e) {
		e.printStackTrace();
	}
}



}
