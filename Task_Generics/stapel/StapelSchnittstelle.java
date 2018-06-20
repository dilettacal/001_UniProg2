package stapel;
/**
 * 30.06.2017
 * StapelSchnittstelle.java
 * package stapel
 * Schnittstelle zur Verwaltung von generischen Stapel-Objekten
 * 
 */
public interface StapelSchnittstelle<T> {
	
	/**
	 * F&uumlgt einen Wert auf der Stapel ein
	 * @param value der Wert
	 */
	abstract void push(T value);
	
	/**
	 * Entfernt oberstes Element auf dem Stapel
	 * @return Knoten des obersten Elements
	 * @throws NullPointerException, falls Stapel leer
	 */
	abstract T pop() throws NullPointerException;
	
	/**
	 * Liefert Schl&uumlssel des obersten Elements zur&uumlck
	 * @return obersten Knoten
	 * @throws NullPointerException, falls Staple leer
	 */
	abstract T top() throws NullPointerException;
	
	/**
	 * Pr&uumlft, ob Stapel leer ist
	 * @return true, wenn Stapel leer
	 */
	abstract boolean isEmpty();

}
