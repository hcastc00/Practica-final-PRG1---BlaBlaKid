package es.unileon.prg1.blablakid;
/**
 * @author Hector Castro
 *
 */
public class Rides {
	
	/**
	 * Array composed by Ride objects
	 */
	public Ride[] rides;
	
	/**
	 * Size of the array
	 */
	public int size;
	
	/**
	 * First free position in the array
	 */
	public int next;

	/**
	 * 
	 * @param numberOfRides maximun number of rides that defines the arrays lenght
	 */
	public Rides(int numberOfRides){
	 this.size = numberOfRides;
	 this.rides = new Ride[size];
	 this.next = 0;
	}

	/**
	 * Adds a Ride to an array
	 * @param Ride that must be added
	 */
	public void addRide(Ride ride) throws RideException{
		//Checks if the ride is alrede in the array
		if(isIncluded(ride)){
			throw new RideException("Error: Ride already included");
		}
		
		//Adds the ride in the first free position in the array
		else{
			//Thows an exception if the array is full
			if (this.next >= this.size) {
				throw new RideException("Error: Ride list is full");
			}
			else {
				rides[this.next] = ride;
				this.next++;
			}
		}
	}

	/**
	 * Remoces a Ride from an array
	 * @param Ride that must be deleted
	 */
	public void removeRide(Ride ride) {

	}

	/**
	 * Checks if a Ride is icluded in an array
	 * @param Ride to be checked
	 */
	private boolean isIncluded(Ride ride) {
		return false;
		// TODO Auto-generated method stub
	}
	
	public void compact(int pos) {
		pos++; 
		// The position is incremented so as to move to the object just behind the one that has been removed
		//When the array finds null the compaction is over
		while(rides[pos] != null) { 
			//Guardo en la posicion anterior la posicion en la que me encuentro, es decir, desplazo todas a la izquierda desde el objeto que borro
			// The objects are moved one position to the left
			rides[(pos-1)] = rides[pos];
			pos++;
		}
	}
}
