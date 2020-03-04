package modell;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


public abstract class Room implements Serializable{
	private static final long serialVersionUID = 5734284257205933226L;
	private int roomNr;
	private boolean door;
	private String roomDescription;
	private Inventory inventory;
	private Player player;
	private Monster [] monster;
	private int monsterAntall;
	private ArrayList<String> valg = new ArrayList<String>();
	private ArrayList<String> handling = new ArrayList<String>();
	private String handlingtxt;
	private String MonsterImage;	
	private String pathSoundBackground;
	private boolean soundPlayed;

	
	public Room(Player player) {
		this.player =player;
		roomNr=0;
		inventory=new Inventory();
		monster=new Monster[2];
		monsterAntall=0;
		valg = new ArrayList<String>();
		handling = new ArrayList<String>();
		handlingtxt=null;

	}
	

	public void playerStrikeMonster(int damage , Monster monster) {
		monster.modifyHealth(damage);
	}
	public void monsterStrikePlayer(int damage ) {
		getPlayer().modifyHealth(damage);
	}
	

	
	public int getRoomNr() {
		return roomNr;
	}
	public void setRoomNr(int roomNr) {
		this.roomNr = roomNr;
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public boolean setItOpen(ItemType item) {
		if (getPlayer().getInventory().har(item)) {
			setDoor(true);
		}
		return door;
	}

	public void setDoor(boolean door) {
		this.door = door;
	}

	public String getRoomDescription() {
		return roomDescription;
	}

	public void setRoomDescription(String roomDescription) {
		this.roomDescription = roomDescription;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}
	
	public String getPlayerInventoryString(){
		return this.player.getInventory().inventoryToString();
	}
	public String getRoomInventoryString(){
		return this.getInventory().inventoryToString();
	}


	public String getLook() {
		return pathSoundBackground;
	}
	public void setLook(String soundBackgroundPath) {
		this.pathSoundBackground = soundBackgroundPath;
	}
	public boolean getSoundPlayed(){
		return soundPlayed;
	}
	public void setSoundPlayed(boolean played){
		soundPlayed = played;
	}
	public String getMonsterLook() {
		return MonsterImage;
	}
	public void setMonsterLook(String image) {
		MonsterImage = image;
	}
	public Monster getMonster(int i) {
		return monster[i];
	}

	public void leggTilMonster(Monster monster, String navn) {
		this.monster[monsterAntall] = monster;
		this.monster[monsterAntall].setName(navn);;
		monsterAntall++;
	}
	public Monster finnMonster(String navn) {
		for (int i = 0; i < monsterAntall; i++) {
			if (monster[i].getName().equals(navn)) {
				return monster[i];
			}
		}
		return null;
	}
	
	public ArrayList<String> getValg() {
		return valg;
	}
	
	public void removeallValg() {
		for (int i = 0; i < getValg().size(); i++) {
			getValg().remove(i);
		}
		
	}
	
	public void setValg(ArrayList<String> valg) {
		this.valg = valg;
	}
	public ArrayList<String> getHandling() {
		return handling;
	}
	public void setHandling(ArrayList<String> handling) {
		this.handling = handling;
	}
	public String getHandlingtxt() {
		return handlingtxt;
	}
	public void setHandlingtxt(String handlingtxt) {
		this.handlingtxt = handlingtxt;
	}
	
}

