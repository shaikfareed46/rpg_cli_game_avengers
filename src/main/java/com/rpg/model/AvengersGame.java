package com.rpg.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.rpg.constants.CommonConstants;
import com.rpg.util.CommonUtil;

/**
 * @author Shaik Fareed
 *
 */
public class AvengersGame implements Game,Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	{
		CommonUtil.slowPrint("Avengers Infinity War Game Presents.....");
		CommonUtil.slowPrint("There was an idea.\nTo bring together a group of remarkable people.\nTo See if we could become something more.\nSo when they needed us we could fight the battles that they never could...");
	}

	@Override
	public String getItem1Description() {
		return "Strength";
	}

	@Override
	public String getItem2Description() {
		return "SuperPower";
	}

	@Override
	public String getItem3Description() {
		return "Acrobatics";
	}

	@Override
	public String getItem4Description() {
		return "Health";
	}
	
	@Override
	public String getItem5Description() {
		return "Intelligence";
	}


	@Override
	public String getMessage1() {
		return "The Earth and its existence has been uncertain as it is totally affected by "+CommonConstants.ASCI_RED+" Thanos "+CommonConstants.ASCI_RESET+" and his people...."
			  +"\n\n You See a man running towards you and looks like he is need of your help.....";
	}

	@Override
	public String getMessage2() {
		return "I'm afraid that I have bad news for you! Earth has been terrorized by "+CommonConstants.ASCI_RED+" Thanos "+CommonConstants.ASCI_RESET+". He is destroying earth as never before!!! \nIt would be great if you could help us!";
	}

	@Override
	public String getChooseRoleMessage() {
		return CommonConstants.ASCI_RESET+" Pick a hero: \n"
				+ "<1> Spider Man \n"
				+ "<2> Hulk \n"
				+ "<3> Captain America \n"
				+ "<4> Create your own character";
	}

	@Override
	public List<String> getHeroes() {
		List<String> heroes = new ArrayList<>();
		heroes.add("Spider Man");
		heroes.add("Hulk");
		heroes.add("Captain America");
		return heroes;
	}

	@Override
	public String getChooseItemMessage() {
		return "Seller : I see you are not properly equipped... Here are the items to choose from...."
				+ "\n <1> Tesseract"
				+ "\n <2> Infinity stones"
				+ "\n <3> Mind stone"
				+ "\n"
				+ "\n"
				+"\n Choose one from above option....";
	}

	@Override
	public List<String> getItemsToChoose() {
		List<String> items = new ArrayList<>();
		items.add("Tesseract");
		items.add("Infinity stones");
		items.add("Mind stone");
		items.add("Iron Man Armors");
		items.add("Scepter");
		items.add("Chitauri Bomb");
		items.add("Captain America shield");
		items.add("Chitauri Gun");
		items.add("Black widow's bite");
		return items;
	}

	@Override
	public String getMessage3() {
		return "Oh... That's okay... \n \n The whole world was destroyed by Thanos and all the avengers died...";
	}
	
	

}
