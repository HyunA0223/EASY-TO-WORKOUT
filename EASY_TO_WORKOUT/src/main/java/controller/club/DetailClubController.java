package controller.club;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import controller.member.MemberSessionUtils;
import service.ClubManager;
import service.MembershipManager;
import service.dto.Club;

public class DetailClubController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(DetailClubController.class);
	
	@Override 
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		if (!MemberSessionUtils.hasLogined(session)) {
			return "redirect:/login";
		}
		
		String memberId = MemberSessionUtils.getLoginMemberId(session);
		
		ClubManager clubManager = ClubManager.getInstance();
		MembershipManager membershipManager = MembershipManager.getInstance();
		
		log.debug("detail club : {}", request.getParameter("clubId"));
		
		int clubId = Integer.parseInt(request.getParameter("clubId"));
		Club club = clubManager.getClubById(clubId);
		request.setAttribute("club", club);
		
		if (request.getParameter("thisIsForDel") != null) {		// ���� ����
			log.debug("delete club : {}", clubId);
			clubManager.deleteClub(clubId);
			
			return "redirect:/club/list";
		}
		
		if (request.getParameter("thisIsForOut") != null) {		// ���� Ż��
			log.debug("leave club : {}", clubId);
			membershipManager.deleteMembership(clubId, memberId);
			
			return "redirect:/club/list";
		}
		
		if (memberId.equals(club.getClubMaster())) {					// ���� ������ �Ǻ�
			request.setAttribute("isMaster", "1");
		} else 
			request.setAttribute("isMaster", "0");
		
		if (membershipManager.isInClub(clubId, memberId)) {			// �ش� ���ӿ� ���ϴ� �� �Ǻ� 
			request.setAttribute("isInClub", "1");
		} else 
			request.setAttribute("isInClub", "0");
		
		return "/club/club_detail.jsp";
	}

}
