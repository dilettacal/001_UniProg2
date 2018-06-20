import java.util.GregorianCalendar;

/**
 * Blatt 6
 * 
 * 26.05.2017
 * 
 * Klasse ObjektenTest.java
 * Klasse zum allgemeinen 
 * Testen der Objekte
 * 
 */
public class ObjektenTest {

	public static void main(String[] args) {

		// Test Waren
		GregorianCalendar d1 = new GregorianCalendar(2017, 6, 6);
		GregorianCalendar d2 = new GregorianCalendar(2017, 8, 6);
		float t1 = 6.7f;
		float t2 = 9.f;
		
		// Konstruktoren

		// Test Ware
		System.out.println("Test Ware");
		Ware wa1 = new Ware();
		System.out.println(wa1);
		wa1.setPreis(10.5f);
		wa1.setTyp("Michprodukt");
		System.out.println(wa1);

		//Test Milch
		System.out.println("\nTest Milch");
		Milch m1 = new Milch();
		System.out.println(m1);
		Milch m2 = new Milch(0.95f, "H-Milch");
		Milch m3 = new Milch(1.2f, "Laktosefreie Milch", 50);
		Milch m4 = new Milch(1.1f, "Frischmilch", d1, t2);
		System.out.println(m2);
		System.out.println(m3);
		System.out.println(m4);
		
		//Test Setter und Getter
		m1.setTemperatur(10.f);
		System.out.println("Temperatur: " + m1.getTemperatur());
		m1.setTyp("Fettarme Milch");
		m1.setPreis(0.9f);
		m1.setVerfallsdatum(d1);//6.6.2017
		System.out.println(m1);
		//Test Methoden
		System.out.println(m1.getTyp() + " ist abgelaufen? " + m1.istAbgelaufen(d2));// false
		d2.set(GregorianCalendar.MONTH, 6);//6.6.2017
		System.out.println(m1.getTyp() + " ist abgelaufen? " + m1.istAbgelaufen(d2) + " am " + m1.getVerfallsdatum());
		System.out.println(m1.istZuWarm(t1));
		
		// Test Parameterloser Konstruktor Kaese-Klasse
		System.out.println("\nTest Kaese");
		Kaese k1 = new Kaese();
		k1.setPreis(4.5f);
		k1.setTyp("Gouda");
		GregorianCalendar kaeseDatum = new GregorianCalendar(2017, 9, 10);
		k1.setVerfallsdatum(kaeseDatum);
		k1.setTemperatur(19.f);
		System.out.println(k1);
		Kaese k2 = new Kaese(6.5f, "Grana",d1,5.f);
		System.out.println(k2);

		// Test Parameterloser Konstruktor
		Toilettenpapier tp1 = new Toilettenpapier();
		System.out.println(tp1); // test toString()
		// Test Setter und Getter
		tp1.setPreis(3.99f);
		tp1.setTyp("4-lagig extraweich");
		System.out.println(tp1.getPreis() + " " +tp1.getTyp());

		// Test Parameter-Konstruktoren
		Toilettenpapier tp2 = new Toilettenpapier(4.50f, "4-lagig");
		System.out.println(tp2);
		Toilettenpapier tp3 = new Toilettenpapier(3.99f, "gelb", 50);
		System.out.println(tp3);
		
		//Warenlager
		// Test Konstruktoren vom Warenlager
		System.out.println("\nTest Warenlager ");
		Warenlager w1 = new Warenlager();
		Warenlager w2 = new Warenlager(-2);
		Warenlager w3 = new Warenlager(3, 6.5f);

		// Test Getter/Setter
		w1.setLagerTemp(8.f);
		w1.setMaxKapazitaet(4);
		System.out.println("Kapazitaet: " + w1.getMaxKapazitaet() + " Lagertemperatur: " + w1.getLagerTemp());
		
		w2.setMaxKapazitaet(3);
		w2.aufnehmen(m1, 500, 510);
		w2.aufnehmen(m3, 30, 100);//Zahl wird 80
		w2.aufnehmen(tp1, 20, 50);
		w2.aufnehmen(m2, 10, 20);		
		w2.ausgeben();
		
		w3.setLagerTemp(7.f);
		w3.setMaxKapazitaet(2);
		Kaese k4 = new Kaese(4.5f, "Parmigiano", d1, 6.f);
		w3.aufnehmen(k4, 300, 400);
		w3.aufnehmen(k1, 170, 100);//Ware wird nicht aufgenommen --> Lager leer
		w3.verfallsdatumcheck(d1);
		w3.temperaturcheck();
		w3.ausgeben();
		
	}

}
