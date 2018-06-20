package generische_baeume;

/**
 * 
 * @param <T> Generische BinTree
 * 03.07.2017
 * BinTree.java
 * package generische_baeume
 */
public class BinTree<T> {
	//Datenfeld 
	BinNode<T> root = null;
	
	/**
	 * Default-Konstruktor erzeugt einen leeren Baum
	 */
	public BinTree(){
		root = null;
	}
	
	/**
	 * Erzeugt einen BinTree-Objekt mit Wurzel
	 * @param r die Wurzel
	 */
	public BinTree(BinNode<T> r){
		root = r;
	}
	
	/**
	 * Liefert Wurzelknoten zur&uumlck
	 * @return Wurzelknoten
	 * @throws NullPointerException, falls Baum leer ist
	 */
	public T getRoot() throws NullPointerException{
		BinNode <T> r = root;
		if(root != null) return r.data;
		else throw new NullPointerException("Baum ist leer!");
	}
	/**
	 * Pr&uumlft, ob Baum leer ist
	 * @return true, wenn Baum leer
	 */
	public boolean isEmpty(){
		return root == null;
	}
	
	/**
	 * F&uumlgt einen Knoten in den Baum. Der Baum bleibt weiterhin sortiert.
	 * @param k der Startknoten
	 * @param neu der neue Knoten
	 */
	private void insertNode (BinNode<T> k, BinNode<T> neu){
		//Der Vergleich erfolgt anhand der Methode compareTo() aus BinNode
		if(k!=null){
			if(neu.compareTo(k)<0){ 
				if(k.left != null){
					insertNode(k.left,neu);
				} else {
					k.left = neu;
				}
			} else if(neu.compareTo(k) > 0){
				if(k.right != null){
					insertNode(k.right,neu);
				} else {
					k.right = neu;
				}
			} else System.out.println("Duplikate nicht erlaubt!");
		} else { //Fall: Baum ist leer
			root = neu;
		}
	}
	/**
	 * F&uumlgt einen Knoten mit dem Schl&uumlssel data in den Baum
	 * @param data der Schl&uumlssel vom neuen Knoten
	 */
	public void insertNode(T data){
		BinNode <T> newNode = new BinNode<T>(data);
		insertNode(root,newNode);
	}
	
	/**
	 * Gibt Baum in InOrder-Reihenfolge aus
	 * @param k der Startknoten
	 */
	private void printInOrder(BinNode<T>k){
		if (k!= null){
			//System.out.print("(");
			printInOrder(k.left);
			System.out.print(k.data + "| ");
			printInOrder(k.right);
		//	System.out.print(")");//ungeeinget fuer Typ Student
		} 
	}
	/**
	 * Gibt den Baum in InOrder-Reihenfolge aus
	 * @see #printInOrder(BinNode)
	 */
	public void printInOrder(){
		printInOrder(root);
		System.out.println();
	}
	
	/**
	 * Sucht nach einem Knoten mit Sch&uumlssel value im Baum mit Wurzel start
	 * @param start der Startknoten
	 * @param value der gesuchte Schl&uumlssel
	 * @return Knoten mit Wert value oder null, falls Knoten nicht enthalten
	 */
	private BinNode<T> searchNode(BinNode<T> start, T value){
		BinNode<T> temp = new BinNode<>(value);
		BinNode<T> foundNode = start;
		if(start!=null){
			if(foundNode.data != value){
				if(temp.compareTo(foundNode) < 0){
					foundNode = searchNode(foundNode.left, temp.data);
				}
				else if(temp.compareTo(foundNode)>0){
					foundNode = searchNode(foundNode.right,temp.data);
				}
				
			}
		} 
		else return null;
		
		return foundNode;
	}
	/**
	 * Sucht nach einem Knoten mit Schl&uumlssel value
	 * @param value der Schl&uumlssel
	 * @see #searchNode(BinNode, Object)
	 */
	public void searchNode(T value){
		BinNode<T> temp = searchNode(root,value);
		if(temp!=null){
			//suche erfolgreich
			System.out.println("Node gefunden: " + temp);
		}
			//erfolglose Suche
		else System.out.println("Node nicht gefunden!");
	}
	
	/**
	 * Pr&uumlft, ob der Baum sortiert ist
	 * @return true, wenn Baum sortiert
	 * @see #isSorted(BinNode)
	 */
	public boolean isSorted(){
		return isSorted(root);
	}
	/**
	 * Pr&uumlft, ob der Baum sortiert ist
	 * @param k der Startknoten
	 * @return true, wenn der Baum sortiert ist
	 */
	private boolean isSorted(BinNode<T> k){
		boolean check = false;
		//Annahme: ein leerer Baum ist nicht sortiert
		if(k== null) return false;
		if(k!=null){ //ein elementiger Baum
			//Annahme: ein Blatt an sich selbst ist sortiert
			//Die Pruefung dass ein Unterbaum sortiert ist
			//erfolgt beginnend von einem Elternknoten
			if(k.left == null && k.right == null) { 
				return true; //sortiert
			}
		}
		//Wenn k linkes Kind hat, traversiere Baum
		//bis zum Blatt
		if (k.left != null){
			if(!isSorted(k.left)){ //sofern Unterbaum false liefert
				return false; //liefer sofort false
			}
		}
			
		
		//wenn k rechtes Kind hat, traversiere Baum
		//bis zum Blatt
		if (k.right != null){
			if(!isSorted(k.right)){ //sofern false
				return false; //liefer sofort false
			}
		}
		//Pruefe im Unterbaum ab Knoten k
		check = isTreePartSorted(k);
		if(check) return true;
		return false;
		
	}
	
	/**
	 * Die Methode pr&uumlft, ob ein Baum ab Knoten k ein BST ist.<br>
	 * Bedingungen: 
	 * 1) Falls nur linkes Nachkommen, k.left < k.data
	 * 2) Falls nur rechtes Nachkommen, k.right > k.data
	 * 3) Falls beide, k.left < k.data && k.right > k.data
	 * @param k  Startknoten f&uumlr die Untersuchung
	 * @return true  falls Teilbaum sortiert unter den o.g. Bedingungen
	 */
	private boolean isTreePartSorted (BinNode<T> k){
		//Fallunterscheidung:
		//1. Fall: k hat nur linkes Kind
		if(k.left != null && k.right == null){
			if(k.left.compareTo(k)<0) return true;
		}
		//2. Fall: k hat nur rechtes Kind
		else if(k.left==null && k.right != null){
			if(k.right.compareTo(k) > 0) return true;
		}
		//3. Fall: k hat beide Kinder
		else if(k.left != null && k.right != null){
			if(k.left.compareTo(k) < 0 && k.right.compareTo(k) > 0){
				return true;
			}
		}
		return false;
	}
}
