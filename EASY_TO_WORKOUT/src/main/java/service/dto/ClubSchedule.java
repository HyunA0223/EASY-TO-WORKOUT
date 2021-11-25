package service.dto;

public class ClubSchedule {
	private int scheduleId = 0; // ������ id(PK)
	private int clubId = 0; // ���� id (PK)
	private String contactAddress = null; // ���� �ּ�
	private String notice = null; // ������ �˸�
	private String creationDate = null; // ������ ��¥
	
	public int getScheduleId() { return scheduleId;	}
	public void setScheduleId(int scheduleId) { this.scheduleId = scheduleId; }
	
	public int getClubId() { return clubId;	}
	public void setClubId(int clubId) {	this.clubId = clubId;	}
	
	public String getContactAddress() {	return contactAddress;	}
	public void setContactAddress(String contactAddress) { this.contactAddress = contactAddress; }
	
	public String getNotice() {	return notice;	}
	public void setNotice(String notice) {	this.notice = notice; }
	
	public String getCreationDate() { return creationDate; }
	public void setCreationDate(String creationDate) {	this.creationDate = creationDate; }
	
}
