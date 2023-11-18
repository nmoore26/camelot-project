package com.actions;
import com.entities.Character;
public class SetRight implements IAction {
	Character character;
	String hide;
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "SetRight";
	}

	@Override
	public boolean getShouldWait() {
		// TODO Auto-generated method stub
		return false;
	}
	public SetRight(Character character) {
		this.character = character;
	}
	public SetRight(String hide) {
		hide = null;
	}
	@Override
	public String toString() {
		return String.format("%s(%s)", getName(),character.getName());
	}
}
