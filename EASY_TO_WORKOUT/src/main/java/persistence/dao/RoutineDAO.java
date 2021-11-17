package persistence.dao;

import java.util.List;
import service.dto.RoutineDTO;

public interface RoutineDAO {

	public List<RoutineDTO> getRoutineList();	//��ƾ����Ʈ ��ȯ
	public List<RoutineDTO> getRoutineListByPublic();	//�ۺ���ƾ����Ʈ ��ȯ
	public List<RoutineDTO> getRoutineListByPersonal();	//�۽��η�ƾ����Ʈ ��ȯ
	public int insertRoutine(RoutineDTO routine);	//��ƾ������ �߰�
	public int updateRoutine(RoutineDTO routine);	//��ƾ������ ����
	public int deleteRoutine(int routineId);	//��ƾ������ ����
	public RoutineDTO getRoutineByName(String rName);	//��ƾ������ ��ƾ������ ã��
	public boolean existingRoutine(String rName);
}
