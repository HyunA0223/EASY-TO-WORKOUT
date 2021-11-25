package controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import service.MemberManager;

public class LoginController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	String id = request.getParameter("loginId");
		String pw = request.getParameter("loginPw");
		
		try {
			// �𵨿� �α��� ó���� ����
			MemberManager manager = MemberManager.getInstance();
			manager.login(id, pw);
	
			// ���ǿ� ����� ���̵� ����
			HttpSession session = request.getSession();
            session.setAttribute(MemberSessionUtils.MEMBER_SESSION_KEY, id);
            
            return "redirect:/main";			
		} catch (Exception e) {
			/* UserNotFoundException�̳� PasswordMismatchException �߻� ��
			 * �ٽ� login form�� ����ڿ��� �����ϰ� ���� �޼����� ���
			 */
			
            request.setAttribute("loginFailed", true);
			request.setAttribute("exception", e);
            return "/member/memberLogin.jsp";
		}
	}

}
