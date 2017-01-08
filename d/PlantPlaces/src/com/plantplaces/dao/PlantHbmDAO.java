package com.plantplaces.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.plantplaces.dto.Plant;

//public class PlantHbmDAO extends PlantPlacesHbmDAO<Plant>implements IPlantDAO {
public class PlantHbmDAO implements IPlantDAO {

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Plant> fetchPlants() {
		
		List<Plant> plantList = new ArrayList<Plant>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		// create the query
		org.hibernate.Query query = session.createQuery("from Plant");
		//plantList = (List<Plant>)session.createQuery("from Plant").list();
		//*@SuppressWarnings("rawtypes")
		plantList = (List<Plant>)query.list();
		return plantList;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Plant> fetchPlants(Plant plant) {
		List<Plant> plantList = new ArrayList<Plant>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		// create the query
		org.hibernate.Query query = session.createQuery("from Plant where common = :common");
		//query.setParameter("common", plant.getCommon()); //Jak definiujenym liniê poni¿ej to tej ju¿ nie potrzebujemy.
		query.setProperties(plant);
		plantList = (List<Plant>)query.list();
		return plantList;
	}
	
	/*@Override
	@SuppressWarnings("unchecked")
	public List<Plant> fetchPlants(Plant plant) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		// create the query
		org.hibernate.Query query = session.createQuery("from Plant where common like :common");
		query.setParameter("common", "%" + plant.getCommon() + "%");
		// query.setProperties(plant);
		@SuppressWarnings("rawtypes")
		List list = query.list();
		List<Plant> plants = list; //Collections.checkedList(list, Plant.class);
		return plants;
	}*/
	/*@Override
	public List<Plant> fetchPlants1(Plant plant) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		org.hibernate.Query query = session.createQuery("from Plants where common=:common");
		//query.setParameter("common", "Potomac Pawpaw");
		query.setProperties(plant);
		@SuppressWarnings("rawtypes")
		List list = query.list();
		@SuppressWarnings("unchecked")
		List<Plant> plants = Collections.checkedList(list, Plant.class);
		return plants;
	}*/
	
	/*@Override
	public void insert(Session session, Plant plant) throws Exception {
		session.save(plant);
	}*/

	
	@Override
	public void update(Plant plant) throws Exception {
		// TODO Auto-generated method stub
	}

	@Override
	public void delete(Plant plant) throws Exception {
		// TODO Auto-generated method stub
	}

	@Override
	public void insert(Plant plant) throws Exception {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(plant);
		session.getTransaction().commit();
	}

	@Override
	public void save(Plant plant) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(Session session, Plant plant) throws Exception {
		// TODO Auto-generated method stub
		
	}
}
