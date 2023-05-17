package Interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import Modelo.CoordinadorInventario;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JOptionPane;

public class Principal_admin extends JFrame implements ActionListener{
	public CoordinadorInventario Coordinador = new CoordinadorInventario();
	
	private static PanelLogo panelLogo;
	private static JButton inventario;
	private static  JButton CrearInventario;
	private static JButton CargarArchivo ;
	private static JButton CargarHabitacion;
	private static JButton ActualizarInformacion ;
	private static JButton CargarTarifa ;
	private static JButton ConsultarInventario ;
	private static  JButton ConsultarHabitacion ;
	private static JButton ConsultarReserva ;
	private static JButton Cerrar;
	
	 
		
	public Principal_admin() {
		setLocationRelativeTo(null);
		setTitle("Admin");
		getContentPane().setBackground(new Color (244,238,226));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		setSize(1400,500);
		setBackground(new Color (244,238,226));
		PanelLogo(this);
		botones(this);
		CrearInventario.addActionListener(this);
		CargarArchivo.addActionListener(this);
		CargarHabitacion.addActionListener(this);
		ActualizarInformacion.addActionListener(this);
		CargarTarifa.addActionListener(this);
		ConsultarInventario.addActionListener(this);
		ConsultarHabitacion.addActionListener(this);
		ConsultarReserva.addActionListener(this);
		Cerrar.addActionListener(this);
		Coordinador.iniciar();
	}

	
	public void PanelLogo(JFrame frame) {
		//frame.setResizable(false);
		panelLogo= new PanelLogo(frame);
		frame.setLayout(new BorderLayout());
	    frame.add(panelLogo, BorderLayout.NORTH);
		
	}
	
	public static void botones (JFrame frame) {
		JPanel base = new JPanel();
		base.setBackground(new Color(244,238,226));
		base.setPreferredSize(new Dimension(200,200));
		base.setLayout(new GridLayout(4,2));
		base.setVisible(true);
		
		CrearInventario = new JButton("Crear Inventario de Habitaciones");
		CargarArchivo = new JButton("Cargar archivo de Habitaciones");
		CargarHabitacion = new JButton("Cargar Habitacion Manualmente");
		ActualizarInformacion = new JButton("Actualizar informacion de una habitacion");
		CargarTarifa = new JButton("Cargar tarifa de tipo de Habitacion");
		ConsultarInventario = new JButton("Consultar Inventario");
		ConsultarHabitacion = new JButton("Consultar informacion de una Habitacion");
		ConsultarReserva = new JButton("Consultar reserva en una fecha determinada");
		Cerrar = new JButton ("Cerrar Ventana");
	
		base.add(CrearInventario);
		base.add(CargarArchivo);
		base.add(CargarHabitacion);
		base.add(ActualizarInformacion);
		base.add(CargarTarifa);
		base.add(ConsultarInventario);
		base.add(ConsultarHabitacion);
		base.add(ConsultarReserva);
		base.add(Cerrar);
		frame.add(base, BorderLayout.CENTER);
	}

		
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if ( e.getSource()== CrearInventario) {
			Coordinador.vaciarArchico();
			Coordinador.crearInventario();
			System.out.println("Crear Inventario Listo");
			JOptionPane.showMessageDialog(null, "Inventario creado", "Inventario", JOptionPane.INFORMATION_MESSAGE);
		}
		if ( e.getSource()== CargarArchivo) {
			Coordinador.cargarCuartos();
			Coordinador.escribirArchivo();
			System.out.println("Cargar Archivo Listo ");
			JOptionPane.showMessageDialog(null, "Archivo cargado", "Archivo", JOptionPane.INFORMATION_MESSAGE);
		}
		if ( e.getSource()== CargarHabitacion) {
			Coordinador.AgregarCuarto();
			Coordinador.escribirArchivo();
			System.out.println("Habitacion Cargada");
			JOptionPane.showMessageDialog(null, "Habitacion Cargada", "Habitacion", JOptionPane.INFORMATION_MESSAGE);
		}
		if ( e.getSource()== ActualizarInformacion) {
			Coordinador.modificarCuarto();
			Coordinador.escribirArchivo();
			JOptionPane.showMessageDialog(null, "Habitacion Actualizada", "Habitacion", JOptionPane.INFORMATION_MESSAGE);
			System.out.println("Habitacion Actualizada");
			
		}
		if ( e.getSource()== CargarTarifa) {
			Coordinador.cargarTarifa();
			Coordinador.escribirArchivo();
			System.out.println("Hola");
		}
		if ( e.getSource()== ConsultarInventario) {
			List <String> respuesta = new ArrayList<>();
			respuesta = Coordinador.consultarInventario();
			System.out.println(respuesta.get(0));
			Pantalla_Inventario intento = new  Pantalla_Inventario(respuesta); 
			System.out.println("Hola");
		}
		if ( e.getSource()== ConsultarHabitacion) {
			String cuarto= JOptionPane.showInputDialog(this ,"Ingrese el numero de la Habitacion a consultar");
			System.out.println(cuarto);
			List <String> respuesta= Coordinador.consultarHabitacion(cuarto);
			Pantalla_Habitacion intento = new  Pantalla_Habitacion(respuesta ); 
			
		}
		if ( e.getSource()== ConsultarReserva) {
			System.out.println("Hola");
		}
		if (e.getSource()== Cerrar) {
			this.dispose();
		}
		
		
	}

}
