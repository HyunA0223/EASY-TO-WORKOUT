package service;

import java.util.List;

import persistence.dao.DiaryDAO;

import java.sql.SQLException;

import service.dto.Diary;
import service.exception.DiaryNotFoundException;

public class DiaryManager {

	private static DiaryManager diaryService = new DiaryManager();
	private DiaryDAO diaryDAO;
	
	private DiaryManager() {
		try {
			diaryDAO = new DiaryDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static DiaryManager getInstance() {
		return diaryService;
	}

	public int create(Diary diary) throws SQLException {
		return diaryDAO.insertDiary(diary);
	}
	
	public int update(Diary diary) throws SQLException {
		return diaryDAO.updateDiary(diary);
	}
	
	public int delete(int id) throws SQLException {
		return diaryDAO.deleteDiary(id);
	}
	
	public Diary getDiaryById(int id)
			throws SQLException, DiaryNotFoundException {
		Diary diary = diaryDAO.getDiaryById(id);
		
		if (diary == null) {
			throw new DiaryNotFoundException(id + "는 존재하지 않는 아이디입니다.");
		}
		return diary;
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
			throw new DiaryNotFoundException("제목을 다시 입력하세요.");
		} else if (!existingMyDiary(id, title)) {
			throw new DiaryNotFoundException("해당 다이어리가 존재하지 않습니다.");
		}
		return diaryDAO.getMyDiaryByTitle(id, title);
	}
	
	public List<Diary> getAllDiaryByTitle(String title) throws DiaryNotFoundException, SQLException {
		if (title.equals("")) {
			throw new DiaryNotFoundException("제목을 다시 입력하세요.");
		} else if (!existingAllDiary(title)) {
			throw new DiaryNotFoundException("해당 다이어리가 존재하지 않습니다.");
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
