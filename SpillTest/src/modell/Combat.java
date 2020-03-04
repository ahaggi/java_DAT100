package modell;

public class Combat extends Room {
	private static final long serialVersionUID = 1446330030563472790L;
	
	private Room originalRoom;
	private Monster monster;

	public Combat(Room originalRoom) {
		super(originalRoom.getPlayer());//endring i player her vil resutere i endring i originalrooms player 
		
		this.originalRoom=originalRoom;
		
		super.setRoomNr(00);
		super.setDoor(true);
		super.setSoundPlayed(true);
		super.setLook("COMBAT");
		super.setHandlingtxt(originalRoom.getHandlingtxt());

		if (originalRoom instanceof RoomKitchen) {
			monster=(originalRoom.getMonster(0));
			System.out.println(monster.getHealth());
			super.setMonsterLook("Ghost");

			super.getValg().add("1. Attack the chef.");//TODO
			super.getValg().add("2. Try to open the metal door.");//TODO

			super.getHandling().add("You've succeded, try again!");//TODO
			super.getHandling().add("The door is locked and the chef strikes you in the back while you fiddle with it.");

		}else if (originalRoom instanceof RoomDining) {
			monster=(originalRoom.getMonster(0));
			System.out.println(monster.getHealth());
			super.setMonsterLook("Wraith");

			super.getValg().add("1. Strike "+monster.getName() + ".");//TODO
			super.getValg().add("2. Try getting away from the " + monster.getName() + ".");//TODO

			super.getHandling().add("You need to finish it off.");//TODO
			super.getHandling().add("The "+monster.getName()+" attacked you before you could try anything.");

		}else if (originalRoom instanceof RoomOffice) {
			monster=(originalRoom.getMonster(0));
			System.out.println(monster.getHealth());
			super.setMonsterLook("Zombie");

			super.getValg().add("1. Attack the "+monster.getName()+" in a boring fashion.");//TODO
			super.getValg().add("2. Try to go in for a pin.");//TODO

			super.getHandling().add("It seems the boring attacks are the most effective ones.");//TODO
			super.getHandling().add("The " + monster.getName() + " bites itself out of your pin, seems John Cena wouldn't do too well in the Walking Dead, then again, the zombies probably wouldn't be able to see him...");

		}else if (originalRoom instanceof RoomGarden) {
			if (!originalRoom.getMonster(0).isdead()) {
				monster=(originalRoom.getMonster(0));
				super.setMonsterLook("Zombie");
				
				super.getValg().add("1. Attack the "+monster.getName() + ".");//TODO
				super.getValg().add("2. Try outsmarting the " + monster.getName() + ".");//TODO

				super.getHandling().add("You've managed to land a hit on the " + monster.getName() + ".");//TODO
				super.getHandling().add("The "+monster.getName()+" appears to be smarter you initially thought, you suffer from being outsmarted.");

			}else if (!originalRoom.getMonster(1).isdead()) {
				monster=(originalRoom.getMonster(1));
				super.setMonsterLook("Skeleton");
				
				super.getValg().add("1. Attack the "+monster.getName() + ".");//TODO
				super.getValg().add("2. Try to discuss politics with the "+monster.getName()+".");//TODO

				super.getHandling().add("You damage the " + monster.getName() + ".");//TODO
				super.getHandling().add("When is that ever a good idea? Your plan backfires...");
			}


		}else if (originalRoom instanceof RoomGuardBooth) {
			if (!originalRoom.getMonster(0).isdead()) {
				monster=(originalRoom.getMonster(0));
				super.setMonsterLook("Patient");

				super.getValg().add("1. Strike the "+monster.getName() + ".");//TODO
				super.getValg().add("2. Try getting away from the " + monster.getName() + ".");//TODO

				super.getHandling().add("You need to finish him off.");//TODO
				super.getHandling().add("The "+monster.getName()+" attacked you before you could try anything.");
				
			}else if (!originalRoom.getMonster(1).isdead()) {
				monster=(originalRoom.getMonster(1));
				super.setMonsterLook("Guard");
				
				super.getValg().add("1. Attack the "+monster.getName()+".");//TODO
				super.getValg().add("2. Try guarding the next attack.");//TODO

				super.getHandling().add("You've landed a hit on the " + monster.getName() + ".");//TODO
				super.getHandling().add("You could never hope to win a guarding contest against a "+monster.getName()+"...");
				}
		}
	}


	public Room getCombatRoom() {
		return originalRoom;
	}
	public void setCombatRoom(Room originalRoom) {
		this.originalRoom = originalRoom;
	}
	
	public Monster getMonster() {
		return monster;
	}


	public String getPlayerInventoryString(){
		return super.getPlayer().getInventory().inventoryToString();
	}

	public  String getRoomInventoryString(){
		return super.getInventory().inventoryToString();
	}

	/*
	 
	public void playerAttacks(){
//		Sound attack1 = new Sound(mainJframe.getKontroll().getMonsterSound1());
//		attack1.play();
		String path = "PatientGuardBooth.png";//TODO
		Label.addImage(monster, path, 250, 30, 866, 460);
		Label.sleep(attack, 300);
	}
	public void monsterAttacks(){
//		Sound attack2 = new Sound(mainJframe.getKontroll().getMonsterSound2());
//		attack2.play();
//		String path = mainJframe.getKontroll().getMonsterImage2(); 
//		Label.addImage(monster, path, 0, -10, 1366, 768);
		Label.sleep(attack, 300);
	}
	
	private void resetAnim(){
		String path = mainJframe.getKontroll().getMonsterImage(); 
		Label.addImage(monster, path, 200, 0, 966, 520);
	}
	
	private Action attack = new AbstractAction() {
		private static final long serialVersionUID = 7892201122490351698L;
		@Override
		public void actionPerformed(ActionEvent arg0) {
			resetAnim();
		}
	};
	
	 */


	public void enter(String valg){

		switch (valg) {
		case "1":
			if (originalRoom instanceof RoomKitchen) {
				setHandlingtxt(getHandling().get(0));
				playerStrikeMonster(-30, monster);
			}else if (originalRoom instanceof RoomGarden) {
				setHandlingtxt(getHandling().get(0));
				playerStrikeMonster(-40, monster);
			}else if (originalRoom instanceof RoomDining) {
				setHandlingtxt(getHandling().get(0));
				playerStrikeMonster(-40, monster);
			}else if (originalRoom instanceof RoomOffice) {
				setHandlingtxt(getHandling().get(0));
				playerStrikeMonster(-50, monster);
			}else if (originalRoom instanceof RoomGuardBooth) {
				setHandlingtxt(getHandling().get(0));
				playerStrikeMonster(-40, monster);
			}


			if (monster.isdead()) {
				super.getHandling().set(0, "You've defeated the "+monster.getName()+".<br>Press Enter to Continue...");//TODO
				setHandlingtxt(getHandling().get(0));
				super.getValg().set(0, " ");
				super.getValg().set(1, " ");
			}//if (getPlayer().isdead()||getMonster().isdead()) 


			break;
		case "2":
				setHandlingtxt(getHandling().get(1));
				monsterStrikePlayer(-10);

				if (getPlayer().isdead()) {
					super.getHandling().set(0, "Game Over!");//TODO remove valgmeny
					setHandlingtxt(getHandling().get(0));
					super.getValg().set(0, " ");
					super.getValg().set(1, " ");

				}

			

			break;

		case "":

			break;
		default:
			break;
		}
	}


	//	public void startFight(String valg){
	//
	//		switch (valg) {
	//			case "1":
	//				if (getPlayer().getInventory().har(ItemType.knife)) {
	//					
	//					super.getHandling().set(0, "xxxxxxthe battel began you losing your strength. You've to finish himxxxxxxxxxxx");
	//					setHandlingtxt(getHandling().get(0));
	//
	//					super.getValg().set(0, "xxxxxxuse a weapon xxxxxxxxxxx");
	//					super.getValg().set(1, "xxxxxxtry to open metal door xxxxxxxxxxx");
	//					super.getValg().remove(2);
	//					
	//				}else{
	//					super.getHandling().set(0, "There is nothing lift");//TODO
	//					setHandlingtxt(getHandling().get(0));				
	//				}
	//				
	//
	//
	//				break;
	//			case "2":
	//				if (getValg().get(1)=="2. Decline his drink and start walking out of the kitchen.") {
	//					setHandlingtxt(getHandling().get(1));
	//					
	//					getPlayer().StartFight(true);
	//
	//					super.getValg().set(0, "xxxxxxuse a weapon xxxxxxxxxxx");
	//					super.getValg().set(1, "xxxxxxtry to open metal door xxxxxxxxxxx");
	//					super.getValg().remove(2);
	//
	//				}else{
	//					super.getHandling().set(1, "qedqedqedqefqfqe");//TODO
	//					setHandlingtxt(getHandling().get(1));				
	//				}
	//				
	//				break;
	//			case "3":
	//				if (getValg().get(2)=="3. Grab your knife.") {
	//					setHandlingtxt(getHandling().get(2));
	//					getPlayer().StartFight(true);
	//
	//					super.getValg().set(0, "xxxxxxuse a weapon xxxxxxxxxxx");
	//					super.getValg().set(1, "xxxxxxtry to open metal door xxxxxxxxxxx");
	//					super.getValg().remove(2);
	//
	//				}else{
	//					super.getHandling().set(1, "qedqedqedqefqfqe");//TODO
	//					setHandlingtxt(getHandling().get(1));				
	//				}
	//				break;
	//
	//			default:
	//				break;
	//			}
	//		
	//}


}

