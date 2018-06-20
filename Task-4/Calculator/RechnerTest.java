/**
 * 
 * Datum: 07.05.2017
 * 
 * Testklasse fuer Klasse Rechner
 */

public class RechnerTest {

	public static void main(String[] args) {
		
		//Test both integer
		String [] s = {"10", "add", "8"}; //result = 18	
		
		//Test Eingabezahl-Format
		boolean check1 = Rechner.checkIfZahl(s[0], s[2]);
		System.out.println(check1); //true
		s[0] = "a";
		s[2] = "5";
		check1 = Rechner.checkIfZahl(s[0], s[2]);
		System.out.println(check1); //falsches Format
		
		//Reset
		s[1] = "add";
		s[0] = "10";
		
		System.out.println("Test for Intgers: ");
		
		boolean check2 = Rechner.bothInt(s[0],s[2]); //prueft 1. und 3. String nach int Werten
		System.out.println(check2); //true	
		int a = Integer.parseInt(s[0]); //Auswertung Zahl1
		int b = Integer.parseInt(s[2]); //Auswertung Zahl2 
		
		//Test Operationen fuer Integers
		System.out.println("Tests der Operationen: ");
		
		System.out.println(Rechner.add(a, b));
		System.out.println(Rechner.sub(a, b));
		System.out.println(Rechner.mul(a, b));
		System.out.println(Rechner.div(a, b));
		b = 0;
		try{
			System.out.println(Rechner.div(a, b));
		} catch (ArithmeticException e){
			System.out.println(e.getMessage());
		}
		
		
		
		
		System.out.println("Test fuer gebrochene Zahlen: ");		
		s[0] = "10.5"; s[1] = "add"; s[2]= "5.5";
		
		check1= Rechner.bothInt(s[0],s[2]); //prueft ob Zahlen Integer
		System.out.println(check1); //false
		
		//Variablen zum Speichern von Double-Werten
		double z1 = Double.parseDouble(s[0]);
		double z2 = Double.parseDouble(s[2]);
		
		//Test der Operationen fuer Double-Zahlen
		System.out.println(Rechner.add(z1, z2));
		System.out.println(Rechner.mul(z1, z2));
		System.out.println(Rechner.sub(z1, z2));
		System.out.println(Rechner.div(z1, z2));
		z2 = 0; //Test der Division durch null
		try{
			System.out.println(Rechner.div(z1, z2));
		} catch (ArithmeticException e){
			System.out.println(e.getMessage());
		}
		
		s[0] = "2147483648";
		s[2] = "-2147483649";
		a = b = 0; //Zuruecksetzen der Werte
		z1 = z2 = 0;
		
		if(Rechner.bothInt(s[0],s[2]) == true){ //false
			a = Integer.parseInt(s[0]); //Wert von a und b == 0
			b = Integer.parseInt(s[2]);
		} else { //Werte von z1 und z2 uberschrieben - overflow/underflow der Parameter vermieden
			z1 = Double.parseDouble(s[0]); //2.147483648E9
			z2 = Double.parseDouble(s[2]); //-2.147483649E9
		}
		
		System.out.println(a + ", " + b); //0, 0
		System.out.println(z1 + ", " + z2);// 2.147483648E9, -2.147483649E9
		
		System.out.println(Rechner.add(z1, z2)); //-1.0
		System.out.println(Rechner.mul(z1, z2)); //-4.6116860205748716E18
		System.out.println(Rechner.sub(z1, z2)); //4.294967297E9
		System.out.println(Rechner.div(z1,z2));//-0.9999999995343387
		
		
	}

}
