package service;

import java.sql.SQLException;
import java.util.List;

import persistence.DAOFactory;
import persistence.dao.ClubDAO;
//import persistence.dao.MemberDAO;
import service.dto.Club;
import service.exception.ExistingClubException;

public class ClubManager {
	
	private static ClubManager clubService = new ClubManager(); 
	private ClubDAO clubDao;
//	private MemberDAO memberDao;
	
	private ClubManager() {							// DAOFactory Ŭ������ ��ü ����
		DAOFactory factory = new DAOFactory();
		clubDao = factory.getClubDAO();
//		memberDao = factory.getMemberDAO();
	}
	
	public static ClubManager getInstance() {	return clubService;		}

	public List<Club> listingClub() throws SQLException {				// ClubDAO�� ���� ���� ���� ��� ȹ��
		// TODO Auto-generated method stub
		return clubDao.getClubList();
	}

	public List<Club> getClubByName(String clubName) throws ExistingClubException, SQLException { // ClubDAO�� ���� �̸��� �ش��ϴ� ���� ���� ��� ȹ��
		// TODO Auto-generated method stub
		if (clubName.equals("")) {
			throw new ExistingClubException("���� �̸��� �ٽ� �Է��ϼ���.");
		}
		else if (!existingClub(clubName)) {
			throw new ExistingClubException("�ش� ������ �������� �ʽ��ϴ�.");
		}
		return clubDao.getClubByName(clubName);
	}

	public Club getClubById(int clubId) {			// ClubDAO�� ���� ���̵� �ش��ϴ� ���� ���� ȹ��
		// TODO Auto-generated method stub
		return clubDao.getClubById(clubId);
	}

	public List<Club> getSortedClub(String sortWith) { // ClubDAO�� ���� ���� ���� (ȸ����, ��������)
		return clubDao.getSortedClub(sortWith);
	}
	
	public boolean existingClub(String clubName) throws SQLException {
		return clubDao.existingClub(clubName);
	}
	
	public int insertClub(Club club) throws ExistingClubException, SQLException {				// ClubDAO�� ���� ���� ���� �߰�
		// TODO Auto-generated method stub
		
/*		if (!memberDao.isMaster(club.getMasterId())) {	// clubMaster�� ������ ����� �ƴ� ��� ���� �߻�
			throw new ExistingClubException("������ ����� �ƴմϴ�.");
		}
		else if (!memberDao.existingUser(masterId)) {	// clubMaster�� �������� �ʴ� ���̵��� ��� ���� �߻�
			throw new ExistingClubException("�������� �ʴ� ȸ�� ���̵��Դϴ�.");
		}*/
		
		return clubDao.insertClub(club);
	}

	public int deleteClub(int clubId) {					// ClubDAO�� ���� ���� ���� ����
		// TODO Auto-generated method stub
		return clubDao.deleteClub(clubId);
	}
	
	
}
