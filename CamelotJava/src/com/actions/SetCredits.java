package com.actions;

public class SetCredits implements IAction {
	public String credits;
	@Override
	public String getName() {
		return "SetCredits";
	}

	@Override
	public boolean getShouldWait() {
		return true;
	}
	public SetCredits(String credits){

		this.credits = credits;
	}
	public String credits() {
		return credits;
	}
	@Override
	public String toString() {
		return String.format("%s(%s)", getName(),credits());
	}
}

