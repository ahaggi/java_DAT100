package Kontroll;

import java.io.Serializable;

import modell.Memberstatus;
import modell.Room;

public class Kontroll implements Serializable {
	private static final long serialVersionUID = 3399894102330945227L;
	private Spill spill;


	public Kontroll() {
	spill= new Spill();
	}
	
	public void start(){
		spill.start();
	}
	public  boolean checkPlayerIsdead() {
		return spill.checkPlayerIsdead();
	}
	public  boolean checkPlayerWon() {
		return spill.checkPlayerWon();
	}
	public void setMemberStatus(Memberstatus set){
		spill.setMemberStatus(set);
	}
	
	public void enter(String valgJtext) {
		spill.enter(valgJtext);
	}
	
	public  String getValgMeny1() {
		return spill.getValgMeny1();
	}
	public  String getValgMeny2() {
		return spill.getValgMeny2();
	}
	
	public  String getHandlingtxt() {
		return spill.getHandlingtxt();
	}	
	
	public  String getPlayerInventory() {
		return spill.getPlayerInventory();
	}
	public  String getRoomInventory() {
		return spill.getRoomInventory();
	}
	public  String getPlayerHealth() {
		return spill.getPlayerHealth();
	}
	public  int getPlayerHealthINT() {
		return spill.getPlayerHealthINT();
	}
	
	public  String getRoomDescription() {
		return spill.getRoomDescription();
	}
	
	public  String getMonsterLook() {
		return spill.getMonsterLook();
	}
	public  String getCombatMonsterhealth() {
		return spill.getCombatMonsterhealth();
	}
	public String getLook() {
		return spill.getLook();
	}
	public boolean getSoundPlayed(){
		return spill.getSoundPlayed();
	}
	public void setSoundPlayed(boolean played){
		spill.setSoundPlayed(played);
	}

	public Room getActiveRoom() {
		return spill.getActiveRoom();
	}



}
