package com.actions;

public class SetDialogue implements IAction {
	public String dialogue;
	@Override
	//blank
	public String getName() {
		return null;
	}

	@Override
	public boolean getShouldWait() {
		return true;
	}
	public SetDialogue(String dialogue) {
		this.dialogue = dialogue;
	}
	public String getDialogue() {
		return dialogue;
	}
}
