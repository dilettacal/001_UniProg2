package stapel;
import stapel.Node;
/**
 * 
 * @param <T>
 * 03.07.2017
 * StapelGenerisch.java
 * package stapel
 */
public class StapelGenerisch<T> implements StapelSchnittstelle<T> {
	//Datenfeld
	public Node<T> head;
	//Counter verfolgt Groesse
	int counter = 0;
	
	/**
	 * Default-Konstruktor
	 */
	public StapelGenerisch(){
		head = null;
	}
	
	/**
	 * Erzeugt einen neuen Stapel mit erstem Knoten vom Schl&uumlssel value
	 * @param value der Schl&uumlssel des hinzugef&uumlgten Knotens
	 */
	public StapelGenerisch(T value){
		push(value);
	}
	
	@Override
	public void push(T value) {
		Node<T> p = new Node<T>(value);
		if(head==null){
			head = p;
		} else {
			p.next = head;
			head = p;			
		}
		counter++;		
	}

	@Override
	public T pop() throws NullPointerException {
		if (head == null) {
			throw new NullPointerException("Operation nicht ausfuehrbar. Stack ist leer!");
		}
		T retObj = head.data;
		head = head.next;
		counter--;
		return retObj;
	}

	@Override
	public T top() throws NullPointerException {
		if(head != null) return head.data;
		else throw new NullPointerException("Stack ist leer!");
	}

	@Override
	public boolean isEmpty() {
		return head==null;
	}
	
	public int size(){
		return counter;
	}
	
	/**
	 * String-Ausgabe des Stapels
	 */
	public String toString(){
		String stapel ="";
		Node<T> start = head;
		if(head != null){
			System.out.println("Stack-Inhalt: ");
			for(int i = 0; i < counter; i++){
				stapel+= "** " + (start.data) + " **\n";
				start = start.next;
			}
			stapel+="*******";
			return stapel;
		}
		return "Stack ist leer ****";
		
	}

	

}
