package Modelo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Modelo.Hotel;

public class Aplicacion 

{
	
		
		private static Hotel hotel;
		
		
		public static void main(String[] args) 
		{
			hotel = new Hotel();


		}




public static String input(String mensaje)
{
	try
	{
		System.out.print(mensaje + ": ");
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