package persistence.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

import service.dto.RoutineDTO;
import persistence.dao.RoutineDAO;
import persistence.util.JDBCUtil;

public class RoutineDAOImpl implements RoutineDAO {
	
	private JDBCUtil jdbcUtil = null;
	
	private static String query = "SELECT ROUTINE.ROUTINEID AS ROUTINE_ID, " +
	         "ROUTINE.RNAME AS ROUTINE_NAME, " +
	         "ROUTINE.RTIME AS ROUTINE_TIME, " +
	         "ROUTINE.DIFFICULTY AS ROUTINE_DIFFICULTY, " +
	         "ROUTINE.RTYPE AS ROUTINE_TYPE, " +
	         "ROUTINE.PART AS ROUTINE_PART, " +
	         "ROUTINE.ROUTINECREATER AS ROUTINE_CREATER ";
	
	public RoutineDAOImpl() {
		jdbcUtil = new JDBCUtil();
	}

	@Override
	public List<RoutineDTO> getRoutineList() {
		String allQuery = query + "FROM ROUTINE ORDER BY ROUTINE_ID ASC ";		
		jdbcUtil.setSqlAndParameters(allQuery, null);		// JDBCUtil �� query ����

		try { 
				ResultSet rs = jdbcUtil.executeQuery();		// query �� ����			
				List<RoutineDTO> list = new ArrayList<RoutineDTO>();		// RoutineDTO ��ü���� ������� list ��ü
				
				while (rs.next()) {	
					RoutineDTO dto = new RoutineDTO();		// �ϳ��� RoutineDTO ��ü ���� �� ���� ����
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

	@Override
	public List<RoutineDTO> getRoutineListByPublic() {
		String searchQuery = query +
			        "FROM ROUTINE " +
			        "WHERE RTYPE = '0' ";
			   	 
		jdbcUtil.setSqlAndParameters(searchQuery, null);				// JDBCUtil �� query �� ����

		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query �� ����
			List<RoutineDTO> list = new ArrayList<RoutineDTO>();	// RoutineDTO ��ü���� ������� list ��ü
			
			while (rs.next()) {						// �ϳ��� RoutineDTO ��ü ���� �� ���� ����
				RoutineDTO dto = new RoutineDTO();
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

	@Override
	public List<RoutineDTO> getRoutineListByPersonal() {
		String searchQuery = query + 
		        "FROM ROUTINE " +
		        "WHERE RTYPE = '1' ";
		   	 
		jdbcUtil.setSqlAndParameters(searchQuery, null);			// JDBCUtil �� query �� ����

		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query �� ����
			List<RoutineDTO> list = new ArrayList<RoutineDTO>();	// RoutineDTO ��ü���� ������� list ��ü
			
			while (rs.next()) {						// �ϳ��� RoutineDTO ��ü ���� �� ���� ����
				RoutineDTO dto = new RoutineDTO();
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
	
	@Override
	public List<RoutineDTO> getRoutineByName(String rName) { // ��ƾ �̸����� ���� �˻�
		// TODO Auto-generated method stub
		String searchQuery = query +
				"FROM ROUTINE " +
		        "WHERE RNAME = ? ";
		
		Object[] param = new Object[] {rName}; // ��ƾ �̸����� �˻� �� ���� ���� ����
		jdbcUtil.setSqlAndParameters(searchQuery, param);
		
		try {
			ResultSet rs = jdbcUtil.executeQuery(); // query�� ����
			List<RoutineDTO> list = new ArrayList<RoutineDTO>();
			
			while (rs.next()) {
				RoutineDTO dto = new RoutineDTO(); // RoutineDTO ��ü ���� �� �˻� ��� ����
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

	@Override
	public int insertRoutine(RoutineDTO routine) {
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

	@Override
	public int updateRoutine(RoutineDTO routine) {
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

	@Override
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

	@Override
	public RoutineDTO getRoutineById(int routineId) {
		String searchQuery = query +
		        "FROM ROUTINE " +
		        "WHERE ROUTINE.ROUTINEID = ? ";
	
		Object[] param = new Object[] { routineId };
		
		jdbcUtil.setSqlAndParameters(searchQuery, param);

		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query �� ����
			RoutineDTO dto = null;
			if (rs.next()) {						// ã�� ��ƾ�� ������ RoutineDTO ��ü�� ����
				dto = new RoutineDTO();
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
}
