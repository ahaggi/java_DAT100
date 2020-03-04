package modell;



public class RoomInfirmary extends Room {
	private static final long serialVersionUID = 2262500902851553641L;
	private int pills;
	
	public RoomInfirmary(Player player) {
		super(player);
		super.setRoomNr(4);
		super.setDoor(false);
		super.setLook("IY");
		pills=3;
		super.setRoomDescription(roomDescription());

		super.getHandling().add("");
		super.getHandling().add("");


		
		super.getValg().add("1. Take the syringe.");
		super.getValg().add("2. Take the aspirin pill.");
		super.getValg().add("3. Go out into the corridor.");

		
	}
	
	public String roomDescription() {
		String s ="";
			if (pills>0) { 
				s="You have entered the infermary. You look around the room a bit and find two items: a pack with "+pills+" pills of aspirin and some syringes. Which do you take?";
			}else{
				s="You have entered the infermary. You look around the room a bit and find two items: a pack with "+pills+" pill of aspirin and some syringes.";
			}
			return s; //
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
			if (super.getValg().get(0).equals("1. Take the syringe.")) {
				getHandling().set(0, "You feel dizzy, weaken and you're about to faint.");
				super.getPlayer().modifyHealth(-10);
				setHandlingtxt(getHandling().get(0));
			}
			break;
		case "2":
			if (super.getValg().get(1).equals("2. Take the aspirin pill.")) {
				if (super.getPlayer().getHealth()>=100 && pills>0) {
					getHandling().set(1, "You took a pill, was it really necessary when you're feeling fine? You're supposed to take one when you get hurt.");
					pills--;
				}else if (super.getPlayer().getHealth()<100 && pills>1) {
					getHandling().set(1, "You took a pill, you start to feel better now, your headache is fading.");
					super.getPlayer().modifyHealth(10);
					pills--;
				}else if (super.getPlayer().getHealth()<100){
					getHandling().set(1, "You took the last pill, you start to feel better and your headache is fading.");
					super.getPlayer().modifyHealth(10);
					pills--;
					getValg().set(1, ""); //avbryte if (super.getValg().get(1).equals("2. Take the aspirin pill.")) {
				}
				super.setRoomDescription(roomDescription());
				setHandlingtxt(getHandling().get(1));

			}
			break;
		case "3":
			break;
		default:
			break;
		}
	}
	
}

