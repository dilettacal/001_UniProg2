/*
 * Author: Diletta Calussi
 * Matrikel-Nr.: s0559842
 * Datum: 01.05.2017
 * 
 * Klasse Bitpattern
 * 
 * 
 */
public class Bitpattern {
	
	public static int setBit(int number, int position) throws IllegalArgumentException {
		//int = max 32 bit
		if (position > 31 || position < 0){
			throw new IllegalArgumentException("Position unzulaessig!");
		}
		int one = 1; 
		one = one << position; //schiebe 1 um position-stellen nach links
		int result = number | one; //OR --> wenn belegt kein 1 eingesetzt
		return result;
	}
	
	/*
	 * number wird nach Potenzintervallen betrachtet 
	 * Bsp: 2^3 < 10 < 2^4 --> arrays mit 4 Stellen noetig: 
	 * inBinary(10) --> 1010 
	 * Variable i soll die Array-Laenge ermitteln
	 */
	public static int[] inBinary(int number) throws IllegalArgumentException {
		long check = 1; // long noetig zur Darstellung der Zahl 2^31
		int i = 0;
		//negatives Argumetn nicht erlaubt
		if (number < 0){
			throw new IllegalArgumentException("Nur positive ganze Zahlen erlaubt!");
		}
		
		//Ermittlung der Array-Laenge
		if (number == 0) {
			i = 1; //Array der Laenge 1
		} else {
			while (check <= number) {
				check = check << 1; 
				i++; 
			}
		}
		
		int[] toBin = new int[i]; // Array zur Umwandlung von number
		int l = toBin.length - 1;
		
		for (int j = 0; j < toBin.length; j++) {
			if ((number & 1) == 1) {
				toBin[l - j] = 1;
			} else {
				toBin[l - j] = 0;
			}
			number = number >> 1;
		}
		return toBin;
	}
	
	 // Array-Ausgabe
		public static void printBinpattern(int[] n) throws NullPointerException {
			if (n == null) throw new NullPointerException("Array muss initialisiert sein!");
			for (int i = 0; i < n.length; i++) {
				System.out.print(n[i]);
			}
			System.out.println();
		}

		
		public static boolean endsOn (int number, String pattern){
			//char-Werte in pattern:
			char c0 = '0'; 
			char c1 = '1';
			//Integer-Werte aus char-Werten zum Vergleich
			int zero = c0; // 48 
			int eins = c1; // 49 
			
			int l = pattern.length() - 1;
			for (int i = 0; i < pattern.length(); i++){
				int bitCheck = number&1; //letzte Stelle in number
				char strCheck = pattern.charAt(l-i); //letzte Stelle in pattern
				
				//Bedingungen fuer nicht-Matching:				
				if ((strCheck == eins && bitCheck != 1) 
					|| (strCheck == zero && bitCheck !=0)){
					return false; //sobald eine zutrifft
				}
				number = number >> 1; //shift nach rechts
			}
			//falls Matching-Bedingungen nicht erfuellt
			//number endet auf pattern
			return true; 		
		}
	
	
	

}
