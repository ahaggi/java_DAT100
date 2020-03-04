package modell;


public class RoomTherapy extends Room {
	private static final long serialVersionUID = -5390678041028419346L;

	public RoomTherapy(Player player) {
		super(player);
		super.setRoomNr(2);
		super.setDoor(true);
		super.setRoomDescription(roomDescription());
		super.getInventory().leggTil(ItemType.InfermaryKey);
		super.setLook("TR");
		super.setHandlingtxt(null);

		super.getHandling().add("Patient: RARWWRAHGRHWAHRHARHR.<br> The patient started to violently attack you.<br> You killed him, but took a great deal of damage.");
		super.getHandling().add("You took the Infermary's key from the patient's belongings.<br> You will have to live with it on your conscience.");


		
		super.getValg().add("1. Release the patient.");
		super.getValg().add("2. Take his belongings.");
		super.getValg().add("3. Go back into the corridor.");

		
	}
	
	public String roomDescription() {
		String s ="You have entered the therapy room, there is a patient strapped to the bed here...";
		return s;

	}
	

	
	public String getPlayerInventoryString(){
		return super.getPlayer().getInventory().inventoryToString();
	}
	
	public  String getRoomInventoryString(){
		return super.getInventory().inventoryToString();
	}
	
	public void enter(String valg){

	switch (valg) {
		case "1":
			if (getValg().get(0)=="1. Release the patient.") {
//				System.out.println(getHandling().get(0)); 
				setHandlingtxt(getHandling().get(0));
				getPlayer().modifyHealth(-20);	
				super.getValg().set(0, "1. Check the bed.");
			}else{
				super.getHandling().set(0, "There is nothing left");
				setHandlingtxt(getHandling().get(0));				
			}
			


			break;
		case "2":
			if (getValg().get(1)=="2. Take his belongings.") {
				setHandlingtxt(getHandling().get(1));
				getPlayer().getInventory().leggTil(getInventory().gi(ItemType.InfermaryKey));
				super.getValg().set(1, "");
			}
			
			break;
		case "3":

			break;
		case "4":

			break;


		default:
			break;
		}
	}
	
}

