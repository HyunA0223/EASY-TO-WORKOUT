package service;

import java.sql.SQLException;
import service.exception.*;
import java.util.List;
import persistence.DAOFactory;
import persistence.dao.RoutineDAO;
import service.dto.Routine;

public class RoutineServiceImpl {

	private static RoutineServiceImpl rouSI = new RoutineServiceImpl();
	private RoutineDAO dao;
	private DAOFactory factory;
	
	public RoutineServiceImpl() {
		try {
			factory = new DAOFactory();
			dao = factory.getRoutineDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static RoutineServiceImpl getInstance() {
		return rouSI;
	}
	
	public List<Routine> ListingRoutines() throws SQLException {
		return dao.getRoutineList();
	}
	
	public List<Routine> ListingRoutinesByPublic() throws SQLException {
		return dao.getRoutineListByPublic();
	}
	
	public List<Routine> ListingRoutinesByPersonal() throws SQLException {
		return dao.getRoutineListByPersonal();
	}
	
	public List<Routine> getRoutineByName(String rName) throws ExistingRoutineException, SQLException {
		// TODO Auto-generated method stub
		if (rName.equals("")) {
			throw new ExistingRoutineException("��ƾ���� �ٽ� �Է��ϼ���.");
		}
		else if (!existingRoutine(rName)) {
			throw new ExistingRoutineException("�ش� ��ƾ�� �������� �ʽ��ϴ�.");
		}
		return dao.getRoutineByName(rName);
	}
	
	public boolean existingRoutine(String rName) throws SQLException {
		return dao.existingRoutine(rName);
	}
	
	public int insertRoutine(Routine routine) throws SQLException, ExistingRoutineException {
		if (dao.existingRoutine(routine.getrName()) == true) {
			throw new ExistingRoutineException(routine.getrName() + "�� �����ϴ� ��ƾ�Դϴ�.");
		}
		return dao.insertRoutine(routine);
	}
	
	public int updateRoutine(Routine routine) throws SQLException, RoutineNotFoundException, ExistingRoutineException {
		String oldRoutineName = getRoutine(routine.getRoutineId()).getrName();
		if (routine.getrName().equals(oldRoutineName) == false) {
			throw new RoutineNotFoundException(routine.getrName() + "�� �������� �ʴ� ��ƾ�Դϴ�.");
		}
		return dao.updateRoutine(routine);
	}
	
	public int deleteRoutine(int routineId) {
		return dao.deleteRoutine(routineId);
	}
	
	public Routine getRoutine(int routineId) throws SQLException, ExistingRoutineException {
		return dao.getRoutineById(routineId);
	}
}
