/*package pokemon;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JButton;

public class Lamina_B extends JPanel {
	
	private ButtonGroup grupo;
	
public Lamina_B(String titulo,String [] opciones ) {
		
		setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), titulo));
		
		setLayout(new FlowLayout(FlowLayout.CENTER));
		
		grupo=new ButtonGroup();
		
		for (int i=0;i<opciones.length;i++) {
			
			JButton btn=new JButton(opciones[i]);
			
			btn.setActionCommand(opciones[i]);
			
			btn.addActionListener(new AccionMostrar);
			
			add(btn);
			
			grupo.add(btn);
			
			btn.setSelected(i==0);
		}
		
	}

public String dameSeleccion() {
	
	return grupo.getSelection().getActionCommand();
}

}*/
