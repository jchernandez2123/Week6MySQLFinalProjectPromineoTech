package com.promineo.tech.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.promineo.tech.Models.Avatar;
import com.promineo.tech.Models.Weapon;

public class WeaponRepository extends MySqlRepository implements IWeaponRepository {
	private Connection connection;
	public WeaponRepository()
	{
		connection = super.getConnection("magic");
	}
	
	@Override
	public ArrayList<Weapon> getWeapons() {
		ArrayList<Weapon> weapons = new ArrayList<Weapon>();

		try
		{
			CallableStatement st = connection.prepareCall("{call getWeapons()}");
			boolean hasResult = st.execute();
			if(hasResult)
			{
				ResultSet rs = st.getResultSet();

				while(rs.next())
				{
					weapons.add(new Weapon(rs.getInt(1), rs.getString(2), rs.getString(3)));
				}
			}
		}
		catch(SQLException ex)
		{
			System.out.println(ex.getMessage());
			return weapons;
		}
		
		return weapons;
	}
	@Override
	public Weapon getWeapon(int weaponId) {
		try
		{
			CallableStatement st = connection.prepareCall("{call getAvatarById(?)}");
			st.setInt(1, weaponId);
			
			boolean hasResult = st.execute();
			if(hasResult)
			{
				ResultSet rs = st.getResultSet();

				while(rs.next())
				{
					return new Weapon(rs.getInt(1), rs.getString(2), rs.getString(3));
				}
			}
		}
		catch(SQLException ex)
		{
			System.out.println(ex.getMessage());
			return null;
		}
		
		return null;
	}
	
	@Override
	public void createWeapon(Weapon weapon) {
		try
		{
			CallableStatement st = connection.prepareCall("{call createWeapon(?, ?)}");
			st.setString(1, weapon.getWeaponName());
			st.setString(2, weapon.getShieldName());
			st.execute();
		}
		catch(SQLException ex)
		{
			System.out.println(ex.getMessage());
		}
	}
	
	@Override
	public void deleteWeapon(Weapon weapon) {
		try
		{
			CallableStatement st = connection.prepareCall("{call deleteWeapon(?)}");
			st.setInt(1, weapon.getId());
			st.execute();
		}
		catch(SQLException ex)
		{
			System.out.println(ex.getMessage());
		}
	}
	
	@Override
	public void updateWeapon(Weapon weapon) {
		try
		{
			CallableStatement st = connection.prepareCall("{call updateWeapon(?, ?, ?)}");
			st.setInt(1, weapon.getId());
			st.setString(2, weapon.getWeaponName());
			st.setString(3, weapon.getShieldName());
			st.execute();
		}
		catch(SQLException ex)
		{
			System.out.println(ex.getMessage());
		}
	}
}