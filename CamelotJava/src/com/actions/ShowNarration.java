package com.actions;

// Ask Ali Reza about how to implement
public class ShowNarration implements IAction  {
	
	public ShowNarration() {
		
	}
	public String getName() {
		return "ShowNarration";
	}
	
	public boolean getShouldWait() {
		return true;
	}
	
	
}
