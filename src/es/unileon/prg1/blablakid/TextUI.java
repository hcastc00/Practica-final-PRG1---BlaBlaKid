package es.unileon.prg1.blablakid;
/**
 * @author Hector Castro
 *
 */
public class TextUI {
	private BlaBlaKidsApp blablakid;

	
	public TextUI(BlaBlaKidsApp blablakid) {
		this.blablakid = blablakid;
	}

	
	public void start(){
		this.displayIntro();
		int select = this.displayMenu();
		
		switch(select) {
			//Add Kid
			case 1:
				Kid kid = this.askKid();
				blablakid.add(kid);
				break;
			//Add Parent
			case 3:
				Parent parent = this.askParent();
				blablakid.add(parent);
				break;
			//Add Activity
			case 5:
				Activity activity = this.askActivity();
				blablakid.add(activity);
				break;
			//TODO Removes 
		}
	}
	
	/**
	 * Prints the apps menu
	 * @return the option selected as an </CODE>int</CODE>
	 */
	private int displayMenu() {
		int option;

		System.out.println("### Select an option ###");
		System.out.println("# [1] Add kid          #");
		System.out.println("# [2] Remove kid       #");
		System.out.println("# [3] Add parent       #");
		System.out.println("# [4] Remove parent    #");
		System.out.println("# [5] Add activity     #");
		System.out.println("# [6] Remove activity  #");
		System.out.println("# [7] Add ride         #");
		System.out.println("# [8] Remove ride      #");
		System.out.println("# [9] Show summary     #");
		System.out.println("# [10] Check status    #");
		System.out.println("# [0] EXIT             #");
		System.out.println("########################");
		option = Teclado.readInteger();
		
		if(option<0 || option>10){
			System.out.println("Opcion invalida");
		}
		return option;
	}
	
	/**
	 * Prints the apps ASCII Art header
	 */
	public void displayIntro() {
		System.out.print("\t\t\t\t\t\t\t╔====================================================╗\n");
		System.out.print("\t\t\t\t\t\t\t|  ██████╗ ██╗      █████╗ ██████╗ ██╗      █████╗   |\n");
		System.out.print("\t\t\t\t\t\t\t|  ██╔══██╗██║     ██╔══██╗██╔══██╗██║     ██╔══██╗  |\n");
		System.out.print("\t\t\t\t\t\t\t|  ██████╔╝██║     ███████║██████╔╝██║     ███████║  |\n");
		System.out.print("\t\t\t\t\t\t\t|  ██╔══██╗██║     ██╔══██║██╔══██╗██║     ██╔══██║  |\n");
		System.out.print("\t\t\t\t\t\t\t|  ██████╔╝███████╗██║  ██║██████╔╝███████╗██║  ██║  |\n");
		System.out.print("\t\t\t\t\t\t\t|  ╚═════╝ ╚══════╝╚═╝  ╚═╝╚═════╝ ╚══════╝╚═╝  ╚═╝  |\n");
		System.out.print("\t\t\t\t\t\t\t|                                                    |\n");
		System.out.print("\t\t\t\t\t\t\t|                 ██╗  ██╗██╗██████╗                 |\n");
		System.out.print("\t\t\t\t\t\t\t|                 ██║ ██╔╝██║██╔══██╗                |\n");
		System.out.print("\t\t\t\t\t\t\t|                 █████╔╝ ██║██║  ██║                |\n");
		System.out.print("\t\t\t\t\t\t\t|                 ██╔═██╗ ██║██║  ██║                |\n");
		System.out.print("\t\t\t\t\t\t\t|                 ██║  ██╗██║██████╔╝                |\n");
		System.out.print("\t\t\t\t\t\t\t|                 ╚═╝  ╚═╝╚═╝╚═════╝                 |\n");
		System.out.print("\t\t\t\t\t\t\t╚====================================================╝\n");
		return;
	}

	
	/**
	 * Asks for all the data necesary to create a new kid and creates it.
	 * @return Kid whith the given data
	 */
	private Kid askKid() {
		String name =new String();
		
		do {
			System.out.println("Introduce the name of the kidd to add: ");
			name = Teclado.readString();
			
			//Checks if the sintax is correct, if not it gives a warning
			if(name == null) {
				System.out.println("Please, introduce a valid name");
			}		
		
		}while(name.equals(""));
		
		Kid kid = new Kid(name);
		return kid;
	}
	
	
	private Parent askParent() {
		String name =new String();
		int numberOfKids, numberOfRides;
		Kid kid;
		//Asks for its name
		do {
			System.out.println("Introduce the name of the parent to add");
			name = Teclado.readString();
			
			//Checks if the sintax is correct, if not it gives a warning
			if(name == null) {
				System.out.println("Please, introduce a valid name");
			}		
		}while(name == null);
		
		//Asks for number of kids
		do {
			System.out.println("Introduce the number of kids that "+name+" has");
			numberOfKids = Teclado.readInteger();
			
			if(numberOfKids<1) {
				System.out.println("Introduce a valid number of kids, at least 1");
			}
		}while(numberOfKids<1);
		Kids kids = new Kids(numberOfKids);
		
		//Asks for the name of its kids
		for(int i=1; i<numberOfKids; i++) {
			System.out.println("Kid number "+i);
			kid = this.askKid();
			try {
				kids.add(kid);
			} catch (KidException e) {
				System.out.println(e.getMessage());
			}
		}

		//Asks for the number of rides
		do {
			System.out.println("Introduce the number of rides thath the parent will do");
			numberOfRides = Teclado.readInteger();
			if (numberOfRides == Integer.MIN_VALUE) {
				System.out.println("Introduce a valid number of kids.");
			}
		}while(numberOfRides == Integer.MIN_VALUE); 
		
		Parent parent = new Parent(name,kids,numberOfRides);
		return parent;
	}
	
	
	private Activity askActivity() {
		Activity activity;
		String name, place;
		Day day;
		Hour startTime, endTime;
		
		//Asks for the name
		do {
			System.out.println("Introduce a name for the activity: ");
			name = Teclado.readString();	
		}while(name.equals(""));
		
		//Asks for the place
		do {
			System.out.println("Introduce a name for the activity: ");
			place = Teclado.readString();	
		}while(place.equals(""));
		
		//Asks for the day
	}
	
	private Ride askRide() {
		String parent = new String();
		String activity = new String();
		String startPlace = new String();
		String endPlace = new String();
		Hour startTime, endTime;
		boolean beforeRide;
		//Gets the parent that makes the ride
		do {
			System.out.println("Intorduce the name of the parent that makes the ride: ");
			parent = Teclado.readString();
		}while(parent.equals(""));
		//TODO pedir lo demas
		Ride ride = new Ride(parent,activity,startPlace,endPlace,startTime,endTime);
		return ride;
	}
 
	private Hour askHour() {
		Hour hour
	}
}	