package com.entities;

public class Place implements IThing<com.entities.Place.Places> {
	private String name;
	private Places template;
	
	public enum Places {
		AlchemyShop, Blacksmith, Bridge, Camp, CastleBedroom, Castlecrossroads, City,
		Cottage, Courtyard, DiningRoom, Dungeon, Farm, ForestPath, GreatHall, Hallway, 
		Library, Port, Ruins, SpookyPath, Storage, Tavern
	}
	public Place(String name, Places template) {
		this.name = name;
		this.template = template;
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public Places getTemplate() {
		return template;
	}
	
	public Furniture getFurniture(String furnitureName) {
		String fullName = name + "." + furnitureName;
		return new Furniture(fullName);
	}
	
}
