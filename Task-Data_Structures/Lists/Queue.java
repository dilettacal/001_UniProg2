

import listen.Node;

/**
 * 16.06.2017
 * Queue.java
 * package listen
 */
public class Queue {
	//braucht 2 Zeiger
	private Node first = null;
	private Node last = null;
	private int counter = 0;
	
	public void enqueue(int x){
		Node hilfe = new Node(x); //erzeugt Knoten mit data = x
		if(first == null) //das ist 1. Element in Queue
			first = hilfe;
		else 
			last.next = hilfe; //aufs neue Element zeigt Zeiger "next" von first
		last = hilfe;//das neue Element ist auf jeden Fall auch das letzte in der Queue
		counter++;
	}
	
	public int dequeue(){
		Node hilfe = first;
		if(first.next == null){
			System.out.println("Queue ist leer!"); //--> exception
		}
		else {
			first = first.next;
			counter --;
		}
		return hilfe.data;
	}
	
	public int firstElem(){
		return first.data;
	}
	
	public int lastElem(){
		return last.data;
	}
	
	public void print(){
		Node hilfe = first;
		System.out.print("<-- ");
		for (int i = 0; i < counter; i++){
			System.out.print(hilfe.data + ", ");
			hilfe = hilfe.next;
		}
		System.out.print("<--");
	}
}
