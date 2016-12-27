package com.plantplaces.ui.test;

import org.junit.Test;

import com.plantplaces.dto.Plant;
import com.plantplaces.ui.SearchPlants;

import junit.framework.TestCase;

public class TestSearchPlants extends TestCase {
	
	
	private SearchPlants searchPlants;
	private String execute;

	@Test
	public void testSearchPlantsExecute(){
		givenSearchPlantsCreatedWithRedBud();
		whenInvokeExecute();
		thenVerifyReturnSuccess();	
	}

	@Test
	public void testSearchPlantsNoRedbud(){
		givenSearchPlantsCreatedWithoutRedBud();
		whenInvokeExecute();
		thenVerifyReturnNoResults();
	}
	
	@Test
	public void testSearchPlantNull(){
		givenSearchPlantsCreatedWithNullPlant();
		whenInvokeExecute();
		thenVerifyReturnNoResults();
	}
	
	private void givenSearchPlantsCreatedWithNullPlant() {
		// TODO Auto-generated method stub
		searchPlants = new SearchPlants();
	}

	private void thenVerifyReturnNoResults() {
		// TODO Auto-generated method stub
		assertEquals("noresults", execute);
		
	}

	private void givenSearchPlantsCreatedWithoutRedBud() {
		// TODO Auto-generated method stub
		searchPlants = new SearchPlants();
		Plant plant = new Plant();
		plant.setName("Pawpaw");
		searchPlants.setPlant(plant);
	}

	private void thenVerifyReturnSuccess() {
		// TODO Auto-generated method stub
		assertEquals("success", execute);
		
	}

	private void whenInvokeExecute() {
		// TODO Auto-generated method stub
		execute = searchPlants.execute();
		
	}

	private void givenSearchPlantsCreatedWithRedBud() {
		searchPlants = new SearchPlants();
		Plant plant = new Plant();
		plant.setName("Redbud");
		searchPlants.setPlant(plant);
	}
}
