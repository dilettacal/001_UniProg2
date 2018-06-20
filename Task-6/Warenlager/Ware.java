/**
 * 
 * Blatt 6
 * 
 * 26.05.2017
 * 
 * Klasse Ware.java
 * Basisklasse
 * 
 */
public class Ware {
	
	//Attribute
	private final String name = getClass().getName(); //Sortenname -> Klassenname
	private float preis;
	private String typ;
	private int anzStuecke; //zur Verfuegung stehende Anzahl an Stuecken
	
	/**
	 * Parameterloser-Konstruktor
	 */
	public Ware() {
		preis = 0.0f;
		typ = "Allgemeine Ware";
		anzStuecke = 0;
	}

	/**
	 * Parameter-Konstruktor zum Einsetzen des Typs und Preises
	 * Attribut anzStuecke wird auf default-Wert eingesetzt
	 * @param preis
	 * @param typ
	 */
	public Ware(float preis, String typ) {
		this.preis = preis;
		this.typ = typ;
		this.anzStuecke = 0; //Attribut initialisiert mit default-Wert
	}
	
	/**
	 * Parameter-Konstruktor erzeugt Objekt mit
	 * Preis, Typ und Stueckenanzahl
	 * @param preis
	 * @param typ
	 * @param anzStuecke
	 */
	public Ware(float preis, String typ, int anzStuecke) {
		this(preis, typ); //ruft eigenen Konstruktor auf
		this.anzStuecke = anzStuecke;
	}

	/*Getter und Setter fuer nicht finale Attribute */
	public float getPreis() {
		return preis;
	}
	
	public void setPreis(float preis) {
		this.preis = preis;
	}
	
	public String getTyp() {
		return typ;
	}
	
	public void setTyp(String typ) {
		this.typ = typ;
	}

	public int getAnzStuecke() {
		return anzStuecke;
	}

	public void setAnzStuecke(int anzStuecke) {
		if (anzStuecke > 0) {
			this.anzStuecke = anzStuecke;
		}
	}

	/*Getter fuer finales Attribut (nicht veraenderbar) */
	public String getName() {
		return name;
	}

	/* Methode eroeht Anzahl an verfuegbaren Stuecken */
	public void anzahlErhoehen(int stuecke){
		if ((anzStuecke + stuecke) > 0){ //Wert darf nicht < 0 werden
			anzStuecke += stuecke;
		} else { 
			System.out.println("Vorrat darf nicht negativ sein!");
		}
	}
	
	/* Objekt-Darstellung in der Form:
	 * Bezeichnung - Anzahl - Typ 
	 */
	public String print(){
		return "Bezeichnung: " + name + " Anzahl: " + anzStuecke + " Typ: " + typ;
	}

	/*
	 * toString()-Methode zur Darstellung
	 * aller Objekt-Eigenschaften
	 */
	@Override
	public String toString() {
		return name + " Preis: " + preis + ", Typ: " + typ + ", Anzahl Stuecke: " + anzStuecke;
	}

	


	
	
	
	
	
	

}
