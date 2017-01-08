package com.plantplaces.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.plantplaces.dto.Plant;


public interface IPlantDAO {
	
	public List<Plant> fetchPlants();
	public void insert(Plant plant) throws Exception;
	public void update(Plant plant) throws Exception;
	public void delete(Plant plant) throws Exception;
	public void insert(Session session, Plant plant) throws Exception;
	void save(Plant plant) throws Exception;
	List<Plant> fetchPlants(Plant plant);
}
