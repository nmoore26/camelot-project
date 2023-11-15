package com.actions;

import com.entities.*;
import com.entities.Character;

public class Sleep implements IAction {
	private Character character;
	private Furniture furniture;
	@Override
	public String getName() {
		return "Sleep";
	}
	@Override
	public boolean getShouldWait() {
		return true;
	}
	public Sleep(Character character, Furniture furniture ) {
		this.character = character;
		this.furniture = furniture;
				
	}
	@Override
	public String toString() {
		return String.format("%s(%s, %s)", getName(), character.getName(), furniture.getName());
	}
}
