package kunden;
/**
 * 
 */

/**
 * 06.06.2017
 */
public class Privatperson implements Kunde {
	private String vorname;
	private String nachname;
	
	/**
	 * Parameterloser Konstruktor
	 */
	public Privatperson(){
		
	}

	/**
	 * @param vorname
	 * @param nachname
	 */
	public Privatperson(String vorname, String nachname) {
		super();
		this.vorname = vorname;
		this.nachname = nachname;
	}
	
	


	/**
	 * @return the vorname
	 */
	public String getVorname() {
		return vorname;
	}

	/**
	 * @param vorname the vorname to set
	 */
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	/**
	 * @return the nachname
	 */
	public String getNachname() {
		return nachname;
	}

	/**
	 * @param nachname the nachname to set
	 */
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return vorname + " " + nachname;
	}

	@Override
	public void empfangeNachricht(String nachricht) {
		System.out.print("an " + this.toString() + ": "+ nachricht);
	}
	
	

}
