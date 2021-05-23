  
package com.promineo.tech.Service;

import java.util.ArrayList;

import com.promineo.tech.Models.Weapon;

public interface IWeaponService {
	ArrayList<Weapon> getWeapons();
	Weapon getWeapon(int weaponId);
	void createWeapon(Weapon weapon);
	void deleteWeapon(Weapon weapon);
	void updateWeapon(Weapon weapon);
}