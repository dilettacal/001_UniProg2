package reiseanbieter;
import kunden.Kunde;
import transportmittel.*;

/**
 * 06.06.2017
 */
public class TuiReisen implements Reiseanbieter {
	
	/* Konkrete Transportmittel des Anbieters TuiReisen */
	private Bus bus;
	private Bahn bahn;
	
	/* Preise fuer die Transportmittel */
	private final double BUSPREIS = 25.0;
	private final double BAHNPREIS = 40.0;
	
	/* Verwaltung der Buchungen/Stornierungen */
	
	/* Verwaltung Busreisenden */
	private Kunde[] kundenImBus; //speichert Bus-Reservierungen
	private int anzahlImBus = 0; //Counter fuer Bus-Reservierungen
	
	/* Verwaltung Bahnreisenden */
	private Kunde[] kundenMitBahn; //speichert Bahn-Reservierungen
	private int anzahlInBahn = 0; //Counter fuer Bahn-Reservierungen
	
	/* Variablen zur Ueberwachung der Anfragen */
	private int transportmittel;//muss static werden !!
	private boolean erfolgBuchung = false;
	private boolean erfolgStorno = false;
	
	/* Codes zur Verwaltung der Anfragen */
	private final static int BUCHUNG_PRIVAT = 1;
	private final static int STORNO_PRIVAT = -1;
	private final static int BUCHUNG_GRUPPE = 11;
	private final static int STORNO_GRUPPE = -11;
	private final static int DAUER = 2;
	private final static int PREIS = 3;
	
	/**
	 * Parameterloser Konstruktor
	 */
	public TuiReisen() {
		super();
	}

	/**
	 * Parameterkonstruktor 
	 * @param bus = eigener Bus 
	 * @param bahn = eigene Bahn
	 */
	public TuiReisen(Bus bus, Bahn bahn) {
		//Reiseanbieter verfuegt ueber der Objekte Bus und Bahn
		this.bus = bus;
		this.bahn = bahn;
		//Reisenabieter verfuegt ueber Reservierung-Speicher
		setKundenImBus(new Kunde[bus.getAnzahlPlaetze()]);
		setKundenMitBahn(new Kunde[bahn.getAnzahlPlaetze()]);
	}
	
	/**
	 * Methode verwaltet externe Anfrage abhaengig von der Anfrageart
	 * @param anfrage = buchen, stornieren, preis- oder dauererfragen
	 * 			ruft jeweils entsprechende Methode auf
	 * @param k = Kunde, der die Anfrage schickt
	 * @param transport = transportmittel, wofuer die Anfrage geschickt wurde
	 * @see #buchen(Kunde, int)
	 * @see #stornieren(Kunde, int)
	 * @see #preisErfragen(Kunde, int)
	 * @see #dauerErfragen(Kunde, int)
	 */
	public void anfrageEinzeln(int anfrage, Kunde k, int transport) {
		switch (anfrage) {
			case BUCHUNG_PRIVAT:
				if (buchen(k, transport)) {
					buchungBestaetigen(k, transport);
				} else
					buchungAblehnen(k, transport);
				break;
			case STORNO_PRIVAT:
				if (stornieren(k, transport)) {
					stornoBestaetigen(k, transport);
				} else
					stornoAblehnen(k, transport);
				break;
				
			case DAUER:
				dauerErfragen(k,transport);
				break;
			
			case PREIS:
				preisErfragen(k,transport);
				break;
			default: 
			if (anfrage != BUCHUNG_PRIVAT || anfrage != STORNO_PRIVAT || anfrage != DAUER || anfrage != PREIS) {
				System.out.println("Anfrage falsch!");
				}
			}
	}
	
	/**
	 * Methode verwaltet externe Gruppenanfrage abhaengig von ihrer Art
	 * @param anfrage = buchen oder stornieren
	 * @param kunden = gruppe, die die Anfrage schickt
	 * @param transport = transportmittel, wofuer die Anfrage gilt
	 * @see #buchen(Kunde[], int)
	 * @see #stornieren(Kunde[], int)
	 */
	public void anfrageGruppe(int anfrage, Kunde[] kunden, int transport){
		switch (anfrage) {
		case BUCHUNG_GRUPPE:
			if (buchen(kunden, transport)) {
				for (int i = 0; i < kunden.length; i++){
					buchungBestaetigen(kunden[i],transport);
				}
			} else
				for (int i = 0; i < kunden.length; i++){
					buchungAblehnen(kunden[i],transport);
				}
			break;
			
		case STORNO_GRUPPE:
			if (stornieren(kunden, transport)) {
				for (int i = 0; i < kunden.length; i++) {
					stornoBestaetigen(kunden[0], transport);
					System.out.println();
				}
			} else
				for (int i = 0; i < kunden.length; i++) {
					stornoAblehnen(kunden[i], transport);
					System.out.println();
				}
			break;
		default: 
			if (anfrage != BUCHUNG_GRUPPE || anfrage != STORNO_GRUPPE) {
				System.out.println("Anfrage falsch!");
				}
		}
	}
	
	/* Getter und Setter fuer Attribute */
	public int getAnzahlImBus() {return anzahlImBus;}
	public void setAnzahlImBus(int anzahlImBus) {this.anzahlImBus = anzahlImBus;}
	
	public int getAnzahlInBahn() {return anzahlInBahn;}
	public void setAnzahlInBahn(int anzahlInBahn) {	this.anzahlInBahn = anzahlInBahn;}
	
	//zu ersetzen
	public int getTransportmittel() {return transportmittel;}
	public void setTransportmittel(int transportmittel) {this.transportmittel = transportmittel;}

	public Bus getBus() { return bus; }
	public void setBus(Bus bus) { this.bus = bus; }
	
	public Bahn getBahn() {	return bahn;}
	public void setBahn(Bahn bahn) {this.bahn = bahn;}

	public double getBUSPREIS() {return BUSPREIS;}
	public double getBAHNPREIS() {return BAHNPREIS;}
	
	public Kunde[] getKundenImBus() { return kundenImBus;}
	public void setKundenImBus(Kunde[] kundenImBus) {this.kundenImBus = kundenImBus;}

	public Kunde[] getKundenMitBahn() { return kundenMitBahn;}
	public void setKundenMitBahn(Kunde[] kundenMitBahn) {this.kundenMitBahn = kundenMitBahn;}

	public static int getDauer() {return DAUER;}
	public static int getPreis() {return PREIS;}
	
	
	@Override
	public boolean buchen(Kunde k, int transport) {
		//Implementare funzione che evita doppie prenotazioni
		if(anzahlImBus == kundenImBus.length-1 || anzahlInBahn == kundenMitBahn.length){
			buchungAblehnen(k,transport);
			return false;
		}
		if(transport == EGAL){
			if(anzahlImBus < kundenImBus.length){
				transport = BUS;
				setTransportmittel(BUS);
				erfolgBuchung = true;
			} 
			else if (anzahlInBahn < kundenMitBahn.length){
				transport = BAHN;
				setTransportmittel(BAHN);
				erfolgBuchung = true;
			}
		}
		else
			switch (transport) {
			case BUS:
				if (anzahlImBus < kundenImBus.length) {
					setTransportmittel(BUS);
					erfolgBuchung = true;
					break;
				} else {
					buchungAblehnen(k,BUS);
					return false;
				}
			case BAHN:
				if (anzahlInBahn < kundenMitBahn.length) {
					setTransportmittel(BAHN);
					erfolgBuchung = true;
					break;
				}
				else {
					buchungAblehnen(k,BAHN);
					return false;
				}
			}
		return true;
	}
	
	@Override
	public boolean buchen(Kunde[] gruppe, int transport) {
		int benoetigtePlaetze = gruppe.length;
		//Berechnung der freien Plaetze
		int nochFreiImBus = kundenImBus.length - anzahlImBus;
		int nochFreiInBahn = kundenMitBahn.length - anzahlInBahn;
		//Zum Vergleich
		boolean busVerfuegbar = false;
		boolean bahnVerfuegbar = false;
		if (nochFreiImBus >= benoetigtePlaetze) busVerfuegbar = true;
		if (nochFreiInBahn >= benoetigtePlaetze) bahnVerfuegbar = true;
		
		if(transport == BUS && busVerfuegbar ){
			setTransportmittel(BUS);
			return true;
		}
		else if (transport == BAHN && bahnVerfuegbar){
			setTransportmittel(BAHN);
			return true;
		}
		
		else if(transport == EGAL){
			if (busVerfuegbar){
				setTransportmittel(BUS);
				return true;
			}
			else if(bahnVerfuegbar){
				setTransportmittel(BAHN);
				return true;
			}
		}
		return false;
	}
	
	@Override
	public void buchungBestaetigen(Kunde k, int transport) {
		transport = getTransportmittel();
		if(erfolgBuchung){
			switch(transport){
			case BUS:
				kundenImBus[anzahlImBus++] = k;
				k.empfangeNachricht("Busreise gebucht\n");
				break;
			case BAHN:
				kundenMitBahn[anzahlInBahn++] = k;
				k.empfangeNachricht("Bahnreise gebucht\n");
				break;
			}
			
		}
		else buchungAblehnen(k,transport);		
	}
	
	@Override
	public void buchungAblehnen(Kunde k, int transport) {
		if (transport == BUS) k.empfangeNachricht("Busreise konnte nicht gebucht werden\n");
		if (transport == BAHN) k.empfangeNachricht("Bahnreise konnte nicht gebucht werden\n");
		
	}

	@Override
	public boolean stornieren(Kunde k, int transport) {
		setTransportmittel(transport);
		if (transport == EGAL){
			System.out.println("Nicht moeglich! Bitte stornieren Sie die"
					+ " Reise nochmal, aber unter Angabe des Transportmittels");
			erfolgStorno = false;
		}
		if (transport == BUS) {
			int index = linSuche(kundenImBus, k); // sucht im Speicher nach k
			if (index != -1) { // Kunde hatte Busreise gebucht
				setTransportmittel(BUS);
				erfolgStorno = true;
				// Umbuchung erfoglt:
				setKundenImBus(umbuchen(kundenImBus, index));
				anzahlImBus--;
			} else{
				erfolgStorno = false;
			}
			
		} 
		if (transport == BAHN) {
			int index = linSuche(kundenMitBahn, k);
			if (index != -1) {//Kunde hatte Bahnreise gebucht
				setTransportmittel(BAHN);
				erfolgStorno = true;//Stornierung moeglich
				// Umbuchung erfolgt:
				setKundenMitBahn(umbuchen(kundenMitBahn, index));
				anzahlInBahn--;
			} else{
				erfolgStorno = false;
			}
		}
		return erfolgStorno; //Stornierungserfolg mitteilen
	}
	
	private static Kunde[] umbuchen (Kunde[] arr, int index){
		arr[index] = null;//loesche Buchung
		int pos = index;
		if(arr[index+1] != null){//wenn andere Buchungen verfuegbar
			for(int i = index+1; i < arr.length; i++){			
				arr[pos++] = arr[i]; //Umbelegung
			}
			arr[pos] = null;//entfernt letztes Duplikat
		}
		return arr;
	
	}
	
	/**
	 * Hilfsmethode zur Suche im Speicher
	 * @param kunden array durchzusuchen
	 * @param k	Kunde zu suchen
	 * @return index oder -1 falls Kunde nicht anwesend
	 */
	private static int linSuche(Kunde[]kunden, Kunde k){
		for (int i = 0; i < kunden.length; i++){
			if (kunden[i] == k) return i;
		}
		return -1;
	}
	

	@Override
	public boolean stornieren(Kunde[] gruppe, int transport) {
		for (Kunde element : gruppe) {
			if(!stornieren(element,transport)) return false;
		}
		return true;
	}

	@Override
	public void stornoBestaetigen(Kunde k, int transport) {
		transport = getTransportmittel();
		if(erfolgStorno){
			if(transport == BUS){
				k.empfangeNachricht("Busreise storniert");
			} else if (transport == BAHN) {
				k.empfangeNachricht("Bahnreise storniert");
			}
		}
		
	}

	@Override
	public void stornoAblehnen(Kunde k, int transport) {
		transport = getTransportmittel();
		if(!erfolgStorno){
			if(transport == BUS){
				k.empfangeNachricht("Busreise konnte nicht storniert werden");
			} else if (transport == BAHN) {
				k.empfangeNachricht("Bahnreise konnte nicht storniert werden");
			}
		}
		
	}

	@Override
	public double preisErfragen(Kunde k, int transport) {
		switch(transport){
		case BUS:
			k.empfangeNachricht("Busreise kostet " + BUSPREIS + " EUR");
			return BUSPREIS;
		case BAHN:
			k.empfangeNachricht("Bahnreise kostet " + BAHNPREIS + " EUR");
			return BAHNPREIS;
		case EGAL:
			if(BUSPREIS < BAHNPREIS){
				k.empfangeNachricht(" Am guenstigsten ist die Busreise und kostet " + BUSPREIS + " EUR");
				return BUSPREIS;
			}
		}
		k.empfangeNachricht(" Am guenstigsten ist die Bahnreise und kostet " + BAHNPREIS + " EUR");
		return BAHNPREIS;
	}

	@Override
	public double dauerErfragen(Kunde k, int transport) {
		double dauerImBus = entfernungBus / bus.getGeschwindigkeit();
		double dauerInBahn = entfernungBahn / bahn.getGeschwindigkeit();

		switch (transport) {
		case BUS:
			sendeDauer(k, dauerImBus, BUS, BUS);
			return dauerImBus;
		case BAHN:
			sendeDauer(k, dauerInBahn, BAHN, BAHN);
			return dauerInBahn;
		case EGAL:
			if (dauerImBus < dauerInBahn) {
				sendeDauer(k, dauerImBus, EGAL, BUS);
				return dauerImBus;
			}
		}
		sendeDauer(k, dauerInBahn, EGAL, BAHN);
		return dauerInBahn;
	}
	
	/**
	 * Methode sendet Dauer an Kunden
	 * @param k Kunde, der die Dauer erfragt hat
	 * @param d Dauer zu schicken
	 * @param transport Transportmittel, wofuer die Dauer erfragt wurde
	 * @param schnellst Schnellstes Transportmittel
	 */
	private void sendeDauer(Kunde k, double d, int transport, int schnellst){
		String dauer = String.format("%.2f", d);
		if(transport != EGAL && transport == schnellst){
			if(transport == BUS){
				k.empfangeNachricht("Busreise dauert " + dauer + " Stunden");
			} 
			if (transport == BAHN){
				k.empfangeNachricht("Bahnreise dauert " + dauer + " Stunden");
			}
		}
		else {
				if (schnellst == BUS){
					k.empfangeNachricht("Busreise ist am schnellsten und dauert " + dauer + " Stunden");
				} else {
					k.empfangeNachricht("Bahnreise ist am schnellsten und dauert " + dauer + " Stunden");
				}
			}
		}
	
	
	@Override
	public String toString() {
		return "Reiseanbieter: " + getClass().getSimpleName() + 
				" bietet folgende Transportmittel an: \nBahn: "+ bahn.toString() + 
				"\nBus" + bus.toString();
	}
		


	
}
