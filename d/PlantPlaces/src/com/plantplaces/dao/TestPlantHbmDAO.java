package com.plantplaces.dao;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import org.junit.Test;

import com.plantplaces.dto.Plant;

import junit.framework.TestCase;

public class TestPlantHbmDAO extends TestCase {

	private PlantHbmDAO plantHbmDAO;
	private List<Plant> plants;
	//Ka¿da metoda testowa powinna mieæ w nazwie test inaczaj przy próbie wywo³ania
	//testu w trybie debug otrzymamy ....
	@Test	
	public void testVerifyFetchByCommonName(){
		givenPlantDAOInstantiated();
		getAllPlants();
		whenCommonNameIsRedBud();
		thenVerifyResults();
		
	}

	private void getAllPlants() {
		// TODO Auto-generated method stub
		plants = plantHbmDAO.fetchPlants();
	}

	private void thenVerifyResults() {
		// TODO Auto-generated method stub
		assertTrue(plants.size() > 0);
		/*for(Plant plant: plants){
			assertEquals("Redbud", plant.getCommon());
		}*/
	}

	private void whenCommonNameIsRedBud() {
		// TODO Auto-generated method stub
		Plant plant = new Plant();
		plant.setName("Redbud");
		plants = plantHbmDAO.fetchPlants(plant);
	}

	private void givenPlantDAOInstantiated() {
		// TODO Auto-generated method stub
		plantHbmDAO = new PlantHbmDAO();
	}
}
