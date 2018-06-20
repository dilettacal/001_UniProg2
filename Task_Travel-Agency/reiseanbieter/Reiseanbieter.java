package reiseanbieter;
import kunden.Kunde;

/**
 * 06.06.2017
 */
public interface Reiseanbieter {
	
	//Auswahl des Transportmittels
	public static final int EGAL = 0;
	public static final int BUS = 1;
	public static final int BAHN = 2;
	
	//Entfernung in Km auf Strassen (Busreise)
	public static final double entfernungBus = 288.2;
	//entfernung in Km auf Schienen (Bahnreise)
	public static final double entfernungBahn = 310;
	
	/**
	 * Methode zum Buchen fuer Einzelkunden. 
	 * Voraussetzung: transport enthaelt noch freie Plaetze
	 * @param k (der Kunde)
	 * @param transport (das gewuenschte Transportmittel)
	 * @return
	 */
	public abstract boolean buchen(Kunde k, int transport);
	
	/**
	 * Methode zum Buchen fuer Gruppe.
	 * Voraussetzung: transport enthaelt noch freie Plaetze
	 * @param gruppe
	 * @param transport
	 * @return
	 */
	public abstract boolean buchen(Kunde[] gruppe, int transport);
	
	/**
	 * Reiseanbieter sendet Bestaetigung an Kunden (= k), 
	 * falls Buchung erfolgreich
	 * @param k
	 * @param transport
	 */
	public abstract void buchungBestaetigen(Kunde k, int transport);
	
	/**
	 * Ablehnung der Buchung, falls Buchung erfolglos
	 * @param k (=Kunde)
	 * @param transport
	 */
	public abstract void buchungAblehnen(Kunde k, int transport);
	
	/**
	 * Stornierung fuer Einzelkunde
	 * @param k (Kunde)
	 * @param transport (betroffenes Transportmittel)
	 * @return true, wenn Stornierung moeglich
	 */
	public abstract boolean stornieren(Kunde k, int transport); 
	
	/**
	 * Stornierung fuer Gruppe
	 * @param gruppe
	 * @param transport
	 * @return true, wenn Stornierung moeglich
	 */
	public abstract boolean stornieren(Kunde[] gruppe, int transport); 
	
	/**
	 * Bestaetigung an k, falls Stornierung erfolgreich
	 * @param k
	 * @param transport
	 */
	public abstract void stornoBestaetigen(Kunde k, int transport);
	
	/**
	 * Ablehnung an k, falls Stornierung erfolglos
	 * @param k
	 * @param transport
	 */
	public abstract void stornoAblehnen(Kunde k, int transport);
	
	/**
	 * Methode zum Preiserfragen fuer Transportmittel transport
	 * durch Kunden k
	 * @param k
	 * @param transport
	 * @return preis (festgelegt durch den Anbieter)
	 */
	public abstract double preisErfragen(Kunde k, int transport);
	
	/**
	 * Methode zum Dauererfragen durch Kunden k
	 * bzgl. Transportmittel transport
	 * @param k
	 * @param transport
	 * @return Dauerwert (haengt von Entfernung + Durchschnittgeschwindigkeit)
	 */
	public abstract double dauerErfragen(Kunde k, int transport);
	
}
