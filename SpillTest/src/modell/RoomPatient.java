package modell;


public class RoomPatient extends Room {
	private static final long serialVersionUID = 6289617513276014201L;

	public RoomPatient(Player player) {
		super(player);
		super.setRoomNr(8);
		super.setDoor(true);
		super.setRoomDescription(roomDescription());
		super.setLook("PR");
		super.setHandlingtxt(null);
		

		super.getHandling().add("The stench of the decomposing bodies makes you feel sick.");
		super.getHandling().add("You find a first aid kit with bandages, a shot of morphine and some rubbing alcohol.<br>You took the shot of morphine which made you feel better");

		super.getValg().add("1. Search the bodies.");
		super.getValg().add("2. Look under the bed.");
		super.getValg().add("3. Go out into the corridor.");
	}
	
	public String roomDescription() {
		String s ="You walk up to the door of the patient room, looking at the name it states: \"No current patient\"<br>As you enter the room, there are two bodies lying on the floor.<br>Judging by the smell, they've been dead<br>for less than 24 hours.<br>The bodies have been dismemberd to the point where you cannot determine neither age nor sex of their owners. It looks like they've been hatched open with a meat cleaver of some sort.<br>";
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
			if (getValg().get(0).equals("1. Search the bodies.")) {
					setHandlingtxt(getHandling().get(0));
					super.getPlayer().modifyHealth(-1);
			}

			break;
		case "2":
			if (getValg().get(1).equals("2. Look under the bed.")) {
				setHandlingtxt(getHandling().get(1));
				super.getPlayer().modifyHealth(10);
				super.getValg().set(1, "");
			}

			break;

		default:
			break;
		}
	}
	
}

