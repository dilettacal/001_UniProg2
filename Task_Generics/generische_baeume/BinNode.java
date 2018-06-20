package generische_baeume;
/**
 * 
 * @param <T> Generische Klasse
 * 03.07.2017
 * BinNode.java
 * package generische_baeume
 */
public class BinNode<T> implements Comparable<BinNode<T>> {
	//Attribute der Klasse BinNode
	 public T data;
	 BinNode<T> left, right;
	
	/**
	 * Default-Konstruktor erzeugt leeren BinNode
	 */
	public BinNode(){
		left = null;
		right = null;
	}
	
	/**
	 * Parameter-Konstruktor erzeugt Knoten mit Schl&uumlssel data
	 * @param data der Wert
	 */
	public BinNode(T data){
		this();
		this.data = data;		
	}
	/**
	 * Erzeugt einen Knoten mit all seinen Attributen
	 * @param data Knotenschl&uumlssel
	 * @param left Zeiger auf linken Nachfolger
	 * @param right Zeiger auf rechten Nachfolger
	 */
	public BinNode(T data, BinNode<T> left, BinNode<T> right){
		this.data = data;
		this.left = left;
		this.right = right;
	}
	
	@Override
	/**
	 * &Uumlberschreibt die Methode compareTo() aus Comparable
	 * Vergleicht den Inhalt zweier Knoten
	 */
	public int compareTo(BinNode<T> o) {
		int comparator = 0;
		//1. Fall: data ist der Klasse Student
		if(this.data instanceof Student && o.data instanceof Student){
			Student st1 = (Student) this.data;
			Student st2 = (Student) o.data;
			comparator = st1.compareTo(st2); //Methode compareTo() aus Student
		}
		//2. Fall: data ist Integer
		if(this.data instanceof Integer && o.data instanceof Integer){
			Integer i1, i2;
			i1 = (Integer)this.data;
			i2 = (Integer)o.data;
			comparator = i1.compareTo(i2); //Methode compareTo() aus Integer
		}
		//3. Fall: data ist Float
		if (this.data instanceof Float && o.data instanceof Float){
			Float f1,f2;
			f1 = (Float)this.data;
			f2 = (Float)o.data;
			comparator = f1.compareTo(f2);//Methode compareTo() aus Float
		}
		return comparator;
	}

	
	@Override
	/**
	 * Darstellung von einem Knoten
	 */
	public String toString() {
		return "[ " + data + " ]\n" ; //es wird nur der Wert angezeigt
	}
	
	
	
	

}
