import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class VerwaltungTest {
	
	static Person p1 = new Person ("Lukas", "Meier", 'm');
	static Student s1 = new Student("Markus", "Heyn", 'm', 559842);
	static Dozent d1 = new Dozent("Oliver", "Mainz", 'm', 02);
	
	static Person[] test = {p1,s1,d1};
	
	/**
	 * Test-Methode fuer listeAnlegen()
	 * Test fuer normale Eingabewerte
	 */
	@Test
	public void testListeAnlegen() {
		Person[] anzulegen;
		anzulegen = Verwaltung.listeAnlegen(p1,s1,d1);
		Person [] erwartet = Verwaltung.listeAnlegen(p1,s1,d1);		
		assertTrue(Arrays.equals(anzulegen, erwartet));			
	}
	
	@Test(expected = NullPointerException.class)
	public void testListeAnlegenLeer(){
		Person [] param = null;
		Verwaltung.listeAnlegen(param);
	}

	/**
	 * Test-Methode zur Ausgabe einer nicht-leeren Liste
	 */
	@Test
	public void testListeAusgeben() {
		Verwaltung.listeAusgeben(test);
	}

	/**
	 * Test-Methode listeSortieren().
	 */
	@Test
	public void testListeSortieren() {
		Person [] sortiert = {s1,d1,p1};
		Person [] check;
		check = Verwaltung.listeSortieren(test);
		assertTrue(Arrays.equals(check, sortiert));
	}

	/**
	 * Test-Methode zaehleWeiblich()
	 * Anzahl weibliche Personen = 0
	 */
	@Test
	public void testZaehleWeiblich() {
		int w = Verwaltung.zaehleWeiblich(test);
		assertEquals(w,0);
	}

}
