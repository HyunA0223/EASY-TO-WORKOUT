package service.dto;

public class Club {
	
	private int clubId = 0; // ���� id (PK)
	private String signUp = null; // ���� ��� (0-�ʴ밡��/1-��������)
	private String openCycle = null; // ���� �ֱ� (0-������/1-�Ͻ���)
	private String clubIntro = null; // ���� �Ұ�
	private String clubName = null; // ���� �̸�
	private String clubMaster = null; // ���� ����
	private int countClub = 0; // ȸ�� ��
	
	public int getClubId() { return clubId; }
	public void setClubId(int clubId) { this.clubId = clubId; }
	
	public String getSignUp() { return signUp; }
	public void setSignUp(String signUp) { this.signUp = signUp; }
	
	public String getOpenCycle() { return openCycle; }
	public void setOpenCycle(String openCycle) { this.openCycle = openCycle; }
	
	public String getClubIntro() { return clubIntro; }
	public void setClubIntro(String clubIntro) { this.clubIntro = clubIntro; }
	
	public String getClubName() { return clubName; }
	public void setClubName(String clubName) { this.clubName = clubName; }
	
	public String getClubMaster() { return clubMaster; }
	public void setClubMaster(String clubMaster) { this.clubMaster = clubMaster; }
	
	public int getCountClub() {	return countClub;	}
	public void setCountClub(int countClub) {	this.countClub = countClub;	}
	
}
 