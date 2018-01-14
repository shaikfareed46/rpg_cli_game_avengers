package com.rpg.launcher;

import java.util.List;

import com.rpg.GameLauncher;
import com.rpg.constants.ErrorMessages;
import com.rpg.constants.InventoryConstants;
import com.rpg.model.RPGPlayerProfile;
import com.rpg.util.CommonUtil;
import com.rpg.util.ScannerUtil;

/**
 * @author Shaik Fareed
 *
 */
public class InventoryLauncher {
	
	public static void purchase(RPGPlayerProfile rpgPlayerProfile,List<String> inventory) {
		
		CommonUtil.slowPrint(rpgPlayerProfile.getGameChosen().getChooseItemMessage());
		int purchase=0;
		try {
			purchase = ScannerUtil.integerInput();
		} catch (NumberFormatException e) {
			CommonUtil.slowPrint(ErrorMessages.INVALID_OPTION);
			purchase(rpgPlayerProfile,inventory);
		}
		
		switch (purchase) {
		case 1:
			inventory.add(rpgPlayerProfile.getGameChosen().getItemsToChoose().get(0));
			// Set stats
			rpgPlayerProfile.setItem1( rpgPlayerProfile.getItem1() + 5);
			rpgPlayerProfile.setItem2( rpgPlayerProfile.getItem2() + 3);
			rpgPlayerProfile.setItem3( rpgPlayerProfile.getItem3() + 3);
			rpgPlayerProfile.setItem4( rpgPlayerProfile.getItem4() + 50);

			// Inventory UPDATE
			inventory.add(rpgPlayerProfile.getGameChosen().getItemsToChoose().get(3));
			inventory.add(rpgPlayerProfile.getGameChosen().getItemsToChoose().get(3));
			inventory.add(rpgPlayerProfile.getGameChosen().getItemsToChoose().get(4));
			break;
		case 2:
			inventory.add(rpgPlayerProfile.getGameChosen().getItemsToChoose().get(1));
			// Set stats
			rpgPlayerProfile.setItem1( rpgPlayerProfile.getItem1() + 4);
			rpgPlayerProfile.setItem2( rpgPlayerProfile.getItem2() + 1);
			rpgPlayerProfile.setItem3( rpgPlayerProfile.getItem3() + 2);
			rpgPlayerProfile.setItem4( rpgPlayerProfile.getItem4() + 20);
			rpgPlayerProfile.setItem5( rpgPlayerProfile.getItem5() + 1);

			inventory.add(rpgPlayerProfile.getGameChosen().getItemsToChoose().get(4));
			inventory.add(rpgPlayerProfile.getGameChosen().getItemsToChoose().get(4));
			inventory.add(rpgPlayerProfile.getGameChosen().getItemsToChoose().get(4));
			inventory.add(rpgPlayerProfile.getGameChosen().getItemsToChoose().get(3));
			inventory.add(rpgPlayerProfile.getGameChosen().getItemsToChoose().get(3));
			inventory.add(rpgPlayerProfile.getGameChosen().getItemsToChoose().get(3));
			inventory.add(rpgPlayerProfile.getGameChosen().getItemsToChoose().get(5));
			inventory.add(rpgPlayerProfile.getGameChosen().getItemsToChoose().get(5));
			inventory.add(rpgPlayerProfile.getGameChosen().getItemsToChoose().get(5));
			inventory.add(rpgPlayerProfile.getGameChosen().getItemsToChoose().get(6));
			inventory.add(rpgPlayerProfile.getGameChosen().getItemsToChoose().get(7));

			break;
		case 3:
			inventory.add(rpgPlayerProfile.getGameChosen().getItemsToChoose().get(2));

			// Set stats

			rpgPlayerProfile.setItem1( rpgPlayerProfile.getItem1() + 3);
			rpgPlayerProfile.setItem2( rpgPlayerProfile.getItem2() + 1);
			rpgPlayerProfile.setItem3( rpgPlayerProfile.getItem3() + 1);
			rpgPlayerProfile.setItem4( rpgPlayerProfile.getItem4() + 10);

			inventory.add(rpgPlayerProfile.getGameChosen().getItemsToChoose().get(4));
			inventory.add(rpgPlayerProfile.getGameChosen().getItemsToChoose().get(4));
			inventory.add(rpgPlayerProfile.getGameChosen().getItemsToChoose().get(4));
			inventory.add(rpgPlayerProfile.getGameChosen().getItemsToChoose().get(4));
			inventory.add(rpgPlayerProfile.getGameChosen().getItemsToChoose().get(5));
			inventory.add(rpgPlayerProfile.getGameChosen().getItemsToChoose().get(5));
			inventory.add(rpgPlayerProfile.getGameChosen().getItemsToChoose().get(5));
			inventory.add(rpgPlayerProfile.getGameChosen().getItemsToChoose().get(6));
			inventory.add(rpgPlayerProfile.getGameChosen().getItemsToChoose().get(6));
			inventory.add(rpgPlayerProfile.getGameChosen().getItemsToChoose().get(7));
			inventory.add(rpgPlayerProfile.getGameChosen().getItemsToChoose().get(3));
			inventory.add(rpgPlayerProfile.getGameChosen().getItemsToChoose().get(3));
			inventory.add(rpgPlayerProfile.getGameChosen().getItemsToChoose().get(8));

			break;

		default: System.out.println("");
			
		}
	
	
	}

	public static void chooseItem(RPGPlayerProfile rpgPlayerProfile) {
		
		CommonUtil.slowPrint(InventoryConstants.SELLER_MESSAGE);
		System.out.println("\n <1> "+rpgPlayerProfile.getGameChosen().getItemsToChoose().get(4)+" - 10 Coins"
									+ "\n <2> "+rpgPlayerProfile.getGameChosen().getItemsToChoose().get(3)+" - 20 Coins"
									+ "\n <3> "+rpgPlayerProfile.getGameChosen().getItemsToChoose().get(5)+" - 30 Coins"
									+ "\n <4> "+rpgPlayerProfile.getGameChosen().getItemsToChoose().get(6)+" - 15 Coins"
									+ "\n \n Coins: " + rpgPlayerProfile.getCash()
									+ "\n <5> Nothing Thanks!");
		int buy=0;
		try {
			buy = ScannerUtil.integerInput();
		} catch (NumberFormatException e) {
			CommonUtil.slowPrint(ErrorMessages.INVALID_OPTION);
			chooseItem(rpgPlayerProfile);
		}
	
		switch(buy) {
		case 1:
			if(rpgPlayerProfile.getCash()>= 10) {
				rpgPlayerProfile.getInventory().add(rpgPlayerProfile.getGameChosen().getItemsToChoose().get(4));
				rpgPlayerProfile.setCash(rpgPlayerProfile.getCash() - 10);
			} else {
				CommonUtil.slowPrint(ErrorMessages.NO_SUFFICIENT_AMOUNT);
			}
			break;
		case 3:
			if(rpgPlayerProfile.getCash()>= 30) {
				rpgPlayerProfile.getInventory().add(rpgPlayerProfile.getGameChosen().getItemsToChoose().get(5));
				rpgPlayerProfile.setCash(rpgPlayerProfile.getCash() - 30);
			} else {
				CommonUtil.slowPrint(ErrorMessages.NO_SUFFICIENT_AMOUNT);
			}
			break;
		case 2:
			if(rpgPlayerProfile.getCash()>= 20) {
				rpgPlayerProfile.getInventory().add(rpgPlayerProfile.getGameChosen().getItemsToChoose().get(3));
				rpgPlayerProfile.setCash(rpgPlayerProfile.getCash() - 20);
			} else {
				CommonUtil.slowPrint(ErrorMessages.NO_SUFFICIENT_AMOUNT);
			}
			break;
		case 4:
			if(rpgPlayerProfile.getCash()>= 15) {
				rpgPlayerProfile.getInventory().add(rpgPlayerProfile.getGameChosen().getItemsToChoose().get(6));
				rpgPlayerProfile.setCash(rpgPlayerProfile.getCash() - 15);
			} else {
				CommonUtil.slowPrint(ErrorMessages.NO_SUFFICIENT_AMOUNT);
			}
			break;
		default:
			CommonUtil.slowPrint(InventoryConstants.MERCHANT_MESSAGE);
	
	
		}
	
	}

	// Ask Inventory - Return Inventroy item number
	public static int InvenAsk(RPGPlayerProfile rpgPlayerProfile) {
		String list = "";
	
		for (int i = 0; i < rpgPlayerProfile.getInventory().size(); i++) {
			list = list + "\n <" + (i+1) + "> " + rpgPlayerProfile.getInventory().get(i);
		}
	
		System.out.println("Select an item: \n" + list);
		
		int invenOption;
		try {
			invenOption = ScannerUtil.integerInput();
		} catch (NumberFormatException e) {
			invenOption = 1;
			CommonUtil.slowPrint("That's not a valid item. Defaulted to item 1.");
		}
		return invenOption-1;
	}

	// Display box that had inventory
	public static void invenRead(RPGPlayerProfile rpgPlayerProfile) {
		String list;
		list = rpgPlayerProfile.getInventory().get(0);
	
		for (int i = 1; i < rpgPlayerProfile.getInventory().size(); i++) {
			list = list + "\n" + rpgPlayerProfile.getInventory().get(i);
		}
	
		CommonUtil.slowPrint("--Inventory-- \n" + list + "\nCoins: " + rpgPlayerProfile.getCash());
	
	}

	public static int mainOpt() {
		int mainOption;
		System.out.println("You arriave in room"
									+ GameLauncher.room
									+ ":"
									+ "\n <1> Look around"
									+ "\n <2> Talk to the Shady Dealer in the corner"
									+ "\n <3> Inventory"
									+ "\n <4> Stats"
									+ "\n <5> Next Room"
									+ "\n <6> Use Item");
	
		try {
			mainOption = ScannerUtil.integerInput();
		} catch (NumberFormatException e) {
			CommonUtil.slowPrint("That was not a valid option.");
			mainOption = mainOpt();
		}
		
		return mainOption;
	}

}
