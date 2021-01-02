package pokemon;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccionMostrar implements ActionListener{
		
		
		public void actionPerformed(ActionEvent e) {
			new PokeWindow().pokeWindow(e.getActionCommand(), 50, 0);
				
		}
		

}
