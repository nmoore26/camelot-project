package com.actions;

public class ShowDialog implements IAction {
	public ShowDialog() {
			
		}
		public String getName() {
			return "ShowDialog";
		}
		
		public boolean getShouldWait() {
			return true;
		}
		@Override
		public String toString() {
			return String.format("%s()", getName());
		}
		
}
