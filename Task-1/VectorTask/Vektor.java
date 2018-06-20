/*
 * Klasse Vektor
 * 18.04.2017
 * 
 * Programmierung 2 - Blatt 1
 * Aufgabe 1.1
 * 
 * Klasse zur Erzeungung und Behandlung von
 * Vektor-Objekten
 * 
 * Konstruktoren: 
 * Parameter: Alle Attributen, dimension und komponenten, nur komponenten
 * 
 * Export-Methoden: transponiere(), 
 * skalarprodukt(vektor b),
 * toString()
 * Setter: setDim(), setKomponenten(), setDarstellung
 * Getter: getDim(), getKomponenten(), getDarstellung 
 * Service-Methoden: ausgabeAlsZeilenvektor(), 
 * ausgabeAlsSpaltenvektor() 
 * 
 */
public class Vektor {

	// Attribute der Klasse Vektor
	private int dimension;
	private float[] komponenten;
	private boolean istZeilenvektor = true; // Standard gesetzt, falls nicht im
											// Konstruktor festgelegt

	//Konstruktor mit allen Parametern
	public Vektor(int d, float[] k, boolean z) {
		istZeilenvektor = z;
		komponenten = k;
		try {
			if (d == k.length) {
				dimension = d;
			} else
				throw new Exception("Dimension und Anzahl der Komponenten muessen gleich sein!");
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}

	}

	//Konstruktorn mit Parametern: Dimension, Komponenten
	public Vektor(int d, float[] k) {
		komponenten = k;
		istZeilenvektor = true;
		// Prueft ob dimension = komponenten.length, sonst Fehlermeldung
		try {
			if (d == k.length) {
				dimension = d;
			} else
				throw new Exception("Dimension und Anzahl der Komponenten muessen gleich sein!");
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}

	// Konstruktor nur mit Komponenten-Array als Parameter 
	public Vektor(float[] k) {
		// Dimension nicht festgelegt, dimension == k.length 
		int dim = k.length;
		dimension = dim;
		komponenten = k;
		istZeilenvektor = true;
	}

	// Methode zum Transponieren des Vektors 
	public void transponiere() {
		if (istZeilenvektor == true) {
			System.out.println("Transponiere zum Spaltenvektor: ");
			ausgabeAlsSpaltenvektor();
			istZeilenvektor = false;
		} else {
			System.out.print("Transponiere zum Zeilenvektor: ");
			ausgabeAlsZeilenvektor();
			istZeilenvektor = true;
		}
	}

	// Ausgabe des Vektors als Zeilenvektor
	private void ausgabeAlsZeilenvektor() {
		float[] a = komponenten;
		int laenge = a.length;
		for (int i = 0; i < laenge; i++) {
			if (i == 0) {
				System.out.print("(");
				System.out.printf("%3.2f, ", a[i]);
			}
			if (i == a.length - 1) {
				System.out.printf("%3.2f)", a[i]);
			} else {
				System.out.printf("%3.2f, ", a[i]);
			}
		}
	}

	// Ausgabe des Vektors als Spaltenvektor 
	private void ausgabeAlsSpaltenvektor() {
		float[] a = komponenten;
		int laenge = a.length;
		for (int i = 0; i < laenge; i++) {
			System.out.printf("%3.2f\n", a[i]);
		}
	}

	// Berechnung des Skalarprodukts
	public void skalarProdukt(Vektor b) throws Exception {
		float skalarprodukt = 0.0f;
		// Bedingung fuer Skalarprodukt:
		// Dimensionen muessen gleich sein
		if (this.dimension == b.dimension) {
			System.out.print("Skalarprodukt = ");
			int laenge = this.dimension;
			for (int i = 0; i < laenge; i++) {
				skalarprodukt += (this.komponenten[i] * b.komponenten[i]);
			}
			System.out.println(skalarprodukt);
		} else
			throw new Exception("Die Dimensionen der 2 Objekte muessen gleich sein!"); // Ausnahme
	}

	// Setter der Dimension
	public void setDim(int d) {
		int dim = this.dimension;
		try {
			if (d == komponenten.length) { // Bedingung fuer Aenderung der
											// Dimension
				dimension = d;
			} else {
				dimension = dim;
				throw new Exception("Dimension muss mit der Komponentenanzahl gleich sein!");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

	//Abrufen der Dimension
	public int getDim() {
		System.out.print("Vektor hat Dimension = ");
		return dimension;
	}

	//Setter der Komponenten
	public void setKomponenten(float[] k) {
		try {
			if (komponenten.length == k.length && dimension == komponenten.length) {
				komponenten = k;
			} else
				throw new Exception("Laenge groesser als Dimension nicht erlaubt!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	//Ablesen der Komponente
	public void getKomponenten() {
		System.out.println("Ausgabe der Komponenten: ");
		if (istZeilenvektor == true)
			this.ausgabeAlsZeilenvektor();
		else
			this.ausgabeAlsSpaltenvektor();
	}

	//Setter der Dartstellung
	public void setDarstellung(boolean w) {
		if (w == true) {
			istZeilenvektor = true; // Zeilendarstellung
		} else
			istZeilenvektor = false; // Spaltendarstellung
	}

	//Ausgabe Vektor-Darstellung
	public String getDarstellung() {
		String s = "";
		if (istZeilenvektor == true) {
			s = "Vektor ist ein Zeilenvektor";
		} else
			s = "Vektor ist ein Spaltenvektor";
		return s;
	}

	// Methode zur graphischen Darstellung von Vektoren
	public String toString() {
		String vektor = "";
		System.out.println("Objekt Vektor. Eigenschaften: ");
		vektor = "Dimension: " + this.dimension + "\n";
		vektor += getDarstellung() + "\nKomponenten: ";
		int laenge = komponenten.length;
		//Auflistung der Komponenten
		for (int i = 0; i < laenge; i++) { 
			if (i == laenge - 1) {
				vektor += this.komponenten[i];
			} else {
				vektor += this.komponenten[i] + ", ";
			}
		}
		return vektor;
	}

}
