/**
 * Blatt 6
 * 
 * 26.05.2017
 * 
 * Klasse Toilettenpapier.java
 * Erbt von Ware
 * 
 */
public class Toilettenpapier extends Ware {

	/**
	 * Parameterloser Konstruktor
	 * Vererbung aus Superklasse
	 */
	public Toilettenpapier() {
		super();
	}

	/**
	 * Parameter-Konstruktor
	 * Vererbung aus Superklasse
	 * @param preis
	 * @param typ
	 */
	public Toilettenpapier(float preis, String typ) {
		super(preis, typ);
	}
	
	
	/**
	 * Parameter-Konstruktor
	 * Vererbung aus Superklasse
	 * @param preis
	 * @param typ
	 * @param anzStuecke
	 */
	public Toilettenpapier(float preis, String typ, int anzStuecke) {
		super(preis, typ, anzStuecke);
	}

	@Override
	public String toString() {
		return super.toString();
	}
	
	
	
}
