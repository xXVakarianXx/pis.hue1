package pis.hue1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class CodecGUI{

	Codec w1, w2;
	
	CodecGUI(Codec w1, Codec w2) {
		this.w1 = w1;
		this.w2 = w2;
	}
	

	
	class ButtonActionListener implements ActionListener {
		
		JTextField losung1, losung2;
		JTextArea klartext, geheimtext;
		
		ButtonActionListener(JTextField losung1, JTextField losung2, JTextArea klartext, JTextArea geheimtext){
			this.losung1 = losung1;
			this.losung2 = losung2;
			this.klartext = klartext;
			this.geheimtext = geheimtext;
		}
		
		
		@Override
		public void actionPerformed(ActionEvent e) {
			switch(e.getActionCommand()) {
			case "Kodiere":
				w1.setzeLosung(losung1.getText());
				w2.setzeLosung(losung2.getText());
				geheimtext.setText(w2.kodiere(w1.kodiere(klartext.getText())));
				break;
			case "Dekodiere":
				w1.setzeLosung(losung1.getText());
				w2.setzeLosung(losung2.getText());
				klartext.setText(w1.dekodiere(w2.dekodiere(geheimtext.getText())));
				break;
			case "Schließen":
				System.exit(0);
				break;
			}
		}
	}
	
	
	void createGUI() {
		
		JFrame fenster = new JFrame();
		
		fenster.setTitle("Doppelwuerfel");
		fenster.setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
		fenster.setLayout(new BorderLayout());
		
		
		
		JPanel losungPanel= new JPanel();
		losungPanel.setLayout (new BoxLayout (losungPanel, BoxLayout.X_AXIS));
		losungPanel.setBorder (BorderFactory.createTitledBorder ("Losung:"));
		
		JLabel losung1Label = new JLabel ("Losung 1:");
		losungPanel.add(losung1Label);
		
		JTextField losung1 = new JTextField();
		losung1.setFont(new Font("Aerial", Font.PLAIN, 12));
		losung1.setPreferredSize(new Dimension (0, 0));
		losungPanel.add(losung1);
		
		JSeparator separator2 = new JSeparator(SwingConstants.VERTICAL);
		separator2.setPreferredSize(new Dimension(10,20));
		losungPanel.add(separator2);		
		
		JLabel losung2Label = new JLabel ("Losung 2:");
		losungPanel.add(losung2Label);
		
		JTextField losung2 = new JTextField();
		losung2.setFont(new Font("Aerial", Font.PLAIN, 12));
		losung1.setPreferredSize(new Dimension (0, 0));
		losungPanel.add(losung2);
		
		fenster.add(losungPanel, BorderLayout.NORTH);
		
		
		JPanel textPanel = new JPanel();
		textPanel.setLayout (new BoxLayout (textPanel, BoxLayout.X_AXIS));
		textPanel.setBorder(BorderFactory.createTitledBorder("Klartext - Geheimtext:"));
		
		JTextArea klartext = new JTextArea();
		klartext.setLineWrap(true);
		klartext.setFont(new Font("Aerial", Font.PLAIN, 12));
		textPanel.add(klartext);
		
		JSeparator separator1 = new JSeparator (SwingConstants.VERTICAL);
		separator1.setPreferredSize (new Dimension (10,400));
		textPanel.add(separator1);
		
		JTextArea geheimtext = new JTextArea();
		geheimtext.setLineWrap(true);
		geheimtext.setFont(new Font("Aerial", Font.PLAIN, 12));
		textPanel.add(geheimtext);
		
		fenster.add(textPanel, BorderLayout.CENTER);
		
		
		JPanel buttonPanel = new JPanel (new FlowLayout (FlowLayout.RIGHT));
		
		JButton codeButton = new JButton ("Kodiere");
		codeButton.addActionListener(new ButtonActionListener(losung1, losung2, klartext, geheimtext));
		buttonPanel.add(codeButton);
		
		JButton DecodeButton = new JButton ("Dekodiere");
		DecodeButton.addActionListener(new ButtonActionListener(losung1, losung2, klartext, geheimtext));
		buttonPanel.add(DecodeButton);
		
		JButton CloseButton = new JButton ("Schließen");
		CloseButton.addActionListener(new ButtonActionListener(losung1, losung2, klartext, geheimtext));
		buttonPanel.add (CloseButton);
		
		fenster.add (buttonPanel, BorderLayout.SOUTH);
		
		
		fenster.setSize (700, 500);
		fenster.setVisible (true);
		
	}	
	
}