/*
 * Klasse Arrayelement
 * 
 * 18.04.2017
 * 
 * Programmierung 2 - Blatt 1
 * Aufgabe 1.2 
 * 
 * Das Programm soll haufigste(s) Element(e) in einem 
 * als Parameter uebergegebenen float array suchen und
 * sie in einem array speichern.
 * Das Array der haeufigst. Elementen wird dann 
 * dementsprechend ausgegeben
 * 
 */
import java.util.Arrays;

public class Arrayelement {
	
	public static void findeHaeufigst(float[] arr) throws NullPointerException {
		
		if (arr == null) throw new NullPointerException("Array darf nicht null sein!");

		int[] wdh = new int[arr.length]; // speichert Wiederholungen der arr-Elemente	
		
		// 1. Schritt: Array sortieren
		Arrays.sort(arr);
		System.out.println("Array sortiert:" + Arrays.toString(arr));

		
		float zI = 0.0f; // speichert a[i]
		float zJ = 0.0f; // speichert a[j]
		int i = 0; //Laufvariable fuer for-Schleife
		int j = 0;
		int w = 0; //speichert Wiederholung
		int end = arr.length - 1;
		
		//2. Schritt: wdh-Array ausfuellen, Keine Wiederholung --> Wert 0 in wdh
		
		for (i = 0; i < arr.length && j < arr.length - 1; i++) {
			j = i + 1;
			zJ = arr[j]; // Nachfolger
			zI = arr[i]; 
			if (i == end - 1) { //Bearbeite letztes und vorletztes Element
				if (arr[i + 1] == arr[i]) { 
					w = zaehleWdh(arr, arr[end]);
					if (w > 1) { //Betrachte nur Wdh > 1
						wdh[end] = w;
					}
				}
			}
			if (zJ > zI) {
				w = zaehleWdh(arr, arr[i]);
				if (w > 1) {
					wdh[i] = w; 
				}

			}

		}
		//Zum Testen des wdh-Array
		//System.out.print("Array der Wiederholungen:");
		//System.out.println(Arrays.toString(wdh));

		int maxWdh = findeMaxWdh(wdh); //speichert Max-Wert aus wdh				
		if (maxWdh == 0) { //Fall: kein Element wiederholt sich
			System.out.print("Elemente kommen gleich so oft vor:" );
			System.out.print(Arrays.toString(arr));
			
		} else {
			float[] ergebnis = new float[arr.length]; //speichert haeufigste(s) Element(e)
			int y = 0;
			for (int x = 0; x < wdh.length && y < wdh.length; x++) {
				if (wdh[x] == maxWdh){
					ergebnis[y] = arr[x];
					y++;
				}
			}
//			System.out.println(Arrays.toString(ergebnis)); //Zum Testen
			ausgabeArray(ergebnis);
		}

	}

	// Methode zaehlt Wiederholungen von k in array a
	private static int zaehleWdh(float[] a, float k) {
		int zaehler = 0;

		for (int i = 0; i < a.length; i++) {
			if (a[i] == k) {
				zaehler++;
			}
		}
		return zaehler;

	}
	
	//Methode sucht groesste Wiederholung
	private static int findeMaxWdh(int[] a) {
		int max = a[0];
		for (int i = 0; i + 1 < a.length; i++) {
			if (a[i + 1] > a[i]) {
				if (a[i + 1] >= max) {
					max = a[i + 1]; // aktualsiiert max-Wert
				}
			}
		}
		return max;

	}
	
	//Methode zur Array-Ausgabe ohne 0-Werten (nicht belegtes Feld)
	private static void ausgabeArray(float[] arr) {
		System.out.print("Array der haeufigsten Elemente: ");
		System.out.print("[");
		int j = 0;
		for (int i = 0; i < arr.length && j + 1 < arr.length; i++) {
			j = i + 1;
			if (arr[i] != 0) {
				if (arr[j] != 0) {
					System.out.print(arr[i] + ", ");
				}
				if (i == arr.length - 1 || arr[j] == 0) {
					System.out.print(arr[i]);
				}
			}
		}
		System.out.print("]");
	}

}