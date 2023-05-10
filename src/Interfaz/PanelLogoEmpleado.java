package Interfaz;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelLogoEmpleado extends JPanel
{
	private JLabel etiquetaImagen;
    private JLabel espacio;
    private JLabel titulo;
    
    public PanelLogoEmpleado(DialogoEmpleado principal)
    {
    	
    	setLayout( new GridLayout( 1,4 ) );
    	
    	espacio = new JLabel();
        add(espacio);

        etiquetaImagen = new JLabel( );
        ImageIcon icono= new ImageIcon( "./data/Screenshot 2023-05-02 at 8.26.17 PM.png" );
        add(etiquetaImagen);
        etiquetaImagen.setIcon( icono );
        etiquetaImagen.setSize(50,50);
        
        espacio = new JLabel();
        add(espacio);
        
        titulo = new JLabel("EMPLEADO");
        add(titulo);
        
        

    }

}
