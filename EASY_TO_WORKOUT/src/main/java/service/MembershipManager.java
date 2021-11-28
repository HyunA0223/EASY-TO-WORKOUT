package service;

import java.sql.SQLException;
import java.util.List;

import persistence.DAOFactory;
import persistence.dao.MembershipDAO;
import service.dto.Membership;
import service.exception.AlreadyInClubException;

public class MembershipManager {
	
	private static MembershipManager membershipManager = new MembershipManager();
	private MembershipDAO membershipDao;
	
	private MembershipManager() {
		DAOFactory factory = new DAOFactory();
		membershipDao = factory.getMembershipDAO();
	}
	
	public static MembershipManager getInstance() {return membershipManager;}
	
	public List<Membership> getClubListByMemberId(String memberId) {
		return membershipDao.getClubListByMemberId(memberId);
	}
	
	public int insertMembership(Membership membership) throws SQLException, AlreadyInClubException {
		// �̹� ���ԵǾ� ������ exception �߻�
		if (isInClub(membership.getClubId(), membership.getMemberId())) {
			throw new AlreadyInClubException("�̹� �ش� ���ӿ� ���ԵǾ� �ֽ��ϴ�.");
		}
		
		return membershipDao.insertMembership(membership);
	}
	
	public int deleteMembership(int clubId, String memberId) {
		return membershipDao.deleteMembership(clubId, memberId);
	}
	
	public boolean isInClub(int clubId, String memberId) {
		return membershipDao.isInClub(clubId, memberId);
	}
}
