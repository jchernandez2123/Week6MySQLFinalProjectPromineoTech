package com.promineo.tech.Service;

import java.util.ArrayList;


import com.promineo.tech.Models.Race;
import com.promineo.tech.Repository.RaceRepository;



public class RaceService {

private RaceRepository raceRepository;
	
	public RaceService()
	{
		raceRepository = new RaceRepository();
	}
	
	public ArrayList<Race> getRaces()
	{
		return raceRepository.getRaces();
	}
	
	public Race getRace(int raceId) {
		return raceRepository.getRace(raceId);
	}

	public void createRace(Race race) {
		raceRepository.createRace(race);
	}

	public void deleteRace(Race race) {
		raceRepository.deleteRace(race);
	}

	public void updateRace(Race race) {
		raceRepository.updateRace(race);
	}
}