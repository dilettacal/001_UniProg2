import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import trees.bynary_trees.BinNode;
import trees.bynary_trees.BinTree;

/**
 * 
 */

/**
 * 26.06.2017
 * BinTreeTest.java
 * package  
 */
public class BinTreeTest {
	
	//Leerer Baum
	BinTree lb = new BinTree();
	
	//Ein-Elementiger Baum
	BinNode root = new BinNode(7);
	BinTree oneElement = new BinTree(root);
	
	//Baum aus Blatt 10
	BinNode n1 = new BinNode(1);
	BinNode n2 = new BinNode(3);
	BinNode f1 = new BinNode(2,n1,n2); //father
	BinNode n3 = new BinNode(5);
	BinNode f2 = new BinNode(4,f1,n3);//father
	BinNode n4 = new BinNode(8);
	BinNode f3 = new BinNode(9,n4,null);
	BinNode wurzel = new BinNode(7,f2,f3);
	
	BinTree tree = new BinTree(wurzel);
	
	@Test
	public void testIsEmptyLeererBaum(){
		assertTrue(lb.isEmpty());
	}
	@Test
	public void testIsEmptyNurWurzel(){
		assertTrue(!oneElement.isEmpty());
	}
	@Test
	public void testIsEmptyNormalBaum(){
		assertTrue(!tree.isEmpty());
	}
	
	@Test
	public void testInnerNodesEmptyTree(){
		//ein leerer Baum liefert 0
		assertEquals(lb.countInnerNodes(),0);
	}
	
	@Test
	public void testInnerNodesOnlyRoot(){
		//Innerknoten = Knoten mit Kind(er)
		assertEquals(oneElement.countInnerNodes(), 0);
	}
	
	@Test
	public void testInnerNodesNormalTree(){
		//Innerknoten: 7, 4, 9, 2
		assertEquals(tree.countInnerNodes(), 4);
	}
}
