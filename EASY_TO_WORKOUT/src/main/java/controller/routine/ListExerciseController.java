package controller.routine;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import controller.member.MemberSessionUtils;
import service.dto.Exercise;
import service.ExerciseManager;
import service.dto.Member;
import service.dto.Routine;
import service.MemberManager;
import service.RoutineManager;

public class ListExerciseController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		if (!MemberSessionUtils.hasLogined(session)) {
			return "redirect:/login";
		}
		
		MemberSessionUtils.setLoginUserInfo(session, request);
		request.setAttribute("btnType", "routineCreate");
		
		ExerciseManager manager = ExerciseManager.getInstance();
		
		
		String memberId = MemberSessionUtils.getLoginMemberId(session);
			
		MemberManager memberManager = MemberManager.getInstance();
		Member member = memberManager.findMember(memberId);
		request.setAttribute("member", member);
			
		List<Exercise> exerciseList = manager.ListingExercises();
		request.setAttribute("exerciseList", exerciseList);
		
		request.setAttribute("routineName", request.getParameter("routineName"));
		
		String[] parts = request.getParameterValues("routinePart");
		String part = "";
		int num = 0;
	
		if (parts != null) {
			for (int i = 0; i < parts.length; i++) {
				if (parts[i].equals("��ü")) {
					if (num == 0) {
						part += "��ü ";
					}
					else {
						part += ", ��ü ";
					}
					num += 1;
				}
				else if (parts[i].equals("��ü")) {
					if (num == 0) {
						part += "��ü ";
					}
					else {
						part += ", ��ü ";
					}
					num += 1;
				}
				else if (parts[i].equals("����")) {
					if (num == 0) {
						part += "���� ";
					}
					else {
						part += ", ���� ";
					}
					num += 1;
				}
				else if (parts[i].equals("���")) {
					if (num == 0) {
						part += "��� ";
					}
					else {
						part += ", ��� ";
					}
					num += 1;
				}
				else {
					if (num == 0) {
						part += "���� ";
					}
					else {
						part += ", ���� ";
					}
					num += 1;
				}
			}
		}
		request.setAttribute("routinePart", part);
		
		
		request.setAttribute("routineTime", request.getParameter("routineTime"));
		request.setAttribute("routineLevel", request.getParameter("routineLevel"));
		request.setAttribute("routineType", request.getParameter("routineType"));
		
		if (request.getParameter("thisIsForChoice") != null) {
			request.setAttribute("thisIsForChoice", "thisIsForChoice");
		}
		else {
			RoutineManager routineManager = RoutineManager.getInstance();
			int routineId = Integer.parseInt(request.getParameter("routineId"));
			Routine routine = routineManager.getRoutineById(routineId);
			request.setAttribute("routine", routine);
		}
		
		return "/routine/exercise_choiceForm.jsp";
	}

}
