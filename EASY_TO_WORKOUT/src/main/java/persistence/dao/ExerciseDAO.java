package persistence.dao;

import java.util.List;
import service.dto.ExerciseDTO;

public interface ExerciseDAO {

	public List<ExerciseDTO> getExerciseList();	//�����Ʈ ��ȯ
	public ExerciseDTO getExerciseByName(String name);	//������� ������� ã��
}
