package generische_baeume;
/**
 * 01.07.2017
 * Student.java
 * package generische_baeume
 */
public class Student implements Comparable<Student> {
	//Attribute
	private String vorname, nachname;
	private int matrikel;
	
	/**
	 * Default-Konstruktor
	 */
	public Student(){
		vorname = "";
		nachname = "";
		matrikel= -1;
	}
	
	/**
	 * Konstruktor mit allen Angaben.
	 * @param vorname der Vorname
	 * @param nachname der Nachname
	 * @param matrikel die Matrikelnummer
	 */
	public Student(String vorname, String nachname, int matrikel){
		this.vorname = vorname;
		this.nachname = nachname;
		this.matrikel = matrikel;
	}

	/**
	 * @return vorname der Vorname
	 */
	public String getVorname() {
		return vorname;
	}

	/**
	 * Setzt Vornamen ein
	 * @param vorname 
	 */
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	/**
	 * @return den Nachnamen
	 */
	public String getNachname() {
		return nachname;
	}

	/**
	 * Setzt Nachnamen ein
	 * @param nachname der Nachname
	 */
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	/**
	 * @return die Matrikelnummer
	 */
	public int getMatrikel() {
		return matrikel;
	}

	/**
	 * Setzt Matrikelnummer ein
	 * @param matrikelnummer die Matrikelnummer
	 */
	public void setMatrikel(int matrikel) {
		this.matrikel = matrikel;
	}

	
	@Override
	public String toString() {
		return "Student " + nachname  + ", " + vorname + " - Matrikel-Nr.: " + matrikel;
	}


	@Override
	/**
	 * &Ummlberschreibt compareTo() aus Comparable.<br>
	 * Liefert von zwei nachnamen-Strings
	 */
	public int compareTo(Student n) {
		return this.nachname.compareToIgnoreCase(n.nachname);	//nutzt Methode der Klasse String
	}
	
	

}
