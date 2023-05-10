package Interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import Modelo.CoordinadorDeServicios;

public class DialogRealizarPago extends JDialog implements ActionListener
{

	private CoordinadorDeServicios cooServicios;

	public DialogRealizarPago(VentanaPrincipal principal) 
	{
		cooServicios = new CoordinadorDeServicios();
		String nomEmpleado = JOptionPane.showInputDialog("Digite su nombre de empleado: ");
		
		String nomCons = JOptionPane.showInputDialog("Ingrese su login:  ");
		String nomHab = JOptionPane.showInputDialog("Ingrese el num de la habitación o el nombre del huesped:  ");
		int precio =Integer.parseInt( JOptionPane.showInputDialog("Digite el precio a abonar:  "));
		
		cooServicios.RegistrarPago(nomHab, nomEmpleado, nomCons, precio);
	
		
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
		
	}

}
