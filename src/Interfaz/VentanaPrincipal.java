package Interfaz;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;

public class VentanaPrincipal extends JFrame
{
	
	private PanelLogo panelLogo;
	private PanelUsuarios panelCentro;
	private PanelUsuarios panelUsuarios;
	private VentanaPrincipal interfaz;
	
	
	
	public static void main (String[ ] args)
    {
    	
        VentanaPrincipal interfaz= new VentanaPrincipal();
        interfaz.setLocationRelativeTo( null );
        interfaz.getContentPane().setBackground(new Color (244,238,226));
        interfaz.setVisible( true );
    }
	
	public VentanaPrincipal()
	{
		setSize(1400, 500);
		
		//setDefaultCloseOperation( DISPOSE_ON_CLOSE );
		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        setTitle( "PaginaPrincipal" );
        
        setLayout( new BorderLayout( ) );
        
               
        panelLogo= new PanelLogo(interfaz);
        add(panelLogo, BorderLayout.NORTH);
        
        panelCentro = new PanelUsuarios(this);
        add(panelCentro, BorderLayout.CENTER);
		
	}
	
	

}
