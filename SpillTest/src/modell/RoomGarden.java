package modell;


public class RoomGarden extends Room {
	private static final long serialVersionUID = -7643005213964505653L;

	public RoomGarden(Player player) {
		super(player);
		super.setRoomNr(3);
		super.setDoor(true);
		super.setRoomDescription(roomDescription());
		super.setLook("GN");
		super.setHandlingtxt(null);
		super.getInventory().leggTil(ItemType.Shovel);
		super.getInventory().leggTil(ItemType.GaurdBoothKeyCard);


		super.leggTilMonster(new Monster(), "Zombie");
		super.leggTilMonster(new Monster(), "Skeleton");



		super.getHandling().add("There is something containing acid in there, and you got some on you when you opened the container. Your skin burns.");
		super.getHandling().add("You need something to break the rusted lock in order to enter the tool shed.");
		super.getHandling().add("");


		
		super.getValg().add("1. Look in the containers.");
		super.getValg().add("2. Look in the tool shed.");
		super.getValg().add("");

		
		
		


		
	}
	
	public String roomDescription() {
		String s ="Fresh air! But this isn't the way out; the garden is surrounded by really high concrete walls, and you can find no weaknesses! But maybe you will be able to find something usefull out here. Let's see; the garden is really just a patch of brown grass, some bushes at one side, a bench, some containers in one corner, and a tool shed.";
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
			if (getValg().get(0).equals("1. Look in the containers.")) {
				setHandlingtxt(getHandling().get(0));
				super.getPlayer().modifyHealth(-10);
			}

			break;
		case "2":
			if (getValg().get(1).equals("2. Look under the bench.")) {
				if (getPlayer().getInventory().har(ItemType.Shovel)) {
					super.getHandling().set(1, "There is nothing left");
				}else{
					getPlayer().getInventory().leggTil(getInventory().gi(ItemType.Shovel));
					super.getHandling().set(1, "There is something lodged under one of the seats. Oh! You found a shovel.");
				}
				setHandlingtxt(getHandling().get(1));
				
			}else if (getValg().get(1).equals("2. Look in the tool shed.")) {
				if (getPlayer().getInventory().har(ItemType.Hatchet)) {
					super.getHandling().set(1, "Oh no! There is a zombie in there.<br>PRESS ENTER WHEN YOU'RE READY TO FIGHT");
					super.getValg().set(0, "");
					super.getValg().set(1, "");
					super.getValg().set(2, "");
				}else{
					super.getHandling().set(1, "You need something to break the rusted lock in order to enter the tool shead.");
				}
				setHandlingtxt(getHandling().get(1));

			
			}else if (getValg().get(1).equals("2. Check if there is anything under the skeleton.")) {
				if (getPlayer().getInventory().har(ItemType.GaurdBoothKeyCard)) {
					super.getHandling().set(1, "There is nothing left");
				}else{
					getPlayer().getInventory().leggTil(getInventory().gi(ItemType.GaurdBoothKeyCard));
				}
				setHandlingtxt(getHandling().get(1));
			}


			
			break;
			
		case "3":
			if (getValg().get(2).equals("3. Behind the bushes, there's some fresh dirt. It looks like maybe there was something buried here not long ago.")) {
				
				if (getPlayer().getInventory().har(ItemType.Shovel)) {
					super.getHandling().set(2, "You've found a skeleton, it seems to be alive?.<br>PRESS ENTER WHEN YOU'RE READY TO FIGHT");
					super.getValg().set(0, "");
					super.getValg().set(1, "");
					super.getValg().set(2, "");
				}else{
					super.getHandling().set(2, "Try to find something to dig with.");

				}
				setHandlingtxt(getHandling().get(2));

			}

			break;
		case "":
			if (!getMonster(0).isdead() && getValg().get(0).equals("")) {
				getPlayer().StartFight(true);
				secondScene ();
			}else if  (!getMonster(1).isdead() && getValg().get(0).equals("")) {
				getPlayer().StartFight(true);
				thirdScene ();
			}

			break;

		default:
			break;
		}
	}
	
	public void secondScene (){

		super.setHandlingtxt("");

		super.getValg().set(0,"1. Look in the containers.");
		super.getValg().set(1, "2. Look under the bench.");
		super.getValg().set(2, "3. Behind the bushes, there's some fresh dirt. It looks like maybe there was something buried here not long ago.");

		super.getHandling().set(0,"There is something containing acid in there, and you got some on you when you opened the container. Your skin burns.");
		super.getHandling().set(1,"There is something lodged under one of the seats. Oh! You found a shovel.");
		super.getHandling().set(2,"Try to find something to dig with.");

	}
	
	public void thirdScene (){

		super.setHandlingtxt("");
		super.getValg().set(0,"1. Look in the containers.");
		super.getValg().set(1, "2. Check if there is anything under the skeleton.");
		super.getValg().set(2, "3. Go out into the corridor.");

		super.getHandling().set(0,"There is something containing acid in there, and you got some on you when you opened the container. Your skin burns.");
		super.getHandling().set(1, "You've found a key card!");
	}


}

