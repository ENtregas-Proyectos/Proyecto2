package Interfaz;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class VentanaPrincipal extends JFrame
{
	
	private PanelLogo panelLogo;
	private PanelUsuarios panelUsuarios;
	
	
	
	public static void main (String[ ] args)
    {
    	
        VentanaPrincipal interfaz= new VentanaPrincipal();
        interfaz.setLocationRelativeTo( null );
        interfaz.setVisible( true );
    }
	
	public VentanaPrincipal()
	{
		
		setSize(900, 500);
		
		setDefaultCloseOperation( DISPOSE_ON_CLOSE );
        setTitle( "LightsOut" );
        setLayout( new BorderLayout( ) );
               
        panelLogo= new PanelLogo(this);
        add(panelLogo, BorderLayout.NORTH);
		
	}
	
	

}
