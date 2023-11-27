package com.actions;

public class HideDialog implements IAction {
	@Override
	public String getName() {
		return "HideDialog";
	}

	@Override
	public boolean getShouldWait() {
		return true;
	}
	
	public HideDialog() {	
	}
	@Override
	public String toString() {
		return String.format("%s()", getName());
	}
}

