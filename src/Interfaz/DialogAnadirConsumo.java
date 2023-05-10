package Interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

import Modelo.CoordinadorDeServicios;

public class DialogAnadirConsumo extends JFrame implements ActionListener
{

	private int intSeleccionadoD;
	private int intSeleccionado;
	private JRadioButton opcion1;
	private JRadioButton opcion2;
	private JRadioButton opcionC1;
	private JRadioButton opcionC2;
	private JLabel numHabiLabel;
	private JTextField numHabitacion;
	private JTextField num;
	private JLabel nomHuespedLabel;
	private JTextField nomHuesped;
	private JTextField nom;
	private JLabel servConsumLabel;
	private JTextField servicio;
	private JTextField serv;
	private JLabel precSinIVALAbel;
	private JTextField precSin;
	private JLabel precTotalLabel;
	private JTextField precTotal;
	private JButton btnAnadir;
	private JLabel espacio;
	private CoordinadorDeServicios cooServicios;
	private JLabel nomEmpleadoLabel;
	private JTextComponent nomEmpleado;
	private JLabel momentoLabel;
	private JComponent personaCarga;
	private PanelLogo panelLogo;

	public DialogAnadirConsumo(VentanaPrincipal principal) 
	{
		
		
		cooServicios = new CoordinadorDeServicios();
		setLocationRelativeTo(principal);
		getContentPane().setBackground(new Color (244,238,226));
		setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
		setLayout( new GridLayout( 7,1 ) );
        setSize( 1400,550 );
        setVisible(true);
        
		setLayout( new BorderLayout( ) );
        
		PanelLogo(this);
		
        JPanel panelWest = new JPanel();
        panelWest.setBackground(new Color (244,238,226));
        panelWest.setLayout( new GridLayout( 7,1 ) );		
		
        momentoLabel = new JLabel("En que momento desea realizar el pago? ");
		momentoLabel.setOpaque(true);
		panelWest.add(momentoLabel);
        
		opcion1 = new JRadioButton("Ahora");
		panelWest.add(opcion1);
		
		opcion2 = new JRadioButton("Al momento del check-out");
		panelWest.add(opcion2);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(opcion1);bg.add(opcion2);
		
		personaCarga = new JLabel("A quien(cual cuarto) se añade el servicio? ");
		personaCarga.setOpaque(true);
		panelWest.add(personaCarga);
		
		opcionC1 = new JRadioButton("Huésped");
		panelWest.add(opcionC1);
		
		opcionC2 = new JRadioButton("Habitación");
		panelWest.add(opcionC2);
		
		ButtonGroup bg2 = new ButtonGroup();
		bg2.add(opcionC1);bg2.add(opcionC2);
		
		add(panelWest, BorderLayout.CENTER);
		
		
		JPanel panelEste = new JPanel();
		panelEste.setBackground(new Color (244,238,226));
        panelEste.setLayout( new GridLayout( 12,1 ) );
		
		numHabiLabel = new JLabel("Numero de la habitación: ");
		numHabiLabel.setOpaque(true);
		panelEste.add(numHabiLabel);
		
		num = new JTextField();
		panelEste.add(num);
		
		nomHuespedLabel = new JLabel("Nombre dle huésped: ");
		nomHuespedLabel.setOpaque(true);
		panelEste.add(nomHuespedLabel);
        
		nom = new JTextField();  
		panelEste.add(nom);
        
        servConsumLabel = new JLabel("Servicio a consumir: ");
        servConsumLabel.setOpaque(true);
        panelEste.add(servConsumLabel);
        
		serv = new JTextField();
		panelEste.add(serv);
		
		precSinIVALAbel = new JLabel("Precio sin IVA: ");
		precSinIVALAbel.setOpaque(true);
		panelEste.add(precSinIVALAbel);
		
		precSin= new JTextField();
        panelEste.add(precSin);
		
		precTotalLabel = new JLabel("Precio Total: ");
		precTotalLabel.setOpaque(true);
		panelEste.add(precTotalLabel);
        
        precTotal= new JTextField();
        panelEste.add(precTotal);
		
		nomEmpleadoLabel = new JLabel("Digite su nombre registrado como empleado: ");
		nomEmpleadoLabel.setOpaque(true);
		panelEste.add(nomEmpleadoLabel);
        
        nomEmpleado= new JTextField();
        panelEste.add(nomEmpleado);
        
        add(panelEste, BorderLayout.EAST);
        
        JPanel panelSur = new JPanel();
        panelSur.setBackground(new Color (244,238,226));
		panelSur.setLayout( new GridLayout( 1,3 ) );
    	
    	espacio = new JLabel();
        panelSur.add(espacio);

        btnAnadir = new JButton("Añadir consumo");
        panelSur.add(btnAnadir);
        
        
        espacio = new JLabel();
        panelSur.add(espacio);
		
        add(panelSur, BorderLayout.SOUTH);
	}
	
	public void PanelLogo(JFrame frame) {
		//frame.setResizable(false);
		panelLogo= new PanelLogo(frame);
		frame.setLayout(new BorderLayout());
	    frame.add(panelLogo, BorderLayout.NORTH);
		
	}

	public int darMomentoDePago() 
    {
    	if (opcion1.isSelected()) 
    	{
			intSeleccionado = 1;
		}
    	
    	else
    	{	
    		intSeleccionado = 2;
    	}
    	
    	return intSeleccionado;

	}
	
	
	public int darCargaConsumoA() 
    {
    	if (opcionC1.isSelected()) 
    	{
			intSeleccionadoD = 1;
		}
    	
    	else
    	{	
    		intSeleccionadoD = 2;
    	}
    	
    	return intSeleccionadoD;

	}
	
	public String darNumHabitacion()
	{
		String nomm = num.getText();
		return nomm;
		
	}
	
	public String darNomEmpleado()
	{
		String nomEmp = nomEmpleado.getText();
		return nomEmp;
		
	}
	
	public String darSrv()
	{
		String servi = serv.getText();
		return servi;
		
	}
	
	public int darPrecio()
	{
		String precio = precTotal.getText();
		int prc = Integer.parseInt(precio);
		return prc;
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource( )==btnAnadir)
        {
            int cargaA =darCargaConsumoA();
            int momento = darMomentoDePago();
            String nombre = darNumHabitacion();
            String empleado = darNomEmpleado();
            String srv = darSrv();
            int precio = darPrecio();
            
            
            if (cargaA == 1)
            {
            	cooServicios.AgregarServicioAHuesped(nombre, srv, precio, momento, empleado);
            	
            }
            
            else
            {
            	cooServicios.AgregarServicioAHabitacion(nombre, srv, precio, momento, empleado);
            }
            
            
            this.setVisible (false);
            this.dispose ();
            
            
            
        }
		
		
	}

}
