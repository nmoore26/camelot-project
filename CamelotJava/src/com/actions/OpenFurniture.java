package com.actions;
import com.entities.*;
import com.entities.Character;
public class OpenFurniture implements IAction {
	private Character character;
	private Furniture furniture;
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "OpenFurniture";
	}

	@Override
	public boolean getShouldWait() {
		// TODO Auto-generated method stub
		return true;
	}
	
	public OpenFurniture(Character character, Furniture furniture ) {
		this.character = character;
		this.furniture = furniture;
				
	}
<<<<<<< HEAD
	@Override
	public String toString() {
		return String.format("%s(%s,%s)", getName(), character.getName(), furniture.getName());
	}
=======
	
	@Override
	public String toString() {
		return String.format("%s(%s, %s)", getName(), character.getName(), furniture.getName());
	}
	
>>>>>>> branch 'main' of https://github.com/nmoore26/camelot-project.git
}
