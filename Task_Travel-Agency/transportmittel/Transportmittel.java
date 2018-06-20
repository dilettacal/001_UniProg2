package transportmittel;

/**
* Schnittstelle Transportmittel <br>
* Klassen, die diese Schnittstelle implementieren, sind konkrete Transportmittel, wie Bus, Bahn, Minibus, Sammeltaxi usw.
* @author Prof.
* @version 1.0
*/	
public interface Transportmittel {
	
	/**
	 * liefert die Durchschnittsgeschwindigkeit des Transportmittels
	 * @return Durchnittsgeschwindigkeit
	 */
	public abstract double getGeschwindigkeit();
	
	/**
	 * liefert die maximale Anzahl der Pl�tze (f�r die Fahrg�ste) in dem Transportmittel
	 * @return Anzahl der Pl�tze
	 */
	public abstract int getAnzahlPlaetze();
}
