/**
 * @author Diletta Calussi
 * Matrikel-Nr. s0559842
 *
 */
public class TestHochschule {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//Erzeugung der Student-Objekte
		//Erzeugung durch parameterlosen Konstruktor
		Student s1 = new Student();
		s1.setVorname("Heinz");
		s1.setNachname("Albert");
		s1.setGeschlecht('m');
		s1.setMatrikelnummer(557876);
		
		Student s2 = new Student("Carolina", "Albert", 'w', 557877);
		Student s3 = new Student("Susanne", "Rossi", 'w', 557876);
		Student s4 = new Student("Fabio", "Alberti", 'm', 557876);
		Student s5 = new Student("Inga", "Meyer", 'w', 557876);
		Person [] liste = null;
		try{
			liste = (Verwaltung.listeAnlegen(s1,s2,s3,s4,s5)); //erzeugt ein Array von Person-Objekte
			
		} catch (NullPointerException e){
			System.out.println(e.getMessage());
		}
		Verwaltung.listeAusgeben(liste);
		System.out.println("Liste sortiert: ");
		Verwaltung.listeSortieren(liste);
		Verwaltung.listeAusgeben(liste);
		System.out.println("Anzahl der Studentinnen = " + Verwaltung.zaehleWeiblich(liste));
		
		Dozent d1 = new Dozent("Karl", "Schwenk", 'm', 1);
		Dozent d2 = new Dozent("Marina", "Hong-Li", 'w', 2);
		Dozent d3 = new Dozent("Viktorija", "Karenina", 'w', 1);
		
		Person [] listeD = null;
		try{
			listeD = Verwaltung.listeAnlegen(d1,d2,d3);
		} catch (NullPointerException e){
			System.out.println(e.getMessage());
		}
		Verwaltung.listeAusgeben(listeD);
		System.out.println("Liste sortiert: ");
		Verwaltung.listeSortieren(listeD);
		Verwaltung.listeAusgeben(listeD);
		System.out.println("Anzahl der Dozentinnen = " + Verwaltung.zaehleWeiblich(listeD));
		
	}

}
