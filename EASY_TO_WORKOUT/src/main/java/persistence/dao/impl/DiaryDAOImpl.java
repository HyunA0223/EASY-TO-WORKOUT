package persistence.dao.impl;

import java.util.List;
import java.util.ArrayList;
import java.sql.*;
import persistence.dao.*;
import persistence.util.*;
import service.dto.*;

public class DiaryDAOImpl implements DiaryDAO {

	private JDBCUtil jdbcUtil = null;
	
	public DiaryDAOImpl() {
		jdbcUtil = new JDBCUtil();
	}
	
	@Override
	public List<DiaryDTO> getAllDiaryList() {
		String allDiaryQuery = "SELECT * FROM diary WHERE private=0";
		jdbcUtil.setSqlAndParameters(allDiaryQuery, null);
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			List<DiaryDTO> list = new ArrayList<DiaryDTO>();
			
			while (rs.next()) {
				DiaryDTO dto = new DiaryDTO();
				dto.setDiaryId(rs.getInt("diaryId"));
				dto.setTitle(rs.getString("title"));
				dto.setDate(rs.getTimestamp("diaryDate"));
				dto.setWorkTime(rs.getInt("workTime"));
				dto.setContents(rs.getString("contents"));
				dto.setIsPrivate(rs.getInt("private"));
				dto.setAuthor(rs.getString("author"));
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}

	@Override
	public List<DiaryDTO> getMyDiaryList(String memberId) {
		String myDiaryQuery = "SELECT * FROM diary WHERE author=?";
		jdbcUtil.setSqlAndParameters(myDiaryQuery, new Object[] {memberId});
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			List<DiaryDTO> list = new ArrayList<DiaryDTO>();
			
			while (rs.next()) {
				DiaryDTO dto = new DiaryDTO();
				dto.setDiaryId(rs.getInt("diaryId"));
				dto.setTitle(rs.getString("title"));
				dto.setDate(rs.getTimestamp("diaryDate"));
				dto.setWorkTime(rs.getInt("workTime"));
				dto.setContents(rs.getString("contents"));
				dto.setIsPrivate(rs.getInt("private"));
				dto.setAuthor(rs.getString("author"));
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}

	@Override
	public DiaryDTO getDiaryById(String id) {
		String searchQuery = "SELECT * FROM diary WHERE diaryId=?";
		jdbcUtil.setSqlAndParameters(searchQuery, new Object[] {id});
		DiaryDTO dto = null;
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			if (rs.next()) {
				dto = new DiaryDTO();
				dto.setDiaryId(rs.getInt("diaryId"));
				dto.setTitle(rs.getString("title"));
				dto.setDate(rs.getTimestamp("diaryDate"));
				dto.setWorkTime(rs.getInt("workTime"));
				dto.setContents(rs.getString("contents"));
				dto.setIsPrivate(rs.getInt("private"));
				dto.setAuthor(rs.getString("author"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return dto;
	}

	@Override
	public int insertDairy(DiaryDTO diary) {
		int result = 0;
		String insertQuery = "INSERT INTO "
				+ "diary (diaryId, title, diaryDate, workTime, contents, private, author) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
		jdbcUtil.setSqlAndParameters(insertQuery, 
				new Object[] {diary.getDiaryId(), diary.getTitle(), 
						diary.getDate(), diary.getWorkTime(), 
						diary.getContents(), diary.getIsPrivate(), 
						diary.getAuthor()});
		try {
			result = jdbcUtil.executeUpdate();
		} catch (Exception e) {
			jdbcUtil.rollback();
			e.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}
		return result;
	}

	@Override
	public int updateDiary(DiaryDTO diary) {
		int result = 0;
		String updateQuery = "UPDATE diary "
				+ "SET title=?, diaryDate=?, workTime=?, contents=?, private=?, author=? "
				+ "WHERE diaryId=?";
		jdbcUtil.setSqlAndParameters(updateQuery, 
				new Object[] {diary.getTitle(), diary.getDate(), 
						diary.getWorkTime(), diary.getContents(), 
						diary.getIsPrivate(), diary.getAuthor(), 
						diary.getDiaryId()});
		try {
			result = jdbcUtil.executeUpdate();
		} catch (Exception e) {
			jdbcUtil.rollback();
			e.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}
		return result;
	}

	@Override
	public int deleteDiary(String id) {
		int result = 0;
		String deleteQuery = "DELETE FROM diary WHERE diaryId=?";
		jdbcUtil.setSqlAndParameters(deleteQuery, new Object[] {id});
		try {
			result = jdbcUtil.executeUpdate();
		} catch (Exception e) {
			jdbcUtil.rollback();
			e.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}
		return result;
	}
	
}
