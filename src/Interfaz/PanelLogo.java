package Interfaz;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelLogo extends JPanel
{
    private JLabel etiquetaImagen;
    private JLabel espacio;
    
    public PanelLogo(JFrame frame)
    {
    	setBackground(new Color (244,238,226));
    	setLayout( new GridLayout( 1,3 ) );
    	
    	espacio = new JLabel();
        add(espacio);
        

        etiquetaImagen = new JLabel( );
        ImageIcon icono= new ImageIcon( "./data/Screenshot 2023-05-02 at 8.26.17 PM.png" );
        add(etiquetaImagen);
        etiquetaImagen.setIcon( icono );
        etiquetaImagen.setSize(50,50);
        
        
        espacio = new JLabel();
        add(espacio);

    }
}