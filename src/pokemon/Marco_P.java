package pokemon;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.*;

public class Marco_P extends JFrame {

	private Lamina_B trainerName;
	public Marco_P(){
			
	setTitle("¡Select your pokemon!");
	this.getContentPane().setBackground(Color.white);
	
	setBounds(100,100,400,200);
	
	JPanel lamina_cuadricula=new JPanel();
	
	lamina_cuadricula.setLayout(new BorderLayout());
	
	String [] selectName= {"SQUIRTLE", "CHARMANDER", "BULBASAUR"};
	
	trainerName=new Lamina_B("¡Choose your pokemon!",selectName);
	
	trainerName.setBackground(Color.WHITE);
	
	setLayout(new BorderLayout());
	
	lamina_cuadricula.add(trainerName);
	
	add(lamina_cuadricula, BorderLayout.SOUTH);
	
	}
	
	//------------------------------------------------------------------------------------------

	private class Lamina_B extends JPanel {
		
		
		private JButton btn;
		
		
	public Lamina_B(String titulo,String [] opciones ) {
			
			setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), titulo));
			
			setLayout(new FlowLayout(FlowLayout.CENTER));
			
			for (int i=0;i<opciones.length;i++) {
				
				btn=new JButton(opciones[i]);
				
				btn.setActionCommand(opciones[i]);
				
				btn.addActionListener(new AccionMostrar());
				
				btn.setBackground(Color.WHITE);
			
				add(btn);
				
			}
			
		}

	}
		
}
