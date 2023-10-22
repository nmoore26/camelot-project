package com.actions;

public class SetDialogue implements IAction {
	public static String dialogue;
	@Override
	public String getName() {
		return null;
	}

	@Override
	public boolean getShouldWait() {
		return true;
	}
	public SetDialogue(String dialogue) {
		SetDialogue.dialogue = dialogue;
	}
	public static String getDialogue() {
		return dialogue;
	}
}
