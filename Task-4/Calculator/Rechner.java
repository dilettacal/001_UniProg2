/**
 * @author Diletta Calussi 
 * Matrikel-Nr.: s0559842 
 * Datum: 06.05.2017
 * 
 * Klasse Rechner
 * 
 * Die Klasse simuliert einen einfachen Rechner mit den grundlegenden
 * Rechenop: Addition, Multiplikation, Subtraktion, Division
 * 
 */

public class Rechner {

	/**
	 * Strings-Array args ueber die Konsole uebergeben
	 * 
	 * Wenn 1. und 3. Strings keine numerische Werte enthalten, wird eine Fehlermeldung ausgegeben
	 * 
	 * Ausgehend vom Parameter am Index 1 (Operator) wird die Operation auf die
	 * Zahlen durchgefuehrt Die Operation-Auswahl erfolgt nach der
	 * Zahlenauswertung, die ueber die Methode bothInt() hergeleitet wird
	 * 
	 * Ergebnis wird einer output-String angehaengt und ausgegeben
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		String s1 = args[0]; // 1. Zahl als Parameter
		String s3 = args[2]; // 2. Zahl als Parameter
		String s2 = args[1]; // Keyword fuer Operation
		String result = s1 + " " + s2 + " " + s3 + " ist "; // Output-String
		int opInt = 0; // speichert Integer-Ergebnis
		double opDouble; // speichert double-Ergebnis
		boolean check = bothInt(s1, s3); //beide Zahlen Integers
		boolean check2 = checkIfZahl(s1,s3);//Strings numerisch
		
		if(check2 == false){ //Falls Strings keine numerische Werte enthalten
			System.out.println("Zahlformat falsch!");
		}
		
		// prueft keyword in s2
		switch (s2) {
		// case Addition
		case "add":
			if (check) { // wenn Zahlen beide Integer
				opInt = add(Integer.parseInt(s1), Integer.parseInt(s3)); // addition
				result += opInt;
			} else { // wenn nicht --> addiere fuer gebrochene Zahlen
				opDouble = add(Double.parseDouble(s1), Double.parseDouble(s3)); // ruft
																				// Methode
																				// fuer
																				// Double-Zahlen
																				// auf
				result += opDouble;
			}
			break;
		// case Multiplikation
		case "mul":
			if (check) { // mult fuer int
				opInt = mul(Integer.parseInt(s1), Integer.parseInt(s3)); // ruft
																			// Methode
																			// fuer
																			// Int-Zahlen
																			// auf
				result += opInt;
			} else {
				opDouble = mul(Double.parseDouble(s1), Double.parseDouble(s3)); // ruft
																				// Methode
																				// fuer
																				// Double-Zahlen
																				// auf
				result += opDouble;
			}
			break;

		// case Subtraktion
		case "sub":
			if (check) {
				opInt = sub(Integer.parseInt(s1), Integer.parseInt(s3)); // ruft
																			// Methode
																			// fuer
																			// Int-Zahlen
																			// auf
				result += opInt;
			} else {
				opDouble = sub(Double.parseDouble(s1), Double.parseDouble(s3)); // ruft
																				// Methode
																				// fuer
																				// Double-Zahlen
																				// auf
				result += opDouble;
			}
			break;
		// case division
		case "div":
			if (check) {
				try {
					opDouble = div(Integer.parseInt(s1), Integer.parseInt(s3)); // ruft
																				// Methode
																				// fuer
																				// Int-Zahlen
					result += opDouble;
				} catch (ArithmeticException e) { // faengt Ausnahme
														// Division durch Null
					result = e.getMessage();
					// System.out.println(e.getMessage());
				}
				break;

			} else {
				try {
					opDouble = div(Double.parseDouble(s1), Double.parseDouble(s3)); // ruft
																					// Methode
																					// fuer
																					// Double-Zahlen
					result += opDouble;
				} catch (ArithmeticException e) { // faengt Ausnahme
														// Division durch Null
					result = e.getMessage();
				}
				break;
			}

		default:
			System.out.print(s2 + " ist kein gueltiges Schluesselwort!"); // falls
																			// Schluesselwort
																			// Fehler
																			// enthaelt
			result = "";//leere String
		}
		System.out.println(result);
	}

	/**
	 * Die Methode prueft ob die eingegebenen Zahlen beide Integer sind
	 * Die Methode vermeidet auch overflow/underflow der
	 * Parameter im INT-Bereich
	 * @param String
	 *            n1 (1. Stelle in args)
	 * @param String
	 *            n2 (3. Stelle in args)
	 * 
	 * @return true wenn beide Integers
	 */
	public static boolean bothInt(String n1, String n2) {
		try {
			Integer.parseInt(n1);
			Integer.parseInt(n2);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
	/**
	 * Methode prueft, dass 1. und letzte String in args
	 * numerische Werte enthalten
	 * @param n1
	 * @param n2
	 * @return true wenn Strings numerisch
	 */
	public static boolean checkIfZahl(String n1, String n2){
		try{
			Double.parseDouble(n1);
			Double.parseDouble(n2);
			return true;
		} catch (NumberFormatException e){
			return false;
		}
	}

	/**
	 * Methode zur Addition zwei int Zahlen
	 * 
	 * @param a
	 * @param b
	 * @return summe
	 * 
	 */

	public static int add(int a, int b) {
		return a+b;
	}

	/**
	 * Ueberladene Methode zur Addition zweier gebrochenen Zahlen
	 * 
	 * @param a,
	 *            b long-Uahlen
	 * @return summe
	 */
	public static double add(double a, double b) {
		return a + b;
	}

	/**
	 * Methode zur Berechnung der Multiplikation zweier Integers
	 * 
	 * @param a
	 * @param b
	 * @return multiplikation
	 */
	public static int mul(int a, int b) {
		return a * b;
	}

	/**
	 * Ueberladene Methode Multiplikation zweier gebrochenen Zahlen
	 * 
	 * @param a
	 * @param b
	 * @return multiplikation
	 */
	public static double mul(double a, double b) {
		return a * b;
	}

	/**
	 * Methode berechnet Subtraktion zweier Integers
	 * 
	 * @param a
	 * @param b
	 * @return subtraktion
	 */
	public static int sub(int a, int b) {
		return a - b;
	}

	/**
	 * Ueberladene Methode Subtraktion gebrochener Zahlen
	 * 
	 * @param a
	 * @param b
	 * @return subtraktion
	 */
	public static double sub(double a, double b) {
		return a - b;
	}

	/**
	 * Methode berechnet Division zweier Integer-Zahlen
	 * 
	 * @param a
	 * @param b
	 * @return division als double-Wert
	 * @throws ArithmeticException bei / durch Null
	 */
	public static double div(int a, int b) throws ArithmeticException {
		if (b == 0)
			throw new ArithmeticException("Division durch Null unzulaessig!");
		else
			return (double) a / b;
	}

	/**
	 * Uberladene Methode Berechnung der Division zweier gebrochenen Zahlen
	 * 
	 * @param a
	 * @param b
	 * @return Division als double-Wert
	 * @throws ArithmeticException bei / durch Null
	 */
	public static double div(double a, double b) throws ArithmeticException {

		if (b == 0)
			throw new ArithmeticException("Division durch Null nicht moeglich!");
		else
			return a / b;
	}

}
