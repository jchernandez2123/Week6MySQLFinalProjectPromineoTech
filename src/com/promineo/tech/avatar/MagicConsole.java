package com.promineo.tech.avatar;

import java.util.Scanner;

import com.promineo.tech.Controllers.MagicController;
import com.promineo.tech.Models.CrudChoice;
import com.promineo.tech.Models.MainMenuChoice;
import com.promineo.tech.Models.MagicViewModel;





public class MagicConsole {
	
	private static MagicViewModel viewModel;
	private static Scanner scanner;

	public static void main(String[] args) {
		
System.out.println("Welcome to the Magic Worlds Game!!!");
		
		try
		{
			scanner = new Scanner(System.in);
			
			do
			{
				viewModel = new MagicViewModel();
				DisplayMainMenu();
				DisplayCrudMenu();
				DisplayDetailsScreen();
		
				if(viewModel.MainMenuChoice != MainMenuChoice.EXIT)
				{
					
					MagicController magicController = new MagicController(viewModel);
					 magicController.StartMagicService();
				}
			} 
	while(viewModel.MainMenuChoice != MainMenuChoice.EXIT);	
			
			System.out.println("Goodbye!!!");
			scanner.close();
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
			scanner.close();
		}
	}
			
	private static void DisplayMainMenu()
	{
		System.out.println("Please choose from the Main Menu...");
		System.out.println("1. Avatar");
		System.out.println("2. Weapon");
		System.out.println("3. Race");
		System.out.println("4. Exit");
		
		if(scanner.hasNextInt())
		{
			viewModel.MainMenuChoice = MainMenuChoice.values()[scanner.nextInt() - 1];
		}
	}
	
	private static void DisplayCrudMenu()
	{
		System.out.println("Please choose from the Menu...");
		System.out.println("1. Create");
		System.out.println("2. Read");
		System.out.println("3. Update");
		System.out.println("4. Delete");
		
		
		if(scanner.hasNextInt())
		{
			viewModel.CrudChoice = CrudChoice.values()[scanner.nextInt() - 1];
		}
	}
		
	private static void DisplayDetailsScreen()
	{
		switch (viewModel.MainMenuChoice) 
		{
			case AVATAR:
				switch (viewModel.CrudChoice)
				{
					case CREATE:
						System.out.println("Enter Avatar First Name: ");
						viewModel.AvatarFirstName = scanner.next();
						System.out.println("Enter Avatar Last Name: ");
						viewModel.AvatarLastName = scanner.next();
						break;
					case READ:
						break;
					case UPDATE:
						System.out.println("Enter Avatar Id: ");
						viewModel.AvatarId = scanner.nextInt();
						System.out.println("Enter Avatar First Name: ");
						viewModel.AvatarFirstName = scanner.next();
						System.out.println("Enter Avatar Last Name: ");
						viewModel.AvatarLastName = scanner.next();
						break;
					case DELETE:
						System.out.println("Enter Avatar Id: ");
						viewModel.AvatarId = scanner.nextInt();
						break;
				}
		
				break;
			case WEAPON:
				switch (viewModel.CrudChoice)
				{
					case CREATE:
						System.out.println("Enter Weapon Name: ");
						viewModel.WeaponWeaponName = scanner.next();
						System.out.println("Enter Shield Name: ");
						viewModel.WeaponShieldName = scanner.next();
						break;
						
					case READ:
						break;
						
					case UPDATE:
						System.out.println("Enter Weapon Id: ");
						viewModel.WeaponId = scanner.nextInt();
						System.out.println("Enter Weapon Name: ");
						viewModel.WeaponWeaponName = scanner.next();
						System.out.println("Enter Shield Name: ");
						viewModel.WeaponShieldName = scanner.next();
						break;
					case DELETE:
						System.out.println("Enter Weapon Id: ");
						viewModel.WeaponId = scanner.nextInt();
						break;
		
				}
				break;
			case RACE:
				switch (viewModel.CrudChoice)
				{
					case CREATE:
						System.out.println("Enter Race Name: ");
						viewModel.RaceName = scanner.next();
						System.out.println("Enter Planet Name: ");
						viewModel.RacePlanet = scanner.next();
						break;
					case READ:
						break;
						
						
					case UPDATE:
						System.out.println("Enter Race Id: ");
						viewModel.RaceId = scanner.nextInt();
						System.out.println("Enter Race Name: ");
						viewModel.RaceName = scanner.next();
						System.out.println("Enter Planet Name: ");
						viewModel.RacePlanet = scanner.next();
						break;
						
					case DELETE:
						System.out.println("Enter Race Id: ");
						viewModel.RaceId = scanner.nextInt();
						break;
				}
				break;	
						
						
						
						
						
						
						
						
		}					
						
	}
}

