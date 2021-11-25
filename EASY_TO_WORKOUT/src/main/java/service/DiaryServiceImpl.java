package service;

import java.util.List;

import persistence.dao.DiaryDAO;

import java.sql.SQLException;

import service.dto.Diary;
import service.exception.DiaryNotFoundException;

public class DiaryServiceImpl {

	private static DiaryServiceImpl diaryService = new DiaryServiceImpl();
	private DiaryDAO diaryDAO;
	
	private DiaryServiceImpl() {
		try {
			diaryDAO = new DiaryDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static DiaryServiceImpl getInstance() {
		return diaryService;
	}

	public int create(Diary diary) throws SQLException {
		return diaryDAO.insertDiary(diary);
	}
	
	public List<Diary> findMyDiaryList(String id) throws SQLException {
		return diaryDAO.getMyDiaryList(id);
	}
	
	public List<Diary> findAllDiaryList() throws SQLException {
		return diaryDAO.getAllDiaryList();
	}
	
	public List<Diary> getSortedAllDiary(String sortType) throws SQLException {
		return diaryDAO.getSortedAllDiary(sortType);
	}
	
	public List<Diary> getSortedMyDiary(String id, String sortType) throws SQLException {
		return diaryDAO.getSortedMyDiary(id, sortType);
	}
	
	public List<Diary> getMyDiaryByTitle(String id, String title) throws DiaryNotFoundException, SQLException {
		if (title.equals("")) {
			throw new DiaryNotFoundException("������ �ٽ� �Է��ϼ���.");
		} else if (!existingMyDiary(id, title)) {
			throw new DiaryNotFoundException("�ش� ���̾�� �������� �ʽ��ϴ�.");
		}
		return diaryDAO.getMyDiaryByTitle(id, title);
	}
	
	public List<Diary> getAllDiaryByTitle(String title) throws DiaryNotFoundException, SQLException {
		if (title.equals("")) {
			throw new DiaryNotFoundException("������ �ٽ� �Է��ϼ���.");
		} else if (!existingAllDiary(title)) {
			throw new DiaryNotFoundException("�ش� ���̾�� �������� �ʽ��ϴ�.");
		}
		return diaryDAO.getAllDiaryByTitle(title);
	}
	
	public boolean existingMyDiary(String id, String title) throws SQLException {
		return diaryDAO.existingMyDiary(id, title);
	}

	public boolean existingAllDiary(String title) throws SQLException {
		return diaryDAO.existingAllDiary(title);
	}
	
}
