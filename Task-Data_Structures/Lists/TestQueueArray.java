
public class TestQueueArray {

	public static void main(String[] args) {
		QueueArray q = new QueueArray(6);
		q.push(10);
		q.push(18);
		q.push(3);
		q.print();
		q.push(19);
		q.push(22);
		q.print();
		q.push(54);
		q.print();
		
		int i = 0;
		while(i < 6){
			System.out.println(q.pop());
			i++;
		}
		q.print();
		System.out.println();
		
		QueueArrayRev qR = new QueueArrayRev(5);
		qR.enqueue(19);
		qR.enqueue(1);
		qR.enqueue(22);
		qR.enqueue(34);
		qR.enqueue(19);
		qR.print();
		qR.dequeue();
		qR.print();
		System.out.println(qR.first());
		System.out.println(qR.last());
	}
	
	
	
	

}
