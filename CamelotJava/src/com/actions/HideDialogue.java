package com.actions;

public class HideDialogue implements IAction {
	@Override
	public String getName() {
		return "HideDialogue";
	}

	@Override
	public boolean getShouldWait() {
		return true;
	}
	
	public HideDialogue() {
		
	}
}
