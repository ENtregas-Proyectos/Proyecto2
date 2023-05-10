package Interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DialogoEmpleado extends JDialog implements ActionListener
{
    private JLabel espacio;
    private JButton btnAnadirConsumo;
    private JButton btnConsultarServicio;
    private JButton btnRealizarPago;
    private JButton btnConsultarConsumo;
    private VentanaPrincipal principal;
	private JLabel etiquetaImagen;
	private JLabel tituloEmpleado;



	public DialogoEmpleado()
    {
        setSize( 500,300 );
        setLayout( new GridLayout( 7,1 ) );
        
        JPanel panelNorte = new JPanel();
		panelNorte.setLayout(new GridLayout(2,3));
        
		espacio = new JLabel();
		panelNorte.add(espacio);

        etiquetaImagen = new JLabel( );
        ImageIcon icono= new ImageIcon( "./data/Screenshot 2023-05-02 at 8.26.17 PM.png" );
        panelNorte.add(etiquetaImagen);
        etiquetaImagen.setSize(50,50);
        etiquetaImagen.setIcon( icono );
        
        
        espacio = new JLabel();
        panelNorte.add(espacio);
        
        espacio = new JLabel();
		panelNorte.add(espacio);

        tituloEmpleado = new JLabel("EMPLEADO");
        panelNorte.add(tituloEmpleado);

        
        espacio = new JLabel();
        panelNorte.add(espacio);
		
        
        
        JPanel panelCentro = new JPanel();
		panelCentro.setLayout(new GridLayout(1,8));
        
        espacio = new JLabel();
        panelCentro.add(espacio);
        
        btnAnadirConsumo= new JButton("AÑADIR CONSUMO");
        btnAnadirConsumo.addActionListener( this );
        btnAnadirConsumo.setBackground(new Color(126, 205, 250));
        panelCentro.add(btnAnadirConsumo);
        
        espacio = new JLabel();
        panelCentro.add(espacio);
        
        btnConsultarServicio=new JButton( "CONSULTAR SERVICIOS");
        btnConsultarServicio.addActionListener( this );
        panelCentro.add(btnConsultarServicio);
        btnConsultarServicio.setSize(100, 100);
        
        espacio = new JLabel();
        panelCentro.add(espacio);
        
        btnRealizarPago=new JButton( "REALIZAR PAGO PENDIENTE");
        panelCentro.add(btnRealizarPago);
        btnRealizarPago.addActionListener( this );
        
        espacio = new JLabel();
        panelCentro.add(espacio);
        
        btnConsultarConsumo=new JButton( "CONSULTAR CONSUMO");
        panelCentro.add(btnConsultarConsumo);
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
        	
        	DilogConsultarServicio dialogConsultarservicio = new DilogConsultarServicio(principal);
        	dialogConsultarservicio.setLocationRelativeTo(principal);
        	dialogConsultarservicio.setVisible( true );
        	
      
        }
        
        else if(e.getSource()== btnRealizarPago)
        {
        	
        	DialogRealizarPago dialogRealizarPago = new DialogRealizarPago(principal);
        	dialogRealizarPago.setLocationRelativeTo(principal);
        	dialogRealizarPago.setVisible( true );
        	
        }
    	
        else if(e.getSource() == btnConsultarConsumo)
        {
        	
        	DialogConsultarConsumo dialogConsultarConsumo = new DialogConsultarConsumo(principal);
        	dialogConsultarConsumo.setLocationRelativeTo(principal);
        	dialogConsultarConsumo.setVisible( true );
        	
        }
        
    }
}
