package Interfaz;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PanelUsuarios extends JPanel implements ActionListener
{
	
	private JLabel etiquetaImagen;
    private JLabel espacio;
	private JButton btnInicioSesion;
	private JButton btnCrearCuenta;
	private JButton btnCerrarSesion;
	private Object nombre;
	private String contrasena;
	private String nombreNuevo;
	private String login;
	private String contrasenaNueva;
	private VentanaPrincipal principal;

	public PanelUsuarios(VentanaPrincipal principal) 
	{
		setLayout( new GridLayout( 7,1 ) );
        
        espacio = new JLabel();
        add(espacio);
        
        btnInicioSesion= new JButton("INICIAR SESION");
        btnInicioSesion.addActionListener( this );
        btnInicioSesion.setBackground(new Color(126, 205, 250));
        add(btnInicioSesion);
        
        espacio = new JLabel();
        add(espacio);
        
        btnCrearCuenta=new JButton( "CREAR NUEVA CUENTA");
        btnCrearCuenta.addActionListener( this );
        add(btnCrearCuenta);
        btnCrearCuenta.setSize(100, 100);
        
        espacio = new JLabel();
        add(espacio);
        
        btnCerrarSesion=new JButton( "CERRAR SESION");
        add(btnCerrarSesion);
        btnCerrarSesion.addActionListener( this );


	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource( )==btnInicioSesion)
        {

            nombre = JOptionPane.showInputDialog(this ,"Ingrese su nombre");
            contrasena = JOptionPane.showInputDialog(this ,"Ingrese su Contraseña");


        }
        else if(e.getSource( )==btnCrearCuenta)
        {
        	
        	DialogoIniciarSesion dialogo= new DialogoIniciarSesion( principal );
            dialogo.setLocationRelativeTo( principal );
            dialogo.setVisible( true );
        	
        
            
           
      
        }
        
        else if(e.getSource()== btnCerrarSesion)
        {
        	
        }
		
	}

}
