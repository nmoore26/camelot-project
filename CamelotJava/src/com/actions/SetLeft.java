package com.actions;
import com.entities.Character;
import com.entities.Furniture;
public class SetLeft implements IAction {
	Character character;
	String hide;
	@Override
	public String getName() {
		return "SetLeft";
	}

	@Override
	public boolean getShouldWait() {
		return false;
	}
	public SetLeft(Character character) {
		this.character = character;
	}
	public SetLeft(String hide) {
		hide = null;
	}
	
}
