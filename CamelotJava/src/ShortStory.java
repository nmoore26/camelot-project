import com.actions.*;
import com.entities.*;
import com.entities.Character;
import com.entities.Character.BodyType;
import com.entities.Character.Clothing;
import com.entities.Character.Hairstyles;
import com.entities.Item.Items;
import com.entities.Place.Places;
import com.entities.Things.ThingNames;
import com.playerInput.*;
import com.playerInput.PositionChoice.Condition;
import com.playerInput.ActionChoice.Icons;
import com.playerInput.PositionChoice;
import com.playerInput.SelectionChoice;
import com.playerInput.PositionChoice.Condition;
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
	
	public ShortStory() {
		getThings();
	}
	
	public INode getRoot() {
		var root = new Node(NodeLabels.Init.toString());
		var start = new Node(NodeLabels.Start.toString());
		var ReadScroll = new Node(NodeLabels.ReadScroll.toString());
		var Entercityfromcot = new Node(NodeLabels.EntercityfromCot.toString());
		var ExitBHome = new Node(NodeLabels.ExitBHome.toString());
		var TalkToKnight = new Node(NodeLabels.TalkToKnight.toString());
		var EnterPrison = new Node(NodeLabels.EnterPrison.toString());
		var StayInPrison = new Node(NodeLabels.StayInPrison.toString());
		var sleepInPrison = new Node(NodeLabels.sleepInPrison.toString());
		var TalkToKing = new Node(NodeLabels.TalkToKing.toString());
		var kingOpensDoor = new Node(NodeLabels.kingOpensDoor.toString());
		var ExitPrison = new Node(NodeLabels.ExitPrison.toString());
		var bartAcceptsQuest = new Node(NodeLabels.bartAcceptsQuest.toString());
		
		var LibraryNarration = new Node(NodeLabels.LibraryNarration.toString());
		var TavernNarration = new Node(NodeLabels.TavernNarration.toString());
		var RuinsNarration = new Node(NodeLabels.RuinsNarration.toString());
		
		var RuinsNarrationfromTavern = new Node(NodeLabels.RuinNarrationfromTavern.toString());
		var EnterLibrary = new Node(NodeLabels.EnterLibrary.toString());
		// Nina Start Here
		var TalkLibrarian = new Node(NodeLabels.TalkLibrarian.toString());
		var Desk = new Node(NodeLabels.Desk.toString());
		var Bookshelf4 = new Node(NodeLabels.Bookshelf4.toString());
		var TalkLibrarian2 = new Node(NodeLabels.TalkLibrarian2.toString());
		var ExitLibrary = new Node(NodeLabels.ExitLibrary.toString());
		var KnightDialoguefromLibrary = new Node(NodeLabels.KnightDialoguefromLibrary.toString());
		var EnterTavern = new Node(NodeLabels.EnterTavern.toString());
		var Talkwithbartender = new Node(NodeLabels.Talkwithbartender.toString());
		var TalkwithRandy = new Node(NodeLabels.TalkwithRandy.toString());
		var ExitTavern = new Node(NodeLabels.ExitTavern.toString());
		var EnterRuins = new Node(NodeLabels.EnterRuins.toString());
		var WalktoPlant = new Node(NodeLabels.WalktoPlant.toString());
		var TalktoBandit = new Node(NodeLabels.TalktoBandit.toString());
		var KnightArrestBandit = new Node(NodeLabels.KnightArrestBandit.toString());
		var JewelKey = new Node(NodeLabels.JewelKey.toString());
		var ExitRuins = new Node(NodeLabels.ExitRuins.toString());
		var TalktoKing2 = new Node(NodeLabels.TalktoKing2.toString());
		var EnterPalace = new Node(NodeLabels.EnterPalace.toString());
		var Credits = new Node(NodeLabels.Credits.toString());
		
		root.addChild(new SelectionChoice("Start"), start);		
		start.addChild(
			new ActionChoice(
				ActionNames.OpenFurniture.toString(),
				BHome.getFurniture("Chest"),
				Icons.chest,
				"Open chest",
				true),
			ReadScroll);
		ReadScroll.addChild(
			new ActionChoice(
				ActionNames.Exit.toString(),
				BHome.getFurniture("Door"),
				Icons.exit,
				"Leave House",
				true),
			Entercityfromcot);
			
		Entercityfromcot.addChild(new PositionChoice(Bartholomew,"knight", PositionChoice.Condition.arrived), TalkToKnight);
		
		TalkToKnight.addChild(new SelectionChoice(ChoiceLabels.AcceptQuest.toString()), bartAcceptsQuest);
		
		TalkToKnight.addChild(new SelectionChoice(ChoiceLabels.DeclineQuest.toString()), EnterPrison);
		
		EnterPrison.addChild(
			new ActionChoice(
				ActionNames.Face.toString(),
				kingBoone,
				Icons.talk,
				"Face King",
				true),
			TalkToKing);
		
		TalkToKing.addChild(new SelectionChoice(ChoiceLabels.AcceptQuest.toString()), kingOpensDoor);
		
		TalkToKing.addChild(new SelectionChoice(ChoiceLabels.DeclineQuest.toString()), StayInPrison);
		
		StayInPrison.addChild(
				new ActionChoice(
						ActionNames.Face.toString(),
						kingBoone,
						Icons.talk,
						"Face King",
						true), TalkToKing);
		
		kingOpensDoor.addChild(
			new ActionChoice(
				ActionNames.Exit.toString(),
				kingsDungeon.getFurniture("Door"),
				Icons.exit,
				"Open door",
				true),
			ExitPrison);
		ExitPrison.addChild(new PositionChoice(Bartholomew,"knight", PositionChoice.Condition.arrived), bartAcceptsQuest);
		
		bartAcceptsQuest.addChild(new SelectionChoice(ChoiceLabels.Library.toString()),LibraryNarration);
		
		LibraryNarration.addChild(new ActionChoice(
						ActionNames.Enter.toString(),
						city.getFurniture("RedHouseDoor"),
						Icons.door,
						"Enter Library",
						true), EnterLibrary);
		
		TavernNarration.addChild(new ActionChoice(
				ActionNames.Enter.toString(),
				city.getFurniture("BlueHouseDoor"),
				Icons.door,
				"Enter Tavern",
				true), EnterTavern);
		
		RuinsNarration.addChild(new PositionChoice(Bartholomew, city.getFurniture("WestEnd"),PositionChoice.Condition.arrived), EnterRuins);
		
		
		bartAcceptsQuest.addChild(new SelectionChoice(ChoiceLabels.Tavern.toString()),TavernNarration);
		
		bartAcceptsQuest.addChild(new SelectionChoice(ChoiceLabels.Ruins.toString()),RuinsNarration);

		EnterLibrary.addChild(new PositionChoice(Bartholomew,"DrAliReza",PositionChoice.Condition.arrived), TalkLibrarian);
		//TalkToKnight.addChild(new SelectionChoice(ChoiceLabels.DeclineQuest.toString()), EnterPrison);
		TalkLibrarian.addChild(new PositionChoice(Bartholomew,
				library.getFurniture("Table"), PositionChoice.Condition.arrived), Desk);
		
		Desk.addChild(new PositionChoice(Bartholomew,library.getFurniture("Bookcase4"),PositionChoice.Condition.arrived), Bookshelf4 );
		Bookshelf4.addChild(new ActionChoice(
				ActionNames.Face.toString(),
				DrAliReza,
				Icons.talk,
				"Face Librarian",
				true), TalkLibrarian2);
		TalkLibrarian2.addChild(new ActionChoice(
				ActionNames.Exit.toString(),
				library.getFurniture("Door"),
				Icons.door,
				"Leave house",
				true),
				ExitLibrary);
		ExitLibrary.addChild(new ActionChoice(ActionNames.Face.toString(),knight,Icons.talk,"Talk to Knight",true), KnightDialoguefromLibrary);
		KnightDialoguefromLibrary.addChild(new SelectionChoice(ChoiceLabels.Tavern.toString()), TavernNarration);
		
		KnightDialoguefromLibrary.addChild(new SelectionChoice(ChoiceLabels.Ruins.toString()), RuinsNarration);
		
		EnterTavern.addChild(new PositionChoice(Bartholomew,tavern.getFurniture("Bar"),PositionChoice.Condition.arrived), Talkwithbartender);
		EnterTavern.addChild(new PositionChoice(Bartholomew,"patronRandy",PositionChoice.Condition.arrived), TalkwithRandy);
		TalkwithRandy.addChild(new ActionChoice(ActionNames.Exit.toString(),
				tavern.getFurniture("Door"),
				Icons.door,
				"Leave Bar",
				true), ExitTavern);
		
		ExitTavern.addChild(new PositionChoice(Bartholomew,city.getFurniture("BlueHouseDoor"),PositionChoice.Condition.arrived),RuinsNarrationfromTavern);
		RuinsNarrationfromTavern.addChild(new PositionChoice(Bartholomew,city.getFurniture("WestEnd"),PositionChoice.Condition.arrived), EnterRuins);
		Talkwithbartender.addChild(new ActionChoice(ActionNames.Face.toString(),
				patronRandy,
				Icons.talk,
				"Talk with Randy",
				true), TalkwithRandy);
		
		EnterRuins.addChild(new PositionChoice(Bartholomew,ruins.getFurniture("Plant"),PositionChoice.Condition.arrived), WalktoPlant);
		EnterRuins.addChild(new PositionChoice(Bartholomew,ruins.getFurniture("Chest"),PositionChoice.Condition.arrived), TalktoBandit);	
		WalktoPlant.addChild(new PositionChoice(Bartholomew,ruins.getFurniture("Chest"),PositionChoice.Condition.arrived), TalktoBandit);
		TalktoBandit.addChild(new PositionChoice(Bartholomew,knight,PositionChoice.Condition.arrived), KnightArrestBandit);
		KnightArrestBandit.addChild(new PositionChoice(Bartholomew,ruins.getFurniture("Chest"),Condition.arrived), JewelKey);
		JewelKey.addChild(new PositionChoice(Bartholomew, ruins.getFurniture("Exit"), PositionChoice.Condition.arrived),ExitRuins);
		
		ExitRuins.addChild(new PositionChoice(Bartholomew, city.getFurniture("EastEnd"),PositionChoice.Condition.arrived) , EnterPalace);
		
		EnterPalace.addChild(new PositionChoice(Bartholomew,greatHall.getFurniture("Throne"),PositionChoice.Condition.arrived), TalktoKing2);
		//TalktoKing2.addChild(new SelectionChoice("Show Menu") , Credits);
		
	
		
		StayInPrison.addChild(
			new ActionChoice(
				ActionNames.Sleep.toString(),
				kingsDungeon.getFurniture("Bed"),
				Icons.sleep,
				"Sleep",
				true),
			sleepInPrison);
		
		sleepInPrison.addChild(
			new ActionChoice(
				ActionNames.Sleep.toString(),
				kingsDungeon.getFurniture("Bed"),
				Icons.sleep,
				"Sleep",
				true),
			TalkToKing);
		
		ExitPrison.addChild(new SelectionChoice(ChoiceLabels.Library.toString()), EnterLibrary);
		
		EnterLibrary.addChild(
			new ActionChoice(
				ActionNames.Face.toString(),
				DrAliReza,
				Icons.talk,
				"Face Dr Ali Reza",
				true),
			TalkLibrarian);
		return root;
	}
	
	public enum ActionNames{

		AddToList, Attack, Bash, Cast, CheckVersion ,Clap ,ClearDialog ,ClearList, CloseFurniture, CreateCharacter,WalkToSpot, Wave,
		CreateEffect, CreateItem, CreatePlace, Dance, DanceTogether, Die, DisableEffect, DisableIcon, DisableInput, Draw,
		Drink, EnableEffect, EnableIcon, EnableInput, Enter, Exit, Face, FadeIn, FadeOut, Give, HideCredits, HideDialog, HideFurniture, 
		HideList, HideMenu, HideNarration, Kneel, Laugh, LookAt, MoveAway, OpenFurniture, Pickup, PlaySound, Pocket, Put, Putdown, Quit,
		RemoveFromList, Reset, Revive, SetCameraBlend, SetCameraFocus, SetCameraMode, SetClothing, SetCredits, SetDay, SetDialog,
		SetExpression, SetEyeColor, SetHairColorSetHairStyle, SetLeft, SetNarration, SetNight,SetPosition, SetRight, SetSkinColor, SetTitle,
		Sheathe, ShowCredits, ShowDialog,showFurniture, ShowList, ShowMenu, ShowNarration, Sit, Sleep, StopSound, Take, Unpocket, Wait, WalkTo,
	}
	public void getThings() {
		Bartholomew = new Character(ThingNames.Bartholomew.toString(),BodyType.D,Clothing.Peasant,Hairstyles.Short_Full);
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
		tavern = new Place(ThingNames.Tavern.toString(),Places.Tavern);
		patronRandy = new Character(ThingNames.patronRandy.toString(),BodyType.F,Clothing.Beggar,Hairstyles.Long);
		bartenderMilina = new Character(ThingNames.bartenderMilina.toString(), BodyType.A, Clothing.Beggar,Hairstyles.Long);
		cupOfBeer = new Item(ThingNames.Cup.toString(),Items.Cup);
		
	}	
	
	public enum ChoiceLabels{
		AcceptQuest, DeclineQuest, Library, Tavern, Ruins, ShowCredits
	}
		
	public ActionMap getMap() {
		var map = new ActionMap();
		map.add(NodeLabels.Init.toString(), getInit());
		map.add(NodeLabels.Start.toString(), getStartSequence());
		map.add(NodeLabels.ReadScroll.toString(), getReadScroll());
		map.add(NodeLabels.OpenBHomeDoor.toString(), getOpenBHomeDoor());
		map.add(NodeLabels.ExitBHome.toString(), getExitBHome());
		map.add(NodeLabels.EntercityfromCot.toString(), getEntercity());
		map.add(NodeLabels.TalkToKnight.toString(), getTalkToKnight());
		map.add(NodeLabels.EnterPrison.toString(), getEnterPrison());
		map.add(NodeLabels.StayInPrison.toString(), StayInPrison());
		map.add(NodeLabels.sleepInPrison.toString(), sleepInPrison());
		map.add(NodeLabels.TalkToKing.toString(), getTalkToKing());
		map.add(NodeLabels.kingOpensDoor.toString(), kingOpensDoor());
		map.add(NodeLabels.ExitPrison.toString(), getExitPrison());
		map.add(NodeLabels.bartAcceptsQuest.toString(), getbartAcceptsQuest());
		
		map.add(NodeLabels.LibraryNarration.toString(), getLibraryNarration());
		map.add(NodeLabels.RuinsNarration.toString(), getRuinsNarration());
		map.add(NodeLabels.TavernNarration.toString(), getTavernNarration());
		map.add(NodeLabels.RuinNarrationfromTavern.toString(), getRuinsNarrationfromTavern());
		
		map.add(NodeLabels.EnterLibrary.toString(), getEnterLibrary());
		map.add(NodeLabels.TalkLibrarian.toString(), getTalkLibrarian());
		map.add(NodeLabels.Desk.toString(), getgoToDesk());
		map.add(NodeLabels.Bookshelf4.toString(), getgoToBookshelf4());
		map.add(NodeLabels.TalkLibrarian2.toString(), gettalkToLibrarian2());
		map.add(NodeLabels.ExitLibrary.toString(), getExitLibrary());
		map.add(NodeLabels.KnightDialoguefromLibrary.toString(), getKnightDialogueFromLibrary());
		map.add(NodeLabels.EnterTavern.toString(), getEntertavern());
		map.add(NodeLabels.Talkwithbartender.toString(), getTalkToBartender());
		map.add(NodeLabels.TalkwithRandy.toString(), gettalkWithPatron());
		
		map.add(NodeLabels.ExitTavern.toString(), getLeaveTavern());
		map.add(NodeLabels.EnterRuins.toString(), getEnterRuins());
		map.add(NodeLabels.WalktoPlant.toString(), getwalkToPlant());
		map.add(NodeLabels.TalktoBandit.toString(), getTalkToBandit());
		map.add(NodeLabels.KnightArrestBandit.toString(), getKnightArrestsBandit());
		map.add(NodeLabels.JewelKey.toString(), getJewelKey());
		map.add(NodeLabels.ExitRuins.toString(), getExitRuins());
		map.add(NodeLabels.EnterPalace.toString(), getEnterPalace());
		
		map.add(NodeLabels.TalktoKing2.toString(), talkToKing());
		return map;
	}
	 private enum NodeLabels {
		 Init,Start,ReadScroll,OpenBHomeDoor, ExitBHome,EntercityfromCot,TalkToKnight,EnterPrison,StayInPrison,sleepInPrison,TalkToKing,kingOpensDoor, ExitPrison,
		 bartAcceptsQuest,LibraryNarration, RuinsNarration,RuinNarrationfromTavern, TavernNarration,EnterLibrary,TalkLibrarian, Desk, Bookshelf4,TalkLibrarian2, ExitLibrary,KnightDialoguefromLibrary,
		 EnterTavern,Talkwithbartender,TalkwithRandy,ExitTavern, EnterRuins,WalktoPlant,TalktoBandit,KnightArrestBandit,JewelKey, TalktoKnight3,
		 ExitRuins, TalktoKing2,EnterPalace,Credits,
	 }
	
	private ActionSequence getInit() {
		
		var sequence = new ActionSequence();
		sequence.combineWith(new CharacterCreation(Bartholomew));
		sequence.add(new Create<Place>(BHome));
		sequence.add(new Position(Bartholomew,BHome,"Bed"));
		//sequence.add(new Position(openScroll,BHome,"Chest"));
		sequence.add(new SetNarration("The scroll reads: Dear Bartholomew,"));
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
		//sequence.add(new Pickup(Bartholomew,openScroll,BHome.getFurniture("Chest")));
		sequence.add(new ShowNarration());
		sequence.add(new Wait(3));
		sequence.add(new HideNarration());
		sequence.add(new SetNarration("I have lost my precious jewel key."));
		sequence.add(new ShowNarration());
		sequence.add(new Wait(3));
		sequence.add(new HideNarration());
		sequence.add(new SetNarration("You are the best investigator in the kingdom."));
		sequence.add(new ShowNarration());
		sequence.add(new Wait(3));
		sequence.add(new HideNarration());
		sequence.add(new SetNarration("I need you to help me find my jewel key and who stole it."));
		sequence.add(new ShowNarration());
		sequence.add(new Wait(3));
		sequence.add(new HideNarration());
		sequence.add(new SetNarration("Please tell my knight whether you accept my quest."));
		sequence.add(new ShowNarration());
		sequence.add(new Wait(3));
		sequence.add(new HideNarration());
		sequence.add(new Create<Place>(city));
		sequence.combineWith(new CharacterCreation(knight));
		sequence.add(new Position(knight,city,"Fountain"));
		sequence.add(new SetDialog("Do you accept the kings quest?  [AcceptQuest|Accept Quest?]  [DeclineQuest|Decline Quest?]"));
		return sequence;
	}
	
	private ActionSequence getOpenBHomeDoor() {
		var sequence = new ActionSequence();
		sequence.add(new OpenFurniture(Bartholomew,BHome.getFurniture("Door")));
		return sequence;
	}
	
	private ActionSequence getExitBHome() {
		var sequence = new ActionSequence();
		sequence.add(new Exit(Bartholomew, BHome.getFurniture("Door"), true));
		return sequence;
	}
	
	private ActionSequence getEntercity() {
		var sequence = new ActionSequence();
		sequence.add(new Position(Bartholomew,city,"GreenHouseDoor"));
		return sequence;
	}
	
	private ActionSequence getTalkToKnight() {
		var sequence = new ActionSequence();
		sequence.add(new ShowDialog());
		sequence.add(new SetRight(knight));
		//sequence.add(new Wait(5));
		return sequence;
	}
	
	
	private ActionSequence getEnterPrison() {
		var sequence = new ActionSequence();
		sequence.add(new HideDialog());
		sequence.combineWith(new CharacterCreation(kingBoone));
		sequence.add(new Create<Place>(kingsDungeon));
		sequence.add(new SetDialog("Do you accept my quest? [AcceptQuest|Accept Quest?] [DeclineQuest|Decline Quest?]"));
		sequence.add(new Position(Bartholomew,kingsDungeon,"DirtPile"));
		sequence.add(new Position(kingBoone,kingsDungeon,"CellDoor"));
		return sequence;
	}
	
	private ActionSequence StayInPrison() {
		var sequence = new ActionSequence();
		sequence.add(new HideDialog());
		sequence.add(new SetDialog("Now do you accept my quest? [AcceptQuest|Accept Quest?][DeclineQuest|Decline Quest?]"));
		sequence.add(new SetRight(kingBoone));
		return sequence;
	}
	
	
	private ActionSequence sleepInPrison() {
		var sequence = new ActionSequence();
		sequence.add(new Sleep(Bartholomew,kingsDungeon.getFurniture("Bed")));
		sequence.add(new SetDialog("Now do you accept my quest? [AcceptQuest|Accept Quest?][DeclineQuest|Decline Quest?]"));
		return sequence;
	}
	
	private ActionSequence getTalkToKing() {
		var sequence = new ActionSequence();
		sequence.add(new ShowDialog());
		sequence.add(new SetRight(kingBoone));
		//sequence.add(new Wait(10));
		return sequence;
	}
	
	private ActionSequence kingOpensDoor() {
		var sequence = new ActionSequence();
		sequence.add(new HideDialog());
		sequence.add(new SetDialog("You are free to begin my quest!"));
		sequence.add(new OpenFurniture(kingBoone, kingsDungeon.getFurniture("CellDoor")));
		sequence.add(new ShowDialog());
		sequence.add(new Wait(3));
		sequence.add(new HideDialog());
		return sequence;
	}
	private ActionSequence getExitPrison() {
		var sequence = new ActionSequence();
		//sequence.add(new Exit(Bartholomew, kingsDungeon.getFurniture("Door"), true));
		sequence.add(new Create<Place>(city));
		sequence.combineWith(new CharacterCreation(knight));
		sequence.add(new Position(knight,city,"Fountain"));
		sequence.add(new Position(Bartholomew,city,"EastEnd"));
		//sequence.add(new SetDialog("Where do you want to go? [Library|Library][Tavern|Tavern][Ruins|Ruins]"));
		return sequence;
	}
	
	private ActionSequence getbartAcceptsQuest() {
		var sequence = new ActionSequence();
		sequence.add(new HideDialog());
		sequence.add(new SetDialog("Where do you want to begin your quest? [Library|Library?]  [Tavern|Tavern?] [Ruins|Ruins?]"));
		sequence.add(new ShowDialog());
		//sequence.add(new Wait(20));	
		return sequence;
	}
	// narration
	private ActionSequence getLibraryNarration() {
		var sequence = new ActionSequence();
		sequence.add(new HideDialog());
		sequence.add(new SetNarration("Go to the RedHouseDoor"));
		sequence.add(new ShowNarration());
		sequence.add(new Wait(3));
		sequence.add(new HideNarration());
		return sequence;
	}
	
	private ActionSequence getRuinsNarration() {
		var sequence = new ActionSequence();
		sequence.add(new HideDialog());
		sequence.add(new SetNarration("Go to the WestEnd"));	
		sequence.add(new ShowNarration());
		sequence.add(new Wait(3));
		sequence.add(new HideNarration());
		return sequence;
	}
	
	private ActionSequence getRuinsNarrationfromTavern() {
		var sequence = new ActionSequence();
		sequence.add(new SetNarration("Go to the WestEnd"));	
		sequence.add(new ShowNarration());
		sequence.add(new Wait(3));
		sequence.add(new HideNarration());
		return sequence;
	}
	private ActionSequence getTavernNarration() {
		var sequence = new ActionSequence();
		sequence.add(new HideDialog());
		sequence.add(new SetNarration("Go to the BlueHouseDoor"));
		sequence.add(new ShowNarration());
		sequence.add(new Wait(3));
		sequence.add(new HideNarration());
		return sequence;
	}
	//
	// Library Nodes
	private ActionSequence getEnterLibrary() {
		var sequence = new ActionSequence();
		sequence.combineWith(new CharacterCreation(DrAliReza));
		sequence.add(new Create<Place>(library));
		sequence.add(new Position(DrAliReza,library,"Stand"));
		sequence.add(new Position(Bartholomew,library,"Door"));
		return sequence;
	}
	
	private ActionSequence getTalkLibrarian() {
		var sequence = new ActionSequence();
		sequence.add(new SetDialog("Good Morning Professor! How are you?")); 
		sequence.add(new ShowDialog());
		sequence.add(new SetRight(Bartholomew));
		sequence.add(new Wait(3));
		sequence.add(new HideDialog());
		
		
		sequence.add(new SetDialog("I am doing good Bartholomew. How can I help you?"));
		sequence.add(new ShowDialog());
		sequence.add(new SetRight(DrAliReza));
		sequence.add(new Wait(3));
		sequence.add(new HideDialog());
		
		
		sequence.add(new SetDialog("I am looking for the Kings's lost jewel key. Can I look around here to see if I can find it")); 
		sequence.add(new ShowDialog());
		sequence.add(new SetRight(Bartholomew));
		sequence.add(new Wait(3));
		sequence.add(new HideDialog());
		
		
		sequence.add(new SetDialog("Sure!"));
		sequence.add(new ShowDialog());
		sequence.add(new SetRight(DrAliReza));
		sequence.add(new Wait(3));
		sequence.add(new HideDialog());
		return sequence;
	}
	
	private ActionSequence getgoToDesk() {
		var sequence = new ActionSequence();
		sequence.add(new SetDialog("Wow, what a pretty flower! It doesn't look like the key is here."));
		sequence.add(new ShowDialog());
		sequence.add(new Wait(5));
		sequence.add(new HideDialog());
		return sequence;
	}
	
	private ActionSequence getgoToBookshelf4() {
		var sequence = new ActionSequence();
		sequence.add(new SetDialog("So many books! After this quest I'll have to read some. It doesn't look like"
				+ "the key is here."));
		sequence.add(new ShowDialog());
		sequence.add(new SetRight(Bartholomew));
		sequence.add(new Wait(5));
		sequence.add(new HideDialog());
		return sequence;
	}
	private ActionSequence gettalkToLibrarian2() {
		var sequence = new ActionSequence();
		sequence.add(new SetDialog("Thank you Professor! It looks like the key isn't here! See you later!")); 
		sequence.add(new ShowDialog());
		sequence.add(new SetRight(Bartholomew));
		sequence.add(new Wait(5));
		sequence.add(new HideDialog());
		
		
		
		sequence.add(new SetDialog("See you soon!"));
		sequence.add(new ShowDialog());
		sequence.add(new SetRight(DrAliReza));
		sequence.add(new Wait(5));
		sequence.add(new HideDialog());
		return sequence;
	}
	private ActionSequence getExitLibrary() {
		var sequence = new ActionSequence();
		sequence.add(new Exit(Bartholomew, library.getFurniture("Door"), true));
		sequence.add(new Position(Bartholomew,city,"RedHouseDoor"));
		return sequence;
	}
	private ActionSequence getKnightDialogueFromLibrary() {
		var sequence = new ActionSequence();
		sequence.add(new SetDialog("Where do you want to go to next?[Tavern|Tavern] [Ruins|Ruins]"));
		sequence.add(new ShowDialog());
		sequence.add(new SetRight(knight));
		
		return sequence;
	}
	
	private ActionSequence getEntertavern() {
		var sequence = new ActionSequence();
		sequence.add(new Create<Place>(tavern));
		sequence.combineWith(new CharacterCreation(bartenderMilina));
		sequence.add(new Position(bartenderMilina,tavern,"Bar.Behind"));
		sequence.combineWith(new CharacterCreation(patronRandy));
		sequence.add(new Position(patronRandy, tavern, "Fireplace"));
		//sequence.add(new Position(cupOfBeer,tavern,"Bar"));
		sequence.add(new Enter(Bartholomew,city.getFurniture("BlueHouseDoor"),true));
		sequence.add(new Position(Bartholomew,tavern, "Door"));
		sequence.add(new SetCameraFocus(Bartholomew));
		return sequence;
	}
	
	private ActionSequence getTalkToBartender() {
		var sequence = new ActionSequence();
		
		sequence.add(new SetDialog("Hey Milena, how are you?"));	
		sequence.add(new ShowDialog());
		sequence.add(new SetRight(Bartholomew));
		sequence.add(new Wait(5));
		sequence.add(new HideDialog());
		
		sequence.add(new SetDialog("Hey Bartholomew! I'm doing good, just preparing for the dinner rush. What can I do for you today?"));
		sequence.add(new ShowDialog());
		sequence.add(new SetRight(bartenderMilina));
		sequence.add(new Wait(5));
		sequence.add(new HideDialog());
		
		sequence.add(new SetDialog("I'm looking for the king's jewel key, have you heard anything?"));	
		sequence.add(new ShowDialog());
		sequence.add(new SetRight(Bartholomew));
		sequence.add(new Wait(5));
		sequence.add(new HideDialog());
		
		sequence.add(new SetDialog("Hey... you didn't hear this from me but Randy over there may know something. I'd ask him."));
		sequence.add(new ShowDialog());
		sequence.add(new SetRight(bartenderMilina));
		sequence.add(new Wait(5));
		sequence.add(new HideDialog());
		
		sequence.add(new SetDialog("Thanks! Will do! Save a beer for me, will you?"));	
		sequence.add(new ShowDialog());
		sequence.add(new SetRight(Bartholomew));
		sequence.add(new Wait(5));
		sequence.add(new HideDialog());
		
		sequence.add(new SetDialog("Sure thing!"));
		sequence.add(new ShowDialog());
		sequence.add(new SetRight(bartenderMilina));
		sequence.add(new Wait(5));
		sequence.add(new HideDialog());
		return sequence;
	}
	private ActionSequence gettalkWithPatron() {
		var sequence = new ActionSequence();
		
		sequence.add(new SetDialog("Hey Randy, your just the man I wanted to see."));	
		sequence.add(new ShowDialog());
		sequence.add(new SetRight(Bartholomew));
		sequence.add(new Wait(5));
		sequence.add(new HideDialog());
		
		sequence.add(new SetDialog("And why is that?"));
		sequence.add(new ShowDialog());
		sequence.add(new SetRight(patronRandy));
		sequence.add(new Wait(5));
		sequence.add(new HideDialog());
		
		sequence.add(new SetDialog("Someone told me that you knew who took the king's jewel key"));	
		sequence.add(new ShowDialog());
		sequence.add(new SetRight(Bartholomew));
		sequence.add(new Wait(5));
		sequence.add(new HideDialog());
		
		sequence.add(new SetDialog("I don't know what your talking about but you should get out of here!"));	
		sequence.add(new ShowDialog());
		sequence.add(new SetRight(patronRandy));
		sequence.add(new Wait(5));
		sequence.add(new HideDialog());
		
		sequence.add(new SetDialog("Look... I'm just doing my job. I wonder what your Majesty would think if he knew that you knew where his jewel key was?"));	
		sequence.add(new ShowDialog());
		sequence.add(new SetRight(Bartholomew));
		sequence.add(new Wait(5));
		sequence.add(new HideDialog());
		
		sequence.add(new SetDialog("Woah man.. chill. All I know is that some bandit who goes by the name of Caspera was acting very suspicious last night. Please don't tell the king!"));
		sequence.add(new ShowDialog());
		sequence.add(new SetRight(patronRandy));
		sequence.add(new Wait(5));
		sequence.add(new HideDialog());
		
		sequence.add(new SetDialog("I won't this time. Thanks for the heads up!"));
		sequence.add(new ShowDialog());
		sequence.add(new SetRight(Bartholomew));
		sequence.add(new Wait(5));
		sequence.add(new HideDialog());
		// removed from getLeaveTavern
		
		return sequence;
	}
	private ActionSequence getLeaveTavern() {
		var sequence = new ActionSequence();
		sequence.add(new Position(Bartholomew, city,"BlueHouseDoor"));
		//sequence.add(new Exit(Bartholomew,tavern.getFurniture("Door"),true))
		return sequence;
	}
	
	private ActionSequence getEnterRuins() {
		var sequence = new ActionSequence();
		sequence.add(new Create<Place>(ruins));
		sequence.combineWith(new CharacterCreation(banditCaspera));
		sequence.add(new Position(banditCaspera,ruins,"Chest"));
		sequence.add(new Position(Bartholomew,ruins, "Exit"));
		return sequence;
	}
	private ActionSequence getwalkToPlant() {
		var sequence = new ActionSequence();
		
		sequence.add(new SetDialog("I wonder where this Caspera is? I don't see her over here by this pretty plant"));
		sequence.add(new ShowDialog());
		sequence.add(new SetRight(Bartholomew));
		sequence.add(new Wait(3));
		sequence.add(new HideDialog());
		return sequence;
		
	}
	
	private ActionSequence getTalkToBandit() {
		var sequence = new ActionSequence();
		sequence.add(new Position(knight,ruins,"DirtPile"));
		
		
		sequence.add(new SetDialog("Stop Caspera you are under arrest. Where is the jewel key?"));
		sequence.add(new ShowDialog()); 
		sequence.add(new SetRight(Bartholomew));
		sequence.add(new Wait(3));
		sequence.add(new HideDialog());
		
		
		sequence.add(new SetDialog("Uhhgh... you caught me! How! I thought if I hid it in this chest, that you'll never find it"));
		sequence.add(new ShowDialog()); 
		sequence.add(new SetRight(banditCaspera));
		sequence.add(new Wait(3));
		sequence.add(new HideDialog());
		
		
		sequence.add(new SetDialog("Well you thought wrong, knight arrest her immediately!"));
		sequence.add(new ShowDialog()); 
		sequence.add(new SetRight(Bartholomew));
		sequence.add(new Wait(3));
		sequence.add(new HideDialog());
		return sequence;
	}
	private ActionSequence getKnightArrestsBandit() {
		var sequence = new ActionSequence();
		sequence.add(new SetCameraFocus(knight));
		sequence.add(new SetDialog("You're under arrest!"));
		sequence.add(new ShowDialog()); 
		sequence.add(new SetRight(knight));
		sequence.add(new Wait(3));
		sequence.add(new HideDialog());
		
		sequence.add(new SetCameraFocus(Bartholomew));
		sequence.add(new Laugh(Bartholomew));
		sequence.add(new Position(banditCaspera)); // bandit diassapears
		sequence.add(new Position(knight));// knight dissapears
		sequence.add(new SetNarration("Go to the chest to collect the jewel key"));
		sequence.add(new ShowNarration());
		sequence.add(new Wait(3));
		sequence.add(new HideNarration());
		
		return sequence;
	}
	
	private ActionSequence getJewelKey() {
		var sequence = new ActionSequence();
		sequence.add(new OpenFurniture(Bartholomew, ruins.getFurniture("Chest")));
		// need pocket & add create jewel key
		sequence.add(new SetNarration("You found the kings jewel key! Return it to him!"));
		sequence.add(new ShowNarration());
		sequence.add(new Wait(3));
		sequence.add(new HideNarration());
		return sequence;
	}
	

	
	private ActionSequence getExitRuins() {
		var sequence = new ActionSequence();
		sequence.combineWith(new CharacterCreation(kingBoone));
		sequence.add(new Create<Place>(greatHall));
		sequence.add(new Position(kingBoone,greatHall,"Throne"));
		sequence.add(new Position(Bartholomew,city,"WestEnd"));
		sequence.add(new SetNarration("Go to the East End "));
		sequence.add(new ShowNarration());
		sequence.add(new Wait(3));
		sequence.add(new HideNarration());
		return sequence;
	}
	
	private ActionSequence getEnterPalace() {
		var sequence = new ActionSequence();
		sequence.add(new Position(Bartholomew,greatHall,"Gate"));
		return sequence;
	}
	private ActionSequence talkToKing() {
		var sequence = new ActionSequence();
		sequence.add(new SetDialog("Thank you so much Bartholomew for finding my jewel key! How can I repay you?"));
		sequence.add(new ShowDialog());
		sequence.add(new SetRight(kingBoone));
		sequence.add(new Wait(3));
		sequence.add(new HideDialog());
		
		sequence.add(new SetDialog("It was an honor my king! Could you tell me what does jewel key open? "));
		sequence.add(new ShowDialog()); 
		sequence.add(new SetRight(Bartholomew));
		sequence.add(new Wait(3));
		sequence.add(new HideDialog());
		
		sequence.add(new SetDialog("Well.. no.. a new home would have to suffice"));
		sequence.add(new ShowDialog());
		sequence.add(new SetRight(kingBoone));
		sequence.add(new Wait(3));
		sequence.add(new HideDialog());
		
		sequence.add(new SetCredits("Congratulations! You Win! Game Designers: Miles & Nina"));
		sequence.add(new ShowCredits());
		sequence.add(new Wait(10));
		sequence.add(new ShowMenu(true));
		return sequence;
	}
	
}
