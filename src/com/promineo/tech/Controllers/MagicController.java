
package com.promineo.tech.Controllers;

import java.util.ArrayList;

import com.promineo.tech.Models.Race;
import com.promineo.tech.Models.Avatar;
import com.promineo.tech.Models.Weapon;
import com.promineo.tech.Models.MagicViewModel;
import com.promineo.tech.Service.RaceService;
import com.promineo.tech.Service.AvatarService;
import com.promineo.tech.Service.WeaponService;

public class MagicController implements IMagicController {
	private MagicViewModel viewModel;
	private AvatarService avatarService;
	private WeaponService weaponService;
	private RaceService raceService;
	
	public MagicController(MagicViewModel model)
	{
		viewModel = model;
		avatarService = new AvatarService();
		weaponService = new WeaponService();
		raceService = new RaceService();
	}
	
	@Override
	public  void StartMagicService()
	{
		Avatar avatar;
		Weapon weapon;
		Race race;
		
		switch (viewModel.MainMenuChoice)
		{
			case AVATAR:
				switch (viewModel.CrudChoice) 
				{
					case CREATE:
						avatarService.createAvatar(new Avatar(0, viewModel.AvatarFirstName, viewModel.AvatarLastName));
						System.out.println("Avatar created!...");
						break;
					case READ:
						System.out.println("All avatars...");
						ArrayList<Avatar> avatars = avatarService.getAvatars();
						for (Avatar s : avatars)
						{
							System.out.println(s);
						}
						break;
					case UPDATE:
						avatar = avatarService.getAvatar(viewModel.AvatarId);
						if(avatar != null)
						{
							avatar.setFirstName(viewModel.AvatarFirstName);
							avatar.setLastName(viewModel.AvatarLastName);
							avatarService.updateAvatar(avatar);
							System.out.println("Avatar updated!...");
						}
						else
						{
							System.out.println("Avatar does not exist...");
						}
						break;
					case DELETE:
						avatar = avatarService.getAvatar(viewModel.AvatarId);
						if(avatar != null)
						{
							avatarService.deleteAvatar(avatar);
							System.out.println("Avatar deleted!...");
						}
						else
						{
							System.out.println("Avatar does not exist...");
						}
						break;
					default:
						System.out.println("Invalid Crud Choice...");
						break;
				}
				break;
			case WEAPON:
				switch (viewModel.CrudChoice) 
				{
					case CREATE:
						weaponService.createWeapon(new Weapon(0, viewModel.WeaponWeaponName, viewModel.WeaponShieldName));
						System.out.println("Weapon created!...");
						break;
					case READ:
						System.out.println("All weapons...");
						ArrayList<Weapon> weapons = weaponService.getWeapons();
						for (Weapon t : weapons)
						{
							System.out.println(t);
						}
						break;
					case UPDATE:
						weapon = weaponService.getWeapon(viewModel.WeaponId);
						if(weapon != null)
						{
							weapon.setWeaponName(viewModel.WeaponWeaponName);
							weapon.setShieldName(viewModel.WeaponShieldName);
							weaponService.updateWeapon(weapon);
							System.out.println("Weapon updated!...");
						}
						else
						{
							System.out.println("Weapon does not exist...");
						}
						break;
					case DELETE:
						weapon = weaponService.getWeapon(viewModel.WeaponId);
						if(weapon != null)
						{
							weaponService.deleteWeapon(weapon);
							System.out.println("Weapon deleted!...");
						}
						else
						{
							System.out.println("Weapon does not exist...");
						}
						break;
					default:
						System.out.println("Invalid Crud Choice...");
						break;
				}
				break;
			case RACE:
				switch (viewModel.CrudChoice) 
				{
					case CREATE:
						raceService.createRace(new Race(0, viewModel.RaceName, viewModel.RacePlanet));
						System.out.println("Race created!...");
						break;
					case READ:
						System.out.println("All races...");
						ArrayList<Race> races = raceService.getRaces();
						for (Race c : races)
						{
							System.out.println(c);
						}
						break;
					case UPDATE:
						race = raceService.getRace(viewModel.RaceId);
						if(race != null)
						{
							race.setName(viewModel.RaceName);
							race.setPlanet(viewModel.RacePlanet);
							raceService.updateRace(race);
							System.out.println("Race updated!...");
						}
						else
						{
							System.out.println("Race does not exist...");
						}
						break;
					case DELETE:
						race = raceService.getRace(viewModel.RaceId);
						if(race != null)
						{
							raceService.deleteRace(race);
							System.out.println("Race deleted!...");
						}
						else
						{
							System.out.println("Race does not exist...");
						}
						break;
					default:
						System.out.println("Invalid Crud Choice...");
						break;
				}
				break;
			default:
				System.out.println("Invalid Main Menu Choice...");
				break;
		}
		
	}
}