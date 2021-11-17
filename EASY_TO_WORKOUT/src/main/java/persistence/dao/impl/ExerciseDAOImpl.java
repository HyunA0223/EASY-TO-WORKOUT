package persistence.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import service.dto.*;
import persistence.dao.*;
import persistence.util.JDBCUtil;

public class ExerciseDAOImpl implements ExerciseDAO {

	private JDBCUtil jdbcUtil = null;
	
	private static String query = "SELECT EXERCISE.EXERCISEID AS EXERCISE_ID, " +
	         "EXERCISE.NAME AS EXERCISE_NAME, " +
	         "EXERCISE.PART AS EXERCISE_PART, " +
	         "EXERCISE.METHOD AS EXERCISE_METHOD ";
	
	public ExerciseDAOImpl() {
		jdbcUtil = new JDBCUtil();
	}
	
	@Override
	public List<ExerciseDTO> getExerciseList() {
		String allQuery = query +
			   "FROM EXERCISE ORDER BY EXERCISE.EXERCISEID ASC ";		
		jdbcUtil.setSqlAndParameters(allQuery, null);		// JDBCUtil �� query ����

		try { 
				ResultSet rs = jdbcUtil.executeQuery();		// query �� ����			
				List<ExerciseDTO> list = new ArrayList<ExerciseDTO>();		// ExerciseDTO ��ü���� ������� list ��ü
				while (rs.next()) {	
					ExerciseDTO dto = new ExerciseDTO();		// �ϳ��� ExerciseDTO ��ü ���� �� ���� ����
					dto.setExerciseId(rs.getInt("EXERCISE_ID"));
					dto.setName(rs.getString("EXERCISE_NAME"));
					dto.setPart(rs.getString("EXERCISE_PART"));
					dto.setMethod(rs.getString("EXERCISE_METHOD"));
					list.add(dto);		// list ��ü�� ������ ������ ExerciseDTO ��ü ����
				}
				return list;		// ��� ������ dto���� ����� ��ȯ
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// ResultSet, PreparedStatement, Connection ��ȯ
		}		
		return null;
	}

	@Override
	public ExerciseDTO getExerciseByName(String name) {
		String searchQuery = query +
		        "FROM EXERCISE " +
		        "WHERE EXERCISE.NAME = ? ";
		   	 
		Object[] param = new Object[] { name };
		
		jdbcUtil.setSqlAndParameters(searchQuery, param);

		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query �� ����
			ExerciseDTO dto = null;
			if (rs.next()) {						// ã�� ��� ������ ExerciseDTO ��ü�� ����
				dto = new ExerciseDTO();
				dto.setExerciseId(rs.getInt("EXERCISE_ID"));
				dto.setName(rs.getString("EXERCISE_NAME"));
				dto.setPart(rs.getString("EXERCISE_PART"));
				dto.setMethod(rs.getString("EXERCISE_METHOD"));
			}
			return dto;				// ã�� ��� ������ ��� �ִ� ExerciseDTO ��ü ��ȯ
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// ResultSet, PreparedStatement, Connection ��ȯ
		}
		return null;
	}

}
