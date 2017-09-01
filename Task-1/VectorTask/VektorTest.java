/*
 * Klasse VektorTest
 * 
 * Author: Diletta Calussi
 * Matrikel-Nr.: s0559842
 * 
 * 18.04.2017
 * 
 * Programmierung 2 - Blatt 1
 * Aufgabe 1.1
 * 
 * Test der Klasse Vektor
 */
public class VektorTest {

	public static void main(String[] args){
		float[] k1 = {1.4f,5.3f,19.0f,20.33f, 4.5f};
		float[] k2 = {3.0f, 10.f, 4.4f};
		float[] k3 = {1.4f,5.3f,19.0f,20.33f};
		float[] k5 = {3.4f, 10.4f, 6.4f, 12.9f};
		float[] k6 = {3.0f, 1.0f, 4.4f, 18.9f, 18.6f};
		
		//Test der Methoden
		Vektor v1, v2, v3, v5;
		
		v1 = new Vektor(5,k1,true); //Korrekt erzeugt
		System.out.println(v1.toString()); 
		v2 = new Vektor(4,k1,false); //Fehlermeldung 
		v2.setDim(5); //Korrektur des Attributs dim
		System.out.println();
		System.out.println(v2.toString());	
		System.out.println();
		System.out.println("Test Skalarprodukt 1:");
		try {
			v2.skalarProdukt(v1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} //824.6089
		v2 = new Vektor(5,k6,true);
		System.out.println("Test Skalarprodukt 2:");
		try {
			v2.skalarProdukt(v1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} // 561.037
		v1 = new Vektor(3,k2);
		System.out.println(v1.toString());
		System.out.println();
		System.out.println("Test Skalarprodukt 3: ");
		try {
			v2.skalarProdukt(v1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} //Fehlermeldung
		System.out.println();
		v3 = new Vektor(k3);
		v3.setDarstellung(false); //Spaltenvektor
		v3.getKomponenten(); //Ausgabe als Spaltenvektor
		System.out.println(v3.toString());
		v5 = new Vektor(k5);
		System.out.println(v5.toString());
		System.out.println("Test Skalarprodukt 4: ");
		try {
			v3.skalarProdukt(v5);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		v3.setKomponenten(k6);
		v3.setDim(5);
		v3.getKomponenten();
		System.out.println();
		System.out.println(v3.getDim());
		System.out.println();
		v3.transponiere();
		v5.transponiere();
		v3.transponiere();
		System.out.println();
		v5.transponiere();		
	}

}
