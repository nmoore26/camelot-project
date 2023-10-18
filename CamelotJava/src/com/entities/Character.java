package com.entities;

public class Character implements IEntity, IThing<com.entities.Character.BodyType> {
	private String name;
	private BodyType bodyType;
	private Clothing clothing;
	private Hairstyles hairStyle;
	
	public enum BodyType{
		A, B, C, D, E, F, G, H
	}
	
	public enum Clothing{
		Bandit, Beggar, HeavyArmour, LightArmour,Merchant,
		Naked, Noble, Peasant, Priest, Queen, Witch, King, 
		Warlock
	}
	
	public Clothing getClothing() {
		return clothing;
	}
	
	public enum Hairstyles{
		Long, Spiky, Short, Short_Beard,Short_Full,
		Ponytail, Straight, Mage, Mage_Beard, Mage_Full,
		Musketeer, Musketeer_Beard,Musketeer_Full,
	}
	
	public Hairstyles getHairstyle() {
		return hairStyle;
	}
	
	public Character(String name) {
		this(name,BodyType.A,Clothing.Peasant,Hairstyles.Short);
		
	}
	public Character(String name, BodyType bodyType) {
		this(name,BodyType.A,Clothing.Peasant,Hairstyles.Short);
	}
	public Character(String name,BodyType bodyType, Clothing clothing ) {
		this(name,BodyType.A,Clothing.Peasant,Hairstyles.Short);
	}
	
	public Character(String name,BodyType bodyType, Clothing clothing, Hairstyles hairStyle ) {
		this.name = name;
		this.bodyType = bodyType;
		this.clothing = clothing;
		this.hairStyle = hairStyle;
	}
	
	public String getName() {
		return name;
	}
	
	public BodyType getTemplate() {
		return bodyType;
	}
}
