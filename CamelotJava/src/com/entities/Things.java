package com.entities;

import java.util.Hashtable;
import java.util.Optional;
public class Things {
	public enum ThingNames{ Tom, Home, Sword,Bartholomew, chestCottage, openScroll,BHome, city, knight, 
		kingsDungeon, library, DrALiReza, ruins, banditCaspera, chestRuins, jewelkey, tavern, patronRandy, 
		bartenderMilina, cupOfBeer, kingBoone, greatHall } 
	private static Hashtable<ThingNames, IThing<?>> list=new Hashtable<>();
	public static boolean add(ThingNames name, IThing<?> thing) {
		if(list.containsKey(name))
			return false;
		list.put(name, thing);
		return true;
	}
	
	public static Optional<IThing<?>> get(ThingNames name) {
		return Optional.ofNullable(list.get(name));
	}
}
