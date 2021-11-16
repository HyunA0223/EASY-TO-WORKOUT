package controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import service.MemberServiceImpl;

public class LoginController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	String id = request.getParameter("loginId");
		String pw = request.getParameter("loginPw");
		
		try {
			// �𵨿� �α��� ó���� ����
			MemberServiceImpl manager = MemberServiceImpl.getInstance();
			manager.login(id, pw);
	
			// ���ǿ� ����� ���̵� ����
			HttpSession session = request.getSession();
            session.setAttribute(MemberSessionUtils.MEMBER_SESSION_KEY, id);
            
            return "redirect:/main";			
		} catch (Exception e) {
			/* UserNotFoundException�̳� PasswordMismatchException �߻� ��
			 * �ٽ� login form�� ����ڿ��� �����ϰ� ���� �޼����� ���
			 */
			
//			redirect parameter ���� ��� ã��
//            request.setAttribute("loginFailed", true);
//			request.setAttribute("exception", e);
            return "redirect:/login";
		}
	}

}
