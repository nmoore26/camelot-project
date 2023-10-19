package com.actions;

public class SetNarration implements IAction {
	public static String narration;
	@Override
	public String getName() {
		return "SetNarration";
	}
	
	public boolean getShouldWait() {
		return false;
	}
	
	public SetNarration(String narration) {
		SetNarration.narration = narration;
	}
	
	public static String getNarration() {
		return narration;
	}
}
