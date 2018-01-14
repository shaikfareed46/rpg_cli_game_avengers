package com.rpg.launcher;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.junit.Test;

import com.rpg.model.AvengersGame;
import com.rpg.model.RPGPlayerProfile;
import com.rpg.util.ScannerUtil;

public class ExplorerLauncherTest {

	@Test
	public void exploreRoomTest() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{

		Random random = mock(Random.class);
		when(random.nextInt(100)).thenReturn(0,75);
		ExplorerLauncher.generator = random;

		//Mock the inputstream

		String input = "Y\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());

		Field f1 = ScannerUtil.class.getDeclaredField("scanner");
		f1.setAccessible(true);
		f1.set(null, new Scanner(in));

		
		
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

		ExplorerLauncher.exploreRoom(rpgPlayerProfile);
		
		assertEquals(0,rpgPlayerProfile.getItem4());

	}

	@Test
	public void exploreRoomTestCash() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{

		Random random = mock(Random.class);
		when(random.nextInt(100)).thenReturn(0,15);
		ExplorerLauncher.generator = random;

		//Mock the inputstream

		String input = "Y\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());

		Field f1 = ScannerUtil.class.getDeclaredField("scanner");
		f1.setAccessible(true);
		f1.set(null, new Scanner(in));

		
		
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
		
		ExplorerLauncher.exploreRoom(rpgPlayerProfile);

		assertEquals(1040,rpgPlayerProfile.getCash());

	}
	
}
