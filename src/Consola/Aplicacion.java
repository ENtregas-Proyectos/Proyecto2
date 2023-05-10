package Consola;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Interfaz.Pantalla_Habitacion;
import Interfaz.Principal_admin;
import Modelo.Administrador;//ESTO
import Modelo.CoordinadorInventario;
import Modelo.Hotel;//ESTO
import Modelo.Recepcionista;
import Modelo.Trabajador;
import Interfaz.VentanaPrincipal;


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
		String nombre2 = JOptionPane.showInputDialog(this ,"Ingrese su nombre");
    	String login2 = JOptionPane.showInputDialog(this ,"Ingrese su login");
        String contrasena2 = JOptionPane.showInputDialog(this ,"Ingrese su Contraseña");
		int opcion = Integer.parseInt(JOptionPane.showInputDialog("Porfavor Seleccione el tipo de empleado\n 1. Administrador \\n2. Recepcionista \\n3. Otro "));
		
		if (opcion ==1 ) {
			Administrador nuevo = new Administrador(nombre2,login2,contrasena2);
			listaAdministradores.add(nuevo);
		}
		else if (opcion ==2 ) {
			Recepcionista nuevo = new Recepcionista(nombre2,login2,contrasena2);
			listaRecepcionista.add(nuevo);

		}
		else {
			JOptionPane.showMessageDialog(null, "Archivo cargado", "Archivo", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	public void iniciarSesion() {
		boolean encontrado = false;
		int opcion =Integer.parseInt( JOptionPane.showInputDialog("Porfavor Seleccione el tipo de empleado: \n1. Administrador 2. Recepcionista 3. Otro "));
		
		String login = JOptionPane.showInputDialog("Ingrese su login:  ");
		String clave = JOptionPane.showInputDialog("Ingrese su clave:  ");
		if (opcion ==1 ) {
			for (int a =0 ; a<listaAdministradores.size();a++) {
				if (listaAdministradores.get(a).getLogin().equals(login) && listaAdministradores.get(a).getClave().equals(clave)) {
					
					encontrado= true;
				}
			}
			if (encontrado ==true) {
				Principal_admin intento = new  Principal_admin(); 
				//AplicacionAdministrador();
			}
			else {
				JOptionPane.showMessageDialog(null, "No se encontro el usuario", "ERROR", JOptionPane.INFORMATION_MESSAGE);
	
				
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