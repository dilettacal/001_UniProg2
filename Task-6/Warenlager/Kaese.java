import java.util.GregorianCalendar;

/**
 * 
 * Blatt 6
 * 26.05.2017
 * 
 * Klasse Kaese.java
 * Erbt von Milch
 */
public class Kaese extends Milch {

	/**
	 * Parameterloser Konstruktor
	 */
	public Kaese() {
		super();
	}
	
	/**
	 * Parameter-Konstruktor
	 * Vererbung aus Superklasse
	 * @param preis
	 * @param typ
	 */
	public Kaese(float preis, String typ) {
		super(preis, typ);
	}
	
	/**
	 * Parameter-Konstruktor
	 * Vererbung aus Superklassen
	 * @param preis
	 * @param typ
	 * @param verfallsdatum
	 * @param temperatur
	 * 
	 */
	public Kaese(float preis, String typ, GregorianCalendar verfallsdatum, float temperatur) {
		super(preis, typ, verfallsdatum, temperatur);
	}

	/**
	 * Parameter-Konstruktor
	 * Vererbung aus Superklasse
	 * @param preis
	 * @param typ
	 * @param verfallsdatum
	 * @param maxLagerTemp
	 */
	public Kaese(float preis, String typ, int anzStuecke, 
			GregorianCalendar verfallsdatum, float temp) {
		super(preis, typ, anzStuecke, verfallsdatum, temp);
	}

	

	@Override
	public String toString() {
		return super.toString();
	}
	
	
	
	
	
}
