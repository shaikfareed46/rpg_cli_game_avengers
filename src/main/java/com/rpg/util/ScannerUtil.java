package com.rpg.util;

import java.util.Scanner;

/**
 * @author Shaik Fareed
 *
 */
public class ScannerUtil {

	private static Scanner scanner = new Scanner(System.in);
	
	
	public static int integerInput(){
		return scanner.nextInt();
	}
	
	public static String stringInput(){
		return scanner.next()+scanner.nextLine();
	}
	
}
