

import generische_baeume.BinNode;
import generische_baeume.BinTree;
import generische_baeume.Student;
/**
 * 03.07.2017
 * TestGenericTree.java
 */
public class TestGenericTree {

	public static void main(String[] args) {
		BinTree<Integer> tree1 = new BinTree<>();
		//Baum aus UB 10
		tree1.insertNode(7);
		tree1.insertNode(4);
		tree1.insertNode(9);
		tree1.insertNode(2);
		tree1.insertNode(5);
		tree1.insertNode(1);
		tree1.insertNode(3);
		tree1.insertNode(8);
		tree1.printInOrder();
		System.out.println();
		
		BinTree<Float> tree2 = new BinTree<>();
		tree2.insertNode(8.f);
		BinNode<?>[] arr = new BinNode<?>[5];
		arr[0] = new BinNode<Float>(55.55f);
		arr[1] = new BinNode<Float>(6.4f);
		arr[2] = new BinNode<Float>(18.9f);
		arr[3] = new BinNode<Float>(-5.2f);
		arr[4] = new BinNode<Float>(7.8f);
		
		for (int i = 0; i < arr.length; i++){
			tree2.insertNode((Float)arr[i].data);
		}
		
		tree2.printInOrder();
		System.out.println();
		
		BinTree <Student> studTree = new BinTree<>();
		Student s1 = new Student("Michael", "Rot", 568468);
		studTree.insertNode(s1);
		Student s2 = new Student("Sarah", "Rieman", 568468);
		Student s3 = new Student("Diletta", "Calussi", 568468);
		Student s4 = new Student("Johnatan", "Kantor", 568468);
		Student s5 = new Student("Martina", "Ronki", 568468);
		Student s6 = new Student("Matthias", "Alter", 568468);
		studTree.insertNode(s2);
		studTree.insertNode(s3);
		studTree.insertNode(s4);
		studTree.insertNode(s5);
		studTree.insertNode(s6);
		
		studTree.printInOrder();
		System.out.println("Baum sortiert: " + studTree.isSorted());
		
		tree2.searchNode(-5.2f);
		tree2.searchNode(.2f);
		studTree.searchNode(s6);
	}

}
