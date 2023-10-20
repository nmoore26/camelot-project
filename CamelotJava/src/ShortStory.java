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
	
	
	
	
	
	
	
	
	
	
	
	
}
