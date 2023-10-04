package com.entities;

public class Furniture implements IEntity {
	private String name;
	
	public String getName() {
		return name;
	}
	
	Furniture(String name) {
		this.name = name;
	}
	
	
}
