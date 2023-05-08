package Interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;

public class DialogoIniciarSesion extends JDialog  implements ActionListener
{
	
	private VentanaPrincipal principal;

	public DialogoIniciarSesion(VentanaPrincipal principal) 
	{
		setSize( 500,300 );
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
