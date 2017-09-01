/**
 * 
 * @author Diletta Calussi
 * Matrikel-Nr.: s0559842
 * 
 * Datum 07.05.2017
 * 
 * Klasse TestPersonal 
 * 
 * Test/Verwlatung des Personals 
 * der GeLa GmbH
 */
public class TestPersonal {

	public static void main(String[] args) {

		// Eingestellte Mitarbeiter

		// Objekt-Erzeugung uber Default-Konstruktor (Attribute einzeln
		// einzugeben):
		Mitarbeiter mitarbeiter1 = new Mitarbeiter();
		Mitarbeiter mitarbeiter2 = new Mitarbeiter();

		// Objekt-Erzeungung ueber Konstruktor mit Parametern:
		Mitarbeiter mitarbeiter3 = new Mitarbeiter("Hans", "Boss", 4000);

		// Eingestellter Azubi - Objekt-Erzeugung ueber parameterlosen
		// Konstruktor
		Auszubildender azubi1 = new Auszubildender();
		// Geplante Einstellungen Azubis
		// Objekt erzeugt ueber Konstruktor mit Parametern
		Auszubildender azubi2 = new Auszubildender("Ted", "Mosby", 500, "Logistiker", "1. Jahr");

		// Personal-Attribute einzeln eingesetzt
		// Mitarbeiter:
		mitarbeiter1.setVorname("Frank");
		mitarbeiter1.setName("Walser");
		mitarbeiter1.setGehalt(1600);

		mitarbeiter2.setVorname("Eva");
		mitarbeiter2.setName("Flink");
		mitarbeiter2.setGehalt(1650);

		// Azubis:
		// Vererbung
		azubi1.setVorname("Sven");
		azubi1.setName("Vogel");
		azubi1.setGehalt(450);
		// eigene Methoden
		azubi1.setAusbildungsberuf("Kaufmann im Einzelhandel");
		azubi1.setAusbildungsjahr("1. Jahr");

		// Beispiel-Ausgabe der Daten eines Mitarbeiters
		System.out.println("Vormane des Mitarbeiters: " + mitarbeiter3.getVorname());
		System.out.println("Name des Mitarbeiters: " + mitarbeiter3.getName());
		System.out.println("Gehalt des Mitarbeiters: " + mitarbeiter3.getGehalt());

		// Auszubildender: Beispiel-Ausgabe der Daten
		// Vererbung
		System.out.println("Vormane des Azubi: " + azubi1.getVorname());
		System.out.println("Name des Azubi: " + azubi1.getName());
		System.out.println("Gehalt des Azubi: " + azubi1.getGehalt());
		// eigene Methoden
		System.out.println("Ausbildungsberuf des Azubi: " + azubi1.getAusbildungsberuf());
		System.out.println("Ausbildungsjahr des Azubi: " + azubi1.getAusbildungsjahr());

		System.out.println();
		System.out.println("Mitarbeiteruebersicht - GeLa GmbH Getraenkenmarkt: ");
		System.out.println();
		System.out.println(mitarbeiter1.toString());
		System.out.println(mitarbeiter2.toString());
		System.out.println(mitarbeiter3.toString());
		System.out.println();
		System.out.println(azubi1.toString());
		System.out.println("---------------------------------------------------------------------");
		System.out.println("Geplante Einstellungen - Azubis:");
		System.out.println(azubi2.toString());

		System.out.println();
		// Test der Methode zum Erhoehen des Gehalts
		System.out.println("Produktionspraemie fuer Mitarbeiter: " + mitarbeiter2.getVorname() + ", " + mitarbeiter2.getName());
		int erhoehung = 500;
		mitarbeiter2.erhoeheGehalt(erhoehung);
		System.out.println(
				"Gehalt erhoeht um: " + erhoehung + " EUR . Neuer Gehalt betraegt: " + mitarbeiter2.getGehalt());
		erhoehung = 50;
		System.out.println("Geplante Erhoehung fuer Azubi: " + azubi1.getVorname() + ", " + azubi1.getName() + " um "
				+ erhoehung + " EUR");
		// Vererbung
		azubi1.erhoeheGehalt(50);
		System.out.println("Neuer Gehalt betraegt: " + azubi1.getGehalt());
	}

}
