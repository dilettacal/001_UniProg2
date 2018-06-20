
import java.util.GregorianCalendar;
/**
 * Blatt 6
 * 
 * 26.05.2017
 * 
 * Klasse Milch.java
 * Erbt von Ware
 * 
 */
public class Milch extends Ware{
	
	//Attribute
	private GregorianCalendar verfallsdatum;
	private float maxTemperatur;
	
	/**
	 * Parameterloser Konstruktor
	 */
	public Milch() {
		super();
	}
	
	/**
	 * Parameter-Konstruktor 
	 * Vererbung aus Superklasse
	 * @param preis
	 * @param typ
	 */
	public Milch(float preis, String typ) {
		super(preis, typ);
	}
	
	/**
	 * Parameter-Konstruktor
	 * Vererbung aus Superklasse
	 * @param preis
	 * @param typ
	 * @param anzStuecke
	 */
	
	public Milch(float preis, String typ, int anzStuecke) {
		super(preis, typ, anzStuecke);
	}
	/**
	 * Vererbung - Parameter-Konstruktor 
	 * Attribute:
	 * @param preis
	 * @param typ
	 * @param verfallsdatum
	 * @param temperatur
	 */
	public Milch(float preis, String typ, GregorianCalendar verfallsdatum, float temperatur){
		this(preis,typ);
		this.verfallsdatum = verfallsdatum;
		this.maxTemperatur = temperatur;
	}
	/**
	 * Parameter-Konstruktor mit allen Attributen
	 * @param preis
	 * @param typ
	 * @param anzStuecke
	 * @param verfallsdatum
	 * @param maxLagerTemp
	 */
	public Milch(float preis, String typ, int anzStuecke, 
			GregorianCalendar verfallsdatum, float temperatur) {
		this(preis, typ, anzStuecke);
		this.verfallsdatum = verfallsdatum;
		maxTemperatur = temperatur;
	}

	/* Getter und Setter fuer Attribute */
	public String getVerfallsdatum() {
		if (verfallsdatum == null){
			return "tt.mm.jjjj";
		}
		int jahr, monat, tag;
		tag = verfallsdatum.get(GregorianCalendar.DAY_OF_MONTH);
		monat = verfallsdatum.get(GregorianCalendar.MONTH);
		jahr = verfallsdatum.get(GregorianCalendar.YEAR);
		return tag +"."+monat+"."+jahr;
	}

	public void setVerfallsdatum(final GregorianCalendar verfallsdatum) {
		//Erlaubt nur einmaliges Einsetzen, wenn Objekt ueber
		//parameterlosen Konstruktor erzeugt wurde
		if (this.verfallsdatum == null) {
			this.verfallsdatum = verfallsdatum;
		}
	}
	
	public float getTemperatur() {
		return maxTemperatur;
	}

	public void setTemperatur(float temp) {
		if (temp < 0){
			System.out.println("Temperatur zu niedrig");
		} else 
			maxTemperatur = temp;
	}

	/* Instanzmethoden */
	
	/**
	 * Die Methode vergleicht Verfallsdatum mit datum
	 * @param datum zum Vergleich
	 * @return true, wenn datum equals (oder after) verfallsdatum
	 */
	public boolean istAbgelaufen (GregorianCalendar datum){
		if (verfallsdatum.equals(datum) || verfallsdatum.before(datum)) {
			return true;
		}
		return false;
	}
	
	/**
	 * Vergleich mit Temperatur (temp)
	 * @param temp
	 * @return true wenn temp ueber
	 * max. Temperatur fuer Warensorte
	 */
	public boolean istZuWarm (float temp){
		if (temp > maxTemperatur) return true;
		else return false;
	}
	
	@Override
	public String toString() {
		return super.toString() + ", Verfallsdatum= " + getVerfallsdatum()
				+ ", max. Lagertemperatur=" + maxTemperatur;
	}
	
	
	
	
	
	
	
	
	

}
