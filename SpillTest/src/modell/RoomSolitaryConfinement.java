package modell;


public class RoomSolitaryConfinement extends Room {
	private static final long serialVersionUID = -3735805052666386649L;


	public RoomSolitaryConfinement(Player player) {
		super(player);
		super.setRoomNr(1);
		super.setDoor(true);
		super.setRoomDescription(roomDescription());
		super.setLook("SC");
		super.getInventory().leggTil(ItemType.Code42);

		
		super.getHandling().add("You walk over to the corner and take a look at the bloody marks... The blood has long since dried. It appears that whoever was its owner, repeatedly hit their head against the wall. To the left of the blood hit-mark, the blood forms some strange symbols, you are not entirely sure of what to make of them. The more you stare at them, the less sane you feel");
		super.getHandling().add("You stick your fingers into the crack and try to lift it, you barely manage to touch the tile before cutting your fingers on its sharp edges. You doubt that you'll be able to budge it with your bare hands.");
		super.getHandling().add("You've opened the door.");

		
		super.getValg().add("1. Examine the bloody marks.");
		super.getValg().add("2. Try lifting the floor-tile with your hands.");
		super.getValg().add("3. Try to ram the door.");
		super.setHandlingtxt(null);

	}
	
	public String roomDescription() {
		if (super.getPlayer().getStatus()==Memberstatus.WOKEUP) { 
			super.getPlayer().setStatus(Memberstatus.HEALTHY);
			return "You wake up in what you guess is a solitary confinement room. You cannot recall why<br> you're here, nor the events of the previous day, or any day before it for that matter.<br> You look around the room and see that there's really not much to note.<br> After all, it is supposed to be a room void of anything one could interact with and a door with<br> no handle on the inside. The walls are a pale grey, perhaps they once upon a time could have<br> been called white. The room is pretty run-down, in one of the corners you see some dried, bloody<br> marks on the wall. You can see a small crack in between the floor tiles."; //you woke up
		}
		return "You look around the room and see that there's really not much to note.<br> After all, it is supposed to be a room void of anything one could interact with and a door with<br> no handle on the inside. The walls are a pale grey, perhaps they once upon a time could have<br> been called white. The room is pretty run-down, in one of the corners you see some dried, bloody<br> marks on the wall. You can see a small crack in between the floor tiles."; //
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
				super.getHandling().set(0, "You walk over to the corner and take a look at the bloody marks... The blood has long since dried. It appears that whoever was its owner, repeatedly hit their head against the wall. To the left of the blood hit-mark, the blood forms some strange symbols, you are not entirely sure of what to make of them. The more you stare at them, the less sane you feel.");
				setHandlingtxt(getHandling().get(0));

			break;
		case "2":
			if (super.getInventory().har(ItemType.Code42)) {
				if (getPlayer().getInventory().har(ItemType.Knife)) {
					getPlayer().getInventory().leggTil(super.getInventory().gi(ItemType.Code42));
					setHandlingtxt(getHandling().get(1));
				}else{//player har ikke kniv
					setHandlingtxt(getHandling().get(1));
					getPlayer().modifyHealth(-10);
				}	
			}else if (getPlayer().getInventory().har(ItemType.Code42)) {// hvis du har funnet og prøver å ta item igjen
				super.getHandling().set(1, "xxxxxyou did that already");
				setHandlingtxt(getHandling().get(1));
			}

			break;
		
		case "3":
			if (super.getValg().get(2).equals("3. Try to ram the door.")) {
//				System.out.println(getHandling().get(2));
				setHandlingtxt(getHandling().get(2));
				super.getValg().set(2, "3. Go out into the corridor.");
			}
			
			break;
		
		case "4":
			break;


		default:
			break;
		}
	}
	

}