package com.promineo.tech.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.promineo.tech.Models.Race;
import com.promineo.tech.Models.Avatar;

public class AvatarRepository extends MySqlRepository implements IAvatarRepository {
	private Connection connection;
	public AvatarRepository()
	{
		connection = super.getConnection("magic");
	}
	
	@Override
	public ArrayList<Avatar> getAvatars() {
		ArrayList<Avatar> avatars = new ArrayList<Avatar>();

		try
		{
			CallableStatement st = connection.prepareCall("{call getAvatars()}");
			boolean hasResult = st.execute();
			if(hasResult)
			{
				ResultSet rs = st.getResultSet();

				while(rs.next())
				{
					avatars.add(new Avatar(rs.getInt(1), rs.getString(2), rs.getString(3)));
				}
			}
		}
		catch(SQLException ex)
		{
			System.out.println(ex.getMessage());
			return avatars;
		}
		
		return avatars;
	}
	@Override
	public Avatar getAvatar(int avatarId) {
		try
		{
			CallableStatement st = connection.prepareCall("{call getAvatarById(?)}");
			st.setInt(1, avatarId);
			
			boolean hasResult = st.execute();
			if(hasResult)
			{
				ResultSet rs = st.getResultSet();

				while(rs.next())
				{
					return new Avatar(rs.getInt(1), rs.getString(2), rs.getString(3));
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
	public void createAvatar(Avatar avatar) {
		try
		{
			CallableStatement st = connection.prepareCall("{call createAvatar(?, ?)}");
			st.setString(1, avatar.getFirstName());
			st.setString(2, avatar.getLastName());
			st.execute();
		}
		catch(SQLException ex)
		{
			System.out.println(ex.getMessage());
		}
	}
	
	@Override
	public void deleteAvatar(Avatar avatar) {
		try
		{
			CallableStatement st = connection.prepareCall("{call deleteAvatar(?)}");
			st.setInt(1, avatar.getId());
			st.execute();
		}
		catch(SQLException ex)
		{
			System.out.println(ex.getMessage());
		}
	}
	
	@Override
	public void updateAvatar(Avatar avatar) {
		try
		{
			CallableStatement st = connection.prepareCall("{call updateAvatar(?, ?, ?)}");
			st.setInt(1, avatar.getId());
			st.setString(2, avatar.getFirstName());
			st.setString(3, avatar.getLastName());
			st.execute();
		}
		catch(SQLException ex)
		{
			System.out.println(ex.getMessage());
		}
	}
}