/**
 * 
 */

/**
 * @author Diletta Calussi
 * Matrikel-Nr. s0559842
 * 
 * Unterklasse Student
 *
 */
public class Student extends Person {
	//Attribut
	int matrikelnummer;

	/**
	 * Parameterloser Konstruktor
	 */
	public Student() {
		super();
	}

	/**
	 * Konstruktor mit allen Attributen
	 * @param vorname
	 * @param nachname
	 * @param geschlecht
	 */
	public Student(String vorname, String nachname, char geschlecht, int m) {
		super(vorname, nachname, geschlecht);
		matrikelnummer = m;
	}

	/**
	 * @return the matrikelnummer
	 */
	public int getMatrikelnummer() {
		return matrikelnummer;
	}

	/**
	 * @param matrikelnummer the matrikelnummer to set
	 */
	public void setMatrikelnummer(int matrikelnummer) {
		this.matrikelnummer = matrikelnummer;
	}


	@Override
	//Vererbung + Ueberschreiben der Methode toString
	public String toString() {
		return super.toString() + ", Matrikelnummer = "+ matrikelnummer + " - Rolle: Student/in";
	}

	
	
	
	
	
	
	

}
