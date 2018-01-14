package com.rpg.model;

import java.util.List;

/**
 * @author Shaik Fareed
 *
 */
public interface Game {
	
	public String getChooseRoleMessage();
	
	public String getItem1Description();
	
	public String getItem2Description();
	
	public String getItem3Description();
	
	public String getItem4Description();
	
	public String getItem5Description();
	
	public String getMessage1();
	
	public String getMessage2();
	
	public List<String> getHeroes();
	
	public String getChooseItemMessage();
	
	public List<String> getItemsToChoose();

	public String getMessage3();
	
}
