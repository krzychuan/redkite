package com.plantplaces.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.plantplaces.dao.IPlantDAO;
import com.plantplaces.dto.Plant;

@Named
public class PlantService implements IPlantService {

	@Inject
	IPlantDAO plantDAO;
	private List<Plant> allPlants;
	
	@Override
	public List<Plant> filsterPlants(String filter) {
		if(allPlants == null){
			allPlants = plantDAO.fetchPlants();
		}
		ArrayList<Plant> returnPlants = new ArrayList<Plant>();
 		// TODO Auto-generated method stub
		return null;
	}

}
