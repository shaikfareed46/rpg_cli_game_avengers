package com.rpg.launcher;

import java.io.IOException;
import java.util.Random;

import com.rpg.GameLauncher;
import com.rpg.constants.CommonConstants;
import com.rpg.model.RPGPlayerProfile;
import com.rpg.util.CommonUtil;
import com.rpg.util.ScannerUtil;

/**
 * @author Shaik Fareed
 *
 */
public class BattleLauncher {
	
	public static Random generator = new Random();
	
	
	/**
	 * 
	 */
	public static void startBattle(RPGPlayerProfile rpgPlayerProfile) {
		boolean explored = false;
		GameLauncher.room = 1;

		do {

			if (rpgPlayerProfile.getXp()== rpgPlayerProfile.getLevel() * 100) {
				CommonUtil.slowPrint("You are ready to start... FIGHT!!");
				if (BattleLauncher.doBattle((rpgPlayerProfile.getXp()+ 1) * 10, (rpgPlayerProfile.getXp()+ 1), (rpgPlayerProfile.getXp()+ 1),rpgPlayerProfile)) {
					CommonUtil.slowPrint("You beat a boss and level up!");
					rpgPlayerProfile.setLevel(rpgPlayerProfile.getLevel()+1);
					rpgPlayerProfile.setItem1( rpgPlayerProfile.getItem1() + rpgPlayerProfile.getLevel());
					rpgPlayerProfile.setItem2( rpgPlayerProfile.getItem2() + rpgPlayerProfile.getLevel());
					rpgPlayerProfile.setItem3( rpgPlayerProfile.getItem3() + rpgPlayerProfile.getLevel());
					rpgPlayerProfile.setItem4( rpgPlayerProfile.getItem4() + rpgPlayerProfile.getLevel());
					rpgPlayerProfile.setItem5( rpgPlayerProfile.getItem5() + rpgPlayerProfile.getLevel());
					rpgPlayerProfile.setXp( 0);
					rpgPlayerProfile.statRead();
					
					System.out.println("\n\nYou are doing good job..... Do you want to save the current game?[Y/N]");
					String response = ScannerUtil.stringInput();
					if("Y".equalsIgnoreCase(response)){
						try {
							SaveLauncher.saveGame(rpgPlayerProfile);
						} catch (IOException e) {
							e.printStackTrace();
							System.out.println("Oops problem occured while saving the file....");
						}
					}else{
						
					}
				}
			} else {

				int mainOption =InventoryLauncher.mainOpt();

				switch (mainOption) {

				case 1:

					System.out.println(!explored);
					if (!explored) {
						explored = true;
						ExplorerLauncher.exploreRoom(rpgPlayerProfile);

					} else {
						CommonUtil.slowPrint("You already saw what was in this room.");
					}
					break;
				case 2:
					InventoryLauncher.chooseItem(rpgPlayerProfile);
					break;
				case 3:
					InventoryLauncher.invenRead(rpgPlayerProfile);
					break;
				case 4:
					rpgPlayerProfile.statRead();
					break;
				case 5:
					explored = false;
					GameLauncher.room++;
					break;
				case 6:
					int selectItem = InventoryLauncher.InvenAsk(rpgPlayerProfile);

					if (rpgPlayerProfile.getInventory().get(selectItem).equals(rpgPlayerProfile.getGameChosen().getItemsToChoose().get(4))) {
						rpgPlayerProfile.setItem4( rpgPlayerProfile.getItem4()+ 15);
						CommonUtil.slowPrint("You used a "+rpgPlayerProfile.getGameChosen().getItemsToChoose().get(4)+" and repaired your "+rpgPlayerProfile.getGameChosen().getItem4Description()+" by 15.");
						rpgPlayerProfile.getInventory().remove(selectItem);
					} else {
						CommonUtil.slowPrint("Not a valid item.");
					}
					break;
				default:

				}
			}

		} while (rpgPlayerProfile.getItem4() > 0);

		CommonUtil.slowPrint(CommonConstants.ASCI_RED+"You died....");
	}
	

	
	/**
	 * @param sentPower
	 * @param sentAttack
	 * @param sentDefense
	 * @param rpgPlayerProfile
	 * @return
	 */
	public static boolean doBattle(int sentPower, int sentAttack,
			int sentDefense,RPGPlayerProfile rpgPlayerProfile) {
		int enemyPower = sentPower + generator.nextInt(1) + rpgPlayerProfile.getLevel();
		int enemyAttack = sentAttack + generator.nextInt(1) + rpgPlayerProfile.getLevel();
		int enemyDefense = sentDefense + generator.nextInt(1) + rpgPlayerProfile.getLevel();
	
		int myDefense = rpgPlayerProfile.getItem1();
	
		int movesLearnt = 0;
		int attack = 0;
	
		while (rpgPlayerProfile.getItem4() > 0 && enemyPower > 0) {
			int action;
			
			System.out.println("Action: \n"
								+ "<1> Attack. \n"
								+ "<2> Use power. \n"
								+ "<3> Dodge and defend. \n"
								+ "<4> Cure self \n" + "<5> Use Item \n"
								+ "\n "+rpgPlayerProfile.getGameChosen().getItem4Description()+": " + rpgPlayerProfile.getItem4()
								+ "\n  Defense: " + myDefense + "\n Enemy HP: "
								+ enemyPower + "\n Enemy Attack: " + enemyAttack
								+ "\n Enemy Defense: " + enemyDefense
								+ "\n Moves made: " + movesLearnt
								+ "\n Attacks made: " 	+ attack
								+ "\n <6> See Full Stats");
	
			try {
				action = ScannerUtil.integerInput();
			} catch (NumberFormatException e) {
				action = 7;
				CommonUtil.slowPrint("You did not type in a valid number.");
			}
			switch (action) {
			case 1:
				if (movesLearnt > 0) {
					if (attack - enemyDefense > 0) {
						enemyPower = enemyPower - attack;
						movesLearnt--;
					} else {
						CommonUtil.slowPrint("You need to make use of power!");
						action = 7;
					}
				}
				break;
			case 2:
				movesLearnt++;
				if (attack > 0) {
					attack = rpgPlayerProfile.getItem2() + rpgPlayerProfile.getItem3() / 2;
					attack++;
	
				} else {
					attack = rpgPlayerProfile.getItem2() + rpgPlayerProfile.getItem3() / 2;
				}
				CommonUtil.slowPrint("You made harmful move.");
				break;
			case 3:
				myDefense = myDefense + (rpgPlayerProfile.getItem3() + rpgPlayerProfile.getItem1()) / 2;
				CommonUtil.slowPrint("Your defensive skill are improved!");
				break;
			case 4:
				rpgPlayerProfile.setItem4( rpgPlayerProfile.getItem5() / 2 + rpgPlayerProfile.getItem3() / 2);
				CommonUtil.slowPrint("Your health improved!");
				break;
			case 5:
				int selectItem = InventoryLauncher.InvenAsk(rpgPlayerProfile);
	
				if (rpgPlayerProfile.getInventory().get(selectItem).equals(rpgPlayerProfile.getGameChosen().getItemsToChoose().get(4))) {
					rpgPlayerProfile.setItem4( rpgPlayerProfile.getItem4()+ 15);
					rpgPlayerProfile.getInventory().remove(selectItem);
					CommonUtil.slowPrint("You used a "+rpgPlayerProfile.getInventory().get(selectItem)+" and repaired your "+rpgPlayerProfile.getGameChosen().getItem4Description()+" by 15.");
				} else if (rpgPlayerProfile.getInventory().get(selectItem).equals(rpgPlayerProfile.getGameChosen().getItemsToChoose().get(3))) {
					CommonUtil.slowPrint("You get to leave battle.");
					rpgPlayerProfile.getInventory().remove(selectItem);
					return true;
				} else if (rpgPlayerProfile.getInventory().get(selectItem).equals(rpgPlayerProfile.getGameChosen().getItemsToChoose().get(6))) {
					myDefense = myDefense + 5;
					rpgPlayerProfile.getInventory().remove(selectItem);
					CommonUtil.slowPrint("You increased your defense by 5.");
				} else if (rpgPlayerProfile.getInventory().get(selectItem).equals(rpgPlayerProfile.getGameChosen().getItemsToChoose().get(5))) {
					attack = attack + 3;
					movesLearnt = movesLearnt + 2;
					rpgPlayerProfile.getInventory().remove(selectItem);
					CommonUtil.slowPrint("Your harmful move got more powerful and your moves and attacks increase by 2 or 3!");
				} else if(selectItem>rpgPlayerProfile.getInventory().size()){
					action = 7;
	
					CommonUtil.slowPrint("Not a valid item.");
				}
				break;
			case 6:
				rpgPlayerProfile.statRead();
				break;
			default:
	
			}
	
			if (action != 6 || action != 7) {
				if(enemyAttack > myDefense) {
					rpgPlayerProfile.setItem4( rpgPlayerProfile.getItem4()- (enemyAttack - myDefense));
					CommonUtil.slowPrint("Enemy attacks for " + (enemyAttack - myDefense));
				} else {
					rpgPlayerProfile.setItem4( rpgPlayerProfile.getItem4()- enemyAttack);
					CommonUtil.slowPrint("Enemy attacks for " + (enemyAttack));
				}
	
				enemyAttack++;
	
			}
	
		}
	
		if (rpgPlayerProfile.getItem4() <= 0) {
			return false;
		} else {
			CommonUtil.slowPrint("You got " + sentPower / 2 + " cash." + "\n " + sentPower + " XP.");
			rpgPlayerProfile.setCash(rpgPlayerProfile.getCash() + sentPower / 2);
			rpgPlayerProfile.setXp(rpgPlayerProfile.getXp()+ sentPower);
			return true;
	
		}
	}

}
