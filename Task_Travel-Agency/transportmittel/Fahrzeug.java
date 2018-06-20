package transportmittel;
/**
 * 06.06.2017
 * 
 * Klasse non prevista dalle indicazioni
 */
public abstract class Fahrzeug implements Transportmittel {
	
	private double geschwindigkeit;
	private int anzahlPlaetze;
	private int frei;
	
	/* Konstruktoren */
	public Fahrzeug(){}	
	
	/**
	 * @param geschwindigkeit
	 * @param anzahlPlaetze
	 */
	public Fahrzeug(double geschwindigkeit, int anzahlPlaetze) {
		this.geschwindigkeit = geschwindigkeit;
		this.anzahlPlaetze = anzahlPlaetze;
		frei = anzahlPlaetze;
	}
	
	public int getFrei() {
		return frei;
	}

	public void setFrei(int frei) {
		this.frei = frei;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + ": \nGeschwindigkeit=" + geschwindigkeit 
				+ ", Anzahl der Plaetze=" + anzahlPlaetze + 
				" Uebrige freie Plaetze: " + getFrei();
	}
	
	
	
	

}
