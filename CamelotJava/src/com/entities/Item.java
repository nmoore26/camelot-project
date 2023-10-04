package com.entities;

public class Item implements IEntity, IThing<com.entities.Item.Items>  {
	private String name;
	private Items template;
	
	public enum Items {
		Apple, Bag, BlueBook, BlueCloth, BlueKey, BluePotion, Bottle, Bread, ChickenLeg, 
		Coin, Compass,Cup, EvilBook, GoldCup, GreenBook, GreenKey,
		GreenPotion, Hammer, Helmet, InkandQuill, JewelKey, LitTorch, Lock, MagnifyingGlass,
		OpenScroll, PurpleBook, PurpleCloth, PurpleKey, PurplePotion, Rags,RedBook, RedCloth, RedKey, 
		RedPotion, Scroll, Skull, Spellbook, Sword, Torch
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public Items getTemplate() {
		return template;
	}
	
	public Item(String name, Items template) {
		this.name = name;
		this.template = template;
	}
}
