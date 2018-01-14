package com.rpg.launcher;

import java.util.Random;

import com.rpg.model.RPGPlayerProfile;
import com.rpg.util.CommonUtil;
import com.rpg.util.ScannerUtil;

/**
 * @author Shaik Fareed
 *
 */
public class ExplorerLauncher {
	
	
	public static Random generator = new Random();

	/**
	 * 
	 */
	public static void exploreRoom(RPGPlayerProfile rpgPlayerProfile) {
		int rand = generator.nextInt(100);
		CommonUtil.slowPrint("You explore the room.");
		System.out.println(rand);
		if (rand == 0) {
			System.out.println("You find a mysterious looking box possibly filled with Coins. Open?[Y/N]");
			String open = ScannerUtil.stringInput();
			if ("y".equalsIgnoreCase(open)) {
				if (generator.nextInt(100) >= 50) {
					CommonUtil.slowPrint("The chest was filled harmful chemical that will infect you.");
					rpgPlayerProfile.setItem4(0);
				} else {
					CommonUtil.slowPrint("You find a load of 1000 Coins!!");
					rpgPlayerProfile.setCash(rpgPlayerProfile.getCash() + 1000);
				}
			}
		} else if (rand <= 50) {
			CommonUtil.slowPrint("You encounter an enemy!");
			if (BattleLauncher.doBattle((rpgPlayerProfile.getLevel() + 2) * 10,
					(rpgPlayerProfile.getLevel() + 2) * 2, (rpgPlayerProfile.getLevel() + 2) * 2,rpgPlayerProfile)) {
				CommonUtil.slowPrint("You won the battle!");
			}
		} else if (rand == 99) {
			System.out.println("You find a mysterious looking bowl of kheer. Investigate?");
			int guac = ScannerUtil.integerInput();
			if (guac == 0) {
				CommonUtil.slowPrint("You take a bite of the kheer and find a key upon your chip!\n Also, you feel quite rejuvinated...");
				rpgPlayerProfile.setItem4( rpgPlayerProfile.getItem4() + 100);
				rpgPlayerProfile.getInventory().add("Key");
			} else {
				CommonUtil.slowPrint("You stay away from the kheer... \n You were always suspicous of kheer...");
			}
		} else if (rand > 85) {
			CommonUtil.slowPrint("You encounter a Mini Boss!");
			if (BattleLauncher.doBattle(rand, rand, rand,rpgPlayerProfile)) {
				CommonUtil.slowPrint("You beat a mini boss!");
			}

		} else {
			CommonUtil.slowPrint("You find nothing.");
		}
	}
	
}
