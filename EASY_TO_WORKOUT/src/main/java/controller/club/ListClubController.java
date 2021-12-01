package controller.club;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import controller.Controller;
import controller.member.MemberSessionUtils;
import service.ClubManager;
import service.dto.Club;

public class ListClubController implements Controller {
	
	//private static final Logger log = LoggerFactory.getLogger(ListClubController.class);
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		if (!MemberSessionUtils.hasLogined(session)) {
			return "redirect:/login";
		}
		
		MemberSessionUtils.setLoginUserInfo(session, request);
		request.setAttribute("btnType", "clubCreate");
		
		ClubManager manager = ClubManager.getInstance();
		
		if (request.getMethod().equals("GET")) {
			List<Club> clubList = manager.listingClub();
			request.setAttribute("clubList",  clubList);
			
			return "/club/clubPage.jsp";
		}
		
		//log.debug("sort club : {}", request.getParameter("sortClub"));
		
		/* ���� ��� ���� */
		if (request.getParameter("sortClub").equals("0")) {
			List<Club> clubList = manager.listingClub();
			request.setAttribute("clubList",  clubList);
		}
		else if (request.getParameter("sortClub").equals("1")) { // �̸���
			request.setAttribute("checkedOne", true);
			
			List<Club> clubList = manager.getSortedClub("clubName");
			request.setAttribute("clubList",  clubList);
		}
		else if (request.getParameter("sortClub").equals("2")) { // ȸ����
			request.setAttribute("checkedTwo", true);
			
			List<Club> clubList = manager.getSortedClub("countMember");
			request.setAttribute("clubList",  clubList);
		}
		else if (request.getParameter("sortClub").equals("3")) { // �������Ը�
			request.setAttribute("checkedThree", true);
			
			List<Club> clubList = manager.getSortedClub("freeSignUp");
			request.setAttribute("clubList",  clubList);
		}
		
		return "/club/clubPage.jsp";
	}

}
