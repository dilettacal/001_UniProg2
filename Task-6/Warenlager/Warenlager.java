import java.util.GregorianCalendar;

/**
 * Blatt 6
 * 
 * 26.05.2017
 * 
 * Klasse Warenlager.java
 * Festlegung vom Objekt Warenlager
 * Verwendet und verwaltet 
 * Objekte der Ware-Hierarchie
 * 
 */
public final class Warenlager {
	
	//Attribute
	private Ware[] warenlager; //Warenlager zur Objekt-Aufnahme und -Verwaltung
	private int maxKapazitaet; //Max Anzahl an Warensorten
	private float lagerTemp; //Lagertemperatur
	
	/* Konstruktoren */
	
	/*Parameterloser Konstruktor*/
	public Warenlager(){
		System.out.println("Warenlager leer, bitte Warenlager einrichten");
		warenlager = null;
		maxKapazitaet = 0;
		lagerTemp = 0.f;
	}
	
	/**
	 * Parameter-Konstruktor 
	 * @param maxKapazitaet = max Anzahl an Sorten
	 */
	public Warenlager (int maxKapazitaet){
		this.setMaxKapazitaet(maxKapazitaet);
	}
	
	
	/**
	 * Parameter-Konstruktor
	 * @param maxKapazitaet
	 * @param lagerTemp
	 */
	public Warenlager(int max, float lagerTemp) {
		this(max); //ruft eigenen Konstruktor auf
		this.setLagerTemp(lagerTemp);
	}

	/*Getters und Setters fuer Attribute */
	
	public float getLagerTemp() {
		return lagerTemp;
	}

	public void setLagerTemp(float lagerTemp) {
		this.lagerTemp = lagerTemp;
	}
	
	public int getMaxKapazitaet() {
		return maxKapazitaet;
	}

	public void setMaxKapazitaet(int maxKapazitaet) {
		if (maxKapazitaet > 0){
			this.maxKapazitaet = maxKapazitaet;
			warenlager = new Ware[maxKapazitaet];
		} else {
			System.out.println("Kapazitaet darf nicht negativ sein!");
		}
	}
	
	
	/**
	 * Aufnahme/Nachfuellung von Waren im Lager
	 * @param ware = aufzunehmendes Ware-Objekt
	 * @param stuecke = Anzahl der aufzunehmenden bzw. nachzufuellenden Stuecke
	 * @param grenze = max Kapazitaet im Warenlager fuer diese Sorte
	 */
	public void aufnehmen (Ware ware, int stuecke, int grenze){
		
		//Fall: ware schon im Lager --> Nachfuellen wenn moeglich
		int index = istEnthalten(ware);
		int freiIndex = freiesLager();
		if(index != -1){
			int zahl = warenlager[index].getAnzStuecke() + stuecke;
			if(zahl <= grenze){
				warenlager[index].anzahlErhoehen(stuecke); //nachfuellen
				System.out.println(stuecke + " " + ware.getTyp() + " eingelagert");
			} else {
				System.out.println("Lager fuer " + ware.getTyp() + " voll. Max Kapazitaet/Sorte:  " + grenze);
			}
		} else { //Ware nicht drinnen
			if(freiIndex != -1){ //Warenlager hat noch freie Lager
				int zahl = ware.getAnzStuecke() + stuecke;
				if (zahl <= grenze){
					warenlager[freiIndex] = ware;
					ware.anzahlErhoehen(stuecke);
					System.out.println(stuecke + " " + ware.getTyp() + " eingelagert");
				}
			}
			else { //kein freies Lager mehr fuer neue Waren
				System.out.println("Lager voll //" + ware.getName() + " konnte nicht mehr eingelagert werden");
			}			
		}		
	}
	
	/**
	 * Prueft, ob ein Ware-Objekt schon im Lager ist
	 * @param ware
	 * @return index, wo Ware gespeichert ist
	 */
	private int istEnthalten(Ware ware){
		for (int i=0; i < warenlager.length; i++){
			if(warenlager[i] != null){
				if(warenlager[i].getTyp() == ware.getTyp()){
					return i;
				}
			}
		}
		return -1;
	}
	
	/**
	 * Sucht nach freiem Lager im Warenlager
	 * @return index
	 */
	private int freiesLager(){
		for (int i = 0; i < warenlager.length; i++){
			if (warenlager[i] == null){
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * Gibt Lagerbestand aus 
	 */
	public void ausgeben(){
		System.out.println(" Der Gesamtbestand des Lagers ist ");
		for (int i = 0; i < warenlager.length; i++){
			if (warenlager[i] == null){
				break;
			} else {
				System.out.print("ID: " + i + " " + warenlager[i].print());
			}
			System.out.println();
		}
	}
	
	/**
	 * Prueft, ob Ware zum/am Datum date abgelaufen ist
	 * @param date zum Vergleich
	 */
	public void verfallsdatumcheck(GregorianCalendar date){
		int counter = 0; //speichert Anzahl Elemente
		//Sucht nach Lebensmitteln, die Verfallsdatum haben
		for (int i = 0; i < warenlager.length; i++){
			if (warenlager[i] == null){ //falls Feld nicht belegt
				System.out.println(" Lager " + i + " nicht belegt");
				continue;
			}
			if(warenlager[i].getName() == "Milch" || warenlager[i].getName() == "Kaese"){
				Milch temp = (Milch) warenlager[i]; //up cast fuer Kaese
				if(temp.istAbgelaufen(date) == true){ //ermittelt ob abgelaufen ist
					counter++;
					System.out.println(temp.getName()+"produkt ID " + i+ ", Anzahl " + temp.getAnzStuecke() + 
							" ist abgelaufen.");	
				}
							
			}
		}
		//finale Meldung
		System.out.println(" Am " + date.get(GregorianCalendar.DAY_OF_MONTH) + "." + date.get(GregorianCalendar.MONTH) + "." + date.get(GregorianCalendar.YEAR) + 
				" laufen " + counter + " Produktsorten ab");
	}
	
	/**
	 * Ermittelt Waren, fuer die die Temp. ueberschritten wurde
	 * Vergleich zwischen Attributen Warentemperatur und Lagertemperatur
	 */
	public void temperaturcheck() {
		int counter = 0; //speichert Anzahl Elemente
		
		for (int i = 0; i < warenlager.length; i++) {
			if (warenlager[i] == null){ //falls Feld nicht belegt
				System.out.println(" Lager " + i + " nicht belegt");
				continue;
			}			
			//Sucht nach Lebensmitteln, die ein max. Temperatur beruecksichtigen muessen
			if (warenlager[i].getName() == "Milch" || warenlager[i].getName() == "Kaese") {
				Milch temp = (Milch) warenlager[i]; //up cast fuer Kaese-Produkte
				//wird auch auf Kaese-Objekte angewendet (Polymorphismus und Sichtbarkeit)
				if (temp.istZuWarm(lagerTemp)) {//Vergleich
					counter++;
					System.out.println("Max. Lagertemperatur fuer " + temp.getName() 
							+ "produkt " + temp.getName()
							+ " ID " + i + " ist ueberschritten.");
				}
			}
		}
		//finale Meldung
		System.out.println(" Bei Lagertemperatur " + lagerTemp +"°C ist die maximale "
				+ "Lagertemperatur fuer " + counter
				+ " Produktsorten ueberschritten.");

	}
	
	

	@Override
	/* Ausgabe allgemeine Warenlager-Informationen */
	public String toString() {
		return "Warenlager \n Kapazitaet fuer " + maxKapazitaet + " Warensorten"
				+ "\n Temperatur= " + lagerTemp + " Grad";
	}
	


}
