/**
 * 
 * Datum 07.05.2017
 * 
 * Klasse Mitarbeiter (Superklasse)
 * 
 * Diese Klasse dient als allgemeine
 * Klasse fuer das Personal
 * der GeLa GmbH
 * 
 * Die Klasse koennte z.B. um weitere Attribute
 * erweitern werden, wie z.B.: Adresse,
 * Geburtstag, Geschlecht, Nationalitaet
 * 
 */
public class Mitarbeiter {

	// Attrubute
	private String vorname;
	private String name;
	float gehalt;

	// Konstruktor
	
	//Default-Konstruktor um Attribute einzeln einzusetzen
	public Mitarbeiter() {
	}

	
	//Konstruktor mit allen Attributen als Paramter
	public Mitarbeiter(String vorname, String name, float gehalt) {
		this.vorname = vorname;
		this.name = name;
		this.gehalt = gehalt;
	}

	// Methode zum Erhoehen des Gehalts
	public float erhoeheGehalt(int erhoehung) {
		this.gehalt += erhoehung;		
		return (float) this.gehalt;
	}
	
	//Getter- und Settermethoden fuer Attribute
	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getGehalt() {
		return gehalt;
	}

	public void setGehalt(float gehalt) {
		this.gehalt = gehalt;
	}

	@Override
	public String toString() {
		return "Mitarbeiter\t Vorname: " + vorname + "\tName: " + name + "\tGehalt (EUR): " + gehalt;
	}

}
