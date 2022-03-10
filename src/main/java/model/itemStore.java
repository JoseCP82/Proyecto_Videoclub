package model;

import java.util.HashSet;

import interfaces.IItem;
import interfaces.IItemStore;

public class ItemStore {
private HashSet<Item> items;
	
	
	
	

	public ItemStore() {
		 items = new HashSet<Item>();
	}

	

	public boolean addItem(Item i) {
		boolean valid = items.add(i);
		return valid;
	}

	public Item searchItem(String name) {
		Item e = null;
		
		for(Item o:items) {
			if(o.getName()==name) {
				e=o;
			}
		}
		return e;
	}

	public boolean updateItem(String name, String description, float price) {
		boolean valid = false;
		Item search = searchItem(name);
		
		if(search !=null) {
			search.setDescription(description);
			search.setPrice(price);
			valid=true;
		}
		return valid;
	}

	public boolean removeItem(Item i) {
		boolean valid = items.remove(i);
		return valid;
	}

	public void saveItems(String url) {
		
	}

	public void loadItems(String url) {
		
	}

}
