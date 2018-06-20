
import listen.Liste;
import listen.warteschlangen.Warteschlange;
import listen.warteschlangen.WarteschlangeSchnittstelle;

/**
 * 21.06.2017<br>
 * TestWarteschlange.java<br>
 * Testklasse f&uumlr Warteschlange-Objekte
 */
public class TestWarteschlange {

	public static void main(String[] args) {
		//Warteschlange definiert mit Datentyp WarteschlangeSchnittstelle
		//zur Einschraenkung der Sichtbarkeit
		WarteschlangeSchnittstelle w1 = new Warteschlange(); //kein Aufruf der unpassenden Zugriffsmethoden moeglich
		System.out.println(w1.isEmpty());
		w1.enqueue(1);
		w1.enqueue(2);
		w1.enqueue(3);
		w1.enqueue(4);
		System.out.println(w1);
		System.out.println(w1.isEmpty());
		int size = ((Liste)w1).size();
		System.out.println(size);
		//dequeue
		while(size != 0){
			System.out.println(w1.dequeue());
			size--;
		}
		System.out.println(w1);
		
	}

}
