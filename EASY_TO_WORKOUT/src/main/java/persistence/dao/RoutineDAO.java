package persistence.dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

import service.dto.Routine;
import service.dto.Exercise;
import persistence.util.JDBCUtil;

public class RoutineDAO {
	
	private JDBCUtil jdbcUtil = null;
	
	private static String query = "SELECT ROUTINE.ROUTINEID AS ROUTINE_ID, " +
	         "ROUTINE.RNAME AS ROUTINE_NAME, " +
	         "ROUTINE.RTIME AS ROUTINE_TIME, " +
	         "ROUTINE.DIFFICULTY AS ROUTINE_DIFFICULTY, " +
	         "ROUTINE.RTYPE AS ROUTINE_TYPE, " +
	         "ROUTINE.PART AS ROUTINE_PART, " +
	         "ROUTINE.ROUTINECREATER AS ROUTINE_CREATER ";
	
	public RoutineDAO() {
		jdbcUtil = new JDBCUtil();
	}

	public List<Routine> getRoutineList() {
		String allQuery = query + "FROM ROUTINE ORDER BY ROUTINE_ID ASC ";		
		jdbcUtil.setSqlAndParameters(allQuery, null);		// JDBCUtil �� query ����

		try { 
				ResultSet rs = jdbcUtil.executeQuery();		// query �� ����			
				List<Routine> list = new ArrayList<Routine>();		// RoutineDTO ��ü���� ������� list ��ü
				
				while (rs.next()) {	
					Routine dto = new Routine();		// �ϳ��� RoutineDTO ��ü ���� �� ���� ����
					dto.setRoutineId(rs.getInt("ROUTINE_ID"));
					dto.setrName(rs.getString("ROUTINE_NAME"));
					dto.setrTime(rs.getInt("ROUTINE_TIME"));
					dto.setDifficulty(rs.getInt("ROUTINE_DIFFICULTY"));
					dto.setrType(rs.getString("ROUTINE_TYPE"));
					dto.setPart(rs.getString("ROUTINE_PART"));
					dto.setRoutineCreater(rs.getString("ROUTINE_CREATER"));
					
					list.add(dto);		// list ��ü�� ������ ������ RoutineDTO ��ü ����
				}
				return list;		// ��ƾ�� ������ dto���� ����� ��ȯ
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// ResultSet, PreparedStatement, Connection ��ȯ
		}		
		return null;
	}

	public List<Routine> getRoutineListByPublic() {
		String searchQuery = query +
			        "FROM ROUTINE " +
			        "WHERE RTYPE = '0' ";
			   	 
		jdbcUtil.setSqlAndParameters(searchQuery, null);				// JDBCUtil �� query �� ����

		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query �� ����
			List<Routine> list = new ArrayList<Routine>();	// RoutineDTO ��ü���� ������� list ��ü
			
			while (rs.next()) {						// �ϳ��� RoutineDTO ��ü ���� �� ���� ����
				Routine dto = new Routine();
				dto.setRoutineId(rs.getInt("ROUTINE_ID"));
				dto.setrName(rs.getString("ROUTINE_NAME"));
				dto.setrTime(rs.getInt("ROUTINE_TIME"));
				dto.setDifficulty(rs.getInt("ROUTINE_DIFFICULTY"));
				dto.setrType(rs.getString("ROUTINE_TYPE"));
				dto.setPart(rs.getString("ROUTINE_PART"));
				dto.setRoutineCreater(rs.getString("ROUTINE_CREATER"));
				list.add(dto);	// list ��ü�� ������ ������ RoutineDTO ��ü ����
			}
			return list;				// �ۺ� ��ƾ�� ������ ��� �ִ� RoutineDTO ��ü ��ȯ
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// ResultSet, PreparedStatement, Connection ��ȯ
		}
		return null;
	}

	public List<Routine> getRoutineListByPersonal(String memberId) {
		String searchQuery = query + 
		        "FROM ROUTINE " +
		        "WHERE ROUTINECREATER = ? ";
		   	 
		jdbcUtil.setSqlAndParameters(searchQuery, new Object[] {memberId});			// JDBCUtil �� query �� ����

		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query �� ����
			List<Routine> list = new ArrayList<Routine>();	// RoutineDTO ��ü���� ������� list ��ü
			
			while (rs.next()) {						// �ϳ��� RoutineDTO ��ü ���� �� ���� ����
				Routine dto = new Routine();
				dto.setRoutineId(rs.getInt("ROUTINE_ID"));
				dto.setrName(rs.getString("ROUTINE_NAME"));
				dto.setrTime(rs.getInt("ROUTINE_TIME"));
				dto.setDifficulty(rs.getInt("ROUTINE_DIFFICULTY"));
				dto.setrType(rs.getString("ROUTINE_TYPE"));
				dto.setPart(rs.getString("ROUTINE_PART"));
				dto.setRoutineCreater(rs.getString("ROUTINE_CREATER"));
				list.add(dto);	// list ��ü�� ������ ������ RoutineDTO ��ü ����
			}
			return list;				// �۽��� ��ƾ�� ������ ��� �ִ� RoutineDTO ��ü ��ȯ
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// ResultSet, PreparedStatement, Connection ��ȯ
		}
		return null;
	}
	
	public List<Routine> getRoutineByPart(String part) { // ��ƾ �̸����� ���� �˻�
		// TODO Auto-generated method stub
		String searchQuery = query +
				"FROM ROUTINE " +
		        "WHERE PART LIKE ? ";
		
		Object[] param = new Object[] {"%" + part + "%"}; // ��ƾ �̸����� �˻� �� ���� ���� ����
		jdbcUtil.setSqlAndParameters(searchQuery, param);
		
		try {
			ResultSet rs = jdbcUtil.executeQuery(); // query�� ����
			List<Routine> list = new ArrayList<Routine>();
			
			while (rs.next()) {
				Routine dto = new Routine(); // RoutineDTO ��ü ���� �� �˻� ��� ����
				dto.setRoutineId(rs.getInt("ROUTINE_ID"));
				dto.setrName(rs.getString("ROUTINE_NAME"));
				dto.setrTime(rs.getInt("ROUTINE_TIME"));
				dto.setDifficulty(rs.getInt("ROUTINE_DIFFICULTY"));
				dto.setrType(rs.getString("ROUTINE_TYPE"));
				dto.setPart(rs.getString("ROUTINE_PART"));
				dto.setRoutineCreater(rs.getString("ROUTINE_CREATER"));
				
				list.add(dto); // ����Ʈ�� DTO ��ü ����
			}
			return list; // ��ƾ ������ ������ DTO ��ü���� ����Ʈ ��ȯ
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close(); // ResultSet, PreparedStatement, Connection ��ȯ
		}
		
		return null;
	}

	public int insertRoutine(Routine routine) {
		int result = 0;
		String insertQuery = "INSERT INTO "
				+ "ROUTINE (ROUTINEID, RNAME, RTIME, DIFFICULTY, RTYPE, RPART, ROUTINECREATER) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
		
		Object[] param = new Object[] {routine.getRoutineId(), routine.getrName(), 
				routine.getrTime(), routine.getDifficulty(), 
				routine.getrType(), routine.getPart(), 
				routine.getRoutineCreater()};
		
		jdbcUtil.setSqlAndParameters(insertQuery, param);
		
		try {
			result = jdbcUtil.executeUpdate();
		} catch (Exception e) {
			jdbcUtil.rollback();
			e.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}
		return result;
	}

	public int updateRoutine(Routine routine) {
		int result = 0;
		String updateQuery = "UPDATE ROUTINE "
				+ "SET RNAME=?, RTIME=?, DIFFICULTY=?, RTYPE=?, RPART=?, ROUTINECREATER=? "
				+ "WHERE ROUTINEID=?";
		
		Object[] param = new Object[] {routine.getrName(), 
				routine.getrTime(), routine.getDifficulty(), 
				routine.getrType(), routine.getPart(), 
				routine.getRoutineCreater(), routine.getRoutineId()};
		
		jdbcUtil.setSqlAndParameters(updateQuery, param);
		
		try {
			result = jdbcUtil.executeUpdate();
		} catch (Exception e) {
			jdbcUtil.rollback();
			e.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}
		return result;
	}

	public int deleteRoutine(int routineId) {
		String deleteQuery = "DELETE FROM ROUTINE WHERE ROUTINEID = ?";
		
		Object[] param = new Object[] {routineId};
		
		jdbcUtil.setSqlAndParameters(deleteQuery, param);
		
		try {
			int result = jdbcUtil.executeUpdate();		// delete �� ����
			return result;						// delete �� ���� �ݿ��� ���ڵ� �� ��ȯ
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();		
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();		// ResultSet, PreparedStatement, Connection ��ȯ
		}
		return 0;
	}

	public Routine getRoutineById(int routineId) {
		String searchQuery = query +
		        "FROM ROUTINE " +
		        "WHERE ROUTINE.ROUTINEID = ? ";
	
		Object[] param = new Object[] { routineId };
		
		jdbcUtil.setSqlAndParameters(searchQuery, param);

		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query �� ����
			Routine dto = null;
			if (rs.next()) {						// ã�� ��ƾ�� ������ RoutineDTO ��ü�� ����
				dto = new Routine();
				dto.setRoutineId(rs.getInt("ROUTINE_ID"));
				dto.setrName(rs.getString("ROUTINE_NAME"));
				dto.setrTime(rs.getInt("ROUTINE_TIME"));
				dto.setDifficulty(rs.getInt("ROUTINE_DIFFICULTY"));
				dto.setrType(rs.getString("ROUTINE_TYPE"));
				dto.setPart(rs.getString("ROUTINE_PART"));
				dto.setRoutineCreater(rs.getString("ROUTINE_CREATER"));
			}
			return dto;				// ã�� ��ƾ�� ������ ��� �ִ� RoutineDTO ��ü ��ȯ
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// ResultSet, PreparedStatement, Connection ��ȯ
		}
		return null;
	}

	public boolean existingRoutine(String rName) {
		String sql = "SELECT count(*) FROM ROUTINE WHERE RNAME=?";   
		
		jdbcUtil.setSqlAndParameters(sql, new Object[] {rName});	// JDBCUtil�� query���� �Ű� ���� ����

		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query ����
			if (rs.next()) {
				int count = rs.getInt(1);
				return (count == 1 ? true : false);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource ��ȯ
		}
		return false;
	}
	
	public boolean existingPart(String part) {
		if (part.equals("��ü")) {
			return true;
		}
		if (part.equals("��ü")) {
			return true;
		}
		if (part.equals("����")) {
			return true;
		}
		if (part.equals("���")) {
			return true;
		}
		if (part.equals("����")) {
			return true;
		}
		return false;
	}
	
	public List<Exercise> getExercises(int routineId) {
		String searchQuery = "SELECT EXERCISE.EXERCISEID AS EXERCISE_ID, " +
		         "EXERCISE.NAME AS EXERCISE_NAME, " +
		         "EXERCISE.PART AS EXERCISE_PART, " +
		         "EXERCISE.METHOD AS EXERCISE_METHOD " + 
		        "FROM EXERCISE LEFT OUTER JOIN CHOICE ON EXERCISE.EXERCISEID = CHOICE.EXERCISEID " +
		        "WHERE CHOICE.ROUTINEID = ? " +
		        "ORDER BY CHOICE.SEQUENCE ASC ";
		   	 
		jdbcUtil.setSqlAndParameters(searchQuery, new Object[] {routineId});			// JDBCUtil �� query �� ����

		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query �� ����
			List<Exercise> list = new ArrayList<Exercise>();	// ExerciseDTO ��ü���� ������� list ��ü
			
			while (rs.next()) {						// �ϳ��� ExerciseDTO ��ü ���� �� ���� ����
				Exercise dto = new Exercise();
				dto.setExerciseId(rs.getInt("EXERCISE_ID"));
				dto.setName(rs.getString("EXERCISE_NAME"));
				dto.setPart(rs.getString("EXERCISE_PART"));
				dto.setMethod(rs.getString("EXERCISE_METHOD"));
				list.add(dto);	// list ��ü�� ������ ������ ExerciseDTO ��ü ����
			}
			return list;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// ResultSet, PreparedStatement, Connection ��ȯ
		}
		return null;
	} 
}
