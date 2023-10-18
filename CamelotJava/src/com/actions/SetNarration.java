package com.actions;

public class SetNarration implements IAction {
	private String narration;
	@Override
	public String getName() {
		return "SetNarration";
	}
	
	public boolean getShouldWait() {
		return false;
	}
	
	public SetNarration(String narration) {
		this.narration = narration;
	}
}
