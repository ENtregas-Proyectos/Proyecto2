package Interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import Modelo.CoordinadorInventario;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Pantalla_Inventario extends JFrame  {
	private static PanelLogo panelLogo;
	public static CoordinadorInventario Coordinador = new CoordinadorInventario();
	
	
	public Pantalla_Inventario(List<String> respuesta){
		this.setLocationRelativeTo(null);
		this.setSize(new Dimension(1400,500));
		this.getContentPane().setBackground(new Color (244,238,226));
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		PanelLogo(this);
		botones(this, respuesta);
	}
	public void PanelLogo(JFrame frame) {
		//frame.setResizable(false);
		panelLogo= new PanelLogo(frame);
		frame.setLayout(new BorderLayout());
	    frame.add(panelLogo, BorderLayout.NORTH);
	}
	public static void botones (JFrame frame, List<String> respuesta) {
		JPanel base = new JPanel();
		base.setBackground(new Color(244,238,226));
		//base.setPreferredSize(new Dimension(200,200));
		base.setLayout(new FlowLayout());
		base.setVisible(true);
		base.setLayout(new FlowLayout());
		for ( int a =0 ; a< respuesta.size();a++) {
			JLabel label = new JLabel(respuesta.get(a));
			base.add(label);			
		}
		frame.add(base);
		
		
		frame.add(base,BorderLayout.CENTER);
	}
}
