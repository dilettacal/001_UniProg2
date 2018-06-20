package transportmittel;
/**
 * 06.06.2017
 */
public class Bahn implements Transportmittel {
	/*Attribute der Klasse Bahn*/
	private double geschwindigkeit;
	private int anzahlPlaetze;
	
	/**
	 * Parameterloser Konstruktor
	 */
	public Bahn(){}
	/**
	 * Parameterkonstruktor
	 * @param g Geschwindigkeit
	 * @param a Anzahl der Plaetze
	 */
	public Bahn(double g, int a){
		geschwindigkeit = g;
		anzahlPlaetze = a;
	}
	

	@Override
	public double getGeschwindigkeit() {
		return geschwindigkeit;
	}

	@Override
	public int getAnzahlPlaetze() {
		return anzahlPlaetze;
	}
	
	public void setAnzahlplaetze(int p){
		anzahlPlaetze = p;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return getClass().getSimpleName() + ": \n Geschwindigkeit=" + geschwindigkeit + 
				", Anzahl der Plaetze=" + anzahlPlaetze;
	}
	
	
	
	

}
