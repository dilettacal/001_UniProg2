/**
 * 
 */

/**
 * @author Diletta Calussi
 * Matrikel-Nr. s0559842
 *
 */
public class Dozent extends Person {
	//Attribut
	int kostenstelle;

	/**
	 * Parameterloser Konstruktor
	 */
	public Dozent() {
		super();
	}

	/**
	 * Konstruktor mit Parametern
	 * @param vorname
	 * @param nachname
	 * @param geschlecht
	 */
	public Dozent(String vorname, String nachname, char geschlecht, int k) {
		//Vererbung
		super(vorname, nachname, geschlecht);
		kostenstelle = k;
	}

	/**
	 * @return the kostenstelle
	 */
	public int getKostenstelle() {
		return kostenstelle;
	}

	/**
	 * @param kostenstelle the kostenstelle to set
	 */
	public void setKostenstelle(int kostenstelle) {
		this.kostenstelle = kostenstelle;
	}

	/* (non-Javadoc)
	 * @see Person#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + ", Kostenstelle = " + kostenstelle + " - Rolle: Dozent/in";
	}
	
	
	
	
}
