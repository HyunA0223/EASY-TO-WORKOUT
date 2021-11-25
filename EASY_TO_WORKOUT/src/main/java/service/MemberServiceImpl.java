package service;

import java.sql.SQLException;

import persistence.dao.MemberDAOImpl;
import service.dto.MemberDTO;
import service.exception.MemberNotFoundException;
import service.exception.PasswordMismatchException;

public class MemberServiceImpl {

	private static MemberServiceImpl memberService = new MemberServiceImpl();
	private MemberDAOImpl memberDAO;
	
	private MemberServiceImpl() {
		try {
			memberDAO = new MemberDAOImpl();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static MemberServiceImpl getInstance() {
		return memberService;
	}
	
	public MemberDTO findMember(String id)
		throws SQLException, MemberNotFoundException {
		MemberDTO member = memberDAO.getMemberById(id);
		
		if (member == null) {
			throw new MemberNotFoundException(id + "�� �������� �ʴ� ���̵��Դϴ�.");
		}
		return member;
	}
	
	public boolean login(String id, String pw)
		throws SQLException, MemberNotFoundException, PasswordMismatchException {
		MemberDTO member = findMember(id);
		
		if (!member.matchPassword(pw)) {
			throw new PasswordMismatchException("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
		}
		return true;
	}
	
}
