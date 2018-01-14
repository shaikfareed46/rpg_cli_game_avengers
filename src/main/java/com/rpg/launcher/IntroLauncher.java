package com.rpg.launcher;

import com.rpg.constants.CommonConstants;
import com.rpg.util.CommonUtil;

/**
 * @author Shaik Fareed
 *
 */
public class IntroLauncher {

	public static void commonIntro() {
		System.out.println(CommonConstants.ASCI_RED+CommonConstants.MESSAGE1);

		System.out.println(CommonConstants.ASCI_PURPLE+CommonConstants.MESSAGE2);
		
		CommonUtil.slowPrint(CommonConstants.ASCI_RED+CommonConstants.MESSAGE3);
		
		System.out.println(""+CommonConstants.ASCI_RESET);
	}
	
}
