package com.plantplaces.ui;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;

import com.plantplaces.dto.Plant;
import com.plantplaces.service.IPlantService;

@Named
@ManagedBean
@Scope("session")
public class AddPlant {

	final static Logger logger = Logger.getLogger(AddPlant.class);
	
	@Inject
	private Plant plant;
	
	@Inject
	private IPlantService plantService;
	
	public String execute(){
		
		//Nie dodajemy wrazliwych danych do loga tj. danych osobowych, nr kart kredytowych itp :)
		logger.info("Entering the Execute method");
		String message = "success";
		//In this case we can not pass the exception any higher 
		//so the block of code must be surrounded by try catch. 
		
		//Get FacesContext
		FacesContext currentInstance = FacesContext.getCurrentInstance();
		
		try {
			plantService.save(plant);
			logger.info("Save successful "+plant.toString());
			// what is the message that we want to show?
			FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Saved", "Plant Saved");

			// display the message
			currentInstance.addMessage(null, fm);
						
		} catch (Exception e) {
			logger.error("Error while saving plant. Message: "+e.getMessage());
			e.printStackTrace();
			message="fail";
			
			// what is the message that we want to show?
			FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Unable to save", "Plant not saved");

			// display the message
			currentInstance.addMessage(null, fm);
		}
		return message;
	}

	public Plant getPlant() {
		return plant;
	}

	public void setPlant(Plant plant) {
		this.plant = plant;
	}

	public IPlantService getPlantService() {
		return plantService;
	}

	public void setPlantService(IPlantService plantService) {
		this.plantService = plantService;
	}
	
}
