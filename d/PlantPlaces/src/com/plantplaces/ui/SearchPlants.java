package com.plantplaces.ui;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.plantplaces.dto.Plant;



@Named
@ManagedBean
@Scope("session")
public class SearchPlants {

	@Inject
	private Plant plant;
	
	public String execute()
	{
		if (plant !=null && plant.getName().equalsIgnoreCase("Redbud"))
		{
			return ("search");
		}
		return ("noresults");
	}

	public Plant getPlant() {
		return plant;
	}

	public void setPlant(Plant plant) {
		this.plant = plant;
	}
	
	public List<Plant> completePlants(String query)
	{
		ArrayList<Plant> allPlants = new ArrayList<Plant>();
		Plant tulipan = new Plant();
		tulipan.setName("Tulipan");
		Plant mimoza = new Plant();
		mimoza.setName("Mimoza");
		allPlants.add(tulipan);
		allPlants.add(mimoza);
		return allPlants;
	}
}
