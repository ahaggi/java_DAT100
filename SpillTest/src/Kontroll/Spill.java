package Kontroll;

import modell.ItemType;
import modell.Memberstatus;
import modell.Player;
import modell.Room;
import modell.RoomCorridor;
import modell.RoomGarden;
import modell.RoomInfirmary;
import modell.RoomSolitaryConfinement;
import modell.RoomTherapy;
import modell.RoomKitchen;
import modell.RoomDining;
import modell.RoomPatient;
import modell.RoomOffice;
import modell.RoomGuardBooth;


import java.io.Serializable;

import modell.Combat;

public class Spill implements Serializable{
	private static final long serialVersionUID = 1959661537594202870L;
	private Player player;
	private Room r;
	private Room RoomSolitaryConfinement;
	private Room RoomCorridor;
	private Room RoomTerapi;
	private Room Roomkitchen;
	private Room RoomInfermary;
	private Room RoomGarden;
	private Room RoomPatient;
	private Room RoomOffice;
	private Room RoomDining;
	private Room RoomGuardBooth;
	private Room Combat;




	public  Spill() {
		player= new Player();
		r=null;
		RoomSolitaryConfinement=new RoomSolitaryConfinement(player);
		RoomCorridor=new RoomCorridor(player);
		Roomkitchen=new RoomKitchen(player);
		RoomTerapi=new RoomTherapy(player);
		RoomGarden=new RoomGarden(player);
		RoomDining=new RoomDining(player);
		RoomPatient=new RoomPatient(player);
		RoomOffice=new RoomOffice(player);
		RoomGuardBooth=new RoomGuardBooth(player);


		RoomInfermary=new RoomInfirmary(player);
		//	System.out.println(r.getRoomDescription());

	}
	public  void start() {
		r=RoomSolitaryConfinement;

	}
	public  void enter(String valg) {


		r.setHandlingtxt("");

		if (r instanceof RoomSolitaryConfinement) {//

			switch (valg) {
			case "1":
				r.setHandlingtxt("");
				((RoomSolitaryConfinement) r).enter(valg);
				break;
			case "2":
				r.setHandlingtxt("");
				((RoomSolitaryConfinement) r).enter(valg);
				break;
			case "3":
				r.setHandlingtxt("");
				if (r.getValg().get(2).equals("3. Go out into the corridor.")) {
					((RoomSolitaryConfinement) r).setRoomDescription(((RoomSolitaryConfinement) r).roomDescription());
					r=RoomCorridor;
					r.setHandlingtxt(r.getHandling().get(0));
				} else{
					((RoomSolitaryConfinement) r).enter(valg);
				}
				break;
			default:
				r.setHandlingtxt("");
				break;}//end switch

		}else if (r instanceof RoomCorridor) {
			switch (valg) {
			case "1":
				r.setHandlingtxt("");
				r=RoomSolitaryConfinement;
				break;
			case "2":
				r.setHandlingtxt("");
				r=RoomTerapi;
				break;
			case "3":
				r.setHandlingtxt("");
				r=Roomkitchen;
				break;
			case "4":
				r.setHandlingtxt("");
				if (RoomInfermary.setItOpen(ItemType.InfermaryKey)) {
					r=RoomInfermary;
				}else{
					r.getHandling().set(1, "This door is locked, you'll need to find a key.");
					r.setHandlingtxt(r.getHandling().get(1));//Try to find the infermary's key at the therapy room
				}
				break;
			case "5":
				r.setHandlingtxt("");
				r=RoomGarden;
				if (RoomGarden.getValg().get(2).equals("")) {
					RoomGarden.getValg().set(2, "3. Go out into the corridor.");

				}

				break;
			case "6":
				r.setHandlingtxt("");
				r=RoomPatient;
				break;
			case "7":
				r.setHandlingtxt("");
				r=RoomOffice;
				/////////////////////GJelder Office
				if (r.getPlayer().getInventory().har(ItemType.Code42)&&r.getValg().get(2).equals("")) {
					RoomOffice.setLook("OE2");
					RoomOffice.setSoundPlayed(false);
					RoomOffice.setRoomDescription("As you enter the room, you notice the stench of decomposition. Something in here has been dead for<br>at least a week. To the right you see a rotten palm tree. On the wall to the left <br>there is a safe with an advanced fingerprint lock. No way you're going to get that open<br>without it's owner.<br>In front of you is a massive Oak desk with leather trimmings. But oddly enough the chair behind the desk,<br>looks like it was stolen from a kitchen. As you walk around the desk, you see a person <br> that appears to be dead.<br>"); 
					RoomOffice.getValg().set(0, "1. Take a closer look at the dead body.");
				}
				/////////////////////GJelder Office
				break;
			case "8":
				r.setHandlingtxt("");
				r=RoomDining;

				break;
			case "9":
				r.setHandlingtxt("");
				if (RoomGuardBooth.setItOpen(ItemType.GaurdBoothKeyCard)) {
					r=RoomGuardBooth;
				}else{
					r.getHandling().set(1, "The door is secured,<br>you'll need a keycard to get inside!");
					r.setHandlingtxt(r.getHandling().get(1));
				}
				break;
			default:
				r.setHandlingtxt("");
				break;}//end switch

		}else if (r instanceof RoomTherapy) {
			switch (valg) {
			case "1":
				r.setHandlingtxt("");
				((RoomTherapy) r).enter(valg);
				break;
			case "2":
				r.setHandlingtxt("");
				((RoomTherapy) r).enter(valg);
				break;
			case "3":
				r.setHandlingtxt("");
				r=RoomCorridor;
				r.setHandlingtxt(r.getHandling().get(0));
				break;				
			default:
				r.setHandlingtxt("");
				break;}//end switch

		}else if (r instanceof RoomInfirmary) {
			switch (valg) {

			case "1":
				r.setHandlingtxt("");
				((RoomInfirmary) r).enter(valg);
				break;
			case "2":
				r.setHandlingtxt("");
				((RoomInfirmary) r).enter(valg);
				break;
			case "3":
				r.setHandlingtxt("");
				r=RoomCorridor;
				r.setHandlingtxt(r.getHandling().get(0));
				break;						
			default:
				r.setHandlingtxt("");
				break;}


		}else if (r instanceof RoomKitchen) {
			switch (valg) {
			case "1":
				r.setHandlingtxt("");
				((RoomKitchen) r).enter(valg);
				break;
			case "2":
				r.setHandlingtxt("");
				((RoomKitchen) r).enter(valg);
				break;
			case "3":
				r.setHandlingtxt("");
				if (r.getValg().get(2).equals("3. Go out into the corridor.")) {
					r=RoomCorridor;
					r.setHandlingtxt(r.getHandling().get(0));
				} else{
					((RoomKitchen) r).enter(valg);
				}
				break;
			case "":
				r.setHandlingtxt("");
				((RoomKitchen) r).enter(valg);
				if (r.getPlayer().startFight()) {
					r.getPlayer().StartFight(false);
					Combat =new Combat(r);
					r=Combat;
				}

				break;
			default:
				r.setHandlingtxt("");
				break;
			}
		}else if (r instanceof RoomDining) {
			switch (valg) {
			case "1":
				r.setHandlingtxt("");
				((RoomDining) r).enter(valg);
				break;
			case "2":
				r.setHandlingtxt("");
				if (r.getValg().get(1).equals("2. Go out into the corridor.")) {
					r=RoomCorridor;
					r.setHandlingtxt(r.getHandling().get(0));
					if (r.getPlayer().getInventory().har(ItemType.Knife)) {
						RoomSolitaryConfinement.getValg().set(1, "2. Try lifting the floor-tile with the knife.");
						RoomSolitaryConfinement.getHandling().set(1, "You stick the knife between the sharp edges of the crack and underneath the floor-tile, after lifting it, you remove the tile and beneath it, you find a small scrap of paper:<br>\"The Code: 42\"<br>Perhaps the tile didn't break due to being worn out?");
					}

				} else{
					((RoomDining) r).enter(valg);
				}
				break;
			case "3":
				r.setHandlingtxt("");
				if (r.getValg().get(2).equals("3. Go out into the corridor.")) {
					r=RoomCorridor;
					r.setHandlingtxt(r.getHandling().get(0));
				} else{
					((RoomDining) r).enter(valg);
				}
				break;
			case "":
				r.setHandlingtxt("");
				((RoomDining) r).enter(valg);
				if (r.getPlayer().startFight()) {
					r.getPlayer().StartFight(false);
					Combat =new Combat(r);
					r=Combat;
				}

				break;
			default:
				r.setHandlingtxt("");
				break;
			}
		}else if (r instanceof RoomGarden) {
			switch (valg) {
			case "1":
				r.setHandlingtxt("");
				((RoomGarden) r).enter(valg);
				break;
			case "2":
				r.setHandlingtxt("");
				((RoomGarden) r).enter(valg);
				break;
			case "3":
				r.setHandlingtxt("");
				if (r.getValg().get(2).equals("3. Go out into the corridor.")) {
					r=RoomCorridor;
					r.setHandlingtxt(r.getHandling().get(0));
				} else{
					((RoomGarden) r).enter(valg);
				}
				break;
			case "":
				r.setHandlingtxt("");
				((RoomGarden) r).enter(valg);
				if (r.getPlayer().startFight()) {
					r.getPlayer().StartFight(false);
					Combat =new Combat(r);
					r=Combat;
				}

				break;
			default:
				r.setHandlingtxt("");
				break;
			}
		}else if (r instanceof RoomPatient) {
			switch (valg) {
			case "1":
				r.setHandlingtxt("");
				((RoomPatient) r).enter(valg);
				break;
			case "2":
				r.setHandlingtxt("");
				((RoomPatient) r).enter(valg);
				break;
			case "3":
				r=RoomCorridor;
				r.setHandlingtxt(r.getHandling().get(0));
				break;				

			default:
				r.setHandlingtxt("");
				break;}//end switch

		}else if (r instanceof RoomOffice) {
			switch (valg) {
			case "1":
				r.setHandlingtxt("");
				if (r.getValg().get(0).equals("1. Go out into the corridor.")) {
					r=RoomCorridor;
					r.setHandlingtxt(r.getHandling().get(0));
				} else{
					((RoomOffice) r).enter(valg);
				}
				break;
			case "2":
				r.setHandlingtxt("");
				((RoomOffice) r).enter(valg);
				break;
			case "3":
				r.setHandlingtxt("");
				((RoomOffice) r).enter(valg);
				break;
			case "":
				r.setHandlingtxt("");
				((RoomOffice) r).enter(valg);
				if (r.getPlayer().startFight()) {
					r.getPlayer().StartFight(false);
					Combat =new Combat(r);
					r=Combat;
				}

				break;
			default:
				r.setHandlingtxt("");
				break;
			}
		}else if (r instanceof RoomGuardBooth) {
			switch (valg) {
			case "1":
				r.setHandlingtxt("");
				((RoomGuardBooth) r).enter(valg);
				break;
			case "2":
				r.setHandlingtxt("");
				((RoomGuardBooth) r).enter(valg);
				break;
			case "3":
				r.setHandlingtxt("");
				if (r.getValg().get(2).equals("3. Go out into the corridor.")) {
					r=RoomCorridor;
					r.setHandlingtxt(r.getHandling().get(0));
				} else{
					((RoomGuardBooth) r).enter(valg);
				}
				break;
			case "":
				((RoomGuardBooth) r).enter(valg);
				if (r.getPlayer().startFight()&& !r.getPlayer().isdead()) {
					r.getPlayer().StartFight(false);
					Combat =new Combat(r);
					r=Combat;
				}

				break;
			default:
				r.setHandlingtxt("");
				break;
			}
		}else if (r instanceof Combat) {
			r.setHandlingtxt("");
			((Combat) r).enter(valg);
			if (((Combat)r).getMonster().isdead()&& valg.equals("")) {
				r=((Combat) r).getCombatRoom();
			}

		}
	}//end of method



	public  String getValgMeny1() {
		String ValgMeny="";
		int i =1;
		for (String c  : r.getValg()) {
			if (i<5) {ValgMeny=ValgMeny+c+"<br>";}
			i++;
		}
		System.out.println(ValgMeny);
		return ValgMeny;
	}

	public  String getValgMeny2() {
		String ValgMeny="";

		int i =1;
		for (String c  : r.getValg()) {
			if (i>=5 && i <10) {ValgMeny=ValgMeny+c+"<br>";}
			i++;
		}

		return ValgMeny;
	}


	public  String getHandlingtxt() {
		return r.getHandlingtxt();
	}	

	public  String getPlayerInventory() {
		return r.getPlayerInventoryString();
	}
	public  String getRoomInventory() {
		return r.getRoomInventoryString();
	}
	public  String getPlayerHealth() {
		String health= Integer.toString(r.getPlayer().getHealth());
		return health;
	}
	public  int getPlayerHealthINT() {
		int health= r.getPlayer().getHealth();
		return health;
	}
	public  boolean checkPlayerIsdead() {
		return r.getPlayer().isdead();
	}
	public  boolean checkPlayerWon() {
		return r.getPlayer().won();
	}
	public void setMemberStatus(Memberstatus set){
		player.setMemberStatus(set);
	}

	public  String getRoomDescription() {
		String RoomDescription=r.getRoomDescription();
		return RoomDescription;
	}

	public  String getMonsterLook() {
		String image=r.getMonsterLook();
		return image;
	}
	public  String getCombatMonsterhealth() {
		String health= "";
		if (r instanceof Combat)
			health=Integer.toString(((Combat) r).getMonster().getHealth());
		return health;
	}

	public String getLook() {
		return r.getLook();
	}
	public boolean getSoundPlayed(){
		return r.getSoundPlayed();
	}
	public void setSoundPlayed(boolean played){
		r.setSoundPlayed(played);
	}


	public Room getActiveRoom() {
		return r;
	}


}
