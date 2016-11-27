package pis.hue1;

import javax.swing.SwingUtilities;

public class Test {

	public static void main(String[] args) {
		
		Wuerfel w1 = new Wuerfel(4);
		Wuerfel w2 = new Wuerfel(4);
		
		CodecGUI GUI = new CodecGUI(w1, w2);
		
		 SwingUtilities.invokeLater (new Runnable()
	      {
	         public void run()
	         {
	        	GUI.createGUI();
	         }
	      });
	}

}