package Interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DialogoEmpleado extends JFrame implements ActionListener
{
    private JLabel espacio;
    private JButton btnAnadirConsumo;
    private JButton btnConsultarServicio;
    private JButton btnRealizarPago;
    private JButton btnConsultarConsumo;
    private VentanaPrincipal principal;
	private JLabel etiquetaImagen;
	private JLabel tituloEmpleado;
	private Interfaz.PanelLogo panelLogo;



	public DialogoEmpleado()
    {
		setLocationRelativeTo(principal);
		setTitle("Empleado");
		getContentPane().setBackground(new Color (244,238,226));
		setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
        setSize( 1400,550 );
        setLayout( new GridLayout( 7,1 ) );
        setVisible(true);
        
        PanelLogo(this);
        
        JPanel panelCentro = new JPanel();
		panelCentro.setLayout(new GridLayout(1,9));
		panelCentro.setBackground(new Color (244,238,226));
        
        espacio = new JLabel();
        panelCentro.add(espacio);
        
        btnAnadirConsumo= new JButton("AÑADIR CONSUMO");
        btnAnadirConsumo.addActionListener( this );
        btnAnadirConsumo.setBackground(new Color (244,238,226));
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
        
        espacio = new JLabel();
        panelCentro.add(espacio);
        
        this.add(panelCentro);
        
        
        
        
    }
	
	public void PanelLogo(JFrame frame) {
		//frame.setResizable(false);
		panelLogo= new PanelLogo(frame);
		frame.setLayout(new BorderLayout());
	    frame.add(panelLogo, BorderLayout.NORTH);
		
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
