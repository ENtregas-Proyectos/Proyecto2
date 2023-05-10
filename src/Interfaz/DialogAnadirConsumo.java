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
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

import Modelo.CoordinadorDeServicios;

public class DialogAnadirConsumo extends JDialog implements ActionListener
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

	public DialogAnadirConsumo(VentanaPrincipal principal) 
	{
		setSize( 500,300 );
		setLayout( new BorderLayout( ) );
        
		JPanel panelNorte = new JPanel();
		panelNorte.setLayout(new GridLayout(1,2));
		
		
        JPanel panelWest = new JPanel();

        panelWest.setLayout( new GridLayout( 1,3 ) );		
		
		opcion1 = new JRadioButton("Ahora");
		panelWest.add(opcion1);
		
		opcion2 = new JRadioButton("Al momento del check-out");
		panelWest.add(opcion2);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(opcion1);bg.add(opcion2);
		
		opcionC1 = new JRadioButton("Huésped");
		add(opcionC1);
		
		opcionC2 = new JRadioButton("Habitación");
		add(opcionC2);
		
		ButtonGroup bg2 = new ButtonGroup();
		bg2.add(opcionC1);bg2.add(opcionC2);
		
		add(panelWest, BorderLayout.WEST);
		
		
		JPanel panelEste = new JPanel();
        panelEste.setLayout( new GridLayout( 12,1 ) );
		
		numHabiLabel = new JLabel("Numero de la habitación: ");
		numHabiLabel.setOpaque(true);
		panelEste.add(numHabiLabel);
		
		num = new JTextField();
		panelEste.add(num);
		
		nomHuespedLabel = new JLabel("Numero de la habitación: ");
		nomHuespedLabel.setOpaque(true);
		panelEste.add(nomHuespedLabel);
        
		nom = new JTextField();  
		panelEste.add(nom);
        
        servConsumLabel = new JLabel("Numero de la habitación: ");
        servConsumLabel.setOpaque(true);
        panelEste.add(servConsumLabel);
        
		serv = new JTextField();
		panelEste.add(serv);
		
		precSinIVALAbel = new JLabel("Numero de la habitación: ");
		precSinIVALAbel.setOpaque(true);
		panelEste.add(precSinIVALAbel);
		
		precSin= new JTextField();
        panelEste.add(precSin);
		
		precTotalLabel = new JLabel("Numero de la habitación: ");
		precTotalLabel.setOpaque(true);
		panelEste.add(precTotalLabel);
        
        precTotal= new JTextField();
        panelEste.add(precTotal);
		
		nomEmpleadoLabel = new JLabel("Digite su nombre registrado como empleado: ");
		nomEmpleadoLabel.setOpaque(true);
		panelEste.add(nomEmpleadoLabel);
        
        nomEmpleado= new JTextField();
        panelEste.add(nomEmpleado);
		
		
        JPanel panelSur = new JPanel();
		panelSur.setLayout( new GridLayout( 1,3 ) );
    	
    	espacio = new JLabel();
        panelSur.add(espacio);

        btnAnadir = new JButton("Añadir consumo");
        panelSur.add(btnAnadir);
        
        
        espacio = new JLabel();
        panelSur.add(espacio);
		
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
            
            
            
        }
		
		
	}

}
