package com.rpg.util;

/**
 * @author Shaik Fareed
 *
 */
public class CommonUtil {

	/**
	 * @param message
	 */
	public static void slowPrint(String message)
    {
		System.out.println("\n");
		
        for (int i = 0; i < message.length(); i++)
        {
            System.out.print(message.charAt(i));

            try
            {
                Thread.sleep(150);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        
        //Wait for next message
        try
        {
            Thread.sleep(100);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        
        System.out.println("\n\n");
    }
	
}
