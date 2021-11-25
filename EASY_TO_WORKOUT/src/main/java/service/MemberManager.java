package service;

import java.sql.SQLException;

import persistence.dao.MemberDAO;
import service.dto.Member;
import service.exception.MemberNotFoundException;
import service.exception.PasswordMismatchException;

public class MemberManager {

	private static MemberManager memberService = new MemberManager();
	private MemberDAO memberDAO;
	
	private MemberManager() {
		try {
			memberDAO = new MemberDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static MemberManager getInstance() {
		return memberService;
	}
	
	public Member findMember(String id)
		throws SQLException, MemberNotFoundException {
		Member member = memberDAO.getMemberById(id);
		
		if (member == null) {
			throw new MemberNotFoundException(id + "�� �������� �ʴ� ���̵��Դϴ�.");
		}
		return member;
	}
	
	public boolean login(String id, String pw)
		throws SQLException, MemberNotFoundException, PasswordMismatchException {
		Member member = findMember(id);
		
		if (!member.matchPassword(pw)) {
			throw new PasswordMismatchException("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
		}
		return true;
	}
	
}
