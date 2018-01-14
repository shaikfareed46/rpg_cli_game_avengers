package com.rpg.launcher;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;

import com.rpg.model.AvengersGame;
import com.rpg.model.RPGPlayerProfile;
import com.rpg.util.ScannerUtil;

public class InventoryLauncherTest {

	@Test
	public void testPurchase_select_Mind_stones() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException{

		RPGPlayerProfile rpgPlayerProfile = new RPGPlayerProfile();


		List<String> inventory = new ArrayList<>();

		rpgPlayerProfile.setGameChosen(new AvengersGame());
		rpgPlayerProfile.setCash(10);
		rpgPlayerProfile.setInventory(inventory);
		rpgPlayerProfile.setItem1(4);
		rpgPlayerProfile.setItem2(5);
		rpgPlayerProfile.setItem3(3);
		rpgPlayerProfile.setItem4(45);
		rpgPlayerProfile.setItem5(3);

		//Mock the inputstream
		
		String input = "3";
		InputStream in = new ByteArrayInputStream(input.getBytes());

        Field f1 = ScannerUtil.class.getDeclaredField("scanner");
        f1.setAccessible(true);
        f1.set(null, new Scanner(in));


		InventoryLauncher.purchase(rpgPlayerProfile, inventory);

		assertEquals(rpgPlayerProfile.getInventory().size(),14);
		assertEquals(rpgPlayerProfile.getInventory().get(0),"Mind stone");
		assertEquals(rpgPlayerProfile.getInventory().get(1),"Scepter");
	}

	@Test
	public void testChooseItem() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException{

		RPGPlayerProfile rpgPlayerProfile = new RPGPlayerProfile();


		List<String> inventory = new ArrayList<>();

		rpgPlayerProfile.setGameChosen(new AvengersGame());
		rpgPlayerProfile.setCash(40);
		rpgPlayerProfile.setInventory(inventory);
		rpgPlayerProfile.setItem1(4);
		rpgPlayerProfile.setItem2(5);
		rpgPlayerProfile.setItem3(3);
		rpgPlayerProfile.setItem4(45);
		rpgPlayerProfile.setItem5(3);

		
		//Mock the inputstream
		
		String input = "3";
		InputStream in = new ByteArrayInputStream(input.getBytes());

        Field f1 = ScannerUtil.class.getDeclaredField("scanner");
        f1.setAccessible(true);
        f1.set(null, new Scanner(in));


		InventoryLauncher.chooseItem(rpgPlayerProfile);

		assertEquals(rpgPlayerProfile.getCash(),10);
		assertEquals(rpgPlayerProfile.getInventory().get(0),"Chitauri Bomb");

	}


}
