package Interfaz;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class DialogoEmpleado extends JDialog implements ActionListener
{
    private JLabel espacio;
    private JButton btnAnadirConsumo;
    private JButton btnConsultarServicio;
    private JButton btnRealizarPago;
    private JButton btnConsultarConsumo;
    private VentanaPrincipal principal;


	public DialogoEmpleado()
    {
        setSize( 500,300 );
        setLayout( new GridLayout( 7,1 ) );
        
        espacio = new JLabel();
        add(espacio);
        
        btnAnadirConsumo= new JButton("AÑADIR CONSUMO");
        btnAnadirConsumo.addActionListener( this );
        btnAnadirConsumo.setBackground(new Color(126, 205, 250));
        add(btnAnadirConsumo);
        
        espacio = new JLabel();
        add(espacio);
        
        btnConsultarServicio=new JButton( "CONSULTAR SERVICIOS");
        btnConsultarServicio.addActionListener( this );
        add(btnConsultarServicio);
        btnConsultarServicio.setSize(100, 100);
        
        espacio = new JLabel();
        add(espacio);
        
        btnRealizarPago=new JButton( "REALIZAR PAGO PENDIENTE");
        add(btnRealizarPago);
        btnRealizarPago.addActionListener( this );
        
        espacio = new JLabel();
        add(espacio);
        
        btnConsultarConsumo=new JButton( "CONSULTAR CONSUMO");
        add(btnConsultarConsumo);
        btnConsultarConsumo.addActionListener( this );
        
        
        
        
    }


    @Override
    public void actionPerformed( ActionEvent e )
    {
    	if(e.getSource( )==btnAnadirConsumo)
        {
    		
    		DialogAnadirConsumo dialogAnadirConsumo = new DialogAnadirConsumo(principal);
    		dialogAnadirConsumo.setLocationRelativeTo(principal);
    		dialogAnadirConsumo.setVisible(true);
    		

           


        }
        else if(e.getSource( )==btnConsultarServicio)
        {
        	
        	DialogoIniciarSesion dialogo= new DialogoIniciarSesion( principal );
            dialogo.setLocationRelativeTo( principal );
            dialogo.setVisible( true );
        	
        
            
           
      
        }
        
        else if(e.getSource()== btnRealizarPago)
        {
        	
        }
    	
        else if(e.getSource() == btnConsultarConsumo)
        {
        	
        }
        
    }
}
