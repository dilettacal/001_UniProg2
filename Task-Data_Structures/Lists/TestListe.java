import listen.*;
/**
 * 17.06.2017<br>
 * TestListe.java<br>
 * Testklasse f&uumlr die Liste-Objekte
 */
public class TestListe {

	public static void main(String[] args) {
		Liste l1 = new Liste();
		System.out.println("Liste leer: " + l1.isEmpty());
		System.out.println("Liste : " +l1);
		//Test add-Methoden:
		System.out.println("Test der add-Methoden: ");
		l1.addLast(99);
		System.out.println("Liste : " +l1);
		l1.addFirst(11);
		System.out.println("Liste : " +l1);
		l1.addFirst(15);
		System.out.println("Liste : " +l1);
		l1.addFirst(7);
		System.out.println("Liste : " +l1);
		l1.addLast(15);
		System.out.println("Liste : " +l1);
		l1.addLast(199);
		System.out.println("Liste : " +l1);
		//Liste:
		// 0  1  2  3  4  5
		//[7,15,11,99,15,199]
		
		//Ausgabe erstes und letztes Element
		System.out.println("First = " + l1.getFirst()); //7
		System.out.println("Last = " + l1.getLast()); //199
		
		System.out.println("Hinfuegen am Index 3: " + l1.add(256, 3));
		//Ergebnis:
		//[7,15,11,*256*,99,15,199]
		System.out.println("Liste : " +l1+ "\n");
		System.out.println("Hinfuegen am Index 1: "+l1.add(1987, 1));
		System.out.println("Liste : " +l1 + "\n");
		
		//Test contains, get, set Methoden
		System.out.println(l1.contains(199)); //true
		System.out.println(l1.contains(2000)); //false
		System.out.println(l1.get(0));//7
		System.out.println(l1.get(6));//15
		System.out.println(l1.get(7));//199
		try{
			System.out.println(l1.get(9));//Fehler
		} catch (NullPointerException e){
				e.printStackTrace();
		} 
		try{
			System.out.println(l1.get(-2));//Fehler
		}
		catch (IllegalArgumentException e){
			e.printStackTrace();
		}
	
		
		//Set(55) am Index 3 (256 --> 55)
		System.out.println(l1.set(55, 3)); 
		System.out.println("Liste : " +l1+ "\n");
		//set(77) am Index 6 (15--> 77)
		System.out.println(l1.set(77, 6));
		System.out.println("Liste : " +l1+ "\n");
		
		//Test der remove-Methoden
		System.out.println("Test der remove-Methoden:");
		System.out.println(l1.removeFirst());
		System.out.println("Liste : " +l1+ "\n");
		System.out.println(l1.removeLast());
		System.out.println("Liste : " +l1 + "\n");
		System.out.println(l1.remove(55));
		System.out.println("Liste : " +l1+ "\n");
		System.out.println(l1.remove(1987));
		System.out.println("Liste : " +l1+ "\n");
		System.out.println(l1.remove(256));
		System.out.println("Liste : " +l1+ "\n");
		System.out.println(l1.removeAtIndex(1)); //15
		System.out.println(l1);
		try{
			System.out.println(l1.removeAtIndex(3));//fehler
		} catch (NullPointerException e){
			System.out.println(e.getMessage());
		}
		System.out.println(l1);
		System.out.println(l1.set(7, 0));
		System.out.println("Liste : " +l1+"\n");		
		System.out.println("Anzahl der Listenelemente: " + l1.size());//3
		l1.makeEmpty(); //leert die Liste
		System.out.println("Anzahl der Listenelemente: " + l1.size()); //0
	}
}
