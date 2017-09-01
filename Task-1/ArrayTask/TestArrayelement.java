/*
 * Klasse TestArrayelement
 * 
 * Author: Diletta Calussi
 * Matrikel-Nr.: s0559842
 * 
 * 18.04.2017
 * 
 * Programmierung 2 - Blatt 1
 * Aufgabe 1.1 
 * 
 * Test der Klasse Arrayelement
 */

public class TestArrayelement {

	public static void main(String[] args) {
		
		try{
			float[] arr = null;
			Arrayelement.findeHaeufigst(arr);
		} catch (NullPointerException e){
			System.out.print(e.getMessage());
		}
		System.out.println();		
		float[] a1 = { 1.1f, 2.5f, 5.5f, 1.1f, 5.6f, 1.1f, 10.0f, 10.0f, 10.0f }; //2 Elemente
		Arrayelement.findeHaeufigst(a1);
		System.out.println();
		System.out.println();
		float[] a2 = { 1.5f, 2.3f, 3.5f, 4.5f, 5.6f, 6.6f, 7.2f}; //Kein Element
		Arrayelement.findeHaeufigst(a2);
		System.out.println();
		System.out.println();
		float[] a4 = { 1.5f, 1.5f, 2.3f, 3.3f, 3.3f, 3.3f, 3.3f, 1.5f, 1.5f, 9.1f, 10.4f, 10.4f, 10.4f, 10.4f}; //4 Elemente
		Arrayelement.findeHaeufigst(a4);
		System.out.println();
		System.out.println();
		float[] test1 = {2.4f, 6.9f, 18.4f, 2.4f, 7.4f, 7.4f, 2.4f, 2.4f}; //1 Element
		Arrayelement.findeHaeufigst(test1);
		System.out.println();	
		System.out.println();
		float [] test2 = {5.5f, 7.2f, 8.2f, 7.2f, 9.0f, 7.2f}; //1 Element
		Arrayelement.findeHaeufigst(test2);
		System.out.println();
		System.out.println();
		float [] test3 = {1.4f, 1.4f, 1.4f, 1.4f, 1.4f, 1.4f, 1.4f}; //1 Element, da alle gleich
		Arrayelement.findeHaeufigst(test3);

	}


}
