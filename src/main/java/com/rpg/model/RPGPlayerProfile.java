package com.rpg.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.rpg.util.CommonUtil;

/**
 * @author Shaik Fareed
 *
 */
public class RPGPlayerProfile implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Game gameChosen;

	private String role;

	private String playerName;

	private int item1;

	private int item2;

	private int item3;

	private int item4;

	private int item5;

	private int xp;

	private int level;

	private List<String> inventory = new ArrayList<>();

	private int cash;

	private String itemChosen;

	public Game getGameChosen() {
		return gameChosen;
	}

	public void setGameChosen(Game gameChosen) {
		this.gameChosen = gameChosen;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getItem1() {
		return item1;
	}

	public void setItem1(int item1) {
		this.item1 = item1;
	}

	public int getItem2() {
		return item2;
	}

	public void setItem2(int item2) {
		this.item2 = item2;
	}

	public int getItem3() {
		return item3;
	}

	public void setItem3(int item3) {
		this.item3 = item3;
	}

	public int getItem4() {
		return item4;
	}

	public void setItem4(int item4) {
		this.item4 = item4;
	}

	public int getItem5() {
		return item5;
	}

	public void setItem5(int item5) {
		this.item5 = item5;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public int getXp() {
		return xp;
	}

	public void setXp(int xp) {
		this.xp = xp;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public List<String> getInventory() {
		return inventory;
	}

	public void setInventory(List<String> inventory) {
		this.inventory = inventory;
	}

	public int getCash() {
		return cash;
	}

	public void setCash(int cash) {
		this.cash = cash;
	}

	public String getItemChosen() {
		return itemChosen;
	}

	public void setItemChosen(String itemChosen) {
		this.itemChosen = itemChosen;
	}

	// Display stats

	public void statRead() {

		CommonUtil.slowPrint("--Stats-- \n "
				+this.getGameChosen().getItem1Description()+": " + this.getItem1() 
				+ "\n "+this.getGameChosen().getItem2Description()+": " + this.getItem2()
				+ "\n "+this.getGameChosen().getItem3Description()+": " + this.getItem3() 
				+ "\n "+this.getGameChosen().getItem4Description()+": " + this.getItem4()
				+ "\n "+this.getGameChosen().getItem5Description()+": " + this.getItem5() 
				+ " \n \n Level: " + this.getLevel() 
				+ "\n XP: "
				+ this.getXp());
	}

}
