package pis.hue1;

import java.awt.*;
import javax.swing.*;

public class CodecGUI{
	
	static void createGUI() {
		JFrame fenster = new JFrame();
		
		fenster.setTitle("Doppelwuerfel");
		
		fenster.setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
		
		fenster.setLayout(new BorderLayout());
		
		JPanel losungPanel= new JPanel();
		losungPanel.setLayout (new BoxLayout (losungPanel, BoxLayout.X_AXIS));
		losungPanel.setBorder (BorderFactory.createTitledBorder ("Losung:"));
		
		JLabel losung1Label = new JLabel ("Losung 1:");
		losungPanel.add(losung1Label);
		
		JTextArea losung1 = new JTextArea();
		losung1.setLineWrap(false);
		losung1.setFont(new Font("Impact", Font.PLAIN, 12));
		losungPanel.add(losung1);
		
		JSeparator separator2 = new JSeparator(SwingConstants.VERTICAL);
		separator2.setPreferredSize(new Dimension(10,20));
		losungPanel.add(separator2);		
		
		JLabel losung2Label = new JLabel ("Losung 2:");
		losungPanel.add(losung2Label);
		
		JTextArea losung2 = new JTextArea();
		losung2.setLineWrap(false);
		losung2.setFont(new Font("Impact", Font.PLAIN, 12));
		losungPanel.add(losung2);
		
		fenster.add(losungPanel, BorderLayout.NORTH);
		
		JPanel textPanel = new JPanel();
		textPanel.setLayout (new BoxLayout (textPanel, BoxLayout.X_AXIS));
		textPanel.setBorder(BorderFactory.createTitledBorder("Klartext - Geheimtext:"));
		
		JTextArea klartext = new JTextArea();
		klartext.setLineWrap(true);
		klartext.setFont(new Font("Impact", Font.PLAIN, 12));
		textPanel.add(klartext);
		
		
		JSeparator separator1 = new JSeparator (SwingConstants.VERTICAL);
		separator1.setPreferredSize (new Dimension (10,400));
		textPanel.add(separator1);
		
		
		JTextArea geheimtext = new JTextArea();
		geheimtext.setLineWrap(true);
		geheimtext.setFont(new Font("Impact", Font.PLAIN, 12));
		textPanel.add(geheimtext);
		
		fenster.add(textPanel, BorderLayout.CENTER);
		
		
		
		JPanel buttonPanel = new JPanel (new FlowLayout (FlowLayout.RIGHT));
		
		
		JButton CodeButton = new JButton ("Kodiere");
		buttonPanel.add (CodeButton);
		
		JButton DecodeButton = new JButton ("Dekodiere");
		buttonPanel.add(DecodeButton);
		
		JButton CloseButton = new JButton ("Schließen");
		buttonPanel.add (CloseButton);
		
		fenster.add (buttonPanel, BorderLayout.SOUTH);
		
		fenster.setSize (700, 500);
		fenster.setVisible (true);
	}
	
	
}

