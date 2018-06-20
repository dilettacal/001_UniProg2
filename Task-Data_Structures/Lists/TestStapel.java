import listen.Liste;
import listen.stapel.Stapel;
import listen.stapel.StapelSchnittstelle;
/**
 * 22.06.2017<br>
 * TestStapel.java<br>
 * Testklasse f&uumlr StapelD-Objekte
 */
public class TestStapel {

	public static void main(String[] args) {
		//StapelD wird ueber die Schnittstelle erzeugt zur Einschraenkung der Sichtbarkeit
		StapelSchnittstelle st = new Stapel(1); //Kein Aufruf der unpassenden Zugriffsmethoden
		st.push(2);
		st.push(3);
		st.push(4); //top
		System.out.println(st);
		int size = ((Liste) st).size();
		System.out.println(st.top());
		System.out.println("Stacksize: " + size);
		while(size!=0){
			System.out.println(st.pop());
			size--;
		}
		System.out.println();
		System.out.println(st);

	}

}
