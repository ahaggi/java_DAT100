package modell;

public class RoomGuardBooth extends Room {
	private static final long serialVersionUID = 7963073174111543262L;

	public RoomGuardBooth(Player player) {
		super(player);
		super.setRoomNr(9);
		super.setDoor(false);
		super.setRoomDescription(roomDescription());
		super.setLook("GB");
		super.setHandlingtxt(null);
		super.getInventory().leggTil(ItemType.guardKey);

		super.leggTilMonster(new Monster(), "Patient");
		super.leggTilMonster(new Monster(), "Guard");


		super.getValg().add("1. Talk to the patient.");
		super.getValg().add("2. Take the keys from the patient.");
		super.getValg().add("3. Go through the door on the other side of the guard booth: exit the asylum.");



		super.getHandling().add("Don't release the guard; he'll kill you! I'll stab you if you try to release him!");
		super.getHandling().add("Patient:\"AAARRHH! Those are mine!\". The patients comes at you, knife ready to slash. Press ENTER when you are ready to fight.");
		super.getHandling().add("");

	}

	public String roomDescription() {
		String s = "You have entered the guard booth. The first thing you see is the guard bound to the chair in the middle of the room, and the "
				+ "patient standing next to him. The patient is holding a knife in one hand, and the guard's keys in the other. "
				+ "It looks like there have been a struggle before the patient got the upper hand; there are a lot of files lying on the floor. "
				+ "You can see the exit.";
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
			if (getValg().get(0) == "1. Talk to the patient.") {
				setHandlingtxt(getHandling().get(0));
				super.getValg().set(0, "1. Never mind to what the patient says, release the guard.");

			} else if (getValg().get(0) == "1. Never mind to what the patient says, release the guard.") {
				super.getHandling().set(0, "The patient stabs you everytime you try to release the guard, you can almost see your kidney, the wound goes deep into your abdomen.");
				setHandlingtxt(getHandling().get(0));
				getPlayer().modifyHealth(-20);

			}else if (getValg().get(0) == "1. Release the guard.") {
				if (getPlayer().getInventory().har(ItemType.Gun)) {
					super.getHandling().set(0, "The guard attacks you. Push ENTER when you are ready to fight.");
					setHandlingtxt(getHandling().get(0));
					super.getValg().set(0, "");
					super.getValg().set(1, "");
					super.getValg().set(2, "");
				}else{//player har ikke gun
					super.getHandling().set(0, "You need to have a gun, try to find it in another room");
					setHandlingtxt(getHandling().get(0));
				}	

			}else if (getValg().get(0) == "1. Try to use the retina scanner.") {
				setHandlingtxt(getHandling().get(0));
				getPlayer().modifyHealth(-5);
			}


			break;
		case "2":
			if (getValg().get(1) == "2. Take the keys from the patient.") {
				getPlayer().getInventory().leggTil((getInventory().gi(ItemType.guardKey)));
				setHandlingtxt(getHandling().get(1));
				super.getValg().set(0, "");
				super.getValg().set(1, "");
				super.getValg().set(2, "");

			}else if (getValg().get(1) == "2. Go through the door on the other side of the guard booth: exit the asylum.") {
				setHandlingtxt(getHandling().get(1));
			}else if (getValg().get(1) == "2. Use the knife to cut out the guard's retina, and use it to open the exit door.") {
				super.getHandling().set(1, "The door of the asylum is open...<br><br>Now what?<br><br> PRESS ENTER WHEN YOU'RE READY TO FIND OUT!");
				setHandlingtxt(getHandling().get(1));
				super.getValg().set(0, "");
				super.getValg().set(1, "");
				super.getValg().set(2, "");
			}
			break;

		case "3":
			if (getValg().get(2) == "3. Go through the door on the other side of the guard booth: exit the asylum.") {
				if (!getPlayer().getInventory().har(ItemType.Gun)){
					super.getHandling().set(2, "The door is sealed. Every exit is locked. The patient's mumbling is driving you insane. Game over. Next time, bring a gun!");
					setHandlingtxt(getHandling().get(2));
					
					super.getValg().set(0, "");
					super.getValg().set(1, "");
					super.getValg().set(2, "");
				}
			}

			break;
		case "":
			if ("The door is sealed. Every exit is locked. The patient's mumbling is driving you insane. Game over. Next time, bring a gun!".equals(getHandling().get(2))) {
				super.getPlayer().setHealthToNull();
			}else if (!getMonster(0).isdead() && getValg().get(0).equals("")) {
				getPlayer().StartFight(true);
				secondScene ();
			}else if (!getMonster(1).isdead() && getValg().get(0).equals("")) {
				getPlayer().StartFight(true);
				thirdScene ();
			}else if ("The door of the asylum is open...<br><br>Now what?<br><br> PRESS ENTER WHEN YOU'RE READY TO FIND OUT!".equals(getHandling().get(1))) {
				super.getPlayer().setStatus(Memberstatus.WON);
			}
			break;

		default:
			break;
		}
	}

	public void secondScene() {

		super.getValg().set(0, "1. Release the guard.");
		super.getValg().set(1, "2. Go through the door on the other side of the guard booth: exit the asylum.");
		super.getValg().set(2, "3. Go out into the corridor.");

		
		super.getHandling().set(0, "The guard attacks you.<br>Push ENTER when you are ready to fight.");
		super.getHandling().set(1, "You have the key, but there is also a retina-scanner-lock on the door.");
		super.getHandling().set(2, "");
	}

	public void thirdScene() {
		super.getValg().set(0, "1. Try to use the retina scanner.");
		super.getValg().set(1, "2. Use the knife to cut out the guard's retina, and use it to open the exit door."); // Use the retina scanner with the guards retina
		super.getValg().set(2, "");

		super.getHandling().set(0, "The retina scanner denies you access. The laser intensifies, and burns your retina."); // (-5) health
		super.getHandling().set(1, ""); // Freedom!
		super.getHandling().set(2, "");
	}


}

