package com.promineo.tech.Models;

public class Race {
	private int Id;
	private String Name;
	private String Planet;
	
	public Race(int id, String name, String plan)
	{
		Id = id;
		Name = name;
		Planet = plan;
	}
	
	public int getId()
	{
		return Id;
	}
	
	public String getName()
	{
		return Name;
	}
	
	public void setName(String name)
	{
		Name = name;
	}
	
	public String getPlanet()
	{
		return Planet;
	}
	
	public void setPlanet(String planet)
	{
		Planet = planet;
	}
			
	public String toString()
	{
		return "RaceId: " + Id + ", Name: " + Name + ", Planet: " + Planet;
	}
}