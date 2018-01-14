package com.rpg.launcher;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.rpg.model.RPGPlayerProfile;
import com.rpg.util.CommonUtil;
import com.rpg.util.ScannerUtil;

/**
 * @author Shaik Fareed
 *
 */
public class SaveLauncher {

	/**
	 * @param rpgPlayerProfile
	 * @throws IOException
	 */
	public static void saveGame(RPGPlayerProfile rpgPlayerProfile) throws IOException{

		String path = SaveLauncher.class.getProtectionDomain().getCodeSource().getLocation().getPath();

		System.out.println("Please enter save name");

		String saveName = ScannerUtil.stringInput();

		// write object to file
		FileOutputStream fos = new FileOutputStream(path+saveName+".sv");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(rpgPlayerProfile);
		oos.close();
	}

	/**
	 * @return
	 */
	public static RPGPlayerProfile startNewOrLoadGame(){
		System.out.println("Do you want to start...\n"+
				"<1> New Game \n"+
				"<2> Load Game"
				);

		int option = ScannerUtil.integerInput();
		
		RPGPlayerProfile rpgPlayerProfile = null;

		if(option == 1){
			rpgPlayerProfile = new RPGPlayerProfile();
		}else if(option==2){
			try {
				rpgPlayerProfile = loadGame();
			} catch (ClassNotFoundException | IOException e) {
				rpgPlayerProfile = new RPGPlayerProfile();
				System.out.println("Could not load the game.... So starting the new game...");
			}
		}else{
			rpgPlayerProfile = new RPGPlayerProfile();
			System.out.println("Invalid option... So starting the new game");
		}
		
		return rpgPlayerProfile;
	}


	/**
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static RPGPlayerProfile loadGame() throws IOException, ClassNotFoundException{

		String path = SaveLauncher.class.getProtectionDomain().getCodeSource().getLocation().getPath();

		File[] files = finder(path);
		
		if(files.length==0){
			CommonUtil.slowPrint("No saved games... So starting a new one....");
			return new RPGPlayerProfile();
		}


		System.out.println("Saved versions are :");
		int i = 1;
		for(File file:files){
			System.out.println("<"+i+"> "+file.getName().replaceAll("sv", ""));
			i++;
		}

		System.out.println("Choose one of the version to load..");

		RPGPlayerProfile rpgPlayerProfile;

		int saveOption;
		try {
			saveOption = ScannerUtil.integerInput();
			if(saveOption>files.length || saveOption==0){
				System.out.println("That was not a valid option.");
				rpgPlayerProfile =loadGame();
			}else{
				// write object to file
				FileInputStream fis = new FileInputStream(files[saveOption-1]);
				ObjectInputStream ois = new ObjectInputStream(fis);
				rpgPlayerProfile = (RPGPlayerProfile) ois.readObject();
				ois.close();
				return rpgPlayerProfile;
			}
		} catch (NumberFormatException e) {
			System.out.println("That was not a valid option.");
			rpgPlayerProfile = loadGame();
		}

		return rpgPlayerProfile;
	}

	/**
	 * @param dirName
	 * @return
	 */
	public static File[] finder(String dirName){
		File dir = new File(dirName);

		return dir.listFiles(new FilenameFilter() { 
			public boolean accept(File dir, String filename)
			{ return filename.endsWith(".sv"); }
		} );

	}
}
