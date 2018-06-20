

import listen.Node;

public class ListeVL {
	
	private Node first = null;
	private Node last = null;
	
	//size() kann auch vermieden werden,
	//indem man einen counter als Feld implementiert und hochzaehlt, bei jedem Hinzufuegen
	
	//Laenge berechnen
	public int size(){
		Node p = first;
		//Iteration ueber Knoten
		int length = 0;
		while (p != null){ //ende der ListeVL
			length++;
			p = p.next;
		}
		return length;
	}
	
	public boolean contains(int wert){
		Node hilfe = first;
		while (hilfe != null && hilfe.data != wert){
			hilfe = hilfe.next;
		}
		if(hilfe == null) return false;
		else return true;
	}
	
	public void einfuegeAm(int wert, int index){
		Node p = new Node(wert); //salviamo valore 
		Node iterator = first; //iteratore sugli elementi
		
		for(int i = 0; i <= index; i++){
			if(first != null && last != null)
				if(index <= size()){
				p.next = iterator.next;
				iterator.next = p;
			}
			iterator = iterator.next;
		}
	}
	
	public void print(){
		int size = size();
		Node temp = first;
		for (int i = 0; i < size; i++){
			System.out.println("Wert = " + temp.data );
			temp = temp.next;
		}
	}

}
