/**
 * @author Diletta Calussi
 * Matrikel-Nr. s0559842
 * 
 * Hauptklasse Person
 * 
 */
public class Person {
	//Attribute
	private String vorname;
	private String nachname;
	private char geschlecht;
	
	//Parameterloser Konstruktor
	public Person() {
		super();
	}

	//Konstruktor mit Attributen
	public Person(String vorname, String nachname, char geschlecht) {
		this.vorname = vorname;
		this.nachname = nachname;
		this.geschlecht = geschlecht;
	}

	//Getter und Setter fuer Attribute
	public String getVorname() {
		return vorname;
	}


	public void setVorname(String vorname) {
		this.vorname = vorname;
	}


	public String getNachname() {
		return nachname;
	}


	public void setNachname(String nachname) {
		this.nachname = nachname;
	}


	public char getGeschlecht() {
		return geschlecht;
	}


	public void setGeschlecht(char geschlecht) {
		this.geschlecht = geschlecht;
	}


	@Override
	//toString-Methode zur graphischen Darstellung
	public String toString() {
		//String s = "Person: ";
		return  "Vorname = " + vorname + ", Nachname = " + nachname + ", Geschlecht = " + geschlecht;
	}
	
	
	
	
	
	
	
	

}
