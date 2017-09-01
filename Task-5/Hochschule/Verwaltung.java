/**
 * @author Diletta Calussi
 * Matrikel-Nr. s0559842
 *
 */
public class Verwaltung {
	
	/**
	 * Methode bekommt als Parameter eine belibiege Anzahl an
	 * Person-Objekten (z.B. Student/Dozent-Objekte)
	 * und liefert ein Array aus diesen Objekten zurueck
	 * 
	 * @param persons (als varargs)
	 * @return persons (array)
	 */
	public static Person[] listeAnlegen(Person ... persons){
		if (persons == null) throw new NullPointerException("Liste ungueltig!");
		else return persons;
	}

	/**
	 * Die Methode gibt die Elemente in p aus
	 * 
	 * @param p (array von Person-Objekten)
	 */
	public static void listeAusgeben(Person[] p){
		for (int i = 0; i < p.length; i++){
			System.out.println(p[i]);
		}
	}
	
	/**
	 * Methode sortiert die Strings nachname aus dem Person-Array list
	 * (Sortieralgorithmen: SelectionSort)
	 * 
	 * @param list
	 * @return sortierte Liste
	 */
	public static Person[] listeSortieren(Person [] list){
		//Durchlaeuft die ganze array list bis n-1
		for(int i = 0; i < list.length-1; i++){
			int minIndex = i; //speichert index i zum Vergleich
			
			for(int j = i; j < list.length; j++){ //durchaleuft Stellen ab i bis Ende				
				//vergleicht Strings paarweise, ob linker hinten der rechten String aufgelistet sein muss
				if(vergleicheStrings(list[minIndex].getNachname(), list[j].getNachname()) == 1){
					minIndex = j; //speichert gefundenes Index
				}
			}
			//swap Objekte in array
			Person temp = list[i];
			list[i] = list[minIndex];
			list[minIndex] = temp;
		}
		//Rueckgabe array
		return list;
	}
	
	/**
	 * Die Methode vergleicht zwei Strings lexikographisch
	 * Liefert 1, wenn Differenz der beiden Strings > 0
	 * Liefert -1, wenn Differenz < 0
	 * 
	 * @param s1
	 * @param s2
	 * @return 1 oder -1, falls Strings an einigen Stellen abweichen
	 */
	private static int vergleicheStrings(String s1, String s2){
		int laenge = 0; //speichert laenge
		int differenz = 0; //speichert Buchstaben-Differenz
		
		//Auswahl der Laenge fuer for-Schleife (nach dem kleineren String)
		if (s1.length() > s2.length()) laenge = s2.length();
		else laenge = s1.length();
		
		//durchlaufe String
		for (int i = 0; i < laenge; i++){
			//berechne Differenz 
			differenz = s1.charAt(i) - s2.charAt(i);
			//sobald Ungleichheit gefunden - halte Schleife
			if (differenz != 0){
				break;
			}
		}
		if (differenz == 0){
			//Schleife durchlaeuft so lang, wie die Laenge der kuerzeren Zeichenkette
			//Falls keine Unterschiede vorkommen
			if(s1.length() > s2.length()) return 1; //hier Vertauschung noetig
			else return -1; //hier keine Vertauschung
		}
		if (differenz > 0) return 1; //linker String muss hinter den rechten, erfordert Strings-Swap
		else return -1; //erfordert keine Aenderung
	}
	
	/**
	 * Die Methode zaehlt die Anzahl der weiblichen Objekte in p
	 * @param p
	 * @return anzahl
	 */
	public static int zaehleWeiblich(Person [] p){
		int zaehler = 0; //zaehlt Vorkommen
		
		for (int i = 0; i < p.length; i++){
			char g = p[i].getGeschlecht(); //speichert char fuer Geschlecht
			if (g == 'w'){ //falls zutreffend
				zaehler++; //erhoeht Zaehler
			}
		}
		return zaehler;
	}
}
