package com.actions;
import com.entities.Character;

public class Laugh implements IAction {
	private Character character;
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Laugh";
	}

	@Override
	public boolean getShouldWait() {
		// TODO Auto-generated method stub
		return true;
	}
	public Laugh(Character character) {
		this.character = character;
	}
	@Override
	public String toString() {
		return String.format("%s(%s)", getName(), character.getName());
	}
	
}
