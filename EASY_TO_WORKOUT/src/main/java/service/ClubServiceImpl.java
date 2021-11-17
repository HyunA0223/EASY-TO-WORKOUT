package service;

import java.sql.SQLException;
import java.util.List;

import persistence.DAOFactory;
import persistence.dao.ClubDAO;
//import persistence.dao.MemberDAO;
import service.dto.ClubDTO;
import service.exception.ExistingClubException;

public class ClubServiceImpl {
	
	private static ClubServiceImpl clubService = new ClubServiceImpl(); 
	private ClubDAO clubDao;
//	private MemberDAO memberDao;
	
	private ClubServiceImpl() {							// DAOFactory Ŭ������ ��ü ����
		DAOFactory factory = new DAOFactory();
		clubDao = factory.getClubDAO();
//		memberDao = factory.getMemberDAO();
	}
	
	public static ClubServiceImpl getInstance() {	return clubService;		}

	public List<ClubDTO> listingClub() throws SQLException {				// ClubDAO�� ���� ���� ���� ��� ȹ��
		// TODO Auto-generated method stub
		return clubDao.getClubList();
	}

	public List<ClubDTO> getClubByName(String clubName) throws ExistingClubException, SQLException { // ClubDAO�� ���� �̸��� �ش��ϴ� ���� ���� ��� ȹ��
		// TODO Auto-generated method stub
		if (clubName.equals("")) {
			throw new ExistingClubException("���� �̸��� �ٽ� �Է��ϼ���.");
		}
		else if (!existingClub(clubName)) {
			throw new ExistingClubException("�ش� ������ �������� �ʽ��ϴ�.");
		}
		return clubDao.getClubByName(clubName);
	}

	public ClubDTO getClubById(int clubId) {			// ClubDAO�� ���� ���̵� �ش��ϴ� ���� ���� ȹ��
		// TODO Auto-generated method stub
		return clubDao.getClubById(clubId);
	}

	public List<ClubDTO> getSortedClub(String sortWith) { // ClubDAO�� ���� ���� ���� (ȸ����, ��������)
		return clubDao.getSortedClub(sortWith);
	}
	
	public boolean existingClub(String clubName) throws SQLException {
		return clubDao.existingClub(clubName);
	}
	
	public int insertClub(ClubDTO club) throws ExistingClubException, SQLException {				// ClubDAO�� ���� ���� ���� �߰�
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
