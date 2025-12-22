package LearningSystem.LS.model;

import LearningSystem.LS.enums.SubjectareaNames;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class SubjectArea { 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int subjectId;

	  @Enumerated(EnumType.STRING)
	    @Column(nullable = false, unique = true)
	private SubjectareaNames subjectareaname;
	
	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public SubjectareaNames getSubjectareaname() {
		return subjectareaname;
	}

	public void setSubjectareaname(SubjectareaNames subjectareaname) {
		this.subjectareaname = subjectareaname;
	}

}
