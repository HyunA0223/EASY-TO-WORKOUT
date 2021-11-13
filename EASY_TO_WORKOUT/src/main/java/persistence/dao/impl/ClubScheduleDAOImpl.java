package persistence.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import persistence.dao.ClubScheduleDAO;
import persistence.util.JDBCUtil;
import service.dto.ClubScheduleDTO;

public class ClubScheduleDAOImpl implements ClubScheduleDAO {
	private JDBCUtil jdbcUtil = null;	// JDBCUtil ��ü �̿�
	
	// ���� ������ �⺻ ������ �����ϴ� SELCT��
	private static String query = "SELECT CLUBSCHEDULE.SCHEDULEID AS SCHEDULEID, " +
				"CLUBSCHEDULE.CLUBID AS CLUBID, " +
				"CLUBSCHEDULE.CONTACTADDRESS AS CONTACTADDRESS, " + 
				"CLUBSCHEDULE.NOTICE AS NOTICE, " + 
				"CLUBSCHEDULE.CREATIONDATE AS CREATIONDATE";
	
	// ������
	public ClubScheduleDAOImpl() {
		jdbcUtil = new JDBCUtil(); // ClubScheduleDAOImpl ��ü ���� �� JDBC ��ü ����
	}

	@Override
	public List<ClubScheduleDTO> getClubScheduleList() {
		// TODO Auto-generated method stub
		String allQuery = query + "FROM CLUBSCHEDULE ORDER BY CLUBID";
		
		// JDBCUtil�� query ����
		jdbcUtil.setSql(allQuery);
		try {
			ResultSet rs = jdbcUtil.executeQuery(); // query�� ����
			List<ClubScheduleDTO> list = new ArrayList<ClubScheduleDTO>(); // DTO ��ü ��� ���� ����Ʈ ����
			
			while (rs.next()) {
				ClubScheduleDTO dto = new ClubScheduleDTO(); // ClubDTO ��ü ���� �� �˻� ��� ����
				dto.setClubId(rs.getInt("CLUBID"));
				dto.setScheduleId(rs.getInt("SCHEDULEID"));
				dto.setContactAddress(rs.getString("CONTACTADDRESS"));
				dto.setNotice(rs.getString("NOTICE"));
				dto.setCreationDate(rs.getString("CREATIONDATE"));
				
				list.add(dto); // ����Ʈ�� DTO ��ü ����
			}
			return list; // ���� ������ ������ DTO ��ü���� ����Ʈ ��ȯ
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close(); // ResultSet, PreparedStatement, Connection ��ȯ
		}
		
		return null;
	}

	@Override
	public ClubScheduleDTO getClubScheduleById(int clubScheduleId, int clubId) {
		// TODO Auto-generated method stub
		String searchQuery = query + "FROM CLUBSCHEDULE WHERE CLUBSCHEDULEID = ? AND CLUBID = ?";
		
		jdbcUtil.setSql(searchQuery);				// JDBCUtil �� query �� ����
		Object[] param = new Object[] {clubScheduleId, clubId};		// ������ ã�� ���� �������� id ����
		jdbcUtil.setParameters(param);				// JDBCUtil �� query ���� �Ű����� ������ ����� �Ű����� ����
		
		try {
			ResultSet rs = jdbcUtil.executeQuery(); // query�� ����
			ClubScheduleDTO schedule = null;
			
			if (rs.next()) {
				schedule = new ClubScheduleDTO(); // clubDTO ��ü�� �����Ͽ� ���� ���� ����
				schedule.setClubId(rs.getInt("CLUBID"));
				schedule.setScheduleId(rs.getInt("SCHEDULEID"));
				schedule.setContactAddress(rs.getString("CONTACTADDRESS"));
				schedule.setNotice(rs.getString("NOTICE"));
				schedule.setCreationDate(rs.getString("CREATIONDATE"));
			}
			return schedule; // ���� ������ ��� �ִ� ClubDTO ��ü ��ȯ
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close(); // ResultSet, PreparedStatement, Connection ��ȯ
		}
		
		return null;
	}

	@Override
	public int insertClubSchedule(ClubScheduleDTO clubSchedule) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteClubSchedule(int clubId, int clubScheduleId) {
		// TODO Auto-generated method stub
		return 0;
	}


}
