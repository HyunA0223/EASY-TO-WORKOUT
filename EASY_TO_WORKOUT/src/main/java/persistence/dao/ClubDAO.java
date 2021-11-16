package persistence.dao;

import java.sql.SQLException;
import java.util.List;
import service.dto.ClubDTO;
import service.exception.ExistingClubException;

public interface ClubDAO {
	
	public List<ClubDTO> getClubList() throws SQLException; // ���� ���
	public ClubDTO getClubById(int clubId);
	public List<ClubDTO> getClubByName(String clubName) throws ExistingClubException, SQLException; // �̸����� ���� �˻�(���� ���� ����)
	public List<ClubDTO> getSortedClub(String sortWith); // ���� ���� (ȸ����, ��������)
	public boolean existingClub(String clubName) throws SQLException;
	public int insertClub(ClubDTO club) throws SQLException; 
	public int deleteClub(int clubId);
	
}
