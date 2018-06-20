package kunden;
/**
* Schnittstelle Kunde <br>
* Klassen, die diese Schnittstelle implementieren, sind Kunden eines Reiseanbieters
* @author Prof.
* @version 1.0
*/	
public interface Kunde {
	
	/**
	 * @param nachricht Nachricht, die vom Kunden empfangen wird
	 */
	public abstract void empfangeNachricht(String nachricht);
}
