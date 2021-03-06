package controller.member;

import java.util.List;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import service.MemberManager;
import service.dto.Member;
import service.ClubManager;
import service.dto.Club;
import service.MembershipManager;
import service.dto.Membership;

public class MemberSessionUtils {

	public static final String MEMBER_SESSION_KEY = "id";
	
    public static String getLoginMemberId(HttpSession session) {
        String id = (String)session.getAttribute(MEMBER_SESSION_KEY);
        return id;
    }

    public static boolean hasLogined(HttpSession session) {
        if (getLoginMemberId(session) != null) {
            return true;
        }
        return false;
    }

    public static boolean isLoginUser(String id, HttpSession session) {
        String loginMember = getLoginMemberId(session);
        if (loginMember == null) {
            return false;
        }
        return loginMember.equals(id);
    }
    
    public static void setLoginUserInfo(HttpSession session, HttpServletRequest request) {
    	MemberManager memberManager = MemberManager.getInstance();
    	MembershipManager membershipManager = MembershipManager.getInstance();
    	ClubManager clubManager = ClubManager.getInstance();
    	
    	try {
    		Member loginMember = memberManager.findMember(getLoginMemberId(session));
    		request.setAttribute("loginMember", loginMember);
    		
    		if (loginMember.getGrade().equals("master")) {
    			request.setAttribute("infoIsMaster", true);
    		}
    		
    		List<Membership> membershipList = membershipManager.getClubListByMemberId(loginMember.getId());
    		if (membershipList != null) {
    			List<Club> myClubList = new ArrayList<Club>();
    			List<Club> masterClubList = new ArrayList<Club>();
    			for (Membership membership : membershipList) {
    				Club club = clubManager.getClubById(membership.getClubId());
    				if (club.getClubMaster().equals(loginMember.getId())) {
    					masterClubList.add(club);
    				}
    				else {
						myClubList.add(club);
    				}
    			}
    			request.setAttribute("myClubList", myClubList);
    			request.setAttribute("masterClubList", masterClubList);
    		}
    		
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
	
}
