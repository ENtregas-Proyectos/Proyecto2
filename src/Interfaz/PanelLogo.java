package Interfaz;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelLogo extends JPanel
{
    private JLabel etiquetaImagen;
    private JLabel espacio;
    
    public PanelLogo(VentanaPrincipal ventanaPrincipal)
    {
    	
    	setLayout( new GridLayout( 1,3 ) );
    	
    	espacio = new JLabel();
    	add(espacio);
        etiquetaImagen = new JLabel( );
        add(etiquetaImagen);
        ImageIcon icono= new ImageIcon( ".data/Screenshot 2023-05-02 at 8.26.17 PM.png" );
        etiquetaImagen.setIcon( icono );
        espacio = new JLabel();
    	add(espacio);
    }
}