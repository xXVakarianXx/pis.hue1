package pis.hue1;

import java.util.ArrayList;

public class Wuerfel implements Codec {

	ArrayList<Integer> losungZahlen = new ArrayList<>();
	int minLengthLosung;
	int klartextLenght;

	public Wuerfel() {

	}

	public Wuerfel(int minLength) {
		
		minLengthLosung = minLength;

	}

	public String kodiere(String klartext) {

		klartextLenght = klartext.length();
		StringBuffer verschluesselt = new StringBuffer();
		int stelle = 1;
		int zahler = 0;

		while (stelle < losungZahlen.size() + 1) {

			if (losungZahlen.get(zahler) == stelle) {

				for (int j = 0; zahler + j * losungZahlen.size() < klartext.length(); j++) {

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
		
		//char[] buchstaben = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r','s', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', ' ', '.', '!','?' };
		char[] geheimtextChar = geheimtext.toCharArray();
		StringBuffer entschluesselt = new StringBuffer(geheimtext);
		int stelleLW = 0;
		int stelleGT = 0;
		int i = 1;
		
		while(i <= losungZahlen.size()) {

			if (losungZahlen.get(stelleLW) == i) {
				
				for(int z = 0; stelleLW + z*losungZahlen.size() < entschluesselt.length(); z++) {
					entschluesselt.setCharAt(stelleLW + losungZahlen.size() * z, geheimtextChar[stelleGT]);
					stelleGT += 1;
				}
				i++;
				stelleLW = 0;
		
			} else stelleLW++;
		}
		

	return entschluesselt.toString();

	}

	public String gibLosung() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setzeLosung(String schluessel) throws IllegalArgumentException {

		schluessel = schluessel.toLowerCase();
		losungZahlen.clear();

		char[] buchstaben = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r','s', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', ' ', '.', '!','?' };
		int zahler = 1;

		if (schluessel.length() < minLengthLosung || schluessel.length() > klartextLenght) {
			throw new IllegalArgumentException();
		}

		for (int i = 0; i < schluessel.length(); i++) {
			losungZahlen.add(0);
		}

		for (int i = 0; i < buchstaben.length; i++) {

			for (int j = 0; j < schluessel.length(); j++) {

				if (schluessel.charAt(j) == buchstaben[i]) {
					losungZahlen.set(j, zahler);
					zahler++;
				}

			}
		}
		System.out.println(losungZahlen.toString());
	}

}
