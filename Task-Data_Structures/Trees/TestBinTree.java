import trees.bynary_trees.*;


/**
 * 
 */

/**
 * 23.06.2017
 * TestBinTree.java
 * package  
 */
public class TestBinTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Baum aus VL
		BinNode k1 = new BinNode(6);
		BinNode k2 = new BinNode(7);
		BinNode m1 = new BinNode(4, k1, k2);
		BinNode m2 = new BinNode(5);
		BinNode m = new BinNode(2, m1, m2);
		BinNode n = new BinNode(3);
		BinNode o = new BinNode(1, m, n);
		BinTree baum = new BinTree(o);
		System.out.println(baum.calculateDepth());
		System.out.println(baum.countNodes());
		System.out.println(baum.printInOrder());
		System.out.println("Anzahl Blaetter = " +baum.countLeaves());
		System.out.println(baum.printPreOrder());
		System.out.println(baum.printPostOrder());
		baum.breadthFirst(); System.out.println();
		System.out.println(baum.countInnerNodes());
		
		//Baum der Abgabe
		System.out.println("Test Baum vom Blatt 10");
		BinNode n1 = new BinNode(1);
		BinNode n2 = new BinNode(3);
		BinNode f1 = new BinNode(2,n1,n2); //father
		BinNode n3 = new BinNode(5);
		BinNode f2 = new BinNode(4,f1,n3);//father
		BinNode n4 = new BinNode(8);
		BinNode f3 = new BinNode(9,n4,null);
		BinNode wurzel = new BinNode(7,f2,f3);
		BinTree tree = new BinTree(wurzel);
		
		System.out.println(tree.calculateDepth()); //3
		System.out.println(tree.countNodes()); //8
		System.out.println(tree.countInnerNodes()); //4
		System.out.println(tree.countLeaves());//4
		System.out.println(tree.printPreOrder());
		
		tree.printTree(1);
		tree.printTree(2);
		tree.printTree(3);
		tree.printTree(4);
		System.out.println();
		System.out.println(tree.isSorted());
		System.out.println(baum.isSorted()); //false
		System.out.println(tree.calculateDepthIter());
		BinNode test = new BinNode(9);
		BinTree one = new BinTree(test);
		System.out.println(one.isSorted()); //one node tree is always sorted
		BinTree leer = new BinTree();
		System.out.println(leer.isSorted()); //empty tree is never sorted!
		
	}

}
