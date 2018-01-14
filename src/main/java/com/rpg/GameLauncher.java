package com.rpg;

import java.util.Random;

import com.rpg.constants.CommonConstants;
import com.rpg.constants.ErrorMessages;
import com.rpg.launcher.BattleLauncher;
import com.rpg.launcher.IntroLauncher;
import com.rpg.launcher.InventoryLauncher;
import com.rpg.launcher.SaveLauncher;
import com.rpg.model.AvengersGame;
import com.rpg.model.Game;
import com.rpg.model.RPGPlayerProfile;
import com.rpg.util.CommonUtil;
import com.rpg.util.ScannerUtil;

/**
 * @author Shaik Fareed
 *
 */
public class GameLauncher {
	public static Random generator = new Random();
	
	public static RPGPlayerProfile rpgPlayerProfile;
	
	public static int room;
	static int playerClass;

	
	public static void main(String[] args) {

		// Variable we'll call to generate
		// random numbers.
		
		IntroLauncher.commonIntro();
		
		//Choose the game
		chooseGame();
		
		//Its time to choose your role
		chooseYourRole();

		rpgPlayerProfile.statRead();

		CommonUtil.slowPrint(rpgPlayerProfile.getGameChosen().getMessage1());

		CommonUtil.slowPrint("Ananymous : Greetings Mr:"+rpgPlayerProfile.getRole());
		
		CommonUtil.slowPrint("Ananymous : "+rpgPlayerProfile.getGameChosen().getMessage2());
		
		System.out.println("Ananymous: So will you accept??[Y/N]");
		
		String accept=ScannerUtil.stringInput();

		
		
		
		if ("Y".equalsIgnoreCase(accept)) {

			System.out.println("Ananymous: Thank you so much! What is your real name though great "
							+ rpgPlayerProfile.getRole() + "?");
			
			String hero = ScannerUtil.stringInput();

			rpgPlayerProfile.setPlayerName(hero);
			
			CommonUtil.slowPrint(hero
					+ "? That's a great name! Come i will help equip you for your Battle!.Lets go to a seller");
			
			CommonUtil.slowPrint("Ananymous: But before we go ther take 20 Coins... You might need them...");
			
			InventoryLauncher.purchase(rpgPlayerProfile,rpgPlayerProfile.getInventory());
			
			CommonUtil.slowPrint("Ananymous: Oh! I forgot! I will take care of little enemies. Don't worry though they are weak. I'd watch out for them...");

			rpgPlayerProfile.setCash(rpgPlayerProfile.getCash() + 20);
			BattleLauncher.startBattle(rpgPlayerProfile);

		} else {

			CommonUtil.slowPrint("Ananymous: "+rpgPlayerProfile.getGameChosen().getMessage3());
		}
	}



	

	

	/**
	 * 
	 */
	private static void chooseGame() {
		//System.out.println(CommonConstants.MESSAGE_CHOOSE_GAME);
		int gameChosen = 1; 
		
		Game game = null;
		
		switch(gameChosen){
			case 1: 
				game = new AvengersGame();
				break;
			case 2:
				//game = new PokemonGame();
				break;
			default:
				chooseGame();
		}
		
		rpgPlayerProfile = SaveLauncher.startNewOrLoadGame();
		
		if(rpgPlayerProfile.getLevel()>0){
			System.out.println("Loading game.....");
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			BattleLauncher.startBattle(rpgPlayerProfile);
		}
		
		rpgPlayerProfile.setGameChosen(game);
	}





	/**
	 * 
	 */
	public static void chooseYourRole() {
		
		System.out.println("\n\n"+rpgPlayerProfile.getGameChosen().getChooseRoleMessage());
		
		try {
			playerClass = ScannerUtil.integerInput();
		} catch (NumberFormatException e) {
			CommonUtil.slowPrint(ErrorMessages.INVALID_ROLE);
			chooseYourRole();
		}

		switch (playerClass) {

		case 1:
			rpgPlayerProfile.setRole(rpgPlayerProfile.getGameChosen().getHeroes().get(0));
			rpgPlayerProfile.setItem1(1);
			rpgPlayerProfile.setItem2(generator.nextInt(1) + 4);
			rpgPlayerProfile.setItem3(generator.nextInt(1) + 3);
			rpgPlayerProfile.setItem4(generator.nextInt(20) + 20);
			rpgPlayerProfile.setItem5(generator.nextInt(2) + 1);
			break;
		case 2:
			rpgPlayerProfile.setRole(rpgPlayerProfile.getGameChosen().getHeroes().get(1));
			rpgPlayerProfile.setItem1(generator.nextInt(2) + 1);
			rpgPlayerProfile.setItem2(generator.nextInt(1) + 3);
			rpgPlayerProfile.setItem3(generator.nextInt(1) + 2);
			rpgPlayerProfile.setItem4(generator.nextInt(20) + 30);
			rpgPlayerProfile.setItem5(generator.nextInt(2) + 4);
			break;
		case 3:
			rpgPlayerProfile.setRole(rpgPlayerProfile.getGameChosen().getHeroes().get(2));
			rpgPlayerProfile.setItem1(generator.nextInt(1) + 3);
			rpgPlayerProfile.setItem2(generator.nextInt(1) + 3);
			rpgPlayerProfile.setItem3(generator.nextInt(1) + 4);
			rpgPlayerProfile.setItem4(generator.nextInt(20) + 20);
			rpgPlayerProfile.setItem5(generator.nextInt(2) + 2);
			break;
		case 4:
			createCharacter();
			rpgPlayerProfile.setItem1(generator.nextInt(1) + 2);
			rpgPlayerProfile.setItem2(generator.nextInt(1) + 4);
			rpgPlayerProfile.setItem3(generator.nextInt(1) + 5);
			rpgPlayerProfile.setItem4(generator.nextInt(20) + 30);
			rpgPlayerProfile.setItem5(generator.nextInt(2) + 2);
			break;
		default:

			chooseYourRole();

		}

	}

	/**
	 * 
	 */
	public static void createCharacter() {
		System.out.println(CommonConstants.CREATE_CHARACTER_MESSAGE);
		
		String characterName = ScannerUtil.stringInput();
		System.out.println("You choose role :"+characterName);
		rpgPlayerProfile.setRole(characterName);
	}	
}
