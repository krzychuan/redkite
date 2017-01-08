package com.plantplaces.service;

import java.util.List;
import com.plantplaces.dto.Plant;

/**
 * IPlantService includes all business functions related 
 * functions for a Plant and related entities.
 * @author antoniakk
 *
 */

public interface IPlantService {
	/**
	 * Return a collection of Plant objects 
	 * that contain the given filter text.
	 * @param filter a substring that should be contained in returned plants.
	 * @return collection of matching plants.
	 */
	public List<Plant> filterPlants(String filter);
	/**
	 * Save the plant and perform a validation check.
	 * @param plant is an dto object to transfer data, in this case about new plant that we are going to persist. 
	 * @throws Exception if unable to save.
	 */
	public void save(Plant plant) throws Exception;
	/**
	 * Return a list of plants that match the given search criteria
	 * @param plant a parameter that contains the search criteria
	 * @return a list of matching plants
	 */
	List<Plant> fetchPlants(Plant plant);
}
