package modell;

import java.io.Serializable;

public class Inventory implements Serializable{
	private static final long serialVersionUID = -6345472121353018271L;
	private ItemType [] items;
	public static final int MAKS_ALLOWED_ITEMS = 8;//TODO skulle blitt mendre enn antall ITEM
	private int numberOfItems=0;			
	
	public Inventory () {
		items = new ItemType[MAKS_ALLOWED_ITEMS];
	}
	
	public void leggTil(ItemType item) {
		if(numberOfItems<items.length && item!=null){//ikke nødvendig å teste om item ikke er null
			items[numberOfItems]=item;
			numberOfItems++;
		}
	}
		
	public boolean har(ItemType item) {
		for (int i = 0; i < numberOfItems; i++) {
			if (items[i].equals(item)) {
				return true;
			}
		}
		return false;
	}
	
	public void fjern(ItemType item) {
		for (int i = 0; i < numberOfItems; i++) {
			if (items[i].equals(item)) {
				int x= numberOfItems-1;
				if (i != x) {//tester hvis "i" er index til det siste  item i tabellen
				items[i]=items[numberOfItems-1];
				items[numberOfItems-1]=null;
				numberOfItems--;
				}else {
				items[numberOfItems-1]=null;
				numberOfItems--;
				}//end else
			}//end if
			}//end for
	}
	public ItemType gi(ItemType item) {
		ItemType k=null;
		for (int i = 0; i < numberOfItems && k==null; i++) {
			if (items[i].equals(item)) {
				int x= numberOfItems-1;
				if (i != x) {//tester hvis "i" er index til det siste  item i tabellen
				k=items[i];
				items[i]=items[numberOfItems-1];
				items[numberOfItems-1]=null;
				numberOfItems--;
				}else {
				k=items[numberOfItems-1];
				items[numberOfItems-1]=null;
				numberOfItems--;
				}//end else
			}//end if
			}//end for
		return k;
	}
	
	public void fjernAlle() {
		for (int i = 0; i < numberOfItems; i++) {
			items[i]=null;
		}
		numberOfItems=0;
	}

	public String inventoryToString() {
		String s="";
		for (int i = 0; i < numberOfItems; i++) {
			if (items[i].equals(ItemType.Code42)) {
				s=s+"Note: \"Code: 42\""+"<br>";
			}else{
				s=s+items[i]+"<br>";
			}
		}
		return s;
	}

	public ItemType[] getItems() {
		return items;
	}

	public void setItems(ItemType[] items) {
		this.items = items;
	}

	public static int getMaksAllowedItems() {
		return MAKS_ALLOWED_ITEMS;
	}




}
