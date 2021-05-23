package com.promineo.tech.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.promineo.tech.Models.Race;

public class RaceRepository extends MySqlRepository implements IRaceRepository {
	private Connection connection;
	public RaceRepository()
	{
		connection = super.getConnection("magic");
	}
	
	@Override
	public ArrayList<Race> getRaces() {
		ArrayList<Race> races = new ArrayList<Race>();

		try
		{
			CallableStatement st = connection.prepareCall("{call getRaces()}");
			boolean hasResult = st.execute();
			if(hasResult)
			{
				ResultSet rs = st.getResultSet();

				while(rs.next())
				{
					races.add(new Race(rs.getInt(1), rs.getString(2), rs.getString(3)));
				}
			}
		}
		catch(SQLException ex)
		{
			System.out.println(ex.getMessage());
			return races;
		}
		
		return races;
	}
	@Override
	public Race getRace(int raceId) {
		try
		{
			CallableStatement st = connection.prepareCall("{call getRaceById(?)}");
			st.setInt(1, raceId);
			
			boolean hasResult = st.execute();
			if(hasResult)
			{
				ResultSet rs = st.getResultSet();

				while(rs.next())
				{
					return new Race(rs.getInt(1), rs.getString(2), rs.getString(3));
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
	public void createRace(Race race) {
		try
		{
			CallableStatement st = connection.prepareCall("{call createRace(?, ?)}");
			st.setString(1, race.getName());
			st.setString(2, race.getPlanet());
			st.execute();
		}
		catch(SQLException ex)
		{
			System.out.println(ex.getMessage());
		}
	}
	
	@Override
	public void deleteRace(Race race) {
		try
		{
			CallableStatement st = connection.prepareCall("{call deleteRace(?)}");
			st.setInt(1, race.getId());
			st.execute();
		}
		catch(SQLException ex)
		{
			System.out.println(ex.getMessage());
		}
	}
	
	@Override
	public void updateRace(Race race) {
		try
		{
			CallableStatement st = connection.prepareCall("{call updateRace(?, ?, ?)}");
			st.setInt(1, race.getId());
			st.setString(2, race.getName());
			st.setString(3, race.getPlanet());
			st.execute();
		}
		catch(SQLException ex)
		{
			System.out.println(ex.getMessage());
		}
	}
}