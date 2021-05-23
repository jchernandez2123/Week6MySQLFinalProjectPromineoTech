package com.promineo.tech.Models;

public class Weapon {
	private int Id;
	private String WeaponName;
	private String ShieldName;
	
	public Weapon(int id, String weaponName, String shieldName)
	{
		Id = id;
		WeaponName = weaponName;
		ShieldName = shieldName;
	}
	
	public int getId()
	{
		return Id;
	}
	
	public String getWeaponName()
	{
		return WeaponName;
	}
	
	public void setWeaponName(String weaponName)
	{
		WeaponName = weaponName;
	}
	
	public String getShieldName()
	{
		return ShieldName;
	}
	
	public void setShieldName(String shieldName)
	{
		ShieldName = shieldName;
	}
			
	public String toString()
	{
		return "WeaponId: " + Id + ", WeaponName: " + WeaponName + ", ShieldName: " + ShieldName;
	}
}