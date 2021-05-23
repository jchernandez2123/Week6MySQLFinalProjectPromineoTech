package com.promineo.tech.Service;

import java.util.ArrayList;

import com.promineo.tech.Models.Race;

public interface IRaceService {
	ArrayList<Race> getRaces();
	Race getRace(int raceId);
	void createRace(Race race);
	void deleteRace(Race race);
	void updateRace(Race race);
}