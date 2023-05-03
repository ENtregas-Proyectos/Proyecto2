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

	public PanelUsuarios(VentanaPrincipal ventanaPrincipal) 
	{
		setLayout( new GridLayout( 8,1 ) );
        
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
        
        espacio = new JLabel();
        add(espacio);
        
        btnCerrarSesion=new JButton( "CERRAR SESION");
        add(btnCerrarSesion);
        btnCerrarSesion.addActionListener( this );
        
        espacio = new JLabel();
        add(espacio); 

	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource( )==btnInicioSesion)
        {

            nombre = JOptionPane.showInputDialog(this ,"Ingrese su nombre");
            contrasena = JOptionPane.showInputDialog(this ,"Ingrese su Contraseña");


        }
        //else if(e.getSource( )==btnCrearCuenta)
        //{
        //	principal.reiniciar();
        //	int dif = principal.darDificultad();
          //  principal.desordenar();
            //repaint();
      
        //}
        
        //else if(e.getSource()== btnCerrarSesion)
        //{
        //	dialogTop = new JDialog(principal);  
          //  dialogTop.setLocationRelativeTo(principal);
           // listadoNombres = top10.darRegistros();
           // rank10 = new JList();
           // rank10.setBorder(new TitledBorder("Rank"));
           // dialogTop.add(rank10);
           // dialogTop.setSize(400,500);
           // dialogTop.setVisible(true);
   
        	
        //}
		
	}

}
