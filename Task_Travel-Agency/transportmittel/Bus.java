package transportmittel;

/**
 * 06.06.2017
 */
public class Bus implements Transportmittel {
	public static int freiePlaetze = 0;
	
	private double geschwindigkeit;
	private int anzahlPlaetze;
	
	
	public Bus(){ 
		super();
	}
	/**
	 * 
	 * @param g
	 * @param a
	 */
	public Bus (double g, int a){
		geschwindigkeit = g;
		anzahlPlaetze = a;
		freiePlaetze = anzahlPlaetze; //Am Anfang sind alle Plaetze verfuegbar
	}
	
	public static int getFreiePlaetze(){
		return freiePlaetze;
	}
	
	public static void setFreiePlaetze(int frei){
		freiePlaetze = frei;
	}
	
	
	@Override
	public double getGeschwindigkeit() {
		return geschwindigkeit;
	}

	@Override
	public int getAnzahlPlaetze() {
		return anzahlPlaetze;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + ": \n Geschwindigkeit=" + geschwindigkeit + 
				", Anzahl der Plaetze=" + anzahlPlaetze;
	}
	
	

}
