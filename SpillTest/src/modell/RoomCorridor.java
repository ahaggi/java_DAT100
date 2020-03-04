package modell;



public class RoomCorridor extends Room {
	private static final long serialVersionUID = 8305108160756402532L;

	public RoomCorridor(Player player) {
		super(player);
		super.setRoomNr(0);
		super.setDoor(true);
		super.setLook("CR");
		super.setRoomDescription(roomDescription());
		super.getHandling().add("Pick the room you want to enter.");
		super.getHandling().add("");
		
		setHandlingtxt(getHandling().get(0));

		super.getValg().add("	1. Solitary Confinement.");
		super.getValg().add("	2. Therapy Room.");
		super.getValg().add("	3. Kitchen.");
		super.getValg().add("	4. Infirmary.");
		super.getValg().add("	5. Garden.");
		super.getValg().add("	6. Patient Room");
		super.getValg().add("	7. Office.");
		super.getValg().add("	8. Dining room.");
		super.getValg().add("	9. Guard Booth.");





	}
	
	public String roomDescription() {
		String s ="You came out of the room, there are doors on both left and right sides... The door plaques are faded, but still readable.";
		return s;

	}
	

	
	public String getPlayerInventoryString(){
		return super.getPlayer().getInventory().inventoryToString();
	}
	
	public  String getRoomInventoryString(){
		return super.getInventory().inventoryToString();
	}
	
	
}

