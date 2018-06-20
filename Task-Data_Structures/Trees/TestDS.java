import listen.*;
public class TestDS {

	public static void main(String[] args) {
		
		Queue q1 = new Queue();
		q1.enqueue(5);
		q1.enqueue(6);
		System.out.println(q1.firstElem());
		System.out.println(q1.lastElem());
		q1.print();
		q1.dequeue();
		System.out.println();
		q1.print();
		
//		System.out.println("Test ListeVL");
//		ListeVL l1 = new ListeVL();
//		l1.einfuegeAm(4, 0);
//		l1.print();
		

	}

}
