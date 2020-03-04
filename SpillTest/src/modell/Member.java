package modell;

import java.io.Serializable;

public abstract class Member implements Serializable{
	private static final long serialVersionUID = 3001914512781030947L;
	private String name;
	private Memberstatus status;
	private Inventory inventory;
	private int health;
	private boolean startFight; 
		
	
	public Member(){
		name = "";
		status=Memberstatus.WOKEUP;
		inventory= new Inventory();
		health=100;
		
	}
	public Member(String name,Memberstatus status ,Inventory inventory,int health, int level){
		this.name = name;
		this.status=status;
		this.inventory= inventory;
		this.health=health;
	}
	
	public void modifyHealth(int health) {
		this.health = this.health+health;
		if (getHealth()>80 && getHealth()<100) {
			setStatus(Memberstatus.HEALTHY);
		}else if (getHealth()>0 && getHealth()<80) {
			setStatus(Memberstatus.INJURED);
		}else if (getHealth()<=0) {
			setStatus(Memberstatus.DIED);
		}
		
	}
	public void setHealthToNull() {
		modifyHealth(-(this.health));
	}
	
	
	public boolean isdead() {
		return (getStatus()==Memberstatus.DIED);
	}
	public boolean won() {
		return (getStatus()==Memberstatus.WON);
	}
	public void setMemberStatus(Memberstatus set){
		status = set;
	}
	
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Inventory getInventory() {
		return inventory;
	}

	public int getHealth() {
		return health;
	}
	public Memberstatus getStatus() {
		return status;
	} 
	public void setStatus(Memberstatus status) {
		this.status = status;
	}
	public boolean startFight() {
		return startFight;
	}
	public void StartFight(boolean startFight) {
		this.startFight = startFight;
	}
	
	

	
	
}
