package com.actions;

public class HideNarration implements IAction {

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "HideNarration";
	}

	@Override
	public boolean getShouldWait() {
		// TODO Auto-generated method stub
		return false;
	}
	public HideNarration() {
		
	}
	@Override
	public String toString() {
		return String.format("%s()", getName());
	}
}
