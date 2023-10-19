package com.actions;


public class Wait implements IAction{
	@Override
	public String getName() {
		return "Wait";
	}
	@Override
	public boolean getShouldWait() {
		return true;
	}
	private double time;
	public Wait (double time) {
		this.time = time;
	}
	
}
