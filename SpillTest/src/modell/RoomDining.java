package modell;

public class RoomDining extends Room {
	private static final long serialVersionUID = 1170105724267897380L;

	public RoomDining(Player player) {
		super(player);
		super.setRoomNr(8);
		super.setDoor(true);
		super.setRoomDescription(roomDescription());
		super.setLook("DR");
		super.setHandlingtxt(null);
		super.leggTilMonster(new Monster(), "Wraith");
		super.getInventory().leggTil(ItemType.Knife);

		super.getHandling().add("As you walk through the darkness you look around for anything of interest, but suddenly, you hear a<br>quiet yet terrifying growl. You trip and hit your arm on something in the confusion, then quickly run out<br>of the darkness.<br>");
		super.getHandling().add("In the corner of the dark side of the room there seems to be a shadow, swaying back and forth slowly.<br>You feel that whatever it is that's casting the shadow, you'd rather not want to find out.<br>");

		super.getValg().add("1. Search through the dark side of the room.");
		super.getValg().add("2. Investigate whatever is spilled by the table.");
		super.getValg().add("3. Go out into the corridor.");
	}
	
	public String roomDescription() {
		String s ="You walk into a huge square room with two long tables in the middle of it.<br>Half the room is covered by a curtain of darkness. It appears that someone or something has been in the<br>room recently - a patient perhaps as there are visible trails pacing between the tables and the doors in the dust covering the room. Judging by the circular spots in the dust on top of the left table,<br>someone must have eaten here recently. Something seems to be spilled at the edge of the darkness closer<br>to the other table.<br>";
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
			if (getValg().get(0).equals("1. Search through the dark side of the room.") && !getMonster(0).isdead()) {
					setHandlingtxt(getHandling().get(0));
					monsterStrikePlayer(-4);
				}
			else if (getValg().get(0).equals("1. Search through the dark side of the room.") && getMonster(0).isdead() && !getValg().get(0).equals("You've encountered a wraith.<br>PRESS ENTER WHEN YOU'RE READY TO FIGHT")) {
				secondScene();
				setHandlingtxt(getHandling().get(0));
			}

			else if (getValg().get(0).equals("1. Approach the shadow.")) {
				getHandling().set(0, "You've encountered a wraith.<br>PRESS ENTER WHEN YOU'RE READY TO FIGHT");
				setHandlingtxt(getHandling().get(0));
				super.getValg().set(0, "");
				super.getValg().set(1, "");
			}

			break;
		case "2":
			if (getValg().get(1).equals("2. Investigate whatever is spilled by the table.")) {
				setHandlingtxt(getHandling().get(1));
				super.getValg().set(0, "1. Approach the shadow.");
				super.getValg().set(1, "2. Step back");
				super.getValg().set(2, "");
			}else if (super.getValg().get(1).equals("2. Step back")) {
				super.getValg().set(0, "1. Search through the dark side of the room.");
				super.getValg().set(1, "2. Investigate whatever is spilled by the table.");
				super.getValg().set(2, "3. Go out to the corridor.");

			}

			break;
			
		
		case "":
			if (!getMonster(0).isdead()&& getHandling().get(0).equals("You've encountered a wraith.<br>PRESS ENTER WHEN YOU'RE READY TO FIGHT")) {
				getPlayer().StartFight(true);
				secondScene ();
			}

			break;

		default:
			break;
		}
	}
	
public void secondScene (){
	super.setHandlingtxt("");

	super.getValg().set(0, "1. Search through the dark side of the room.");
	super.getValg().set(1, "2. Go out into the corridor.");
	super.getValg().set(2, "");

if(getMonster(0).isdead()){
	super.getHandling().set(0, "There is nothing else of interest in this room other than a knife which you've picked up and the barely "
			+ "readable message on the wall.<br>Thankfully the message is written with a slightly shining,"
			+ " dark red substance - you get a feeling that it'd<br>be best not to think about what was "
			+ "used to write this. Whatever the message might refer to, it might be<br>important since "
			+ "someone has spent some time of their life - literally - to write it.<br>"
			+ "\"Do not... finger-scanner... find the owner... only his... will work...\"<br>");
	
		if (getInventory().har(ItemType.Knife)) {
			getPlayer().getInventory().leggTil(getInventory().gi(ItemType.Knife));
			setHandlingtxt(getHandling().get(0));
		}else if (getPlayer().getInventory().har(ItemType.Knife)) {
			setHandlingtxt(getHandling().get(0));
		}
}
	
	super.getHandling().set(1, "");
}
}

