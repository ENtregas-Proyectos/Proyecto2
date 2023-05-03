package Interfaz;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelUsuarios extends JPanel implements ActionListener
{
	
	private JLabel etiquetaImagen;
    private JLabel espacio;
	private JButton btnNuevo;
	private JButton btnReiniciar;
	private JButton btnTop10;
	private JButton btnCambiarJ;

	public PanelUsuarios(VentanaPrincipal ventanaPrincipal) 
	{
		setLayout( new GridLayout( 8,1 ) );
        
        espacio = new JLabel();
        add(espacio);
        
        btnNuevo= new JButton("INICIAR SESION");
        btnNuevo.addActionListener( this );
        btnNuevo.setBackground(new Color(126, 205, 250));
        add(btnNuevo);
        
        espacio = new JLabel();
        add(espacio);
        
        btnReiniciar=new JButton( "CREAR NUEVA CUENTA");
        btnReiniciar.addActionListener( this );
        add(btnReiniciar);
        
        espacio = new JLabel();
        add(espacio);
        
        btnTop10=new JButton( "CERRAR SESION");
        add(btnTop10);
        btnTop10.addActionListener( this );
        
        espacio = new JLabel();
        add(espacio); 

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
