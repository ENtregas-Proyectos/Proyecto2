package Consola;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import Modelo.Administrador;//ESTO
import Modelo.Hotel;//ESTO
import Modelo.Recepcionista;
import Modelo.Trabajador;


public class Aplicacion {
	public Hotel hotel = new Hotel();
	private static ArrayList<Administrador> listaAdministradores= new ArrayList<Administrador>();
	private static ArrayList<Recepcionista> listaRecepcionista= new ArrayList<Recepcionista>();
	private static ArrayList<Trabajador>listaTrabajadores = new ArrayList<Trabajador>();
	
	public static void main(String[] args) {
		Aplicacion consola = new Aplicacion();
		consola.ejecutarAplicacion();
		
	}
	
	public void ejecutarAplicacion() {
		boolean continuar= true;
		 System.out.println("********** BIENVENIDO AL HOTEL! **********\n");
		 while (continuar) {
			 mostrarMenuInicial();
			 int opcion = Integer.parseInt(input("Por favor seleccione una opción:\n"));
			 if (opcion ==1 ) {
				 crearCuenta();
			 }
			 else if (opcion ==2) {
				 iniciarSesion();
			 }
			 else if (opcion ==3 ) {
				 continuar=false;
			 }
		 }
	}

	public void mostrarMenuInicial() {
		System.out.println("\nEn que te podemos ayudar hoy?\n\n1. Crear Cuenta");
		System.out.println("2. Iniciar Sesion");
		System.out.println("3. Cerrar Aplicacion\n"); 
	}
	public void crearCuenta() {
		String nombre = input ("\nIngrese su nombre: \n");
		String login = input ("Ingrese su login: \n");
		String clave = input ("Ingrese su clave: \n");
		System.out.println("\nPorfavor Seleccione el tipo de empleado\n ");
		System.out.println("1. Administrador \n2. Recepcionista \n3. Otro");
		int opcion = Integer.parseInt(input(""));
		if (opcion ==1 ) {
			Administrador nuevo = new Administrador(nombre,login,clave);
			listaAdministradores.add(nuevo);
		}
		else if (opcion ==2 ) {
			Recepcionista nuevo = new Recepcionista(nombre,login,clave);
			listaRecepcionista.add(nuevo);

		}
		else {
			System.out.println("Opcion no valida ");
		}
		
	}
	public void iniciarSesion() {
		boolean encontrado = false;
		System.out.println("\nPorfavor Seleccione el tipo de empleado:\n ");
		System.out.println("1. Administrador \n2. Recepcionista \n3. Otro\n");
		int opcion = Integer.parseInt(input(""));
		String login = input("Ingrese su login:  ");
		String clave = input("Ingrese su clave:  ");
		if (opcion ==1 ) {
			for (int a =0 ; a<listaAdministradores.size();a++) {
				if (listaAdministradores.get(a).getLogin().equals(login) && listaAdministradores.get(a).getClave().equals(clave)) {
					System.out.println("******Bienvenido*****"); 
					encontrado= true;
				}
			}
			if (encontrado ==true) {
				AplicacionAdministrador();
			}
			else {
				System.out.println("\n-----ERROR:NO SE ENCONTRO EL USUARIO-----"); 
				
			}
		}
		else if (opcion ==2) {
			for (int a =0 ; a<listaRecepcionista.size();a++) 
			{
				if (listaRecepcionista.get(a).getLogin().equals(login) && listaRecepcionista.get(a).getClave().equals(clave)) {
					System.out.println("Bienvenido"); 
					encontrado= true;
				}
			}
			if (encontrado ==true) 
			{
				aplicacionRecepcionista();
			}
			else {
				System.out.println("\n-----ERROR:NO SE ENCONTRO EL USUARIO-----"); 
				
			}
			}
		else if (opcion ==3) {
			// LOG IN DE OTROS 
		}
	}
	
	
	public void AplicacionAdministrador() {
		hotel.aplicacionAdministrador();
	}

	public void aplicacionRecepcionista() {
		hotel.aplicacionRecepcionista();
	}
	public void aplicacionParaServicios() 
	{
		hotel.aplicacionParaServicios();
		
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
}
