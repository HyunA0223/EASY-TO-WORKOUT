package service;

import java.sql.SQLException;
import java.util.List;
import persistence.DAOFactory;
import persistence.dao.ExerciseDAO;
import service.dto.Exercise;
import service.exception.ExistingExerciseException;


public class ExerciseManager {

	private static ExerciseManager exSI = new ExerciseManager();
	private ExerciseDAO dao;
	private DAOFactory factory;
	
	public ExerciseManager() {
		try {
			factory = new DAOFactory();
			dao = factory.getExerciseDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static ExerciseManager getInstance() {
		return exSI;
	}
	
	public List<Exercise> ListingExercises() throws SQLException {
		return dao.getExerciseList();
	}
	
	public List<Exercise> getExerciseByName(String name) throws ExistingExerciseException, SQLException {
		// TODO Auto-generated method stub
		if (name.equals("")) {
			throw new ExistingExerciseException("����� �ٽ� �Է��ϼ���.");
		}
		else if (!existingExercise(name)) {
			throw new ExistingExerciseException("�ش� ��� �������� �ʽ��ϴ�.");
		}
		return dao.getExerciseByName(name);
	}
	
	public boolean existingExercise(String name) throws SQLException {
		return dao.existingExercise(name);
	}
	
	public Exercise getExercise(int exerciseId) throws SQLException {
		return dao.getExerciseById(exerciseId);
	}
}
