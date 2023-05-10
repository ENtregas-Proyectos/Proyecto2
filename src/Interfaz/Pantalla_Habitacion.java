package Interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Pantalla_Habitacion extends JFrame  {
	private static PanelLogo panelLogo;

	
	public Pantalla_Habitacion(List <String> respuesta){
		this.setLocationRelativeTo(null);
		this.setSize(new Dimension(1400,500));
		this.getContentPane().setBackground(new Color (244,238,226));
		this.setVisible(true);
		PanelLogo(this);
		centro(this, respuesta);
	}
	public void PanelLogo(JFrame frame) {
		//frame.setResizable(false);
		panelLogo= new PanelLogo(frame);
		frame.setLayout(new BorderLayout());
	    frame.add(panelLogo, BorderLayout.NORTH);
	}
	public void centro(JFrame frame,List <String> respuesta) {
		
		JPanel base = new JPanel();
		base.setBackground(new Color(244,238,226));
		base.setSize(new Dimension (200,150));
		base.setLayout(new BorderLayout());
		base.setVisible(true);
		base.setLayout(new BorderLayout());
		
		JLabel label = new JLabel();
		
		ImageIcon imagen ;
		
		imagen = new ImageIcon("./data/Cuarto12.png");
		label.setSize(new Dimension (100,100));
	
		label.setIcon(imagen);
		label.setVisible(true);
		base.add(label,BorderLayout.LINE_START);
		frame.add(base,BorderLayout.LINE_START);
		
		//parte texto
		JPanel base2 = new JPanel();
		base2.setBackground(new Color(244,238,226));
		//base.setSize(new Dimension (300,300));
		base2.setLayout(new GridLayout(7,1));
		base2.setVisible(true);
		
		JLabel label1 = new JLabel (respuesta.get(0));
		JLabel label2 = new JLabel (respuesta.get(1));
		JLabel label3 = new JLabel (respuesta.get(2));
		JLabel label4 = new JLabel (respuesta.get(3));
		JLabel label5 = new JLabel (respuesta.get(4));
		JLabel label6 = new JLabel (respuesta.get(5));
		JLabel label7 = new JLabel (respuesta.get(6));
		JLabel label8 = new JLabel (respuesta.get(7));
		
		base2.add( label1);
		base2.add( label2);
		base2.add( label3);
		base2.add( label4);
		base2.add( label5);
		base2.add( label6);
		base2.add( label7);
		base2.add( label8);
		
		
		frame.add(base2,BorderLayout.CENTER);
		
		
	}
}
