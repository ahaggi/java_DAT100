package modell;





public class RoomKitchen extends Room {
	private static final long serialVersionUID = 4374986042370733601L;

	public RoomKitchen(Player player) {
		super(player);
		super.setRoomNr(3);
		super.setDoor(true);
		super.setRoomDescription(roomDescription());
		super.setLook("KN");
		super.setHandlingtxt(null);
		super.leggTilMonster(new Monster(), "Chef");
		
		super.getInventory().leggTil(ItemType.Hatchet);

		super.getHandling().add("You accept his offer and walk towards him. You consume the drink. Immediately you feel dazed. Your perception of reality is affected.<br>The chef laughs and raises his hatchet and strikes towards you.<br>(The chef gets the first strike)...<br> PRESS ENTER WHEN YOU'RE READY TO FIGHT");
		super.getHandling().add("You decline his offer and slowly starts retracing out of the kitchen.<br>Chef: \"Not so fast. How impolite.\"<br>He pushes a button and you hear a click sound. The door behind you is definitely locked now.<br>Chef: \"Now it's only me and you. You have nowhere to run.\"<br>He runs towards you screaming with the hatchet raised.<br> PRESS ENTER WHEN YOU'RE READY TO FIGHT");
		super.getHandling().add("You grab your knife preparing for combat.<br>Chef: \"How sad. I only wanted to help you.\"<br>The chef raises the hatchet and screams \"Die!\" while running towards you.<br> PRESS ENTER WHEN YOU'RE READY TO FIGHT");

		super.getValg().add("1. Accept the drink and walk towards him.");
		super.getValg().add("2. Decline his drink and start walking out of the kitchen.");
		super.getValg().add("3. Get ready to fight.");

	}
	
	public String roomDescription() {
		String s ="You enter the kitchen through a metal door. The door slams shut. The kitchen is small. Way too small for a facility like this. A man stands in front of a stove cooking what appears to be a soup. The smell is stale, almost rotten. The chef is a tall man holding a bloody handkerchief in his left hand and a hatchet in the right. He spots you and lays down the hatchet on the bench. You stand about 10 feet away from him, facing him. <br>Chef: \"Hello there. What are you doing here? Are you lost? Here let me offer you a drink, and some directions.\"<br>The chef reaches for the cupboard and takes out a cup. He grabs a nearby jar and fills the cup.<br> Chef: \"Don't be afraid. Here take it.\"<br>He gestures that you should move towards him. He has a soft smile on his face. <br>What do you do?";
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
			if (getValg().get(0).equals("1. Accept the drink and walk towards him.")) {
				setHandlingtxt(getHandling().get(0));
				monsterStrikePlayer(-10);
				super.getValg().set(0, " ");
				super.getValg().set(1, " ");
				super.getValg().set(2, " ");

			}else if (getValg().get(0).equals("1. Search the kitchen. The search will take some time.")) {
				setHandlingtxt(getHandling().get(0));				
			}

			break;
		case "2":
			if (getValg().get(1).equals("2. Decline his drink and start walking out of the kitchen.")) {
				setHandlingtxt(getHandling().get(1));
				super.getValg().set(0, " ");
				super.getValg().set(1, " ");
				super.getValg().set(2, " ");

				
			}else if (getValg().get(1).equals("2. Equip the hatchet.")) {
				if (getInventory().har(ItemType.Hatchet)) {
					getPlayer().getInventory().leggTil(getInventory().gi(ItemType.Hatchet));
					setHandlingtxt(getHandling().get(1));	
					super.getValg().set(1, " ");
				}
			}

			break;
			
		case "3":
			if (getValg().get(2).equals("3. Get ready to fight.")) {
				setHandlingtxt(getHandling().get(2));
				super.getValg().set(0, " ");
				super.getValg().set(1, " ");
				super.getValg().set(2, " ");
			}

			break;
		case "":
			if (!getMonster(0).isdead()) {
				getPlayer().StartFight(true);
				secondScene ();
			}

			break;

		default:
			break;
		}
	}
	
public void secondScene (){

	super.setRoomDescription("The kitchen is a mess...");
	super.setHandlingtxt("");

	super.getValg().set(0, "1. Search the kitchen. The search will take some time.");
	super.getValg().set(1, "2. Equip the hatchet.");
	super.getValg().set(2, "3. Go out into the corridor.");

	super.getHandling().set(0, "There is nothing useful....");
	super.getHandling().set(1, "You got the hatchet, which is slightly better than the knife.");
	super.getHandling().remove(2);

}


}

