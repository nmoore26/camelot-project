package com.actions;

public class SetDialog implements IAction {
	public String dialogue;
	@Override
	//blank
	public String getName() {
		return "SetDialog";
	}

	@Override
	public boolean getShouldWait() {
		return true;
	}
	public SetDialog(String dialogue) {
		this.dialogue = dialogue;
	}
	public String getDialogue() {
		return dialogue;
	}
	@Override
	public String toString() {
		return String.format("%s(%s)", getName(),getDialogue());
	}
}

