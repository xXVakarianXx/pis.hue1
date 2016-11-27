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
		StringBuffer entschluesselt = new StringBuffer(geheimtext);
		
		
		
		
		return entschluesselt.toString();
		
	}


	public String gibLosung() {
		// TODO Auto-generated method stub
		return null;
	}


	public void setzeLosung(String schluessel) throws IllegalArgumentException {
		
		schluessel = schluessel.toLowerCase();
		losungZahlen.clear();
		
		char[] buchstaben ={'a', 'b', 'c', 'd','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','0','1','2','3','4','5','6','7','8','9',' ','.','!','?'};
		int zahler = 0;
		
		if(schluessel.length() < 4) {
			throw new IllegalArgumentException();
		}
			
		
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
