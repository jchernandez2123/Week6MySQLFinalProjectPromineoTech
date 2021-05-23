package com.promineo.tech.Service;



import java.util.ArrayList;

import com.promineo.tech.Models.Avatar;
import com.promineo.tech.Models.Weapon;
import com.promineo.tech.Repository.WeaponRepository;

public class WeaponService implements IWeaponService {
private WeaponRepository weaponRepository;
	
	public WeaponService()
	{
		weaponRepository = new WeaponRepository();
	}
	
	@Override
	public ArrayList<Weapon> getWeapons()
	{
		return weaponRepository.getWeapons();
	}

	@Override
	public Weapon getWeapon(int weaponId) {
		return weaponRepository.getWeapon(weaponId);
	}

	@Override
	public void createWeapon(Weapon weapon) {
		weaponRepository.createWeapon(weapon);
	}

	
	public void deleteWeapon(Weapon weapon) {
		weaponRepository.deleteWeapon(weapon);
	}
	
	@Override
	public void updateWeapon(Weapon weapon) {
		weaponRepository.updateWeapon(weapon);
	}
}