  
package com.promineo.tech.Repository;

import java.util.ArrayList;

import com.promineo.tech.Models.Race;

public interface IRaceRepository {
	ArrayList<Race> getRaces();
	Race getRace(int classRoomId);
	void createRace(Race race);
	void deleteRace(Race race);
	void updateRace(Race race);
}