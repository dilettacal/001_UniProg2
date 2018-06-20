import java.util.Arrays;

import kunden.*;
import reiseanbieter.*;
import transportmittel.*;

/**
 * 06.06.2017
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//Bus erzeugen; dieser Bus fährt durchschnittlich 80 km/h und hat nur 3 Plätze
		Bus bus = new Bus(80.5, 3);
		//Bahn erzeugen; diese Bahn fährt durchschnittlich 120 km/h und hat 10 Plätze
		Bahn bahn = new Bahn(120, 10);
		//Filiale von TuiReisen erzeugen, die über das o.g. bus und bahn verfügt
		TuiReisen tui1 = new TuiReisen(bus, bahn);
		
		//Privatperson als Kunden erzeugen
		Privatperson p1 = new Privatperson("Robert", "Neumann");
		
		//Studenten als Kunden erzeugen
		Student s1 = new Student("Hans", "Meier", "HTW-Berlin");
		Student s2 = new Student("Angela", "Elbig", "HTW-Berlin");
		Student s3 = new Student("Maria", "Hellmann", "HTW-Berlin");
		
//		tui1.buchen(p1, 1); //Buchung von einer Privatperson
		Kunde [] gruppe = {s1,s2,s3};
//		tui1.buchen(gruppe, 1); //Gruppe bucht Ausflug mit Bus
//		tui1.buchen(gruppe, 0); //Gruppe bucht also mit EGAL
//		System.out.println();
//		tui1.dauerErfragen(p1, 0);
//		tui1.dauerErfragen(p1, 1);
//		tui1.preisErfragen(p1, 0);
//		tui1.preisErfragen(p1, 2);
//		tui1.stornieren(p1, 1); //buchen rivedere!
//		tui1.buchen(p1, 2);
		int einzelneBuchung = 1;
		int einzelnStorno = -1;
		int gruppenbuchung = 11;
		int gruppenstorno = -11;
		int preis = 3;
		int dauer = 2;
		//Robert Neumann bucht eine Reise mit dem Bus
		tui1.anfrageEinzeln(einzelneBuchung, p1, 1);
		System.out.println();
		//Studenten s1, s2, s3 buchen als Reisegruppe eine Reise mit dem Bus
		tui1.anfrageGruppe(gruppenbuchung, gruppe, 1); //Buchung erfolglos
		System.out.println();
		//s1, s2, s3 buchen also eine Reise mit EGAL-Transportmittel
		tui1.anfrageGruppe(gruppenbuchung, gruppe, 0); //Bahnreise gebucht
		System.out.println();
		tui1.anfrageEinzeln(dauer, p1, 0);
		System.out.println();
		tui1.anfrageEinzeln(dauer, p1, 1);
		System.out.println();
		tui1.anfrageEinzeln(preis, p1, 0);
		System.out.println();
		tui1.anfrageEinzeln(preis, p1, 2);
		System.out.println();
		tui1.anfrageEinzeln(einzelnStorno, p1, 1);
		System.out.println();
		tui1.anfrageEinzeln(einzelneBuchung, p1, 2);
		System.out.println(Arrays.toString(tui1.getKundenMitBahn()));
		System.out.println();
		tui1.anfrageGruppe(gruppenstorno, gruppe, 1);
		System.out.println();
		tui1.anfrageGruppe(gruppenstorno, gruppe, 0);
		System.out.println();
		tui1.anfrageGruppe(gruppenstorno, gruppe, 2);
	}

	

}
