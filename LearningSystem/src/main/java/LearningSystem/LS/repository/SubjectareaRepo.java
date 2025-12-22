package LearningSystem.LS.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import LearningSystem.LS.enums.SubjectareaNames;
import LearningSystem.LS.model.SubjectArea;

public interface SubjectareaRepo extends JpaRepository<SubjectArea,Integer>{
	  List<SubjectArea> findAllByOrderBySubjectIdAsc();
	
}