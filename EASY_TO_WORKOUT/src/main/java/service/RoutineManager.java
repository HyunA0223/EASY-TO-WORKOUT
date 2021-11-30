package service;

import java.sql.SQLException;
import service.exception.*;
import java.util.List;
import persistence.DAOFactory;
import persistence.dao.RoutineDAO;
import service.dto.Routine;
import service.dto.Exercise;

public class RoutineManager {

	private static RoutineManager rouSI = new RoutineManager();
	private RoutineDAO dao;
	private DAOFactory factory;
	
	public RoutineManager() {
		try {
			factory = new DAOFactory();
			dao = factory.getRoutineDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static RoutineManager getInstance() {
		return rouSI;
	}
	
	public List<Routine> ListingRoutines() throws SQLException {
		return dao.getRoutineList();
	}
	
	public List<Routine> ListingRoutinesByPublic() throws SQLException {
		return dao.getRoutineListByPublic();
	}
	
	public List<Routine> ListingRoutinesByPersonal(String id) throws SQLException {
		return dao.getRoutineListByPersonal(id);
	}
	
	public List<Routine> getRoutineByPart(String part) throws ExistingPartException, SQLException {
		// TODO Auto-generated method stub
		if (part.equals("")) {
			throw new ExistingPartException("������� �ٽ� �Է��ϼ���.");
		}
		else if (!existingPart(part)) {
			throw new ExistingPartException("�ش� ������� �������� �ʽ��ϴ�.");
		}
		return dao.getRoutineByPart(part);
	}
	
	public boolean existingRoutine(String rName) throws SQLException {
		return dao.existingRoutine(rName);
	}
	
	public boolean existingPart(String part) throws SQLException {
		return dao.existingPart(part);
	}
	
	public int insertRoutine(Routine routine) throws SQLException, ExistingRoutineException {
		if (dao.existingRoutine(routine.getrName()) == true) {
			throw new ExistingRoutineException(routine.getrName() + "�� �����ϴ� ��ƾ�Դϴ�.");
		}
		return dao.insertRoutine(routine);
	}
	
	public Routine getRoutineById(String routineId) {
		return dao.getRoutineById(routineId);
	}
	
	
	public int updateRoutine(Routine routine) throws SQLException, ExistingRoutineException {
		String oldRoutineName = getRoutine(routine.getRoutineId()).getrName();
		if (routine.getrName().equals(oldRoutineName) == false) {
			throw new ExistingRoutineException(routine.getrName() + "�� �������� �ʴ� ��ƾ�Դϴ�.");
		}
		return dao.updateRoutine(routine);
	}
	
	public int deleteRoutine(int routineId) {
		return dao.deleteRoutine(routineId);
	}
	
	public Routine getRoutine(int routineId) throws SQLException, ExistingRoutineException {
		return dao.getRoutineById(routineId);
	}
	
	public List<Exercise> getExercises(int routineId) throws SQLException {
		return dao.getExercises(routineId);
	}
}
