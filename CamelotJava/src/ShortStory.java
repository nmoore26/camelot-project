import com.actions.*;
import com.entities.*;
import com.entities.Character;
import com.entities.Character.BodyType;
import com.entities.Character.Clothing;
import com.entities.Character.Hairstyles;
import com.entities.Item.Items;
import com.entities.Place.Places;
import com.entities.Things.ThingNames;
import com.storygraph.*;
import com.sequences.*;
public class ShortStory implements IStory{
	private Character Bartholomew;
	private Item openScroll;
	private Place BHome;
	private Place city;
	private Character knight;
	private Character kingBoone;
	private Place kingsDungeon;
	private Place library;
	private Character DrAliReza;
	private Place ruins;
	private Character banditCaspera;
	private Item jewelKey;
	private Place tavern;
	private Character patronRandy;
	private Character bartenderMilina;
	private Item cupOfBeer;
	private Place greatHall;
	
	public INode getRoot() {
		return new Node("root");
	}
	
	public void getThings() {
		Bartholomew = new Character(ThingNames.Bartholomew.toString(),BodyType.D,Clothing.Peasant,Hairstyles.Short_Beard);
		openScroll = new Item(ThingNames.openScroll.toString(),Items.Scroll);
		BHome = new Place(ThingNames.BHome.toString(),Places.Cottage);
		city = new Place(ThingNames.city.toString(), Places.City);
		knight = new Character(ThingNames.knight.toString(),BodyType.B,Clothing.HeavyArmour,Hairstyles.Short);
		kingBoone = new Character(ThingNames.kingBoone.toString(),BodyType.D, Clothing.King,Hairstyles.Short);
		greatHall = new Place(ThingNames.greatHall.toString(),Places.GreatHall);
		kingsDungeon = new Place(ThingNames.kingsDungeon.toString(),Places.Dungeon);
		library = new Place(ThingNames.library.toString(),Places.Library);
		DrAliReza = new Character(ThingNames.DrALiReza.toString(),BodyType.H,Clothing.Merchant,Hairstyles.Short);
		ruins = new Place(ThingNames.ruins.toString(), Places.Ruins);
		banditCaspera = new Character(ThingNames.banditCaspera.toString(), BodyType.A,Clothing.Bandit, Hairstyles.Long);
		jewelKey = new Item(ThingNames.jewelkey.toString(),Items.JewelKey);
		tavern = new Place(ThingNames.tavern.toString(),Places.Tavern);
		patronRandy = new Character(ThingNames.patronRandy.toString());
		bartenderMilina = new Character(ThingNames.bartenderMilina.toString(), BodyType.A, Clothing.Beggar);
		cupOfBeer = new Item(ThingNames.cupOfBeer.toString(),Items.Cup);
		
	}	
		
	public ActionMap getMap() {
		var map = new ActionMap();
		return map;
	}
	
	private ActionSequence getInit() {
		var sequence = new ActionSequence();
		sequence.combineWith(new CharacterCreation(Bartholomew));
		sequence.add(new Create<Place>(BHome));
		sequence.add(new Position(Bartholomew,BHome,"Bed"));
		sequence.add(new Position(openScroll,BHome,"Chest"));
		sequence.add(new SetNarration("The scroll reads:"
				+ "Dear Bartholomew,"
				+ "		I have lost my precious jewel key. You are the best investigator in the kingdom."
				+ "		I need you to help me find my jewel key and who stole it. Please tell my "
				+ "		knight whether you accept my quest. "));
		sequence.add(new SetCameraFocus(Bartholomew));
		sequence.add(new ShowMenu(true));
		return sequence;
		
	}
	
	private ActionSequence getStartSequence() {
		var sequence = new ActionSequence();
		sequence.add(new ShowMenu(false));
		sequence.add(new EnableInput(true));
		return sequence;
	}
	
	private ActionSequence getReadScroll() {
		var sequence = new ActionSequence();
		sequence.add(new OpenFurniture(Bartholomew,BHome.getFurniture("Chest")));
		sequence.add(new ShowNarration());
		return sequence;
	}

	private ActionSequence getExitBHome() {
		var sequence = new ActionSequence();
		sequence.add(new Exit(Bartholomew, BHome.getFurniture("Door"), true));
		sequence.add(new Create<Place>(city));
		sequence.combineWith(new CharacterCreation(knight));
		sequence.add(new Position(knight,city,"Fountain"));
		sequence.add(new Position(Bartholomew,city,"EastEnd"));
		sequence.add(new SetDialogue("Do you accept the kings quest? [AccpeptQuest|Accpept Quest?][DeclineQuest|Decline Quest?]"));
		return sequence;
	}
	
	private ActionSequence getTalkToKnight() {
		var sequence = new ActionSequence();
		sequence.add(new SetRight(knight));
		sequence.add(new ShowDialogue());
		return sequence;
	}
	
	
	private ActionSequence getEnterPrison() {
		var sequence = new ActionSequence();
		sequence.combineWith(new CharacterCreation(kingBoone));
		sequence.add(new Create<Place>(kingsDungeon));
		sequence.add(new SetDialogue("Do you accept my quest? [AccpeptQuest|Accpept Quest?][DeclineQuest|Decline Quest?]"));
		sequence.add(new Position(Bartholomew,kingsDungeon,"DirtPile"));
		sequence.add(new Position(kingBoone,kingsDungeon,"CellDoor"));
		return sequence;
	}
	
	private ActionSequence sleepInPrison() {
		var sequence = new ActionSequence();
		sequence.add(new Sleep(Bartholomew,kingsDungeon.getFurniture("Bed")));
		sequence.add(new SetDialogue("Now do you accept my quest? [AccpeptQuest|Accpept Quest?][DeclineQuest|Decline Quest?]"));
		return sequence;
	}
	
	private ActionSequence getTalkToKing() {
		var sequence = new ActionSequence();
		sequence.add(new ShowDialogue());
		sequence.add(new SetRight(kingBoone));
		return sequence;
	}
	
	private ActionSequence kingOpensDoor() {
		var sequence = new ActionSequence();
		sequence.add(new SetDialogue("You are free to begin my quest!"));
		sequence.add(new OpenFurniture(kingBoone, kingsDungeon.getFurniture("CellDoor")));
		sequence.add(new ShowDialogue());
		return sequence;
	}
	private ActionSequence getExitPrison() {
		var sequence = new ActionSequence();
		sequence.add(new Exit(Bartholomew, kingsDungeon.getFurniture("Door"), true));
		sequence.add(new Create<Place>(city));
		sequence.combineWith(new CharacterCreation(knight));
		sequence.add(new Position(knight,city,"Fountain"));
		sequence.add(new Position(Bartholomew,city,"EastEnd"));
		sequence.add(new SetDialogue("Where do you want to go? [Library|Library][Tavern|Tavern][Ruins|Ruins]"));
		return sequence;
	}
	
	private ActionSequence bartAcceptsQuest() {
		var sequence = new ActionSequence();
		sequence.add(new SetDialogue("Where do you want to begin your quest? [Library|Library][Tavern|Tavern][Ruins|Ruins]"));
		sequence.add(new ShowDialogue());
		return sequence;
	}
	
	
	// Library Nodes
	private ActionSequence getEnterLibrary() {
		var sequence = new ActionSequence();
		sequence.combineWith(new CharacterCreation(DrAliReza));
		sequence.add(new Create<Place>(library));
		sequence.add(new Position(DrAliReza,library,"Bookcase4"));
		sequence.add(new Enter(Bartholomew, BHome.getFurniture("Door"),true));
		return sequence;
	}
	
	private ActionSequence getTalkLibrarian() {
		var sequence = new ActionSequence();
		sequence.add(new SetCameraFocus(Bartholomew));
		sequence.add(new SetDialogue("")); // will come up with when I talk with Miles
		return sequence;
	}
	private ActionSequence getTalkToBandit() {
		var sequence = new ActionSequence();
		sequence.add(new ShowDialogue()); 
		sequence.add(new SetDialogue("Stop Theif you are Under arrest"));
		return sequence;
	}
	private ActionSequence getKnightArrestsBandit() {
		var sequence = new ActionSequence();
		sequence.add(new ShowDialogue()); 
		return sequence;
	}
	
	private ActionSequence getGem() {
		var sequence = new ActionSequence();
		sequence.add(new OpenFurniture(Bartholomew, ruins.getFurniture("Chest")));
		sequence.add(new SetNarration("You found the kings jewel key! return it to him!"));
		sequence.add(new SetDialogue("Lets get to the king immediately he will be so happy that youy found his jewel key"));
		return sequence;
	}
	
	private ActionSequence talkToKnight3() {
		var sequence = new ActionSequence();
		sequence.add(new ShowDialogue());
		return sequence;
	}
	
	private ActionSequence getExitRuins() {
		var sequence = new ActionSequence();
		sequence.add(new Exit(Bartholomew, ruins.getFurniture("Exit"), true));
		sequence.add(new Exit(knight, ruins.getFurniture("Exit"), true));
		sequence.add(new Create<Place>(greatHall));
		sequence.add(new Position(kingBoone,greatHall,"Throne"));
		sequence.add(new Position(Bartholomew,greatHall,"LeftDoor"));
		sequence.add(new SetDialogue(""));
		
		return sequence;
	}
	private ActionSequence talkToKing() {
		var sequence = new ActionSequence();
		sequence.add(new ShowDialogue()); 
		return sequence;
	}
	private ActionSequence getCredits() {
		var sequence = new ActionSequence(); 
		return sequence;
	}

}
