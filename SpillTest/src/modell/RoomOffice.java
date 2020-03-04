package modell;


public class RoomOffice extends Room {
	private static final long serialVersionUID = -6153814325408889822L;

	public RoomOffice(Player player) {
		super(player);
		super.setRoomNr(7);
		super.setDoor(true);
		super.setRoomDescription(roomDescription());
		super.setLook("OE");
		super.setHandlingtxt(null);
		super.leggTilMonster(new Monster(), "Zombie");
		super.getInventory().leggTil(ItemType.Gun);


		super.setHandlingtxt("");
		//opner andre muligheter etter at spiller får tak i code fra Solitary

		super.getValg().add("1. Go out into the corridor.");
		super.getValg().add("");
		super.getValg().add("");

		super.getHandling().add("");
		super.getHandling().add("");
		super.getHandling().add("");	
	}

	public String roomDescription() {
		String s ="The door is locked by what appears to be a voice activated lock system.<br>"
				+ "An automated voice utters the words \"What is the meaning of life?\"<br>"
				+ "The password seems to be wrong.<br>There must be a reference to it around this place somewhere...";
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
			
			if (getValg().get(0).equals("1. Take a closer look at the dead body.")) {
				super.getHandling().set(0, "As you examine the dead body, you find a name-tag that say \"Vladimir Aristov\".<br>In his pocket is a picture of a woman and a child. And a small note containing the message:<br>\"What have you done? Experiment 178 has gone terribly wrong. We cannot contain it for much<br>longer! Please Aristov, we beg you to terminate the project before we get destroyed.\"<br>When you are about to stand up, the body comes to life and immediately starts attacking you.<br>");
				super.getValg().set(0, "");
				super.getValg().set(1, "");
				super.getValg().set(2, "");
				setHandlingtxt(getHandling().get(0));
			}
			
			break;
		case "2":
			if (getValg().get(1).equals("2. Try to put your finger on the safe fingerprint scanner.")) {
				super.getHandling().set(1, "You stick your finger inside the fingerprint scanner. A sharp blade comes down from the casing of the scanner and cuts off your thumb.");
				setHandlingtxt(getHandling().get(1));
				super.getPlayer().modifyHealth(-6);
				hasKnifeScene();
				
			}else if (getValg().get(1).equals("2. Cut off \"Vladimir Aristov's\" finger and use it to open the safe.")) {
				if (super.getInventory().har(ItemType.Gun)) {
					super.getPlayer().getInventory().leggTil(super.getInventory().gi(ItemType.Gun));
					super.getHandling().set(1, "Inside the safe there's a Magnum 44, some old documents and some cash.<br> You take the gun, not much use for money here...");
					setHandlingtxt(getHandling().get(1));
					super.getValg().set(1, "");
				}

			}

			break;
		case "3":
			if (getValg().get(2).equals("3. Search the drawers of the massive desk.")) {
				super.getHandling().set(2, "In the drawer you find Vladimir's diary. You turn to the last page.<br>\"Experiment 178 is finally in it's final stage. The world will be amazed<br>by it's beauty. I just wish 177 was here to see it. On the other<br>hand, he would have to taste the treacherous soup the chef makes, which seems<br>to be having some negative effect on the subject's health.\"");
				setHandlingtxt(getHandling().get(2));
			}

			break;


		case "":
			if (!getMonster(0).isdead() && getValg().get(0).equals("")) {
				getPlayer().StartFight(true);
				secondScene ();
			}
			break;

		default:
			break;
		}
	}

	public void secondScene (){
		super.setRoomDescription("As you enter the room, you notice the stench of decomposition. Something in here has been dead for<br>at least a week. To the right you see a rotten palm tree. On the wall to the left<br>there is a safe with an advanced fingerprint lock. No way you're going to get that open<br>without it's owner.<br>In front of you is a massive Oak desk with leather trimmings. But oddly enough the chair behind the desk,<br>looks like it was stolen from a kitchen.<br>"); 

		super.getValg().set(0, "1. Go out into the corridor.");
		super.getValg().set(1, "2. Try to put your finger on the safe fingerprint scanner.");
		super.getValg().set(2, "3. Search the drawers of the massive desk.");

	}

	public void hasKnifeScene (){
		if (getValg().get(1).equals("2. Try to put your finger on the safe fingerprint scanner.")||getValg().get(1).equals("2. Drag his body to the scanner")) {
			if (super.getPlayer().getInventory().har(ItemType.Knife)) {
				super.getValg().set(1, "2. Cut off \"Vladimir Aristov's\" finger and use it to open the safe.");
				setHandlingtxt(getHandling().get(1));
			}else{
				super.getValg().set(1, "2. Drag his body to the scanner");
				setHandlingtxt(getHandling().get(1));
			}
		}
	}//end has knife

}

