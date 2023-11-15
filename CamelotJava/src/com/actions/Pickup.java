package com.actions;
import com.entities.Character;
import com.entities.Furniture;
import com.entities.Item;
public class Pickup implements IAction {
	Character character;
	Furniture furniture;
	Item item;
	
	@Override
	public String getName() {
		return "Pickup";
	}

	@Override
	public boolean getShouldWait() {
		return true;
	}
	public Pickup(Character character, Item item,Furniture furniture) {
		this.character = character;
		this.item = item;
		this.furniture = furniture;
	}
	public Pickup(Character character, Item item) {
		this.character = character;
		this.item = item;
		furniture = null;
	}
}
