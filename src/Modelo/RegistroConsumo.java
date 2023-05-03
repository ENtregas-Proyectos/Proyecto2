package Modelo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class RegistroConsumo 
{
	
	private ArrayList<Consumo> consumos;

	private ArrayList<Consumo> pagos;
	private double registroConsumos;
	
	private  String nombre;
	private int numero;

	
	public RegistroConsumo()
	{
		consumos = new ArrayList<Consumo>();
		this.registroConsumos = registroConsumos;
		this.nombre = nombre;
		this.numero = numero;
		pagos = new ArrayList<Consumo>();
	}
	
	
	private ArrayList<Consumo> getConsumosTotales()
	{
		return consumos;
	}
	
	private double getPrecioIVA(double precioInicial)

	{
		
		double precioFinal = precioInicial*0.19;
		
		return precioFinal;
		
	}
	
	private double getPrecioNeto(double precioInicial)
	{
		
		double precioIVA = getPrecioIVA(precioInicial);
		
		double prcFinal = precioIVA+precioInicial;
		
		
		return prcFinal;
	}
	
	public ArrayList<Consumo> getConsumos()
	{
		return consumos;
		
	}
	
	public void agregarPago(Consumo pago)
	{
		pagos.add(pago);
		
	}
	
	
	
	public void generarTextoFactura(String nombreArchivo, double precioInicial)
	{
		try {
			
			
			File file 	= new File(nombreArchivo + "txt");
			
			if (file.createNewFile())
				System.out.println("File created: " + file.getName());
			else
				System.out.println("File already exists.");
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			
			writer.write("Registro Consumo\n");
			writer.write("Número habitación: " + numero);
			writer.write("Nombre: " + nombre);
			double pIVA = getPrecioIVA(precioInicial);
			String precioDelIVA = Double.toString(pIVA);
			writer.write("Precio IVA: " + precioDelIVA);
			double pFinal = getPrecioNeto(precioInicial);
			String precioFinal = Double.toString(pFinal);
			writer.write("Precio total: $"+ precioFinal + "\n");
			writer.close();
			
			}
			catch (IOException e)
			{
				System.out.println("Error writing from the standard input");
				e.printStackTrace();
			}
		
	}
	

}
