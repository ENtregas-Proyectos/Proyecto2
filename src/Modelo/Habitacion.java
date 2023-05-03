
package Modelo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Habitacion 
{	
	private double registroConsumos;
	private  String nombre;
	private int camas;
	private String ubicacion;
	private int capacidad;
	private ArrayList<String> Tamano;
	private String tipo;
	private String Extra; 
	private String tarifa;
	private Map<LocalDate, Boolean> availability = new HashMap<>();
	
	public Habitacion (String nombre,String ubicacion, int capacidad, int camas, ArrayList<String> Tamano, String tipo, String Extra, String tarifa)
	{
		this.nombre = nombre;
		this.ubicacion = ubicacion;
		this.capacidad=capacidad;
		this.camas = camas;
		this.Tamano=Tamano;
		this.tipo=tipo;
		this.Extra=Extra;
		this.tarifa=tarifa;
		LocalDate date = LocalDate.now();
		for (int i = 0; i < 730; i++) {
            availability.put(date.plusDays(i), true);
        }
	}
	
	
	public String getNumero()
	{
		return nombre;
	}
	
	public int getCapacidad()
	{
		return capacidad;
	}
	public int getCamas()
	{
		return camas;
	}
	public ArrayList<String> getTamano(){
		return Tamano; 
	}
	
	public String getUbicacion()
	{
		return ubicacion;
	}
	public String getTipo()
	{
		return tipo;
	}
	public String getExtra()
	{
		return Extra;
	}
	public String getTarifa() {
		return tarifa;
	}
	public String getTamanoString() {
		String tamanos="";
		if (Tamano.size()>1) {
			for (int a =0; a< Tamano.size();a++) {
			tamanos+= Tamano.get(a)+",";
			}
		}
		else {
			tamanos= Tamano.get(0);
		}
		
		return tamanos;
	}
	
	public void setTarifa(String nuevo) {
		tarifa=nuevo;
	}
	public void setnombre(String nuevo) {
		nombre=nuevo;
	}
	public void setcapacidad(int nuevo) {
		capacidad=nuevo;
	}
	public void setubicacion(String nuevo) {
		ubicacion=nuevo;
	}
	public void setCamas(int nuevo) {
		camas=nuevo;
	}
	public void setTamano(ArrayList<String> nuevo) {
		Tamano=nuevo;
	}
	public void setTipo(String nuevo) {
		tipo=nuevo;
	}
	public void setExtra(String nuevo) {
		Extra=nuevo;
	}
	
	private double getConsumos()
	{
		return registroConsumos;
	}
	
	public boolean verificarDisponibilidad(LocalDate startDate, LocalDate endDate) {
        for (LocalDate date = startDate; date.isBefore(endDate); date = date.plusDays(1)) {
            if (!availability.get(date)) {
                return false;
            }
        }
        return true;
    }
	
	public void blockearDisponibilidad(LocalDate fechaInicial, LocalDate fechaFinal) {
        for (LocalDate date = fechaInicial; date.isBefore(fechaFinal); date = date.plusDays(1)) {
            availability.put(date, false);
        }
    }
	
	public void desbloquearDisponibilidad(LocalDate fechaInicial, LocalDate fechaFinal) {
        for (LocalDate date = fechaInicial; date.isBefore(fechaFinal); date = date.plusDays(1)) {
            availability.put(date, true);
        }
    }
	
	
}
