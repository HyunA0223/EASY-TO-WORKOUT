package controller.member;

import javax.servlet.http.HttpSession;

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
	
}
