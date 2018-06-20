package stapel;
/**
 * 
 * 30.06.2017
 * Node.java
 * package stapel
 * @param <T>
 * Generische Klasse f&uumlr Knoten-Objekte
 */
public class Node<T> {
	//Datenfelder
	T data;
	Node<T> next;
	
	/**
	 * Default-Konstruktor
	 */
	public Node(){
		next = null;
	}
	
	/**
	 * Erzeugt Knoten mit Schl&uumlssel
	 * @param data der Wert
	 */
	public Node (T data){
		this.data = data;
		next = null;
	}
	
	/**
	 * Gibt Knoten aus.
	 */
	public String toString(){
		return (String) this.data;
	}

}
