

import listen.Node;

public class Stack {
	
	private Node top = null;
	private int count = 0;

	//int muss in einen Node verpacken
	public void push(int elem){		
		//hier mussen wir top==null nicht pruefen
		//da Knoten immer auf null zeigt
		
		Node node = new Node(elem); //muss in die ListeVL eingepackt werden, Zeiger ist auf null
		//Naechstes Element ist das drunter liegende Element
		
		node.next = top; //zeigt worauf fruehr top gezeigt hat
		
		top = node; //top muss jetzt auf das neue Element zeigen
		count++;
	}
	
	public int pop(){
		if (top == null) throw new RuntimeException("Stack ist leer!");
//			System.out.println("Stack ist leer!");
//			return 0; 
		else {
			Node p = top; //Zwischenspeicehr fuer top
			top = top.next; //top zeigt jetzt auf Nachfolger
			count--;
			return p.data; //liefert date vom Element
		}
	}
	
	public int top(){
		if(top == null){
			System.out.println("Stack ist leer!");
		}
		return top.data;
	}
	
	public void content(){
		System.out.println("Stack-Content");
		Node temp = top;
		for(int i = 0; i < count; i++){
			System.out.println(temp.data);
			temp = temp.next;
		}
	}
	
	public boolean isEmpty(){
		if (count==0) return true;
		return false;
	}

}
