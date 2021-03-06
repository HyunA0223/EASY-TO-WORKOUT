package persistence;

import persistence.dao.*;

public class DAOFactory {
	
	public ChoiceDAO getChoiceDAO() {
		return new ChoiceDAO();
	}
	
	public ClubDAO getClubDAO() {
		return new ClubDAO();
	}
	
	public ClubScheduleDAO getClubScheduleDAO() {
		return new ClubScheduleDAO();
	}
	
	public DiaryDAO getDiaryDAO() {
		return new DiaryDAO();
	}
	
	public ExerciseDAO getExerciseDAO() {
		return new ExerciseDAO();
	}
	
	public MemberDAO getMemberDAO() {
		return new MemberDAO();
	}
	
	public MembershipDAO getMembershipDAO() {
		return new MembershipDAO();
	}
	
	public RoutineDAO getRoutineDAO() {
		return new RoutineDAO();
	}
	
	public UsageDAO getUsageDAO() {
		return new UsageDAO();
	}
}
