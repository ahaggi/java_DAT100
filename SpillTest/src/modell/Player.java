package modell;


public class Player extends Member {
	private static final long serialVersionUID = 8641203565937956641L;


	public Player(){
		super();
	}
	
	public String getFirstName(){
		String arr[] = getName().split(" ");
		String firstName = arr[0];
		return firstName;
	}
	
	
}
