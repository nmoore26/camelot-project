package com.actions;

public class ShowCredits implements IAction  {
	//blank
	public ShowCredits() {
	}
	public String getName() {
		return "ShowCredits";
	}
	
	public boolean getShouldWait() {
		return true;
	}
	
	
}
