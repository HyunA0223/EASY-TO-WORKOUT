package persistence.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import service.dto.*;
import persistence.DAOFactory;
import persistence.dao.*;
import persistence.util.JDBCUtil;

public class RoutineDAOImpl implements RoutineDAO {
	
	private JDBCUtil jdbcUtil = null;
	
	private static String query = "SELECT ROUTINE.ROUTINEID AS ROUTINE_ID, " +
	         "ROUTINE.RNAME AS ROUTINE_NAME, " +
	         "ROUTINE.RTIME AS ROUTINE_TIME, " +
	         "ROUTINE.DIFFICULTY AS ROUTINE_DIFFICULTY, " +
	         "ROUTINE.RTYPE AS ROUTINE_TYPE, " +
	         "ROUTINE.PART AS ROUTINE_PART ";
	
	public RoutineDAOImpl() {
		jdbcUtil = new JDBCUtil();
	}

	@Override
	public List<RoutineDTO> getRoutineList() {
		String allQuery = query + ", " + "ROUTINE.ROUTINECREATER AS ROUTINE_CREATER " +
		    "FROM ROUTINE ORDER BY ROUTINE.ROUTINEID ASC ";		
		jdbcUtil.setSql(allQuery);		// JDBCUtil �� query ����

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
	public List<RoutineDTO> getRoutineListByPublic(String rType) {
		String searchQuery = query + ", " + "ROUTINE.ROUTINECREATER AS ROUTINE_CREATER " +
			        "FROM ROUTINE " +
			        "WHERE ROUTINE.RTYPE = 0 ";
			   	 
		jdbcUtil.setSql(searchQuery);				// JDBCUtil �� query �� ����

		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query �� ����
			List<RoutineDTO> list = new ArrayList<RoutineDTO>();	// RoutineDTO ��ü���� ������� list ��ü
			if (rs.next()) {						// �ϳ��� RoutineDTO ��ü ���� �� ���� ����
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
	public List<RoutineDTO> getRoutineListByPersonal(String rType) {
		String searchQuery = query + ", " + "ROUTINE.ROUTINECREATER AS ROUTINE_CREATER " +
		        "FROM ROUTINE " +
		        "WHERE ROUTINE.RTYPE = 1 ";
		   	 
		jdbcUtil.setSql(searchQuery);				// JDBCUtil �� query �� ����

		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query �� ����
			List<RoutineDTO> list = new ArrayList<RoutineDTO>();	// RoutineDTO ��ü���� ������� list ��ü
			if (rs.next()) {						// �ϳ��� RoutineDTO ��ü ���� �� ���� ����
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
	public int insertRoutine(RoutineDTO routine) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateRoutine(RoutineDTO routine) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteRoutine(int routineId) {
		String deleteQuery = "DELETE FROM ROUTINE WHERE ROUTINEID = ?";
		
		jdbcUtil.setSql(deleteQuery);			// JDBCUtil �� query �� ����
		Object[] param = new Object[] {routineId};
		jdbcUtil.setParameters(param);			// JDBCUtil �� �Ű����� ����
		
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
	public RoutineDTO getRoutineByName(String rName) {
		String searchQuery = query + ", " + "ROUTINE.ROUTINECREATER AS ROUTINE_CREATER " +
		        "FROM ROUTINE " +
		        "WHERE ROUTINE.RNAME = ? ";
		   	 
		jdbcUtil.setSql(searchQuery);				// JDBCUtil �� query �� ����
		Object[] param = new Object[] { rName };
		jdbcUtil.setParameters(param);

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

}
