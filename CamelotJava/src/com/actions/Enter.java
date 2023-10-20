package com.actions;
import com.entities.Furniture;
import com.entities.Character;

public class Enter implements IAction {
	Character character;
	Furniture furniture;
	boolean fadeIn;
	public Enter(Character character, Furniture furniture) {
		this.character = character;
		this.furniture = furniture;
	}
	public Enter(Character character, Furniture furniture, boolean fadeIn) {
		this.character = character;
		this.furniture = furniture;
		this.fadeIn = fadeIn;
	}
	@Override
	public String getName() {
		return "Enter";
	}

	@Override
	public boolean getShouldWait() {
		return false;
	}
	@Override
	public String toString() {
		return String.format("%s(%s,%s,%s)", getName(), character.getName(), furniture.getName(),fadeIn);
	}
	
}
