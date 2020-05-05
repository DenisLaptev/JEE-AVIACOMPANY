package main.java.service;

import java.util.ArrayList;
import java.util.List;

import main.java.dao.FlightDAO;
import main.java.dao.FlightDAOImpl;
import main.java.dao.PersonalDAO;
import main.java.dao.PersonalDAOImpl;
import main.java.model.Flight;
import main.java.model.Personal;

public class PersonalServiceImpl implements PersonalService {
	@Override
	public List<Personal> getAllPersonals() {
		PersonalDAO personalDAO = new PersonalDAOImpl();
		List<Personal> allPersonalsList = new ArrayList<>();
		allPersonalsList = personalDAO.getAllPersonals();
		return allPersonalsList;
	}

	@Override
	public Personal getPersonalById(int idPersonal) {
		PersonalDAO personalDAO = new PersonalDAOImpl();
		Personal personal = personalDAO.getPersonalById(idPersonal);
		return personal;
	}

	@Override
	public Personal updatePersonal(int idPersonal, Personal newPersonal) {
		PersonalDAO personalDAO = new PersonalDAOImpl();
		Personal updatedPersonal = personalDAO.updatePersonal(idPersonal, newPersonal);

		System.out.println("updatedPersonal=" + updatedPersonal);
		return updatedPersonal;
	}

	@Override
	public boolean addPersonal(Personal personal) {
		PersonalDAO personalDAO = new PersonalDAOImpl();
		boolean result = personalDAO.addPersonal(personal);
		return result;
	}

	@Override
	public boolean deletePersonalById(int idPersonal) {
		PersonalDAO personalDAO = new PersonalDAOImpl();
		boolean result = personalDAO.deletePersonalById(idPersonal);

		System.out.println("deletePersonalById=" + result);
		return result;
	}

	@Override
	public void addPersonToPersonal(int idPerson, int idPersonal) {
		PersonalDAO personalDAO = new PersonalDAOImpl();
		personalDAO.addPersonToPersonal(idPerson, idPersonal);

		//TODO
		//update person info (change idPersonal)
	}

	@Override
	public List<Personal> getFreePersonalByIdOrder(int idOrder) {
		
		PersonalDAO personalDAO = new PersonalDAOImpl();
		List<Personal> personalList = new ArrayList<>();
		personalList = personalDAO.getFreePersonalByIdOrder(idOrder);
		return personalList;
	}
}
