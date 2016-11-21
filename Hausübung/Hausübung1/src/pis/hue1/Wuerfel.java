package pis.hue1;

import java.util.ArrayList;

public class Wuerfel implements Codec {
	
	ArrayList<Integer> losungZahlen = new ArrayList<>();
	
	public Wuerfel(){
		
	}
	
	
	public Wuerfel(int minLength) {
		
	}


	public String kodiere(String klartext) {
		
		StringBuffer verschluesselt = new StringBuffer();
		int zeilen = (klartext.length()/losungZahlen.size()) +1;
		int stelle = 0;
		int zahler = 0;
		
		while(stelle < losungZahlen.size()) {
			
			
			if(losungZahlen.get(zahler) == stelle) {
				
				for(int j = 0; zahler + j * losungZahlen.size() < klartext.length(); j++) {
					
					verschluesselt.append(klartext.charAt(zahler + losungZahlen.size() * j));
					
				}
				
				zahler = 0;
				stelle++;
				
			} else
				zahler++;
		}
		
		System.out.println(verschluesselt);
		
		return verschluesselt.toString();
	}


	public String dekodiere(String geheimtext) {
		
		String verschluesselt = geheimtext;
		String entschluesselt = "";
		int stelle = 0;
		int zahler = 0;
		
		while(stelle < losungZahlen.size()) {
			
			if(losungZahlen.get(stelle) == zahler) {
				
				
				
				
			}
			
			
		}
		
		
		
		return entschluesselt;
	}


	public String gibLosung() {
		// TODO Auto-generated method stub
		return null;
	}


	public void setzeLosung(String schluessel) throws IllegalArgumentException {
		
		schluessel = schluessel.toLowerCase();
		
		char[] buchstaben ={'a', 'b', 'c', 'd','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		int zahler = 0;
		
		for(int i=0; i < schluessel.length(); i++) {
			losungZahlen.add(0);
		}
		
		for(int i = 0; i < buchstaben.length; i++) {
			
			for(int j = 0; j < schluessel.length(); j++) {
				
				if(schluessel.charAt(j) == buchstaben[i]) {
					losungZahlen.set(j, zahler);
					zahler++;
				}
				
			}
		}
		System.out.println(losungZahlen.toString());
	}

}
