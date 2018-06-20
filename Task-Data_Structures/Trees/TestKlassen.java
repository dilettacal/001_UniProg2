import listen.Liste;
/**
 * 17.06.2017
 * TestKlassen.java
 * package
 */
public class TestKlassen {

	public static void main(String[] args) {
		Liste l1 = new Liste();
		l1.addLast(99);
		l1.addFirst(11);
		l1.addFirst(15);
		System.out.println(l1.size()); //1
		l1.addFirst(7);
		System.out.println(l1.size()); //2
		l1.addLast(15);
		System.out.println(l1.size()); //3
		l1.addLast(199);
		//Liste:
		// 0  1  2  3  4  5
		//[7,15,11,99,15,199]
		
		System.out.println("First = " + l1.getFirst()); //7
		System.out.println("Last = " + l1.getLast()); //199
		
		System.out.println(l1.add(256, 3));
		//Ergebnis:
		//[7,15,11,*256*,99,15,199]
		System.out.println(l1);
		
		System.out.println(l1.contains(199));
		System.out.println(l1.contains(2000));
		System.out.println(l1.get(0));
		System.out.println(l1.get(1));
		try{
			System.out.println(l1.get(9));
		} catch (NullPointerException e){
			System.out.println(e.getMessage());
		}
		System.out.println(l1.get(6));
		
		System.out.println(l1);
		//Set(55) am Index 3 (256 --> 55)
		System.out.println(l1.set(55, 3)); //256
		System.out.println(l1);
		
		
		//remove first
		System.out.println(l1.removeFirst());
		System.out.println(l1);
		
		//remove last
		System.out.println(l1.removeLast()); //199
//		System.out.println();
		System.out.println(l1);
		
		//Remove (55) aus liste --> zu korrigieren
		System.out.println(l1.remove(55));
		System.out.println(l1);
		System.out.println(l1.remove(99));
		System.out.println(l1);
		//Problem bei Duplikate!
		System.out.println(l1.remove(15));
		System.out.println(l1);
		
		
		
	}
}
