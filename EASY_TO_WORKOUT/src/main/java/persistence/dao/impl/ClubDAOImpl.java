package persistence.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import persistence.dao.ClubDAO;
import persistence.util.JDBCUtil;
import service.dto.ClubDTO;

public class ClubDAOImpl implements ClubDAO {
	private JDBCUtil jdbcUtil = null;	// JDBCUtil ��ü �̿�
	
	// ���� �⺻ ������ �����ϴ� SELCT��
	private static String query = "SELECT CLUB.CLUBID AS CLUBID, " + 
			"CLUB.SIGNUP AS SIGNUP, " + 
			"CLUB.OPENCYCLE AS OPENCYCLE, " + 
			"CLUB.CLUBINTRO AS CLUBINTRO, " + 
			"CLUB.CLUBNAME AS CLUBNAME, " + 
			"CLUB.CLUBMASTER AS CLUBMASTER ";
	
	// ������
	public ClubDAOImpl() {
		jdbcUtil = new JDBCUtil(); // ClubDAOImpl ��ü ���� �� JDBC ��ü ����
	}
	
	@Override
	public List<ClubDTO> getClubList() { // ���� ���
		// TODO Auto-generated method stub
		String allQuery = query + "FROM CLUB ORDER BY CLUBID";
		
		// JDBCUtil�� query ����
		jdbcUtil.setSql(allQuery);
		try {
			ResultSet rs = jdbcUtil.executeQuery(); // query�� ����
			List<ClubDTO> list = new ArrayList<ClubDTO>(); // DTO ��ü ��� ���� ����Ʈ ����
			
			while (rs.next()) {
				ClubDTO dto = new ClubDTO(); // ClubDTO ��ü ���� �� �˻� ��� ����
				dto.setClubId(rs.getInt("CLUBID"));
				dto.setSignUp(rs.getString("SIGNUP"));
				dto.setOpenCycle(rs.getString("OPENCYCLE"));
				dto.setOpenCycle(rs.getString("CLUBINTRO"));
				dto.setOpenCycle(rs.getString("CLUBNAME"));
				dto.setOpenCycle(rs.getString("CLUBMASTER"));
				
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
	public ClubDTO getClubById(int clubId) { // ���� id�� ���� ���� ������
		// TODO Auto-generated method stub
		String searchQuery = query + "FROM CLUB WHERE CLUBID = ?";
		
		jdbcUtil.setSql(searchQuery);				// JDBCUtil �� query �� ����
		Object[] param = new Object[] {clubId};		// ������ ã�� ���� �������� id ����
		jdbcUtil.setParameters(param);				// JDBCUtil �� query ���� �Ű����� ������ ����� �Ű����� ����
		
		try {
			ResultSet rs = jdbcUtil.executeQuery(); // query�� ����
			ClubDTO club = null;
			
			if (rs.next()) {
				club = new ClubDTO(); // clubDTO ��ü�� �����Ͽ� ���� ���� ����
				club.setClubId(rs.getInt("CLUBID"));
				club.setSignUp(rs.getString("SIGNUP"));
				club.setOpenCycle(rs.getString("OPENCYCLE"));
				club.setOpenCycle(rs.getString("CLUBINTRO"));
				club.setOpenCycle(rs.getString("CLUBNAME"));
				club.setOpenCycle(rs.getString("CLUBMASTER"));
			}
			return club; // ���� ������ ��� �ִ� ClubDTO ��ü ��ȯ
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close(); // ResultSet, PreparedStatement, Connection ��ȯ
		}
		
		return null;
	}

	@Override
	public List<ClubDTO> getClubByName(String clubName) { // ���� �̸����� ���� �˻�
		// TODO Auto-generated method stub
		String searchQuery = query + "FROM CLUB WHERE CLUBNAME = ?";
		
		jdbcUtil.setSql(searchQuery);	// JDBCUtil �� query �� ����
		Object[] param = new Object[] {clubName}; // ������ ã�� ���� �������� �̸��� ����
		jdbcUtil.setParameters(param); // JDBCUtil �� query ���� �Ű����� ������ ����� �Ű����� ����
		
		try {
			ResultSet rs = jdbcUtil.executeQuery(); // query�� ����
			List<ClubDTO> list = new ArrayList<ClubDTO>();
			
			while (rs.next()) {
				ClubDTO dto = new ClubDTO(); // ClubDTO ��ü ���� �� �˻� ��� ����
				dto.setClubId(rs.getInt("CLUBID"));
				dto.setSignUp(rs.getString("SIGNUP"));
				dto.setOpenCycle(rs.getString("OPENCYCLE"));
				dto.setOpenCycle(rs.getString("CLUBINTRO"));
				dto.setOpenCycle(rs.getString("CLUBNAME"));
				dto.setOpenCycle(rs.getString("CLUBMASTER"));
				
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
	public int insertClub(ClubDTO club) { // ���� �߰� (����)
		// TODO Auto-generated method stub
		
		return 0;
	}

	@Override
	public int deleteClub(int clubId) { // ���� ����
		// TODO Auto-generated method stub
		return 0;
	}

}
