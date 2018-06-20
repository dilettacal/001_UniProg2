package kunden;
/**
 * 06.06.2017
 */
public class Student extends Privatperson {
	
	private String hochschule;

	/**
	 * 
	 */
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param vorname
	 * @param nachname
	 */
	public Student(String vorname, String nachname, String hochschule) {
		super(vorname, nachname);
		this.hochschule = hochschule;
	}
	
	

	/**
	 * @return the hochschule
	 */
	public String getHochschule() {
		return hochschule;
	}

	/**
	 * @param hochschule the hochschule to set
	 */
	public void setHochschule(String hochschule) {
		this.hochschule = hochschule;
	}

	@Override
	public String toString() {
		return super.toString() + ", " + hochschule ;
	}
	

}
