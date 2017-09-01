/**
 * @author Diletta Calussi
 * Matrikel-Nr.: s0559842
 * 
 * Datum 07.05.2017
 * 
 * Klasse Auszubildender (Unterklasse)
 * 
 * Die Klasse Auszubildender stellt eine 
 * Spezialisierung fuer die allgemeine
 * Klasse Mitarbeiter (ist-ein Beziehung):
 * ein Azubi ist ein Mitarbeiter 
 * 
 * Beispiel fuer weitere Spezifikationen fuer Mitarbeiter:
 * Angestellter, Werkstudent, Volontaer, Praktikant,
 * vorlaeufige Hilfskraft...
 * 
 */
public class Auszubildender extends Mitarbeiter {
	
	//Attribute
	private String ausbildungsberuf;
	private String ausbildungsjahr;
	
	//Default-Konstruktor um Attribute einzeln einzusetzen 
	public Auszubildender(){
		
	}
	
	//Konstruktor Vererbung + zusaetzlichen eigenen Attributen
	public Auszubildender(String vorname, String name, float gehalt, String ausbildungsberuf, String ausbildungsjahr) {
		super(vorname, name, gehalt);
		this.ausbildungsberuf = ausbildungsberuf;
		this.ausbildungsjahr = ausbildungsjahr;
	}

	//Getter- und Setter fuer Attribute
	
	public String getAusbildungsberuf() {
		return ausbildungsberuf;
	}

	public void setAusbildungsberuf(String ausbildungsberuf) {
		this.ausbildungsberuf = ausbildungsberuf;
	}

	public String getAusbildungsjahr() {
		return ausbildungsjahr;
	}

	public void setAusbildungsjahr(String ausbildungsjahr) {
		this.ausbildungsjahr = ausbildungsjahr;
	}

	@Override
	public String toString() {
		return "Auszubildender\tVorname: " + getVorname() + "\tName: " + getName()
				+ "\tGehalt (EUR): " + getGehalt() + "\tAusbildungsberuf: " + ausbildungsberuf + "\tAusbildungsjahr: " + ausbildungsjahr
						+ "\tGehalt: " + gehalt;
	}
	

}
