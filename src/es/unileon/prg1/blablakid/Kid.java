package es.unileon.prg1.blablakid;
/**
 * Class that creates the children that will manage the kids class
 * 
 * @author Adrian Perez
 *
 */
public class Kid {
	/**
	 * Name of the kid, used as his/her identifier
	 * 
	 * @see String
	 */
	private String Name;
	
	/**
	 * Activities of each kid
	 * 
	 * @see Activities
	 */
	private Activities activities;
	
	/**
	 *Creates the kid object with its name (identifier)
	 * 
	 * @param name Kid identifier
	 */
	public Kid (String name){
		this.Name = name;
		this.activities = new Activities();
	}
	
	/**
	 * 
	 * @return name of kid
	 */
	public String getName() {
		return this.Name;
	}
	
	/**
	 * Method that check is two kid object are equal
	 * 
	 * @param kid2
	 * 
	 * @return boolean that is true if kids are same or false if not
	 */
	public boolean isSame(Kid kid2) {
		return (this.Name == kid2.getName());
	}
	
	public Activities getActivities() {
		return activities; 
	}
	
	/**
	 * 
	 * @return String version with the name of the kid
	 */
	@Override
	public String toString() {
		StringBuilder salida = new StringBuilder();
		salida.append("****** ").append(this.Name).append(" ******\n");
		salida.append(this.activities.toString());
		return salida.toString();
	}



}

