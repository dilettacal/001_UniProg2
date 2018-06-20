import java.util.GregorianCalendar;

/**
 * Blatt6
 * 
 * 26.05.2017
 * 
 * Klasse TestBibliothek.java
 * Beispiel-Ausfuehrung des Projekts
 * 
 */
public class TestBibliothek {

	public static void main(String[] args) {
		//erzeugt ein Warenlager mit 4 Lagern und Temperatur 7.1 Grad
		Warenlager w1 = new Warenlager(4, 7.1f); 
		int zahl1 = 300; //Fettarme Milch
		int zahl2 = 100; //Gouda
		int zahl3 = 500; //Frischmilch
		int zahl4 = 300; //H-Milch
		
		int grenze = 800; //Max. Vorrat Warenlager
		
		GregorianCalendar date1 = new GregorianCalendar(2017,7,30);
		GregorianCalendar date2 = new GregorianCalendar(2017,9,30);
		GregorianCalendar date3 = new GregorianCalendar(2017,11,28);
		
		System.out.println("Mit dem Einlagern wird begonnen");
		
		Milch m1 = new Milch(0.9f, "Fettarme Milch", date1, 4.5f); 
		Milch m2 = new Milch(1.10f, "H-Milch", date1, 7.2f); 
		Milch m3 = new Milch(1.40f, "Frischmilch", date2, 5.6f); 
		Kaese k1 = new Kaese(4.5f, "Gouda", date3, 8.2f);
		
		//Einlagern der Produkte
		w1.aufnehmen(m1, zahl1, grenze); //Fettarme Milch
		w1.aufnehmen(m3, zahl3, grenze); //Frischmilch
		w1.aufnehmen(k1, zahl2, grenze); //Gouda
		w1.aufnehmen(m2, zahl4, grenze); //H-Milch
	
		zahl1 = 200;
		//Nachfuellen
		w1.aufnehmen(m1, zahl1, grenze); //Fettarme Milch
		zahl2 = 50;
		w1.aufnehmen(k1, zahl2, grenze); //Gouda
		
		Toilettenpapier t1 = new Toilettenpapier(4.99f, "4-lagig weiches Toilettenpapier");
		w1.aufnehmen(t1, 400, grenze); //Klopapier konnte nicht mehr eingelagert werden
		System.out.println();
		w1.ausgeben();
		
		//Test erfolgloses Nachfuellen, da Lagerkapazitaet ueberschritten
		zahl1 = 400; //Fehler, zu viel Fettarme Milch (900 st. insgesamt)
		System.out.println("Nachfuellen fuer " + m1.getTyp() + ", Stuecke dazu: " + zahl1);
		w1.aufnehmen(m1, zahl1, grenze); //Fettarme Milch
		System.out.println();		
		//Test Verfallumsdatumcheck
		GregorianCalendar date4 = new GregorianCalendar(2017,5,24);
		w1.verfallsdatumcheck(date4); System.out.println();
		w1.verfallsdatumcheck(date1);
		System.out.println();
		w1.temperaturcheck();
	}

}
