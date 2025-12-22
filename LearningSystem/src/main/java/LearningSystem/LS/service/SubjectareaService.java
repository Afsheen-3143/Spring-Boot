package LearningSystem.LS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import LearningSystem.LS.exception.DuplicateValueException;
import LearningSystem.LS.exception.InvalidEnumValueException;
import LearningSystem.LS.exception.ResourceNotFoundException;
import LearningSystem.LS.model.SubjectArea;
import LearningSystem.LS.repository.SubjectareaRepo;

@Service
public class SubjectareaService {
	
	@Autowired
	private SubjectareaRepo subjectrepo;
	
	  public SubjectArea addsubjectarea(SubjectArea subjectarea) {

	        if (subjectarea.getSubjectareaname() == null) {
	            throw new InvalidEnumValueException("SubjectArea name cannot be null");
	        }

	        try {
	            return subjectrepo.save(subjectarea);
	        } catch (DataIntegrityViolationException ex) {
	            throw new DuplicateValueException(
	                "SubjectArea with " + subjectarea.getSubjectareaname() + " already exists"
	            );
	        }
	    }     
    // UPDATE SUBJECT AREA
    public SubjectArea updateSubject(int id, SubjectArea subject) {

        SubjectArea existing = subjectrepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "SubjectArea not found with id " + id));

        existing.setSubjectareaname(subject.getSubjectareaname());
        return subjectrepo.save(existing);
    }

    // GET SUBJECT BY ID
    public SubjectArea getSubject(int id) {
        return subjectrepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "SubjectArea not found with id " + id));
    }

    // GET ALL SUBJECTS
    public List<SubjectArea> getAllSubjects() {
        return subjectrepo.findAllByOrderBySubjectIdAsc();
    }

    // DELETE SUBJECT 
    public void deleteSubject(int id) {
        SubjectArea subject = getSubject(id);
        subjectrepo.delete(subject);
    }

//    delete all subjects
    public void deleteAllsubjects() {
    	subjectrepo.deleteAll();
    }

}
