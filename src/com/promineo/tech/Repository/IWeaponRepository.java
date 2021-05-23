  
package com.promineo.tech.Repository;

import java.util.ArrayList;

import com.promineo.tech.Models.Weapon;

public interface IWeaponRepository {
	ArrayList<Weapon> getWeapons();
	Weapon getWeapon(int weaponId);
	void createWeapon(Weapon weapon);
	void deleteWeapon(Weapon weapon);
	void updateWeapon(Weapon weapon);
}